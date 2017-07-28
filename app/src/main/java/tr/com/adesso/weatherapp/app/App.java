package tr.com.adesso.weatherapp.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import timber.log.Timber;
import tr.com.adesso.weatherapp.BuildConfig;
import tr.com.adesso.weatherapp.utils.constants.Constants;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public class App extends Application {

    private AppComponent appComponent;

    public static boolean isActivityActive;
    public static int activityCount;

    public static App get(Activity activity) {
        return (App) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree(){
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    super.log(priority, Constants.TIMBER_LOG, message, t);
                }
            });
        }

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        activityCount = 0;

        Realm.init(getApplicationContext());

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Log.d("ActivityLifecycle", "onActivityCreated " + activity.getLocalClassName());
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.d("ActivityLifecycle", "onActivityStarted " + activity.getLocalClassName());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.d("ActivityLifecycle", "onActivityResumed " + activity.getLocalClassName());
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.d("ActivityLifecycle", "onActivityPaused " + activity.getLocalClassName());
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.d("ActivityLifecycle", "onActivityStopped " + activity.getLocalClassName());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                Log.d("ActivityLifecycle", "onActivitySaveInstanceState " + activity.getLocalClassName());
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.d("ActivityLifecycle", "onActivityDestroyed " + activity.getLocalClassName());
            }
        });
    }

    public AppComponent component() {
        return appComponent;
    }
}
