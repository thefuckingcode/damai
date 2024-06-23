package com.youku.resource.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.youku.motioncurvex.MotionCurveXOvershootInterpolator;
import com.youku.motioncurvex.MotionCurveXStandardInterpolator;
import com.youku.resource.R;

/* compiled from: Taobao */
public class PlayerGuideTipsView extends FrameLayout {
    public static final int ANIM_DURATION_ALPHA = 230;
    private final int ANIM_DURATION_SCALE = 400;
    private final float ANIM_SCALE_INIT_VALUE = 0.4f;
    private final float ANIM_SCALE_OVERSHOT_VALUE = 1.13f;
    private final int SIZE_MARGIN_HORIZONTAL = 20;
    private final float SIZE_TRIANGLE_BOTTOM_EDGE = 10.0f;
    private final float SIZE_TRIANGLE_BOTTOM_OVERLAP = 5.0f;
    private final int SIZE_TRIANGLE_HORIZONTAL_MARGIN = 25;
    private final float SIZE_TRIANGLE_TOP_EDGE = 5.0f;
    private final float SIZE_TRIANGLE_TOP_OVERLAP = 2.0f;
    private View mAnimView;
    private ViewGroup mHolderView;
    private Paint mPaint;
    private TextView mTipsView;
    private Bitmap mTriangleBottom;
    private Bitmap mTriangleTop;
    private GuideTipsType mType = GuideTipsType.BOTTOM_RIGHT;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.resource.widget.PlayerGuideTipsView$2  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[GuideTipsType.values().length];
            $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType = iArr;
            iArr[GuideTipsType.BOTTOM_RIGHT.ordinal()] = 1;
            $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[GuideTipsType.BOTTOM_CENTER.ordinal()] = 2;
            $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[GuideTipsType.BOTTOM_LEFT.ordinal()] = 3;
            $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[GuideTipsType.TOP_RIGHT.ordinal()] = 4;
            $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[GuideTipsType.TOP_CENTER.ordinal()] = 5;
            try {
                $SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[GuideTipsType.TOP_LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum GuideTipsType {
        BOTTOM_RIGHT,
        BOTTOM_CENTER,
        BOTTOM_LEFT,
        TOP_RIGHT,
        TOP_CENTER,
        TOP_LEFT
    }

    public PlayerGuideTipsView(Context context) {
        super(context);
        initView();
    }

    public static int dp2px(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void drawBottomTriangle(Canvas canvas, int i) {
        int height = (getHeight() - this.mTriangleBottom.getHeight()) - dp2px(getContext(), 5.0f);
        Log.d("helen", "drawBottomTriangle:" + dp2px(getContext(), 5.0f));
        canvas.drawBitmap(this.mTriangleBottom, new Rect(0, 0, this.mTriangleBottom.getWidth(), this.mTriangleBottom.getHeight()), new Rect(i, height, this.mTriangleBottom.getWidth() + i, this.mTriangleBottom.getHeight() + height), this.mPaint);
    }

    private void drawTopTriangle(Canvas canvas, int i) {
        Rect rect = new Rect(0, 0, this.mTriangleTop.getWidth(), this.mTriangleTop.getHeight());
        int dp2px = dp2px(getContext(), 2.0f);
        canvas.drawBitmap(this.mTriangleTop, rect, new Rect(i, dp2px, this.mTriangleTop.getWidth() + i, this.mTriangleTop.getHeight() + dp2px), this.mPaint);
    }

    private void drawTriangle(Canvas canvas) {
        switch (AnonymousClass2.$SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[this.mType.ordinal()]) {
            case 1:
                drawTopTriangle(canvas, dp2px(getContext(), 25.0f));
                return;
            case 2:
                drawTopTriangle(canvas, (getWidth() - this.mTriangleBottom.getWidth()) / 2);
                return;
            case 3:
                drawTopTriangle(canvas, (getWidth() - this.mTriangleBottom.getWidth()) - dp2px(getContext(), 25.0f));
                return;
            case 4:
                drawBottomTriangle(canvas, dp2px(getContext(), 25.0f));
                return;
            case 5:
                drawBottomTriangle(canvas, (getWidth() - this.mTriangleBottom.getWidth()) / 2);
                return;
            case 6:
                drawBottomTriangle(canvas, (getWidth() - this.mTriangleBottom.getWidth()) - dp2px(getContext(), 25.0f));
                return;
            default:
                return;
        }
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.resource_yk_guide_tips_layout, this);
        this.mHolderView = (ViewGroup) findViewById(R.id.v_tips_root_holder);
        this.mAnimView = findViewById(R.id.v_anim_bg);
        this.mTipsView = (TextView) findViewById(R.id.tv_tips);
        this.mHolderView.bringChildToFront(findViewById(R.id.ll_tips_holder));
        this.mTriangleTop = BitmapFactory.decodeResource(getResources(), R.drawable.yk_guide_tips_triangle_top);
        this.mTriangleBottom = BitmapFactory.decodeResource(getResources(), R.drawable.yk_guide_tips_triangle_bottom);
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        setTipsType(GuideTipsType.TOP_RIGHT);
    }

    private void updateMargin(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.mHolderView;
        if (viewGroup != null) {
            viewGroup.setPadding(i, i2, i3, i4);
            this.mHolderView.setClipToPadding(false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
        boolean drawChild = super.drawChild(canvas, view, j);
        drawTriangle(canvas);
        canvas.restoreToCount(saveLayer);
        return drawChild;
    }

    public int getBottomTriangleHorizon2Edge() {
        int dp2px = dp2px(getContext(), 25.0f);
        Bitmap bitmap = this.mTriangleBottom;
        return dp2px + (bitmap == null ? 0 : bitmap.getWidth() / 2);
    }

    public int getTopTriangleHorizontal2Edge() {
        int dp2px = dp2px(getContext(), 25.0f);
        Bitmap bitmap = this.mTriangleTop;
        return dp2px + (bitmap == null ? 0 : bitmap.getWidth() / 2);
    }

    public int getTriangleBottomEdge() {
        return dp2px(getContext(), 10.0f);
    }

    public int getTriangleTopEdge() {
        return dp2px(getContext(), 5.0f);
    }

    public void hide() {
        if (getVisibility() != 8) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.yk_amin_guide_tips_alpha_hide);
            loadAnimation.setFillAfter(false);
            setVisibility(8);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.youku.resource.widget.PlayerGuideTipsView.AnonymousClass1 */

                public void onAnimationEnd(Animation animation) {
                    Log.w("helen", "onAnimationEnd:" + this);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            startAnimation(loadAnimation);
        }
    }

    public void setTipsText(String str) {
        this.mTipsView.setText(str);
    }

    public void setTipsType(GuideTipsType guideTipsType) {
        this.mType = guideTipsType;
        switch (AnonymousClass2.$SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[guideTipsType.ordinal()]) {
            case 1:
                updateMargin(0, this.mTriangleTop.getHeight(), dp2px(getContext(), 20.0f), 0);
                return;
            case 2:
                int height = this.mTriangleTop.getHeight();
                int dp2px = dp2px(getContext(), 20.0f);
                updateMargin(dp2px, height, dp2px, 0);
                return;
            case 3:
                updateMargin(dp2px(getContext(), 20.0f), this.mTriangleTop.getHeight(), 0, 0);
                return;
            case 4:
                updateMargin(0, 0, dp2px(getContext(), 20.0f), this.mTriangleBottom.getHeight());
                return;
            case 5:
                int height2 = this.mTriangleBottom.getHeight();
                int dp2px2 = dp2px(getContext(), 20.0f);
                updateMargin(dp2px2, 0, dp2px2, height2);
                return;
            case 6:
                updateMargin(dp2px(getContext(), 20.0f), 0, 0, this.mTriangleBottom.getHeight());
                return;
            default:
                return;
        }
    }

    public void show() {
        if (getVisibility() != 0) {
            setVisibility(0);
            switch (AnonymousClass2.$SwitchMap$com$youku$resource$widget$PlayerGuideTipsView$GuideTipsType[this.mType.ordinal()]) {
                case 1:
                case 4:
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.4f, 1.0f, 1.0f, 1.0f, 1, 0.0f, 1, 1.0f);
                    scaleAnimation.setDuration(400);
                    scaleAnimation.setInterpolator(new MotionCurveXOvershootInterpolator());
                    this.mAnimView.startAnimation(scaleAnimation);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(230);
                    alphaAnimation.setInterpolator(new MotionCurveXStandardInterpolator());
                    startAnimation(alphaAnimation);
                    return;
                case 2:
                case 5:
                    ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.4f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 1.0f);
                    scaleAnimation2.setDuration(400);
                    scaleAnimation2.setInterpolator(new MotionCurveXOvershootInterpolator());
                    this.mAnimView.startAnimation(scaleAnimation2);
                    AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation2.setDuration(230);
                    alphaAnimation2.setInterpolator(new MotionCurveXStandardInterpolator());
                    startAnimation(alphaAnimation2);
                    return;
                case 3:
                case 6:
                    ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.4f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 1.0f);
                    scaleAnimation3.setDuration(400);
                    scaleAnimation3.setInterpolator(new MotionCurveXOvershootInterpolator());
                    this.mAnimView.startAnimation(scaleAnimation3);
                    AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation3.setDuration(230);
                    alphaAnimation3.setInterpolator(new MotionCurveXStandardInterpolator());
                    startAnimation(alphaAnimation3);
                    return;
                default:
                    return;
            }
        }
    }

    public PlayerGuideTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public PlayerGuideTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
