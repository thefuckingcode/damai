package cn.damai.uikit.banner.sub;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RoundRadiusImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Path mClipPath;
    private int mLastHeight;
    private int mLastWidth;
    private Paint mPaint;
    private int mRoundRadius;
    private int mStrokeColor;
    private int mStrokeWidth;
    private int mTempRid;

    public RoundRadiusImageView(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        int i;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1617574487")) {
            ipChange.ipc$dispatch("-1617574487", new Object[]{this, canvas});
            return;
        }
        int width = getWidth();
        int height = getHeight();
        boolean z2 = (width == this.mLastWidth && height == this.mLastHeight) ? false : true;
        if (this.mRoundRadius <= 0) {
            this.mClipPath = null;
        } else if (z2) {
            Path path = new Path();
            this.mClipPath = path;
            RectF rectF = new RectF(0.0f, 0.0f, (float) width, (float) height);
            int i2 = this.mRoundRadius;
            path.addRoundRect(rectF, (float) i2, (float) i2, Path.Direction.CW);
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.mClipPath == null) {
            z = false;
        }
        if (z) {
            canvas.save();
            canvas.clipPath(this.mClipPath);
        }
        super.onDraw(canvas);
        if (z) {
            canvas.restore();
        }
        if (this.mClipPath != null && (i = this.mStrokeWidth) > 0) {
            this.mPaint.setStrokeWidth((float) i);
            this.mPaint.setColor(this.mStrokeColor);
            canvas.drawPath(this.mClipPath, this.mPaint);
        }
    }

    public void setRoundRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316190722")) {
            ipChange.ipc$dispatch("1316190722", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRoundRadius = i;
        invalidate();
    }

    public RoundRadiusImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRadiusImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint(1);
        this.mLastWidth = -1;
        this.mLastHeight = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundRadiusImageView);
        this.mRoundRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RoundRadiusImageView_r_round_radius, 0);
        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RoundRadiusImageView_r_stroke_width, 0);
        this.mStrokeColor = obtainStyledAttributes.getColor(R$styleable.RoundRadiusImageView_r_stroke_color, 0);
        obtainStyledAttributes.recycle();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mTempRid = R$drawable.user_v_tag_brand_v2;
    }
}
