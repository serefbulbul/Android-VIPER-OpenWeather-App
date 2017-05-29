package tr.com.adesso.weatherapp.features.home;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tr.com.adesso.weatherapp.R;
import tr.com.adesso.weatherapp.features.base.BaseView;

/**
 * Created by batuhan on 25/05/2017.
 */

public class HomePageView extends BaseView implements HomePageContract.View {

    @BindView(R.id.text_view_home_page_current_location_name)
    AppCompatTextView textViewCurrentLocationName;

    private final HomePagePresenter presenter;

    public HomePageView(Context context, HomePagePresenter presenter) {
        super(context, presenter);
        this.presenter = presenter;

        inflate(getContext(), R.layout.activity_home_page, this);
        ButterKnife.bind(this);
    }

    public void setCurrentLocationName(String currentLocationName) {
        textViewCurrentLocationName.setText(currentLocationName);
    }
}
