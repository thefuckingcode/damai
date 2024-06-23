package com.youku.live.dago.widgetlib.ailproom.favor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.util.UIUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* compiled from: Taobao */
public class FavorLayout extends View implements IFavorHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int ADD_FAVOR = 321;
    private static final int ADD_FAVOR_LOOP = 231;
    private static final int FAVOR_DURATION = 2000;
    private static final int MAX_COUNT = 50;
    private static final int SHOW_FAKE_FAVOR = 123;
    private Interpolator acc;
    private Interpolator accdec;
    private Interpolator dce;
    private Interpolator[] interpolators;
    private Interpolator line;
    private Drawable mAvatar;
    private int mCurrentIndex;
    private int mDrawableHeight;
    private int mDrawableWidth;
    private List<Drawable> mDrawables;
    private int mFavorDuration;
    private List<FavorObject> mFavorObjects;
    private WeakHandler mHandler;
    private int mHeight;
    private long mLastTimeMillis;
    private double mScaleFactor;
    private int mWidth;
    private Random random;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class AnimEndListener extends AnimatorListenerAdapter {
        private WeakReference<FavorLayout> mFavorLayout;
        private FavorObject target;

        public AnimEndListener(FavorLayout favorLayout, FavorObject favorObject) {
            this.mFavorLayout = new WeakReference<>(favorLayout);
            this.target = favorObject;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            FavorLayout favorLayout = this.mFavorLayout.get();
            if (favorLayout != null) {
                favorLayout.removeFavor(this.target);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class BezierListener implements ValueAnimator.AnimatorUpdateListener {
        private WeakReference<FavorLayout> mWeakRef;
        private FavorObject target;

        public BezierListener(FavorObject favorObject, FavorLayout favorLayout) {
            this.target = favorObject;
            this.mWeakRef = new WeakReference<>(favorLayout);
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PointF pointF = (PointF) valueAnimator.getAnimatedValue();
            this.target.setX(pointF.x);
            this.target.setY(pointF.y);
            this.target.setAlpha(1.0f - valueAnimator.getAnimatedFraction());
            FavorLayout favorLayout = this.mWeakRef.get();
            if (favorLayout != null) {
                favorLayout.invalidate();
            }
        }
    }

    public FavorLayout(Context context) {
        this(context, null);
    }

    private Drawable createLayerDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956027764")) {
            return (Drawable) ipChange.ipc$dispatch("-1956027764", new Object[]{this, drawable});
        } else if (drawable == null) {
            return null;
        } else {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.setIntrinsicHeight(drawable.getIntrinsicHeight());
            shapeDrawable.setIntrinsicWidth(drawable.getIntrinsicWidth());
            shapeDrawable.getPaint().setColor(-1);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, drawable});
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            layerDrawable.setLayerInset(1, 4, 4, 4, 4);
            return layerDrawable;
        }
    }

    private Animator getAnimator(FavorObject favorObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2112733167")) {
            return (Animator) ipChange.ipc$dispatch("-2112733167", new Object[]{this, favorObject});
        }
        int i = this.mWidth / 2;
        AnimatorSet enterAnimtor = getEnterAnimtor(favorObject, i);
        ValueAnimator bezierValueAnimator = getBezierValueAnimator(favorObject, i);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(enterAnimtor, bezierValueAnimator);
        animatorSet.setInterpolator(this.accdec);
        animatorSet.setTarget(favorObject);
        return animatorSet;
    }

    private ValueAnimator getBezierValueAnimator(FavorObject favorObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340800997")) {
            return (ValueAnimator) ipChange.ipc$dispatch("-1340800997", new Object[]{this, favorObject, Integer.valueOf(i)});
        }
        float f = (float) i;
        ValueAnimator ofObject = ValueAnimator.ofObject(new BezierEvaluator(getPointF(2), getPointF(1)), new PointF(f, ((float) this.mHeight) - (((float) this.mDrawableWidth) / 2.0f)), new PointF(f, 50.0f));
        ofObject.addUpdateListener(new BezierListener(favorObject, this));
        ofObject.setTarget(favorObject);
        ofObject.setDuration((long) this.mFavorDuration);
        return ofObject;
    }

    private PointF getBreakPointF(int i, int i2) {
        IpChange ipChange = $ipChange;
        int i3 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1158780251")) {
            return (PointF) ipChange.ipc$dispatch("-1158780251", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Random random2 = new Random();
        PointF pointF = new PointF();
        int measuredWidth = ((getMeasuredWidth() - getPaddingRight()) + getPaddingLeft()) / i;
        if (measuredWidth <= 0) {
            measuredWidth = 1;
        }
        pointF.x = (float) (random2.nextInt(measuredWidth) + (getMeasuredWidth() / i2));
        int measuredHeight = ((getMeasuredHeight() - getPaddingBottom()) + getPaddingTop()) / i;
        if (measuredHeight > 0) {
            i3 = measuredHeight;
        }
        pointF.y = (float) (random2.nextInt(i3) + (getMeasuredHeight() / i2));
        return pointF;
    }

    private AnimatorSet getEnterAnimtor(FavorObject favorObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-41258071")) {
            return (AnimatorSet) ipChange.ipc$dispatch("-41258071", new Object[]{this, favorObject, Integer.valueOf(i)});
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(favorObject, "alpha", 0.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(favorObject, "scaleX", 0.2f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(favorObject, "scaleY", 0.2f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setTarget(favorObject);
        return animatorSet;
    }

    private PointF getPointF(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577234232")) {
            return (PointF) ipChange.ipc$dispatch("-1577234232", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        PointF pointF = new PointF();
        pointF.x = (float) i;
        pointF.y = (float) i2;
        return pointF;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428812227")) {
            ipChange.ipc$dispatch("-428812227", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.mDrawables = arrayList;
        arrayList.add(getResources().getDrawable(R.drawable.dago_pgc_ailp_like_favor_anim_1));
        this.mDrawables.add(getResources().getDrawable(R.drawable.dago_pgc_ailp_like_favor_anim_2));
        this.mDrawables.add(getResources().getDrawable(R.drawable.dago_pgc_ailp_like_favor_anim_3));
        this.mDrawables.add(getResources().getDrawable(R.drawable.dago_pgc_ailp_like_favor_anim_4));
        this.mDrawables.add(getResources().getDrawable(R.drawable.dago_pgc_ailp_like_favor_anim_5));
        this.mDrawables.add(getResources().getDrawable(R.drawable.dago_pgc_ailp_like_favor_anim_6));
        this.mDrawables.add(getResources().getDrawable(R.drawable.dago_pgc_ailp_like_favor_anim_7));
        this.mDrawables.add(getResources().getDrawable(R.drawable.dago_pgc_ailp_like_favor_anim_8));
        this.mDrawables.add(getResources().getDrawable(R.drawable.dago_pgc_ailp_like_favor_anim_9));
        this.mDrawables.add(getResources().getDrawable(R.drawable.dago_pgc_ailp_like_favor_anim_10));
        Interpolator[] interpolatorArr = new Interpolator[4];
        this.interpolators = interpolatorArr;
        interpolatorArr[0] = this.line;
        interpolatorArr[1] = this.acc;
        interpolatorArr[2] = this.dce;
        interpolatorArr[3] = this.accdec;
        this.mFavorObjects = new ArrayList();
    }

    private static int random(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-355735924")) {
            return ((Integer) ipChange.ipc$dispatch("-355735924", new Object[]{Integer.valueOf(i)})).intValue();
        } else if (i != 0 && Build.VERSION.SDK_INT >= 21) {
            return ThreadLocalRandom.current().nextInt(i);
        } else {
            return 0;
        }
    }

    public void addFavor(boolean z) {
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637641412")) {
            ipChange.ipc$dispatch("1637641412", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mFavorObjects.size() < 50) {
            if (this.mCurrentIndex >= this.mDrawables.size()) {
                this.mCurrentIndex = 0;
            }
            int i = this.mCurrentIndex;
            if (i >= 0 && i < this.mDrawables.size()) {
                FavorObject favorObject = new FavorObject();
                Drawable drawable2 = this.mAvatar;
                if (drawable2 != null) {
                    drawable = new Drawable[]{drawable2, this.mDrawables.get(this.mCurrentIndex).getConstantState().newDrawable()}[random(2)];
                } else {
                    drawable = this.mDrawables.get(this.mCurrentIndex).getConstantState().newDrawable();
                }
                favorObject.setDrawable(drawable);
                this.mCurrentIndex++;
                this.mFavorObjects.add(favorObject);
                Animator animator = getAnimator(favorObject);
                animator.addListener(new AnimEndListener(this, favorObject));
                animator.start();
                invalidate();
            }
        }
    }

    public void clearFavor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-911572036")) {
            ipChange.ipc$dispatch("-911572036", new Object[]{this});
            return;
        }
        WeakHandler weakHandler = this.mHandler;
        if (weakHandler != null) {
            weakHandler.removeCallbacksAndMessages(null);
        }
        List<FavorObject> list = this.mFavorObjects;
        if (list != null) {
            list.clear();
        }
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "989992547")) {
            ipChange.ipc$dispatch("989992547", new Object[]{this});
            return;
        }
        stopFakeFavor();
        List<FavorObject> list = this.mFavorObjects;
        if (list != null) {
            list.clear();
        }
    }

    public List<Drawable> getDrawables() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1457579399")) {
            return this.mDrawables;
        }
        return (List) ipChange.ipc$dispatch("-1457579399", new Object[]{this});
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.favor.IFavorHandler
    public void handleMessage(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "317906897")) {
            ipChange.ipc$dispatch("317906897", new Object[]{this, message});
            return;
        }
        int i = message.what;
        if (i != 123) {
            if (i == ADD_FAVOR_LOOP) {
                this.mHandler.sendEmptyMessageDelayed(ADD_FAVOR, 1000);
            } else if (i == ADD_FAVOR) {
                addFavor(false);
            }
        } else if (message.obj.equals(this.mHandler.toString())) {
            addFavor(2);
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 123;
            obtainMessage.obj = this.mHandler.toString();
            this.mHandler.sendMessageDelayed(obtainMessage, 700);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431518213")) {
            ipChange.ipc$dispatch("-431518213", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        List<FavorObject> list = this.mFavorObjects;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.mFavorObjects.size(); i++) {
                Drawable drawable = this.mFavorObjects.get(i).getDrawable();
                drawable.setAlpha((int) (this.mFavorObjects.get(i).getAlpha() * 255.0f));
                drawable.setBounds((int) (((double) this.mFavorObjects.get(i).getX()) - ((((double) (((float) this.mDrawableWidth) * this.mFavorObjects.get(i).getScaleX())) * this.mScaleFactor) / 2.0d)), (int) (((double) this.mFavorObjects.get(i).getY()) - ((((double) (((float) this.mDrawableHeight) * this.mFavorObjects.get(i).getScaleY())) * this.mScaleFactor) / 2.0d)), (int) (((double) this.mFavorObjects.get(i).getX()) + ((((double) (((float) this.mDrawableWidth) * this.mFavorObjects.get(i).getScaleX())) * this.mScaleFactor) / 2.0d)), (int) (((double) this.mFavorObjects.get(i).getY()) + ((((double) (((float) this.mDrawableHeight) * this.mFavorObjects.get(i).getScaleY())) * this.mScaleFactor) / 2.0d)));
                drawable.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045868898")) {
            ipChange.ipc$dispatch("-2045868898", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
    }

    public void removeFavor(FavorObject favorObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2048306181")) {
            ipChange.ipc$dispatch("2048306181", new Object[]{this, favorObject});
            return;
        }
        List<FavorObject> list = this.mFavorObjects;
        if (list != null) {
            list.remove(favorObject);
        }
    }

    public void setAvatar(BitmapDrawable bitmapDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-598059817")) {
            ipChange.ipc$dispatch("-598059817", new Object[]{this, bitmapDrawable});
            return;
        }
        this.mAvatar = createLayerDrawable(bitmapDrawable);
    }

    public void setDrawables(List<Drawable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348972043")) {
            ipChange.ipc$dispatch("1348972043", new Object[]{this, list});
        } else if (list != null && list.size() > 0) {
            this.mDrawables = list;
        }
    }

    public void setFavorDuration(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-462428666")) {
            ipChange.ipc$dispatch("-462428666", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mFavorDuration = i;
    }

    public void setFavorHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1249089255")) {
            ipChange.ipc$dispatch("-1249089255", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDrawableHeight = i;
    }

    public void setFavorWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111037136")) {
            ipChange.ipc$dispatch("-1111037136", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDrawableWidth = i;
    }

    public void setScaleFactor(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-459942264")) {
            ipChange.ipc$dispatch("-459942264", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.mScaleFactor = d;
    }

    public void startFakeFavor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-650181050")) {
            ipChange.ipc$dispatch("-650181050", new Object[]{this});
            return;
        }
        if (this.mHandler == null) {
            this.mHandler = new WeakHandler(this);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = ADD_FAVOR;
        obtainMessage.obj = this.mHandler.toString();
        this.mHandler.sendMessage(obtainMessage);
    }

    public void stopFakeFavor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155113782")) {
            ipChange.ipc$dispatch("1155113782", new Object[]{this});
            return;
        }
        WeakHandler weakHandler = this.mHandler;
        if (weakHandler != null) {
            weakHandler.removeCallbacksAndMessages(null);
        }
        invalidate();
    }

    public FavorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FavorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.random = new Random();
        this.mDrawableWidth = UIUtil.dip2px(36);
        this.mDrawableHeight = UIUtil.dip2px(36);
        this.line = new LinearInterpolator();
        this.acc = new AccelerateInterpolator();
        this.dce = new DecelerateInterpolator();
        this.accdec = new AccelerateDecelerateInterpolator();
        this.mCurrentIndex = 0;
        this.mFavorDuration = 2000;
        this.mScaleFactor = 1.0d;
        this.mHandler = null;
        this.mLastTimeMillis = 0;
        init();
    }

    private PointF getPointF(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "1089611753")) {
            return (PointF) ipChange.ipc$dispatch("1089611753", new Object[]{this, Integer.valueOf(i)});
        }
        PointF pointF = new PointF();
        Random random2 = this.random;
        int i3 = this.mWidth;
        if (i3 <= 0) {
            i3 = 1;
        }
        pointF.x = (float) random2.nextInt(i3);
        int i4 = this.mHeight;
        if (i4 - 100 > 0) {
            i4 -= 100;
        }
        Random random3 = this.random;
        if (i4 > 0) {
            i2 = i4;
        }
        pointF.y = (float) (random3.nextInt(i2) / i);
        return pointF;
    }

    public void addFavor(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "1637625075")) {
            ipChange.ipc$dispatch("1637625075", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int size = this.mDrawables.size();
        if (size > 0) {
            i2 = size;
        }
        if (i > 0) {
            if (i > i2) {
                i = i2;
            }
            int i3 = this.mFavorDuration / i;
            for (int i4 = 0; i4 < i; i4++) {
                if (this.mHandler == null) {
                    this.mHandler = new WeakHandler(this);
                }
                this.mHandler.sendEmptyMessageDelayed(ADD_FAVOR, (long) (i4 * i3));
            }
        }
    }
}
