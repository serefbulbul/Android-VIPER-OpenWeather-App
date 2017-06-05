package tr.com.adesso.weatherapp.features.temperature;

import tr.com.adesso.weatherapp.features.base.BasePresenter;
import tr.com.adesso.weatherapp.utils.services.network.models.WeatherData;

/**
 * Created by serefbulbul on 02/06/2017.
 */

public class TemperaturePresenter extends BasePresenter implements TemperatureContract.Presenter {

    private final TemperatureContract.View view;
    private final TemperatureContract.Interactor interactor;

    private WeatherData weatherData;

    public TemperaturePresenter(TemperatureContract.View view, TemperatureContract.Interactor interactor) {
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