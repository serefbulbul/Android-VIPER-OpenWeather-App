package tr.com.adesso.weatherapp.features.humidity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import tr.com.adesso.weatherapp.R;
import tr.com.adesso.weatherapp.app.App;
import tr.com.adesso.weatherapp.features.base.BaseFragment;
import tr.com.adesso.weatherapp.features.humidity.HumidityContract;
import tr.com.adesso.weatherapp.features.humidity.HumidityModule;

/**
 * Created by serefbulbul on 02/06/2017.
 */

public class HumidityFragment extends BaseFragment {

    private static final String TAB_INDEX = "TAB_INDEX";

    @Inject
    HumidityContract.View view;

    @Inject
    HumidityContract.Presenter presenter;

    public static HumidityFragment newInstance(int index) {
        HumidityFragment fragment = new HumidityFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View viewRoot = inflater.inflate(R.layout.fragment_humidity, container, false);

        DaggerHumidityComponent.builder()
                .humidityModule(new HumidityModule(getContext(), viewRoot))
                .appComponent(App.get(getActivity()).component())
                .build().inject(this);

        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.view.prepareView();
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
}
