package com.youku.resource.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.youku.resource.R;
import java.util.List;

/* compiled from: Taobao */
public class YKAutoScrollTextView extends TextSwitcher implements ViewSwitcher.ViewFactory {
    private int delayedTime;
    private long duration;
    private Handler handler;
    private List<String> list;
    private Context mContext;
    private Rotate3dAnimation mInUp;
    private Rotate3dAnimation mOutUp;
    private OnTextChangeListener onTextChangeListener;
    private int position;
    private Runnable runnable;
    private boolean running;
    private int textColor;

    /* compiled from: Taobao */
    public interface OnTextChangeListener {
        void onTextChangeListener(int i);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class Rotate3dAnimation extends Animation {
        private Camera mCamera;
        private float mCenterX;
        private float mCenterY;
        private final boolean mTurnIn;
        private final boolean mTurnUp;

        public Rotate3dAnimation(boolean z, boolean z2) {
            this.mTurnIn = z;
            this.mTurnUp = z2;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            float f2 = this.mCenterX;
            float f3 = this.mCenterY;
            Camera camera = this.mCamera;
            int i = this.mTurnUp ? 1 : -1;
            Matrix matrix = transformation.getMatrix();
            camera.save();
            if (this.mTurnIn) {
                camera.translate(0.0f, ((float) i) * this.mCenterY * (f - 1.0f), 0.0f);
            } else {
                camera.translate(0.0f, ((float) i) * this.mCenterY * f, 0.0f);
            }
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f2, -f3);
            matrix.postTranslate(f2, f3);
        }

        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.mCamera = new Camera();
            this.mCenterY = (float) YKAutoScrollTextView.this.getHeight();
            this.mCenterX = (float) YKAutoScrollTextView.this.getWidth();
        }
    }

    public YKAutoScrollTextView(Context context) {
        this(context, null);
    }

    static /* synthetic */ int access$108(YKAutoScrollTextView yKAutoScrollTextView) {
        int i = yKAutoScrollTextView.position;
        yKAutoScrollTextView.position = i + 1;
        return i;
    }

    private Rotate3dAnimation createAnim(boolean z, boolean z2) {
        Rotate3dAnimation rotate3dAnimation = new Rotate3dAnimation(z, z2);
        rotate3dAnimation.setDuration(this.duration);
        rotate3dAnimation.setFillAfter(false);
        rotate3dAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        return rotate3dAnimation;
    }

    public static boolean isListNull(List list2) {
        return list2 == null || list2.size() <= 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void init() {
        if (getCurrentView() != null) {
            getCurrentView().clearAnimation();
        }
        if (getNextView() != null) {
            getNextView().clearAnimation();
        }
        removeAllViews();
        setFactory(this);
        this.mInUp = createAnim(true, true);
        this.mOutUp = createAnim(false, true);
        setInAnimation(this.mInUp);
        setOutAnimation(this.mOutUp);
        this.handler = new Handler();
        this.runnable = new Runnable() {
            /* class com.youku.resource.widget.YKAutoScrollTextView.AnonymousClass1 */

            public void run() {
                if (!YKAutoScrollTextView.isListNull(YKAutoScrollTextView.this.list)) {
                    YKAutoScrollTextView.access$108(YKAutoScrollTextView.this);
                    if (YKAutoScrollTextView.this.position == YKAutoScrollTextView.this.list.size()) {
                        YKAutoScrollTextView.this.position = 0;
                    }
                    if (YKAutoScrollTextView.this.onTextChangeListener != null) {
                        YKAutoScrollTextView.this.onTextChangeListener.onTextChangeListener(YKAutoScrollTextView.this.position);
                    }
                    YKAutoScrollTextView yKAutoScrollTextView = YKAutoScrollTextView.this;
                    yKAutoScrollTextView.setText((CharSequence) yKAutoScrollTextView.list.get(YKAutoScrollTextView.this.position));
                    YKAutoScrollTextView.this.handler.postDelayed(YKAutoScrollTextView.this.runnable, (long) YKAutoScrollTextView.this.delayedTime);
                }
            }
        };
    }

    public View makeView() {
        TextView textView = new TextView(this.mContext);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        textView.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.resource_size_12));
        textView.setSingleLine(true);
        textView.setIncludeFontPadding(false);
        textView.setGravity(17);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.textColor);
        return textView;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startScroll();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopScroll();
    }

    public void setList(List<String> list2) {
        setList(list2, 0);
    }

    public void setOnTextChangeListener(OnTextChangeListener onTextChangeListener2) {
        this.onTextChangeListener = onTextChangeListener2;
    }

    public void startScroll() {
        if (!isListNull(this.list)) {
            this.position = 0;
            if (this.running || this.list.size() <= 1) {
                setCurrentText(this.list.get(0));
            } else {
                setCurrentText(this.list.get(0));
                this.handler.postDelayed(this.runnable, (long) this.delayedTime);
                this.running = true;
            }
            OnTextChangeListener onTextChangeListener2 = this.onTextChangeListener;
            if (onTextChangeListener2 != null) {
                onTextChangeListener2.onTextChangeListener(this.position);
            }
        }
    }

    public void stopScroll() {
        if (this.running) {
            this.running = false;
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.removeCallbacks(this.runnable);
            }
        }
    }

    public YKAutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.running = false;
        this.textColor = Color.parseColor("#CCFFFFFF");
        this.position = 0;
        this.duration = 500;
        this.delayedTime = 5000;
        this.mContext = context;
    }

    public void setList(List<String> list2, int i) {
        if (!isListNull(list2)) {
            this.list = list2;
            if (i != 0) {
                this.textColor = i;
            }
            stopScroll();
            init();
            startScroll();
        }
    }
}
