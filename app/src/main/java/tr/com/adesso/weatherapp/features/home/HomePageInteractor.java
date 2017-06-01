package tr.com.adesso.weatherapp.features.home;

import io.reactivex.Observable;
import tr.com.adesso.weatherapp.features.base.BaseInteractor;
import tr.com.adesso.weatherapp.utils.ServiceResult;
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
    public Observable<ServiceResult<HomePagePresenterModel>> getWeatherData(String city) {
        final Observable<WeatherData> london = openWeatherService.getWeatherData(city, "4abf3b21b72f324add11d4445f40f32a", "metric");

        return Observable.create(o -> london.map(weatherData -> new HomePagePresenterModel(weatherData.getName(), weatherData.getMain().getTemp()))
                .subscribe(home -> {
                    o.onNext(new ServiceResult<>(home));
                    o.onComplete();
                }, throwable -> {
                    o.onNext(new ServiceResult<>(throwable));
                    o.onComplete();
                }));
    }
}
