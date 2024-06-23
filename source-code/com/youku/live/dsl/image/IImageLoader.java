package com.youku.live.dsl.image;

import android.widget.ImageView;

/* compiled from: Taobao */
public interface IImageLoader {
    IImageLoader blur(int i);

    IImageLoader circle();

    IImageLoader into(ImageView imageView);

    IImageLoader loadUrl(String str);

    IImageLoader round(int i);
}
