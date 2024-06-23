package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;

/* compiled from: Taobao */
public class ErrorDialogFragment extends DialogFragment {
    private DialogInterface.OnCancelListener myCancelLister = null;
    private Dialog myDialog = null;

    public static ErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.myCancelLister;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.myDialog == null) {
            setShowsDialog(false);
        }
        return this.myDialog;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
        super.show(fragmentManager, str);
    }

    public static ErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        errorDialogFragment.myDialog = dialog;
        dialog.setOnCancelListener(null);
        errorDialogFragment.myDialog.setOnDismissListener(null);
        if (onCancelListener != null) {
            errorDialogFragment.myCancelLister = onCancelListener;
        }
        return errorDialogFragment;
    }
}
