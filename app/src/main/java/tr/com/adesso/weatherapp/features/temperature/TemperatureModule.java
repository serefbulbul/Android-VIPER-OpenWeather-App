package tr.com.adesso.weatherapp.features.temperature;

import android.content.Context;
import android.view.View;

import dagger.Module;
import dagger.Provides;

/**
 * Created by serefbulbul on 02/06/2017.
 */

@Module
public class TemperatureModule {

    private final Context context;
    private final View rootView;

    public TemperatureModule(Context context, View rootView) {
        this.context = context;
        this.rootView = rootView;
    }

    @TemperatureScope
    @Provides
    public TemperatureContract.View view() {
        return new TemperatureView(context, rootView);
    }

    @TemperatureScope
    @Provides
    public TemperatureContract.Presenter presenter(TemperatureContract.View view, TemperatureContract.Interactor interactor) {
        return new TemperaturePresenter(view, interactor);
    }

    @TemperatureScope
    @Provides
    public TemperatureContract.Interactor interactor() {
        return new TemperatureInteractor();
    }
}