package tr.com.adesso.weatherapp.features.home;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

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

    @BindView(R.id.text_view_home_page_current_location_temperature)
    AppCompatTextView textViewCurrentLocationTemperature;

    @BindView(R.id.edit_text_home_page_some_text)
    AppCompatEditText editTextSomeText;

    @BindView(R.id.button_home_page_some_button)
    AppCompatButton buttonSomeButton;

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

        compositeDisposable.add(presenter.getWeatherDataName().subscribe(RxTextView.text(textViewCurrentLocationName)));
        compositeDisposable.add(presenter.getWeatherDataTemperature().subscribe(RxTextView.text(textViewCurrentLocationTemperature)));

        presenter.setInput(RxTextView.textChanges(editTextSomeText), RxView.clicks(buttonSomeButton));
    }
}
