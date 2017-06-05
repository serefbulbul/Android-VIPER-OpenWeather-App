package tr.com.adesso.weatherapp.features.temperature;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import javax.inject.Inject;

import tr.com.adesso.weatherapp.app.App;
import tr.com.adesso.weatherapp.features.base.BaseFragment;
import tr.com.adesso.weatherapp.utils.services.network.models.WeatherData;

/**
 * Created by serefbulbul on 02/06/2017.
 */

public class TemperatureFragment extends BaseFragment {

    private static final String TAB_INDEX = "TAB_INDEX";
    private static final String WEATHER_DATA = "WEATHER_DATA";

    @Inject
    TemperatureContract.View view;

    @Inject
    TemperatureContract.Presenter presenter;

    public static TemperatureFragment newInstance(int index, WeatherData weatherData) {
        TemperatureFragment fragment = new TemperatureFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_INDEX, index);
        args.putParcelable(WEATHER_DATA, Parcels.wrap(weatherData));
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        DaggerTemperatureComponent.builder()
                .temperatureModule(new TemperatureModule(getContext()))
                .appComponent(App.get(getActivity()).component())
                .build().inject(this);

        return view.getRootView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.view.prepareView();

        getExtras();
    }

    @Override
    public void onResume() {
        super.onResume();

        if (getView() != null && getView().getVisibility() == View.VISIBLE) {
            presenter.subscribe();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        presenter.unsubscribe();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        if (!hidden) {
            view.prepareView();
            presenter.subscribe();
        } else {
            presenter.unsubscribe();
        }
    }

    private void getExtras() {
        Bundle extras = getArguments();

        if (extras != null) {
            presenter.setWeatherData(Parcels.unwrap(extras.getParcelable(WEATHER_DATA)));
        }
    }
}
