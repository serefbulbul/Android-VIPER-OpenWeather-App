package tr.com.adesso.weatherapp.features.humidity;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by serefbulbul on 02/06/2017.
 */

@Module
public class HumidityModule {

    private final Context context;

    public HumidityModule(Context context) {
        this.context = context;
    }

    @HumidityScope
    @Provides
    public HumidityContract.View view() {
        return new HumidityView(context);
    }

    @HumidityScope
    @Provides
    public HumidityContract.Presenter presenter(HumidityContract.View view, HumidityContract.Interactor interactor) {
        return new HumidityPresenter(view, interactor);
    }

    @HumidityScope
    @Provides
    public HumidityContract.Interactor interactor() {
        return new HumidityInteractor();
    }
}