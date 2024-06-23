package tb;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class bn extends ym2<StoreInfo> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private LinearLayout d;
    @Nullable
    private StoreInfo e;
    @Nullable
    private RoundImageView f;
    @Nullable
    private TextView g;
    @Nullable
    private TextView h;

    public bn(@Nullable Context context) {
        super(context);
    }

    @Override // tb.ym2
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-564667454")) {
            return R$layout.live_content_detail_store;
        }
        return ((Integer) ipChange.ipc$dispatch("-564667454", new Object[]{this})).intValue();
    }

    @Override // tb.ym2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080742543")) {
            ipChange.ipc$dispatch("1080742543", new Object[]{this});
            return;
        }
        this.d = (LinearLayout) this.b.findViewById(R$id.live_content_dm_layout);
        this.f = (RoundImageView) this.b.findViewById(R$id.store_pic);
        this.g = (TextView) this.b.findViewById(R$id.store_title);
        this.h = (TextView) this.b.findViewById(R$id.tv_store_des);
    }

    public void d(@Nullable StoreInfo storeInfo) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "166478483")) {
            ipChange.ipc$dispatch("166478483", new Object[]{this, storeInfo});
        } else if (storeInfo == null) {
            c(false);
        } else {
            LinearLayout linearLayout = this.d;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(this);
            }
            getLiveUt().n(this.d, storeInfo.getStoreId());
            this.e = storeInfo;
            int a = n42.a(xs0.a(), 42.0f);
            DMImageCreator f2 = a.b().f(storeInfo.getStoreImgUrl(), n42.a(xs0.a(), 42.0f), a);
            int i = R$drawable.store_defult_img;
            f2.i(i).c(i).g(this.f);
            String des = storeInfo.getDes();
            TextView textView = this.g;
            if (textView != null) {
                textView.setText(storeInfo.getStoreName());
            }
            if (des.length() == 0) {
                z = true;
            }
            if (!z) {
                TextView textView2 = this.h;
                if (textView2 != null) {
                    textView2.setText(storeInfo.getDes());
                }
            } else {
                TextView textView3 = this.h;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
            }
            c(true);
        }
    }

    @Override // tb.ym2
    public void onClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "302018353")) {
            ipChange.ipc$dispatch("302018353", new Object[]{this, view});
            return;
        }
        k21.i(view, "v");
        super.onClick(view);
        StoreInfo storeInfo = this.e;
        String str = null;
        String storeId = storeInfo != null ? storeInfo.getStoreId() : null;
        if (storeId != null) {
            c e2 = c.e();
            w71 liveUt = getLiveUt();
            StoreInfo storeInfo2 = this.e;
            if (storeInfo2 != null) {
                str = storeInfo2.getStoreId();
            }
            e2.x(liveUt.G(str));
            DMNav from = DMNav.from(this.a);
            from.toUri("damai://V1/ScriptPlay?storeId=" + storeId);
        }
    }
}
