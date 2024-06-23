package tb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import cn.damai.projectfilter.filterbtn.FilterBtn;
import cn.damai.projectfilter.floatcontainer.FloatContainer;
import cn.damai.projectfilter.floatview.FloatLayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class kj0 implements FloatContainer {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewGroup a;
    private FrameLayout b;
    private FilterBtn c;
    private FloatLayer d;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1118728809")) {
                ipChange.ipc$dispatch("1118728809", new Object[]{this, view});
                return;
            }
            kj0.this.hide();
        }
    }

    public kj0(Context context, ViewGroup viewGroup) {
        this.a = viewGroup;
        FrameLayout frameLayout = new FrameLayout(context);
        this.b = frameLayout;
        this.a.addView(frameLayout, -1, -1);
        this.b.setBackgroundColor(ng0.C_A30_000000);
        viewGroup.setOnClickListener(new a());
    }

    @Override // cn.damai.projectfilter.floatcontainer.FloatContainer
    @Nullable
    public FilterBtn getShowAnchor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1833032018")) {
            return this.c;
        }
        return (FilterBtn) ipChange.ipc$dispatch("-1833032018", new Object[]{this});
    }

    @Override // cn.damai.projectfilter.floatcontainer.FloatContainer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-415207319")) {
            ipChange.ipc$dispatch("-415207319", new Object[]{this});
            return;
        }
        FilterBtn filterBtn = this.c;
        if (filterBtn != null) {
            filterBtn.setState(false);
        }
        this.c = null;
        FloatLayer floatLayer = this.d;
        if (floatLayer != null) {
            floatLayer.hide();
        }
        this.d = null;
        this.a.setVisibility(8);
    }

    @Override // cn.damai.projectfilter.floatcontainer.FloatContainer
    public boolean isShowing() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-477958488")) {
            return this.a.getVisibility() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-477958488", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.projectfilter.floatcontainer.FloatContainer
    public void show(FilterBtn filterBtn, FloatLayer floatLayer, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-972493573")) {
            ipChange.ipc$dispatch("-972493573", new Object[]{this, filterBtn, floatLayer, Integer.valueOf(i)});
            return;
        }
        View view = floatLayer.getView();
        if (view != null) {
            FilterBtn filterBtn2 = this.c;
            if (filterBtn2 != null) {
                filterBtn2.setState(false);
            }
            FloatLayer floatLayer2 = this.d;
            if (floatLayer2 != null) {
                floatLayer2.hide();
            }
            this.c = filterBtn;
            this.d = floatLayer;
            filterBtn.setState(true);
            if (view.getParent() == null) {
                this.b.addView(view);
            }
            int childCount = this.b.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.b.getChildAt(i2);
                if (childAt == view) {
                    childAt.setVisibility(0);
                } else {
                    childAt.setVisibility(8);
                }
            }
            if (this.a.getPaddingTop() != i) {
                int paddingLeft = this.a.getPaddingLeft();
                int paddingBottom = this.a.getPaddingBottom();
                this.a.setPadding(paddingLeft, i, this.a.getPaddingRight(), paddingBottom);
            }
            this.a.setVisibility(0);
        }
    }
}
