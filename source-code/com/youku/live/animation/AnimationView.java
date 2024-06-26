package com.youku.live.animation;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import tb.u22;
import tb.v;

/* compiled from: Taobao */
public class AnimationView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String ANIM_TAG = v.TAK_ABILITY_SHOW_POP_ANIMATION;
    private boolean isWeex = false;
    private IAnimationCallback mAnimationCallback;
    private int mLoopCount = 1;
    private SVGAImageView mSvgaImageView;
    private boolean useCache = false;

    public AnimationView(Context context) {
        super(context);
    }

    private void addAnimationView(int i, int i2, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2063694922")) {
            ipChange.ipc$dispatch("-2063694922", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), view});
        } else if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view, new FrameLayout.LayoutParams(i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void playAnimation(SVGAVideoEntity sVGAVideoEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "130654879")) {
            ipChange.ipc$dispatch("130654879", new Object[]{this, sVGAVideoEntity});
        } else if (sVGAVideoEntity != null) {
            if (this.isWeex) {
                this.mSvgaImageView = new SVGAAnimationView(getContext());
            } else {
                this.mSvgaImageView = new SVGAImageView(getContext());
            }
            this.mSvgaImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.mSvgaImageView.setTag(v.TAK_ABILITY_SHOW_POP_ANIMATION);
            this.mSvgaImageView.setLoops(this.mLoopCount);
            this.mSvgaImageView.setClearsAfterStop(true);
            addAnimationView(getWidth(), getHeight(), this.mSvgaImageView);
            SVGAImageView sVGAImageView = this.mSvgaImageView;
            if (sVGAImageView instanceof SVGAAnimationView) {
                ((SVGAAnimationView) sVGAImageView).setSize(getWidth(), getHeight());
                ((SVGAAnimationView) this.mSvgaImageView).setResSize((int) sVGAVideoEntity.h().b(), (int) sVGAVideoEntity.h().a());
            }
            this.mSvgaImageView.setImageDrawable(new u22(sVGAVideoEntity));
            this.mSvgaImageView.setCallback(new SVGACallback() {
                /* class com.youku.live.animation.AnimationView.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onFinished() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "782992996")) {
                        ipChange.ipc$dispatch("782992996", new Object[]{this});
                    } else if (AnimationView.this.mAnimationCallback != null) {
                        AnimationView.this.mAnimationCallback.onAnimationEnd();
                    }
                }

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onPause() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1299383106")) {
                        ipChange.ipc$dispatch("-1299383106", new Object[]{this});
                    }
                }

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onRepeat() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1185370331")) {
                        ipChange.ipc$dispatch("1185370331", new Object[]{this});
                    }
                }

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onStep(int i, double d) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1161312923")) {
                        ipChange.ipc$dispatch("-1161312923", new Object[]{this, Integer.valueOf(i), Double.valueOf(d)});
                    }
                }
            });
            this.mSvgaImageView.startAnimation();
            IAnimationCallback iAnimationCallback = this.mAnimationCallback;
            if (iAnimationCallback != null) {
                iAnimationCallback.onAnimationStart();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void playStepFrameAnimation(int i, boolean z, SVGAVideoEntity sVGAVideoEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "680018935")) {
            ipChange.ipc$dispatch("680018935", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), sVGAVideoEntity});
        } else if (sVGAVideoEntity != null) {
            if (this.isWeex) {
                this.mSvgaImageView = new SVGAAnimationView(getContext());
            } else {
                this.mSvgaImageView = new SVGAImageView(getContext());
            }
            this.mSvgaImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.mSvgaImageView.setTag(v.TAK_ABILITY_SHOW_POP_ANIMATION);
            this.mSvgaImageView.setLoops(this.mLoopCount);
            this.mSvgaImageView.setClearsAfterStop(true);
            addAnimationView(getWidth(), getHeight(), this.mSvgaImageView);
            SVGAImageView sVGAImageView = this.mSvgaImageView;
            if (sVGAImageView instanceof SVGAAnimationView) {
                ((SVGAAnimationView) sVGAImageView).setSize(getWidth(), getHeight());
                ((SVGAAnimationView) this.mSvgaImageView).setResSize((int) sVGAVideoEntity.h().b(), (int) sVGAVideoEntity.h().a());
            }
            this.mSvgaImageView.setImageDrawable(new u22(sVGAVideoEntity));
            this.mSvgaImageView.setCallback(new SVGACallback() {
                /* class com.youku.live.animation.AnimationView.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onFinished() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-570316701")) {
                        ipChange.ipc$dispatch("-570316701", new Object[]{this});
                    } else if (AnimationView.this.mAnimationCallback != null) {
                        AnimationView.this.mAnimationCallback.onAnimationEnd();
                    }
                }

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onPause() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-793824481")) {
                        ipChange.ipc$dispatch("-793824481", new Object[]{this});
                    }
                }

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onRepeat() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-322181478")) {
                        ipChange.ipc$dispatch("-322181478", new Object[]{this});
                    }
                }

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onStep(int i, double d) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1626102564")) {
                        ipChange.ipc$dispatch("1626102564", new Object[]{this, Integer.valueOf(i), Double.valueOf(d)});
                    }
                }
            });
            this.mSvgaImageView.stepToFrame(i, z);
            IAnimationCallback iAnimationCallback = this.mAnimationCallback;
            if (iAnimationCallback != null) {
                iAnimationCallback.onAnimationStart();
            }
        }
    }

    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "892906090")) {
            ipChange.ipc$dispatch("892906090", new Object[]{this});
        } else if (getChildCount() != 0 && findViewWithTag(v.TAK_ABILITY_SHOW_POP_ANIMATION) != null) {
            View findViewWithTag = findViewWithTag(v.TAK_ABILITY_SHOW_POP_ANIMATION);
            if (findViewWithTag instanceof SVGAImageView) {
                ((SVGAImageView) findViewWithTag).stopAnimation(true);
            }
            IAnimationCallback iAnimationCallback = this.mAnimationCallback;
            if (iAnimationCallback != null) {
                iAnimationCallback.onAnimationCancel();
            }
        }
    }

    public void isWeex(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1382001925")) {
            ipChange.ipc$dispatch("-1382001925", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isWeex = z;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2134291865")) {
            ipChange.ipc$dispatch("2134291865", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void play(AnimationFileType animationFileType, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772316073")) {
            ipChange.ipc$dispatch("1772316073", new Object[]{this, animationFileType, str});
            return;
        }
        play(animationFileType, str, null);
    }

    public void playByUrl(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-451113620")) {
            ipChange.ipc$dispatch("-451113620", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            IAnimationCallback iAnimationCallback = this.mAnimationCallback;
            if (iAnimationCallback != null) {
                iAnimationCallback.onAnimationError(new AnimationError(-1, "url is empty"));
            }
        } else {
            SVGAVideoEntity drawableFromCache = AnimationCacheManger.getInstance().getDrawableFromCache(str);
            if (drawableFromCache == null || !this.useCache) {
                new SVGAParser(getContext()).j(str, new SVGAParser.ParseCompletion() {
                    /* class com.youku.live.animation.AnimationView.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                    public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-547364164")) {
                            ipChange.ipc$dispatch("-547364164", new Object[]{this, sVGAVideoEntity});
                            return;
                        }
                        if (AnimationView.this.useCache) {
                            AnimationCacheManger.getInstance().addCache(str, sVGAVideoEntity);
                        }
                        AnimationView.this.playAnimation(sVGAVideoEntity);
                    }

                    @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                    public void onError() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "845273328")) {
                            ipChange.ipc$dispatch("845273328", new Object[]{this});
                        } else if (AnimationView.this.mAnimationCallback != null) {
                            AnimationView.this.mAnimationCallback.onAnimationError(new AnimationError(-1, "parse url error"));
                        }
                    }
                });
            } else {
                playAnimation(drawableFromCache);
            }
        }
    }

    public void setAnimationCallback(IAnimationCallback iAnimationCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1242871626")) {
            ipChange.ipc$dispatch("1242871626", new Object[]{this, iAnimationCallback});
            return;
        }
        this.mAnimationCallback = iAnimationCallback;
    }

    public void setLoopCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-932941400")) {
            ipChange.ipc$dispatch("-932941400", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mLoopCount = i;
    }

    public void stepFramePlay(final int i, final boolean z, AnimationFileType animationFileType, final String str, AnimationProperties animationProperties) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1156049075")) {
            ipChange.ipc$dispatch("-1156049075", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), animationFileType, str, animationProperties});
        } else if (TextUtils.isEmpty(str)) {
            IAnimationCallback iAnimationCallback = this.mAnimationCallback;
            if (iAnimationCallback != null) {
                iAnimationCallback.onAnimationError(new AnimationError());
            }
        } else {
            if (animationProperties != null) {
                this.mLoopCount = animationProperties.loopCount;
            }
            File file = new File(str);
            if (!file.exists()) {
                IAnimationCallback iAnimationCallback2 = this.mAnimationCallback;
                if (iAnimationCallback2 != null) {
                    iAnimationCallback2.onAnimationError(new AnimationError());
                    return;
                }
                return;
            }
            FileInputStream fileInputStream = null;
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    IAnimationCallback iAnimationCallback3 = this.mAnimationCallback;
                    if (iAnimationCallback3 != null) {
                        iAnimationCallback3.onAnimationError(new AnimationError());
                        return;
                    }
                    return;
                } else if (animationFileType == AnimationFileType.TYPE_SVGA) {
                    File file2 = null;
                    while (true) {
                        if (i2 >= listFiles.length) {
                            break;
                        }
                        file2 = listFiles[i2];
                        if (file2 != null && file2.getAbsolutePath().endsWith(".svga")) {
                            str = file2.getAbsolutePath();
                            break;
                        }
                        i2++;
                    }
                    file = file2;
                } else {
                    file = null;
                }
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (fileInputStream == null) {
                IAnimationCallback iAnimationCallback4 = this.mAnimationCallback;
                if (iAnimationCallback4 != null) {
                    iAnimationCallback4.onAnimationError(new AnimationError());
                    return;
                }
                return;
            }
            if (getChildCount() != 0) {
                removeAllViews();
            }
            if (animationFileType == AnimationFileType.TYPE_SVGA) {
                SVGAVideoEntity drawableFromCache = AnimationCacheManger.getInstance().getDrawableFromCache(str);
                if (drawableFromCache == null || !this.useCache) {
                    new SVGAParser(getContext()).i(fileInputStream, str, new SVGAParser.ParseCompletion() {
                        /* class com.youku.live.animation.AnimationView.AnonymousClass3 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                        public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-345540230")) {
                                ipChange.ipc$dispatch("-345540230", new Object[]{this, sVGAVideoEntity});
                                return;
                            }
                            if (AnimationView.this.useCache) {
                                AnimationCacheManger.getInstance().addCache(str, sVGAVideoEntity);
                            }
                            AnimationView.this.playStepFrameAnimation(i, z, sVGAVideoEntity);
                        }

                        @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                        public void onError() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-165843922")) {
                                ipChange.ipc$dispatch("-165843922", new Object[]{this});
                            } else if (AnimationView.this.mAnimationCallback != null) {
                                AnimationView.this.mAnimationCallback.onAnimationError(new AnimationError(-1, "parse local resource error"));
                            }
                        }
                    }, true);
                } else {
                    playStepFrameAnimation(i, z, drawableFromCache);
                }
            }
        }
    }

    public void stepToFrame(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1182236753")) {
            ipChange.ipc$dispatch("1182236753", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        SVGAImageView sVGAImageView = this.mSvgaImageView;
        if (sVGAImageView != null) {
            sVGAImageView.stepToFrame(i, z);
        }
    }

    public void stepToPercentage(double d, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "753775097")) {
            ipChange.ipc$dispatch("753775097", new Object[]{this, Double.valueOf(d), Boolean.valueOf(z)});
            return;
        }
        SVGAImageView sVGAImageView = this.mSvgaImageView;
        if (sVGAImageView != null) {
            sVGAImageView.stepToPercentage(d, z);
        }
    }

    public void useCache(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1166142635")) {
            ipChange.ipc$dispatch("1166142635", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.useCache = z;
    }

    public void play(AnimationFileType animationFileType, final String str, AnimationProperties animationProperties) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1938813339")) {
            ipChange.ipc$dispatch("1938813339", new Object[]{this, animationFileType, str, animationProperties});
        } else if (TextUtils.isEmpty(str)) {
            IAnimationCallback iAnimationCallback = this.mAnimationCallback;
            if (iAnimationCallback != null) {
                iAnimationCallback.onAnimationError(new AnimationError());
            }
        } else {
            if (animationProperties != null) {
                this.mLoopCount = animationProperties.loopCount;
            }
            File file = new File(str);
            if (!file.exists()) {
                IAnimationCallback iAnimationCallback2 = this.mAnimationCallback;
                if (iAnimationCallback2 != null) {
                    iAnimationCallback2.onAnimationError(new AnimationError());
                    return;
                }
                return;
            }
            FileInputStream fileInputStream = null;
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    IAnimationCallback iAnimationCallback3 = this.mAnimationCallback;
                    if (iAnimationCallback3 != null) {
                        iAnimationCallback3.onAnimationError(new AnimationError());
                        return;
                    }
                    return;
                } else if (animationFileType == AnimationFileType.TYPE_SVGA) {
                    File file2 = null;
                    while (true) {
                        if (i >= listFiles.length) {
                            break;
                        }
                        file2 = listFiles[i];
                        if (file2 != null && file2.getAbsolutePath().endsWith(".svga")) {
                            str = file2.getAbsolutePath();
                            break;
                        }
                        i++;
                    }
                    file = file2;
                } else {
                    file = null;
                }
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (fileInputStream == null) {
                IAnimationCallback iAnimationCallback4 = this.mAnimationCallback;
                if (iAnimationCallback4 != null) {
                    iAnimationCallback4.onAnimationError(new AnimationError());
                    return;
                }
                return;
            }
            if (getChildCount() != 0) {
                removeAllViews();
            }
            if (animationFileType == AnimationFileType.TYPE_SVGA) {
                SVGAVideoEntity drawableFromCache = AnimationCacheManger.getInstance().getDrawableFromCache(str);
                if (drawableFromCache == null || !this.useCache) {
                    new SVGAParser(getContext()).i(fileInputStream, str, new SVGAParser.ParseCompletion() {
                        /* class com.youku.live.animation.AnimationView.AnonymousClass2 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                        public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-446452197")) {
                                ipChange.ipc$dispatch("-446452197", new Object[]{this, sVGAVideoEntity});
                                return;
                            }
                            if (AnimationView.this.useCache) {
                                AnimationCacheManger.getInstance().addCache(str, sVGAVideoEntity);
                            }
                            AnimationView.this.playAnimation(sVGAVideoEntity);
                        }

                        @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                        public void onError() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "339714703")) {
                                ipChange.ipc$dispatch("339714703", new Object[]{this});
                            } else if (AnimationView.this.mAnimationCallback != null) {
                                AnimationView.this.mAnimationCallback.onAnimationError(new AnimationError(-1, "parse local resource error"));
                            }
                        }
                    }, true);
                } else {
                    playAnimation(drawableFromCache);
                }
            }
        }
    }

    private void addAnimationView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "910786838")) {
            ipChange.ipc$dispatch("910786838", new Object[]{this, view});
        } else if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public AnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
