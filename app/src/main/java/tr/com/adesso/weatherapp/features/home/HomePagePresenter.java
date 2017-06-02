package tr.com.adesso.weatherapp.features.home;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import tr.com.adesso.weatherapp.R;
import tr.com.adesso.weatherapp.features.base.BasePresenter;
import tr.com.adesso.weatherapp.utils.Constants;
import tr.com.adesso.weatherapp.utils.ValidationResult;
import tr.com.adesso.weatherapp.utils.services.realm.models.Bookmark;

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
                .subscribe(result -> {
                    if (result.getData() != null) {
                        view.setCurrentLocationName(result.getData().getName());
                        view.setCurrentLocationTemperature(String.valueOf(result.getData().getMain().getTemp()));
                        view.hideProgressView();
                    } else {
                        view.showAlert("ADSError", "Request failed.", "OK", null, null, null);
                    }
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
                .throttleFirst(Constants.THROTTLE_TIME_IN_MILLISECONDS, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .doOnNext(o -> view.showProgressView())
                .flatMap(o -> interactor.getWeatherData(view.getSomeText()))
                .doOnNext(result -> view.hideProgressView())
                .subscribe(result -> {
                    if (result.isSuccess()) {
                        view.setCurrentLocationName(result.getData().getName());
                        view.setCurrentLocationTemperature(String.valueOf(result.getData().getMain().getTemp()));
                        view.startWeatherDetail(result.getData());
                    } else {
                        view.showAlert(String.valueOf(result.getError().getErrorCode()), result.getError().getErrorMessage(), "OK", null, null, null);
                    }

                    interactor.createPerson("asd");

                    Bookmark bookmark = interactor.getPerson("asd");

                    bookmark.getName();
                });
    }
}
