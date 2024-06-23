package cn.damai.tetris.component.drama.viewholder;

import android.annotation.SuppressLint;
import android.app.Application;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.component.drama.bean.DramaMonthBean;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.tetris.component.drama.bean.DramaWrapBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.f92;
import tb.n42;
import tb.tf;
import tb.xs0;

/* compiled from: Taobao */
public class DramaByMonthViewHolder extends BaseViewHolder<DramaWrapBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private DramaListV1RecyAdapter c;
    private MonthTabAdapter d;
    private RecyclerView e;
    private tf f;
    private boolean g = true;
    private DramaWrapBean h;
    private List<DramaMonthBean> i;
    private HashMap<Integer, DramaMonthBean> j = new HashMap<>();
    private OnDramaByMonthClickListener k;
    private RecyclerView l;

    /* compiled from: Taobao */
    public interface OnDramaByMonthClickListener {
        void expose(View view, DramaV1Bean dramaV1Bean, int i);

        void onAllClick(String str);

        void onDramaClick(DramaV1Bean dramaV1Bean, int i);

        void onTabClick(DramaMonthBean dramaMonthBean, int i);
    }

    /* compiled from: Taobao */
    public class a implements OnItemClickListener<DramaMonthBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void onItemClick(DramaMonthBean dramaMonthBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "282913315")) {
                ipChange.ipc$dispatch("282913315", new Object[]{this, dramaMonthBean, Integer.valueOf(i)});
                return;
            }
            DramaByMonthViewHolder.this.g = false;
            if (DramaByMonthViewHolder.this.d.f(dramaMonthBean)) {
                if (DramaByMonthViewHolder.this.k != null) {
                    DramaByMonthViewHolder.this.k.onTabClick(dramaMonthBean, i);
                }
                int i2 = dramaMonthBean.headPosInTotalList;
                RecyclerView.LayoutManager layoutManager = DramaByMonthViewHolder.this.e.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, DramaByMonthViewHolder.this.b);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements OnItemBindListener<DramaV1Bean> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void exposeItem(View view, DramaV1Bean dramaV1Bean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-466060934")) {
                ipChange.ipc$dispatch("-466060934", new Object[]{this, view, dramaV1Bean, Integer.valueOf(i)});
            } else if (DramaByMonthViewHolder.this.k != null) {
                DramaByMonthViewHolder.this.k.expose(view, dramaV1Bean, i);
            }
        }

        /* renamed from: b */
        public void onItemClick(DramaV1Bean dramaV1Bean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1112147055")) {
                ipChange.ipc$dispatch("1112147055", new Object[]{this, dramaV1Bean, Integer.valueOf(i)});
            } else if (DramaByMonthViewHolder.this.k != null) {
                DramaByMonthViewHolder.this.k.onDramaClick(dramaV1Bean, i);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1406911273")) {
                return ((Boolean) ipChange.ipc$dispatch("1406911273", new Object[]{this, view, motionEvent})).booleanValue();
            }
            DramaByMonthViewHolder.this.g = true;
            return false;
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-808221027")) {
                ipChange.ipc$dispatch("-808221027", new Object[]{this, view});
            } else if (DramaByMonthViewHolder.this.k != null) {
                DramaByMonthViewHolder.this.k.onAllClick(this.a);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public DramaByMonthViewHolder(View view, OnDramaByMonthClickListener onDramaByMonthClickListener) {
        super(view);
        this.k = onDramaByMonthClickListener;
        Application a2 = xs0.a();
        this.b = n42.a(a2, 21.0f);
        this.a = n42.a(a2, 12.0f);
        this.f = new tf(view.findViewById(R$id.card_title_layout));
        this.l = (RecyclerView) view.findViewById(R$id.dbm_tab_recycler);
        this.e = (RecyclerView) view.findViewById(R$id.dbm_drama_recycler);
        MonthTabAdapter monthTabAdapter = new MonthTabAdapter(new a());
        this.d = monthTabAdapter;
        this.l.setAdapter(monthTabAdapter);
        this.l.setLayoutManager(new LinearLayoutManager(a2, 0, false));
        DramaListV1RecyAdapter dramaListV1RecyAdapter = new DramaListV1RecyAdapter(new b());
        this.c = dramaListV1RecyAdapter;
        this.e.setAdapter(dramaListV1RecyAdapter);
        this.e.setLayoutManager(new LinearLayoutManager(a2, 0, false));
        this.e.setOnTouchListener(new c());
        j();
        l();
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1889685677")) {
            ipChange.ipc$dispatch("1889685677", new Object[]{this});
            return;
        }
        this.e.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                boolean z = true;
                if (AndroidInstantRuntime.support(ipChange, "2047928799")) {
                    ipChange.ipc$dispatch("2047928799", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    if (adapter.getItemCount() - 1 != childAdapterPosition) {
                        z = false;
                    }
                    if (childAdapterPosition == 0) {
                        rect.left = DramaByMonthViewHolder.this.b;
                    } else {
                        rect.left = 0;
                    }
                    if (z) {
                        rect.right = DramaByMonthViewHolder.this.b;
                    } else {
                        rect.right = DramaByMonthViewHolder.this.a;
                    }
                }
            }
        });
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1376211434")) {
            ipChange.ipc$dispatch("1376211434", new Object[]{this});
            return;
        }
        this.j.clear();
        if (!f92.d(this.i)) {
            int i2 = 0;
            for (DramaMonthBean dramaMonthBean : this.i) {
                List<DramaV1Bean> list = dramaMonthBean.content;
                if (!f92.d(list)) {
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        this.j.put(Integer.valueOf(i2), dramaMonthBean);
                        i2++;
                    }
                }
            }
        }
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996523153")) {
            ipChange.ipc$dispatch("-1996523153", new Object[]{this});
            return;
        }
        this.e.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-487928263")) {
                    ipChange.ipc$dispatch("-487928263", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                DramaByMonthViewHolder.this.n(recyclerView, i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n(RecyclerView recyclerView, int i2) {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-741098548")) {
            ipChange.ipc$dispatch("-741098548", new Object[]{this, recyclerView, Integer.valueOf(i2)});
        } else if (this.g && i2 != 0 && (childAt = recyclerView.getChildAt(0)) != null) {
            this.d.f(this.j.get(Integer.valueOf(recyclerView.getChildAdapterPosition(childAt))));
        }
    }

    /* renamed from: m */
    public void a(DramaWrapBean dramaWrapBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-233222252")) {
            ipChange.ipc$dispatch("-233222252", new Object[]{this, dramaWrapBean, Integer.valueOf(i2)});
        } else if (dramaWrapBean != null) {
            this.h = dramaWrapBean;
            dramaWrapBean.utParamsInset();
            List<DramaMonthBean> list = this.h.result;
            this.i = list;
            if (f92.d(list)) {
                this.e.setVisibility(8);
                this.l.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                this.l.setVisibility(0);
                this.h.computeScrollPos();
                k();
                this.d.e(this.i, !f92.d(this.i) ? this.i.get(0) : null);
                this.c.c(this.h.getTotalList());
                this.e.post(new Runnable() {
                    /* class cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder.AnonymousClass6 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "699201684")) {
                            ipChange.ipc$dispatch("699201684", new Object[]{this});
                            return;
                        }
                        DramaByMonthViewHolder dramaByMonthViewHolder = DramaByMonthViewHolder.this;
                        dramaByMonthViewHolder.n(dramaByMonthViewHolder.e, -1);
                    }
                });
            }
            CardTitleBean cardTitleBean = this.h.mTitleBean;
            this.f.h(cardTitleBean);
            if (cardTitleBean == null || !cardTitleBean.hasUrl()) {
                this.f.a(null);
            } else {
                this.f.a(new d(cardTitleBean.url));
            }
        }
    }
}
