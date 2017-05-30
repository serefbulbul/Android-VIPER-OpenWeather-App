package tr.com.adesso.weatherapp.features.home;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import tr.com.adesso.weatherapp.R;
import tr.com.adesso.weatherapp.features.base.BasePresenter;
import tr.com.adesso.weatherapp.utils.ValidationResult;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

/**
 * Created by batuhan on 18/05/2017.
 */

public class HomePagePresenter extends BasePresenter implements HomePageContract.Presenter {

    private HomePageContract.View view;
    private HomePageContract.Interactor interactor;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
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
                .map(new Function<CharSequence, ValidationResult>() {
                    @Override
                    public ValidationResult apply(CharSequence charSequence) throws Exception {
                        if (charSequence.length() > 0) {
                            return new ValidationResult(true);
                        } else {
                            return new ValidationResult(false, R.string.app_name);
                        }
                    }
                });
    }

    private void getLondonData() {
        interactor.getWeatherData("London")
                .doOnNext(new Consumer<WeatherData>() {
                    @Override
                    public void accept(WeatherData weatherData) throws Exception {
                        view.showProgressView();
                    }
                })
                .subscribe(new Consumer<WeatherData>() {
                    @Override
                    public void accept(WeatherData weatherData) throws Exception {
                        Log.e("Current Weather", weatherData.getWeather()
                                .get(0)
                                .getDescription());

                        view.setCurrentLocationName(weatherData.getName());
                        view.setCurrentLocationTemperature(String.valueOf(weatherData.getMain().getTemp()));
                        view.hideProgressView();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                }).dispose();
    }

    private Disposable observeSomeTextValidation() {
        return someTextValidation.subscribe(new Consumer<ValidationResult>() {
            @Override
            public void accept(ValidationResult validationResult) throws Exception {

            }
        });
    }

    private Disposable observeOnSomeButtonClick() {
        return view.onSomeButtonClick()
                .doOnNext(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        view.showProgressView();
                    }
                })
                .switchMap(new Function<Object, ObservableSource<WeatherData>>() {
                    @Override
                    public ObservableSource<WeatherData> apply(Object o) throws Exception {
                        return interactor.getWeatherData(view.getSomeText());
                    }
                })
                .subscribe(new Consumer<WeatherData>() {
                    @Override
                    public void accept(WeatherData weatherData) throws Exception {
                        view.setCurrentLocationName(weatherData.getName());
                        view.setCurrentLocationTemperature(String.valueOf(weatherData.getMain().getTemp()));
                        view.hideProgressView();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
