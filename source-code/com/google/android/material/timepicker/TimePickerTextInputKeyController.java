package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class TimePickerTextInputKeyController implements View.OnKeyListener, TextView.OnEditorActionListener {
    private final ChipTextInputComboView hourLayoutComboView;
    private boolean keyListenerRunning = false;
    private final ChipTextInputComboView minuteLayoutComboView;
    private final TimeModel time;

    TimePickerTextInputKeyController(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.hourLayoutComboView = chipTextInputComboView;
        this.minuteLayoutComboView = chipTextInputComboView2;
        this.time = timeModel;
    }

    private void moveSelection(int i) {
        boolean z = true;
        this.minuteLayoutComboView.setChecked(i == 12);
        ChipTextInputComboView chipTextInputComboView = this.hourLayoutComboView;
        if (i != 10) {
            z = false;
        }
        chipTextInputComboView.setChecked(z);
        this.time.selection = i;
    }

    private boolean onHourKeyPress(int i, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (!(i >= 7 && i <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2)) {
            return false;
        }
        moveSelection(12);
        return true;
    }

    private boolean onMinuteKeyPress(int i, KeyEvent keyEvent, EditText editText) {
        if (!(i == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText()))) {
            return false;
        }
        moveSelection(10);
        return true;
    }

    public void bind() {
        TextInputLayout textInput = this.hourLayoutComboView.getTextInput();
        TextInputLayout textInput2 = this.minuteLayoutComboView.getTextInput();
        EditText editText = textInput.getEditText();
        EditText editText2 = textInput2.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = i == 5;
        if (z) {
            moveSelection(12);
        }
        return z;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        boolean z;
        if (this.keyListenerRunning) {
            return false;
        }
        this.keyListenerRunning = true;
        EditText editText = (EditText) view;
        if (this.time.selection == 12) {
            z = onMinuteKeyPress(i, keyEvent, editText);
        } else {
            z = onHourKeyPress(i, keyEvent, editText);
        }
        this.keyListenerRunning = false;
        return z;
    }
}
