package tr.com.adesso.weatherapp.app;

import android.content.Context;

import dagger.Component;
import tr.com.adesso.weatherapp.utils.services.NetworkModule;
import tr.com.adesso.weatherapp.utils.services.NetworkService;
import tr.com.adesso.weatherapp.utils.services.realm.RealmModule;
import tr.com.adesso.weatherapp.utils.services.realm.RealmService;

/**
 * Created by serefbulbul on 29/05/2017.
 */

@AppScope
@Component(modules = {AppModule.class, NetworkModule.class, RealmModule.class})
public interface AppComponent {

    Context getContext();

    NetworkService networkService();

    RealmService realmService();
}
