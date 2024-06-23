package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import tb.gn0;
import tb.sr1;

/* compiled from: Taobao */
public class TestPagerIndicator extends View implements IPagerIndicator {
    private RectF mInnerRect = new RectF();
    private int mInnerRectColor;
    private RectF mOutRect = new RectF();
    private int mOutRectColor;
    private Paint mPaint;
    private List<sr1> mPositionDataList;

    public TestPagerIndicator(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mOutRectColor = SupportMenu.CATEGORY_MASK;
        this.mInnerRectColor = -16711936;
    }

    public int getInnerRectColor() {
        return this.mInnerRectColor;
    }

    public int getOutRectColor() {
        return this.mOutRectColor;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mOutRectColor);
        canvas.drawRect(this.mOutRect, this.mPaint);
        this.mPaint.setColor(this.mInnerRectColor);
        canvas.drawRect(this.mInnerRect, this.mPaint);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        List<sr1> list = this.mPositionDataList;
        if (list != null && !list.isEmpty()) {
            sr1 a = gn0.a(this.mPositionDataList, i);
            sr1 a2 = gn0.a(this.mPositionDataList, i + 1);
            RectF rectF = this.mOutRect;
            int i3 = a.a;
            rectF.left = ((float) i3) + (((float) (a2.a - i3)) * f);
            int i4 = a.b;
            rectF.top = ((float) i4) + (((float) (a2.b - i4)) * f);
            int i5 = a.c;
            rectF.right = ((float) i5) + (((float) (a2.c - i5)) * f);
            int i6 = a.d;
            rectF.bottom = ((float) i6) + (((float) (a2.d - i6)) * f);
            RectF rectF2 = this.mInnerRect;
            int i7 = a.e;
            rectF2.left = ((float) i7) + (((float) (a2.e - i7)) * f);
            int i8 = a.f;
            rectF2.top = ((float) i8) + (((float) (a2.f - i8)) * f);
            int i9 = a.g;
            rectF2.right = ((float) i9) + (((float) (a2.g - i9)) * f);
            int i10 = a.h;
            rectF2.bottom = ((float) i10) + (((float) (a2.h - i10)) * f);
            invalidate();
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageSelected(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPositionDataProvide(List<sr1> list) {
        this.mPositionDataList = list;
    }

    public void setInnerRectColor(int i) {
        this.mInnerRectColor = i;
    }

    public void setOutRectColor(int i) {
        this.mOutRectColor = i;
    }
}
