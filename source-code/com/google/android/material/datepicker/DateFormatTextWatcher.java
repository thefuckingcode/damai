package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    private static final int VALIDATION_DELAY = 1000;
    private final CalendarConstraints constraints;
    private final DateFormat dateFormat;
    private final String outOfRange;
    private final Runnable setErrorCallback;
    private Runnable setRangeErrorCallback;
    @NonNull
    private final TextInputLayout textInputLayout;

    DateFormatTextWatcher(final String str, DateFormat dateFormat2, @NonNull TextInputLayout textInputLayout2, CalendarConstraints calendarConstraints) {
        this.dateFormat = dateFormat2;
        this.textInputLayout = textInputLayout2;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout2.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.setErrorCallback = new Runnable() {
            /* class com.google.android.material.datepicker.DateFormatTextWatcher.AnonymousClass1 */

            public void run() {
                TextInputLayout textInputLayout = DateFormatTextWatcher.this.textInputLayout;
                DateFormat dateFormat = DateFormatTextWatcher.this.dateFormat;
                Context context = textInputLayout.getContext();
                String string = context.getString(R.string.mtrl_picker_invalid_format);
                String format = String.format(context.getString(R.string.mtrl_picker_invalid_format_use), str);
                String format2 = String.format(context.getString(R.string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis())));
                textInputLayout.setError(string + StringUtils.LF + format + StringUtils.LF + format2);
                DateFormatTextWatcher.this.onInvalidDate();
            }
        };
    }

    private Runnable createRangeErrorCallback(final long j) {
        return new Runnable() {
            /* class com.google.android.material.datepicker.DateFormatTextWatcher.AnonymousClass2 */

            public void run() {
                DateFormatTextWatcher.this.textInputLayout.setError(String.format(DateFormatTextWatcher.this.outOfRange, DateStrings.getDateString(j)));
                DateFormatTextWatcher.this.onInvalidDate();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void onInvalidDate() {
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter
    public void onTextChanged(@NonNull CharSequence charSequence, int i, int i2, int i3) {
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        this.textInputLayout.setError(null);
        onValidDate(null);
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                Date parse = this.dateFormat.parse(charSequence.toString());
                this.textInputLayout.setError(null);
                long time = parse.getTime();
                if (!this.constraints.getDateValidator().isValid(time) || !this.constraints.isWithinBounds(time)) {
                    Runnable createRangeErrorCallback = createRangeErrorCallback(time);
                    this.setRangeErrorCallback = createRangeErrorCallback;
                    runValidation(this.textInputLayout, createRangeErrorCallback);
                    return;
                }
                onValidDate(Long.valueOf(parse.getTime()));
            } catch (ParseException unused) {
                runValidation(this.textInputLayout, this.setErrorCallback);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void onValidDate(@Nullable Long l);

    public void runValidation(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000);
    }
}
