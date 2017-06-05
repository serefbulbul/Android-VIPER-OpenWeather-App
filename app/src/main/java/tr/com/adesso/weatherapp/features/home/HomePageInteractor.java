package tr.com.adesso.weatherapp.features.home;

import io.reactivex.Observable;
import tr.com.adesso.weatherapp.features.base.BaseInteractor;
import tr.com.adesso.weatherapp.utils.Constants;
import tr.com.adesso.weatherapp.utils.ServiceResult;
import tr.com.adesso.weatherapp.utils.services.network.OpenWeatherService;
import tr.com.adesso.weatherapp.utils.services.network.models.WeatherData;
import tr.com.adesso.weatherapp.utils.services.realm.RealmService;
import tr.com.adesso.weatherapp.utils.services.realm.models.Bookmark;

/**
 * Created by batuhan on 23/05/2017.
 */

public class HomePageInteractor extends BaseInteractor implements HomePageContract.Interactor {

    private final OpenWeatherService openWeatherService;
    private final RealmService realmService;

    HomePageInteractor(OpenWeatherService openWeatherService, RealmService realmService) {
        this.openWeatherService = openWeatherService;
        this.realmService = realmService;
    }

    @Override
    public Observable<ServiceResult<WeatherData>> getWeatherData(String city) {
        final Observable<WeatherData> london = openWeatherService.getWeatherData(city, Constants.OPEN_WEATHER_API_KEY, "metric");

        return Observable.create(o ->
                london.subscribe(weatherData -> {
                    o.onNext(new ServiceResult<>(weatherData));
                    o.onComplete();
                }, throwable -> {
                    o.onNext(new ServiceResult<>(throwable));
                    o.onComplete();
                }));
    }

    @Override
    public void createPerson(String name) {
        realmService.createBookmark(name);
    }

    @Override
    public Bookmark getPerson(String name) {
        return realmService.getBookmark(name);
    }
}
