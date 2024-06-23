package com.taobao.android.dinamicx.widget;

import android.content.Context;
import com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode;

/* compiled from: Taobao */
public interface IDXRichTextImageInterface {
    void downloadImage(Context context, String str, DXImageSpanWidgetNode.ImageLoadCallback imageLoadCallback);
}
