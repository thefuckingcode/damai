package cn.damai.uikit.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public class HoleCardView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String TAG = HoleCardView.class.getSimpleName();
    int absBottom;
    int absLeft;
    int absRight;
    int absTop;
    private int mBackgroundColor;
    private Paint mBackgroundPaint = new Paint();
    private int mBorderColor;
    private Paint mBorderPaint = new Paint();
    private int mBorderWidth;
    private int mCornerRadius;
    private int mCornerType;
    private boolean mDirty = true;
    private int mDividerColor;
    private int mDividerDashGap;
    private int mDividerDashLength;
    private int mDividerPadding;
    private Paint mDividerPaint = new Paint();
    private float mDividerStartX;
    private float mDividerStartY;
    private float mDividerStopX;
    private float mDividerStopY;
    private int mDividerType;
    private int mDividerWidth;
    private int mOrientation;
    private Path mPath = new Path();
    private RectF mRect = new RectF();
    private RectF mRoundedCornerArc = new RectF();
    private RectF mScallopCornerArc = new RectF();
    private int mScallopHeight;
    private float mScallopPosition;
    private float mScallopPositionPercent;
    private int mScallopPositionPx;
    private int mScallopRadius;
    private Bitmap mShadow;
    private float mShadowBlurRadius = 0.0f;
    private final Paint mShadowPaint = new Paint(1);
    private boolean mShowBorder;
    private boolean mShowDivider;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface CornerType {
        public static final int NORMAL = 0;
        public static final int ROUNDED = 1;
        public static final int SCALLOP = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DividerType {
        public static final int DASH = 1;
        public static final int NORMAL = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface Orientation {
        public static final int HORIZONTAL = 0;
        public static final int VERTICAL = 1;
    }

    public HoleCardView(Context context) {
        super(context);
        init(null);
    }

    private void doLayout() {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501411049")) {
            ipChange.ipc$dispatch("-1501411049", new Object[]{this});
            return;
        }
        float paddingLeft = ((float) getPaddingLeft()) + this.mShadowBlurRadius;
        float width = ((float) (getWidth() - getPaddingRight())) - this.mShadowBlurRadius;
        float paddingTop = ((float) getPaddingTop()) + (this.mShadowBlurRadius / 2.0f);
        float f2 = this.mShadowBlurRadius;
        float height = (((float) (getHeight() - getPaddingBottom())) - f2) - (f2 / 2.0f);
        this.mPath.reset();
        if (this.mOrientation == 0) {
            f = getOffset(paddingTop, height);
            int i = this.mCornerType;
            if (i == 1) {
                this.mPath.arcTo(getTopLeftCornerRoundedArc(paddingTop, paddingLeft), 180.0f, 90.0f, false);
                this.mPath.lineTo(((float) this.mCornerRadius) + paddingLeft, paddingTop);
                this.mPath.lineTo(width - ((float) this.mCornerRadius), paddingTop);
                this.mPath.arcTo(getTopRightCornerRoundedArc(paddingTop, width), -90.0f, 90.0f, false);
            } else if (i == 2) {
                this.mPath.arcTo(getTopLeftCornerScallopArc(paddingTop, paddingLeft), 90.0f, -90.0f, false);
                this.mPath.lineTo(((float) this.mCornerRadius) + paddingLeft, paddingTop);
                this.mPath.lineTo(width - ((float) this.mCornerRadius), paddingTop);
                this.mPath.arcTo(getTopRightCornerScallopArc(paddingTop, width), 180.0f, -90.0f, false);
            } else {
                this.mPath.moveTo(paddingLeft, paddingTop);
                this.mPath.lineTo(width, paddingTop);
            }
            RectF rectF = this.mRect;
            int i2 = this.mScallopRadius;
            float f3 = paddingTop + f;
            rectF.set(width - ((float) i2), f3, ((float) i2) + width, ((float) this.mScallopHeight) + f + paddingTop);
            this.mPath.arcTo(this.mRect, 270.0f, -180.0f, false);
            int i3 = this.mCornerType;
            if (i3 == 1) {
                this.mPath.arcTo(getBottomRightCornerRoundedArc(height, width), 0.0f, 90.0f, false);
                this.mPath.lineTo(width - ((float) this.mCornerRadius), height);
                this.mPath.lineTo(((float) this.mCornerRadius) + paddingLeft, height);
                this.mPath.arcTo(getBottomLeftCornerRoundedArc(paddingLeft, height), 90.0f, 90.0f, false);
            } else if (i3 == 2) {
                this.mPath.arcTo(getBottomRightCornerScallopArc(height, width), 270.0f, -90.0f, false);
                this.mPath.lineTo(width - ((float) this.mCornerRadius), height);
                this.mPath.lineTo(((float) this.mCornerRadius) + paddingLeft, height);
                this.mPath.arcTo(getBottomLeftCornerScallopArc(paddingLeft, height), 0.0f, -90.0f, false);
            } else {
                this.mPath.lineTo(width, height);
                this.mPath.lineTo(paddingLeft, height);
            }
            RectF rectF2 = this.mRect;
            int i4 = this.mScallopRadius;
            rectF2.set(paddingLeft - ((float) i4), f3, ((float) i4) + paddingLeft, ((float) this.mScallopHeight) + f + paddingTop);
            this.mPath.arcTo(this.mRect, 90.0f, -180.0f, false);
            this.mPath.close();
        } else {
            f = getOffset(width, paddingLeft);
            int i5 = this.mCornerType;
            if (i5 == 1) {
                this.mPath.arcTo(getTopLeftCornerRoundedArc(paddingTop, paddingLeft), 180.0f, 90.0f, false);
                this.mPath.lineTo(((float) this.mCornerRadius) + paddingLeft, paddingTop);
            } else if (i5 == 2) {
                this.mPath.arcTo(getTopLeftCornerScallopArc(paddingTop, paddingLeft), 90.0f, -90.0f, false);
                this.mPath.lineTo(((float) this.mCornerRadius) + paddingLeft, paddingTop);
            } else {
                this.mPath.moveTo(paddingLeft, paddingTop);
            }
            RectF rectF3 = this.mRect;
            float f4 = paddingLeft + f;
            int i6 = this.mScallopRadius;
            rectF3.set(f4, paddingTop - ((float) i6), ((float) this.mScallopHeight) + f + paddingLeft, ((float) i6) + paddingTop);
            this.mPath.arcTo(this.mRect, 180.0f, -180.0f, false);
            int i7 = this.mCornerType;
            if (i7 == 1) {
                this.mPath.lineTo(width - ((float) this.mCornerRadius), paddingTop);
                this.mPath.arcTo(getTopRightCornerRoundedArc(paddingTop, width), -90.0f, 90.0f, false);
                this.mPath.arcTo(getBottomRightCornerRoundedArc(height, width), 0.0f, 90.0f, false);
                this.mPath.lineTo(width - ((float) this.mCornerRadius), height);
            } else if (i7 == 2) {
                this.mPath.lineTo(width - ((float) this.mCornerRadius), paddingTop);
                this.mPath.arcTo(getTopRightCornerScallopArc(paddingTop, width), 180.0f, -90.0f, false);
                this.mPath.arcTo(getBottomRightCornerScallopArc(height, width), 270.0f, -90.0f, false);
                this.mPath.lineTo(width - ((float) this.mCornerRadius), height);
            } else {
                this.mPath.lineTo(width, paddingTop);
                this.mPath.lineTo(width, height);
            }
            RectF rectF4 = this.mRect;
            int i8 = this.mScallopRadius;
            rectF4.set(f4, height - ((float) i8), ((float) this.mScallopHeight) + f + paddingLeft, ((float) i8) + height);
            this.mPath.arcTo(this.mRect, 0.0f, -180.0f, false);
            int i9 = this.mCornerType;
            if (i9 == 1) {
                this.mPath.arcTo(getBottomLeftCornerRoundedArc(paddingLeft, height), 90.0f, 90.0f, false);
                this.mPath.lineTo(paddingLeft, height - ((float) this.mCornerRadius));
            } else if (i9 == 2) {
                this.mPath.arcTo(getBottomLeftCornerScallopArc(paddingLeft, height), 0.0f, -90.0f, false);
                this.mPath.lineTo(paddingLeft, height - ((float) this.mCornerRadius));
            } else {
                this.mPath.lineTo(paddingLeft, height);
            }
            this.mPath.close();
        }
        if (this.mOrientation == 0) {
            int i10 = this.mScallopRadius;
            int i11 = this.mDividerPadding;
            this.mDividerStartX = paddingLeft + ((float) i10) + ((float) i11);
            this.mDividerStartY = ((float) i10) + paddingTop + f;
            this.mDividerStopX = (width - ((float) i10)) - ((float) i11);
            this.mDividerStopY = ((float) i10) + paddingTop + f;
        } else {
            int i12 = this.mScallopRadius;
            this.mDividerStartX = ((float) i12) + paddingLeft + f;
            int i13 = this.mDividerPadding;
            this.mDividerStartY = paddingTop + ((float) i12) + ((float) i13);
            this.mDividerStopX = ((float) i12) + paddingLeft + f;
            this.mDividerStopY = (height - ((float) i12)) - ((float) i13);
        }
        generateShadow();
        this.mDirty = false;
    }

    private static int dpToPx(float f, Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1501849256")) {
            return dpToPx(f, context.getResources());
        }
        return ((Integer) ipChange.ipc$dispatch("-1501849256", new Object[]{Float.valueOf(f), context})).intValue();
    }

    private void generateShadow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708624265")) {
            ipChange.ipc$dispatch("-708624265", new Object[]{this});
        } else if (isJellyBeanAndAbove() && !isInEditMode() && this.mShadowBlurRadius != 0.0f) {
            Bitmap bitmap = this.mShadow;
            if (bitmap == null) {
                this.mShadow = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ALPHA_8);
            } else {
                bitmap.eraseColor(0);
            }
            Canvas canvas = new Canvas(this.mShadow);
            canvas.drawPath(this.mPath, this.mShadowPaint);
            if (this.mShowBorder) {
                canvas.drawPath(this.mPath, this.mShadowPaint);
            }
            RenderScript create = RenderScript.create(getContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, this.mShadow);
            Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
            create2.setRadius(this.mShadowBlurRadius);
            create2.setInput(createFromBitmap);
            create2.forEach(createTyped);
            createTyped.copyTo(this.mShadow);
            createFromBitmap.destroy();
            createTyped.destroy();
            create2.destroy();
        }
    }

    private RectF getBottomLeftCornerRoundedArc(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-215980245")) {
            return (RectF) ipChange.ipc$dispatch("-215980245", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        RectF rectF = this.mRoundedCornerArc;
        int i = this.mCornerRadius;
        rectF.set(f, f2 - ((float) (i * 2)), ((float) (i * 2)) + f, f2);
        return this.mRoundedCornerArc;
    }

    private RectF getBottomLeftCornerScallopArc(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1147033018")) {
            return (RectF) ipChange.ipc$dispatch("-1147033018", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        RectF rectF = this.mScallopCornerArc;
        int i = this.mCornerRadius;
        rectF.set(f - ((float) i), f2 - ((float) i), f + ((float) i), f2 + ((float) i));
        return this.mScallopCornerArc;
    }

    private RectF getBottomRightCornerRoundedArc(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308364784")) {
            return (RectF) ipChange.ipc$dispatch("-1308364784", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        RectF rectF = this.mRoundedCornerArc;
        int i = this.mCornerRadius;
        rectF.set(f2 - ((float) (i * 2)), f - ((float) (i * 2)), f2, f);
        return this.mRoundedCornerArc;
    }

    private RectF getBottomRightCornerScallopArc(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055549739")) {
            return (RectF) ipChange.ipc$dispatch("2055549739", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        RectF rectF = this.mScallopCornerArc;
        int i = this.mCornerRadius;
        rectF.set(f2 - ((float) i), f - ((float) i), f2 + ((float) i), f + ((float) i));
        return this.mScallopCornerArc;
    }

    private float getOffset(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "606129029")) {
            return ((Float) ipChange.ipc$dispatch("606129029", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)})).floatValue();
        }
        int i = this.mScallopPositionPx;
        if (i == 0) {
            return ((f + f2) / this.mScallopPosition) - ((float) this.mScallopRadius);
        }
        return (float) (i - this.mScallopRadius);
    }

    private RectF getTopLeftCornerRoundedArc(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-7735973")) {
            return (RectF) ipChange.ipc$dispatch("-7735973", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        RectF rectF = this.mRoundedCornerArc;
        int i = this.mCornerRadius;
        rectF.set(f2, f, ((float) (i * 2)) + f2, ((float) (i * 2)) + f);
        return this.mRoundedCornerArc;
    }

    private RectF getTopLeftCornerScallopArc(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-938788746")) {
            return (RectF) ipChange.ipc$dispatch("-938788746", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        RectF rectF = this.mScallopCornerArc;
        int i = this.mCornerRadius;
        rectF.set(f2 - ((float) i), f - ((float) i), f2 + ((float) i), f + ((float) i));
        return this.mScallopCornerArc;
    }

    private RectF getTopRightCornerRoundedArc(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "852240352")) {
            return (RectF) ipChange.ipc$dispatch("852240352", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        RectF rectF = this.mRoundedCornerArc;
        int i = this.mCornerRadius;
        rectF.set(f2 - ((float) (i * 2)), f, f2, ((float) (i * 2)) + f);
        return this.mRoundedCornerArc;
    }

    private RectF getTopRightCornerScallopArc(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78812421")) {
            return (RectF) ipChange.ipc$dispatch("-78812421", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        RectF rectF = this.mScallopCornerArc;
        int i = this.mCornerRadius;
        rectF.set(f2 - ((float) i), f - ((float) i), f2 + ((float) i), f + ((float) i));
        return this.mScallopCornerArc;
    }

    private void init(AttributeSet attributeSet) {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795565230")) {
            ipChange.ipc$dispatch("-1795565230", new Object[]{this, attributeSet});
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.HoleCardView);
            this.mOrientation = obtainStyledAttributes.getInt(R$styleable.HoleCardView_holeOrientation, 0);
            this.mBackgroundColor = obtainStyledAttributes.getColor(R$styleable.HoleCardView_holeBackgroundColor, getResources().getColor(17170443));
            this.mScallopRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.HoleCardView_holeScallopRadius, dpToPx(20.0f, getContext()));
            this.mScallopPositionPercent = obtainStyledAttributes.getFloat(R$styleable.HoleCardView_holeScallopPositionPercent, 50.0f);
            this.mShowBorder = obtainStyledAttributes.getBoolean(R$styleable.HoleCardView_holeShowBorder, false);
            this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.HoleCardView_holeBorderWidth, dpToPx(2.0f, getContext()));
            this.mBorderColor = obtainStyledAttributes.getColor(R$styleable.HoleCardView_holeBorderColor, getResources().getColor(17170444));
            this.mShowDivider = obtainStyledAttributes.getBoolean(R$styleable.HoleCardView_holeShowDivider, false);
            this.mDividerType = obtainStyledAttributes.getInt(R$styleable.HoleCardView_holeDividerType, 1);
            this.mDividerWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.HoleCardView_holeDividerWidth, dpToPx(2.0f, getContext()));
            this.mDividerColor = obtainStyledAttributes.getColor(R$styleable.HoleCardView_holeDividerColor, getResources().getColor(17170432));
            this.mDividerDashLength = obtainStyledAttributes.getDimensionPixelSize(R$styleable.HoleCardView_holeDividerDashLength, dpToPx(8.0f, getContext()));
            this.mDividerDashGap = obtainStyledAttributes.getDimensionPixelSize(R$styleable.HoleCardView_holeDividerDashGap, dpToPx(4.0f, getContext()));
            this.mCornerType = obtainStyledAttributes.getInt(R$styleable.HoleCardView_holeCornerType, 1);
            this.mCornerRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.HoleCardView_holeCornerRadius, dpToPx(10.0f, getContext()));
            this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R$styleable.HoleCardView_holeDividerPadding, dpToPx(10.0f, getContext()));
            int i = R$styleable.HoleCardView_holeElevation;
            if (obtainStyledAttributes.hasValue(i)) {
                f = obtainStyledAttributes.getDimension(i, 0.0f);
            } else {
                int i2 = R$styleable.HoleCardView_android_elevation;
                f = obtainStyledAttributes.hasValue(i2) ? obtainStyledAttributes.getDimension(i2, 0.0f) : 0.0f;
            }
            if (f > 0.0f) {
                setShadowBlurRadius(f);
            }
            obtainStyledAttributes.recycle();
        }
        this.mShadowPaint.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_IN));
        this.mShadowPaint.setAlpha(51);
        initElements();
        setLayerType(1, null);
        super.setBackgroundColor(getResources().getColor(17170445));
    }

    private void initElements() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-308115003")) {
            ipChange.ipc$dispatch("-308115003", new Object[]{this});
            return;
        }
        int i = this.mDividerWidth;
        int i2 = this.mScallopRadius;
        if (i > i2) {
            this.mDividerWidth = i2;
        }
        this.mScallopPosition = 100.0f / this.mScallopPositionPercent;
        this.mScallopHeight = i2 * 2;
        setBackgroundPaint();
        setBorderPaint();
        setDividerPaint();
        this.mDirty = true;
        invalidate();
    }

    private boolean isJellyBeanAndAbove() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-4942152")) {
            return Build.VERSION.SDK_INT >= 17;
        }
        return ((Boolean) ipChange.ipc$dispatch("-4942152", new Object[]{this})).booleanValue();
    }

    private void setBackgroundPaint() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1660887490")) {
            ipChange.ipc$dispatch("-1660887490", new Object[]{this});
            return;
        }
        this.mBackgroundPaint.setAlpha(0);
        this.mBackgroundPaint.setAntiAlias(true);
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        this.mBackgroundPaint.setStyle(Paint.Style.FILL);
    }

    private void setBorderPaint() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144775236")) {
            ipChange.ipc$dispatch("-2144775236", new Object[]{this});
            return;
        }
        this.mBorderPaint.setAlpha(0);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth((float) this.mBorderWidth);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    private void setDividerPaint() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-325007721")) {
            ipChange.ipc$dispatch("-325007721", new Object[]{this});
            return;
        }
        this.mDividerPaint.setAlpha(0);
        this.mDividerPaint.setAntiAlias(true);
        this.mDividerPaint.setColor(this.mDividerColor);
        this.mDividerPaint.setStrokeWidth((float) this.mDividerWidth);
        if (this.mDividerType == 1) {
            this.mDividerPaint.setPathEffect(new DashPathEffect(new float[]{(float) this.mDividerDashLength, (float) this.mDividerDashGap}, 0.0f));
            return;
        }
        this.mDividerPaint.setPathEffect(new PathEffect());
    }

    private void setShadowBlurRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1811814947")) {
            ipChange.ipc$dispatch("-1811814947", new Object[]{this, Float.valueOf(f)});
        } else if (isJellyBeanAndAbove()) {
            if (f > 25.0f) {
                f = 25.0f;
            }
            this.mShadowBlurRadius = f;
        }
    }

    public int getBackgroundColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1456928000")) {
            return this.mBackgroundColor;
        }
        return ((Integer) ipChange.ipc$dispatch("-1456928000", new Object[]{this})).intValue();
    }

    public int getBorderColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1535548030")) {
            return this.mBorderColor;
        }
        return ((Integer) ipChange.ipc$dispatch("1535548030", new Object[]{this})).intValue();
    }

    public int getBorderWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "777248059")) {
            return this.mBorderWidth;
        }
        return ((Integer) ipChange.ipc$dispatch("777248059", new Object[]{this})).intValue();
    }

    public int getCornerRadius() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "212339540")) {
            return this.mCornerRadius;
        }
        return ((Integer) ipChange.ipc$dispatch("212339540", new Object[]{this})).intValue();
    }

    public int getCornerType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1933484244")) {
            return this.mCornerType;
        }
        return ((Integer) ipChange.ipc$dispatch("-1933484244", new Object[]{this})).intValue();
    }

    public int getDividerColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1495129073")) {
            return this.mDividerColor;
        }
        return ((Integer) ipChange.ipc$dispatch("1495129073", new Object[]{this})).intValue();
    }

    public int getDividerDashGap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2141108528")) {
            return this.mDividerDashGap;
        }
        return ((Integer) ipChange.ipc$dispatch("-2141108528", new Object[]{this})).intValue();
    }

    public int getDividerDashLength() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1122948100")) {
            return this.mDividerDashLength;
        }
        return ((Integer) ipChange.ipc$dispatch("1122948100", new Object[]{this})).intValue();
    }

    public int getDividerPadding() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1153426819")) {
            return this.mDividerPadding;
        }
        return ((Integer) ipChange.ipc$dispatch("1153426819", new Object[]{this})).intValue();
    }

    public int getDividerType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1477365342")) {
            return this.mDividerType;
        }
        return ((Integer) ipChange.ipc$dispatch("-1477365342", new Object[]{this})).intValue();
    }

    public int getDividerWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "736829102")) {
            return this.mDividerWidth;
        }
        return ((Integer) ipChange.ipc$dispatch("736829102", new Object[]{this})).intValue();
    }

    public int getOrientation() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-573000539")) {
            return this.mOrientation;
        }
        return ((Integer) ipChange.ipc$dispatch("-573000539", new Object[]{this})).intValue();
    }

    public float getScallopPositionPercent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1863992722")) {
            return this.mScallopPositionPercent;
        }
        return ((Float) ipChange.ipc$dispatch("-1863992722", new Object[]{this})).floatValue();
    }

    public int getScallopRadius() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1579849583")) {
            return this.mScallopRadius;
        }
        return ((Integer) ipChange.ipc$dispatch("-1579849583", new Object[]{this})).intValue();
    }

    public int getmScallopPositionPx() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1523208859")) {
            return this.mScallopPositionPx;
        }
        return ((Integer) ipChange.ipc$dispatch("-1523208859", new Object[]{this})).intValue();
    }

    public boolean isShowBorder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1874706915")) {
            return this.mShowBorder;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1874706915", new Object[]{this})).booleanValue();
    }

    public boolean isShowDivider() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1934149264")) {
            return this.mShowDivider;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1934149264", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1147687524")) {
            ipChange.ipc$dispatch("-1147687524", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (this.mDirty) {
            doLayout();
        }
        if (this.mShadowBlurRadius > 0.0f && !isInEditMode()) {
            canvas.drawBitmap(this.mShadow, 0.0f, this.mShadowBlurRadius / 2.0f, (Paint) null);
        }
        canvas.clipPath(this.mPath);
        canvas.drawPath(this.mPath, this.mBackgroundPaint);
        if (this.mShowBorder) {
            canvas.drawPath(this.mPath, this.mBorderPaint);
        }
        if (this.mShowDivider) {
            canvas.drawLine(this.mDividerStartX, this.mDividerStartY, this.mDividerStopX, this.mDividerStopY, this.mDividerPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "959790385")) {
            ipChange.ipc$dispatch("959790385", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int childCount = getChildCount();
        if (childCount > 1) {
            throw new RuntimeException(TAG + "：最多只能有一个直接子布局，请检查布局");
        } else if (childCount == 1) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8) {
                if (z) {
                    this.mDirty = true;
                }
                childAt.layout(this.absLeft, this.absTop, getMeasuredWidth() - this.absRight, getMeasuredHeight() - this.absBottom);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1562902207")) {
            ipChange.ipc$dispatch("1562902207", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        if (childCount > 1) {
            throw new RuntimeException(TAG + "：最多只能有一个直接子布局，请检查布局");
        } else if (childCount == 1) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8) {
                float f = this.mShadowBlurRadius;
                this.absLeft = Math.abs(((int) (((float) getPaddingLeft()) + this.mShadowBlurRadius)) - 0);
                this.absTop = Math.abs(((int) (((float) getPaddingTop()) + (this.mShadowBlurRadius / 2.0f))) - 0);
                this.absRight = Math.abs(((int) (((float) (size - getPaddingRight())) - this.mShadowBlurRadius)) - size);
                this.absBottom = Math.abs(((int) ((((float) (size2 - getPaddingBottom())) - f) - (f / 2.0f))) - size2);
                childAt.measure(View.MeasureSpec.makeMeasureSpec((size - this.absLeft) - this.absRight, mode), View.MeasureSpec.makeMeasureSpec((size2 - this.absTop) - this.absBottom, mode2));
            }
        }
    }

    public void setBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-901936886")) {
            ipChange.ipc$dispatch("-901936886", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mBackgroundColor = i;
        initElements();
    }

    public void setBorderColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1277412172")) {
            ipChange.ipc$dispatch("1277412172", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mBorderColor = i;
        initElements();
    }

    public void setBorderWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-755050449")) {
            ipChange.ipc$dispatch("-755050449", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mBorderWidth = i;
        initElements();
    }

    public void setCornerRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "743860430")) {
            ipChange.ipc$dispatch("743860430", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mCornerRadius = i;
        initElements();
    }

    public void setCornerType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-748592394")) {
            ipChange.ipc$dispatch("-748592394", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mCornerType = i;
        initElements();
    }

    public void setDividerColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1855630289")) {
            ipChange.ipc$dispatch("1855630289", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDividerColor = i;
        initElements();
    }

    public void setDividerDashGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "586385874")) {
            ipChange.ipc$dispatch("586385874", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDividerDashGap = i;
        initElements();
    }

    public void setDividerDashLength(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352398458")) {
            ipChange.ipc$dispatch("-352398458", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDividerDashLength = i;
        initElements();
    }

    public void setDividerPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362233473")) {
            ipChange.ipc$dispatch("-362233473", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDividerPadding = i;
        initElements();
    }

    public void setDividerType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928589144")) {
            ipChange.ipc$dispatch("-1928589144", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDividerType = i;
        initElements();
    }

    public void setDividerWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176832332")) {
            ipChange.ipc$dispatch("-176832332", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDividerWidth = i;
        initElements();
    }

    public void setOrientation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "336915973")) {
            ipChange.ipc$dispatch("336915973", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mOrientation = i;
        initElements();
    }

    public void setScallopPositionPercent(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2073080590")) {
            ipChange.ipc$dispatch("2073080590", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mScallopPositionPercent = f;
        initElements();
    }

    public void setScallopRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953376921")) {
            ipChange.ipc$dispatch("1953376921", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mScallopRadius = i;
        initElements();
    }

    public void setShowBorder(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825814049")) {
            ipChange.ipc$dispatch("825814049", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mShowBorder = z;
        initElements();
    }

    public void setShowDivider(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002025314")) {
            ipChange.ipc$dispatch("2002025314", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mShowDivider = z;
        initElements();
    }

    public void setTicketElevation(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-944911965")) {
            ipChange.ipc$dispatch("-944911965", new Object[]{this, Float.valueOf(f)});
        } else if (isJellyBeanAndAbove()) {
            setShadowBlurRadius(f);
            initElements();
        }
    }

    public void setmScallopPositionPx(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "868487133")) {
            ipChange.ipc$dispatch("868487133", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mScallopPositionPx = i;
        initElements();
    }

    private static int dpToPx(float f, Resources resources) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-152792783")) {
            return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
        }
        return ((Integer) ipChange.ipc$dispatch("-152792783", new Object[]{Float.valueOf(f), resources})).intValue();
    }

    public HoleCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public HoleCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }
}
