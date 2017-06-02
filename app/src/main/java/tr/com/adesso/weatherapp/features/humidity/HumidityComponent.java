package tr.com.adesso.weatherapp.features.humidity;

import dagger.Component;
import tr.com.adesso.weatherapp.app.AppComponent;

/**
 * Created by serefbulbul on 02/06/2017.
 */

@HumidityScope
@Component(modules = {HumidityModule.class}, dependencies = AppComponent.class)
public interface HumidityComponent {
    void inject(HumidityFragment fragment);
}