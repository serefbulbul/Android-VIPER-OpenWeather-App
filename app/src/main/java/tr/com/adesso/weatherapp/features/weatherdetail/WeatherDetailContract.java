package tr.com.adesso.weatherapp.features.weatherdetail;

import tr.com.adesso.weatherapp.features.base.BaseContract;
import tr.com.adesso.weatherapp.utils.services.network.models.WeatherData;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public class WeatherDetailContract {

    interface View extends BaseContract.View {

        void configureFragments(WeatherData weatherData);
    }

    interface Presenter extends BaseContract.Presenter {

        void setWeatherData(WeatherData weatherData);
    }

    interface Interactor extends BaseContract.Interactor {

    }
}
