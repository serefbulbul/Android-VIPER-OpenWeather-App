package tr.com.adesso.weatherapp.features.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public abstract class BasePresenter implements BaseContract.Presenter {

    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected boolean isSubscribed;

    @Override
    public void subscribe() {
        isSubscribed = true;
    }

    @Override
    public void unsubscribe() {
        isSubscribed = false;
        compositeDisposable.clear();
    }
}
