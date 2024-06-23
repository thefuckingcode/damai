package com.taobao.uikit.extend.feature.features;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.phenix.intf.event.IRetryHandlerOnFailure;
import com.taobao.phenix.loader.network.HttpCodeResponseException;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.ImageStrategyDecider;
import com.taobao.tao.util.TBImageUrlStrategy;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.taobao.uikit.feature.callback.LayoutCallback;
import com.taobao.uikit.feature.features.AbsFeature;
import com.taobao.uikit.image.R;
import com.taobao.uikit.utils.UIKITLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import tb.cq1;
import tb.fc1;
import tb.i42;
import tb.j22;
import tb.qg0;
import tb.r02;
import tb.so1;
import tb.tp1;
import tb.ug2;
import tb.v;
import tb.vp1;

/* compiled from: Taobao */
public class ImageLoadFeature extends AbsFeature<ImageView> implements LayoutCallback {
    private static final int L_SCROLLING = 1;
    private static final int L_SHOWING = 0;
    private static final int S_DONE_FAIL = 3;
    private static final int S_DONE_SUC = 2;
    private static final int S_INIT = 0;
    private static final int S_LOADING = 1;
    private static final int S_LOAD_IMMEDIATE = 4;
    protected ObjectAnimator mAlphaAnim;
    private String mCacheKey4PlaceHolder;
    private Context mContext;
    private boolean mEnableSizeInLayoutParams;
    private boolean mEnabledLoadOnFling = true;
    private int mErrorImageId;
    protected boolean mFadeIn;
    private ImageLoadFailListener mFailListener = new ImageLoadFailListener();
    private TUrlImageView.FinalUrlInspector mFinalUrlInspector;
    private PhenixOptions mGlobalPhenixOptions;
    private WeakReference<ImageView> mHostReference;
    private int mKeepBackgroundState;
    private int mLastMaxViewSize;
    private cq1 mLastResTicket;
    protected int mLoadState = 0;
    protected String mLoadingUrl = "";
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private IPhenixListener<fc1> mMemoryMissListener = new IPhenixListener<fc1>() {
        /* class com.taobao.uikit.extend.feature.features.ImageLoadFeature.AnonymousClass1 */

        public boolean onHappen(fc1 fc1) {
            ImageLoadFeature imageLoadFeature = ImageLoadFeature.this;
            int i = imageLoadFeature.mLoadState;
            imageLoadFeature.fillImageDrawable(imageLoadFeature.getHost(), null, false, ImageLoadFeature.this.mWhenNullClearImg);
            ImageLoadFeature.this.mLoadState = i;
            return false;
        }
    };
    private PhenixOptions mNextPhenixOptions;
    private boolean mNoRepeatOnError = true;
    private Drawable mPlaceHoldForeground;
    protected int mPlaceHoldResourceId;
    private String mPriorityModuleName;
    private ImageRetryHandler mRetryHandler = new ImageRetryHandler();
    private int mScrollState = 0;
    private Boolean mSkipAutoSize;
    private ImageStrategyConfig mStrategyConfig;
    private ImageLoadSuccListener mSuccListener = new ImageLoadSuccListener();
    private cq1 mTicket;
    private String mUrl;
    private boolean mUserCalledSetImageUrl = false;
    protected IPhenixListener<qg0> mUserFailListener;
    protected IPhenixListener<ug2> mUserSuccListener;
    private boolean mWhenNullClearImg = true;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class ImageLoadFailListener implements IPhenixListener<qg0> {
        vp1 mCreator;

        ImageLoadFailListener() {
        }

        public boolean onHappen(qg0 qg0) {
            UIKITLog.d(TUrlImageView.LOG_TAG, "load image failed, state=%d, url=%s", Integer.valueOf(ImageLoadFeature.this.mLoadState), ImageLoadFeature.this.mUrl);
            int f = qg0.f();
            if (f == -1 || f == 404) {
                ImageLoadFeature.this.mNoRepeatOnError = true;
            } else {
                ImageLoadFeature.this.mNoRepeatOnError = false;
            }
            qg0.a().b(true);
            ImageLoadFeature imageLoadFeature = ImageLoadFeature.this;
            imageLoadFeature.fillImageDrawable(imageLoadFeature.getHost(), null, true, ImageLoadFeature.this.mWhenNullClearImg);
            ImageLoadFeature imageLoadFeature2 = ImageLoadFeature.this;
            imageLoadFeature2.mLoadState = 3;
            IPhenixListener<qg0> iPhenixListener = imageLoadFeature2.mUserFailListener;
            if (iPhenixListener != null) {
                iPhenixListener.onHappen(qg0);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("resultCode", String.valueOf(qg0.f()));
            hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("oriUrl", ImageLoadFeature.this.mUrl);
            TBImageLifeCycleMonitor a = TBImageLifeCycleMonitor.a();
            vp1 vp1 = this.mCreator;
            a.onError(vp1 != null ? String.valueOf(vp1.x()) : "", qg0.b(), hashMap);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class ImageLoadSuccListener implements IPhenixListener<ug2> {
        private boolean isInLayoutPass;
        vp1 mCreator;

        ImageLoadSuccListener() {
        }

        public boolean applyEvent(final ug2 ug2, boolean z) {
            String str;
            String b = ug2.b();
            if (b == null || (str = ImageLoadFeature.this.mLoadingUrl) == null || b.startsWith(str)) {
                final ImageView host = ImageLoadFeature.this.getHost();
                if (host == null) {
                    ImageLoadFeature.this.mLoadState = 3;
                    return false;
                } else if (!z || !this.isInLayoutPass) {
                    ImageLoadFeature.this.mLoadState = 3;
                    BitmapDrawable f = ug2.f();
                    if (f == null) {
                        ImageLoadFeature imageLoadFeature = ImageLoadFeature.this;
                        imageLoadFeature.fillImageDrawable(host, null, false, imageLoadFeature.mWhenNullClearImg);
                        return true;
                    }
                    boolean i = ug2.i();
                    ImageLoadFeature imageLoadFeature2 = ImageLoadFeature.this;
                    boolean z2 = imageLoadFeature2.mFadeIn;
                    if (imageLoadFeature2.isViewBitmapDifferentWith(host, f.getBitmap())) {
                        z2 = false;
                    }
                    if (z || i || !z2 || ImageLoadFeature.this.mLoadState == 2) {
                        ImageLoadFeature imageLoadFeature3 = ImageLoadFeature.this;
                        imageLoadFeature3.fillImageDrawable(host, f, false, imageLoadFeature3.mWhenNullClearImg);
                    } else {
                        host.setImageDrawable(f);
                        ImageLoadFeature imageLoadFeature4 = ImageLoadFeature.this;
                        ObjectAnimator objectAnimator = imageLoadFeature4.mAlphaAnim;
                        if (objectAnimator == null) {
                            imageLoadFeature4.mAlphaAnim = ObjectAnimator.ofInt(host, "alpha", 0, 255);
                            ImageLoadFeature.this.mAlphaAnim.setInterpolator(new AccelerateInterpolator());
                            ImageLoadFeature.this.mAlphaAnim.setDuration(300L);
                            ImageLoadFeature.this.mAlphaAnim.addListener(new AnimatorListenerAdapter() {
                                /* class com.taobao.uikit.extend.feature.features.ImageLoadFeature.ImageLoadSuccListener.AnonymousClass2 */

                                public void onAnimationEnd(Animator animator) {
                                    if (ImageLoadFeature.this.mKeepBackgroundState < 0 || (ImageLoadFeature.this.mKeepBackgroundState == 0 && ImageLoadFeature.this.mPlaceHoldResourceId != 0)) {
                                        host.setBackgroundDrawable(null);
                                    }
                                }
                            });
                            ImageLoadFeature.this.mAlphaAnim.start();
                        } else if (!objectAnimator.isRunning()) {
                            ImageLoadFeature.this.mAlphaAnim.start();
                        }
                    }
                    if (!i) {
                        ug2.a().b(true);
                        ImageLoadFeature imageLoadFeature5 = ImageLoadFeature.this;
                        imageLoadFeature5.mLoadState = 2;
                        IPhenixListener<ug2> iPhenixListener = imageLoadFeature5.mUserSuccListener;
                        if (iPhenixListener != null) {
                            iPhenixListener.onHappen(ug2);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("intermediate", Boolean.valueOf(i));
                    hashMap.put(v.TAK_ABILITY_SHOW_POP_ANIMATION, Boolean.valueOf(z2));
                    hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
                    TBImageLifeCycleMonitor a = TBImageLifeCycleMonitor.a();
                    vp1 vp1 = this.mCreator;
                    a.onFinished(vp1 != null ? String.valueOf(vp1.x()) : "", b, hashMap);
                    return true;
                } else {
                    host.post(new Runnable() {
                        /* class com.taobao.uikit.extend.feature.features.ImageLoadFeature.ImageLoadSuccListener.AnonymousClass1 */

                        public void run() {
                            ImageLoadSuccListener.this.applyEvent(ug2, false);
                        }
                    });
                    return true;
                }
            } else {
                UIKITLog.w(TUrlImageView.LOG_TAG, "callback url not match target url, callback=%s, target=%s", b, ImageLoadFeature.this.mLoadingUrl);
                return true;
            }
        }

        public void setIsInLayoutPass(boolean z) {
            this.isInLayoutPass = z;
        }

        public boolean onHappen(ug2 ug2) {
            return applyEvent(ug2, ug2.h());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class ImageRetryHandler implements IRetryHandlerOnFailure {
        private String retryUrl;

        ImageRetryHandler() {
        }

        @Override // com.taobao.phenix.intf.event.IRetryHandlerOnFailure
        public String getRetryUrl(vp1 vp1, Throwable th) {
            if (!(th instanceof HttpCodeResponseException) || ((HttpCodeResponseException) th).getHttpCode() != 404) {
                return null;
            }
            ImageLoadFeature imageLoadFeature = ImageLoadFeature.this;
            String str = this.retryUrl;
            imageLoadFeature.mLoadingUrl = str;
            return str;
        }

        public ImageRetryHandler setRetryUrl(String str) {
            if (str == null || !str.endsWith(TBImageUrlStrategy.END_IMAGE_URL)) {
                this.retryUrl = str;
            } else {
                this.retryUrl = str.substring(0, str.length() - 13);
            }
            return this;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fillImageDrawable(ImageView imageView, BitmapDrawable bitmapDrawable, boolean z, boolean z2) {
        Drawable drawable;
        if (imageView != null) {
            cq1 cq1 = this.mLastResTicket;
            if (cq1 != null) {
                cq1.cancel();
                this.mLastResTicket = null;
            }
            if (bitmapDrawable != null) {
                imageView.setImageDrawable(bitmapDrawable);
                int i = this.mKeepBackgroundState;
                if (i < 0 || (i == 0 && this.mPlaceHoldResourceId != 0)) {
                    imageView.setBackgroundDrawable(null);
                }
            } else if (z && z2) {
                imageView.setImageDrawable(null);
                int i2 = this.mErrorImageId;
                if (i2 == 0) {
                    i2 = this.mPlaceHoldResourceId;
                }
                placeBgResImage(i2);
            } else if ((z2 || isViewDrawableSameWith(imageView, null)) && (drawable = this.mPlaceHoldForeground) != null) {
                imageView.setImageDrawable(drawable);
            } else if (z2) {
                imageView.setImageDrawable(null);
                placeBgResImage(this.mPlaceHoldResourceId);
            }
        }
    }

    private String getPriorityModuleName() {
        PhenixOptions phenixOptions = this.mNextPhenixOptions;
        if (phenixOptions != null) {
            return phenixOptions.priorityModuleName;
        }
        String str = this.mPriorityModuleName;
        if (str != null) {
            return str;
        }
        PhenixOptions phenixOptions2 = this.mGlobalPhenixOptions;
        if (phenixOptions2 != null) {
            return phenixOptions2.priorityModuleName;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isViewBitmapDifferentWith(ImageView imageView, Bitmap bitmap) {
        if (imageView instanceof TUrlImageView) {
            return ((TUrlImageView) imageView).isViewBitmapDifferentWith(bitmap);
        }
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            return (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() != bitmap;
        }
    }

    private boolean isViewDrawableSameWith(ImageView imageView, Drawable drawable) {
        if (imageView instanceof TUrlImageView) {
            return ((TUrlImageView) imageView).isDrawableSameWith(drawable);
        }
        return imageView != null && imageView.getDrawable() == drawable;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055  */
    private boolean loadImageIfNecessary(boolean z) {
        boolean z2;
        boolean z3;
        Boolean bool;
        int i;
        int i2;
        ImageView host = getHost();
        if (host == null) {
            return false;
        }
        int width = host.getWidth();
        int height = host.getHeight();
        ViewGroup.LayoutParams layoutParams = host.getLayoutParams();
        if (layoutParams != null) {
            if (this.mEnableSizeInLayoutParams && (i = layoutParams.width) > 0 && (i2 = layoutParams.height) > 0) {
                this.mLastMaxViewSize = Math.max(i, i2);
                width = i;
                height = i2;
            } else if (layoutParams.height == -2 && layoutParams.width == -2) {
                z2 = true;
                if (width != 0 && height == 0 && !z2) {
                    return false;
                }
                if (!TextUtils.isEmpty(this.mUrl)) {
                    cq1 cq1 = this.mTicket;
                    if (cq1 != null) {
                        cq1.cancel();
                    }
                    fillImageDrawable(host, null, false, this.mUserCalledSetImageUrl);
                    return false;
                }
                cq1 cq12 = this.mTicket;
                if (cq12 != null && !cq12.theSame(this.mUrl)) {
                    this.mTicket.cancel();
                }
                if (this.mNoRepeatOnError || this.mLoadState != 0) {
                    return false;
                }
                if (this.mScrollState != 1) {
                    z3 = false;
                } else if (!this.mEnabledLoadOnFling) {
                    return false;
                } else {
                    z3 = true;
                }
                String str = this.mUrl;
                if ((this.mSkipAutoSize == null && !TUrlImageView.isAutoSizeSkippedGlobally()) || ((bool = this.mSkipAutoSize) != null && !bool.booleanValue())) {
                    str = ImageStrategyDecider.decideUrl(this.mUrl, Integer.valueOf(width), Integer.valueOf(height), this.mStrategyConfig);
                }
                TUrlImageView.FinalUrlInspector finalUrlInspector = this.mFinalUrlInspector;
                if (finalUrlInspector != null) {
                    str = finalUrlInspector.inspectFinalUrl(str, width, height);
                }
                TUrlImageView.FinalUrlInspector globalFinalUrlInspector = TUrlImageView.getGlobalFinalUrlInspector();
                if (globalFinalUrlInspector != null) {
                    str = globalFinalUrlInspector.inspectFinalUrl(str, width, height);
                }
                this.mLoadingUrl = str;
                this.mSuccListener.setIsInLayoutPass(z);
                this.mLoadState = z3 ? 4 : 1;
                PhenixOptions phenixOptions = this.mNextPhenixOptions;
                if (phenixOptions == null) {
                    phenixOptions = this.mGlobalPhenixOptions;
                }
                vp1 m = tp1.o().z(this.mContext).t(getPriorityModuleName(), str).K(true).O(this.mCacheKey4PlaceHolder).D(z3).A(host).Q(this.mSuccListener).C(this.mMemoryMissListener).m(this.mFailListener);
                this.mSuccListener.mCreator = m;
                this.mFailListener.mCreator = m;
                HashMap hashMap = new HashMap();
                hashMap.put("oriUrl", this.mUrl);
                hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
                TBImageLifeCycleMonitor.a().onRequest(String.valueOf(m.x()), str, hashMap);
                if (phenixOptions != null) {
                    m.J(phenixOptions.isOpened(1)).M(phenixOptions.isOpened(2)).h(phenixOptions.bitmapProcessors).g(phenixOptions.thumbnailType, phenixOptions.isOpened(16)).j(phenixOptions.diskCachePriority).N(phenixOptions.schedulePriority).E(phenixOptions.memoryCachePriority);
                    if (phenixOptions.isOpened(4)) {
                        m.P();
                    }
                    if (phenixOptions.isOpened(8)) {
                        m.G();
                    }
                }
                if (!this.mUrl.equals(str)) {
                    m.L(this.mRetryHandler.setRetryUrl(this.mUrl));
                    m.f("origin_url", this.mUrl);
                }
                ImageStrategyConfig imageStrategyConfig = this.mStrategyConfig;
                if (imageStrategyConfig != null) {
                    String bizIdStr = imageStrategyConfig.getBizIdStr();
                    if (TextUtils.isEmpty(bizIdStr)) {
                        bizIdStr = String.valueOf(this.mStrategyConfig.a());
                    }
                    m.f("bundle_biz_code", bizIdStr);
                }
                cq1 n = m.n();
                this.mTicket = n;
                n.c(this.mUrl);
                return false;
            }
        }
        z2 = false;
        if (width != 0) {
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
        }
    }

    private void placeBgResImage(int i) {
        ImageView host = getHost();
        if (i != 0 && host != null) {
            if (!j22.c(this.mContext, i)) {
                host.setBackgroundResource(i);
            } else {
                this.mLastResTicket = tp1.o().z(this.mContext).s(i42.r(i)).N(4).Q(new IPhenixListener<ug2>() {
                    /* class com.taobao.uikit.extend.feature.features.ImageLoadFeature.AnonymousClass3 */

                    public boolean onHappen(ug2 ug2) {
                        so1 so1;
                        ImageView host = ImageLoadFeature.this.getHost();
                        if (host == null || (so1 = (so1) ug2.f()) == null) {
                            return false;
                        }
                        NinePatchDrawable a = so1.a();
                        if (a != null) {
                            so1 = a;
                        }
                        host.setBackgroundDrawable(so1);
                        return false;
                    }
                }).n();
            }
        }
    }

    @Override // com.taobao.uikit.feature.callback.LayoutCallback
    public void afterOnLayout(boolean z, int i, int i2, int i3, int i4) {
        int max = Math.max(i3 - i, i4 - i2);
        int i5 = this.mLastMaxViewSize;
        boolean z2 = i5 > 0 && max - i5 >= 100;
        this.mLastMaxViewSize = max;
        if (z2 || this.mLoadState != 2) {
            if (z2) {
                resetState();
            }
            loadImageIfNecessary(true);
        }
    }

    @Override // com.taobao.uikit.feature.callback.LayoutCallback
    public void beforeOnLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // com.taobao.uikit.feature.features.AbsFeature
    public void constructor(Context context, AttributeSet attributeSet, int i) {
        constructor(context, attributeSet, i, null);
    }

    public void enableLoadOnFling(boolean z) {
        this.mEnabledLoadOnFling = z;
    }

    public void enableSizeInLayoutParams(boolean z) {
        this.mEnableSizeInLayoutParams = z;
    }

    public ImageLoadFeature failListener(IPhenixListener<qg0> iPhenixListener) {
        this.mUserFailListener = iPhenixListener;
        return this;
    }

    public String getImageUrl() {
        return this.mUrl;
    }

    public String getLoadingUrl() {
        return this.mLoadingUrl;
    }

    public boolean isFadeIn() {
        return this.mFadeIn;
    }

    public void keepBackgroundOnForegroundUpdate(boolean z) {
        this.mKeepBackgroundState = z ? 1 : -1;
    }

    public void pause() {
        this.mScrollState = 1;
    }

    public void reload(boolean z) {
        setImageUrl(this.mUrl, this.mCacheKey4PlaceHolder, z, true, this.mNextPhenixOptions);
    }

    public void resetState() {
        this.mLoadState = 0;
    }

    public void resume() {
        if (this.mScrollState == 1) {
            this.mScrollState = 0;
            int i = this.mLoadState;
            if (i == 0 || i == 4) {
                resetState();
                loadImageIfNecessary(false);
            }
        }
    }

    public r02 retrieveImageData() {
        String str = this.mLoadingUrl;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return tp1.o().f(getPriorityModuleName(), str, 0, false);
    }

    public void setErrorImageResId(int i) {
        this.mErrorImageId = i;
    }

    public void setFadeIn(boolean z) {
        this.mFadeIn = z;
    }

    public void setFinalUrlInspector(TUrlImageView.FinalUrlInspector finalUrlInspector) {
        this.mFinalUrlInspector = finalUrlInspector;
    }

    public void setImageUrl(String str) {
        setImageUrl(str, null, false, false, null);
    }

    public void setPhenixOptions(PhenixOptions phenixOptions) {
        this.mGlobalPhenixOptions = phenixOptions;
    }

    public void setPlaceHoldForeground(Drawable drawable) {
        this.mPlaceHoldForeground = drawable;
    }

    public void setPlaceHoldImageResId(int i) {
        this.mPlaceHoldResourceId = i;
    }

    public void setPriorityModuleName(String str) {
        this.mPriorityModuleName = str;
    }

    public void setStrategyConfig(Object obj) {
        if (obj instanceof ImageStrategyConfig) {
            this.mStrategyConfig = (ImageStrategyConfig) obj;
        }
    }

    public void setWhenNullClearImg(boolean z) {
        this.mWhenNullClearImg = z;
    }

    public boolean skipAutoSize(boolean z) {
        this.mSkipAutoSize = Boolean.valueOf(z);
        return z;
    }

    public ImageLoadFeature succListener(IPhenixListener<ug2> iPhenixListener) {
        this.mUserSuccListener = iPhenixListener;
        return this;
    }

    public void constructor(Context context, AttributeSet attributeSet, int i, boolean[] zArr) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageLoadFeature, i, 0)) != null) {
            this.mFadeIn = obtainStyledAttributes.getBoolean(R.styleable.ImageLoadFeature_uik_fade_in, false);
            int i2 = R.styleable.ImageLoadFeature_uik_skip_auto_size;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.mSkipAutoSize = Boolean.valueOf(obtainStyledAttributes.getBoolean(i2, false));
            }
            this.mWhenNullClearImg = obtainStyledAttributes.getBoolean(R.styleable.ImageLoadFeature_uik_when_null_clear_img, true);
            this.mPlaceHoldResourceId = obtainStyledAttributes.getResourceId(R.styleable.ImageLoadFeature_uik_place_hold_background, 0);
            this.mErrorImageId = obtainStyledAttributes.getResourceId(R.styleable.ImageLoadFeature_uik_error_background, 0);
            this.mPlaceHoldForeground = obtainStyledAttributes.getDrawable(R.styleable.ImageLoadFeature_uik_place_hold_foreground);
            if (zArr != null) {
                zArr[0] = obtainStyledAttributes.getBoolean(R.styleable.ImageLoadFeature_uik_auto_release_image, true);
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // com.taobao.uikit.feature.features.AbsFeature
    public ImageView getHost() {
        WeakReference<ImageView> weakReference = this.mHostReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setHost(ImageView imageView) {
        if (imageView == null) {
            this.mHostReference = null;
            this.mUserSuccListener = null;
            this.mUserFailListener = null;
            cq1 cq1 = this.mTicket;
            if (cq1 != null) {
                cq1.cancel();
                return;
            }
            return;
        }
        this.mHostReference = new WeakReference<>(imageView);
        this.mContext = imageView.getContext().getApplicationContext();
        if (!TextUtils.isEmpty(this.mUrl)) {
            loadImageIfNecessary(false);
        }
    }

    public void setImageUrl(String str, String str2, boolean z, boolean z2, PhenixOptions phenixOptions) {
        int i;
        this.mUserCalledSetImageUrl = true;
        if (z2 || (i = this.mLoadState) == 0 || i == 3 || !TextUtils.equals(this.mUrl, str) || !TextUtils.equals(this.mCacheKey4PlaceHolder, str2) || !PhenixOptions.isSame(this.mNextPhenixOptions, phenixOptions)) {
            this.mUrl = str;
            this.mCacheKey4PlaceHolder = str2;
            this.mNoRepeatOnError = false;
            resetState();
            this.mNextPhenixOptions = phenixOptions;
            ImageView host = getHost();
            if (host == null) {
                return;
            }
            if (!z) {
                loadImageIfNecessary(false);
            } else if (this.mUrl == null) {
                tp1.o().d(this.mTicket);
                fillImageDrawable(host, null, false, true);
            } else {
                this.mMainHandler.post(new Runnable() {
                    /* class com.taobao.uikit.extend.feature.features.ImageLoadFeature.AnonymousClass2 */

                    public void run() {
                        ImageLoadFeature.this.loadImageIfNecessary(false);
                    }
                });
            }
        }
    }
}
