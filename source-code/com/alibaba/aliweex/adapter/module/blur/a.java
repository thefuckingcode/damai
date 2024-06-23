package com.alibaba.aliweex.adapter.module.blur;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.utils.BlurTool;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
class a implements BlurAlgorithm {
    private boolean a = false;

    a(boolean z) {
        this.a = z;
    }

    @Override // com.alibaba.aliweex.adapter.module.blur.BlurAlgorithm
    @Nullable
    public Bitmap blur(Bitmap bitmap, int i) {
        int max = Math.max(0, Math.min(100, i));
        long j = 0;
        long currentTimeMillis = WXEnvironment.isApkDebugable() ? System.currentTimeMillis() : 0;
        Bitmap bitmap2 = null;
        try {
            bitmap2 = BlurTool.f(bitmap, max, this.a);
        } catch (Exception e) {
            WXLogUtils.e("StackBlur", e.getMessage());
        }
        if (WXEnvironment.isApkDebugable()) {
            j = System.currentTimeMillis();
        }
        WXLogUtils.d("StackBlur", "blur time:" + (j - currentTimeMillis) + "ms");
        return bitmap2;
    }

    @Override // com.alibaba.aliweex.adapter.module.blur.BlurAlgorithm
    public boolean canModifyBitmap() {
        return this.a;
    }

    @Override // com.alibaba.aliweex.adapter.module.blur.BlurAlgorithm
    @NonNull
    public Bitmap.Config getSupportedBitmapConfig() {
        return Bitmap.Config.ARGB_8888;
    }
}
