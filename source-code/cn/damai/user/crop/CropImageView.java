package cn.damai.user.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import cn.damai.user.crop.HighlightView;
import cn.damai.user.crop.ImageViewTouchBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import tb.w12;

/* compiled from: Taobao */
public class CropImageView extends ImageViewTouchBase {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    ArrayList<HighlightView> highlightViews = new ArrayList<>();
    private float lastX;
    private float lastY;
    private int motionEdge;
    HighlightView motionHighlightView;
    private int validPointerId;

    public CropImageView(Context context2) {
        super(context2);
    }

    private void centerBasedOnHighlightView(HighlightView highlightView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2057964223")) {
            ipChange.ipc$dispatch("2057964223", new Object[]{this, highlightView});
            return;
        }
        Rect rect = highlightView.b;
        float max = Math.max(1.0f, Math.min((((float) getWidth()) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect))) * 0.6f, (((float) getHeight()) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect))) * 0.6f) * getScale());
        if (((double) (Math.abs(max - getScale()) / max)) > 0.1d) {
            float[] fArr = {highlightView.a.centerX(), highlightView.a.centerY()};
            getUnrotatedMatrix().mapPoints(fArr);
            zoomTo(max, fArr[0], fArr[1], 300.0f);
        }
        ensureVisible(highlightView);
    }

    private void ensureVisible(HighlightView highlightView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1544550355")) {
            ipChange.ipc$dispatch("1544550355", new Object[]{this, highlightView});
            return;
        }
        Rect rect = highlightView.b;
        int max = Math.max(0, getLeft() - rect.left);
        int min = Math.min(0, getRight() - rect.right);
        int max2 = Math.max(0, getTop() - rect.top);
        int min2 = Math.min(0, getBottom() - rect.bottom);
        if (max == 0) {
            max = min;
        }
        if (max2 == 0) {
            max2 = min2;
        }
        if (max != 0 || max2 != 0) {
            panBy((float) max, (float) max2);
        }
    }

    public void add(HighlightView highlightView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-454843098")) {
            ipChange.ipc$dispatch("-454843098", new Object[]{this, highlightView});
            return;
        }
        this.highlightViews.add(highlightView);
        invalidate();
    }

    @Override // cn.damai.user.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // cn.damai.user.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ Matrix getUnrotatedMatrix() {
        return super.getUnrotatedMatrix();
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1066637081")) {
            ipChange.ipc$dispatch("1066637081", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        Iterator<HighlightView> it = this.highlightViews.iterator();
        while (it.hasNext()) {
            it.next().c(canvas);
        }
    }

    @Override // cn.damai.user.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.user.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.user.crop.ImageViewTouchBase
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778023406")) {
            ipChange.ipc$dispatch("1778023406", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        if (this.bitmapDisplayed.a() != null) {
            Iterator<HighlightView> it = this.highlightViews.iterator();
            while (it.hasNext()) {
                HighlightView next = it.next();
                next.c.set(getUnrotatedMatrix());
                next.n();
                if (next.l()) {
                    centerBasedOnHighlightView(next);
                }
            }
        }
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        HighlightView.ModifyMode modifyMode;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-714035026")) {
            return ((Boolean) ipChange.ipc$dispatch("-714035026", new Object[]{this, motionEvent})).booleanValue();
        } else if (((CropImageActivity) this.context).q()) {
            return false;
        } else {
            int action = motionEvent.getAction();
            if (action == 0) {
                Iterator<HighlightView> it = this.highlightViews.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HighlightView next = it.next();
                    int h = next.h(motionEvent.getX(), motionEvent.getY());
                    if (h != 1) {
                        this.motionEdge = h;
                        this.motionHighlightView = next;
                        this.lastX = motionEvent.getX();
                        this.lastY = motionEvent.getY();
                        this.validPointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        HighlightView highlightView = this.motionHighlightView;
                        if (h == 32) {
                            modifyMode = HighlightView.ModifyMode.Move;
                        } else {
                            modifyMode = HighlightView.ModifyMode.Grow;
                        }
                        highlightView.r(modifyMode);
                    }
                }
            } else if (action == 1) {
                HighlightView highlightView2 = this.motionHighlightView;
                if (highlightView2 != null) {
                    centerBasedOnHighlightView(highlightView2);
                    this.motionHighlightView.r(HighlightView.ModifyMode.None);
                }
                this.motionHighlightView = null;
                center();
            } else if (action == 2) {
                if (this.motionHighlightView != null && motionEvent.getPointerId(motionEvent.getActionIndex()) == this.validPointerId) {
                    this.motionHighlightView.k(this.motionEdge, motionEvent.getX() - this.lastX, motionEvent.getY() - this.lastY);
                    this.lastX = motionEvent.getX();
                    this.lastY = motionEvent.getY();
                }
                if (getScale() == 1.0f) {
                    center();
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.user.crop.ImageViewTouchBase
    public void postTranslate(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-832161619")) {
            ipChange.ipc$dispatch("-832161619", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        super.postTranslate(f, f2);
        Iterator<HighlightView> it = this.highlightViews.iterator();
        while (it.hasNext()) {
            HighlightView next = it.next();
            next.c.postTranslate(f, f2);
            next.n();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, cn.damai.user.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    @Override // cn.damai.user.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageBitmapResetBase(Bitmap bitmap, boolean z) {
        super.setImageBitmapResetBase(bitmap, z);
    }

    @Override // cn.damai.user.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageRotateBitmapResetBase(w12 w12, boolean z) {
        super.setImageRotateBitmapResetBase(w12, z);
    }

    @Override // cn.damai.user.crop.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setRecycler(ImageViewTouchBase.Recycler recycler) {
        super.setRecycler(recycler);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.user.crop.ImageViewTouchBase
    public void zoomIn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196321047")) {
            ipChange.ipc$dispatch("196321047", new Object[]{this});
            return;
        }
        super.zoomIn();
        Iterator<HighlightView> it = this.highlightViews.iterator();
        while (it.hasNext()) {
            HighlightView next = it.next();
            next.c.set(getUnrotatedMatrix());
            next.n();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.user.crop.ImageViewTouchBase
    public void zoomOut() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1971486560")) {
            ipChange.ipc$dispatch("1971486560", new Object[]{this});
            return;
        }
        super.zoomOut();
        Iterator<HighlightView> it = this.highlightViews.iterator();
        while (it.hasNext()) {
            HighlightView next = it.next();
            next.c.set(getUnrotatedMatrix());
            next.n();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.user.crop.ImageViewTouchBase
    public void zoomTo(float f, float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759776287")) {
            ipChange.ipc$dispatch("1759776287", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        super.zoomTo(f, f2, f3);
        Iterator<HighlightView> it = this.highlightViews.iterator();
        while (it.hasNext()) {
            HighlightView next = it.next();
            next.c.set(getUnrotatedMatrix());
            next.n();
        }
    }

    public CropImageView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
    }

    public CropImageView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
    }
}
