package tr.com.adesso.weatherapp.features.temperature;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tr.com.adesso.weatherapp.R;
import tr.com.adesso.weatherapp.features.base.BaseView;

/**
 * Created by serefbulbul on 02/06/2017.
 */

public class TemperatureView extends BaseView implements TemperatureContract.View {

    @BindView(R.id.image_view_temperature_icon)
    AppCompatImageView imageViewTemperature;

    public TemperatureView(Context context) {
        super(context);

        rootView = inflate(getContext(), R.layout.fragment_temperature, this);
        ButterKnife.bind(this);
    }

    @Override
    public void prepareView() {
        showActionBar(context);
        ((Activity) context).setTitle(context.getString(R.string.temperature));
    }
}