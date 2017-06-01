package tr.com.adesso.weatherapp.features.home;

import io.reactivex.Observable;
import tr.com.adesso.weatherapp.features.base.BaseInteractor;
import tr.com.adesso.weatherapp.utils.ServiceResult;
import tr.com.adesso.weatherapp.utils.services.NetworkService;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;
import tr.com.adesso.weatherapp.utils.services.realm.RealmService;
import tr.com.adesso.weatherapp.utils.services.realm.models.Person;

/**
 * Created by batuhan on 23/05/2017.
 */

public class HomePageInteractor extends BaseInteractor implements HomePageContract.Interactor {

    private final NetworkService networkService;
    private final RealmService realmService;

    HomePageInteractor(NetworkService networkService, RealmService realmService) {
        this.networkService = networkService;
        this.realmService = realmService;
    }

    @Override
    public Observable<ServiceResult<WeatherData>> getWeatherData(String city) {
        final Observable<WeatherData> london = networkService.getWeatherData(city, "4abf3b21b72f324add11d4445f40f32a", "metric");

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
        realmService.createPerson(name);
    }

    @Override
    public Person getPerson(String name) {
        return realmService.getPerson(name);
    }
}
