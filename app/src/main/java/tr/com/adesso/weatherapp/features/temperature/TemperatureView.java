package tr.com.adesso.weatherapp.features.temperature;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import butterknife.ButterKnife;
import tr.com.adesso.weatherapp.R;
import tr.com.adesso.weatherapp.features.base.BaseView;

/**
 * Created by serefbulbul on 02/06/2017.
 */

public class TemperatureView extends BaseView implements TemperatureContract.View {

    public TemperatureView(Context context, View view) {
        super(context);

        ButterKnife.bind(this, view);

    }

    @Override
    public void prepareView() {
        showActionBar(context);
        ((Activity) context).setTitle(context.getString(R.string.temperature));
    }
}