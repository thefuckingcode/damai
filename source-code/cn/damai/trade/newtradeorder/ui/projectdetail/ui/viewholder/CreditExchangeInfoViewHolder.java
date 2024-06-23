package cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder;

import android.graphics.Bitmap;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt;
import com.alibaba.pictures.moimage.MoImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import kotlin.text.o;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dp;
import tb.ep;
import tb.fp;
import tb.g90;
import tb.k21;
import tb.m40;
import tb.pe1;

/* compiled from: Taobao */
public final class CreditExchangeInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final TextView a;
    @NotNull
    private final TextView b;
    @NotNull
    private final LinearLayout c;
    @NotNull
    private final LinearLayout d;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final CreditExchangeInfoViewHolder a(@NotNull ViewGroup viewGroup) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1720217894")) {
                return (CreditExchangeInfoViewHolder) ipChange.ipc$dispatch("-1720217894", new Object[]{this, viewGroup});
            }
            k21.i(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_credit_exchange_info_view, viewGroup, false);
            k21.h(inflate, "from(parent.context)\n   …info_view, parent, false)");
            return new CreditExchangeInfoViewHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreditExchangeInfoViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        View findViewById = view.findViewById(R$id.title);
        k21.h(findViewById, "itemView.findViewById(R.id.title)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.desc);
        k21.h(findViewById2, "itemView.findViewById(R.id.desc)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.ll_banners);
        k21.h(findViewById3, "itemView.findViewById(R.id.ll_banners)");
        this.c = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R$id.ll_images);
        k21.h(findViewById4, "itemView.findViewById(R.id.ll_images)");
        this.d = (LinearLayout) findViewById4;
    }

    /* access modifiers changed from: private */
    public static final void e(MoImageView moImageView, ProjectMemberPrompt.BannerVO bannerVO, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1147599134")) {
            ipChange.ipc$dispatch("1147599134", new Object[]{moImageView, bannerVO, view});
            return;
        }
        k21.i(moImageView, "$this_apply");
        k21.i(bannerVO, "$banner");
        DMNav.from(moImageView.getContext()).toUri(bannerVO.getUrl());
    }

    /* access modifiers changed from: private */
    public static final void g(CreditExchangeInfoViewHolder creditExchangeInfoViewHolder, MoImageView moImageView, boolean z, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "158348285")) {
            ipChange.ipc$dispatch("158348285", new Object[]{creditExchangeInfoViewHolder, moImageView, Boolean.valueOf(z), eVar});
            return;
        }
        k21.i(creditExchangeInfoViewHolder, "this$0");
        k21.i(moImageView, "$imageView");
        creditExchangeInfoViewHolder.i(moImageView, eVar.b, z);
    }

    /* access modifiers changed from: private */
    public static final void h(CreditExchangeInfoViewHolder creditExchangeInfoViewHolder, MoImageView moImageView, boolean z, DMImageCreator.d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1973035327")) {
            ipChange.ipc$dispatch("-1973035327", new Object[]{creditExchangeInfoViewHolder, moImageView, Boolean.valueOf(z), dVar});
            return;
        }
        k21.i(creditExchangeInfoViewHolder, "this$0");
        k21.i(moImageView, "$imageView");
        creditExchangeInfoViewHolder.i(moImageView, null, z);
    }

    private final void i(MoImageView moImageView, Bitmap bitmap, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1284821301")) {
            ipChange.ipc$dispatch("-1284821301", new Object[]{this, moImageView, bitmap, Boolean.valueOf(z)});
        } else if (bitmap != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, g90.c(9.0f), 0, 0);
            int g = (int) (((float) g90.g()) - g90.b(z ? 30.0f : 54.0f));
            layoutParams.width = g;
            layoutParams.height = (g * bitmap.getHeight()) / bitmap.getWidth();
            moImageView.setLayoutParams(layoutParams);
            moImageView.setLocalImageBitmap(bitmap);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public final void d(@Nullable ProjectMemberPrompt.ProfitDetailContent profitDetailContent) {
        boolean z;
        List<ProjectMemberPrompt.BannerVO> banners;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "970804433")) {
            ipChange.ipc$dispatch("970804433", new Object[]{this, profitDetailContent});
        } else if (profitDetailContent != null) {
            String title = profitDetailContent.getTitle();
            if (title == null || title.length() == 0) {
                this.a.setVisibility(8);
            } else {
                this.a.setText(profitDetailContent.getTitle());
                this.a.setVisibility(0);
            }
            String content = profitDetailContent.getContent();
            if (content == null || content.length() == 0) {
                this.b.setVisibility(8);
            } else {
                TextView textView = this.b;
                String content2 = profitDetailContent.getContent();
                k21.f(content2);
                textView.setText(Html.fromHtml(o.F(content2, StringUtils.LF, "<br>", false, 4, null)));
                this.b.setVisibility(0);
            }
            this.c.removeAllViews();
            this.d.removeAllViews();
            String title2 = profitDetailContent.getTitle();
            if (title2 == null || title2.length() == 0) {
                String content3 = profitDetailContent.getContent();
                if (content3 == null || content3.length() == 0) {
                    z = true;
                    if (!z) {
                        this.d.setVisibility(0);
                        this.c.setVisibility(8);
                    } else {
                        this.c.setVisibility(0);
                        this.d.setVisibility(8);
                    }
                    banners = profitDetailContent.getBanners();
                    if (banners == null) {
                        for (T t : banners) {
                            String pic = t.getPic();
                            if (pic == null || pic.length() == 0) {
                                t = null;
                            }
                            if (t != null) {
                                MoImageView f = f(t.getPic(), z);
                                f.setOnClickListener(new dp(f, t));
                                if (z) {
                                    this.d.addView(f);
                                } else {
                                    this.c.addView(f);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
            }
            z = false;
            if (!z) {
            }
            banners = profitDetailContent.getBanners();
            if (banners == null) {
            }
        }
    }

    @NotNull
    public final MoImageView f(@Nullable String str, boolean z) {
        pe1.a aVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737491050")) {
            return (MoImageView) ipChange.ipc$dispatch("737491050", new Object[]{this, str, Boolean.valueOf(z)});
        }
        MoImageView moImageView = new MoImageView(this.a.getContext(), null, 0, 6, null);
        pe1.a roundingParams = moImageView.getRoundingParams();
        if (roundingParams == null || (aVar = roundingParams.k(g90.b(6.0f))) == null) {
            aVar = pe1.a.Companion.a((float) g90.c(6.0f));
        }
        moImageView.setRoundingParams(aVar);
        moImageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        cn.damai.common.image.a.b().c(str).n(new fp(this, moImageView, z)).e(new ep(this, moImageView, z)).f();
        return moImageView;
    }
}
