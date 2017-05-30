package tr.com.adesso.weatherapp.features.home;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import tr.com.adesso.weatherapp.features.base.BaseInteractor;
import tr.com.adesso.weatherapp.utils.services.OpenWeatherService;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

/**
 * Created by batuhan on 23/05/2017.
 */

public class HomePageInteractor extends BaseInteractor implements HomePageContract.Interactor {

    private OpenWeatherService openWeatherService;

    private PublishSubject<WeatherData> londonData = PublishSubject.create();

    HomePageInteractor(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    public void requestLondonData() {
        final Observable<WeatherData> london = openWeatherService.getWeatherData("London", "4abf3b21b72f324add11d4445f40f32a","metric");

        london.subscribe(new Consumer<WeatherData>() {
            @Override
            public void accept(WeatherData weatherData) throws Exception {
                londonData.onNext(weatherData);
            }
        });

    }

    @Override
    public Observable<WeatherData> getLondonData() {
        return londonData;
    }
}
