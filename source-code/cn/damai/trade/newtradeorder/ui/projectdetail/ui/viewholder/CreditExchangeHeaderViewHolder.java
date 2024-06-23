package cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.alibaba.pictures.moimage.MoImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap;
import tb.bp;
import tb.cp;
import tb.g90;
import tb.h10;
import tb.k21;
import tb.m40;
import tb.pe1;

/* compiled from: Taobao */
public final class CreditExchangeHeaderViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final MoImageView a;
    @NotNull
    private final TextView b;
    @NotNull
    private final TextView c;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final CreditExchangeHeaderViewHolder a(@NotNull ViewGroup viewGroup) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-337530788")) {
                return (CreditExchangeHeaderViewHolder) ipChange.ipc$dispatch("-337530788", new Object[]{this, viewGroup});
            }
            k21.i(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_credit_exchange_header_view, viewGroup, false);
            k21.h(inflate, "from(parent.context)\n   …ader_view, parent, false)");
            return new CreditExchangeHeaderViewHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreditExchangeHeaderViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        View findViewById = view.findViewById(R$id.poster);
        k21.h(findViewById, "itemView.findViewById(R.id.poster)");
        this.a = (MoImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.title);
        k21.h(findViewById2, "itemView.findViewById(R.id.title)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.desc);
        k21.h(findViewById3, "itemView.findViewById(R.id.desc)");
        this.c = (TextView) findViewById3;
    }

    /* access modifiers changed from: private */
    public static final void e(CreditExchangeHeaderViewHolder creditExchangeHeaderViewHolder, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1535110500")) {
            ipChange.ipc$dispatch("1535110500", new Object[]{creditExchangeHeaderViewHolder, eVar});
            return;
        }
        k21.i(creditExchangeHeaderViewHolder, "this$0");
        creditExchangeHeaderViewHolder.g(eVar.b);
    }

    /* access modifiers changed from: private */
    public static final void f(CreditExchangeHeaderViewHolder creditExchangeHeaderViewHolder, DMImageCreator.d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "768469912")) {
            ipChange.ipc$dispatch("768469912", new Object[]{creditExchangeHeaderViewHolder, dVar});
            return;
        }
        k21.i(creditExchangeHeaderViewHolder, "this$0");
        creditExchangeHeaderViewHolder.g(null);
    }

    private final void g(Bitmap bitmap) {
        pe1.a aVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350662216")) {
            ipChange.ipc$dispatch("350662216", new Object[]{this, bitmap});
            return;
        }
        MoImageView moImageView = this.a;
        pe1.a roundingParams = moImageView.getRoundingParams();
        if (roundingParams == null || (aVar = roundingParams.j(g90.b(6.0f), g90.b(6.0f), 0.0f, 0.0f)) == null) {
            aVar = new pe1.a().j(g90.b(6.0f), g90.b(6.0f), 0.0f, 0.0f);
        }
        moImageView.setRoundingParams(aVar);
        moImageView.post(new cp(bitmap, moImageView));
        moImageView.setLocalImageBitmap(bitmap);
    }

    /* access modifiers changed from: private */
    public static final void h(Bitmap bitmap, MoImageView moImageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1783833415")) {
            ipChange.ipc$dispatch("1783833415", new Object[]{bitmap, moImageView});
            return;
        }
        k21.i(moImageView, "$this_apply");
        if (bitmap == null) {
            moImageView.setLocalDrawable(Integer.valueOf(R$drawable.uikit_default_image_bg_gradient));
            ViewGroup.LayoutParams layoutParams = moImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = (int) (((float) g90.g()) - g90.b(30.0f));
            }
            ViewGroup.LayoutParams layoutParams2 = moImageView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = (moImageView.getWidth() * h10.SCREEN_WIDTH) / 763;
            }
            moImageView.setLayoutParams(moImageView.getLayoutParams());
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 0 && height > 0) {
            ViewGroup.LayoutParams layoutParams3 = moImageView.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = (int) (((float) g90.g()) - g90.b(30.0f));
            }
            ViewGroup.LayoutParams layoutParams4 = moImageView.getLayoutParams();
            if (layoutParams4 != null) {
                layoutParams4.height = (moImageView.getWidth() * height) / width;
            }
            moImageView.setLayoutParams(moImageView.getLayoutParams());
        }
    }

    public final void d(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691043426")) {
            ipChange.ipc$dispatch("-691043426", new Object[]{this, str, str2, str3});
            return;
        }
        cn.damai.common.image.a.b().c(str).n(new bp(this)).e(new ap(this)).f();
        TextView textView = this.b;
        if (str2 == null) {
            str2 = "";
        }
        textView.setText(str2);
        TextView textView2 = this.c;
        if (str3 == null) {
            str3 = "";
        }
        textView2.setText(str3);
    }
}
