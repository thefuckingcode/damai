package com.alibaba.aliweex.adapter.component;

import android.widget.ImageView;
import androidx.annotation.RestrictTo;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.dom.WXImageQuality;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXVContainer;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
public class AliGifImage extends AliWXImage {

    /* compiled from: Taobao */
    public static class a implements ComponentCreator {
        /* renamed from: a */
        public AliGifImage createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new AliGifImage(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    public AliGifImage(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXImage
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public WXImageQuality getImageQuality() {
        return WXImageQuality.ORIGINAL;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXImage
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ImageView.ScaleType getResizeMode(String str) {
        return ImageView.ScaleType.FIT_CENTER;
    }
}
