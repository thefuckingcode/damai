package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.widget.ImageView;
import com.taobao.android.dinamicx.widget.DXImageWidgetNode;

/* compiled from: Taobao */
public interface IDXWebImageInterface {
    ImageView buildView(Context context);

    void setImage(ImageView imageView, String str, DXImageWidgetNode.c cVar);
}
