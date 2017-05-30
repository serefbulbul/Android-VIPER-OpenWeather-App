package tr.com.adesso.weatherapp.features.home;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import tr.com.adesso.weatherapp.features.base.BasePresenter;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

/**
 * Created by batuhan on 18/05/2017.
 */

public class HomePagePresenter extends BasePresenter implements HomePageContract.Presenter {

    private HomePageContract.Interactor interactor;

    private PublishSubject<String> weatherDataName = PublishSubject.create();
    private PublishSubject<String> weatherDataTemperature = PublishSubject.create();

    public HomePagePresenter(HomePageContract.Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void subscribe() {
        progress.onNext(true);
        compositeDisposable.add(observeLondonData());
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
}
