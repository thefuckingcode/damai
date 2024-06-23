package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.custom.ExpandState;
import cn.damai.ultron.utils.DmUltronConstants;
import cn.damai.ultron.view.adapter.DmBuyerViewAdapter;
import cn.damai.ultron.view.bean.DmViewerBean;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class pa0 extends h1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final IViewHolderCreator CREATOR = new b();
    private RecyclerView c;
    private DmBuyerViewAdapter d;
    private LinearLayout e;
    private TextView f;
    private ExpandState g = ExpandState.HIDE;
    private Context h;
    private fa0 i;
    private int j = 2;
    View.OnClickListener k = new a();
    private boolean l = true;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1679230883")) {
                ipChange.ipc$dispatch("-1679230883", new Object[]{this, view});
            } else if (pa0.this.g == ExpandState.EXPAND) {
                pa0.this.l();
                pa0.this.d.f(pa0.this.g);
                pa0.this.d.notifyDataSetChanged();
                c.e().x(ma0.u().q(pa0.this.h));
            }
        }
    }

    /* compiled from: Taobao */
    public static final class b implements IViewHolderCreator {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator
        public h1 create(wv2 wv2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1399881899")) {
                return new pa0(wv2);
            }
            return (h1) ipChange.ipc$dispatch("-1399881899", new Object[]{this, wv2});
        }
    }

    public pa0(wv2 wv2) {
        super(wv2);
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "535478142")) {
            ipChange.ipc$dispatch("535478142", new Object[]{this});
            return;
        }
        this.g = ExpandState.HIDE;
        this.e.setVisibility(8);
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940597155")) {
            ipChange.ipc$dispatch("1940597155", new Object[]{this});
            return;
        }
        this.g = ExpandState.EXPAND;
        this.e.setVisibility(0);
        this.f.setText("展开全部");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1627104415")) {
            ipChange.ipc$dispatch("-1627104415", new Object[]{this});
            return;
        }
        this.g = ExpandState.PICKUP;
        this.e.setVisibility(8);
    }

    private void m(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1784663718")) {
            ipChange.ipc$dispatch("1784663718", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 <= this.j) {
            j();
        } else if (this.g == ExpandState.PICKUP) {
            l();
        } else {
            k();
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.h1
    public void d(@NonNull IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687381541")) {
            ipChange.ipc$dispatch("-687381541", new Object[]{this, iDMComponent});
        } else if (iDMComponent != null && (iDMComponent instanceof DMComponent)) {
            try {
                fa0 fa0 = new fa0((DMComponent) iDMComponent);
                this.i = fa0;
                int e2 = xf2.e(fa0.e());
                int b2 = this.i.b();
                this.j = e2;
                m(e2);
                DmBuyerViewAdapter dmBuyerViewAdapter = new DmBuyerViewAdapter(this.h);
                this.d = dmBuyerViewAdapter;
                dmBuyerViewAdapter.h(this.i);
                this.d.g(b2);
                this.d.e(this.j);
                this.d.f(this.g);
                this.c.setAdapter(this.d);
                String[] b3 = l8.Companion.b(w90.b(this.h) + "", this.h);
                if (this.l && b3.length > 0 && e2 > 0) {
                    this.l = false;
                    List<DmViewerBean> e3 = this.i.e();
                    HashMap hashMap = new HashMap();
                    int i2 = 0;
                    for (String str : b3) {
                        if (!TextUtils.isEmpty(str) && i2 < b2) {
                            Iterator<DmViewerBean> it = e3.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                DmViewerBean next = it.next();
                                if (!next.isDisabled() && str.equals(next.viewerId)) {
                                    next.isUsed = "true";
                                    hashMap.put(next.viewerId, next);
                                    this.i.a(next, hashMap.size());
                                    i2++;
                                    break;
                                }
                            }
                        }
                    }
                    this.i.g(hashMap);
                    br.c(DmUltronConstants.REFRESH_CONTACT_COMPONENT_DATA, this.i.c());
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.h1
    public View e(@Nullable ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "167583712")) {
            return (View) ipChange.ipc$dispatch("167583712", new Object[]{this, viewGroup});
        }
        Context l2 = this.a.l();
        this.h = l2;
        View inflate = LayoutInflater.from(l2).inflate(R$layout.ultron_ticket_buyer, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.recycler_main);
        this.c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.h));
        this.e = (LinearLayout) inflate.findViewById(R$id.ll_expend);
        this.f = (TextView) inflate.findViewById(R$id.tv_expend);
        this.e.setVisibility(8);
        this.e.setOnClickListener(this.k);
        return inflate;
    }
}
