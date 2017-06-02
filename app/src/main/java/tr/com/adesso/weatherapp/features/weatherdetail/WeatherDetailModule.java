package tr.com.adesso.weatherapp.features.weatherdetail;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by serefbulbul on 01/06/2017.
 */

@Module
public class WeatherDetailModule {

    private Context context;

    public WeatherDetailModule(Context context) {
        this.context = context;
    }

    @WeatherDetailScope
    @Provides
    public WeatherDetailContract.View view() {
        return new WeatherDetailView(context);
    }

    @WeatherDetailScope
    @Provides
    public WeatherDetailContract.Presenter presenter(WeatherDetailContract.View view, WeatherDetailContract.Interactor interactor) {
        return new WeatherDetailPresenter(view, interactor);
    }

    @WeatherDetailScope
    @Provides
    public WeatherDetailContract.Interactor interactor() {
        return new WeatherDetailInteractor();
    }
}