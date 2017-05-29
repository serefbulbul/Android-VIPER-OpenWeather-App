package tr.com.adesso.weatherapp.app;

import android.content.Context;

import dagger.Component;
import tr.com.adesso.weatherapp.utils.services.OpenWeatherService;
import tr.com.adesso.weatherapp.utils.services.OpenWeatherServiceModule;

/**
 * Created by serefbulbul on 29/05/2017.
 */

@AppScope
@Component(modules = {AppModule.class, OpenWeatherServiceModule.class})
public interface AppComponent {

    Context getContext();

    OpenWeatherService openWeatherService();
}
