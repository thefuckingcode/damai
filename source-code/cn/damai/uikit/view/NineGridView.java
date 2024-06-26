package cn.damai.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$styleable;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.m42;

/* compiled from: Taobao */
public class NineGridView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MAX_COUNT = 9;
    private static final String TAG = "NineGridView";
    private boolean isPrintLog;
    private a mAdapter;
    private int mChildSpacingPx;
    private Path mCornerRadiusPath;
    private int mCornerRadiusPx;
    private RectF mLastRectF;
    private d mObserver;
    private b mRecycler;
    private RectF mTempRectF;

    /* compiled from: Taobao */
    public interface ViewChangedObserver {
        void notifyDataSetChanged();

        void notifyItemChanged(int i);
    }

    /* compiled from: Taobao */
    public static abstract class a<VH extends c> {
        private static transient /* synthetic */ IpChange $ipChange;
        private ViewChangedObserver a;

        public final void a(boolean z, ViewChangedObserver viewChangedObserver) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-334004479")) {
                ipChange.ipc$dispatch("-334004479", new Object[]{this, Boolean.valueOf(z), viewChangedObserver});
            } else if (z) {
                this.a = viewChangedObserver;
            } else {
                this.a = null;
            }
        }

        public abstract void b(VH vh, int i);

        public abstract VH c(@NonNull ViewGroup viewGroup, int i);

        public final VH d(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1001145769")) {
                return (VH) ((c) ipChange.ipc$dispatch("1001145769", new Object[]{this, viewGroup, Integer.valueOf(i)}));
            }
            VH c = c(viewGroup, i);
            if (c != null) {
                c.b = i;
            }
            return c;
        }

        public abstract int e();

        public int f(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-858475936")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("-858475936", new Object[]{this, Integer.valueOf(i)})).intValue();
        }

        public final void g() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1543126586")) {
                ipChange.ipc$dispatch("1543126586", new Object[]{this});
                return;
            }
            ViewChangedObserver viewChangedObserver = this.a;
            if (viewChangedObserver != null) {
                viewChangedObserver.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: Taobao */
    public class b {
        private static transient /* synthetic */ IpChange $ipChange;
        private final HashMap<Integer, List<c>> a = new HashMap<>();

        public b() {
        }

        public c a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-106123445")) {
                return (c) ipChange.ipc$dispatch("-106123445", new Object[]{this, Integer.valueOf(i)});
            }
            List<c> list = this.a.get(Integer.valueOf(i));
            if (list == null || list.size() <= 0) {
                return null;
            }
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.a.getParent() == null) {
                    it.remove();
                    return next;
                }
                it.remove();
            }
            return null;
        }

        public void b(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-199952")) {
                ipChange.ipc$dispatch("-199952", new Object[]{this, view});
                return;
            }
            Object tag = view.getTag(R$id.id_nine_grid_child_tag);
            if (tag instanceof c) {
                c cVar = (c) tag;
                List<c> list = this.a.get(Integer.valueOf(cVar.b));
                if (list == null) {
                    list = new ArrayList<>(9);
                    this.a.put(Integer.valueOf(cVar.b), list);
                }
                if (!list.contains(cVar)) {
                    if (NineGridView.this.isPrintLog) {
                        NineGridView nineGridView = NineGridView.this;
                        nineGridView.printLog("Recycler collect viewHolder hash=" + cVar.hashCode());
                    }
                    list.add(cVar);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public static class c {
        public final View a;
        public int b = -1;

        public c(View view) {
            this.a = view;
            view.setTag(R$id.id_nine_grid_child_tag, this);
        }
    }

    /* compiled from: Taobao */
    public class d implements ViewChangedObserver {
        private static transient /* synthetic */ IpChange $ipChange;

        public d() {
        }

        @Override // cn.damai.uikit.view.NineGridView.ViewChangedObserver
        public void notifyDataSetChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1443113704")) {
                ipChange.ipc$dispatch("-1443113704", new Object[]{this});
                return;
            }
            NineGridView.this.notifyDataSetChanged();
        }

        @Override // cn.damai.uikit.view.NineGridView.ViewChangedObserver
        public void notifyItemChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "44780526")) {
                ipChange.ipc$dispatch("44780526", new Object[]{this, Integer.valueOf(i)});
            }
        }
    }

    public NineGridView(@NonNull Context context) {
        this(context, null);
    }

    public static String mode2NameStr(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-303791078")) {
            return i != Integer.MIN_VALUE ? i != 1073741824 ? "UNSPECIFIED" : "EXACTLY" : "AT_MOST";
        }
        return (String) ipChange.ipc$dispatch("-303791078", new Object[]{Integer.valueOf(i)});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyDataSetChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402191983")) {
            ipChange.ipc$dispatch("402191983", new Object[]{this});
            return;
        }
        removeAllViews();
        a aVar = this.mAdapter;
        if (aVar != null) {
            int min = Math.min(9, aVar.e());
            for (int i = 0; i < min; i++) {
                int f = this.mAdapter.f(i);
                c a2 = this.mRecycler.a(f);
                boolean z = a2 != null;
                if (a2 == null) {
                    a2 = this.mAdapter.d(this, f);
                }
                if (a2 != null) {
                    addView(a2.a);
                    this.mAdapter.b(a2, i);
                }
                if (this.isPrintLog) {
                    if (z) {
                        printLog("NotifyDataSetChanged use cache holder pos=" + i + " hash=" + a2.hashCode());
                    } else {
                        printLog("NotifyDataSetChanged create new viewHolder pos=" + i + " hash=" + a2.hashCode());
                    }
                }
            }
        }
    }

    private void prepareClipRadiusPathIfAllow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685095830")) {
            ipChange.ipc$dispatch("685095830", new Object[]{this});
            return;
        }
        int childCount = getChildCount();
        if (childCount <= 0 || this.mCornerRadiusPx <= 0) {
            this.mCornerRadiusPath = null;
            return;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (i == 0) {
                this.mTempRectF.set((float) childAt.getLeft(), (float) childAt.getTop(), (float) childAt.getRight(), (float) childAt.getBottom());
            } else {
                this.mTempRectF.left = Math.min((float) childAt.getLeft(), this.mTempRectF.left);
                this.mTempRectF.top = Math.min((float) childAt.getTop(), this.mTempRectF.top);
                this.mTempRectF.right = Math.max((float) childAt.getRight(), this.mTempRectF.right);
                this.mTempRectF.bottom = Math.max((float) childAt.getBottom(), this.mTempRectF.bottom);
            }
        }
        if (!this.mTempRectF.equals(this.mLastRectF)) {
            this.mLastRectF.set(this.mTempRectF);
            Path path = new Path();
            this.mCornerRadiusPath = path;
            RectF rectF = this.mTempRectF;
            int i2 = this.mCornerRadiusPx;
            path.addRoundRect(rectF, (float) i2, (float) i2, Path.Direction.CW);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void printLog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1531919929")) {
            ipChange.ipc$dispatch("-1531919929", new Object[]{this, str});
        } else if (this.isPrintLog) {
            Log.e(TAG, str);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923891889")) {
            ipChange.ipc$dispatch("-1923891889", new Object[]{this, canvas});
            return;
        }
        prepareClipRadiusPathIfAllow();
        if (this.mCornerRadiusPath != null) {
            canvas.save();
            canvas.clipPath(this.mCornerRadiusPath);
        }
        super.dispatchDraw(canvas);
        if (this.mCornerRadiusPath != null) {
            canvas.restore();
        }
    }

    public void enableLog(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2146668801")) {
            ipChange.ipc$dispatch("-2146668801", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isPrintLog = z;
    }

    public void notifyItemChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815868155")) {
            ipChange.ipc$dispatch("-815868155", new Object[]{this, Integer.valueOf(i)});
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        int i5 = 3;
        if (AndroidInstantRuntime.support(ipChange, "1681769737")) {
            ipChange.ipc$dispatch("1681769737", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int childCount = getChildCount();
        if (childCount <= 1) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        if (childCount == 4) {
            i5 = 2;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (i9 != 0 && i9 % i5 == 0) {
                i6 += i7 + this.mChildSpacingPx;
                i7 = 0;
                i8 = 0;
            }
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            childAt.layout(i8, i6, i8 + measuredWidth, i6 + measuredHeight);
            i8 += measuredWidth + this.mChildSpacingPx;
            i7 = Math.max(i7, measuredHeight);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        int i3 = 3;
        if (AndroidInstantRuntime.support(ipChange, "1407229079")) {
            ipChange.ipc$dispatch("1407229079", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int childCount = getChildCount();
        printLog("NineGView onMeasure  childCount=" + childCount);
        if (childCount <= 1) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = (int) (((float) (((mode == 1073741824 || mode == Integer.MIN_VALUE) ? size : (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) ? size2 : getContext() != null ? DisplayMetrics.getwidthPixels(m42.b(getContext())) : 0) - (this.mChildSpacingPx * 2))) / 3.0f);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        if (childCount == 4) {
            i3 = 2;
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            childAt.measure(makeMeasureSpec, makeMeasureSpec2);
            if (i7 < i3) {
                i5 += childAt.getMeasuredWidth() + this.mChildSpacingPx;
            }
            if (i7 % i3 == 0) {
                i6 += childAt.getMeasuredHeight() + this.mChildSpacingPx;
            }
        }
        int i8 = this.mChildSpacingPx;
        int i9 = i5 - i8;
        int i10 = i6 - i8;
        int resolveSize = FrameLayout.resolveSize(i9, i);
        int resolveSize2 = FrameLayout.resolveSize(i10, i2);
        printLog("onMeasure wMode=" + mode2NameStr(mode) + " wSize=" + size + " hMode=" + mode2NameStr(mode2) + " hSize=" + size2);
        printLog("onMeasure childUseWidth=" + i9 + " childUseHeight=" + i10 + " finalW=" + resolveSize + " finalH=" + resolveSize2);
        setMeasuredDimension(resolveSize, resolveSize2);
    }

    public void onViewRemoved(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018990680")) {
            ipChange.ipc$dispatch("2018990680", new Object[]{this, view});
            return;
        }
        this.mRecycler.b(view);
    }

    public void setAdapter(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681346612")) {
            ipChange.ipc$dispatch("-1681346612", new Object[]{this, aVar});
            return;
        }
        a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.a(false, null);
        }
        this.mAdapter = aVar;
        if (aVar != null) {
            aVar.a(true, this.mObserver);
        }
        notifyDataSetChanged();
    }

    public NineGridView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.widget.FrameLayout
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-916071453")) {
            return new FrameLayout.LayoutParams(-2, -2);
        }
        return (FrameLayout.LayoutParams) ipChange.ipc$dispatch("-916071453", new Object[]{this});
    }

    public NineGridView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRecycler = new b();
        this.mObserver = new d();
        this.mTempRectF = new RectF();
        this.mLastRectF = new RectF();
        this.isPrintLog = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NineGridView);
        this.mCornerRadiusPx = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NineGridView_clip_children_bound_radius, 0);
        this.mChildSpacingPx = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NineGridView_nine_child_spacing, 0);
        obtainStyledAttributes.recycle();
    }
}
