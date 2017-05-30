package tr.com.adesso.weatherapp.features.base;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public abstract class BasePresenter implements BaseContract.Presenter {

    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected boolean isSubscribed;

    public PublishSubject<Boolean> progress = PublishSubject.create();

    @Override
    public void subscribe() {
        isSubscribed = true;
    }

    @Override
    public void unsubscribe() {
        isSubscribed = false;
        compositeDisposable.clear();
    }

    @Override
    public Observable<Boolean> getProgress() {
        return progress;
    }
}
