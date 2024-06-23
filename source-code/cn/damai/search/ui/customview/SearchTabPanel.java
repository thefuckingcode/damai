package cn.damai.search.ui.customview;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.common.user.c;
import cn.damai.homepage.R$id;
import cn.damai.search.ui.customview.XRadioGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.c62;

@SuppressLint({"ClickableViewAccessibility"})
/* compiled from: Taobao */
public class SearchTabPanel {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private RecyclerView.LayoutManager b;
    private RecyclerView.Adapter c;
    private RecyclerView d;
    private int e = -1;
    private boolean f;
    private boolean g;
    private XRadioGroup h;
    private OnRecyclerViewListener i;
    private UtParamsProvider j;

    /* compiled from: Taobao */
    public interface OnRecyclerViewListener {
        void onFirstItemPosition(int i);

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* compiled from: Taobao */
    public interface UtParamsProvider {
        String getAaid();

        String getInputWord();
    }

    /* compiled from: Taobao */
    public class a implements XRadioGroup.OnTouchL {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.search.ui.customview.XRadioGroup.OnTouchL
        public void onTouch() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-3489049")) {
                ipChange.ipc$dispatch("-3489049", new Object[]{this});
                return;
            }
            SearchTabPanel.this.f = false;
            SearchTabPanel.this.g = false;
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1549217178")) {
                return ((Boolean) ipChange.ipc$dispatch("-1549217178", new Object[]{this, view, motionEvent})).booleanValue();
            }
            SearchTabPanel.this.f = true;
            SearchTabPanel.this.g = true;
            if (SearchTabPanel.this.i != null) {
                return SearchTabPanel.this.i.onTouch(view, motionEvent);
            }
            return false;
        }
    }

    public SearchTabPanel(View view, RecyclerView recyclerView, OnRecyclerViewListener onRecyclerViewListener, UtParamsProvider utParamsProvider) {
        this.i = onRecyclerViewListener;
        this.a = view;
        this.j = utParamsProvider;
        XRadioGroup xRadioGroup = (XRadioGroup) view.findViewById(R$id.search_top_tab_layout);
        this.h = xRadioGroup;
        xRadioGroup.mTouchL = new a();
        this.h.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class cn.damai.search.ui.customview.SearchTabPanel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1196926423")) {
                    ipChange.ipc$dispatch("-1196926423", new Object[]{this, radioGroup, Integer.valueOf(i)});
                    return;
                }
                radioGroup.invalidate();
                int childCount = radioGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = radioGroup.getChildAt(i2);
                    if (childAt instanceof RadioButton) {
                        RadioButton radioButton = (RadioButton) childAt;
                        radioButton.setTextSize(1, (float) (i == radioButton.getId() ? 20 : 16));
                    }
                }
                if (!SearchTabPanel.this.f) {
                    SearchTabPanel.this.m(i);
                }
            }
        });
        this.f = true;
        this.h.check(R$id.search_top_tab_show);
        this.d = recyclerView;
        recyclerView.setOnTouchListener(new b());
        this.c = recyclerView.getAdapter();
        p();
        this.b = recyclerView.getLayoutManager();
        l();
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917426670")) {
            ipChange.ipc$dispatch("-1917426670", new Object[]{this});
            return;
        }
        this.d.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.search.ui.customview.SearchTabPanel.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1793792476")) {
                    ipChange.ipc$dispatch("1793792476", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                View childAt = recyclerView.getChildAt(0);
                if (childAt != null) {
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                    if (SearchTabPanel.this.i != null) {
                        SearchTabPanel.this.i.onFirstItemPosition(childAdapterPosition);
                    }
                    if (SearchTabPanel.this.g && SearchTabPanel.this.a.getVisibility() == 0) {
                        if (SearchTabPanel.this.e == -1) {
                            SearchTabPanel searchTabPanel = SearchTabPanel.this;
                            searchTabPanel.e = searchTabPanel.n();
                        }
                        if (SearchTabPanel.this.e >= 0 && childAdapterPosition >= 0) {
                            if (childAdapterPosition >= SearchTabPanel.this.e) {
                                SearchTabPanel.this.q(R$id.search_top_tab_xian, true);
                            } else {
                                SearchTabPanel.this.q(R$id.search_top_tab_show, true);
                            }
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "861026614")) {
            ipChange.ipc$dispatch("861026614", new Object[]{this, Integer.valueOf(i2)});
        } else if (this.c != null && this.d != null && this.b != null) {
            UtParamsProvider utParamsProvider = this.j;
            if (utParamsProvider != null) {
                c.e().x(c62.C().G(this.j.getInputWord(), utParamsProvider.getAaid(), i2 != R$id.search_top_tab_xian));
            }
            if (i2 == R$id.search_top_tab_xian) {
                int n = n();
                if (n >= 0) {
                    RecyclerView.LayoutManager layoutManager = this.b;
                    if (layoutManager instanceof StaggeredGridLayoutManager) {
                        ((StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(n, 0);
                    } else {
                        layoutManager.scrollToPosition(n);
                    }
                }
            } else {
                this.d.scrollToPosition(0);
            }
            this.f = true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1228996560")) {
            return ((Integer) ipChange.ipc$dispatch("1228996560", new Object[]{this})).intValue();
        }
        RecyclerView.Adapter adapter = this.c;
        if (adapter == null) {
            return -1;
        }
        int itemCount = adapter.getItemCount();
        for (int i2 = 0; i2 < itemCount; i2++) {
            if (this.c.getItemViewType(i2) == 1) {
                return i2;
            }
        }
        return -1;
    }

    private void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "337556233")) {
            ipChange.ipc$dispatch("337556233", new Object[]{this});
            return;
        }
        this.c.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            /* class cn.damai.search.ui.customview.SearchTabPanel.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1581545842")) {
                    ipChange.ipc$dispatch("-1581545842", new Object[]{this});
                    return;
                }
                super.onChanged();
                SearchTabPanel.this.e = -1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-943363330")) {
                    ipChange.ipc$dispatch("-943363330", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onItemRangeChanged(i, i2);
                SearchTabPanel.this.e = -1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-432118400")) {
                    ipChange.ipc$dispatch("-432118400", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onItemRangeInserted(i, i2);
                SearchTabPanel.this.e = -1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1937403204")) {
                    ipChange.ipc$dispatch("1937403204", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                    return;
                }
                super.onItemRangeMoved(i, i2, i3);
                SearchTabPanel.this.e = -1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1704501038")) {
                    ipChange.ipc$dispatch("-1704501038", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onItemRangeRemoved(i, i2);
                SearchTabPanel.this.e = -1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "290445146")) {
                    ipChange.ipc$dispatch("290445146", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), obj});
                    return;
                }
                super.onItemRangeChanged(i, i2, obj);
                SearchTabPanel.this.e = -1;
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q(int i2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "567369164")) {
            ipChange.ipc$dispatch("567369164", new Object[]{this, Integer.valueOf(i2), Boolean.valueOf(z)});
            return;
        }
        this.f = z;
        this.h.check(i2);
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-476138665")) {
            ipChange.ipc$dispatch("-476138665", new Object[]{this});
            return;
        }
        this.a.setVisibility(8);
    }

    public void r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1262096238")) {
            ipChange.ipc$dispatch("-1262096238", new Object[]{this});
            return;
        }
        this.a.setVisibility(0);
        q(R$id.search_top_tab_show, true);
    }
}
