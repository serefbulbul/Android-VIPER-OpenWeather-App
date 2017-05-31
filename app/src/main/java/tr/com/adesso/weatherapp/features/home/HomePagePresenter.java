package tr.com.adesso.weatherapp.features.home;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import tr.com.adesso.weatherapp.R;
import tr.com.adesso.weatherapp.features.base.BasePresenter;
import tr.com.adesso.weatherapp.utils.ValidationResult;

/**
 * Created by batuhan on 18/05/2017.
 */

public class HomePagePresenter extends BasePresenter implements HomePageContract.Presenter {

    private HomePageContract.View view;
    private HomePageContract.Interactor interactor;
    private Observable<ValidationResult> someTextValidation;

    public HomePagePresenter(HomePageContract.View view, HomePageContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void subscribe() {
        view.setSomeText("Istanbul");
        observeValidations();

        compositeDisposable.add(observeSomeTextValidation());
        compositeDisposable.add(observeOnSomeButtonClick());

        getLondonData();
    }

    public void unsubscribe() {
        compositeDisposable.clear();
    }

    private void observeValidations() {
        someTextValidation = view.onSomeTextChange()
                .map(charSequence -> {
                    if (charSequence.length() > 0) {
                        return new ValidationResult(true);
                    } else {
                        return new ValidationResult(false, R.string.app_name);
                    }
                });
    }

    private void getLondonData() {
        interactor.getWeatherData("London")
                .doOnNext(presenterModel -> view.showProgressView())
                .subscribe(presenterModel -> {
                    view.setCurrentLocationName(presenterModel.getName());
                    view.setCurrentLocationTemperature(String.valueOf(presenterModel.getTemp()));
                    view.hideProgressView();
                }, throwable -> {

                }, () -> {

                }).dispose();
    }

    private Disposable observeSomeTextValidation() {
        return someTextValidation
                .subscribe(validationResult -> {

                });
    }

    private Disposable observeOnSomeButtonClick() {
        return view.onSomeButtonClick()
                .doOnNext(o -> view.showProgressView())
                .switchMap(o -> interactor.getWeatherData(view.getSomeText()))
                .doOnEach(homePagePresenterModelNotification -> view.hideProgressView())
                .retry()
                .subscribe(presenterModel -> {
                    view.setCurrentLocationName(presenterModel.getName());
                    view.setCurrentLocationTemperature(String.valueOf(presenterModel.getTemp()));
                }, throwable -> {
                    view.showAlert("Error", "Request failed.", "OK", null, null, null);
                    view.hideProgressView();
                }, () -> {

                });
    }
}
