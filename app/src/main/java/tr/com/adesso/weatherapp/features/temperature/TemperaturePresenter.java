package tr.com.adesso.weatherapp.features.temperature;

import tr.com.adesso.weatherapp.features.base.BasePresenter;

/**
 * Created by serefbulbul on 02/06/2017.
 */

public class TemperaturePresenter extends BasePresenter implements TemperatureContract.Presenter {

    private TemperatureContract.View view;
    private TemperatureContract.Interactor interactor;

    public TemperaturePresenter(TemperatureContract.View view, TemperatureContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void subscribe() {

    }

    public void unsubscribe() {
        compositeDisposable.clear();
    }
}