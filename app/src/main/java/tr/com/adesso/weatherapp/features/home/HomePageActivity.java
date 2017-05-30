package tr.com.adesso.weatherapp.features.home;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import tr.com.adesso.weatherapp.app.App;

public class HomePageActivity extends AppCompatActivity {

    @Inject
    HomePageContract.Presenter presenter;

    @Inject
    HomePageContract.View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerHomePageComponent.builder()
                .homePageModule(new HomePageModule(this))
                .appComponent(App.get(this).component())
                .build().inject(this);

        setContentView(view.getRootView());

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    protected void onResume() {
        super.onResume();

        view.subscribe();
        presenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.unsubscribe();
        view.unsubscribe();
    }
}



