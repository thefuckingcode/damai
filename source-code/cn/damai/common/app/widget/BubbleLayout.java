package cn.damai.common.app.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s50;

/* compiled from: Taobao */
public class BubbleLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mArrowDownLeftRadius;
    private int mArrowDownRightRadius;
    private int mArrowTopLeftRadius;
    private int mArrowTopRightRadius;
    private int mBottom;
    private int mBubbleColor;
    private int mBubblePadding;
    private int mBubbleRadius;
    private int mHeight;
    private int mLeft;
    private OnClickEdgeListener mListener;
    private Look mLook;
    private int mLookLength;
    private int mLookPosition;
    private int mLookWidth;
    private Paint mPaint;
    private Path mPath;
    private Region mRegion;
    private int mRight;
    private int mTop;
    private int mWidth;

    /* compiled from: Taobao */
    public enum Look {
        LEFT(1),
        TOP(2),
        RIGHT(3),
        BOTTOM(4);
        
        int value;

        private Look(int i) {
            this.value = i;
        }

        public static Look getType(int i) {
            Look look = BOTTOM;
            if (i == 1) {
                return LEFT;
            }
            if (i == 2) {
                return TOP;
            }
            if (i != 3) {
                return look;
            }
            return RIGHT;
        }
    }

    /* compiled from: Taobao */
    public interface OnClickEdgeListener {
        void edge();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[Look.values().length];
            a = iArr;
            iArr[Look.BOTTOM.ordinal()] = 1;
            a[Look.TOP.ordinal()] = 2;
            a[Look.LEFT.ordinal()] = 3;
            try {
                a[Look.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public BubbleLayout(Context context) {
        this(context, null);
    }

    private void initAttr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931425254")) {
            ipChange.ipc$dispatch("931425254", new Object[]{this});
            return;
        }
        this.mLook = Look.BOTTOM;
        this.mLookPosition = 0;
        this.mLookWidth = s50.a(getContext(), 10.0f);
        this.mLookLength = s50.a(getContext(), 8.0f);
        this.mBubbleRadius = s50.a(getContext(), 8.0f);
        this.mArrowTopLeftRadius = s50.a(getContext(), 0.5f);
        this.mArrowTopRightRadius = s50.a(getContext(), 0.5f);
        this.mArrowDownLeftRadius = s50.a(getContext(), 0.0f);
        this.mArrowDownRightRadius = s50.a(getContext(), 0.0f);
        this.mBubblePadding = s50.a(getContext(), 3.0f);
        this.mBubbleColor = Color.parseColor("#CC000000");
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1245491315")) {
            ipChange.ipc$dispatch("-1245491315", new Object[]{this});
            return;
        }
        Look look = this.mLook;
        this.mLeft = look == Look.LEFT ? this.mLookLength : 0;
        this.mTop = look == Look.TOP ? this.mLookLength : 0;
        this.mRight = this.mWidth - (look == Look.RIGHT ? this.mLookLength : 0);
        int i2 = this.mHeight;
        if (look == Look.BOTTOM) {
            i = this.mLookLength;
        }
        this.mBottom = i2 - i;
        this.mPaint.setColor(this.mBubbleColor);
        this.mPath.reset();
        int i3 = this.mLookPosition;
        int i4 = this.mLookLength;
        int i5 = i3 + i4;
        int i6 = this.mBottom;
        int i7 = i5 > i6 ? i6 - this.mLookWidth : i3;
        int i8 = i4 + i3;
        int i9 = this.mRight;
        if (i8 > i9) {
            i3 = i9 - this.mLookWidth;
        }
        int i10 = a.a[this.mLook.ordinal()];
        if (i10 == 1) {
            int i11 = this.mBubbleRadius;
            int i12 = this.mArrowDownRightRadius;
            if (i3 >= i11 + i12) {
                this.mPath.moveTo((float) (i3 - i12), (float) this.mBottom);
                Path path = this.mPath;
                int i13 = this.mArrowDownRightRadius;
                int i14 = this.mLookWidth;
                float f = ((float) i13) + ((((float) i14) / 2.0f) - ((float) this.mArrowTopRightRadius));
                int i15 = this.mLookLength;
                path.rCubicTo((float) i13, 0.0f, f, (float) i15, (((float) i14) / 2.0f) + ((float) i13), (float) i15);
            } else {
                this.mPath.moveTo(((float) i3) + (((float) this.mLookWidth) / 2.0f), (float) (this.mBottom + this.mLookLength));
            }
            int i16 = this.mLookWidth;
            int i17 = i3 + i16;
            int i18 = this.mRight - this.mBubbleRadius;
            int i19 = this.mArrowDownLeftRadius;
            if (i17 < i18 - i19) {
                int i20 = this.mLookLength;
                this.mPath.rCubicTo((float) this.mArrowTopLeftRadius, 0.0f, ((float) i16) / 2.0f, (float) (-i20), (((float) i16) / 2.0f) + ((float) i19), (float) (-i20));
                this.mPath.lineTo((float) (this.mRight - this.mBubbleRadius), (float) this.mBottom);
            }
            Path path2 = this.mPath;
            int i21 = this.mRight;
            int i22 = this.mBottom;
            path2.quadTo((float) i21, (float) i22, (float) i21, (float) (i22 - this.mBubbleRadius));
            this.mPath.lineTo((float) this.mRight, (float) (this.mTop + this.mBubbleRadius));
            Path path3 = this.mPath;
            int i23 = this.mRight;
            int i24 = this.mTop;
            path3.quadTo((float) i23, (float) i24, (float) (i23 - this.mBubbleRadius), (float) i24);
            this.mPath.lineTo((float) (this.mLeft + this.mBubbleRadius), (float) this.mTop);
            Path path4 = this.mPath;
            int i25 = this.mLeft;
            int i26 = this.mTop;
            path4.quadTo((float) i25, (float) i26, (float) i25, (float) (i26 + this.mBubbleRadius));
            this.mPath.lineTo((float) this.mLeft, (float) (this.mBottom - this.mBubbleRadius));
            int i27 = this.mBubbleRadius;
            if (i3 >= this.mArrowDownRightRadius + i27) {
                Path path5 = this.mPath;
                int i28 = this.mLeft;
                int i29 = this.mBottom;
                path5.quadTo((float) i28, (float) i29, (float) (i28 + i27), (float) i29);
            } else {
                int i30 = this.mBottom;
                this.mPath.quadTo((float) this.mLeft, (float) i30, ((float) i3) + (((float) this.mLookWidth) / 2.0f), (float) (i30 + this.mLookLength));
            }
        } else if (i10 == 2) {
            int i31 = this.mBubbleRadius;
            int i32 = this.mArrowDownLeftRadius;
            if (i3 >= i31 + i32) {
                this.mPath.moveTo((float) (i3 - i32), (float) this.mTop);
                Path path6 = this.mPath;
                int i33 = this.mArrowDownLeftRadius;
                int i34 = this.mLookWidth;
                float f2 = ((float) i33) + ((((float) i34) / 2.0f) - ((float) this.mArrowTopLeftRadius));
                int i35 = this.mLookLength;
                path6.rCubicTo((float) i33, 0.0f, f2, (float) (-i35), (((float) i34) / 2.0f) + ((float) i33), (float) (-i35));
            } else {
                this.mPath.moveTo(((float) i3) + (((float) this.mLookWidth) / 2.0f), (float) (this.mTop - this.mLookLength));
            }
            int i36 = this.mLookWidth;
            int i37 = i3 + i36;
            int i38 = this.mRight - this.mBubbleRadius;
            int i39 = this.mArrowDownRightRadius;
            if (i37 < i38 - i39) {
                int i40 = this.mLookLength;
                this.mPath.rCubicTo((float) this.mArrowTopRightRadius, 0.0f, ((float) i36) / 2.0f, (float) i40, (((float) i36) / 2.0f) + ((float) i39), (float) i40);
                this.mPath.lineTo((float) (this.mRight - this.mBubbleRadius), (float) this.mTop);
            }
            Path path7 = this.mPath;
            int i41 = this.mRight;
            int i42 = this.mTop;
            path7.quadTo((float) i41, (float) i42, (float) i41, (float) (i42 + this.mBubbleRadius));
            this.mPath.lineTo((float) this.mRight, (float) (this.mBottom - this.mBubbleRadius));
            Path path8 = this.mPath;
            int i43 = this.mRight;
            int i44 = this.mBottom;
            path8.quadTo((float) i43, (float) i44, (float) (i43 - this.mBubbleRadius), (float) i44);
            this.mPath.lineTo((float) (this.mLeft + this.mBubbleRadius), (float) this.mBottom);
            Path path9 = this.mPath;
            int i45 = this.mLeft;
            int i46 = this.mBottom;
            path9.quadTo((float) i45, (float) i46, (float) i45, (float) (i46 - this.mBubbleRadius));
            this.mPath.lineTo((float) this.mLeft, (float) (this.mTop + this.mBubbleRadius));
            int i47 = this.mBubbleRadius;
            if (i3 >= this.mArrowDownLeftRadius + i47) {
                Path path10 = this.mPath;
                int i48 = this.mLeft;
                int i49 = this.mTop;
                path10.quadTo((float) i48, (float) i49, (float) (i48 + i47), (float) i49);
            } else {
                int i50 = this.mTop;
                this.mPath.quadTo((float) this.mLeft, (float) i50, ((float) i3) + (((float) this.mLookWidth) / 2.0f), (float) (i50 - this.mLookLength));
            }
        } else if (i10 == 3) {
            int i51 = this.mBubbleRadius;
            int i52 = this.mArrowDownRightRadius;
            if (i7 >= i51 + i52) {
                this.mPath.moveTo((float) this.mLeft, (float) (i7 - i52));
                Path path11 = this.mPath;
                int i53 = this.mArrowDownRightRadius;
                int i54 = this.mLookLength;
                int i55 = this.mLookWidth;
                path11.rCubicTo(0.0f, (float) i53, (float) (-i54), ((((float) i55) / 2.0f) - ((float) this.mArrowTopRightRadius)) + ((float) i53), (float) (-i54), (((float) i55) / 2.0f) + ((float) i53));
            } else {
                this.mPath.moveTo((float) (this.mLeft - this.mLookLength), ((float) i7) + (((float) this.mLookWidth) / 2.0f));
            }
            int i56 = this.mLookWidth;
            int i57 = i7 + i56;
            int i58 = this.mBottom - this.mBubbleRadius;
            int i59 = this.mArrowDownLeftRadius;
            if (i57 < i58 - i59) {
                Path path12 = this.mPath;
                float f3 = (float) this.mArrowTopLeftRadius;
                int i60 = this.mLookLength;
                path12.rCubicTo(0.0f, f3, (float) i60, ((float) i56) / 2.0f, (float) i60, (((float) i56) / 2.0f) + ((float) i59));
                this.mPath.lineTo((float) this.mLeft, (float) (this.mBottom - this.mBubbleRadius));
            }
            Path path13 = this.mPath;
            int i61 = this.mLeft;
            int i62 = this.mBottom;
            path13.quadTo((float) i61, (float) i62, (float) (i61 + this.mBubbleRadius), (float) i62);
            this.mPath.lineTo((float) (this.mRight - this.mBubbleRadius), (float) this.mBottom);
            Path path14 = this.mPath;
            int i63 = this.mRight;
            int i64 = this.mBottom;
            path14.quadTo((float) i63, (float) i64, (float) i63, (float) (i64 - this.mBubbleRadius));
            this.mPath.lineTo((float) this.mRight, (float) (this.mTop + this.mBubbleRadius));
            Path path15 = this.mPath;
            int i65 = this.mRight;
            int i66 = this.mTop;
            path15.quadTo((float) i65, (float) i66, (float) (i65 - this.mBubbleRadius), (float) i66);
            this.mPath.lineTo((float) (this.mLeft + this.mBubbleRadius), (float) this.mTop);
            int i67 = this.mBubbleRadius;
            if (i7 >= this.mArrowDownRightRadius + i67) {
                Path path16 = this.mPath;
                int i68 = this.mLeft;
                int i69 = this.mTop;
                path16.quadTo((float) i68, (float) i69, (float) i68, (float) (i69 + i67));
            } else {
                Path path17 = this.mPath;
                int i70 = this.mLeft;
                path17.quadTo((float) i70, (float) this.mTop, (float) (i70 - this.mLookLength), ((float) i7) + (((float) this.mLookWidth) / 2.0f));
            }
        } else if (i10 == 4) {
            int i71 = this.mBubbleRadius;
            int i72 = this.mArrowDownLeftRadius;
            if (i7 >= i71 + i72) {
                this.mPath.moveTo((float) this.mRight, (float) (i7 - i72));
                Path path18 = this.mPath;
                int i73 = this.mArrowDownLeftRadius;
                int i74 = this.mLookLength;
                int i75 = this.mLookWidth;
                path18.rCubicTo(0.0f, (float) i73, (float) i74, ((((float) i75) / 2.0f) - ((float) this.mArrowTopLeftRadius)) + ((float) i73), (float) i74, (((float) i75) / 2.0f) + ((float) i73));
            } else {
                this.mPath.moveTo((float) (this.mRight + this.mLookLength), ((float) i7) + (((float) this.mLookWidth) / 2.0f));
            }
            int i76 = this.mLookWidth;
            int i77 = i7 + i76;
            int i78 = this.mBottom - this.mBubbleRadius;
            int i79 = this.mArrowDownRightRadius;
            if (i77 < i78 - i79) {
                Path path19 = this.mPath;
                float f4 = (float) this.mArrowTopRightRadius;
                int i80 = this.mLookLength;
                path19.rCubicTo(0.0f, f4, (float) (-i80), ((float) i76) / 2.0f, (float) (-i80), (((float) i76) / 2.0f) + ((float) i79));
                this.mPath.lineTo((float) this.mRight, (float) (this.mBottom - this.mBubbleRadius));
            }
            Path path20 = this.mPath;
            int i81 = this.mRight;
            int i82 = this.mBottom;
            path20.quadTo((float) i81, (float) i82, (float) (i81 - this.mBubbleRadius), (float) i82);
            this.mPath.lineTo((float) (this.mLeft + this.mBubbleRadius), (float) this.mBottom);
            Path path21 = this.mPath;
            int i83 = this.mLeft;
            int i84 = this.mBottom;
            path21.quadTo((float) i83, (float) i84, (float) i83, (float) (i84 - this.mBubbleRadius));
            this.mPath.lineTo((float) this.mLeft, (float) (this.mTop + this.mBubbleRadius));
            Path path22 = this.mPath;
            int i85 = this.mLeft;
            int i86 = this.mTop;
            path22.quadTo((float) i85, (float) i86, (float) (i85 + this.mBubbleRadius), (float) i86);
            this.mPath.lineTo((float) (this.mRight - this.mBubbleRadius), (float) this.mTop);
            int i87 = this.mBubbleRadius;
            if (i7 >= this.mArrowDownLeftRadius + i87) {
                Path path23 = this.mPath;
                int i88 = this.mRight;
                int i89 = this.mTop;
                path23.quadTo((float) i88, (float) i89, (float) i88, (float) (i89 + i87));
            } else {
                Path path24 = this.mPath;
                int i90 = this.mRight;
                path24.quadTo((float) i90, (float) this.mTop, (float) (i90 + this.mLookLength), ((float) i7) + (((float) this.mLookWidth) / 2.0f));
            }
        }
        this.mPath.close();
    }

    public int getArrowDownLeftRadius() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1511283052")) {
            return this.mArrowDownLeftRadius;
        }
        return ((Integer) ipChange.ipc$dispatch("1511283052", new Object[]{this})).intValue();
    }

    public int getArrowDownRightRadius() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1745803869")) {
            return this.mArrowDownRightRadius;
        }
        return ((Integer) ipChange.ipc$dispatch("1745803869", new Object[]{this})).intValue();
    }

    public int getArrowTopLeftRadius() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1243604091")) {
            return this.mArrowTopLeftRadius;
        }
        return ((Integer) ipChange.ipc$dispatch("1243604091", new Object[]{this})).intValue();
    }

    public int getArrowTopRightRadius() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2037690670")) {
            return this.mArrowTopRightRadius;
        }
        return ((Integer) ipChange.ipc$dispatch("2037690670", new Object[]{this})).intValue();
    }

    public int getBubbleColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-161459079")) {
            return this.mBubbleColor;
        }
        return ((Integer) ipChange.ipc$dispatch("-161459079", new Object[]{this})).intValue();
    }

    public int getBubbleRadius() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "641315010")) {
            return this.mBubbleRadius;
        }
        return ((Integer) ipChange.ipc$dispatch("641315010", new Object[]{this})).intValue();
    }

    public Look getLook() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "690100254")) {
            return this.mLook;
        }
        return (Look) ipChange.ipc$dispatch("690100254", new Object[]{this});
    }

    public int getLookLength() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2060018885")) {
            return this.mLookLength;
        }
        return ((Integer) ipChange.ipc$dispatch("-2060018885", new Object[]{this})).intValue();
    }

    public int getLookPosition() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1421690920")) {
            return this.mLookPosition;
        }
        return ((Integer) ipChange.ipc$dispatch("-1421690920", new Object[]{this})).intValue();
    }

    public int getLookWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-757632951")) {
            return this.mLookWidth;
        }
        return ((Integer) ipChange.ipc$dispatch("-757632951", new Object[]{this})).intValue();
    }

    public Paint getPaint() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "230264204")) {
            return this.mPaint;
        }
        return (Paint) ipChange.ipc$dispatch("230264204", new Object[]{this});
    }

    public Path getPath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "627733680")) {
            return this.mPath;
        }
        return (Path) ipChange.ipc$dispatch("627733680", new Object[]{this});
    }

    public void initPadding() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94943614")) {
            ipChange.ipc$dispatch("-94943614", new Object[]{this});
            return;
        }
        int i = this.mBubblePadding;
        int i2 = a.a[this.mLook.ordinal()];
        if (i2 == 1) {
            setPadding(i, i, i, this.mLookLength + i);
        } else if (i2 == 2) {
            setPadding(i, this.mLookLength + i, i, i);
        } else if (i2 == 3) {
            setPadding(this.mLookLength + i, i, i, i);
        } else if (i2 == 4) {
            setPadding(i, i, this.mLookLength + i, i);
        }
    }

    public void invalidate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-537398516")) {
            ipChange.ipc$dispatch("-537398516", new Object[]{this});
            return;
        }
        initData();
        super.invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "783670625")) {
            ipChange.ipc$dispatch("783670625", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724971545")) {
            ipChange.ipc$dispatch("1724971545", new Object[]{this, parcelable});
        } else if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mLookPosition = bundle.getInt("mLookPosition");
            this.mLookWidth = bundle.getInt("mLookWidth");
            this.mLookLength = bundle.getInt("mLookLength");
            this.mBubbleRadius = bundle.getInt("mBubbleRadius");
            this.mBubblePadding = bundle.getInt("mBubblePadding");
            this.mArrowTopLeftRadius = bundle.getInt("mArrowTopLeftRadius");
            this.mArrowTopRightRadius = bundle.getInt("mArrowTopRightRadius");
            this.mArrowDownLeftRadius = bundle.getInt("mArrowDownLeftRadius");
            this.mArrowDownRightRadius = bundle.getInt("mArrowDownRightRadius");
            this.mWidth = bundle.getInt("mWidth");
            this.mHeight = bundle.getInt("mHeight");
            this.mLeft = bundle.getInt("mLeft");
            this.mTop = bundle.getInt("mTop");
            this.mRight = bundle.getInt("mRight");
            this.mBottom = bundle.getInt("mBottom");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    public Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814047386")) {
            return (Parcelable) ipChange.ipc$dispatch("-1814047386", new Object[]{this});
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mLookPosition", this.mLookPosition);
        bundle.putInt("mLookWidth", this.mLookWidth);
        bundle.putInt("mLookLength", this.mLookLength);
        bundle.putInt("mBubbleRadius", this.mBubbleRadius);
        bundle.putInt("mBubblePadding", this.mBubblePadding);
        bundle.putInt("mArrowTopLeftRadius", this.mArrowTopLeftRadius);
        bundle.putInt("mArrowTopRightRadius", this.mArrowTopRightRadius);
        bundle.putInt("mArrowDownLeftRadius", this.mArrowDownLeftRadius);
        bundle.putInt("mArrowDownRightRadius", this.mArrowDownRightRadius);
        bundle.putInt("mWidth", this.mWidth);
        bundle.putInt("mHeight", this.mHeight);
        bundle.putInt("mLeft", this.mLeft);
        bundle.putInt("mTop", this.mTop);
        bundle.putInt("mRight", this.mRight);
        bundle.putInt("mBottom", this.mBottom);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1929654225")) {
            ipChange.ipc$dispatch("-1929654225", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        initData();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnClickEdgeListener onClickEdgeListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978826906")) {
            return ((Boolean) ipChange.ipc$dispatch("-978826906", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            RectF rectF = new RectF();
            this.mPath.computeBounds(rectF, true);
            this.mRegion.setPath(this.mPath, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
            if (!this.mRegion.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && (onClickEdgeListener = this.mListener) != null) {
                onClickEdgeListener.edge();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void postInvalidate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15263052")) {
            ipChange.ipc$dispatch("15263052", new Object[]{this});
            return;
        }
        initData();
        super.postInvalidate();
    }

    public void setArrowDownLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-22598114")) {
            ipChange.ipc$dispatch("-22598114", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mArrowDownLeftRadius = i;
    }

    public void setArrowDownRightRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234808549")) {
            ipChange.ipc$dispatch("1234808549", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mArrowDownRightRadius = i;
    }

    public void setArrowTopLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "740342663")) {
            ipChange.ipc$dispatch("740342663", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mArrowTopLeftRadius = i;
    }

    public void setArrowTopRightRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883831140")) {
            ipChange.ipc$dispatch("-883831140", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mArrowTopRightRadius = i;
    }

    public void setBubbleColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209799345")) {
            ipChange.ipc$dispatch("209799345", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mBubbleColor = i;
    }

    public void setBubblePadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1457805729")) {
            ipChange.ipc$dispatch("-1457805729", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mBubblePadding = i;
    }

    public void setBubbleRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1157198112")) {
            ipChange.ipc$dispatch("1157198112", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mBubbleRadius = i;
    }

    public void setLook(Look look) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "299888024")) {
            ipChange.ipc$dispatch("299888024", new Object[]{this, look});
            return;
        }
        this.mLook = look;
        initPadding();
    }

    public void setLookLength(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-376198969")) {
            ipChange.ipc$dispatch("-376198969", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mLookLength = i;
        initPadding();
    }

    public void setLookPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1628523722")) {
            ipChange.ipc$dispatch("1628523722", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mLookPosition = i;
    }

    public void setLookWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "451769313")) {
            ipChange.ipc$dispatch("451769313", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mLookWidth = i;
    }

    public void setOnClickEdgeListener(OnClickEdgeListener onClickEdgeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1314958930")) {
            ipChange.ipc$dispatch("1314958930", new Object[]{this, onClickEdgeListener});
            return;
        }
        this.mListener = onClickEdgeListener;
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRegion = new Region();
        setLayerType(1, null);
        setWillNotDraw(false);
        initAttr();
        Paint paint = new Paint(5);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPath = new Path();
        initPadding();
    }
}
