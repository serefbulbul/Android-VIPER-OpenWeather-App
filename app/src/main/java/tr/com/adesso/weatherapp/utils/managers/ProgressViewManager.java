package tr.com.adesso.weatherapp.utils.managers;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import tr.com.adesso.weatherapp.R;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public class ProgressViewManager {

    private final Context mContext;
    private ProgressBar mCircularProgressView;

    private Dialog mDialog;

    public ProgressViewManager(Context context) {
        mContext = context;
    }

    public void show() {
        Activity activity = (Activity) mContext;

        if (mDialog == null && !activity.isFinishing()) {
            mDialog = new Dialog(activity, R.style.TranslucentTheme);
            mDialog.setContentView(R.layout.progress_view);

            mDialog.setCancelable(false);
            mDialog.setCanceledOnTouchOutside(false);

            mCircularProgressView = (ProgressBar) mDialog.findViewById(R.id.progress_view);

            mDialog.show();
        } else if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    public void hide() {
        try {
            if (mDialog != null && mDialog.isShowing()) {
                mCircularProgressView.setVisibility(View.INVISIBLE);
                mDialog.dismiss();
                mDialog.cancel();
            }
            mDialog = null;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
