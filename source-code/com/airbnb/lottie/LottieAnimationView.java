package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import tb.cb2;
import tb.k61;
import tb.ma1;
import tb.o91;
import tb.oa1;
import tb.pa1;
import tb.wm0;
import tb.xt2;
import tb.z51;
import tb.zj2;

/* compiled from: Taobao */
public class LottieAnimationView extends AppCompatImageView {
    private static final LottieListener<Throwable> DEFAULT_FAILURE_LISTENER = new a();
    private static final String TAG = LottieAnimationView.class.getSimpleName();
    private String animationName;
    @RawRes
    private int animationResId;
    private boolean autoPlay = false;
    private int buildDrawingCacheDepth = 0;
    private boolean cacheComposition = true;
    @Nullable
    private a composition;
    @Nullable
    private LottieTask<a> compositionTask;
    @Nullable
    private LottieListener<Throwable> failureListener;
    @DrawableRes
    private int fallbackResource = 0;
    private boolean ignoreUnschedule = false;
    private boolean isInitialized;
    private final LottieListener<a> loadedListener = new b();
    private final LottieDrawable lottieDrawable = new LottieDrawable();
    private final Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners = new HashSet();
    private boolean playAnimationWhenShown = false;
    private RenderMode renderMode = RenderMode.AUTOMATIC;
    private boolean wasAnimatingWhenDetached = false;
    private boolean wasAnimatingWhenNotShown = false;
    private final LottieListener<Throwable> wrappedFailureListener = new c();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        /* compiled from: Taobao */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() != 1 ? false : true;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements LottieListener<Throwable> {
        a() {
        }

        /* renamed from: a */
        public void onResult(Throwable th) {
            if (xt2.k(th)) {
                o91.d("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    /* compiled from: Taobao */
    class b implements LottieListener<a> {
        b() {
        }

        /* renamed from: a */
        public void onResult(a aVar) {
            LottieAnimationView.this.setComposition(aVar);
        }
    }

    /* compiled from: Taobao */
    class c implements LottieListener<Throwable> {
        c() {
        }

        /* renamed from: a */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.fallbackResource != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
            }
            (LottieAnimationView.this.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : LottieAnimationView.this.failureListener).onResult(th);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements Callable<oa1<a>> {
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        /* renamed from: a */
        public oa1<a> call() {
            return LottieAnimationView.this.cacheComposition ? b.q(LottieAnimationView.this.getContext(), this.a) : b.r(LottieAnimationView.this.getContext(), this.a, null);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements Callable<oa1<a>> {
        final /* synthetic */ String a;

        e(String str) {
            this.a = str;
        }

        /* renamed from: a */
        public oa1<a> call() {
            return LottieAnimationView.this.cacheComposition ? b.f(LottieAnimationView.this.getContext(), this.a) : b.g(LottieAnimationView.this.getContext(), this.a, null);
        }
    }

    /* compiled from: Taobao */
    class f extends pa1<T> {
        final /* synthetic */ SimpleLottieValueCallback c;

        f(LottieAnimationView lottieAnimationView, SimpleLottieValueCallback simpleLottieValueCallback) {
            this.c = simpleLottieValueCallback;
        }

        @Override // tb.pa1
        public T a(ma1<T> ma1) {
            return (T) this.c.getValue(ma1);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class g {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[RenderMode.values().length];
            a = iArr;
            iArr[RenderMode.HARDWARE.ordinal()] = 1;
            a[RenderMode.SOFTWARE.ordinal()] = 2;
            try {
                a[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        init(null, R$attr.lottieAnimationViewStyle);
    }

    private void cancelLoaderTask() {
        LottieTask<a> lottieTask = this.compositionTask;
        if (lottieTask != null) {
            lottieTask.k(this.loadedListener);
            this.compositionTask.j(this.wrappedFailureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        if (r3 != false) goto L_0x0046;
     */
    private void enableOrDisableHardwareLayer() {
        a aVar;
        int i;
        int i2 = g.a[this.renderMode.ordinal()];
        int i3 = 2;
        if (i2 != 1) {
            if (i2 != 2 && i2 == 3) {
                a aVar2 = this.composition;
                boolean z = false;
                if ((aVar2 == null || !aVar2.p() || Build.VERSION.SDK_INT >= 28) && (((aVar = this.composition) == null || aVar.l() <= 4) && (i = Build.VERSION.SDK_INT) >= 21 && i != 24 && i != 25)) {
                    z = true;
                }
            }
            i3 = 1;
        }
        if (i3 != getLayerType()) {
            setLayerType(i3, null);
        }
    }

    private LottieTask<a> fromAssets(String str) {
        if (isInEditMode()) {
            return new LottieTask<>(new e(str), true);
        }
        return this.cacheComposition ? b.d(getContext(), str) : b.e(getContext(), str, null);
    }

    private LottieTask<a> fromRawRes(@RawRes int i) {
        if (isInEditMode()) {
            return new LottieTask<>(new d(i), true);
        }
        return this.cacheComposition ? b.o(getContext(), i) : b.p(getContext(), i, null);
    }

    private void init(@Nullable AttributeSet attributeSet, @AttrRes int i) {
        String string;
        boolean z = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LottieAnimationView, i, 0);
        this.cacheComposition = obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_cacheComposition, true);
        int i2 = R$styleable.LottieAnimationView_lottie_rawRes;
        boolean hasValue = obtainStyledAttributes.hasValue(i2);
        int i3 = R$styleable.LottieAnimationView_lottie_fileName;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i3);
        int i4 = R$styleable.LottieAnimationView_lottie_url;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i4);
        if (!hasValue || !hasValue2) {
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(i3);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(i4)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(obtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_fallbackRes, 0));
            if (obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_autoPlay, false)) {
                this.wasAnimatingWhenDetached = true;
                this.autoPlay = true;
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_loop, false)) {
                this.lottieDrawable.setRepeatCount(-1);
            }
            int i5 = R$styleable.LottieAnimationView_lottie_repeatMode;
            if (obtainStyledAttributes.hasValue(i5)) {
                setRepeatMode(obtainStyledAttributes.getInt(i5, 1));
            }
            int i6 = R$styleable.LottieAnimationView_lottie_repeatCount;
            if (obtainStyledAttributes.hasValue(i6)) {
                setRepeatCount(obtainStyledAttributes.getInt(i6, -1));
            }
            int i7 = R$styleable.LottieAnimationView_lottie_speed;
            if (obtainStyledAttributes.hasValue(i7)) {
                setSpeed(obtainStyledAttributes.getFloat(i7, 1.0f));
            }
            setImageAssetsFolder(obtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_imageAssetsFolder));
            setProgress(obtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_progress, 0.0f));
            enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
            int i8 = R$styleable.LottieAnimationView_lottie_colorFilter;
            if (obtainStyledAttributes.hasValue(i8)) {
                addValueCallback(new z51("**"), LottieProperty.COLOR_FILTER, new pa1(new cb2(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(i8, -1)).getDefaultColor())));
            }
            int i9 = R$styleable.LottieAnimationView_lottie_scale;
            if (obtainStyledAttributes.hasValue(i9)) {
                this.lottieDrawable.setScale(obtainStyledAttributes.getFloat(i9, 1.0f));
            }
            int i10 = R$styleable.LottieAnimationView_lottie_renderMode;
            if (obtainStyledAttributes.hasValue(i10)) {
                RenderMode renderMode2 = RenderMode.AUTOMATIC;
                int i11 = obtainStyledAttributes.getInt(i10, renderMode2.ordinal());
                if (i11 >= RenderMode.values().length) {
                    i11 = renderMode2.ordinal();
                }
                setRenderMode(RenderMode.values()[i11]);
            }
            setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
            obtainStyledAttributes.recycle();
            LottieDrawable lottieDrawable2 = this.lottieDrawable;
            if (xt2.f(getContext()) != 0.0f) {
                z = true;
            }
            lottieDrawable2.setSystemAnimationsAreEnabled(Boolean.valueOf(z));
            enableOrDisableHardwareLayer();
            this.isInitialized = true;
            return;
        }
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    }

    private void setCompositionTask(LottieTask<a> lottieTask) {
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = lottieTask.f(this.loadedListener).e(this.wrappedFailureListener);
    }

    private void setLottieDrawable() {
        boolean isAnimating = isAnimating();
        setImageDrawable(null);
        setImageDrawable(this.lottieDrawable);
        if (isAnimating) {
            this.lottieDrawable.resumeAnimation();
        }
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.addAnimatorListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.addAnimatorPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        a aVar = this.composition;
        if (aVar != null) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(aVar);
        }
        return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener);
    }

    public <T> void addValueCallback(z51 z51, T t, pa1<T> pa1) {
        this.lottieDrawable.addValueCallback(z51, t, pa1);
    }

    public void buildDrawingCache(boolean z) {
        k61.a("buildDrawingCache");
        this.buildDrawingCacheDepth++;
        super.buildDrawingCache(z);
        if (this.buildDrawingCacheDepth == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.buildDrawingCacheDepth--;
        k61.b("buildDrawingCache");
    }

    @MainThread
    public void cancelAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.cancelAnimation();
        enableOrDisableHardwareLayer();
    }

    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.disableExtraScaleModeInFitXY();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(z);
    }

    @Nullable
    public a getComposition() {
        return this.composition;
    }

    public long getDuration() {
        a aVar = this.composition;
        if (aVar != null) {
            return (long) aVar.d();
        }
        return 0;
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public float getScale() {
        return this.lottieDrawable.getScale();
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        if (drawable2 == lottieDrawable2) {
            super.invalidateDrawable(lottieDrawable2);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    @Deprecated
    public void loop(boolean z) {
        this.lottieDrawable.setRepeatCount(z ? -1 : 0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.autoPlay || this.wasAnimatingWhenDetached)) {
            playAnimation();
            this.autoPlay = false;
            this.wasAnimatingWhenDetached = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.animationName;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i = savedState.animationResId;
        this.animationResId = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            playAnimation();
        }
        this.lottieDrawable.setImagesAssetsFolder(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        savedState.progress = this.lottieDrawable.getProgress();
        savedState.isAnimating = this.lottieDrawable.isAnimating() || (!ViewCompat.isAttachedToWindow(this) && this.wasAnimatingWhenDetached);
        savedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
        savedState.repeatMode = this.lottieDrawable.getRepeatMode();
        savedState.repeatCount = this.lottieDrawable.getRepeatCount();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i) {
        if (this.isInitialized) {
            if (isShown()) {
                if (this.wasAnimatingWhenNotShown) {
                    resumeAnimation();
                } else if (this.playAnimationWhenShown) {
                    playAnimation();
                }
                this.wasAnimatingWhenNotShown = false;
                this.playAnimationWhenShown = false;
            } else if (isAnimating()) {
                pauseAnimation();
                this.wasAnimatingWhenNotShown = true;
            }
        }
    }

    @MainThread
    public void pauseAnimation() {
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.pauseAnimation();
        enableOrDisableHardwareLayer();
    }

    @MainThread
    public void playAnimation() {
        if (isShown()) {
            this.lottieDrawable.playAnimation();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = true;
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.removeAnimatorListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.removeAnimatorPauseListener(animatorPauseListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public List<z51> resolveKeyPath(z51 z51) {
        return this.lottieDrawable.resolveKeyPath(z51);
    }

    @MainThread
    public void resumeAnimation() {
        if (isShown()) {
            this.lottieDrawable.resumeAnimation();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = true;
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setAnimation(@RawRes int i) {
        this.animationResId = i;
        this.animationName = null;
        setCompositionTask(fromRawRes(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.cacheComposition ? b.s(getContext(), str) : b.t(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.lottieDrawable.setApplyingOpacityToLayersEnabled(z);
    }

    public void setCacheComposition(boolean z) {
        this.cacheComposition = z;
    }

    public void setComposition(@NonNull a aVar) {
        if (k61.a) {
            String str = TAG;
            Log.v(str, "Set Composition \n" + aVar);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = aVar;
        this.ignoreUnschedule = true;
        boolean composition2 = this.lottieDrawable.setComposition(aVar);
        this.ignoreUnschedule = false;
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || composition2) {
            if (!composition2) {
                setLottieDrawable();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener : this.lottieOnCompositionLoadedListeners) {
                lottieOnCompositionLoadedListener.onCompositionLoaded(aVar);
            }
        }
    }

    public void setFailureListener(@Nullable LottieListener<Throwable> lottieListener) {
        this.failureListener = lottieListener;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.fallbackResource = i;
    }

    public void setFontAssetDelegate(wm0 wm0) {
        this.lottieDrawable.setFontAssetDelegate(wm0);
    }

    public void setFrame(int i) {
        this.lottieDrawable.setFrame(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.lottieDrawable.setIgnoreDisabledSystemAnimations(z);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.lottieDrawable.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.setImagesAssetsFolder(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageResource(int i) {
        cancelLoaderTask();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.lottieDrawable.setMaxFrame(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lottieDrawable.setMaxProgress(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.setMinAndMaxFrame(str);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        this.lottieDrawable.setMinAndMaxProgress(f2, f3);
    }

    public void setMinFrame(int i) {
        this.lottieDrawable.setMinFrame(i);
    }

    public void setMinProgress(float f2) {
        this.lottieDrawable.setMinProgress(f2);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.lottieDrawable.setOutlineMasksAndMattes(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.setPerformanceTrackingEnabled(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lottieDrawable.setProgress(f2);
    }

    public void setRenderMode(RenderMode renderMode2) {
        this.renderMode = renderMode2;
        enableOrDisableHardwareLayer();
    }

    public void setRepeatCount(int i) {
        this.lottieDrawable.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.lottieDrawable.setRepeatMode(i);
    }

    public void setSafeMode(boolean z) {
        this.lottieDrawable.setSafeMode(z);
    }

    public void setScale(float f2) {
        this.lottieDrawable.setScale(f2);
        if (getDrawable() == this.lottieDrawable) {
            setLottieDrawable();
        }
    }

    public void setSpeed(float f2) {
        this.lottieDrawable.setSpeed(f2);
    }

    public void setTextDelegate(zj2 zj2) {
        this.lottieDrawable.setTextDelegate(zj2);
    }

    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable2;
        if (!this.ignoreUnschedule && drawable == (lottieDrawable2 = this.lottieDrawable) && lottieDrawable2.isAnimating()) {
            pauseAnimation();
        } else if (!this.ignoreUnschedule && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable3 = (LottieDrawable) drawable;
            if (lottieDrawable3.isAnimating()) {
                lottieDrawable3.pauseAnimation();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.lottieDrawable.updateBitmap(str, bitmap);
    }

    public <T> void addValueCallback(z51 z51, T t, SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.lottieDrawable.addValueCallback(z51, t, new f(this, simpleLottieValueCallback));
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.setMaxFrame(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.lottieDrawable.setMinAndMaxFrame(str, str2, z);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.setMinFrame(str);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.lottieDrawable.setMinAndMaxFrame(i, i2);
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(fromAssets(str));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(b.t(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(b.h(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, R$attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }
}
