package tr.com.adesso.weatherapp.features.home;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import tr.com.adesso.weatherapp.R;
import tr.com.adesso.weatherapp.features.base.BaseView;

/**
 * Created by batuhan on 25/05/2017.
 */

public class HomePageView extends BaseView implements HomePageContract.View {

    @BindView(R.id.text_view_home_page_current_location_name)
    AppCompatTextView textViewCurrentLocationName;

    @BindView(R.id.text_view_home_page_current_location_temperature)
    AppCompatTextView textViewCurrentLocationTemperature;

    private final HomePageContract.Presenter presenter;

    public HomePageView(Context context, HomePageContract.Presenter presenter) {
        super(context, presenter);
        this.presenter = presenter;

        rootView = inflate(getContext(), R.layout.activity_home_page, this);
        ButterKnife.bind(this);
    }

    @Override
    public void subscribe() {
        super.subscribe();

        compositeDisposable.add(observeWeatherDataName());
        compositeDisposable.add(observeWeatherDataTemperature());
    }

    private Disposable observeWeatherDataName() {
        return presenter.getWeatherDataName()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        textViewCurrentLocationName.setText(s);
                    }
                });
    }

    private Disposable observeWeatherDataTemperature() {
        return presenter.getWeatherDataTemperature()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        textViewCurrentLocationTemperature.setText(s);
                    }
                });
    }
}
