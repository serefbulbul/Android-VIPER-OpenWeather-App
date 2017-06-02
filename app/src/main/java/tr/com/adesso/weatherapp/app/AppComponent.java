package tr.com.adesso.weatherapp.app;

import android.content.Context;

import dagger.Component;
import tr.com.adesso.weatherapp.utils.services.network.NetworkModule;
import tr.com.adesso.weatherapp.utils.services.network.OpenWeatherService;
import tr.com.adesso.weatherapp.utils.services.realm.RealmModule;
import tr.com.adesso.weatherapp.utils.services.realm.RealmService;

/**
 * Created by serefbulbul on 29/05/2017.
 */

@AppScope
@Component(modules = {AppModule.class, NetworkModule.class, RealmModule.class})
public interface AppComponent {

    Context getContext();

    OpenWeatherService networkService();

    RealmService realmService();
}
