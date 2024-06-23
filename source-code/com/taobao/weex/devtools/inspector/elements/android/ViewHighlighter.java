package com.taobao.weex.devtools.inspector.elements.android;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.common.Util;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class ViewHighlighter {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class NoopHighlighter extends ViewHighlighter {
        private NoopHighlighter() {
        }

        @Override // com.taobao.weex.devtools.inspector.elements.android.ViewHighlighter
        public void clearHighlight() {
        }

        @Override // com.taobao.weex.devtools.inspector.elements.android.ViewHighlighter
        public void setHighlightedView(View view, int i) {
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(18)
    /* compiled from: Taobao */
    public static final class OverlayHighlighter extends ViewHighlighter {
        private AtomicInteger mContentColor = new AtomicInteger();
        private final Handler mHandler = new Handler(Looper.getMainLooper());
        private final ViewHighlightOverlays mHighlightOverlays = ViewHighlightOverlays.newInstance();
        private final Runnable mHighlightViewOnUiThreadRunnable = new Runnable() {
            /* class com.taobao.weex.devtools.inspector.elements.android.ViewHighlighter.OverlayHighlighter.AnonymousClass1 */

            public void run() {
                OverlayHighlighter.this.highlightViewOnUiThread();
            }
        };
        private View mHighlightedView;
        private AtomicReference<View> mViewToHighlight = new AtomicReference<>();

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void highlightViewOnUiThread() {
            View andSet = this.mViewToHighlight.getAndSet(null);
            View view = this.mHighlightedView;
            if (andSet != view) {
                if (view != null) {
                    this.mHighlightOverlays.removeHighlight(view);
                }
                if (andSet != null) {
                    this.mHighlightOverlays.highlightView(andSet, this.mContentColor.get());
                }
                this.mHighlightedView = andSet;
            }
        }

        private void setHighlightedViewImpl(@Nullable View view, int i) {
            this.mHandler.removeCallbacks(this.mHighlightViewOnUiThreadRunnable);
            this.mViewToHighlight.set(view);
            this.mContentColor.set(i);
            this.mHandler.postDelayed(this.mHighlightViewOnUiThreadRunnable, 100);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.android.ViewHighlighter
        public void clearHighlight() {
            setHighlightedViewImpl(null, 0);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.android.ViewHighlighter
        public void setHighlightedView(View view, int i) {
            setHighlightedViewImpl((View) Util.throwIfNull(view), i);
        }
    }

    protected ViewHighlighter() {
    }

    public static ViewHighlighter newInstance() {
        if (Build.VERSION.SDK_INT >= 18) {
            return new OverlayHighlighter();
        }
        LogUtil.w("Running on pre-JBMR2: View highlighting is not supported");
        return new NoopHighlighter();
    }

    public abstract void clearHighlight();

    public abstract void setHighlightedView(View view, int i);
}
