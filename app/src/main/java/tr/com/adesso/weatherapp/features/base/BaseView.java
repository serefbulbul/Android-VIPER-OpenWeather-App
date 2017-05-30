package tr.com.adesso.weatherapp.features.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import tr.com.adesso.weatherapp.utils.managers.AlertViewManager;
import tr.com.adesso.weatherapp.utils.managers.ProgressViewManager;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public abstract class BaseView extends FrameLayout implements BaseContract.View {

    protected final Context context;
    protected View rootView;
    private final ProgressViewManager progressViewManager;
    private final BaseContract.Presenter presenter;
    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseView(@NonNull Context context, BaseContract.Presenter presenter) {
        super(context);

        this.context = context;
        this.presenter = presenter;

        progressViewManager = new ProgressViewManager(context);
    }

    public void subscribe() {
        compositeDisposable.add(observeProgress());
    }

    public void unsubscribe() {
        compositeDisposable.clear();
    }

    public View getRootView() {
        return rootView;
    }

    private Disposable observeProgress() {
        return presenter.getProgress()
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            showProgressView();
                        } else {
                            hideProgressView();
                        }
                    }
                });
    }

    @Override
    public void showActionBar(Context context) {
        ((AppCompatActivity) context).getSupportActionBar().setShowHideAnimationEnabled(false);
        ((AppCompatActivity) context).getSupportActionBar().show();
    }

    @Override
    public void hideActionBar(Context context) {
        ((AppCompatActivity) context).getSupportActionBar().setShowHideAnimationEnabled(false);
        ((AppCompatActivity) context).getSupportActionBar().hide();
    }

    @Override
    public void onBackPressed() {
        ((Activity) context).onBackPressed();
    }

    @Override
    public void showProgressView() {
        progressViewManager.show();
    }

    @Override
    public void hideProgressView() {
        progressViewManager.hide();
    }

    @Override
    public void showAlert(Object title, Object message, Object negativeTitle, DialogInterface.OnClickListener negativeAction, Object positiveTitle, DialogInterface.OnClickListener positiveAction) {
        AlertViewManager.getAlertDialog(context, title, message, negativeTitle, negativeAction, positiveTitle, positiveAction).show();
    }
}