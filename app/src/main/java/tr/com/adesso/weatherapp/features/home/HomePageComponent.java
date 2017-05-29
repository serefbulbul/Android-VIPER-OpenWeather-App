package tr.com.adesso.weatherapp.features.home;

import dagger.Component;
import tr.com.adesso.weatherapp.app.AppComponent;

/**
 * Created by batuhan on 25/05/2017.
 */

@HomePageScope
@Component(modules = HomePageModule.class, dependencies = AppComponent.class)
public interface HomePageComponent {
    void inject(HomePageActivity activity);
}
