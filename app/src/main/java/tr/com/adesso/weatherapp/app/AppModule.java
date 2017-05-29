package tr.com.adesso.weatherapp.app;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by serefbulbul on 29/05/2017.
 */

@Module
public class AppModule {

    private  final Context context;

    AppModule(Context context) {
        this.context = context;
    }

    @AppScope
    @Provides
    public Context provideContext() {
        return context;
    }
}