package tr.com.adesso.weatherapp.features.humidity;

import tr.com.adesso.weatherapp.features.base.BasePresenter;

/**
 * Created by serefbulbul on 02/06/2017.
 */

public class HumidityPresenter extends BasePresenter implements HumidityContract.Presenter {

    private HumidityContract.View view;
    private HumidityContract.Interactor interactor;

    public HumidityPresenter(HumidityContract.View view, HumidityContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void subscribe() {

    }

    public void unsubscribe() {
        compositeDisposable.clear();
    }
}