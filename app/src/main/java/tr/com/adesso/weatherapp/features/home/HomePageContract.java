package tr.com.adesso.weatherapp.features.home;

import io.reactivex.Observable;
import tr.com.adesso.weatherapp.features.base.BaseContract;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public class HomePageContract {

    interface View extends BaseContract.View {
        void setCurrentLocationName(String currentLocationName);
    }

    interface Presenter extends BaseContract.Presenter {

    }


    interface Interactor extends BaseContract.Interactor {
        void requestLondonData();
        Observable<WeatherData> getLondonData();
    }
}
