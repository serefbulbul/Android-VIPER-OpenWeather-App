package tr.com.adesso.weatherapp.features.home;

import io.reactivex.Observable;
import tr.com.adesso.weatherapp.features.base.BaseContract;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public interface HomePageContract {

    interface View extends BaseContract.View {
        void setCurrentLocationName(String currentLocationName);

        void setCurrentLocationTemperature(String currentLocationTemperature);

        void setSomeText(String text);

        String getSomeText();

        Observable<CharSequence> onSomeTextChange();

        Observable<Object> onSomeButtonClick();
    }

    interface Presenter extends BaseContract.Presenter {

    }

    interface Interactor extends BaseContract.Interactor {
        Observable<WeatherData> getWeatherData(String city);
    }
}
