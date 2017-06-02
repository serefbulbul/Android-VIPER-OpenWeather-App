package tr.com.adesso.weatherapp.features.humidity;

import android.content.Context;
import android.view.View;

import dagger.Module;
import dagger.Provides;

/**
 * Created by serefbulbul on 02/06/2017.
 */

@Module
public class HumidityModule {

    private final Context context;
    private final View rootView;

    public HumidityModule(Context context, View rootView) {
        this.context = context;
        this.rootView = rootView;
    }

    @HumidityScope
    @Provides
    public HumidityContract.View view() {
        return new HumidityView(context, rootView);
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