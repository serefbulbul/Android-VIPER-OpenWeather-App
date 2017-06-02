package tr.com.adesso.weatherapp.features.weatherdetail;

import dagger.Component;
import tr.com.adesso.weatherapp.app.AppComponent;

/**
 * Created by serefbulbul on 01/06/2017.
 */

@WeatherDetailScope
@Component(modules = WeatherDetailModule.class, dependencies = AppComponent.class)
public interface WeatherDetailComponent {
    void inject(WeatherDetailActivity activity);
}