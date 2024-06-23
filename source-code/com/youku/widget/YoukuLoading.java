package com.youku.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.airbnb.lottie.a;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;
import com.baseproject.ui.R$style;
import com.youku.utils.YoukuUIUtil;

/* compiled from: Taobao */
public class YoukuLoading {
    private static LoadingDialog mLoadingDialog;
    private static LottieDrawable mLottieDrawable;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class LoadingDialog extends Dialog {
        private Loading loading;

        public LoadingDialog(Context context) {
            super(context, R$style.LoadingDialog);
        }

        public void dismiss() {
            try {
                super.dismiss();
            } catch (Exception unused) {
            }
            this.loading.stopAnimation();
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(R$layout.loading);
            this.loading = (Loading) findViewById(R$id.newLoading);
            getWindow().addFlags(32);
        }

        public void show() {
            super.show();
            this.loading.startAnimation();
        }
    }

    private static boolean canDismissed(Context context, ImageView imageView) {
        LottieDrawable lottieDrawable = mLottieDrawable;
        return (lottieDrawable == null || !lottieDrawable.isAnimating() || context == null || imageView == null) ? false : true;
    }

    public static void dismiss() {
        LoadingDialog loadingDialog = mLoadingDialog;
        if (!(loadingDialog == null || !loadingDialog.isShowing() || mLoadingDialog.getWindow() == null)) {
            mLoadingDialog.dismiss();
        }
        mLoadingDialog = null;
    }

    private static void ensureLottieDrawable(Context context) {
        if (mLottieDrawable == null) {
            final AnonymousClass1 r0 = new LottieDrawable() {
                /* class com.youku.widget.YoukuLoading.AnonymousClass1 */

                @Override // com.airbnb.lottie.LottieDrawable
                public int getIntrinsicHeight() {
                    return super.getIntrinsicHeight();
                }
            };
            try {
                a.b.a(context, "loading_sphere.json", new OnCompositionLoadedListener() {
                    /* class com.youku.widget.YoukuLoading.AnonymousClass2 */

                    @Override // com.airbnb.lottie.OnCompositionLoadedListener
                    public void onCompositionLoaded(@Nullable a aVar) {
                        r0.setComposition(aVar);
                    }
                });
                r0.loop(true);
            } catch (Exception unused) {
            }
            mLottieDrawable = r0;
        }
    }

    public static boolean isRunning(Context context, ImageView imageView) {
        LottieDrawable lottieDrawable = mLottieDrawable;
        return (lottieDrawable != null && lottieDrawable.isAnimating()) || context == null || imageView == null;
    }

    public static boolean isShowing() {
        LoadingDialog loadingDialog = mLoadingDialog;
        return loadingDialog != null && loadingDialog.isShowing();
    }

    public static void remove() {
        dismiss();
    }

    public static void show(Context context) {
        if (!isShowing() && context != null) {
            if (!(context instanceof Activity) || YoukuUIUtil.isActivityContextValid((Activity) context)) {
                LoadingDialog loadingDialog = new LoadingDialog(context);
                mLoadingDialog = loadingDialog;
                loadingDialog.setCanceledOnTouchOutside(false);
                mLoadingDialog.show();
            }
        }
    }

    public static void dismiss(Context context, ImageView imageView) {
        ensureLottieDrawable(context);
        if (canDismissed(context, imageView)) {
            mLottieDrawable.pauseAnimation();
        }
    }

    public static void show(Context context, ImageView imageView) {
        ensureLottieDrawable(context);
        if (!isRunning(context, imageView)) {
            imageView.setImageDrawable(mLottieDrawable);
            mLottieDrawable.playAnimation();
        }
    }
}
