package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

public class ErrorDialogFragments {
    public static int ERROR_DIALOG_ICON;
    public static Class<?> EVENT_TYPE_ON_CLICK;

    public static Dialog createDialog(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString(ErrorDialogManager.KEY_TITLE));
        builder.setMessage(bundle.getString(ErrorDialogManager.KEY_MESSAGE));
        int i = ERROR_DIALOG_ICON;
        if (i != 0) {
            builder.setIcon(i);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void handleOnClick(DialogInterface dialogInterface, int i, Activity activity, Bundle bundle) {
        Class<?> cls = EVENT_TYPE_ON_CLICK;
        if (cls != null) {
            try {
                ErrorDialogManager.factory.config.getEventBus().post(cls.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Event cannot be constructed", e);
            }
        }
        if (bundle.getBoolean(ErrorDialogManager.KEY_FINISH_AFTER_DIALOG, false) && activity != null) {
            activity.finish();
        }
    }

    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.handleOnClick(dialogInterface, i, getActivity(), getArguments());
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.handleOnClick(dialogInterface, i, getActivity(), getArguments());
        }
    }
}
