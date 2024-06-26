package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.NcovSkuBottomInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMLabelView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class dh1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View b;
    private View c;
    private View d;
    private TextView e;
    private View f;
    private TextView g;
    private View h;
    private TextView i;
    private View j;
    private DMIconFontTextView k;
    private TextView l;
    private DMLabelView m;
    private View n;
    private NcovSkuBottomInfo o = null;
    boolean p = false;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(dh1 dh1) {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1591876725")) {
                ipChange.ipc$dispatch("-1591876725", new Object[]{this, view});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "519413644")) {
                ipChange.ipc$dispatch("519413644", new Object[]{this, view});
            } else if (dh1.this.j != null && dh1.this.j.getVisibility() == 0) {
                dh1.this.g();
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1664263283")) {
                ipChange.ipc$dispatch("-1664263283", new Object[]{this, view});
            } else if (dh1.this.o.pageType == 1) {
                dh1.this.c();
            } else if (dh1.this.o.pageType != 2) {
            } else {
                if (dh1.this.o.buyStatus == 3) {
                    dh1.this.e(true);
                } else {
                    dh1.this.e(false);
                }
            }
        }
    }

    public dh1(View view, View view2, NcovSkuBottomInfo ncovSkuBottomInfo) {
        this.b = view;
        this.c = view2;
        this.o = ncovSkuBottomInfo;
        view.setOnClickListener(new a(this));
        this.a = view.getContext();
        d();
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "909148184")) {
            ipChange.ipc$dispatch("909148184", new Object[]{this});
            return;
        }
        this.d = this.c.findViewById(R$id.layout_bottom_discount_tip);
        this.e = (TextView) this.c.findViewById(R$id.tv_bottom_discount_tip);
        this.f = this.b.findViewById(R$id.layout_bottom_buy_tip);
        this.g = (TextView) this.b.findViewById(R$id.tv_bottom_buy_tip);
        View findViewById = this.b.findViewById(R$id.layout_left);
        this.h = findViewById;
        findViewById.setOnClickListener(new b());
        this.i = (TextView) this.b.findViewById(R$id.tv_price);
        this.j = this.b.findViewById(R$id.layout_price_detail);
        this.k = (DMIconFontTextView) this.b.findViewById(R$id.view_jiantou);
        this.l = (TextView) this.b.findViewById(R$id.tv_price_tip);
        DMLabelView dMLabelView = (DMLabelView) this.b.findViewById(R$id.btn_buy);
        this.m = dMLabelView;
        dMLabelView.setLabelType(DMLabelType.LABEL_TYPE_BUYING).setLabelName("确定").setLabelTextSize(16.0f).setContentGravity(17).setCornerRadii((float) n42.a(this.a, 22.0f), (float) n42.a(this.a, 22.0f), (float) n42.a(this.a, 22.0f), (float) n42.a(this.a, 2.0f));
        this.m.setOnClickListener(new c());
        this.n = this.b.findViewById(R$id.view_translucent);
    }

    public void c() {
        throw null;
    }

    public void e(boolean z) {
        throw null;
    }

    public void f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1912676819")) {
            ipChange.ipc$dispatch("1912676819", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        DMIconFontTextView dMIconFontTextView = this.k;
        if (dMIconFontTextView == null) {
            return;
        }
        if (z) {
            dMIconFontTextView.setText(this.a.getString(R$string.iconfont_shaixuanshang12));
        } else {
            dMIconFontTextView.setText(this.a.getString(R$string.iconfont_shaixuanxia12));
        }
    }

    public void g() {
        throw null;
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "843772991")) {
            ipChange.ipc$dispatch("843772991", new Object[]{this});
        } else if (this.o != null) {
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            if (!TextUtils.isEmpty(this.o.buyTip)) {
                this.f.setVisibility(0);
                this.g.setText(this.o.buyTip);
            }
            if (!TextUtils.isEmpty(this.o.discountTip) && this.o.buyStatus != 2) {
                this.d.setVisibility(0);
                this.e.setText(this.o.discountTip);
            }
            NcovSkuBottomInfo ncovSkuBottomInfo = this.o;
            String str = "确定";
            if (ncovSkuBottomInfo.pageType == 2) {
                this.h.setVisibility(8);
                if (this.o.buyStatus == 3) {
                    this.m.setLabelName("提交开售提醒");
                } else {
                    this.m.setLabelName(str);
                }
            } else {
                int i2 = ncovSkuBottomInfo.buyStatus;
                if (i2 == 1) {
                    DMLabelView dMLabelView = this.m;
                    if (this.p) {
                        str = "特惠购买";
                    }
                    dMLabelView.setLabelName(str);
                    this.h.setVisibility(0);
                } else if (i2 == 2) {
                    this.m.setLabelName("提交缺货登记");
                    this.h.setVisibility(8);
                } else if (i2 == 3) {
                    this.m.setLabelName("提交开售提醒");
                    this.h.setVisibility(8);
                } else if (i2 != 4) {
                    this.m.setLabelName(str);
                    this.h.setVisibility(0);
                } else {
                    this.m.setLabelName(this.p ? "特惠选座" : "去选座");
                    this.h.setVisibility(8);
                }
            }
            this.i.setText(ik1.c(this.o.allPrice));
            if (this.o.promotionAmount == 0.0d) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                TextView textView = this.l;
                textView.setText("已省" + ik1.c(this.o.promotionAmount) + "元");
            }
            NcovSkuBottomInfo ncovSkuBottomInfo2 = this.o;
            if (ncovSkuBottomInfo2.buyStatus != 1 || !ncovSkuBottomInfo2.isCanClickable) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
            }
            if (this.o.isCanClickable) {
                this.m.setClickable(true);
                this.n.setVisibility(8);
                return;
            }
            this.m.setClickable(false);
            this.n.setVisibility(0);
        }
    }

    public void i(PriceBean priceBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1050642466")) {
            ipChange.ipc$dispatch("1050642466", new Object[]{this, priceBean});
            return;
        }
        if (priceBean != null) {
            this.p = priceBean.isDiscount();
        } else {
            this.p = false;
        }
        h();
    }
}
