package com.taobao.android.dinamicx.view.richtext.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate;

/* compiled from: Taobao */
public class CloneableNoStyleClickSpan extends ClickableSpan implements PublicCloneable {
    private ClickSpanDelegate mClickDelegate;

    @Override // java.lang.Object, com.taobao.android.dinamicx.view.richtext.span.PublicCloneable
    @NonNull
    public Object clone() {
        CloneableNoStyleClickSpan cloneableNoStyleClickSpan = new CloneableNoStyleClickSpan();
        cloneableNoStyleClickSpan.mClickDelegate = this.mClickDelegate;
        return cloneableNoStyleClickSpan;
    }

    public ClickSpanDelegate getClickDelegate() {
        return this.mClickDelegate;
    }

    public void onClick(@NonNull View view) {
        ClickSpanDelegate clickSpanDelegate = this.mClickDelegate;
        if (clickSpanDelegate != null) {
            clickSpanDelegate.onClick(view);
        }
    }

    public void setClickDelegate(ClickSpanDelegate clickSpanDelegate) {
        this.mClickDelegate = clickSpanDelegate;
    }

    public void updateDrawState(@NonNull TextPaint textPaint) {
    }
}
