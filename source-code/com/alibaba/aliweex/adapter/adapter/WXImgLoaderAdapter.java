package com.alibaba.aliweex.adapter.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.adapter.IGodEyeStageAdapter;
import com.alibaba.aliweex.interceptor.phenix.PhenixTracker;
import com.alibaba.aliweex.utils.BlurTool;
import com.alibaba.gaiax.GXTemplateEngine;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.ImageStrategyDecider;
import com.taobao.tao.util.TaobaoImageUrlStrategy;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;
import com.taobao.weex.ui.view.WXImageView;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import tb.cq1;
import tb.kx2;
import tb.qg0;
import tb.tp1;
import tb.ug2;
import tb.vp1;

/* compiled from: Taobao */
public class WXImgLoaderAdapter implements IWXImgLoaderAdapter {
    public static final String TRUE = "true";
    public static final String WX_ALLOW_RELEASE_DOMAIN = "allow_active_release";
    public static final String WX_IMAGE_RELEASE_CONFIG = "android_aliweex_image_release";
    private static boolean b = true;
    private PhenixTracker a = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[WXImageQuality.values().length];
            a = iArr;
            iArr[WXImageQuality.LOW.ordinal()] = 1;
            a[WXImageQuality.NORMAL.ordinal()] = 2;
            try {
                a[WXImageQuality.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    static class b implements IPhenixListener<qg0> {
        private WXImageStrategy a;
        private WeakReference<ImageView> b;
        private String c;
        private PhenixTracker d;

        b(WXImageStrategy wXImageStrategy, ImageView imageView, String str, PhenixTracker phenixTracker) {
            this.a = wXImageStrategy;
            this.b = new WeakReference<>(imageView);
            this.c = str;
            this.d = phenixTracker;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0092  */
        /* renamed from: a */
        public boolean onHappen(qg0 qg0) {
            String str;
            PhenixTracker phenixTracker;
            WXSDKInstance y = WXSDKManager.v().y(this.a.instanceId);
            if (y != null) {
                y.getApmForInstance().b(false, String.valueOf(qg0.f()));
            }
            ImageView imageView = this.b.get();
            if (imageView == null) {
                return false;
            }
            if (WXImgLoaderAdapter.b && qg0 != null) {
                try {
                    str = "resultCode:" + qg0.f() + ',' + "httpCode:" + qg0.d() + ',' + "httpMessage" + qg0.e();
                } catch (Throwable unused) {
                    boolean unused2 = WXImgLoaderAdapter.b = false;
                }
                WXImgLoaderAdapter.i("weex-image-Fail", this.c, str);
                imageView.setTag(-308, "ERROR");
                if (this.a.getImageListener() != null) {
                    this.a.getImageListener().onImageFinish(this.c, imageView, false, null);
                }
                phenixTracker = this.d;
                if (phenixTracker != null) {
                    phenixTracker.k(qg0);
                }
                return false;
            }
            str = "";
            WXImgLoaderAdapter.i("weex-image-Fail", this.c, str);
            imageView.setTag(-308, "ERROR");
            if (this.a.getImageListener() != null) {
            }
            phenixTracker = this.d;
            if (phenixTracker != null) {
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    static class c implements IPhenixListener<ug2> {
        private WXImageStrategy a;
        private WeakReference<ImageView> b;
        private String c;
        private PhenixTracker d;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a implements BlurTool.OnBlurCompleteListener {
            final /* synthetic */ ImageView a;
            final /* synthetic */ Drawable b;

            a(c cVar, ImageView imageView, Drawable drawable) {
                this.a = imageView;
                this.b = drawable;
            }

            @Override // com.alibaba.aliweex.utils.BlurTool.OnBlurCompleteListener
            public void onBlurComplete(@NonNull Bitmap bitmap) {
                try {
                    this.a.setImageDrawable(new BitmapDrawable(this.a.getContext().getResources(), bitmap));
                } catch (Exception e) {
                    try {
                        WXLogUtils.e(e.getMessage());
                        this.a.setImageDrawable(this.b);
                    } catch (Exception e2) {
                        WXLogUtils.e(e2.getMessage());
                    }
                }
            }
        }

        c(WXImageStrategy wXImageStrategy, ImageView imageView, String str, PhenixTracker phenixTracker) {
            this.a = wXImageStrategy;
            this.b = new WeakReference<>(imageView);
            this.c = str;
            this.d = phenixTracker;
        }

        /* renamed from: a */
        public boolean onHappen(ug2 ug2) {
            WXSDKInstance y = WXSDKManager.v().y(this.a.instanceId);
            if (y != null) {
                y.getApmForInstance().b(true, null);
            }
            BitmapDrawable f = ug2.f();
            ImageView imageView = this.b.get();
            if (imageView == null) {
                return false;
            }
            String str = this.c;
            StringBuilder sb = new StringBuilder();
            sb.append("drawable is null?");
            sb.append(f == null);
            WXImgLoaderAdapter.i("weex-image-success", str, sb.toString());
            imageView.setTag(-308, GXTemplateEngine.b.STATE_END);
            if (f != null) {
                if ((imageView instanceof WXImageView) && (f instanceof AnimatedImageDrawable)) {
                    ((WXImageView) imageView).setImageDrawable(f, true);
                } else if (this.a.blurRadius <= 0) {
                    imageView.setImageDrawable(f);
                } else if (f.getBitmap() != null) {
                    BlurTool.b(f.getBitmap(), this.a.blurRadius, new a(this, imageView, f));
                } else {
                    try {
                        imageView.setImageDrawable(f);
                    } catch (Exception e) {
                        WXLogUtils.e(e.getMessage());
                    }
                }
                if (!ug2.i() && this.a.getImageListener() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("drawable", new WeakReference(f));
                    this.a.getImageListener().onImageFinish(this.c, imageView, true, hashMap);
                }
            }
            PhenixTracker phenixTracker = this.d;
            if (phenixTracker != null) {
                phenixTracker.l(ug2);
            }
            return false;
        }
    }

    private ImageStrategyConfig g(boolean z, WXImageQuality wXImageQuality) {
        ImageStrategyConfig.b p = ImageStrategyConfig.p(z ? ImageStrategyConfig.WEAPPSHARPEN : ImageStrategyConfig.WEAPP, 70);
        if (wXImageQuality != null) {
            int i = a.a[wXImageQuality.ordinal()];
            if (i == 1) {
                p.c(TaobaoImageUrlStrategy.ImageQuality.q50);
            } else if (i == 2) {
                p.c(TaobaoImageUrlStrategy.ImageQuality.q75);
            } else if (i == 3) {
                p.c(TaobaoImageUrlStrategy.ImageQuality.q90);
            }
        }
        return p.a();
    }

    /* access modifiers changed from: private */
    public static void i(String str, String str2, String str3) {
        IGodEyeStageAdapter h;
        IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
        if ((c2 == null || Boolean.valueOf(c2.getConfig(kx2.WXAPM_CONFIG_GROUP, "recordImageState", "true")).booleanValue()) && (h = com.alibaba.aliweex.a.l().h()) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str2);
            hashMap.put("msg", str3);
            h.onStage(str, hashMap);
        }
    }

    public String f(ImageView imageView, String str, boolean z, WXImageQuality wXImageQuality) {
        int i;
        int i2;
        ImageStrategyConfig g = g(z, wXImageQuality);
        if (g == null) {
            return str;
        }
        if (imageView.getLayoutParams() != null) {
            i = imageView.getLayoutParams().height;
            i2 = imageView.getLayoutParams().width;
        } else {
            i = imageView.getHeight();
            i2 = imageView.getWidth();
        }
        return ImageStrategyDecider.decideUrl(str, Integer.valueOf(i2), Integer.valueOf(i), g);
    }

    public String h(ImageView imageView, String str, WXImageQuality wXImageQuality, WXImageStrategy wXImageStrategy) {
        return (imageView == null || TextUtils.isEmpty(str) || wXImageQuality == WXImageQuality.ORIGINAL) ? str : f(imageView, str, wXImageStrategy.isSharpen, wXImageQuality);
    }

    @Override // com.taobao.weex.adapter.IWXImgLoaderAdapter
    public void setImage(@Nullable final String str, @Nullable final ImageView imageView, final WXImageQuality wXImageQuality, final WXImageStrategy wXImageStrategy) {
        WXSDKManager.v().N(new Runnable() {
            /* class com.alibaba.aliweex.adapter.adapter.WXImgLoaderAdapter.AnonymousClass1 */

            public void run() {
                String str;
                ImageView imageView = imageView;
                if (imageView != null) {
                    if (imageView.getTag() instanceof cq1) {
                        ((cq1) imageView.getTag()).cancel();
                    }
                    if (TextUtils.isEmpty(str)) {
                        imageView.setImageDrawable(null);
                        return;
                    }
                    WXSDKInstance y = WXSDKManager.v().y(wXImageStrategy.instanceId);
                    if (y != null) {
                        y.getApmForInstance().a();
                        str = y.getBundleUrl();
                    } else {
                        str = null;
                    }
                    String h = WXImgLoaderAdapter.this.h(imageView, str, wXImageQuality, wXImageStrategy);
                    if (!TextUtils.isEmpty(wXImageStrategy.placeHolder)) {
                        tp1.o().s(wXImageStrategy.placeHolder).n();
                    }
                    if (WXEnvironment.isApkDebugable() && WXImgLoaderAdapter.this.a == null) {
                        WXImgLoaderAdapter.this.a = PhenixTracker.j();
                    }
                    vp1 f = tp1.o().s(h).O(wXImageStrategy.placeHolder).A(imageView).K(true).f("bundle_biz_code", Integer.toString(70));
                    if (!TextUtils.isEmpty(str)) {
                        f.f("pageURL", str);
                    }
                    IConfigAdapter c = com.alibaba.aliweex.a.l().c();
                    if (c != null) {
                        String config = c.getConfig(WXImgLoaderAdapter.WX_IMAGE_RELEASE_CONFIG, WXImgLoaderAdapter.WX_ALLOW_RELEASE_DOMAIN, "");
                        if (TextUtils.isEmpty(config) || !TextUtils.equals("true", config)) {
                            f.K(false);
                        }
                    }
                    WXImgLoaderAdapter.i("weex-image-start", str, null);
                    f.Q(new c(wXImageStrategy, imageView, str, WXImgLoaderAdapter.this.a));
                    f.m(new b(wXImageStrategy, imageView, str, WXImgLoaderAdapter.this.a));
                    imageView.setTag(-308, GXTemplateEngine.b.STATE_START);
                    if (WXImgLoaderAdapter.this.a != null) {
                        HashMap hashMap = new HashMap();
                        if (WXEnvironment.isApkDebugable()) {
                            hashMap.put(Constants.Name.QUALITY, wXImageQuality.name());
                            hashMap.put("bundle_biz_code", String.valueOf(70));
                            hashMap.put(Constants.Name.SHARPEN, String.valueOf(wXImageStrategy.isSharpen));
                            hashMap.put("blurRaduis", String.valueOf(wXImageStrategy.blurRadius));
                            hashMap.put(Constants.Name.PLACE_HOLDER, wXImageStrategy.placeHolder);
                        }
                        WXImgLoaderAdapter.this.a.m(f, hashMap);
                    }
                    imageView.setTag(f.n());
                }
            }
        }, 0);
    }
}
