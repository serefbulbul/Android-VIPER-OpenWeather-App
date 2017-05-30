package tr.com.adesso.weatherapp.features.home;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import tr.com.adesso.weatherapp.R;
import tr.com.adesso.weatherapp.features.base.BasePresenter;
import tr.com.adesso.weatherapp.utils.ValidationResult;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

/**
 * Created by batuhan on 18/05/2017.
 */

public class HomePagePresenter extends BasePresenter implements HomePageContract.Presenter {

    private HomePageContract.Interactor interactor;

    private final PublishSubject<String> weatherDataName = PublishSubject.create();
    private final PublishSubject<String> weatherDataTemperature = PublishSubject.create();
    private Observable<ValidationResult> someTextValidation;
    private Observable<Object> onSomeButtonClick;

    public HomePagePresenter(HomePageContract.Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void setInput(Observable<CharSequence> onSomeTextChange, Observable<Object> onSomeButtonClick) {
        someTextValidation = onSomeTextChange.
                map(new Function<CharSequence, ValidationResult>() {
                    @Override
                    public ValidationResult apply(CharSequence someText) throws Exception {

                        if (someText.length() > 0) {
                            return new ValidationResult(true);
                        } else {
                            return new ValidationResult(false, R.string.app_name);
                        }
                    }
                });

        this.onSomeButtonClick = onSomeButtonClick;
    }

    @Override
    public void subscribe() {
        progress.onNext(true);
        compositeDisposable.add(observeLondonData());
        compositeDisposable.add(observeSomeTextValidation());
        compositeDisposable.add(observeOnSomeButtonClick());
    }

    @Override
    public void unsubscribe() {
        compositeDisposable.clear();
    }

    @Override
    public Observable<String> getWeatherDataName() {
        return weatherDataName;
    }

    @Override
    public Observable<String> getWeatherDataTemperature() {
        return weatherDataTemperature;
    }

    private Disposable observeLondonData() {
        return interactor.observeLondonData()
                .subscribe(new Consumer<WeatherData>() {
                    @Override
                    public void accept(WeatherData weatherData) throws Exception {
                        weatherDataName.onNext(weatherData.getName());
                        weatherDataTemperature.onNext(String.valueOf(weatherData.getMain().getTemp()));

                        progress.onNext(false);
                    }
                });
    }

    private Disposable observeSomeTextValidation() {
        return someTextValidation.subscribe(new Consumer<ValidationResult>() {
            @Override
            public void accept(ValidationResult v) throws Exception {
                Log.d("String", v.toString());
            }
        });
    }

    private Disposable observeOnSomeButtonClick() {
        return onSomeButtonClick.subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {

            }
        });
    }
}
