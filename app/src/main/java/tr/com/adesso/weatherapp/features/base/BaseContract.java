package tr.com.adesso.weatherapp.features.base;

import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public interface BaseContract {

    interface View {
        void showActionBar(Context context);

        void hideActionBar(Context context);

        void onBackPressed();

        void showProgressView();

        void hideProgressView();

        void showAlert(String title, String message, String negativeTitle, DialogInterface.OnClickListener negativeAction, String positiveTitle, DialogInterface.OnClickListener positiveAction);
    }

    interface Presenter {
        void subscribe();

        void unsubscribe();
    }

    interface Interactor {

    }
}