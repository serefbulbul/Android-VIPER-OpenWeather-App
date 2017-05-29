package tr.com.adesso.weatherapp.features.home;

import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import tr.com.adesso.weatherapp.features.base.BasePresenter;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

/**
 * Created by batuhan on 18/05/2017.
 */

public class HomePagePresenter extends BasePresenter implements HomePageContract.Presenter {

    private HomePageContract.View view;
    private HomePageContract.Interactor interactor;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HomePagePresenter(HomePageContract.View view, HomePageContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void subscribe() {
        compositeDisposable.add(getLondonData());

        view.showProgressView();
        interactor.requestLondonData();
    }

    public void unsubscribe() {
        compositeDisposable.clear();
    }

    private Disposable getLondonData() {
        return interactor.getLondonData()
                .subscribe(new Consumer<WeatherData>() {
                    @Override
                    public void accept(WeatherData weatherData) throws Exception {
                        Log.e("Current Weather", weatherData.getWeather()
                                .get(0)
                                .getDescription());

                        view.setCurrentLocationName(weatherData.getName());
                        view.hideProgressView();
                    }
                });
    }

}
