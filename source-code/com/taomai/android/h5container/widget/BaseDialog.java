package com.taomai.android.h5container.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
public class BaseDialog extends Dialog {
    public BaseDialog(@NonNull Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            decorView.setPadding(i, 0, i, 0);
        }
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }

    public BaseDialog(@NonNull Context context, int i) {
        super(context, i);
    }
}
