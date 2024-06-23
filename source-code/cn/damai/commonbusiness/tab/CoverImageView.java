package cn.damai.commonbusiness.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CoverImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mLastHeight;
    private int mLastWidth;
    private Path mPath;
    private RectF mRectF;

    public CoverImageView(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1539026809")) {
            ipChange.ipc$dispatch("-1539026809", new Object[]{this, canvas});
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (this.mLastHeight == height && this.mLastWidth == width) {
            z = false;
        }
        if (z) {
            this.mLastWidth = width;
            this.mLastHeight = height;
            this.mRectF.set(0.0f, 0.0f, (float) width, (float) height);
            if (width <= 0 || height <= 0) {
                this.mPath = null;
            } else {
                Path path = new Path();
                this.mPath = path;
                path.addOval(this.mRectF, Path.Direction.CW);
            }
        }
        canvas.save();
        Path path2 = this.mPath;
        if (path2 != null) {
            canvas.clipPath(path2);
        }
        super.onDraw(canvas);
        canvas.restore();
    }

    public CoverImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPath = new Path();
        this.mRectF = new RectF();
        this.mLastHeight = -1;
        this.mLastWidth = -1;
    }
}
