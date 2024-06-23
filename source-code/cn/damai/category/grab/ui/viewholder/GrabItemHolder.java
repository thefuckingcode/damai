package cn.damai.category.grab.ui.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.common.listener.ShareImageCallback;
import cn.damai.category.grab.bean.ItemBean;
import cn.damai.category.grab.ui.GrabActivity;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.apache.commons.lang3.time.DateUtils;
import tb.n42;
import tb.rr;
import tb.tz0;
import tb.v50;
import tb.zs0;

/* compiled from: Taobao */
public class GrabItemHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BEING = 2;
    public static final int SELL_OUT = 3;
    public static final int SOON = 1;
    private TextView A;
    private TextView B;
    private ViewGroup C;
    private Context a = this.itemView.getContext();
    private View b;
    private View c;
    private RoundImageView d;
    private View e;
    private DMPosterView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private View o;
    private View p;
    private TextView q;
    private View r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private View y;
    private TextView z;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(GrabItemHolder grabItemHolder) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "514448008")) {
                ipChange.ipc$dispatch("514448008", new Object[]{this, dVar});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ItemBean a;
        final /* synthetic */ ShareImageCallback b;

        b(ItemBean itemBean, ShareImageCallback shareImageCallback) {
            this.a = itemBean;
            this.b = shareImageCallback;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-187578851")) {
                ipChange.ipc$dispatch("-187578851", new Object[]{this, eVar});
            } else if (eVar != null && (bitmap = eVar.b) != null) {
                String d = tz0.d(this.a.verticalPic, bitmap, GrabItemHolder.this.a);
                ShareImageCallback shareImageCallback = this.b;
                if (shareImageCallback != null) {
                    shareImageCallback.callback(this.a.verticalPic, d);
                }
            }
        }
    }

    public GrabItemHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.grab_project_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        View findViewById = this.itemView.findViewById(R$id.layout_shadow);
        this.b = findViewById;
        rr.b(findViewById, Color.parseColor("#ffffff"), v50.a(this.a, 2.0f), Color.parseColor("#09000000"), v50.a(this.a, 3.0f), 0, v50.a(this.a, 3.0f));
        this.c = this.itemView.findViewById(R$id.layout_top);
        this.d = (RoundImageView) this.itemView.findViewById(R$id.image_bg);
        this.e = this.itemView.findViewById(R$id.image_mask);
        this.f = (DMPosterView) this.itemView.findViewById(R$id.poster);
        this.g = (TextView) this.itemView.findViewById(R$id.tv_name);
        this.h = (TextView) this.itemView.findViewById(R$id.tv_time);
        this.i = (TextView) this.itemView.findViewById(R$id.tv_address);
        this.j = this.itemView.findViewById(R$id.layout_see);
        this.k = (TextView) this.itemView.findViewById(R$id.tv_see);
        this.l = (TextView) this.itemView.findViewById(R$id.tv_price);
        this.m = (TextView) this.itemView.findViewById(R$id.tv_price_tip);
        this.n = (TextView) this.itemView.findViewById(R$id.btn_buy);
        this.C = (ViewGroup) this.itemView.findViewById(R$id.ht_ll_tagview);
        this.o = this.itemView.findViewById(R$id.view_xuxian);
        this.p = this.itemView.findViewById(R$id.layout_bottom);
        this.q = (TextView) this.itemView.findViewById(R$id.tv_time_tip);
        this.r = this.itemView.findViewById(R$id.layout_daojishi);
        this.s = (TextView) this.itemView.findViewById(R$id.tv_time1);
        this.t = (TextView) this.itemView.findViewById(R$id.tv_time1_tip);
        this.u = (TextView) this.itemView.findViewById(R$id.tv_time2);
        this.v = (TextView) this.itemView.findViewById(R$id.tv_time3);
        this.w = (TextView) this.itemView.findViewById(R$id.tv_time4);
        this.x = (TextView) this.itemView.findViewById(R$id.btn_see);
        this.y = this.itemView.findViewById(R$id.layout_bottom2);
        this.z = (TextView) this.itemView.findViewById(R$id.tv_selling_tip);
        this.A = (TextView) this.itemView.findViewById(R$id.btn_go_buy);
        this.B = (TextView) this.itemView.findViewById(R$id.tv_qiangwanle);
        int[] iArr = {Color.parseColor("#FF7F81"), Color.parseColor("#FF2D79")};
        rr.d(this.n, iArr, v50.a(this.a, 25.0f), Color.parseColor("#4bFF2D79"), v50.a(this.a, 2.0f), 0, v50.a(this.a, 2.0f));
        rr.d(this.x, iArr, v50.a(this.a, 25.0f), Color.parseColor("#4bFF2D79"), v50.a(this.a, 2.0f), 0, v50.a(this.a, 2.0f));
        rr.d(this.A, iArr, v50.a(this.a, 25.0f), Color.parseColor("#4bFF2D79"), v50.a(this.a, 2.0f), 0, v50.a(this.a, 2.0f));
    }

    private void b(MarketTagBean marketTagBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1151168634")) {
            ipChange.ipc$dispatch("1151168634", new Object[]{this, marketTagBean});
        } else if (marketTagBean != null) {
            if (this.C.getVisibility() != 0) {
                this.C.setVisibility(0);
            }
            marketTagBean.addMarketTagView(this.C, true);
        }
    }

    private String c(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1301861419")) {
            return (String) ipChange.ipc$dispatch("1301861419", new Object[]{this, Long.valueOf(j2)});
        } else if (j2 < 0) {
            return "00";
        } else {
            String str = j2 + "";
            if (TextUtils.isEmpty(str)) {
                return "00";
            }
            if (str.length() != 1) {
                return str;
            }
            return "0" + str;
        }
    }

    private void e(String str, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985723785")) {
            ipChange.ipc$dispatch("1985723785", new Object[]{this, str, str2, Integer.valueOf(i2)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("discount_type", str2);
        }
        c e2 = c.e();
        View view = this.itemView;
        e2.G(view, "item_" + i2, "list", zs0.GRAB_PAGE, hashMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x02e3  */
    public void d(boolean z2, ItemBean itemBean, int i2, ShareImageCallback shareImageCallback) {
        MarketTagBean marketTagBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1647602945")) {
            ipChange.ipc$dispatch("1647602945", new Object[]{this, Boolean.valueOf(z2), itemBean, Integer.valueOf(i2), shareImageCallback});
        } else if (itemBean != null) {
            this.e.setVisibility(8);
            this.f.setImageUrl(itemBean.verticalPic);
            this.f.setCategoryTagName(itemBean.getCategoryNameCompat());
            if (i2 == 0 && !z2) {
                cn.damai.common.image.a.b().f(itemBean.verticalPic, n42.a(this.a, 111.0f), n42.a(this.a, 148.0f)).n(new b(itemBean, shareImageCallback)).e(new a(this)).f();
            }
            this.g.setText(itemBean.name);
            this.h.setText(itemBean.showTime);
            if (TextUtils.isEmpty(itemBean.venueName)) {
                this.i.setText(itemBean.cityName);
            } else {
                this.i.setText(itemBean.cityName + " | " + itemBean.venueName);
            }
            if (!TextUtils.isEmpty(itemBean.ipvuv)) {
                this.j.setVisibility(0);
                this.k.setText(itemBean.ipvuv);
            } else {
                this.j.setVisibility(8);
            }
            if (TextUtils.isEmpty(itemBean.priceLow)) {
                this.l.setTextSize(1, 12.0f);
                this.l.setText("价格待定");
                this.m.setText("");
            } else if (itemBean.priceLow.contains("待定")) {
                this.l.setTextSize(1, 12.0f);
                this.l.setText("价格待定");
                this.m.setText("");
            } else {
                this.l.setTextSize(1, 16.0f);
                this.l.setText("¥" + itemBean.priceLow);
                this.m.setText("起");
            }
            this.B.setVisibility(8);
            this.n.setVisibility(8);
            this.C.setVisibility(4);
            this.C.removeAllViews();
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.y.setVisibility(8);
            int i3 = itemBean.status;
            if (i3 == 1) {
                this.o.setVisibility(0);
                this.p.setVisibility(0);
                this.q.setText(itemBean.onSaleTime);
            } else if (i3 != 2) {
                if (i3 == 3) {
                    this.B.setVisibility(0);
                    this.B.setText(itemBean.title);
                }
            } else if (itemBean.group == 1) {
                this.y.setVisibility(0);
                this.z.setText(itemBean.title);
            } else {
                this.n.setVisibility(0);
                marketTagBean = itemBean.gotTopTag(true);
                b(marketTagBean);
                if (itemBean.group != 1) {
                    TextView textView = this.g;
                    Resources resources = this.a.getResources();
                    int i4 = R$color.white;
                    textView.setTextColor(resources.getColor(i4));
                    this.h.setTextColor(this.a.getResources().getColor(i4));
                    this.i.setTextColor(this.a.getResources().getColor(i4));
                    this.g.setTextColor(this.a.getResources().getColor(i4));
                    this.l.setTextColor(this.a.getResources().getColor(i4));
                    this.m.setTextColor(this.a.getResources().getColor(i4));
                    this.d.setVisibility(0);
                    this.o.setVisibility(8);
                } else {
                    this.g.setTextColor(this.a.getResources().getColor(R$color.color_000000));
                    TextView textView2 = this.h;
                    Resources resources2 = this.a.getResources();
                    int i5 = R$color.color_666666;
                    textView2.setTextColor(resources2.getColor(i5));
                    this.i.setTextColor(this.a.getResources().getColor(i5));
                    this.l.setTextColor(this.a.getResources().getColor(R$color.color_ff2d79));
                    this.m.setTextColor(this.a.getResources().getColor(i5));
                    this.d.setVisibility(8);
                }
                this.s.setVisibility(8);
                this.t.setVisibility(8);
                this.s.setText("00");
                this.u.setText("00");
                this.v.setText("00");
                this.w.setText("00");
                if (itemBean.countdownTime <= 0) {
                    this.r.setVisibility(0);
                    if (itemBean.countdownTime / 86400000 >= 1) {
                        this.s.setVisibility(0);
                        this.t.setVisibility(0);
                    }
                    long j2 = itemBean.countdownTime - ((long) (GrabActivity.second * 1000));
                    if (j2 > 0) {
                        long j3 = j2 / 86400000;
                        long j4 = j2 - (86400000 * j3);
                        long j5 = j4 / DateUtils.MILLIS_PER_HOUR;
                        long j6 = j4 - (DateUtils.MILLIS_PER_HOUR * j5);
                        long j7 = j6 / DateUtils.MILLIS_PER_MINUTE;
                        this.s.setText(c(j3));
                        this.u.setText(c(j5));
                        this.v.setText(c(j7));
                        this.w.setText(c((j6 - (DateUtils.MILLIS_PER_MINUTE * j7)) / 1000));
                    }
                } else {
                    this.r.setVisibility(8);
                }
                if (marketTagBean != null || TextUtils.isEmpty(marketTagBean.type)) {
                    e(itemBean.itemId, null, i2);
                } else {
                    e(itemBean.itemId, marketTagBean.type, i2);
                    return;
                }
            }
            marketTagBean = null;
            if (itemBean.group != 1) {
            }
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            this.s.setText("00");
            this.u.setText("00");
            this.v.setText("00");
            this.w.setText("00");
            if (itemBean.countdownTime <= 0) {
            }
            if (marketTagBean != null) {
            }
            e(itemBean.itemId, null, i2);
        }
    }
}
