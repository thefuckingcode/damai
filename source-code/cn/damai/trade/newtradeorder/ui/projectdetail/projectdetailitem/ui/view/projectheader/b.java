package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.EarlyBirdVO;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.PromotionItemBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.TagBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.WedHalfPriceVO;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.activity.ProjectDetailActivity;
import cn.damai.trade.newtradeorder.ui.projectdetail.xflush.ProjectDetailXFlushUtil;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.view.RoundImageView;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.bk2;
import tb.f92;
import tb.gb;
import tb.ln2;
import tb.n42;
import tb.v50;
import tb.xf2;
import tb.xs0;
import tb.xt1;

/* compiled from: Taobao */
public class b extends a implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private RoundImageView e;
    private FlowLayout f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private View k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private c r;
    private View s;
    private ImageView t;
    private TextView u;
    private LinearLayout v;
    private DMCategroyTagView w;
    private TextView x;
    private ViewGroup y;
    private ViewGroup z;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "596802219")) {
                ipChange.ipc$dispatch("596802219", new Object[]{this, dVar});
            } else {
                ProjectDetailXFlushUtil.n(dVar != null ? String.valueOf(dVar.a) : "", this.a, String.valueOf(b.this.b));
            }
        }
    }

    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0055b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        C0055b(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-868450304")) {
                ipChange.ipc$dispatch("-868450304", new Object[]{this, eVar});
            } else if (eVar != null) {
                if (eVar.a != null) {
                    b.this.e.setImageDrawable(eVar.a);
                    b.this.e.setOnClickListener(b.this);
                }
                Bitmap bitmap = eVar.b;
                if (bitmap != null) {
                    b.this.d.onLoadedPosterPic(this.a, bitmap, this.b);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class c extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        public c(long j) {
            super(j, 1000);
        }

        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1535142228")) {
                ipChange.ipc$dispatch("1535142228", new Object[]{this});
                return;
            }
            Activity activity = b.this.a;
            if (activity != null && !activity.isDestroyed()) {
                Activity activity2 = b.this.a;
                if ((activity2 instanceof ProjectDetailActivity) && ((ProjectDetailActivity) activity2).getCurrentFragment() != null && (((ProjectDetailActivity) b.this.a).getCurrentFragment() instanceof ProjectDetailItemMainFragment)) {
                    ((ProjectDetailItemMainFragment) ((ProjectDetailActivity) b.this.a).getCurrentFragment()).onRefresh();
                }
            }
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1913369734")) {
                ipChange.ipc$dispatch("-1913369734", new Object[]{this, Long.valueOf(j)});
                return;
            }
            String[] a2 = xt1.a(j / 1000);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("还剩");
            if (!TextUtils.isEmpty(a2[0])) {
                stringBuffer.append(a2[0]);
                stringBuffer.append("天 ");
            }
            stringBuffer.append(a2[1]);
            stringBuffer.append(":");
            stringBuffer.append(a2[2]);
            stringBuffer.append(":");
            stringBuffer.append(a2[3]);
            b.this.i.setText(stringBuffer);
        }
    }

    public b(Activity activity, long j2, View view, OnHeadClickListener onHeadClickListener) {
        super(activity, j2, view, onHeadClickListener);
        this.e = (RoundImageView) view.findViewById(R$id.project_item_poster_image_iv);
        this.y = (ViewGroup) view.findViewById(R$id.title_layout);
        this.f = (FlowLayout) view.findViewById(R$id.project_show_tags_fl);
        this.g = (TextView) view.findViewById(R$id.project_price_tv);
        this.h = (TextView) view.findViewById(R$id.project_price_tv_inner);
        this.i = (TextView) view.findViewById(R$id.project_detail_countdown_tv);
        this.s = view.findViewById(R$id.project_price_promotion);
        this.t = (ImageView) view.findViewById(R$id.iv_project_price_promotion);
        this.u = (TextView) view.findViewById(R$id.project_dash_price_tv);
        this.v = (LinearLayout) view.findViewById(R$id.header_promotion_newll);
        TextView textView = (TextView) view.findViewById(R$id.tv_project_coupon_mark);
        this.w = (DMCategroyTagView) view.findViewById(R$id.project_detail_agency_tag_fv);
        this.x = (TextView) view.findViewById(R$id.project_detail_image_num_tv);
        this.j = view.findViewById(R$id.sfpt_container);
        this.l = (TextView) view.findViewById(R$id.sfpt_prefix_tv);
        this.m = (TextView) view.findViewById(R$id.sfpt_tv);
        this.n = (TextView) view.findViewById(R$id.sfpt_suffix_tv);
        this.k = view.findViewById(R$id.sfpt_container_inner);
        this.o = (TextView) view.findViewById(R$id.sfpt_prefix_tv_inner);
        this.p = (TextView) view.findViewById(R$id.sfpt_tv_inner);
        this.q = (TextView) view.findViewById(R$id.sfpt_suffix_tv_inner);
        this.z = (ViewGroup) view.findViewById(R$id.header_base_uill);
        this.f.setSingleLine(true);
    }

    private ImageView h(TagBean tagBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-251590025")) {
            return (ImageView) ipChange.ipc$dispatch("-251590025", new Object[]{this, tagBean});
        } else if (tagBean.ids <= 0) {
            return null;
        } else {
            int a2 = n42.a(this.a, 16.0f);
            FlowLayout.LayoutParams layoutParams = new FlowLayout.LayoutParams((tagBean.picWidth * a2) / tagBean.picHeight, a2);
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = n42.a(this.a, 3.0f);
            ImageView imageView = new ImageView(this.a);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(tagBean.ids);
            return imageView;
        }
    }

    private View i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593113345")) {
            return (View) ipChange.ipc$dispatch("593113345", new Object[]{this, str});
        }
        View inflate = LayoutInflater.from(this.a).inflate(R$layout.project_item_basic_mark_layout, (ViewGroup) this.f, false);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_show_tag);
        textView.setBackgroundResource(R$drawable.project_detail_show_tag_bg);
        textView.setText(str);
        return inflate;
    }

    private void j(String str, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-945909966")) {
            ipChange.ipc$dispatch("-945909966", new Object[]{this, str, Boolean.valueOf(z2)});
            return;
        }
        this.e.setOnClickListener(null);
        if (str != null) {
            DMImageCreator k2 = cn.damai.common.image.a.b().f(str, ScreenUtil.dip2px(xs0.a(), 93.0f), ScreenUtil.dip2px(xs0.a(), 131.0f)).k(new DMRoundedCornersBitmapProcessor(6, 0));
            int i2 = R$drawable.uikit_default_image_bg_trans_white;
            k2.i(i2).c(i2).n(new C0055b(str, z2)).e(new a(str)).f();
            ln2.r().K1(this.e, String.valueOf(this.b));
        }
    }

    private void l(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724671320")) {
            ipChange.ipc$dispatch("1724671320", new Object[]{this, textView, str});
            return;
        }
        int length = str.length();
        int length2 = str.split("\\d")[0].length();
        SpannableString spannableString = new SpannableString(str);
        int a2 = v50.a(this.a, 10.0f);
        int a3 = v50.a(this.a, 11.0f);
        spannableString.setSpan(new AbsoluteSizeSpan(a2), 0, length2, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(a3), length2, length, 18);
        textView.setText(spannableString);
    }

    private void m(List<PromotionItemBean> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "95955078")) {
            ipChange.ipc$dispatch("95955078", new Object[]{this, list, str});
        } else if (f92.d(list)) {
            this.v.setOnClickListener(null);
            this.v.setVisibility(8);
        } else {
            if (list.get(0) != null) {
                this.v.setVisibility(0);
                ViewGroup viewGroup = (ViewGroup) this.v.findViewById(R$id.fl_sub_tags_container);
                viewGroup.removeAllViews();
                list.get(0).addTagView(viewGroup, new int[]{0, 0, v50.a(this.a, 4.5f), 0});
            }
            ViewGroup viewGroup2 = (ViewGroup) this.v.findViewById(R$id.sub_marketing_item_container);
            viewGroup2.removeAllViews();
            for (int i2 = 1; i2 < list.size(); i2++) {
                list.get(i2).addTagView(viewGroup2, new int[]{0, v50.a(this.a, 4.5f), v50.a(this.a, 4.5f), 0});
            }
            this.v.setOnClickListener(this);
            ln2.r().p2(this.v, str, list);
        }
    }

    private void n(List<TagBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1456571867")) {
            ipChange.ipc$dispatch("-1456571867", new Object[]{this, list});
        } else if (f92.d(list)) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            this.f.removeAllViews();
            for (int i2 = 0; i2 < list.size(); i2++) {
                TagBean tagBean = list.get(i2);
                if (tagBean != null) {
                    int i3 = tagBean.type;
                    if (i3 == TagBean.TYPE_TEXT) {
                        if (!TextUtils.isEmpty(tagBean.text)) {
                            this.f.addView(i(tagBean.text));
                        }
                    } else if (i3 == TagBean.TYPE_IMAGE) {
                        this.f.addView(h(tagBean));
                    }
                }
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1603899377")) {
            return R$id.header_base_info_ui;
        }
        return ((Integer) ipChange.ipc$dispatch("-1603899377", new Object[]{this})).intValue();
    }

    public void f(ProjectDetailDataBean projectDetailDataBean, boolean z2) {
        String str;
        String str2;
        String str3;
        EarlyBirdVO earlyBirdVO;
        WedHalfPriceVO wedHalfPriceVO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649191225")) {
            ipChange.ipc$dispatch("-1649191225", new Object[]{this, projectDetailDataBean, Boolean.valueOf(z2)});
        } else if (projectDetailDataBean != null) {
            ProjectStaticDataBean staticData = projectDetailDataBean.getStaticData();
            ProjectItemDataBean item = projectDetailDataBean.getItem();
            ProjectStaticItemBaseBean c2 = gb.c(staticData);
            List<TagBean> k2 = gb.k(staticData);
            if (c2 == null) {
                str = "";
            } else {
                str = c2.getItemName();
            }
            n(k2);
            if (c2 == null) {
                str2 = "";
            } else {
                str2 = String.valueOf(c2.getItemId());
            }
            o(str, xf2.e(k2) > 0);
            if (item != null) {
                str3 = item.getPriceRange();
            } else {
                str3 = "";
            }
            if (TextUtils.isEmpty(str3) || str3.contains(bk2.b(this.a, R$string.damai_projectdetail_tbd)) || str3.contains(bk2.b(this.a, R$string.damai_search_prize))) {
                str3 = this.a.getResources().getString(R$string.damai_search_prize);
            }
            CharSequence n2 = gb.n(str3, 12);
            this.g.setText(n2);
            if (c2 != null) {
                long j2 = c2.sfpt;
                if (!c2.hasServiceFee) {
                    this.j.setVisibility(8);
                } else if (item == null || (!item.hasEarlyBird && !item.hasWedHalfPrice)) {
                    this.j.setVisibility(0);
                    this.m.setTextColor(this.a.getResources().getColor(j2 == 0 ? R$color.color_9C9CA5 : R$color.color_FF2869));
                    l(this.m, c2.sfptTip);
                    this.l.setText(c2.sfptPrefix);
                    this.n.setText(c2.sfptSuffix);
                } else {
                    this.k.setVisibility(0);
                    l(this.p, c2.sfptTip);
                    this.o.setText(c2.sfptPrefix);
                    this.q.setText(c2.sfptSuffix);
                }
            }
            if (item == null || (!item.hasEarlyBird && !item.hasWedHalfPrice)) {
                ViewGroup viewGroup = this.z;
                if (viewGroup != null) {
                    viewGroup.setBackgroundResource(R$drawable.bg_header_corner_white_shape);
                }
            } else {
                this.s.setVisibility(0);
                ViewGroup viewGroup2 = this.z;
                if (viewGroup2 != null) {
                    viewGroup2.setBackgroundResource(R$drawable.bg_header_corner_pink_shape);
                }
                if (item.hasWedHalfPrice) {
                    this.t.setImageResource(R$drawable.icon_promotion_wedensday_half_price);
                } else if (item.hasEarlyBird) {
                    this.t.setImageResource(R$drawable.icon_market_earlybird_inner);
                }
                this.g.setVisibility(8);
                this.h.setText(n2);
                if (item.hasWedHalfPrice && (wedHalfPriceVO = item.wedHalfPriceVO) != null) {
                    String str4 = wedHalfPriceVO.tips;
                    if (str4 != null) {
                        this.i.setText(str4);
                    } else {
                        this.i.setText("");
                    }
                    c cVar = this.r;
                    if (cVar != null) {
                        cVar.cancel();
                    }
                } else if (item.hasEarlyBird && (earlyBirdVO = item.earlyBirdVO) != null) {
                    if (earlyBirdVO.showTips) {
                        this.i.setText(earlyBirdVO.tips);
                    } else {
                        c cVar2 = this.r;
                        if (cVar2 != null) {
                            cVar2.cancel();
                        }
                        if (item.earlyBirdVO.countdown > 0) {
                            c cVar3 = new c(item.earlyBirdVO.countdown);
                            this.r = cVar3;
                            cVar3.start();
                        }
                    }
                }
            }
            this.u.setVisibility(8);
            m(item.promotionList, str2);
            int e2 = xf2.e(gb.f(staticData));
            if (e2 > 1) {
                this.x.setText(bk2.c(this.a, R$string.project_total_image_num, Integer.valueOf(e2)));
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
            this.w.setVisibility(8);
            j(gb.h(staticData), z2);
        }
    }

    public void g(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670816066")) {
            ipChange.ipc$dispatch("-670816066", new Object[]{this, str, str2});
            return;
        }
        o(str2, false);
        j(str, false);
        this.g.setVisibility(8);
        this.u.setVisibility(8);
        n(null);
        m(null, null);
        this.x.setVisibility(8);
        this.w.setVisibility(8);
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1753785562")) {
            ipChange.ipc$dispatch("1753785562", new Object[]{this});
            return;
        }
        c cVar = this.r;
        if (cVar != null) {
            cVar.cancel();
            this.r = null;
        }
    }

    public void o(String str, boolean z2) {
        IpChange ipChange = $ipChange;
        int i2 = 2;
        if (AndroidInstantRuntime.support(ipChange, "1209254358")) {
            ipChange.ipc$dispatch("1209254358", new Object[]{this, str, Boolean.valueOf(z2)});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.y.removeAllViews();
        AppCompatTextView appCompatTextView = new AppCompatTextView(this.a);
        if (!z2) {
            i2 = 3;
        }
        appCompatTextView.setMaxLines(i2);
        appCompatTextView.setTextColor(-16777216);
        appCompatTextView.setLineSpacing(6.0f, 1.0f);
        appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
        appCompatTextView.setTextSize(1, 16.0f);
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(appCompatTextView, 6, 16, 1, 1);
        appCompatTextView.setText(str);
        this.y.addView(appCompatTextView, -1, -2);
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "327004396")) {
            ipChange.ipc$dispatch("327004396", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == this.e.getId()) {
            this.d.onPosterClick();
        } else if (id == this.v.getId()) {
            this.d.onPromotionTagsClick();
        }
    }
}
