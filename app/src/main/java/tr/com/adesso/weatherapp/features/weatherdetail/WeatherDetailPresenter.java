package tr.com.adesso.weatherapp.features.weatherdetail;

import tr.com.adesso.weatherapp.features.base.BasePresenter;
import tr.com.adesso.weatherapp.utils.services.network.models.WeatherData;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public class WeatherDetailPresenter extends BasePresenter implements WeatherDetailContract.Presenter {

    private final WeatherDetailContract.View view;
    private final WeatherDetailContract.Interactor interactor;

    private WeatherData weatherData;

    public WeatherDetailPresenter(WeatherDetailContract.View view, WeatherDetailContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void subscribe() {
        view.configureFragments(weatherData);
    }

    public void unsubscribe() {
        compositeDisposable.clear();
    }

    @Override
    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;

        view.configureFragments(weatherData);
    }
}