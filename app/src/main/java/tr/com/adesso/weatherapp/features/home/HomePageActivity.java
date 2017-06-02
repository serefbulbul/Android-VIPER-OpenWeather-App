package tr.com.adesso.weatherapp.features.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;

import javax.inject.Inject;

import tr.com.adesso.weatherapp.app.App;
import tr.com.adesso.weatherapp.features.base.BaseActivity;

public class HomePageActivity extends BaseActivity {

    @Inject
    HomePageContract.Presenter presenter;

    @Inject
    HomePageContract.View view;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, HomePageActivity.class);
//        intent.putExtra("", "");
        return intent;
    }

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

        presenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.unsubscribe();
    }
}



