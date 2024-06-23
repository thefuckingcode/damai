package tb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.category.common.listener.ShareImageCallback;
import cn.damai.category.grab.bean.ItemBean;
import cn.damai.category.grab.ui.GrabActivity;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.RoundImageView;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class xm2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BEING = 2;
    public static final int SELL_OUT = 3;
    public static final int SOON = 1;
    private View A;
    private TextView B;
    private TextView C;
    private TextView D;
    public ItemBean E;
    private ShareImageCallback F;
    private Context a;
    private TextView b;
    private TextView c;
    private View d;
    private View e;
    private RoundImageView f;
    private View g;
    private DMPosterView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private View l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private View q;
    private View r;
    private TextView s;
    private View t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ItemBean a;

        a(ItemBean itemBean) {
            this.a = itemBean;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "978232163")) {
                ipChange.ipc$dispatch("978232163", new Object[]{this, dVar});
                return;
            }
            xm2.this.h(this.a);
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ItemBean a;

        b(ItemBean itemBean) {
            this.a = itemBean;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-457883976")) {
                ipChange.ipc$dispatch("-457883976", new Object[]{this, eVar});
            } else if (eVar == null || (bitmap = eVar.b) == null) {
                xm2.this.h(this.a);
            } else {
                String d = tz0.d(this.a.verticalPic, bitmap, xm2.this.a);
                if (xm2.this.F != null) {
                    xm2.this.F.callback(this.a.verticalPic, d);
                }
                if (this.a.group == 1) {
                    Bitmap b2 = l01.b(xm2.this.a, this.a.verticalPic, eVar.b, 20);
                    int e = DMRGBUtil.e(0.7f, eVar.b);
                    if (b2 != null) {
                        xm2.this.f.setImageBitmap(b2);
                        xm2.this.g.setVisibility(0);
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setShape(0);
                        gradientDrawable.setGradientType(0);
                        gradientDrawable.setCornerRadius((float) ScreenUtil.dip2px(xm2.this.a, 3.0f));
                        gradientDrawable.setColor(e);
                        xm2.this.g.setBackgroundDrawable(gradientDrawable);
                        return;
                    }
                    xm2.this.h(this.a);
                }
            }
        }
    }

    public xm2(Activity activity, View view, ShareImageCallback shareImageCallback) {
        this.a = view.getContext();
        this.F = shareImageCallback;
        this.b = (TextView) view.findViewById(R$id.tv_title);
        this.c = (TextView) view.findViewById(R$id.tv_subtitle);
        View findViewById = view.findViewById(R$id.layout_shadow);
        this.d = findViewById;
        rr.b(findViewById, Color.parseColor("#ffffff"), v50.a(this.a, 2.0f), Color.parseColor("#09000000"), v50.a(this.a, 3.0f), 0, v50.a(this.a, 3.0f));
        this.e = view.findViewById(R$id.layout_top);
        this.f = (RoundImageView) view.findViewById(R$id.image_bg);
        this.g = view.findViewById(R$id.image_mask);
        this.h = (DMPosterView) view.findViewById(R$id.poster);
        this.i = (TextView) view.findViewById(R$id.tv_name);
        this.j = (TextView) view.findViewById(R$id.tv_time);
        this.k = (TextView) view.findViewById(R$id.tv_address);
        this.l = view.findViewById(R$id.layout_see);
        this.m = (TextView) view.findViewById(R$id.tv_see);
        this.n = (TextView) view.findViewById(R$id.tv_price);
        this.o = (TextView) view.findViewById(R$id.tv_price_tip);
        this.p = (TextView) view.findViewById(R$id.btn_buy);
        this.q = view.findViewById(R$id.view_xuxian);
        this.r = view.findViewById(R$id.layout_bottom);
        this.s = (TextView) view.findViewById(R$id.tv_time_tip);
        this.t = view.findViewById(R$id.layout_daojishi);
        this.u = (TextView) view.findViewById(R$id.tv_time1);
        this.v = (TextView) view.findViewById(R$id.tv_time1_tip);
        this.w = (TextView) view.findViewById(R$id.tv_time2);
        this.x = (TextView) view.findViewById(R$id.tv_time3);
        this.y = (TextView) view.findViewById(R$id.tv_time4);
        this.z = (TextView) view.findViewById(R$id.btn_see);
        this.A = view.findViewById(R$id.layout_bottom2);
        this.B = (TextView) view.findViewById(R$id.tv_selling_tip);
        this.C = (TextView) view.findViewById(R$id.btn_go_buy);
        this.D = (TextView) view.findViewById(R$id.tv_qiangwanle);
        int[] iArr = {Color.parseColor("#FF7F81"), Color.parseColor("#FF2D79")};
        rr.d(this.p, iArr, v50.a(this.a, 25.0f), Color.parseColor("#4bFF2D79"), v50.a(this.a, 2.0f), 0, v50.a(this.a, 2.0f));
        rr.d(this.z, iArr, v50.a(this.a, 25.0f), Color.parseColor("#4bFF2D79"), v50.a(this.a, 2.0f), 0, v50.a(this.a, 2.0f));
        rr.d(this.C, iArr, v50.a(this.a, 25.0f), Color.parseColor("#4bFF2D79"), v50.a(this.a, 2.0f), 0, v50.a(this.a, 2.0f));
    }

    private String f(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "981453062")) {
            return (String) ipChange.ipc$dispatch("981453062", new Object[]{this, Long.valueOf(j2)});
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

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h(ItemBean itemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "93601205")) {
            ipChange.ipc$dispatch("93601205", new Object[]{this, itemBean});
        } else if (itemBean != null && itemBean.group == 1) {
            this.f.setImageDrawable(this.a.getResources().getDrawable(R$drawable.grab_image_bg));
        }
    }

    public void g(ItemBean itemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059998272")) {
            ipChange.ipc$dispatch("-1059998272", new Object[]{this, itemBean});
        } else if (itemBean != null) {
            this.E = itemBean;
            this.h.setImageUrl(itemBean.verticalPic);
            this.h.setCategoryTagName(itemBean.getCategoryNameCompat());
            this.b.setText(itemBean.groupTitle);
            if (itemBean.group == 1) {
                this.b.setTextSize(1, 24.0f);
            } else {
                this.b.setTextSize(1, 20.0f);
            }
            this.c.setText(itemBean.groupTip);
            this.g.setVisibility(8);
            cn.damai.common.image.a.b().f(itemBean.verticalPic, n42.a(this.a, 111.0f), n42.a(this.a, 148.0f)).n(new b(itemBean)).e(new a(itemBean)).f();
            this.i.setText(itemBean.name);
            this.j.setText(itemBean.showTime);
            if (TextUtils.isEmpty(itemBean.venueName)) {
                this.k.setText(itemBean.cityName);
            } else {
                TextView textView = this.k;
                textView.setText(itemBean.cityName + " | " + itemBean.venueName);
            }
            if (!TextUtils.isEmpty(itemBean.ipvuv)) {
                this.l.setVisibility(0);
                this.m.setText(itemBean.ipvuv);
            } else {
                this.l.setVisibility(8);
            }
            if (TextUtils.isEmpty(itemBean.priceLow)) {
                this.n.setTextSize(1, 12.0f);
                this.n.setText("价格待定");
                this.o.setText("");
            } else if (itemBean.priceLow.contains("待定")) {
                this.n.setTextSize(1, 12.0f);
                this.n.setText("价格待定");
                this.o.setText("");
            } else {
                this.n.setTextSize(1, 16.0f);
                TextView textView2 = this.n;
                textView2.setText("¥" + itemBean.priceLow);
                this.o.setText("起");
            }
            this.D.setVisibility(8);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.A.setVisibility(8);
            int i2 = itemBean.status;
            if (i2 == 1) {
                this.q.setVisibility(0);
                this.r.setVisibility(0);
                this.s.setText(itemBean.onSaleTime);
            } else if (i2 != 2) {
                if (i2 == 3) {
                    this.D.setVisibility(0);
                    this.D.setText(itemBean.title);
                }
            } else if (itemBean.group == 1) {
                this.A.setVisibility(0);
                this.B.setText(itemBean.title);
            } else {
                this.p.setVisibility(0);
            }
            if (itemBean.group == 1) {
                TextView textView3 = this.i;
                Resources resources = this.a.getResources();
                int i3 = R$color.white;
                textView3.setTextColor(resources.getColor(i3));
                this.j.setTextColor(this.a.getResources().getColor(i3));
                this.k.setTextColor(this.a.getResources().getColor(i3));
                this.i.setTextColor(this.a.getResources().getColor(i3));
                this.n.setTextColor(this.a.getResources().getColor(i3));
                this.o.setTextColor(this.a.getResources().getColor(i3));
                this.f.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.i.setTextColor(this.a.getResources().getColor(R$color.color_000000));
                TextView textView4 = this.j;
                Resources resources2 = this.a.getResources();
                int i4 = R$color.color_666666;
                textView4.setTextColor(resources2.getColor(i4));
                this.k.setTextColor(this.a.getResources().getColor(i4));
                this.n.setTextColor(this.a.getResources().getColor(R$color.color_ff2d79));
                this.o.setTextColor(this.a.getResources().getColor(i4));
                this.f.setVisibility(8);
            }
            this.u.setVisibility(8);
            this.v.setVisibility(8);
            this.u.setText("00");
            this.w.setText("00");
            this.x.setText("00");
            this.y.setText("00");
            if (itemBean.countdownTime > 0) {
                this.t.setVisibility(0);
                if (itemBean.countdownTime / 86400000 >= 1) {
                    this.u.setVisibility(0);
                    this.v.setVisibility(0);
                }
                long j2 = itemBean.countdownTime - ((long) (GrabActivity.second * 1000));
                if (j2 > 0) {
                    long j3 = j2 / 86400000;
                    long j4 = j2 - (86400000 * j3);
                    long j5 = j4 / DateUtils.MILLIS_PER_HOUR;
                    long j6 = j4 - (DateUtils.MILLIS_PER_HOUR * j5);
                    long j7 = j6 / DateUtils.MILLIS_PER_MINUTE;
                    this.u.setText(f(j3));
                    this.w.setText(f(j5));
                    this.x.setText(f(j7));
                    this.y.setText(f((j6 - (DateUtils.MILLIS_PER_MINUTE * j7)) / 1000));
                    return;
                }
                return;
            }
            this.t.setVisibility(8);
        }
    }
}
