package cn.damai.ultron.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.utils.DmChooseSwitchListenerImpl;
import cn.damai.ultron.view.bean.DmPromotionOptionsBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class DmUltronPromotionAdapterOld extends RecyclerView.Adapter<DeliveryViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DmPromotionOptionsBean> a;
    private Context b;
    private DmChooseSwitchListenerImpl<DmPromotionOptionsBean> c;
    private String d;
    private boolean e = true;

    /* compiled from: Taobao */
    public class DeliveryViewHolder extends RecyclerView.ViewHolder {
        private View a;
        private TextView b;
        private CheckBox c;

        public DeliveryViewHolder(DmUltronPromotionAdapterOld dmUltronPromotionAdapterOld, View view) {
            super(view);
            this.a = view;
            this.b = (TextView) view.findViewById(R$id.text_name);
            this.c = (CheckBox) view.findViewById(R$id.checkbox);
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ DmPromotionOptionsBean b;

        a(int i, DmPromotionOptionsBean dmPromotionOptionsBean) {
            this.a = i;
            this.b = dmPromotionOptionsBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "298159687")) {
                ipChange.ipc$dispatch("298159687", new Object[]{this, view});
                return;
            }
            DmUltronPromotionAdapterOld.this.e = false;
            DmUltronPromotionAdapterOld.this.h(this.a);
            DmUltronPromotionAdapterOld.this.notifyDataSetChanged();
            DmUltronPromotionAdapterOld.this.c.chooseItemListener(this.b, this.a);
        }
    }

    public DmUltronPromotionAdapterOld(Context context, List<DmPromotionOptionsBean> list, DmChooseSwitchListenerImpl<DmPromotionOptionsBean> dmChooseSwitchListenerImpl) {
        this.b = context;
        this.a = list;
        this.c = dmChooseSwitchListenerImpl;
    }

    private boolean d(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "82299696")) {
            return !TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(str) && this.d.equals(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("82299696", new Object[]{this, str})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1282404390")) {
            ipChange.ipc$dispatch("1282404390", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        for (int i2 = 0; i2 < xf2.e(this.a); i2++) {
            if (i2 == i) {
                this.a.get(i2).checked = true;
            } else {
                this.a.get(i2).checked = false;
            }
        }
    }

    /* renamed from: e */
    public void onBindViewHolder(DeliveryViewHolder deliveryViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107985747")) {
            ipChange.ipc$dispatch("1107985747", new Object[]{this, deliveryViewHolder, Integer.valueOf(i)});
            return;
        }
        DmPromotionOptionsBean dmPromotionOptionsBean = this.a.get(i);
        if (dmPromotionOptionsBean != null) {
            deliveryViewHolder.b.setText(dmPromotionOptionsBean.fullTitle);
            deliveryViewHolder.c.setOnCheckedChangeListener(null);
            if (this.e) {
                dmPromotionOptionsBean.checked = d(dmPromotionOptionsBean.id);
            }
            deliveryViewHolder.c.setChecked(dmPromotionOptionsBean.checked);
            deliveryViewHolder.a.setOnClickListener(new a(i, dmPromotionOptionsBean));
        }
    }

    /* renamed from: f */
    public DeliveryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1087952829")) {
            return new DeliveryViewHolder(this, LayoutInflater.from(this.b).inflate(R$layout.dm_ultron_promotion_item, viewGroup, false));
        }
        return (DeliveryViewHolder) ipChange.ipc$dispatch("-1087952829", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-874092498")) {
            ipChange.ipc$dispatch("-874092498", new Object[]{this, str});
            return;
        }
        this.d = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1645657590")) {
            return xf2.e(this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("1645657590", new Object[]{this})).intValue();
    }
}
