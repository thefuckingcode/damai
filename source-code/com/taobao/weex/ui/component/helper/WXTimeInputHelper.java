package com.taobao.weex.ui.component.helper;

import android.widget.TextView;
import androidx.annotation.Nullable;
import com.taobao.weex.appfram.pickers.DatePickerImpl;
import com.taobao.weex.ui.component.AbstractEditComponent;

/* compiled from: Taobao */
public class WXTimeInputHelper {
    public static void pickDate(String str, String str2, final AbstractEditComponent abstractEditComponent) {
        final TextView textView = (TextView) abstractEditComponent.getHostView();
        DatePickerImpl.c(textView.getContext(), textView.getText().toString(), str, str2, new DatePickerImpl.OnPickListener() {
            /* class com.taobao.weex.ui.component.helper.WXTimeInputHelper.AnonymousClass1 */

            @Override // com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener
            public void onPick(boolean z, @Nullable String str) {
                if (z) {
                    textView.setText(str);
                    abstractEditComponent.performOnChange(str);
                }
            }
        }, null);
    }

    public static void pickTime(final AbstractEditComponent abstractEditComponent) {
        final TextView textView = (TextView) abstractEditComponent.getHostView();
        DatePickerImpl.d(textView.getContext(), textView.getText().toString(), new DatePickerImpl.OnPickListener() {
            /* class com.taobao.weex.ui.component.helper.WXTimeInputHelper.AnonymousClass2 */

            @Override // com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener
            public void onPick(boolean z, @Nullable String str) {
                if (z) {
                    textView.setText(str);
                    abstractEditComponent.performOnChange(str);
                }
            }
        }, null);
    }
}
