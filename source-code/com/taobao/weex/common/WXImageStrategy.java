package com.taobao.weex.common;

import android.widget.ImageView;
import java.util.Map;

/* compiled from: Taobao */
public class WXImageStrategy {
    public int blurRadius;
    ImageListener imageListener;
    public String instanceId;
    @Deprecated
    public boolean isClipping;
    public boolean isSharpen;
    public String placeHolder;

    /* compiled from: Taobao */
    public interface ImageListener {
        void onImageFinish(String str, ImageView imageView, boolean z, Map map);
    }

    public WXImageStrategy() {
    }

    public ImageListener getImageListener() {
        return this.imageListener;
    }

    public void setImageListener(ImageListener imageListener2) {
        this.imageListener = imageListener2;
    }

    public WXImageStrategy(String str) {
        this.instanceId = str;
    }
}
