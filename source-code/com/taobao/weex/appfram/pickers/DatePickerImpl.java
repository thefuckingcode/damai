package com.taobao.weex.appfram.pickers;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.taobao.weex.utils.WXLogUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
public class DatePickerImpl {
    private static SimpleDateFormat a;
    private static SimpleDateFormat b;

    /* compiled from: Taobao */
    public interface OnPickListener {
        void onPick(boolean z, @Nullable String str);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements DatePickerDialog.OnDateSetListener {
        final /* synthetic */ OnPickListener a;

        a(OnPickListener onPickListener) {
            this.a = onPickListener;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str;
            String str2;
            int i4 = i2 + 1;
            if (i4 < 10) {
                str = "0" + i4;
            } else {
                str = String.valueOf(i4);
            }
            if (i3 < 10) {
                str2 = "0" + i3;
            } else {
                str2 = String.valueOf(i3);
            }
            this.a.onPick(true, i + "-" + str + "-" + str2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b implements DialogInterface.OnCancelListener {
        final /* synthetic */ OnPickListener a;

        b(OnPickListener onPickListener) {
            this.a = onPickListener;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.a.onPick(false, null);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c implements TimePickerDialog.OnTimeSetListener {
        final /* synthetic */ OnPickListener a;

        c(OnPickListener onPickListener) {
            this.a = onPickListener;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            String str;
            String str2;
            if (i < 10) {
                str = "0" + i;
            } else {
                str = String.valueOf(i);
            }
            if (i2 < 10) {
                str2 = "0" + i2;
            } else {
                str2 = String.valueOf(i2);
            }
            this.a.onPick(true, str + ":" + str2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class d implements DialogInterface.OnCancelListener {
        final /* synthetic */ OnPickListener a;

        d(OnPickListener onPickListener) {
            this.a = onPickListener;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.a.onPick(false, null);
        }
    }

    private static Date a(String str) {
        if (b == null) {
            b = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.getDefault());
        }
        try {
            return b.parse(str);
        } catch (ParseException e) {
            WXLogUtils.w("[DatePickerImpl] " + e.toString());
            return new Date();
        }
    }

    private static Date b(String str) {
        if (a == null) {
            a = new SimpleDateFormat("HH:mm", Locale.getDefault());
        }
        try {
            return a.parse(str);
        } catch (ParseException e) {
            WXLogUtils.w("[DatePickerImpl] " + e.toString());
            return new Date();
        }
    }

    public static void c(@NonNull Context context, String str, String str2, String str3, @NonNull OnPickListener onPickListener, @Nullable Map<String, Object> map) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(a(str));
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new a(onPickListener), instance.get(1), instance.get(2), instance.get(5));
        DatePicker datePicker = datePickerDialog.getDatePicker();
        Calendar instance2 = Calendar.getInstance(Locale.getDefault());
        Calendar instance3 = Calendar.getInstance(Locale.getDefault());
        instance2.set(1900, 0, 1);
        instance3.set(2100, 11, 31);
        if (!TextUtils.isEmpty(str3)) {
            if (datePicker.getMaxDate() >= a(str3).getTime()) {
                datePicker.setMinDate(a(str3).getTime());
            } else {
                datePicker.setMinDate(instance2.getTimeInMillis());
                datePicker.setMaxDate(instance3.getTimeInMillis());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            if (datePicker.getMinDate() <= a(str2).getTime()) {
                datePicker.setMaxDate(a(str2).getTime());
            } else {
                datePicker.setMinDate(instance2.getTimeInMillis());
                datePicker.setMaxDate(instance3.getTimeInMillis());
            }
        }
        datePickerDialog.setOnCancelListener(new b(onPickListener));
        Object obj = null;
        e(datePickerDialog, -2, String.valueOf(map != null ? map.get(WXModalUIModule.CANCEL_TITLE) : null));
        if (map != null) {
            obj = map.get("confirmTitle");
        }
        e(datePickerDialog, -1, String.valueOf(obj));
        datePickerDialog.show();
    }

    public static void d(@NonNull Context context, String str, @NonNull OnPickListener onPickListener, @Nullable Map<String, Object> map) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(b(str));
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new c(onPickListener), instance.get(11), instance.get(12), false);
        timePickerDialog.setOnCancelListener(new d(onPickListener));
        Object obj = null;
        e(timePickerDialog, -2, String.valueOf(map != null ? map.get(WXModalUIModule.CANCEL_TITLE) : null));
        if (map != null) {
            obj = map.get("confirmTitle");
        }
        e(timePickerDialog, -1, String.valueOf(obj));
        timePickerDialog.show();
    }

    private static void e(final AlertDialog alertDialog, final int i, final CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && !"null".equals(charSequence)) {
            try {
                alertDialog.getWindow().getDecorView().post(WXThread.secure(new Runnable() {
                    /* class com.taobao.weex.appfram.pickers.DatePickerImpl.AnonymousClass5 */

                    public void run() {
                        Button button = alertDialog.getButton(i);
                        if (button != null) {
                            button.setAllCaps(false);
                            button.setText(charSequence);
                        }
                    }
                }));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
