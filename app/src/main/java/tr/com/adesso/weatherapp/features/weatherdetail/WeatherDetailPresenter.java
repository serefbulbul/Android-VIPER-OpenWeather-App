package tr.com.adesso.weatherapp.features.weatherdetail;

import tr.com.adesso.weatherapp.features.base.BasePresenter;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public class WeatherDetailPresenter extends BasePresenter implements WeatherDetailContract.Presenter {

    private WeatherDetailContract.View view;
    private WeatherDetailContract.Interactor interactor;

    public WeatherDetailPresenter(WeatherDetailContract.View view, WeatherDetailContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void subscribe() {

    }

    public void unsubscribe() {
        compositeDisposable.clear();
    }
}