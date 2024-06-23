package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.a;
import com.alibaba.aliweex.adapter.adapter.WXImgLoaderAdapter;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.ui.view.WXImageView;
import tb.cq1;
import tb.pz1;

/* compiled from: Taobao */
public class AliWXImageView extends WXImageView implements Destroyable {
    private pz1 reference;

    public AliWXImageView(Context context) {
        super(context);
    }

    private void releaseDrawable() {
        pz1 pz1 = this.reference;
        if (pz1 != null) {
            pz1.k();
            this.reference = null;
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        try {
            if (getTag() instanceof cq1) {
                ((cq1) getTag()).cancel();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        releaseDrawable();
    }

    @Override // com.taobao.weex.ui.view.WXImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        releaseDrawable();
        super.setImageDrawable(drawable);
        if (drawable instanceof pz1) {
            String config = a.l().c().getConfig(WXImgLoaderAdapter.WX_IMAGE_RELEASE_CONFIG, WXImgLoaderAdapter.WX_ALLOW_RELEASE_DOMAIN, "");
            if (!TextUtils.isEmpty(config) && TextUtils.equals("true", config)) {
                this.reference = (pz1) drawable;
            }
        }
    }
}
