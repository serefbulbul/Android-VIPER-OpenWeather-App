package tr.com.adesso.weatherapp.features.home;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import tr.com.adesso.weatherapp.utils.services.NetworkService;
import tr.com.adesso.weatherapp.utils.services.realm.RealmService;

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
    public HomePageContract.View view() {
        return new HomePageView(context);
    }

    @HomePageScope
    @Provides
    public HomePageContract.Presenter presenter(HomePageContract.View view, HomePageContract.Interactor interactor) {
        return new HomePagePresenter(view, interactor);
    }

    @HomePageScope
    @Provides
    public HomePageContract.Interactor interactor(NetworkService networkService, RealmService realmService) {
        return new HomePageInteractor(networkService, realmService);
    }
}
