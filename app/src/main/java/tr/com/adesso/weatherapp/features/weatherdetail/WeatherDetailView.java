package tr.com.adesso.weatherapp.features.weatherdetail;

import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tr.com.adesso.weatherapp.R;
import tr.com.adesso.weatherapp.features.base.BaseView;
import tr.com.adesso.weatherapp.features.humidity.HumidityFragment;
import tr.com.adesso.weatherapp.features.temperature.TemperatureFragment;
import tr.com.adesso.weatherapp.utils.managers.FragmentNavigationManager;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public class WeatherDetailView extends BaseView implements WeatherDetailContract.View {

    @BindView(R.id.bottom_navigation_weather_detail)
    BottomNavigationView bottomNavigationView;

    private final FragmentNavigationManager fragmentNavigationManager;
    
    public WeatherDetailView(Context context) {
        super(context);

        rootView = inflate(getContext(), R.layout.activity_weather_detail, this);
        ButterKnife.bind(this);

        List<Fragment> fragmentList = new ArrayList(2) {{
            add(TemperatureFragment.newInstance(0));
            add(HumidityFragment.newInstance(1));
        }};

        fragmentNavigationManager = new FragmentNavigationManager(((WeatherDetailActivity) context).getSupportFragmentManager(), R.id.frame_layout_weather_detail, fragmentList);

        configureNavigationBottomView();
    }

    private void configureNavigationBottomView() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_weather_detail);
        switchTab(0);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.transaction:
                    switchTab(0);
                    break;
                case R.id.contact:
                    switchTab(1);
                    break;
                default:
                    switchTab(0);
                    break;
            }

            return true;
        });

    }

    public void switchTab(int index) {
        switch (index) {
            case 0:
                fragmentNavigationManager.switchTab(FragmentNavigationManager.TAB1);
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                break;
            case 1:
                fragmentNavigationManager.switchTab(FragmentNavigationManager.TAB2);
                bottomNavigationView.getMenu().getItem(1).setChecked(true);
                break;
            default:
                fragmentNavigationManager.switchTab(FragmentNavigationManager.TAB1);
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
        }
    }
}