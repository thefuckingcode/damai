package tb;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.legacy.widget.Space;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener;
import java.util.LinkedList;

/* compiled from: Taobao */
public class jz1 implements ValueAnimator.AnimatorUpdateListener, RefreshContent, CoordinatorLayoutListener {
    protected View a;
    protected View b;
    protected View c;
    protected View d;
    protected View e;
    protected int f = 0;
    protected boolean g = true;
    protected boolean h = true;
    protected n52 i = new n52();

    public jz1(@NonNull View view) {
        this.c = view;
        this.b = view;
        this.a = view;
    }

    /* access modifiers changed from: protected */
    public void a(View view, RefreshKernel refreshKernel) {
        boolean isInEditMode = this.a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view = c(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!isInEditMode) {
                u60.a(view, refreshKernel, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.c = view2;
        }
    }

    /* access modifiers changed from: protected */
    public View b(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (cc2.isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && cc2.isContentView(childAt)) {
                        return childAt;
                    } else {
                        pointF.offset(pointF2.x, pointF2.y);
                        View b2 = b(childAt, pointF, view2);
                        pointF.offset(-pointF2.x, -pointF2.y);
                        return b2;
                    }
                }
            }
        }
        return view2;
    }

    /* access modifiers changed from: protected */
    public View c(View view, boolean z) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z || view3 != view) && cc2.isContentView(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        linkedList.add(viewGroup.getChildAt(i2));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public boolean canLoadMore() {
        return this.h && this.i.canLoadMore(this.a);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public boolean canRefresh() {
        return this.g && this.i.canRefresh(this.a);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    @NonNull
    public View getScrollableView() {
        return this.c;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    @NonNull
    public View getView() {
        return this.a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void moveSpinner(int i2, int i3, int i4) {
        boolean z;
        View view;
        View view2;
        View findViewById;
        View findViewById2;
        boolean z2 = true;
        if (!(i3 == -1 || (findViewById2 = this.b.findViewById(i3)) == null)) {
            if (i2 > 0) {
                findViewById2.setTranslationY((float) i2);
                z = true;
                if (!(i4 == -1 || (findViewById = this.b.findViewById(i4)) == null)) {
                    if (i2 >= 0) {
                        findViewById.setTranslationY((float) i2);
                        if (z2) {
                            this.b.setTranslationY((float) i2);
                        } else {
                            this.b.setTranslationY(0.0f);
                        }
                        view = this.d;
                        if (view != null) {
                            view.setTranslationY((float) Math.max(0, i2));
                        }
                        view2 = this.e;
                        if (view2 == null) {
                            view2.setTranslationY((float) Math.min(0, i2));
                            return;
                        }
                        return;
                    } else if (findViewById.getTranslationY() < 0.0f) {
                        findViewById.setTranslationY(0.0f);
                    }
                }
                z2 = z;
                if (z2) {
                }
                view = this.d;
                if (view != null) {
                }
                view2 = this.e;
                if (view2 == null) {
                }
            } else if (findViewById2.getTranslationY() > 0.0f) {
                findViewById2.setTranslationY(0.0f);
            }
        }
        z = false;
        if (i2 >= 0) {
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void onActionDown(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset((float) (-this.a.getLeft()), (float) (-this.a.getTop()));
        View view = this.c;
        View view2 = this.a;
        if (view != view2) {
            this.c = b(view2, pointF, view);
        }
        if (this.c == this.a) {
            this.i.mActionEvent = null;
        } else {
            this.i.mActionEvent = pointF;
        }
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = ((float) (intValue - this.f)) * this.c.getScaleY();
            View view = this.c;
            if (view instanceof AbsListView) {
                cc2.scrollListBy((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f = intValue;
    }

    @Override // com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener
    public void onCoordinatorUpdate(boolean z, boolean z2) {
        this.g = z;
        this.h = z2;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public ValueAnimator.AnimatorUpdateListener scrollContentWhenFinished(int i2) {
        View view = this.c;
        if (view == null || i2 == 0) {
            return null;
        }
        if ((i2 >= 0 || !cc2.canScrollVertically(view, 1)) && (i2 <= 0 || !cc2.canScrollVertically(this.c, -1))) {
            return null;
        }
        this.f = i2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void setEnableLoadMoreWhenContentNotFull(boolean z) {
        this.i.mEnableLoadMoreWhenContentNotFull = z;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void setScrollBoundaryDecider(ScrollBoundaryDecider scrollBoundaryDecider) {
        if (scrollBoundaryDecider instanceof n52) {
            this.i = (n52) scrollBoundaryDecider;
        } else {
            this.i.boundary = scrollBoundaryDecider;
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void setUpComponent(RefreshKernel refreshKernel, View view, View view2) {
        a(this.a, refreshKernel);
        if (view != null || view2 != null) {
            this.d = view;
            this.e = view2;
            FrameLayout frameLayout = new FrameLayout(this.a.getContext());
            int indexOfChild = refreshKernel.getRefreshLayout().getLayout().indexOfChild(this.a);
            refreshKernel.getRefreshLayout().getLayout().removeView(this.a);
            frameLayout.addView(this.a, 0, new ViewGroup.LayoutParams(-1, -1));
            refreshKernel.getRefreshLayout().getLayout().addView(frameLayout, indexOfChild, this.a.getLayoutParams());
            this.a = frameLayout;
            if (view != null) {
                view.setTag("fixed-top");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int indexOfChild2 = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                layoutParams.height = cc2.measureViewHeight(view);
                viewGroup.addView(new Space(this.a.getContext()), indexOfChild2, layoutParams);
                frameLayout.addView(view, 1, layoutParams);
            }
            if (view2 != null) {
                view2.setTag("fixed-bottom");
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                int indexOfChild3 = viewGroup2.indexOfChild(view2);
                viewGroup2.removeView(view2);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
                layoutParams2.height = cc2.measureViewHeight(view2);
                viewGroup2.addView(new Space(this.a.getContext()), indexOfChild3, layoutParams2);
                layoutParams3.gravity = 80;
                frameLayout.addView(view2, 1, layoutParams3);
            }
        }
    }
}
