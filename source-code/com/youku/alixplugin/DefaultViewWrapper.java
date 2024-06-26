package com.youku.alixplugin;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import com.youku.alixplugin.layer.LMLayerInfo;
import com.youku.kubus.NoProguard;

@NoProguard
@Keep
/* compiled from: Taobao */
public class DefaultViewWrapper extends ParentViewGroupLayer {
    public DefaultViewWrapper(Context context, LMLayerInfo lMLayerInfo) {
        super(context, lMLayerInfo);
        initViews(context);
    }

    private void initViews(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setContentDescription("DefaultViewWrapper");
        this.rootViewGroup = frameLayout;
    }
}
