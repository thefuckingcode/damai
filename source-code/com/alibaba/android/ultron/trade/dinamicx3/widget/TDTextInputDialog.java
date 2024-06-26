package com.alibaba.android.ultron.trade.dinamicx3.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.alibaba.android.ultron.trade.R$id;
import com.alibaba.android.ultron.trade.R$layout;
import tb.di2;
import tb.i80;

/* compiled from: Taobao */
public class TDTextInputDialog extends AlertDialog {
    private EditText a;
    private EditText b;
    private String c = "";
    private OnClickListener d;
    private OnClickListener e;

    /* compiled from: Taobao */
    public interface OnClickListener {
        void onClick(DialogInterface dialogInterface, CharSequence charSequence);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            TDTextInputDialog.this.dismiss();
            if (TDTextInputDialog.this.b != null && TDTextInputDialog.this.d != null) {
                OnClickListener onClickListener = TDTextInputDialog.this.d;
                TDTextInputDialog tDTextInputDialog = TDTextInputDialog.this;
                onClickListener.onClick(tDTextInputDialog, tDTextInputDialog.b.getText());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            TDTextInputDialog.this.dismiss();
            if (TDTextInputDialog.this.b != null && TDTextInputDialog.this.e != null) {
                Editable text = TDTextInputDialog.this.b.getText();
                TDTextInputDialog.this.a.setText(text);
                TDTextInputDialog.this.e.onClick(TDTextInputDialog.this, text);
            }
        }
    }

    public TDTextInputDialog(Context context) {
        super(context);
    }

    private void e() {
        EditText editText = this.a;
        if (editText != null && this.b != null) {
            Object tag = editText.getTag(di2.ID_KEY_BOARD);
            if (tag instanceof Integer) {
                i80.c(this.b, ((Integer) tag).intValue());
            }
            Object tag2 = this.a.getTag(di2.ID_MAX_LENGTH);
            if (tag2 instanceof Integer) {
                i80.d(this.b, ((Integer) tag2).intValue());
            }
            Object tag3 = this.a.getTag(di2.ID_PLACE_HOLDER);
            if (tag3 != null) {
                i80.a(this.b, tag3.toString());
            }
            Object tag4 = this.a.getTag(di2.ID_PLACE_HOLDER_COLOR);
            if (tag4 instanceof Integer) {
                i80.b(this.b, ((Integer) tag4).intValue());
            }
            Object tag5 = this.a.getTag(di2.ID_TV_TEXT);
            if (tag5 != null) {
                String obj = tag5.toString();
                this.c = obj;
                i80.e(this.b, obj);
            }
            Editable text = this.b.getText();
            if (!TextUtils.isEmpty(text)) {
                this.b.setSelection(text.length());
            }
        }
    }

    private void f(Context context) {
        setContentView(R$layout.trade_text_input);
        this.b = (EditText) findViewById(R$id.et_input);
        findViewById(R$id.tv_cancel).setOnClickListener(new a());
        findViewById(R$id.tv_confirm).setOnClickListener(new b());
    }

    private void g() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(17170445);
        window.clearFlags(131072);
        window.setSoftInputMode(5);
    }

    public void dismiss() {
        super.dismiss();
    }

    public void h(EditText editText) {
        this.a = editText;
        e();
    }

    public void i(OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public void show() {
        super.show();
        f(getContext());
        g();
        e();
    }
}
