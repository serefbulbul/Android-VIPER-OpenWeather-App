package tr.com.adesso.weatherapp.features.home;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import tr.com.adesso.weatherapp.utils.services.OpenWeatherService;

/**
 * Created by batuhan on 25/05/2017.
 */

@Module
public class HomePageModule {

    private Context context;

    public HomePageModule(Context context) {
        this.context = context;
    }

    @HomePageScope
    @Provides
    public HomePageView view(HomePagePresenter presenter) {
        return new HomePageView(context, presenter);
    }

    @HomePageScope
    @Provides
    public HomePagePresenter presenter(HomePageInteractor interactor) {
        return new HomePagePresenter(interactor);
    }

    @HomePageScope
    @Provides
    public HomePageInteractor interactor(OpenWeatherService openWeatherService) {
        return new HomePageInteractor(openWeatherService);
    }
}
