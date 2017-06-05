package tr.com.adesso.weatherapp.features.humidity;

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

public class HumidityView extends BaseView implements HumidityContract.View {

    @BindView(R.id.image_view_humidity_icon)
    AppCompatImageView imageViewTemperature;

    public HumidityView(Context context) {
        super(context);

        rootView = inflate(getContext(), R.layout.fragment_humidity, this);
        ButterKnife.bind(this);
    }

    @Override
    public void prepareView() {
        showActionBar(context);
        ((Activity) context).setTitle(context.getString(R.string.humidity));
    }
}