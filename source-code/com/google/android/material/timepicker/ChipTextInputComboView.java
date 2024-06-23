package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* compiled from: Taobao */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    private final Chip chip;
    private final EditText editText;
    private TextView label;
    private final TextInputLayout textInputLayout;
    private TextWatcher watcher;

    /* compiled from: Taobao */
    private class TextFormatter extends TextWatcherAdapter {
        private static final String DEFAULT_TEXT = "00";

        private TextFormatter() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.chip.setText(ChipTextInputComboView.this.formatText(DEFAULT_TEXT));
            } else {
                ChipTextInputComboView.this.chip.setText(ChipTextInputComboView.this.formatText(editable));
            }
        }
    }

    public ChipTextInputComboView(@NonNull Context context) {
        this(context, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String formatText(CharSequence charSequence) {
        return TimeModel.formatText(getResources(), charSequence);
    }

    private void updateHintLocales() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public void addInputFilter(InputFilter inputFilter) {
        InputFilter[] filters = this.editText.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.editText.setFilters(inputFilterArr);
    }

    public TextInputLayout getTextInput() {
        return this.textInputLayout;
    }

    public boolean isChecked() {
        return this.chip.isChecked();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateHintLocales();
    }

    public void setChecked(boolean z) {
        this.chip.setChecked(z);
        int i = 0;
        this.editText.setVisibility(z ? 0 : 4);
        Chip chip2 = this.chip;
        if (z) {
            i = 8;
        }
        chip2.setVisibility(i);
        if (isChecked()) {
            this.editText.requestFocus();
            if (!TextUtils.isEmpty(this.editText.getText())) {
                EditText editText2 = this.editText;
                editText2.setSelection(editText2.getText().length());
            }
        }
    }

    public void setChipDelegate(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.chip, accessibilityDelegateCompat);
    }

    public void setCursorVisible(boolean z) {
        this.editText.setCursorVisible(z);
    }

    public void setHelperText(CharSequence charSequence) {
        this.label.setText(charSequence);
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.chip.setOnClickListener(onClickListener);
    }

    public void setTag(int i, Object obj) {
        this.chip.setTag(i, obj);
    }

    public void setText(CharSequence charSequence) {
        this.chip.setText(formatText(charSequence));
        if (!TextUtils.isEmpty(this.editText.getText())) {
            this.editText.removeTextChangedListener(this.watcher);
            this.editText.setText((CharSequence) null);
            this.editText.addTextChangedListener(this.watcher);
        }
    }

    public void toggle() {
        this.chip.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip2 = (Chip) from.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.chip = chip2;
        TextInputLayout textInputLayout2 = (TextInputLayout) from.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.textInputLayout = textInputLayout2;
        EditText editText2 = textInputLayout2.getEditText();
        this.editText = editText2;
        editText2.setVisibility(4);
        TextFormatter textFormatter = new TextFormatter();
        this.watcher = textFormatter;
        editText2.addTextChangedListener(textFormatter);
        updateHintLocales();
        addView(chip2);
        addView(textInputLayout2);
        this.label = (TextView) findViewById(R.id.material_label);
        editText2.setSaveEnabled(false);
    }
}
