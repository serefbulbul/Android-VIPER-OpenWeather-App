package tr.com.adesso.weatherapp.features.home;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import tr.com.adesso.weatherapp.features.base.BaseInteractor;
import tr.com.adesso.weatherapp.utils.services.OpenWeatherService;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

/**
 * Created by batuhan on 23/05/2017.
 */

public class HomePageInteractor extends BaseInteractor implements HomePageContract.Interactor {

    private OpenWeatherService openWeatherService;

    HomePageInteractor(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    @Override
    public Observable<WeatherData> observeLondonData() {
        return Observable.create(new ObservableOnSubscribe<WeatherData>() {
            @Override
            public void subscribe(final ObservableEmitter<WeatherData> e) throws Exception {
                final Observable<WeatherData> london = openWeatherService.getWeatherData("London", "4abf3b21b72f324add11d4445f40f32a","metric");

                london.subscribe(new Consumer<WeatherData>() {
                    @Override
                    public void accept(WeatherData weatherData) throws Exception {
                        e.onNext(weatherData);
                    }
                });
            }
        });
    }
}
