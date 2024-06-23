package com.taobao.android.dinamicx.view.richtext.node;

import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: Taobao */
public interface RichTextNode {

    /* compiled from: Taobao */
    public interface OnLinkTapListener {
        void onLinkTap(String str);
    }

    /* compiled from: Taobao */
    public interface OnLongPressListener {
        boolean onLongPress(String str);
    }

    /* compiled from: Taobao */
    public interface OnLongTapListener {
        void onLongTap();
    }

    /* compiled from: Taobao */
    public interface OnTapListener {
        void onTap();
    }

    @NonNull
    String getText();

    @NonNull
    List<Object> toSpans();

    @NonNull
    List<Object> toSpans(boolean z);
}
