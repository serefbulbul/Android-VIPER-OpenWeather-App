package tr.com.adesso.weatherapp.features.temperature;

import dagger.Component;
import tr.com.adesso.weatherapp.app.AppComponent;

/**
 * Created by serefbulbul on 02/06/2017.
 */

@TemperatureScope
@Component(modules = {TemperatureModule.class}, dependencies = AppComponent.class)
public interface TemperatureComponent {
    void inject(TemperatureFragment fragment);
}