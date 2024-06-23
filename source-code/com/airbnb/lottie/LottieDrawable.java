package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.parser.s;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tb.he1;
import tb.k61;
import tb.kb1;
import tb.ma1;
import tb.o91;
import tb.pa1;
import tb.rz0;
import tb.wm0;
import tb.xm0;
import tb.z51;
import tb.zj2;

/* compiled from: Taobao */
public class LottieDrawable extends Drawable implements Animatable, Drawable.Callback {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private int alpha;
    private final LottieValueAnimator animator;
    private a composition;
    @Nullable
    private com.airbnb.lottie.model.layer.b compositionLayer;
    private boolean enableMergePaths;
    @Nullable
    wm0 fontAssetDelegate;
    @Nullable
    private xm0 fontAssetManager;
    private boolean ignoreSystemAnimationsDisabled;
    @Nullable
    private ImageAssetDelegate imageAssetDelegate;
    @Nullable
    private rz0 imageAssetManager;
    @Nullable
    private rz0 imageAssetManagerOverride;
    @Nullable
    private String imageAssetsFolder;
    private boolean isApplyingOpacityToLayersEnabled;
    private boolean isDirty;
    private boolean isExtraScaleEnabled;
    private final ArrayList<LazyCompositionTask> lazyCompositionTasks;
    private final Matrix matrix = new Matrix();
    private boolean outlineMasksAndMattes;
    private boolean performanceTrackingEnabled;
    private final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    private boolean safeMode;
    private float scale;
    private boolean systemAnimationsEnabled;
    @Nullable
    zj2 textDelegate;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface LazyCompositionTask {
        void run(a aVar);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface RepeatMode {
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements LazyCompositionTask {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setMinAndMaxFrame(this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements LazyCompositionTask {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;

        b(String str, String str2, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setMinAndMaxFrame(this.a, this.b, this.c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements LazyCompositionTask {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setMinAndMaxFrame(this.a, this.b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements LazyCompositionTask {
        final /* synthetic */ float a;
        final /* synthetic */ float b;

        d(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setMinAndMaxProgress(this.a, this.b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements LazyCompositionTask {
        final /* synthetic */ int a;

        e(int i) {
            this.a = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setFrame(this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f implements LazyCompositionTask {
        final /* synthetic */ float a;

        f(float f) {
            this.a = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setProgress(this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class g implements LazyCompositionTask {
        final /* synthetic */ z51 a;
        final /* synthetic */ Object b;
        final /* synthetic */ pa1 c;

        g(z51 z51, Object obj, pa1 pa1) {
            this.a = z51;
            this.b = obj;
            this.c = pa1;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.addValueCallback(this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    class h extends pa1<T> {
        final /* synthetic */ SimpleLottieValueCallback c;

        h(LottieDrawable lottieDrawable, SimpleLottieValueCallback simpleLottieValueCallback) {
            this.c = simpleLottieValueCallback;
        }

        @Override // tb.pa1
        public T a(ma1<T> ma1) {
            return (T) this.c.getValue(ma1);
        }
    }

    /* compiled from: Taobao */
    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (LottieDrawable.this.compositionLayer != null) {
                LottieDrawable.this.compositionLayer.B(LottieDrawable.this.animator.getAnimatedValueAbsolute());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class j implements LazyCompositionTask {
        j() {
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.playAnimation();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class k implements LazyCompositionTask {
        k() {
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.resumeAnimation();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class l implements LazyCompositionTask {
        final /* synthetic */ int a;

        l(int i) {
            this.a = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setMinFrame(this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class m implements LazyCompositionTask {
        final /* synthetic */ float a;

        m(float f) {
            this.a = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setMinProgress(this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class n implements LazyCompositionTask {
        final /* synthetic */ int a;

        n(int i) {
            this.a = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setMaxFrame(this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class o implements LazyCompositionTask {
        final /* synthetic */ float a;

        o(float f) {
            this.a = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setMaxProgress(this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class p implements LazyCompositionTask {
        final /* synthetic */ String a;

        p(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setMinFrame(this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class q implements LazyCompositionTask {
        final /* synthetic */ String a;

        q(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(a aVar) {
            LottieDrawable.this.setMaxFrame(this.a);
        }
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.animator = lottieValueAnimator;
        this.scale = 1.0f;
        this.systemAnimationsEnabled = true;
        this.ignoreSystemAnimationsDisabled = false;
        this.safeMode = false;
        this.lazyCompositionTasks = new ArrayList<>();
        i iVar = new i();
        this.progressUpdateListener = iVar;
        this.alpha = 255;
        this.isExtraScaleEnabled = true;
        this.isDirty = false;
        lottieValueAnimator.addUpdateListener(iVar);
    }

    private boolean animationsEnabled() {
        return this.systemAnimationsEnabled || this.ignoreSystemAnimationsDisabled;
    }

    private float aspectRatio(Rect rect) {
        return ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect)) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect));
    }

    private boolean boundsMatchesCompositionAspectRatio() {
        a aVar = this.composition;
        if (aVar == null || getBounds().isEmpty() || aspectRatio(getBounds()) == aspectRatio(aVar.b())) {
            return true;
        }
        return false;
    }

    private void buildCompositionLayer() {
        com.airbnb.lottie.model.layer.b bVar = new com.airbnb.lottie.model.layer.b(this, s.a(this.composition), this.composition.j(), this.composition);
        this.compositionLayer = bVar;
        if (this.outlineMasksAndMattes) {
            bVar.z(true);
        }
    }

    private void drawInternal(@NonNull Canvas canvas) {
        if (!boundsMatchesCompositionAspectRatio()) {
            drawWithNewAspectRatio(canvas);
        } else {
            drawWithOriginalAspectRatio(canvas);
        }
    }

    private void drawWithNewAspectRatio(Canvas canvas) {
        float f2;
        if (this.compositionLayer != null) {
            int i2 = -1;
            Rect bounds = getBounds();
            float width = ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds)) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.composition.b()));
            float height = ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds)) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.composition.b()));
            if (this.isExtraScaleEnabled) {
                float min = Math.min(width, height);
                if (min < 1.0f) {
                    f2 = 1.0f / min;
                    width /= f2;
                    height /= f2;
                } else {
                    f2 = 1.0f;
                }
                if (f2 > 1.0f) {
                    i2 = canvas.save();
                    float width2 = ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds)) / 2.0f;
                    float height2 = ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds)) / 2.0f;
                    float f3 = width2 * min;
                    float f4 = min * height2;
                    canvas.translate(width2 - f3, height2 - f4);
                    canvas.scale(f2, f2, f3, f4);
                }
            }
            this.matrix.reset();
            this.matrix.preScale(width, height);
            this.compositionLayer.draw(canvas, this.matrix, this.alpha);
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    private void drawWithOriginalAspectRatio(Canvas canvas) {
        float f2;
        if (this.compositionLayer != null) {
            float f3 = this.scale;
            float maxScale = getMaxScale(canvas);
            if (f3 > maxScale) {
                f2 = this.scale / maxScale;
            } else {
                maxScale = f3;
                f2 = 1.0f;
            }
            int i2 = -1;
            if (f2 > 1.0f) {
                i2 = canvas.save();
                float width = ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.composition.b())) / 2.0f;
                float height = ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.composition.b())) / 2.0f;
                float f4 = width * maxScale;
                float f5 = height * maxScale;
                canvas.translate((getScale() * width) - f4, (getScale() * height) - f5);
                canvas.scale(f2, f2, f4, f5);
            }
            this.matrix.reset();
            this.matrix.preScale(maxScale, maxScale);
            this.compositionLayer.draw(canvas, this.matrix, this.alpha);
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    @Nullable
    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private xm0 getFontAssetManager() {
        if (getCallback() == null) {
            return null;
        }
        if (this.fontAssetManager == null) {
            this.fontAssetManager = new xm0(getCallback(), this.fontAssetDelegate);
        }
        return this.fontAssetManager;
    }

    private rz0 getImageAssetManager() {
        rz0 rz0 = this.imageAssetManagerOverride;
        if (rz0 != null) {
            return rz0;
        }
        if (getCallback() == null) {
            return null;
        }
        rz0 rz02 = this.imageAssetManager;
        if (rz02 != null && !rz02.b(getContext())) {
            this.imageAssetManager = null;
        }
        if (this.imageAssetManager == null) {
            this.imageAssetManager = new rz0(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.i());
        }
        return this.imageAssetManager;
    }

    private float getMaxScale(@NonNull Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.composition.b())), ((float) canvas.getHeight()) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.composition.b())));
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.addListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.animator.addPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.addUpdateListener(animatorUpdateListener);
    }

    public <T> void addValueCallback(z51 z51, T t, pa1<T> pa1) {
        com.airbnb.lottie.model.layer.b bVar = this.compositionLayer;
        if (bVar == null) {
            this.lazyCompositionTasks.add(new g(z51, t, pa1));
            return;
        }
        boolean z = true;
        if (z51 == z51.COMPOSITION) {
            bVar.addValueCallback(t, pa1);
        } else if (z51.d() != null) {
            z51.d().addValueCallback(t, pa1);
        } else {
            List<z51> resolveKeyPath = resolveKeyPath(z51);
            for (int i2 = 0; i2 < resolveKeyPath.size(); i2++) {
                resolveKeyPath.get(i2).d().addValueCallback(t, pa1);
            }
            z = true ^ resolveKeyPath.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
    }

    public void clearComposition() {
        if (this.animator.isRunning()) {
            this.animator.cancel();
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.animator.clearComposition();
        invalidateSelf();
    }

    public void disableExtraScaleModeInFitXY() {
        this.isExtraScaleEnabled = false;
    }

    public void draw(@NonNull Canvas canvas) {
        this.isDirty = false;
        k61.a("Drawable#draw");
        if (this.safeMode) {
            try {
                drawInternal(canvas);
            } catch (Throwable th) {
                o91.b("Lottie crashed in draw!", th);
            }
        } else {
            drawInternal(canvas);
        }
        k61.b("Drawable#draw");
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    @MainThread
    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
    }

    public int getAlpha() {
        return this.alpha;
    }

    public a getComposition() {
        return this.composition;
    }

    public int getFrame() {
        return (int) this.animator.getFrame();
    }

    @Nullable
    public Bitmap getImageAsset(String str) {
        rz0 imageAssetManager2 = getImageAssetManager();
        if (imageAssetManager2 != null) {
            return imageAssetManager2.a(str);
        }
        return null;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public int getIntrinsicHeight() {
        a aVar = this.composition;
        if (aVar == null) {
            return -1;
        }
        return (int) (((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(aVar.b())) * getScale());
    }

    public int getIntrinsicWidth() {
        a aVar = this.composition;
        if (aVar == null) {
            return -1;
        }
        return (int) (((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(aVar.b())) * getScale());
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    public int getOpacity() {
        return -3;
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        a aVar = this.composition;
        if (aVar != null) {
            return aVar.m();
        }
        return null;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public float getScale() {
        return this.scale;
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    @Nullable
    public zj2 getTextDelegate() {
        return this.textDelegate;
    }

    @Nullable
    public Typeface getTypeface(String str, String str2) {
        xm0 fontAssetManager2 = getFontAssetManager();
        if (fontAssetManager2 != null) {
            return fontAssetManager2.b(str, str2);
        }
        return null;
    }

    public boolean hasMasks() {
        com.airbnb.lottie.model.layer.b bVar = this.compositionLayer;
        return bVar != null && bVar.E();
    }

    public boolean hasMatte() {
        com.airbnb.lottie.model.layer.b bVar = this.compositionLayer;
        return bVar != null && bVar.F();
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void invalidateSelf() {
        if (!this.isDirty) {
            this.isDirty = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public boolean isAnimating() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.isApplyingOpacityToLayersEnabled;
    }

    public boolean isLooping() {
        return this.animator.getRepeatCount() == -1;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public boolean isRunning() {
        return isAnimating();
    }

    @Deprecated
    public void loop(boolean z) {
        this.animator.setRepeatCount(z ? -1 : 0);
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
    }

    @MainThread
    public void playAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new j());
            return;
        }
        if (animationsEnabled() || getRepeatCount() == 0) {
            this.animator.playAnimation();
        }
        if (!animationsEnabled()) {
            setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
            this.animator.endAnimation();
        }
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
        this.animator.addUpdateListener(this.progressUpdateListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.removeListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.animator.removePauseListener(animatorPauseListener);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.removeUpdateListener(animatorUpdateListener);
    }

    public List<z51> resolveKeyPath(z51 z51) {
        if (this.compositionLayer == null) {
            o91.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.compositionLayer.resolveKeyPath(z51, 0, arrayList, new z51(new String[0]));
        return arrayList;
    }

    @MainThread
    public void resumeAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new k());
            return;
        }
        if (animationsEnabled() || getRepeatCount() == 0) {
            this.animator.resumeAnimation();
        }
        if (!animationsEnabled()) {
            setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
            this.animator.endAnimation();
        }
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.alpha = i2;
        invalidateSelf();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.isApplyingOpacityToLayersEnabled = z;
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        o91.c("Use addColorFilter instead.");
    }

    public boolean setComposition(a aVar) {
        if (this.composition == aVar) {
            return false;
        }
        this.isDirty = false;
        clearComposition();
        this.composition = aVar;
        buildCompositionLayer();
        this.animator.setComposition(aVar);
        setProgress(this.animator.getAnimatedFraction());
        setScale(this.scale);
        Iterator it = new ArrayList(this.lazyCompositionTasks).iterator();
        while (it.hasNext()) {
            LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.run(aVar);
            }
            it.remove();
        }
        this.lazyCompositionTasks.clear();
        aVar.u(this.performanceTrackingEnabled);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void setFontAssetDelegate(wm0 wm0) {
        xm0 xm0 = this.fontAssetManager;
        if (xm0 != null) {
            xm0.c(wm0);
        }
    }

    public void setFrame(int i2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new e(i2));
        } else {
            this.animator.setFrame((float) i2);
        }
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.ignoreSystemAnimationsDisabled = z;
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate2) {
        this.imageAssetDelegate = imageAssetDelegate2;
        rz0 rz0 = this.imageAssetManager;
        if (rz0 != null) {
            rz0.d(imageAssetDelegate2);
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setImageAssetManager(@Nullable rz0 rz0) {
        this.imageAssetManagerOverride = rz0;
    }

    public void setImagesAssetsFolder(@Nullable String str) {
        this.imageAssetsFolder = str;
    }

    public void setMaxFrame(int i2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new n(i2));
        } else {
            this.animator.setMaxFrame(((float) i2) + 0.99f);
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new o(f2));
        } else {
            setMaxFrame((int) he1.k(aVar.o(), this.composition.f(), f2));
        }
    }

    public void setMinAndMaxFrame(String str) {
        a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new a(str));
            return;
        }
        kb1 k2 = aVar.k(str);
        if (k2 != null) {
            int i2 = (int) k2.b;
            setMinAndMaxFrame(i2, ((int) k2.c) + i2);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new d(f2, f3));
        } else {
            setMinAndMaxFrame((int) he1.k(aVar.o(), this.composition.f(), f2), (int) he1.k(this.composition.o(), this.composition.f(), f3));
        }
    }

    public void setMinFrame(int i2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new l(i2));
        } else {
            this.animator.setMinFrame(i2);
        }
    }

    public void setMinProgress(float f2) {
        a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new m(f2));
        } else {
            setMinFrame((int) he1.k(aVar.o(), this.composition.f(), f2));
        }
    }

    public void setOutlineMasksAndMattes(boolean z) {
        if (this.outlineMasksAndMattes != z) {
            this.outlineMasksAndMattes = z;
            com.airbnb.lottie.model.layer.b bVar = this.compositionLayer;
            if (bVar != null) {
                bVar.z(z);
            }
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.performanceTrackingEnabled = z;
        a aVar = this.composition;
        if (aVar != null) {
            aVar.u(z);
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new f(f2));
            return;
        }
        k61.a("Drawable#setProgress");
        this.animator.setFrame(he1.k(this.composition.o(), this.composition.f(), f2));
        k61.b("Drawable#setProgress");
    }

    public void setRepeatCount(int i2) {
        this.animator.setRepeatCount(i2);
    }

    public void setRepeatMode(int i2) {
        this.animator.setRepeatMode(i2);
    }

    public void setSafeMode(boolean z) {
        this.safeMode = z;
    }

    public void setScale(float f2) {
        this.scale = f2;
    }

    public void setSpeed(float f2) {
        this.animator.setSpeed(f2);
    }

    /* access modifiers changed from: package-private */
    public void setSystemAnimationsAreEnabled(Boolean bool) {
        this.systemAnimationsEnabled = bool.booleanValue();
    }

    public void setTextDelegate(zj2 zj2) {
    }

    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && !((View) callback).isInEditMode()) {
            playAnimation();
        }
    }

    @MainThread
    public void stop() {
        endAnimation();
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        rz0 imageAssetManager2 = getImageAssetManager();
        if (imageAssetManager2 == null) {
            o91.c("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap e2 = imageAssetManager2.e(str, bitmap);
        invalidateSelf();
        return e2;
    }

    public boolean useTextGlyphs() {
        return this.composition.c().size() > 0;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.enableMergePaths != z) {
            if (Build.VERSION.SDK_INT < 19) {
                o91.c("Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.enableMergePaths = z;
            if (this.composition != null) {
                buildCompositionLayer();
            }
        }
    }

    public void setMaxFrame(String str) {
        a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new q(str));
            return;
        }
        kb1 k2 = aVar.k(str);
        if (k2 != null) {
            setMaxFrame((int) (k2.b + k2.c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinFrame(String str) {
        a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new p(str));
            return;
        }
        kb1 k2 = aVar.k(str);
        if (k2 != null) {
            setMinFrame((int) k2.b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        a aVar = this.composition;
        if (aVar == null) {
            this.lazyCompositionTasks.add(new b(str, str2, z));
            return;
        }
        kb1 k2 = aVar.k(str);
        if (k2 != null) {
            int i2 = (int) k2.b;
            kb1 k3 = this.composition.k(str2);
            if (k3 != null) {
                setMinAndMaxFrame(i2, (int) (k3.b + (z ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public <T> void addValueCallback(z51 z51, T t, SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        addValueCallback(z51, t, new h(this, simpleLottieValueCallback));
    }

    public void setMinAndMaxFrame(int i2, int i3) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new c(i2, i3));
        } else {
            this.animator.setMinAndMaxFrames((float) i2, ((float) i3) + 0.99f);
        }
    }
}
