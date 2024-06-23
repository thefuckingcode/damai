package cn.damai.commonbusiness.qrcode.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import cn.damai.commonbusiness.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v50;

/* compiled from: Taobao */
public final class ViewfinderView extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int OPAQUE = 255;
    public long ANIMATION_DELAY = 20;
    private int CORNER_PADDING;
    public int SPEEN_DISTANCE;
    private Bitmap bitmapCornerBottomLeft;
    private Bitmap bitmapCornerBottomRight;
    private Bitmap bitmapCornerTopleft;
    private Bitmap bitmapCornerTopright;
    private boolean isFirst = false;
    private Context mContext;
    private int maskColor;
    private DisplayMetrics metrics;
    private final Paint paint;
    private Bitmap saomiao;
    private int slideTop;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.paint = new Paint(1);
        this.metrics = this.mContext.getResources().getDisplayMetrics();
        this.CORNER_PADDING = v50.a(context, 0.0f);
        this.SPEEN_DISTANCE = (int) (this.metrics.density * 10.0f);
        initCornerIcon();
    }

    private void drawRectEdges(Canvas canvas, Rect rect) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857405369")) {
            ipChange.ipc$dispatch("857405369", new Object[]{this, canvas, rect});
            return;
        }
        this.paint.setColor(-1);
        this.paint.setAlpha(255);
        canvas.drawBitmap(this.bitmapCornerTopleft, (float) (rect.left + this.CORNER_PADDING), (float) rect.top, this.paint);
        Bitmap bitmap = this.bitmapCornerTopright;
        canvas.drawBitmap(bitmap, (float) ((rect.right - this.CORNER_PADDING) - bitmap.getWidth()), (float) rect.top, this.paint);
        Bitmap bitmap2 = this.bitmapCornerBottomLeft;
        int i = rect.left;
        int i2 = this.CORNER_PADDING;
        canvas.drawBitmap(bitmap2, (float) (i + i2), (float) (((rect.bottom - i2) - bitmap2.getHeight()) + 2), this.paint);
        Bitmap bitmap3 = this.bitmapCornerBottomRight;
        canvas.drawBitmap(bitmap3, (float) ((rect.right - this.CORNER_PADDING) - bitmap3.getWidth()), (float) (((rect.bottom - this.CORNER_PADDING) - this.bitmapCornerBottomRight.getHeight()) + 2), this.paint);
    }

    private void drawScanningLine(Canvas canvas, Rect rect) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670897826")) {
            ipChange.ipc$dispatch("670897826", new Object[]{this, canvas, rect});
            return;
        }
        int i = this.slideTop + this.SPEEN_DISTANCE;
        this.slideTop = i;
        if (i >= rect.bottom) {
            this.slideTop = rect.top;
        }
        RectF rectF = new RectF();
        Rect rect2 = new Rect();
        int i2 = rect.left;
        rectF.left = (float) i2;
        int i3 = rect.right;
        rectF.right = (float) i3;
        rectF.top = (float) rect.top;
        rectF.bottom = (float) this.slideTop;
        rect2.left = i2;
        rect2.right = i3;
        rect2.top = (int) (((float) this.saomiao.getHeight()) - rectF.height());
        rect2.bottom = this.saomiao.getHeight();
        if (rect2.top < 0) {
            rect2.top = 0;
            rectF.top = rectF.bottom - ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2));
        }
        canvas.drawBitmap(this.saomiao, (Rect) null, rectF, this.paint);
    }

    private Point getScreenSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107858167")) {
            return (Point) ipChange.ipc$dispatch("-1107858167", new Object[]{this});
        }
        DisplayMetrics displayMetrics = this.metrics;
        return new Point(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
    }

    private Rect getViewFinderRect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "704566231")) {
            return (Rect) ipChange.ipc$dispatch("704566231", new Object[]{this});
        }
        Point screenSize = getScreenSize();
        int viewfinderSize = getViewfinderSize();
        int viewfinderSize2 = getViewfinderSize();
        int xVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(screenSize) - viewfinderSize) / 2;
        int yVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(screenSize) - viewfinderSize2) / 2;
        return new Rect(xVar, yVar, viewfinderSize + xVar, viewfinderSize2 + yVar);
    }

    private void initCornerIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1391354503")) {
            ipChange.ipc$dispatch("-1391354503", new Object[]{this});
            return;
        }
        Resources resources = getResources();
        this.maskColor = Color.parseColor("#60000000");
        this.bitmapCornerTopleft = BitmapFactory.decodeResource(resources, R$drawable.qrcode_corner_left_top);
        this.bitmapCornerTopright = BitmapFactory.decodeResource(resources, R$drawable.qrcode_corner_right_top);
        this.bitmapCornerBottomLeft = BitmapFactory.decodeResource(resources, R$drawable.qrcode_corner_left_bottom);
        this.bitmapCornerBottomRight = BitmapFactory.decodeResource(resources, R$drawable.qrcode_corner_right_bottom);
        this.saomiao = BitmapFactory.decodeResource(resources, R$drawable.qrcode_scan_icon);
    }

    public void drawViewfinder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1760070136")) {
            ipChange.ipc$dispatch("-1760070136", new Object[]{this});
            return;
        }
        invalidate();
    }

    public int getViewfinderSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-443541020")) {
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(this.metrics) - v50.a(getContext(), 80.0f);
        }
        return ((Integer) ipChange.ipc$dispatch("-443541020", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858610924")) {
            ipChange.ipc$dispatch("858610924", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mContext = null;
        this.isFirst = false;
        this.metrics = null;
    }

    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2039130959")) {
            ipChange.ipc$dispatch("-2039130959", new Object[]{this, canvas});
            return;
        }
        try {
            Rect viewFinderRect = getViewFinderRect();
            if (viewFinderRect != null) {
                if (!this.isFirst) {
                    this.isFirst = true;
                    this.slideTop = viewFinderRect.top;
                }
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                this.paint.setColor(this.maskColor);
                float f = (float) width;
                canvas.drawRect(0.0f, 0.0f, f, (float) viewFinderRect.top, this.paint);
                canvas.drawRect(0.0f, (float) viewFinderRect.top, (float) viewFinderRect.left, (float) (viewFinderRect.bottom + 1), this.paint);
                canvas.drawRect((float) (viewFinderRect.right + 1), (float) viewFinderRect.top, f, (float) (viewFinderRect.bottom + 1), this.paint);
                canvas.drawRect(0.0f, (float) (viewFinderRect.bottom + 1), f, (float) height, this.paint);
                drawRectEdges(canvas, viewFinderRect);
                drawScanningLine(canvas, viewFinderRect);
                postInvalidateDelayed(this.ANIMATION_DELAY, viewFinderRect.left, viewFinderRect.top, viewFinderRect.right, viewFinderRect.bottom);
            }
        } catch (Exception unused) {
        }
    }
}
