package com.taobao.android.animationkit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.ImageAssetDelegate;
import com.taobao.orange.OrangeConfig;
import com.taobao.weex.common.Constants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.na1;

/* compiled from: Taobao */
public class AnimationView extends FrameLayout {
    public static final int ANIM_KEY_DECISION_SLICE = 1;
    public static final int ANIM_KEY_FRAMEWORK_SLICE = 2;
    private static final int ANIM_KEY_UNKNOW = 0;
    public static final int ANIM_KEY_VOICE_THINKING = 3;
    private static final String TAG = "AnimationView";
    private JSONObject animationJson;
    private String animationName;
    private boolean autoPlay;
    private final Map<String, Bitmap> bitmapCache;
    private BitmapFetcher bitmapFetcher;
    private String lastAnimResFolder;
    private boolean loop;
    private long loopDelay;
    private LoopRunnable loopRunnable;
    private GuardedLottieAnimationView lottieAnimationView;
    private boolean pausedOrCanceled;

    /* compiled from: Taobao */
    public @interface AnimationKey {
    }

    /* compiled from: Taobao */
    public interface BitmapFetcher {
        Bitmap fetchBitmap(String str);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class LoopRunnable implements Runnable {
        WeakReference<AnimationView> ref = null;

        public LoopRunnable(AnimationView animationView) {
            this.ref = new WeakReference<>(animationView);
        }

        public void run() {
            AnimationView animationView = this.ref.get();
            if (animationView != null) {
                animationView.playAnimationWithoutCheck();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements ImageAssetDelegate {
        a() {
        }

        @Override // com.airbnb.lottie.ImageAssetDelegate
        public Bitmap fetchBitmap(na1 na1) {
            return AnimationView.this.bitmapFetcher.fetchBitmap(na1.b());
        }
    }

    /* compiled from: Taobao */
    class b implements FileFilter {
        b(AnimationView animationView) {
        }

        public boolean accept(File file) {
            return file.getName().endsWith(".json");
        }
    }

    /* compiled from: Taobao */
    class c implements BitmapFetcher {
        c() {
        }

        @Override // com.taobao.android.animationkit.AnimationView.BitmapFetcher
        public Bitmap fetchBitmap(String str) {
            return (Bitmap) AnimationView.this.bitmapCache.get(str);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class d extends AnimatorListenerAdapter {
        WeakReference<AnimationView> a = null;

        public d(AnimationView animationView) {
            this.a = new WeakReference<>(animationView);
        }

        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            AnimationView animationView = this.a.get();
            if (animationView != null) {
                animationView.pausedOrCanceled = true;
            }
        }

        public void onAnimationEnd(Animator animator) {
            AnimationView animationView = this.a.get();
            if (animationView != null) {
                animationView.onLottieAnimationEnd();
            }
        }
    }

    public AnimationView(Context context) {
        this(context, null);
    }

    private boolean checkAnimationEnable(String str) {
        String str2;
        try {
            str2 = OrangeConfig.getInstance().getConfig("animation_kit_switch", str, "true");
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "true";
        }
        boolean equals = "true".equals(str2);
        if (equals) {
            setVisibility(0);
            this.lottieAnimationView.setVisibility(0);
        } else {
            setVisibility(8);
            this.lottieAnimationView.setVisibility(8);
        }
        return equals;
    }

    private void init(AttributeSet attributeSet) {
        GuardedLottieAnimationView guardedLottieAnimationView = new GuardedLottieAnimationView(getContext());
        this.lottieAnimationView = guardedLottieAnimationView;
        addView(guardedLottieAnimationView);
        this.loopRunnable = new LoopRunnable(this);
        this.lottieAnimationView.addAnimatorListener(new d(this));
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.AnimationView);
        loop(obtainStyledAttributes.getBoolean(R$styleable.AnimationView_ak_loop, false));
        setupAnimKey(obtainStyledAttributes.getInt(R$styleable.AnimationView_ak_animKey, 0));
        String string = obtainStyledAttributes.getString(R$styleable.AnimationView_ak_jsonFilePath);
        String string2 = obtainStyledAttributes.getString(R$styleable.AnimationView_ak_imageAssetsFolder);
        if (!TextUtils.isEmpty(string)) {
            setAnimation(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            setImageAssetsFolder(string2);
        }
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.AnimationView_ak_autoPlay, true);
        this.autoPlay = z;
        if (z) {
            setupAutoPlay();
            playAnimation();
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onLottieAnimationEnd() {
        if (this.loop && !this.pausedOrCanceled) {
            postDelayed(this.loopRunnable, this.loopDelay);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void playAnimationWithoutCheck() {
        this.lottieAnimationView.playAnimation();
        this.pausedOrCanceled = false;
    }

    private void resumeReverseAnimation() {
        this.pausedOrCanceled = false;
    }

    private void setupAnimKey(@AnimationKey int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3 && checkAnimationEnable("voice_thinking")) {
                    setAnimation("voice_thinking/voice_thinking.json");
                    setImageAssetsFolder("voice_thinking/images");
                    this.animationName = "voice_thinking";
                }
            } else if (checkAnimationEnable("framework_slice")) {
                setAnimation("framework_slice/framework_slice.json");
                setImageAssetsFolder("framework_slice/images");
                this.animationName = "framework_slice";
            }
        } else if (checkAnimationEnable("decision_slice")) {
            setAnimation("decision_slice/decision_slice.json");
            setImageAssetsFolder("decision_slice/images");
            this.animationName = "decision_slice";
        }
    }

    private void setupAutoPlay() {
        try {
            Field declaredField = this.lottieAnimationView.getClass().getDeclaredField(Constants.Name.AUTO_PLAY);
            declaredField.setAccessible(true);
            declaredField.set(this.lottieAnimationView, Boolean.valueOf(this.autoPlay));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieAnimationView.addAnimatorListener(animatorListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieAnimationView.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public void cancelAnimation() {
        this.lottieAnimationView.cancelAnimation();
        this.pausedOrCanceled = true;
    }

    public long getDuration() {
        return this.lottieAnimationView.getDuration();
    }

    public float getProgress() {
        return this.lottieAnimationView.getProgress();
    }

    public boolean isAnimating() {
        return this.lottieAnimationView.isAnimating();
    }

    public void loop(boolean z) {
        this.loop = z;
    }

    public void pauseAnimation() {
        this.pausedOrCanceled = true;
        this.lottieAnimationView.pauseAnimation();
    }

    public void playAnimation() {
        if (!TextUtils.isEmpty(this.animationName)) {
            if (checkAnimationEnable(this.animationName)) {
                this.lottieAnimationView.playAnimation();
                this.pausedOrCanceled = false;
            }
        } else if (this.animationJson != null) {
            this.lottieAnimationView.playAnimation();
            this.pausedOrCanceled = false;
        }
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieAnimationView.removeAnimatorListener(animatorListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieAnimationView.removeUpdateListener(animatorUpdateListener);
    }

    public void resumeAnimation() {
        this.lottieAnimationView.resumeAnimation();
        this.pausedOrCanceled = false;
    }

    public void reverseAnimation() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7 A[SYNTHETIC, Splitter:B:44:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f0 A[SYNTHETIC, Splitter:B:61:0x00f0] */
    @CheckResult
    public boolean setAnimResFolder(String str) {
        Throwable th;
        FileNotFoundException e;
        UnsupportedEncodingException e2;
        IOException e3;
        JSONException e4;
        FileInputStream fileInputStream;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.lastAnimResFolder)) {
                return true;
            }
            String str2 = File.separator;
            if (str.endsWith(str2)) {
                File file = new File(str);
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles(new b(this));
                    if (listFiles.length > 0) {
                        FileInputStream fileInputStream2 = null;
                        try {
                            fileInputStream = new FileInputStream(listFiles[0]);
                        } catch (FileNotFoundException e5) {
                            e = e5;
                            e.printStackTrace();
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            return false;
                        } catch (UnsupportedEncodingException e6) {
                            e2 = e6;
                            e2.printStackTrace();
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            return false;
                        } catch (IOException e7) {
                            e3 = e7;
                            e3.printStackTrace();
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            return false;
                        } catch (JSONException e8) {
                            e4 = e8;
                            try {
                                e4.printStackTrace();
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e9) {
                                        e9.printStackTrace();
                                    }
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileInputStream2 != null) {
                                }
                                throw th;
                            }
                        }
                        try {
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                            String str3 = str + "images" + str2;
                            File file2 = new File(str3);
                            if (file2.exists() && file2.isDirectory()) {
                                this.bitmapCache.clear();
                                File[] listFiles2 = new File(str3).listFiles();
                                for (File file3 : listFiles2) {
                                    this.bitmapCache.put(file3.getName(), BitmapFactory.decodeFile(file3.getPath()));
                                }
                                setBitmapFetcher(new c());
                            }
                            setAnimation(jSONObject);
                            this.lastAnimResFolder = str;
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                            return true;
                        } catch (FileNotFoundException e11) {
                            e = e11;
                            fileInputStream2 = fileInputStream;
                            e.printStackTrace();
                            if (fileInputStream2 != null) {
                            }
                            return false;
                        } catch (UnsupportedEncodingException e12) {
                            e2 = e12;
                            fileInputStream2 = fileInputStream;
                            e2.printStackTrace();
                            if (fileInputStream2 != null) {
                            }
                            return false;
                        } catch (IOException e13) {
                            e3 = e13;
                            fileInputStream2 = fileInputStream;
                            e3.printStackTrace();
                            if (fileInputStream2 != null) {
                            }
                            return false;
                        } catch (JSONException e14) {
                            e4 = e14;
                            fileInputStream2 = fileInputStream;
                            e4.printStackTrace();
                            if (fileInputStream2 != null) {
                            }
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void setAnimation(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.animationName = str;
            this.lottieAnimationView.setAnimation(str);
        }
    }

    public void setAnimationKey(@AnimationKey int i) {
        setupAnimKey(i);
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
        setupAutoPlay();
    }

    public void setBitmapFetcher(BitmapFetcher bitmapFetcher2) {
        this.bitmapFetcher = bitmapFetcher2;
        if (bitmapFetcher2 == null) {
            this.lottieAnimationView.setImageAssetDelegate(null);
        } else {
            this.lottieAnimationView.setImageAssetDelegate(new a());
        }
    }

    public void setHardwareEnable(boolean z) {
        if (!this.lottieAnimationView.isHardwareAccelerated() || !z) {
            this.lottieAnimationView.setLayerType(1, null);
        } else {
            this.lottieAnimationView.setLayerType(2, null);
        }
    }

    public void setImageAssetsFolder(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lottieAnimationView.setImageAssetsFolder(str);
        }
    }

    public void setLoopDelay(long j) {
        if (j < 0) {
            j = 0;
        }
        this.loopDelay = j;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lottieAnimationView.setProgress(f);
    }

    public AnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.autoPlay = true;
        this.animationName = "";
        this.animationJson = null;
        this.pausedOrCanceled = false;
        this.bitmapCache = new HashMap();
        this.loopDelay = 0;
        init(attributeSet);
    }

    public void setAnimation(JSONObject jSONObject) {
        this.animationJson = jSONObject;
        this.lottieAnimationView.setAnimation(jSONObject);
    }
}
