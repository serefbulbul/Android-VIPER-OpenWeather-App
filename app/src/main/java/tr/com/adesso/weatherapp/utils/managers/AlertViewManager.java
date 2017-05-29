package tr.com.adesso.weatherapp.utils.managers;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import tr.com.adesso.weatherapp.R;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public class AlertViewManager {

    public static AlertDialog getAlertDialog(Context context, Object title, Object message, Object negativeButtonTitle, DialogInterface.OnClickListener negativeButtonOnClickListener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
        if (title instanceof String) {
            alertDialogBuilder.setTitle((String) title);
        } else if (title instanceof Integer) {
            alertDialogBuilder.setTitle(context.getString((Integer) title));
        }

        if (message instanceof String) {
            alertDialogBuilder.setMessage((String) message);
        } else if (message instanceof Integer) {
            alertDialogBuilder.setMessage(context.getString((Integer) message));
        }

        if (negativeButtonTitle instanceof String) {
            alertDialogBuilder.setNegativeButton((String) negativeButtonTitle, negativeButtonOnClickListener);
        } else if (negativeButtonTitle instanceof Integer) {
            alertDialogBuilder.setNegativeButton(context.getString((Integer) negativeButtonTitle), negativeButtonOnClickListener);
        }

        return alertDialogBuilder.setCancelable(false).create();
    }

    public static AlertDialog getAlertDialog(Context context, Object title, Object message, Object negativeButtonTitle, DialogInterface.OnClickListener negativeButtonOnClickListener,
                                             Object positiveButtonTitle, DialogInterface.OnClickListener positiveButtonOnClickListener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
        if (title instanceof String) {
            alertDialogBuilder.setTitle((String) title);
        } else if (title instanceof Integer) {
            alertDialogBuilder.setTitle(context.getString((Integer) title));
        }

        if (message instanceof String) {
            alertDialogBuilder.setMessage((String) message);
        } else if (message instanceof Integer) {
            alertDialogBuilder.setMessage(context.getString((Integer) message));
        }

        if (positiveButtonTitle instanceof String) {
            alertDialogBuilder.setPositiveButton((String) positiveButtonTitle, positiveButtonOnClickListener);
        } else if (positiveButtonTitle instanceof Integer) {
            alertDialogBuilder.setPositiveButton(context.getString((Integer) positiveButtonTitle), positiveButtonOnClickListener);
        }

        if (negativeButtonTitle instanceof String) {
            alertDialogBuilder.setNegativeButton((String) negativeButtonTitle, negativeButtonOnClickListener);
        } else if (negativeButtonTitle instanceof Integer) {
            alertDialogBuilder.setNegativeButton(context.getString((Integer) negativeButtonTitle), negativeButtonOnClickListener);
        }

        return alertDialogBuilder.setCancelable(false).create();
    }
}
