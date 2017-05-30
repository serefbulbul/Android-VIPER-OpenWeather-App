package tr.com.adesso.weatherapp.features.home;

import io.reactivex.Observable;
import tr.com.adesso.weatherapp.features.base.BaseContract;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public class HomePageContract {

    interface View extends BaseContract.View {

    }

    interface Presenter extends BaseContract.Presenter {
        void setInput(Observable<CharSequence> onSomeTextChange, Observable<Object> onSomeButtonClick);

        Observable<String> getWeatherDataName();
        Observable<String> getWeatherDataTemperature();
    }

    interface Interactor extends BaseContract.Interactor {
        Observable<WeatherData> observeLondonData();
    }
}
