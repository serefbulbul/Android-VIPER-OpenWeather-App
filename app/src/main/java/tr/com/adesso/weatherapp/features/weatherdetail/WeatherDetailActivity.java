package tr.com.adesso.weatherapp.features.weatherdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;

import org.parceler.Parcels;

import javax.inject.Inject;

import tr.com.adesso.weatherapp.app.App;
import tr.com.adesso.weatherapp.features.base.BaseActivity;
import tr.com.adesso.weatherapp.utils.services.network.models.WeatherData;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public class WeatherDetailActivity extends BaseActivity {

    private static final String WEATHER_DATA = "WEATHER_DATA";

    @Inject
    WeatherDetailContract.Presenter presenter;

    @Inject
    WeatherDetailContract.View view;

    public static Intent newIntent(Context context, WeatherData weatherData) {
        Intent intent = new Intent(context, WeatherDetailActivity.class);
        intent.putExtra(WEATHER_DATA, Parcels.wrap(weatherData));
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerWeatherDetailComponent.builder()
                .weatherDetailModule(new WeatherDetailModule(this))
                .appComponent(App.get(this).component())
                .build().inject(this);

        setContentView(view.getRootView());

        getExtras();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.unsubscribe();
    }

    private void getExtras() {
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            WeatherData weatherData = Parcels.unwrap(extras.getParcelable(WEATHER_DATA));
        }
    }
}