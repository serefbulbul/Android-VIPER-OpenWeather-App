package tr.com.adesso.weatherapp.features.temperature;

import tr.com.adesso.weatherapp.features.base.BaseContract;
import tr.com.adesso.weatherapp.utils.services.network.models.WeatherData;

/**
 * Created by serefbulbul on 02/06/2017.
 */

public class TemperatureContract {

    interface View extends BaseContract.View {
        void prepareView();
    }

    interface Presenter extends BaseContract.Presenter {

        void setWeatherData(WeatherData weatherData);
    }

    interface Interactor extends BaseContract.Interactor {

    }
}
