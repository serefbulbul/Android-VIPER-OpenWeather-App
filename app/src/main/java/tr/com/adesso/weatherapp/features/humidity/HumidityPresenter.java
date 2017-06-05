package tr.com.adesso.weatherapp.features.humidity;

import tr.com.adesso.weatherapp.features.base.BasePresenter;
import tr.com.adesso.weatherapp.utils.services.network.models.WeatherData;

/**
 * Created by serefbulbul on 02/06/2017.
 */

public class HumidityPresenter extends BasePresenter implements HumidityContract.Presenter {

    private final HumidityContract.View view;
    private final HumidityContract.Interactor interactor;

    private WeatherData weatherData;

    public HumidityPresenter(HumidityContract.View view, HumidityContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void subscribe() {

    }

    public void unsubscribe() {
        compositeDisposable.clear();
    }

    @Override
    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }
}