package cn.damai.ultron.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.custom.ExpandState;
import cn.damai.ultron.utils.DmUltronConstants;
import cn.damai.ultron.view.bean.DmViewerBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.br;
import tb.fa0;
import tb.ma0;
import tb.xf2;

/* compiled from: Taobao */
public class DmBuyerViewAdapter extends RecyclerView.Adapter<PurchaseViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private ExpandState b = ExpandState.HIDE;
    private int c = 2;
    fa0 d;
    private List<DmViewerBean> e;
    private int f;
    Map<String, DmViewerBean> g = new HashMap();

    /* compiled from: Taobao */
    public class PurchaseViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout a;
        private CheckBox b;
        private TextView c;
        private TextView d;
        private TextView e;

        public PurchaseViewHolder(DmBuyerViewAdapter dmBuyerViewAdapter, View view) {
            super(view);
            this.a = (LinearLayout) view.findViewById(R$id.layout_main);
            this.b = (CheckBox) view.findViewById(R$id.checkbox);
            this.c = (TextView) view.findViewById(R$id.text_name);
            this.d = (TextView) view.findViewById(R$id.text_num_type);
            this.e = (TextView) view.findViewById(R$id.text_num);
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PurchaseViewHolder a;

        a(DmBuyerViewAdapter dmBuyerViewAdapter, PurchaseViewHolder purchaseViewHolder) {
            this.a = purchaseViewHolder;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2136870747")) {
                ipChange.ipc$dispatch("-2136870747", new Object[]{this, view});
                return;
            }
            this.a.b.setPressed(true);
            this.a.b.performClick();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(DmBuyerViewAdapter dmBuyerViewAdapter) {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2085709991")) {
                ipChange.ipc$dispatch("2085709991", new Object[]{this, view});
                return;
            }
            ToastUtil.i("该项目暂不支持此证件类型");
        }
    }

    public DmBuyerViewAdapter(Context context) {
        this.a = context;
    }

    /* renamed from: c */
    public void onBindViewHolder(final PurchaseViewHolder purchaseViewHolder, @SuppressLint({"RecyclerView"}) final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "517014374")) {
            ipChange.ipc$dispatch("517014374", new Object[]{this, purchaseViewHolder, Integer.valueOf(i)});
            return;
        }
        final DmViewerBean dmViewerBean = this.e.get(i);
        if (dmViewerBean != null) {
            purchaseViewHolder.c.setText(dmViewerBean.viewerName);
            purchaseViewHolder.d.setText(dmViewerBean.idTypeDesc);
            purchaseViewHolder.e.setText(dmViewerBean.hashIdentityNo);
            purchaseViewHolder.b.setVisibility(0);
            if (!dmViewerBean.isDisabled()) {
                purchaseViewHolder.a.setAlpha(1.0f);
                purchaseViewHolder.a.setEnabled(true);
                purchaseViewHolder.b.setEnabled(true);
                purchaseViewHolder.b.setChecked(dmViewerBean.isUsed());
                if (dmViewerBean.isUsed()) {
                    this.g.put(dmViewerBean.viewerId, dmViewerBean);
                } else if (this.g.containsKey(dmViewerBean.viewerId)) {
                    this.g.remove(dmViewerBean.viewerId);
                }
                purchaseViewHolder.a.setOnClickListener(new a(this, purchaseViewHolder));
                purchaseViewHolder.b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class cn.damai.ultron.view.adapter.DmBuyerViewAdapter.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1747142596")) {
                            ipChange.ipc$dispatch("1747142596", new Object[]{this, compoundButton, Boolean.valueOf(z)});
                        } else if (!z) {
                            DmViewerBean dmViewerBean = dmViewerBean;
                            dmViewerBean.isUsed = "false";
                            if (DmBuyerViewAdapter.this.g.containsKey(dmViewerBean.viewerId)) {
                                DmBuyerViewAdapter.this.g.remove(dmViewerBean.viewerId);
                                DmBuyerViewAdapter dmBuyerViewAdapter = DmBuyerViewAdapter.this;
                                fa0 fa0 = dmBuyerViewAdapter.d;
                                if (fa0 != null) {
                                    fa0.f(dmViewerBean, dmBuyerViewAdapter.g.size());
                                    br.c(DmUltronConstants.UPDATE_CONTACT_COMPONENT_DATA, DmBuyerViewAdapter.this.d.c());
                                }
                            }
                        } else if (DmBuyerViewAdapter.this.g.size() > DmBuyerViewAdapter.this.f - 1) {
                            ToastUtil.i("所需观演人已选齐");
                            purchaseViewHolder.b.setChecked(false);
                        } else {
                            c.e().x(ma0.u().p(DmBuyerViewAdapter.this.a, i, z));
                            DmViewerBean dmViewerBean2 = dmViewerBean;
                            dmViewerBean2.isUsed = "true";
                            DmBuyerViewAdapter.this.g.put(dmViewerBean2.viewerId, dmViewerBean2);
                            DmBuyerViewAdapter dmBuyerViewAdapter2 = DmBuyerViewAdapter.this;
                            if (dmBuyerViewAdapter2.d != null) {
                                if (dmBuyerViewAdapter2.g.size() == DmBuyerViewAdapter.this.f) {
                                    DmBuyerViewAdapter dmBuyerViewAdapter3 = DmBuyerViewAdapter.this;
                                    dmBuyerViewAdapter3.d.a(dmViewerBean, dmBuyerViewAdapter3.g.size());
                                    DmBuyerViewAdapter dmBuyerViewAdapter4 = DmBuyerViewAdapter.this;
                                    dmBuyerViewAdapter4.d.g(dmBuyerViewAdapter4.g);
                                    br.c(DmUltronConstants.REFRESH_CONTACT_COMPONENT_DATA, DmBuyerViewAdapter.this.d.c());
                                    return;
                                }
                                DmBuyerViewAdapter dmBuyerViewAdapter5 = DmBuyerViewAdapter.this;
                                dmBuyerViewAdapter5.d.a(dmViewerBean, dmBuyerViewAdapter5.g.size());
                                br.c(DmUltronConstants.UPDATE_CONTACT_COMPONENT_DATA, DmBuyerViewAdapter.this.d.c());
                            }
                        }
                    }
                });
            } else {
                purchaseViewHolder.a.setAlpha(0.3f);
                purchaseViewHolder.b.setEnabled(false);
                purchaseViewHolder.b.setChecked(dmViewerBean.isUsed());
                if (dmViewerBean.isUsed()) {
                    this.g.put(dmViewerBean.viewerId, dmViewerBean);
                } else if (this.g.containsKey(dmViewerBean.viewerId)) {
                    this.g.remove(dmViewerBean.viewerId);
                }
                purchaseViewHolder.a.setOnClickListener(new b(this));
            }
            if (this.g.size() == this.f) {
                this.d.g(this.g);
            }
        }
    }

    /* renamed from: d */
    public PurchaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1257104336")) {
            return new PurchaseViewHolder(this, LayoutInflater.from(this.a).inflate(R$layout.ultron_ticket_buyer_item, viewGroup, false));
        }
        return (PurchaseViewHolder) ipChange.ipc$dispatch("1257104336", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1168459933")) {
            ipChange.ipc$dispatch("1168459933", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.c = i;
    }

    public void f(ExpandState expandState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "845269672")) {
            ipChange.ipc$dispatch("845269672", new Object[]{this, expandState});
            return;
        }
        this.b = expandState;
    }

    public void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530001916")) {
            ipChange.ipc$dispatch("-1530001916", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.f = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737174444")) {
            return ((Integer) ipChange.ipc$dispatch("-737174444", new Object[]{this})).intValue();
        } else if (this.b == ExpandState.EXPAND) {
            return this.c;
        } else {
            return xf2.e(this.e);
        }
    }

    public void h(fa0 fa0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086040344")) {
            ipChange.ipc$dispatch("-1086040344", new Object[]{this, fa0});
            return;
        }
        this.d = fa0;
        if (fa0 != null) {
            this.e = fa0.e();
        }
    }
}
