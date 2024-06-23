package tb;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;

/* compiled from: Taobao */
public abstract class p1 extends BaseLayoutHelper {
    protected boolean a = false;
    protected boolean b = false;
    protected boolean c = false;

    /* access modifiers changed from: protected */
    public void a(int i, Rect rect, VirtualLayoutManager.d dVar, LayoutManagerHelper layoutManagerHelper) {
        int i2 = 0;
        if (layoutManagerHelper.getOrientation() == 1) {
            rect.left = layoutManagerHelper.getPaddingLeft() + this.mMarginLeft + this.mPaddingLeft;
            rect.right = ((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - this.mMarginRight) - this.mPaddingRight;
            if (dVar.f() == -1) {
                int g = dVar.g();
                if (!this.c && !this.b) {
                    i2 = this.mMarginBottom + this.mPaddingBottom;
                }
                int i3 = g - i2;
                rect.bottom = i3;
                rect.top = i3 - i;
                return;
            }
            int g2 = dVar.g();
            if (!this.c && !this.a) {
                i2 = this.mMarginTop + this.mPaddingTop;
            }
            int i4 = g2 + i2;
            rect.top = i4;
            rect.bottom = i4 + i;
            return;
        }
        rect.top = layoutManagerHelper.getPaddingTop() + this.mMarginTop + this.mPaddingTop;
        rect.bottom = ((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingBottom()) - this.mMarginBottom) - this.mPaddingBottom;
        if (dVar.f() == -1) {
            int g3 = dVar.g();
            if (!this.c && !this.b) {
                i2 = this.mMarginRight + this.mPaddingRight;
            }
            int i5 = g3 - i2;
            rect.right = i5;
            rect.left = i5 - i;
            return;
        }
        int g4 = dVar.g();
        if (!this.c && !this.a) {
            i2 = this.mMarginLeft + this.mPaddingLeft;
        }
        int i6 = g4 + i2;
        rect.left = i6;
        rect.right = i6 + i;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        super.afterLayout(recycler, state, i, i2, i3, layoutManagerHelper);
        this.c = false;
    }

    /* access modifiers changed from: protected */
    public boolean b(ViewGroup.LayoutParams layoutParams) {
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams c() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    @Override // com.alibaba.android.vlayout.a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        if (cVar.c) {
            if (!this.b) {
                cVar.a = getRange().e().intValue();
            }
        } else if (!this.a) {
            cVar.a = getRange().d().intValue();
        }
        this.c = true;
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        boolean z3 = true;
        if (layoutManagerHelper.getOrientation() != 1) {
            z3 = false;
        }
        if (z3) {
            if (z) {
                return this.mMarginBottom + this.mPaddingBottom;
            }
            return (-this.mMarginTop) - this.mPaddingTop;
        } else if (z) {
            return this.mMarginRight + this.mPaddingRight;
        } else {
            return (-this.mMarginLeft) - this.mPaddingLeft;
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams d(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public int e(View[] viewArr, RecyclerView.Recycler recycler, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper) {
        View nextView;
        int i = 0;
        boolean z = true;
        if (dVar.e() != 1) {
            z = false;
        }
        sw1<Integer> range = getRange();
        int intValue = (z ? range.d() : range.e()).intValue();
        int c2 = dVar.c();
        if (!z ? c2 > intValue : c2 > intValue) {
            Log.w("FullFillLayoutHelper", "Please handle strange order views carefully");
        }
        int i2 = 0;
        while (i2 < viewArr.length && !isOutOfRange(dVar.c()) && (nextView = nextView(recycler, dVar, layoutManagerHelper, s61)) != null) {
            viewArr[i2] = nextView;
            ViewGroup.LayoutParams layoutParams = nextView.getLayoutParams();
            if (layoutParams == null) {
                nextView.setLayoutParams(c());
            } else if (!b(layoutParams)) {
                nextView.setLayoutParams(d(layoutParams));
            }
            i2++;
        }
        if (i2 > 0 && !z) {
            for (int i3 = i2 - 1; i < i3; i3--) {
                View view = viewArr[i];
                viewArr[i] = viewArr[i3];
                viewArr[i3] = view;
                i++;
            }
        }
        return i2;
    }

    @Override // com.alibaba.android.vlayout.a
    public boolean isRecyclable(int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper, boolean z) {
        sw1<Integer> range = getRange();
        if (!range.a(Integer.valueOf(i))) {
            Log.w("FullFillLayoutHelper", "Child item not match");
            return true;
        } else if (this.a && i == getRange().d().intValue()) {
            return true;
        } else {
            if (this.b && i == getRange().e().intValue()) {
                return true;
            }
            return sw1.c(Integer.valueOf(i2), Integer.valueOf(i3)).b(sw1.c(Integer.valueOf(range.d().intValue() + (this.a ? 1 : 0)), Integer.valueOf(range.e().intValue() - (this.b ? 1 : 0))));
        }
    }
}
