package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.banner.bean.PageBanner;
import cn.damai.commonbusiness.banner.request.OrderDetailBannerRequest;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ta.utdid2.device.UTDevice;
import java.util.HashMap;
import tb.ln2;
import tb.v50;

/* compiled from: Taobao */
public class OrderDetailGuideViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private LinearLayout b = ((LinearLayout) this.itemView.findViewById(R$id.ll_order_banner));
    private ImageView c = ((ImageView) this.itemView.findViewById(R$id.iv_order_banner));

    public OrderDetailGuideViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_manager_list_guide, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = context;
        int i = DisplayMetrics.getwidthPixels(v50.b(this.a));
        this.c.setLayoutParams(new LinearLayout.LayoutParams(i, (i * 80) / 315));
    }

    public void d(final String str, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "520009100")) {
            ipChange.ipc$dispatch("520009100", new Object[]{this, str, str2});
            return;
        }
        OrderDetailBannerRequest orderDetailBannerRequest = new OrderDetailBannerRequest();
        orderDetailBannerRequest.visitorId = UTDevice.getUtdid(this.a);
        orderDetailBannerRequest.request(new DMMtopRequestListener<PageBanner>(PageBanner.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailGuideViewHolder.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailGuideViewHolder$1$a */
            /* compiled from: Taobao */
            public class a implements View.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2009192369")) {
                        ipChange.ipc$dispatch("2009192369", new Object[]{this, view});
                        return;
                    }
                    String str = (String) view.getTag();
                    if (!TextUtils.isEmpty(str)) {
                        c e = c.e();
                        ln2 r = ln2.r();
                        AnonymousClass1 r2 = AnonymousClass1.this;
                        e.x(r.v(str, str2, str));
                        DMNav.from(OrderDetailGuideViewHolder.this.a).toUri(str);
                    }
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1969082890")) {
                    ipChange.ipc$dispatch("1969082890", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailGuideViewHolder.this.b.setVisibility(8);
            }

            public void onSuccess(PageBanner pageBanner) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1532324414")) {
                    ipChange.ipc$dispatch("-1532324414", new Object[]{this, pageBanner});
                } else if (pageBanner == null || TextUtils.isEmpty(pageBanner.picUrl) || TextUtils.isEmpty(pageBanner.schema)) {
                    OrderDetailGuideViewHolder.this.b.setVisibility(8);
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("titlelabel", pageBanner.schema);
                    c.e().G(OrderDetailGuideViewHolder.this.b, "bannerimg", "banners", ln2.ORDER_DETAL_PAGE, hashMap);
                    OrderDetailGuideViewHolder.this.b.setVisibility(0);
                    OrderDetailGuideViewHolder.this.c.setTag(pageBanner.schema);
                    DMImageCreator c = cn.damai.common.image.a.b().c(pageBanner.picUrl);
                    int i = R$drawable.uikit_default_image_bg_grey;
                    c.i(i).c(i).g(OrderDetailGuideViewHolder.this.c);
                    OrderDetailGuideViewHolder.this.c.setOnClickListener(new a());
                }
            }
        });
    }

    public void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-265377847")) {
            ipChange.ipc$dispatch("-265377847", new Object[]{this, str, str2});
            return;
        }
        this.b.setVisibility(8);
        d(str, str2);
    }
}
