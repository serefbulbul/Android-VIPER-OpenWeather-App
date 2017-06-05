package tr.com.adesso.weatherapp.features.humidity;

import tr.com.adesso.weatherapp.features.base.BaseContract;
import tr.com.adesso.weatherapp.utils.services.network.models.WeatherData;

/**
 * Created by serefbulbul on 02/06/2017.
 */

public class HumidityContract {

    interface View extends BaseContract.View {
        void prepareView();
    }

    interface Presenter extends BaseContract.Presenter {

        void setWeatherData(WeatherData weatherData);
    }

    interface Interactor extends BaseContract.Interactor {

    }
}
