package cn.damai.seat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.g91;

/* compiled from: Taobao */
public class SVGDisplayView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    float dheight = 0.0f;
    float dleft = 0.0f;
    float down1x = 0.0f;
    float down1y = 0.0f;
    float downChang = 0.0f;
    float downx = 0.0f;
    float downy = 0.0f;
    private a drawRegion;
    float dtop = 0.0f;
    float dwidth = 0.0f;
    private boolean fangda;
    private float firstDrawRegionHeight = 0.0f;
    private float firstDrawRegionWidth = 0.0f;
    private float firstHeight = 0.0f;
    private float firstLeft = 0.0f;
    private float firstTop = 0.0f;
    private float firstWidth = 0.0f;
    private boolean firstb = true;
    private Rect mRegionRect;
    private PictureDrawable pictureData;
    private float regionImageHeight;
    private float regionImageWidth;

    /* compiled from: Taobao */
    public class a {
        private static transient /* synthetic */ IpChange $ipChange;
        float a = 0.0f;
        float b = 0.0f;
        float c = 0.0f;
        float d = 0.0f;
        float e = 1.0f;

        public a() {
        }

        public void a(float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1671803119")) {
                ipChange.ipc$dispatch("-1671803119", new Object[]{this, Float.valueOf(f2)});
                return;
            }
            this.a = f2;
            this.e = SVGDisplayView.this.firstDrawRegionWidth / f2;
            this.b = SVGDisplayView.this.firstDrawRegionHeight / this.e;
        }
    }

    public SVGDisplayView(Context context) {
        super(context);
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1715649973")) {
            ipChange.ipc$dispatch("-1715649973", new Object[]{this});
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.drawRegion = new a();
        this.mRegionRect = new Rect();
    }

    private float spacing(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361950876")) {
            return ((Float) ipChange.ipc$dispatch("361950876", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})).floatValue();
        }
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1006062381")) {
            ipChange.ipc$dispatch("1006062381", new Object[]{this, canvas});
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.firstb) {
                PictureDrawable pictureDrawable = this.pictureData;
                this.firstWidth = (float) getWidth();
                this.firstHeight = (float) getHeight();
                this.firstLeft = (float) getLeft();
                this.firstTop = (float) getTop();
                this.regionImageWidth = (float) pictureDrawable.getIntrinsicWidth();
                this.regionImageHeight = (float) pictureDrawable.getIntrinsicHeight();
                float f = this.firstWidth;
                if (((float) pictureDrawable.getIntrinsicWidth()) * this.firstHeight > ((float) pictureDrawable.getIntrinsicHeight()) * f) {
                    a aVar = this.drawRegion;
                    aVar.a = f;
                    aVar.b = (((float) pictureDrawable.getIntrinsicHeight()) * this.firstWidth) / ((float) pictureDrawable.getIntrinsicWidth());
                } else {
                    a aVar2 = this.drawRegion;
                    aVar2.b = this.firstHeight;
                    aVar2.a = (((float) pictureDrawable.getIntrinsicWidth()) * this.firstHeight) / ((float) pictureDrawable.getIntrinsicHeight());
                }
                a aVar3 = this.drawRegion;
                float f2 = aVar3.a;
                this.firstDrawRegionWidth = f2;
                float f3 = aVar3.b;
                this.firstDrawRegionHeight = f3;
                aVar3.c = (this.firstWidth - f2) / 2.0f;
                aVar3.d = (this.firstHeight - f3) / 2.0f;
            }
            Rect rect = this.mRegionRect;
            a aVar4 = this.drawRegion;
            float f4 = aVar4.c;
            float f5 = aVar4.d;
            rect.set((int) f4, (int) f5, (int) (f4 + aVar4.a), (int) (f5 + aVar4.b));
            canvas.drawPicture(this.pictureData.getPicture(), this.mRegionRect);
            if (this.firstb) {
                this.firstb = false;
                a aVar5 = this.drawRegion;
                aVar5.e = this.firstDrawRegionWidth / aVar5.a;
            }
            g91.g("SVG parse", "Region SVG render cost = " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "617741850")) {
            return ((Boolean) ipChange.ipc$dispatch("617741850", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0 && motionEvent.getPointerCount() == 1) {
            this.downx = motionEvent.getX();
            this.downy = motionEvent.getY();
            a aVar = this.drawRegion;
            if (aVar == null) {
                return false;
            }
            this.dleft = aVar.c;
            this.dtop = aVar.d;
            this.dwidth = aVar.a;
            this.dheight = aVar.b;
        }
        if (motionEvent.getAction() == 2) {
            if (motionEvent.getPointerCount() == 1 && !this.fangda) {
                float x = (motionEvent.getX() - this.downx) + this.dleft;
                float f = this.firstWidth;
                if (x > f / 2.0f) {
                    this.drawRegion.c = f / 2.0f;
                } else {
                    float x2 = (motionEvent.getX() - this.downx) + this.dleft;
                    a aVar2 = this.drawRegion;
                    float f2 = aVar2.a;
                    float f3 = this.firstWidth;
                    if (x2 + f2 < f3 / 2.0f) {
                        aVar2.c = (f3 / 2.0f) - f2;
                    } else {
                        aVar2.c = (motionEvent.getX() - this.downx) + this.dleft;
                    }
                }
                float y = (motionEvent.getY() - this.downy) + this.dtop;
                float f4 = this.firstHeight;
                if (y > f4 / 2.0f) {
                    this.drawRegion.d = f4 / 2.0f;
                } else {
                    float y2 = (motionEvent.getY() - this.downy) + this.dtop;
                    a aVar3 = this.drawRegion;
                    float f5 = aVar3.b;
                    float f6 = this.firstHeight;
                    if (y2 + f5 < f6 / 2.0f) {
                        aVar3.d = (f6 / 2.0f) - f5;
                    } else {
                        aVar3.d = (motionEvent.getY() - this.downy) + this.dtop;
                    }
                }
                invalidate();
            } else if (motionEvent.getPointerCount() == 2) {
                if (!this.fangda) {
                    this.downx = motionEvent.getX(0);
                    this.downy = motionEvent.getY(0);
                    this.down1x = motionEvent.getX(1);
                    float y3 = motionEvent.getY(1);
                    this.down1y = y3;
                    this.downChang = spacing(this.downx, this.downy, this.down1x, y3);
                }
                this.fangda = true;
                float x3 = motionEvent.getX();
                float y4 = motionEvent.getY();
                float x4 = motionEvent.getX(1);
                float y5 = motionEvent.getY(1);
                float spacing = spacing(x3, y4, x4, y5);
                float f7 = (x3 + x4) / 2.0f;
                float f8 = (y4 + y5) / 2.0f;
                a aVar4 = this.drawRegion;
                float f9 = aVar4.c;
                float f10 = aVar4.d;
                float f11 = aVar4.a;
                float f12 = aVar4.b;
                float f13 = this.dwidth * (spacing / this.downChang);
                float f14 = this.firstDrawRegionWidth;
                if (f13 / f14 >= 3.0f || ((double) (f13 / f14)) <= 0.6d) {
                    return true;
                }
                aVar4.a(f13);
                a aVar5 = this.drawRegion;
                aVar5.c = f7 - (aVar5.a * ((f7 - f9) / f11));
                aVar5.d = f8 - (aVar5.b * ((f8 - f10) / f12));
                invalidate();
            }
        }
        if (motionEvent.getAction() == 1) {
            this.fangda = false;
        }
        return true;
    }

    public void setPictureData(PictureDrawable pictureDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "73367389")) {
            ipChange.ipc$dispatch("73367389", new Object[]{this, pictureDrawable});
            return;
        }
        this.pictureData = pictureDrawable;
    }

    public SVGDisplayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SVGDisplayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
