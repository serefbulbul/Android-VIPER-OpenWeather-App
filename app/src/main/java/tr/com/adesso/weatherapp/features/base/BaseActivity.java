package tr.com.adesso.weatherapp.features.base;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import tr.com.adesso.weatherapp.app.App;

import static tr.com.adesso.weatherapp.app.App.activityCount;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        App.isActivityActive = true;

        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }

    @Override
    protected void onPause() {
        super.onPause();

        App.isActivityActive = false;
    }

    @Override
    protected void onStart() {
        super.onStart();

        activityCount++;
    }

    @Override
    protected void onStop() {
        super.onStop();

        activityCount--;
    }
}