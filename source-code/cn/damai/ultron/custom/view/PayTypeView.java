package cn.damai.ultron.custom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.user.c;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.utils.DmUltronConstants;
import cn.damai.ultron.view.bean.DmPayTypeBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.br;
import tb.ma0;
import tb.w90;
import tb.x90;
import tb.xf2;

/* compiled from: Taobao */
public class PayTypeView extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int defaultShowNum;
    private x90 dmPayTypeComponent;
    private Boolean isAllShow;
    private LinearLayout ll_pay_info;
    private LinearLayout ll_pay_type;
    private LinearLayout ll_show_all;
    private Context mContext;
    private View partent;
    private PayTypeItemView selectView;
    private TextView tv_pay_info;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmPayTypeBean a;
        final /* synthetic */ PayTypeItemView b;
        final /* synthetic */ int c;

        a(DmPayTypeBean dmPayTypeBean, PayTypeItemView payTypeItemView, int i) {
            this.a = dmPayTypeBean;
            this.b = payTypeItemView;
            this.c = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1500589078")) {
                ipChange.ipc$dispatch("1500589078", new Object[]{this, view});
            } else if (!this.a.isSelect()) {
                if (PayTypeView.this.selectView != null) {
                    PayTypeView.this.selectView.setChecked(Boolean.FALSE, false);
                }
                this.b.setChecked(Boolean.TRUE, true);
                PayTypeView.this.selectView = this.b;
                br.c(DmUltronConstants.REFRESH_PAYTYPE_COMPONENT_DATA, PayTypeView.this.dmPayTypeComponent.a());
                try {
                    c.e().x(ma0.u().z(this.c, String.valueOf(w90.b(PayTypeView.this.mContext)), this.a.name));
                } catch (Exception unused) {
                }
            }
        }
    }

    public PayTypeView(Context context) {
        this(context, null);
    }

    private void initData(List<DmPayTypeBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1539670545")) {
            ipChange.ipc$dispatch("-1539670545", new Object[]{this, list});
        } else if (xf2.e(list) > 0) {
            this.ll_pay_type.removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    DmPayTypeBean dmPayTypeBean = list.get(i);
                    PayTypeItemView payTypeItemView = new PayTypeItemView(this.mContext);
                    payTypeItemView.setDmPayTypeComponent(this.dmPayTypeComponent);
                    payTypeItemView.setData(dmPayTypeBean);
                    if (dmPayTypeBean.isSelect()) {
                        PayTypeItemView payTypeItemView2 = this.selectView;
                        if (payTypeItemView2 != null) {
                            payTypeItemView2.setChecked(Boolean.FALSE, false);
                        }
                        this.selectView = payTypeItemView;
                        payTypeItemView.setChecked(Boolean.TRUE, false);
                    }
                    payTypeItemView.setOnClickListener(new a(dmPayTypeBean, payTypeItemView, i));
                    if (!this.isAllShow.booleanValue() && i >= this.defaultShowNum) {
                        payTypeItemView.setVisibility(8);
                    }
                    this.ll_pay_type.addView(payTypeItemView);
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("item_id", w90.b(getContext()) + "");
                        hashMap.put("titlelabel", dmPayTypeBean.name);
                        hashMap.put("discount_name", dmPayTypeBean.promotionDesc);
                        c e = c.e();
                        e.G(payTypeItemView, "pay_type_" + i, "pay", "confirm", hashMap);
                    } catch (Exception unused) {
                    }
                } else {
                    return;
                }
            }
            if (this.isAllShow.booleanValue() || list.size() <= this.defaultShowNum) {
                this.isAllShow = Boolean.TRUE;
                this.ll_show_all.setVisibility(8);
            }
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425247709")) {
            ipChange.ipc$dispatch("-425247709", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.ultron_pay_type_item, this);
        this.partent = inflate;
        this.ll_pay_info = (LinearLayout) inflate.findViewById(R$id.ll_pay_info);
        this.ll_pay_type = (LinearLayout) this.partent.findViewById(R$id.ll_pay_type);
        this.ll_show_all = (LinearLayout) this.partent.findViewById(R$id.ll_show_all);
        this.tv_pay_info = (TextView) this.partent.findViewById(R$id.tv_pay_info);
        this.ll_show_all.setOnClickListener(this);
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462158153")) {
            ipChange.ipc$dispatch("1462158153", new Object[]{this, view});
        } else if (view == this.ll_show_all) {
            for (int i = 0; i < this.ll_pay_type.getChildCount(); i++) {
                this.ll_pay_type.getChildAt(i).setVisibility(0);
            }
            this.ll_show_all.setVisibility(8);
            this.isAllShow = Boolean.TRUE;
            try {
                c.e().x(ma0.u().y(this.mContext));
            } catch (Exception unused) {
            }
        }
    }

    public void setDmPayTypeComponent(x90 x90) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1956608309")) {
            ipChange.ipc$dispatch("1956608309", new Object[]{this, x90});
            return;
        }
        this.dmPayTypeComponent = x90;
        if (x90 == null) {
            return;
        }
        if (xf2.e(x90.c()) == 0) {
            this.ll_pay_info.setVisibility(8);
            return;
        }
        this.ll_pay_info.setVisibility(0);
        initData(x90.c());
        this.tv_pay_info.setText(x90.b());
    }

    public PayTypeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PayTypeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.defaultShowNum = 2;
        this.selectView = null;
        this.isAllShow = Boolean.FALSE;
        this.mContext = context;
        initView();
    }
}
