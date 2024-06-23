package com.taobao.uikit.extend.feature.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.features.ImageLoadFeature;
import com.taobao.uikit.extend.feature.features.PhenixOptions;
import com.taobao.uikit.feature.view.TImageView;
import com.taobao.uikit.utils.UIKITLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.qg0;
import tb.r02;
import tb.so1;
import tb.ug2;

/* compiled from: Taobao */
public class TUrlImageView extends TImageView {
    public static final String LOG_TAG = "UIKitImage";
    private static Application.ActivityLifecycleCallbacks sActivityCallbacks;
    private static boolean sAutoSizeSkippedGlobally;
    private static FinalUrlInspector sGlobalFinalUrlInspector;
    public static boolean sTemporaryDrawableGetting;
    private static Map<Integer, LinkedHashMap<Integer, WeakReference<TUrlImageView>>> sViewGroupByActivity = new ConcurrentHashMap();
    private boolean mDoNotLayout;
    public boolean mEnableAutoRelease = true;
    private boolean mEnableLayoutOptimize = false;
    private ImageLoadFeature mImageLoad;
    private boolean mKeepImageIfShownInLastScreen;
    private boolean mOutWindowVisibilityChangedReally;
    private boolean mShouldRecoverOnNextVisible;

    /* compiled from: Taobao */
    public interface FinalUrlInspector {
        String inspectFinalUrl(String str, int i, int i2);
    }

    public TUrlImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initImageLoad(context, attributeSet, i);
    }

    public static FinalUrlInspector getGlobalFinalUrlInspector() {
        return sGlobalFinalUrlInspector;
    }

    private void initImageLoad(Context context, AttributeSet attributeSet, int i) {
        ImageLoadFeature imageLoadFeature = new ImageLoadFeature();
        this.mImageLoad = imageLoadFeature;
        boolean[] zArr = {true};
        imageLoadFeature.constructor(context, attributeSet, i, zArr);
        this.mEnableAutoRelease = zArr[0];
        addFeature(this.mImageLoad);
    }

    public static boolean isAutoSizeSkippedGlobally() {
        return sAutoSizeSkippedGlobally;
    }

    /* access modifiers changed from: private */
    public static void onActivityStateChanged(Activity activity, boolean z, boolean z2, boolean z3) {
        TUrlImageView tUrlImageView;
        int hashCode = activity.hashCode();
        LinkedHashMap<Integer, WeakReference<TUrlImageView>> linkedHashMap = sViewGroupByActivity.get(Integer.valueOf(hashCode));
        if (linkedHashMap != null) {
            for (Map.Entry<Integer, WeakReference<TUrlImageView>> entry : linkedHashMap.entrySet()) {
                WeakReference<TUrlImageView> value = entry.getValue();
                if (!(value == null || (tUrlImageView = value.get()) == null || !z3)) {
                    tUrlImageView.onDestroyed();
                }
            }
            if (z3) {
                sViewGroupByActivity.remove(Integer.valueOf(hashCode));
            }
        }
    }

    private void onDestroyed() {
        this.mImageLoad.setHost((ImageView) null);
    }

    private void putThisIntoViewGroup() {
        Integer num;
        Context context = getContext();
        if (context instanceof Activity) {
            num = Integer.valueOf(context.hashCode());
        } else {
            View rootView = getRootView();
            num = (rootView == null || !(rootView.getContext() instanceof Activity)) ? null : Integer.valueOf(rootView.getContext().hashCode());
        }
        if (num != null) {
            Integer valueOf = Integer.valueOf(hashCode());
            LinkedHashMap<Integer, WeakReference<TUrlImageView>> linkedHashMap = sViewGroupByActivity.get(num);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>(0, 0.75f, true);
                sViewGroupByActivity.put(num, linkedHashMap);
            }
            if (linkedHashMap.isEmpty() || linkedHashMap.get(valueOf) == null) {
                linkedHashMap.put(valueOf, new WeakReference<>(this));
            }
        }
    }

    private Drawable realDrawable(boolean z) {
        Drawable drawable = super.getDrawable();
        return drawable instanceof DrawableProxy ? ((DrawableProxy) drawable).getRealDrawable(z) : drawable;
    }

    private synchronized void recoverImageIfPossible(boolean z) {
        if (this.mShouldRecoverOnNextVisible && getWindowToken() != null) {
            this.mShouldRecoverOnNextVisible = false;
            if (!z || (getWidth() >= 100 && getHeight() >= 100)) {
                Drawable drawable = super.getDrawable();
                if (drawable instanceof DrawableProxy) {
                    ((DrawableProxy) drawable).recover();
                }
            }
        }
    }

    public static void registerActivityCallback(Application application) {
        AnonymousClass1 r0 = new Application.ActivityLifecycleCallbacks() {
            /* class com.taobao.uikit.extend.feature.view.TUrlImageView.AnonymousClass1 */

            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
                TUrlImageView.onActivityStateChanged(activity, false, false, true);
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }
        };
        sActivityCallbacks = r0;
        application.registerActivityLifecycleCallbacks(r0);
        UIKITLog.i(LOG_TAG, "register activity callback for cancelling on destroyed, app=%s", application);
    }

    private synchronized void releaseImageIfPossible() {
        if (this.mEnableAutoRelease && !this.mShouldRecoverOnNextVisible) {
            Drawable drawable = super.getDrawable();
            this.mShouldRecoverOnNextVisible = (drawable instanceof DrawableProxy) && ((DrawableProxy) drawable).release();
        }
    }

    private void releaseImageWhenInvisible(boolean z, boolean z2) {
        if (z2 || (z && !this.mKeepImageIfShownInLastScreen)) {
            releaseImageIfPossible();
        }
    }

    public static void setGlobalFinalUrlInspector(FinalUrlInspector finalUrlInspector) {
        sGlobalFinalUrlInspector = finalUrlInspector;
    }

    public static void skipAutoSizeGlobally(boolean z) {
        sAutoSizeSkippedGlobally = z;
    }

    public static void unregisterActivityCallback(Application application) {
        application.unregisterActivityLifecycleCallbacks(sActivityCallbacks);
        UIKITLog.i(LOG_TAG, "unregister activity callback for cancelling on destroyed, app=%s", application);
    }

    public void asyncSetImageUrl(String str) {
        this.mImageLoad.setImageUrl(str, null, true, false, null);
        this.mEnableLayoutOptimize = true;
    }

    public void dispatchWindowVisibilityChanged(int i) {
        this.mOutWindowVisibilityChangedReally = true;
        super.dispatchWindowVisibilityChanged(i);
        this.mOutWindowVisibilityChangedReally = false;
    }

    public void enableLoadOnFling(boolean z) {
        this.mImageLoad.enableLoadOnFling(z);
    }

    public void enableSizeInLayoutParams(boolean z) {
        this.mImageLoad.enableSizeInLayoutParams(z);
    }

    public ImageLoadFeature failListener(IPhenixListener<qg0> iPhenixListener) {
        return this.mImageLoad.failListener(iPhenixListener);
    }

    public Drawable getDrawable() {
        return realDrawable(sTemporaryDrawableGetting);
    }

    public String getImageUrl() {
        ImageLoadFeature imageLoadFeature = this.mImageLoad;
        if (imageLoadFeature == null) {
            return null;
        }
        return imageLoadFeature.getImageUrl();
    }

    public String getLoadingUrl() {
        ImageLoadFeature imageLoadFeature = this.mImageLoad;
        if (imageLoadFeature == null) {
            return null;
        }
        return imageLoadFeature.getLoadingUrl();
    }

    @Deprecated
    public ImageLoadFeature getmImageLoad() {
        return this.mImageLoad;
    }

    public boolean isDrawableSameWith(Drawable drawable) {
        return realDrawable(true) == drawable;
    }

    public boolean isViewBitmapDifferentWith(Bitmap bitmap) {
        Drawable realDrawable = realDrawable(true);
        if (!(realDrawable instanceof BitmapDrawable) || ((BitmapDrawable) realDrawable).getBitmap() == bitmap) {
            return false;
        }
        return true;
    }

    public void keepBackgroundOnForegroundUpdate(boolean z) {
        this.mImageLoad.keepBackgroundOnForegroundUpdate(z);
    }

    public void keepImageIfShownInLastScreen(boolean z) {
        this.mKeepImageIfShownInLastScreen = z;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        putThisIntoViewGroup();
        recoverImageIfPossible(false);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseImageIfPossible();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        recoverImageIfPossible(false);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        releaseImageIfPossible();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this) {
            boolean z = false;
            if (i == 0) {
                recoverImageIfPossible(false);
            } else if (i == 4 || i == 8) {
                if (getWindowVisibility() != 0) {
                    z = true;
                }
                releaseImageWhenInvisible(z, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.mOutWindowVisibilityChangedReally) {
            return;
        }
        if (i == 0) {
            recoverImageIfPossible(true);
        } else if (i == 4 || i == 8) {
            releaseImageWhenInvisible(true, getVisibility() != 0);
        }
    }

    public void pause() {
        this.mImageLoad.pause();
    }

    public void reload() {
        this.mImageLoad.reload(false);
    }

    public void requestLayout() {
        if (this.mDoNotLayout) {
            this.mDoNotLayout = false;
        } else {
            super.requestLayout();
        }
    }

    public void resume() {
        this.mImageLoad.resume();
    }

    public r02 retrieveImageData() {
        ImageLoadFeature imageLoadFeature = this.mImageLoad;
        if (imageLoadFeature != null) {
            return imageLoadFeature.retrieveImageData();
        }
        return null;
    }

    public void setAutoRelease(boolean z) {
        this.mEnableAutoRelease = z;
    }

    public void setEnableLayoutOptimize(boolean z) {
        this.mEnableLayoutOptimize = z;
    }

    public void setErrorImageResId(int i) {
        this.mImageLoad.setErrorImageResId(i);
    }

    public void setFadeIn(boolean z) {
        this.mImageLoad.setFadeIn(z);
    }

    public void setFinalUrlInspector(FinalUrlInspector finalUrlInspector) {
        this.mImageLoad.setFinalUrlInspector(finalUrlInspector);
    }

    @Override // com.taobao.uikit.feature.view.TImageView
    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = super.getDrawable();
        ImageLoadFeature imageLoadFeature = this.mImageLoad;
        if (imageLoadFeature != null) {
            if (drawable == null) {
                if (drawable2 != null) {
                    imageLoadFeature.resetState();
                }
            } else if ((drawable instanceof so1) && !(drawable instanceof AnimatedImageDrawable)) {
                drawable = DrawableProxy.obtain((so1) drawable).bindHostView(this);
                this.mDoNotLayout = (!this.mEnableLayoutOptimize || getLayoutParams() == null || getLayoutParams().height == -2 || getLayoutParams().width == -2) ? false : true;
            }
        }
        super.setImageDrawable(drawable);
        if (drawable2 != drawable) {
            this.mShouldRecoverOnNextVisible = false;
            if (drawable2 instanceof DrawableProxy) {
                DrawableProxy drawableProxy = (DrawableProxy) drawable2;
                if (drawableProxy.isContentDifferent(drawable)) {
                    drawableProxy.release();
                }
            }
        }
    }

    public void setImageUrl(String str) {
        this.mImageLoad.setImageUrl(str, null, false, false, null);
    }

    public void setPhenixOptions(PhenixOptions phenixOptions) {
        this.mImageLoad.setPhenixOptions(phenixOptions);
    }

    public void setPlaceHoldForeground(Drawable drawable) {
        this.mImageLoad.setPlaceHoldForeground(drawable);
    }

    public void setPlaceHoldImageResId(int i) {
        this.mImageLoad.setPlaceHoldImageResId(i);
    }

    public void setPriorityModuleName(String str) {
        this.mImageLoad.setPriorityModuleName(str);
    }

    public void setSkipAutoSize(boolean z) {
        this.mImageLoad.skipAutoSize(z);
    }

    public void setStrategyConfig(Object obj) {
        this.mImageLoad.setStrategyConfig(obj);
    }

    public void setWhenNullClearImg(boolean z) {
        this.mImageLoad.setWhenNullClearImg(z);
    }

    public ImageLoadFeature succListener(IPhenixListener<ug2> iPhenixListener) {
        return this.mImageLoad.succListener(iPhenixListener);
    }

    public void setImageUrl(String str, PhenixOptions phenixOptions) {
        this.mImageLoad.setImageUrl(str, null, false, false, phenixOptions);
    }

    public void asyncSetImageUrl(String str, String str2) {
        this.mImageLoad.setImageUrl(str, str2, true, false, null);
    }

    public void setImageUrl(String str, String str2) {
        this.mImageLoad.setImageUrl(str, str2, false, false, null);
    }

    public void setImageUrl(String str, String str2, PhenixOptions phenixOptions) {
        this.mImageLoad.setImageUrl(str, str2, false, false, phenixOptions);
    }

    public TUrlImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initImageLoad(context, attributeSet, 0);
    }

    public TUrlImageView(Context context) {
        super(context);
        initImageLoad(context, null, 0);
    }
}
