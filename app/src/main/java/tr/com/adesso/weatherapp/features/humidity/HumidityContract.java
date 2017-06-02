package tr.com.adesso.weatherapp.features.humidity;

import tr.com.adesso.weatherapp.features.base.BaseContract;

/**
 * Created by serefbulbul on 02/06/2017.
 */

public class HumidityContract {

    interface View extends BaseContract.View {
        void prepareView();
    }

    interface Presenter extends BaseContract.Presenter {

    }

    interface Interactor extends BaseContract.Interactor {

    }
}
