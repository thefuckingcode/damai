package tb;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.scriptmurder.bean.ScriptBean;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class t42 extends ym2<ScriptBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private LinearLayout d;
    @Nullable
    private ScriptBean e;
    @Nullable
    private RoundImageView f;
    @Nullable
    private TextView g;
    @Nullable
    private TextView h;

    public t42(@Nullable Context context) {
        super(context);
    }

    @Override // tb.ym2
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "288591581")) {
            return R$layout.live_content_detail_script;
        }
        return ((Integer) ipChange.ipc$dispatch("288591581", new Object[]{this})).intValue();
    }

    @Override // tb.ym2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818263254")) {
            ipChange.ipc$dispatch("-818263254", new Object[]{this});
            return;
        }
        this.d = (LinearLayout) this.b.findViewById(R$id.live_content_dm_layout);
        this.f = (RoundImageView) this.b.findViewById(R$id.script_pic);
        this.g = (TextView) this.b.findViewById(R$id.script_title);
        this.h = (TextView) this.b.findViewById(R$id.tv_script_des);
    }

    public void d(@Nullable ScriptBean scriptBean) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1442724993")) {
            ipChange.ipc$dispatch("1442724993", new Object[]{this, scriptBean});
        } else if (scriptBean == null) {
            c(false);
        } else {
            LinearLayout linearLayout = this.d;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(this);
            }
            getLiveUt().m(this.d, scriptBean.getId());
            this.e = scriptBean;
            int a = n42.a(xs0.a(), 64.0f);
            DMImageCreator f2 = a.b().f(scriptBean.getPosterUrl(), n42.a(xs0.a(), 48.0f), a);
            int i = R$drawable.store_defult_img;
            f2.i(i).c(i).g(this.f);
            String des = scriptBean.getDes();
            TextView textView = this.g;
            if (textView != null) {
                textView.setText(scriptBean.getName());
            }
            if (des.length() == 0) {
                z = true;
            }
            if (!z) {
                TextView textView2 = this.h;
                if (textView2 != null) {
                    textView2.setText(scriptBean.getDes());
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
        if (AndroidInstantRuntime.support(ipChange, "910869174")) {
            ipChange.ipc$dispatch("910869174", new Object[]{this, view});
            return;
        }
        k21.i(view, "v");
        super.onClick(view);
        ScriptBean scriptBean = this.e;
        if (scriptBean != null) {
            c e2 = c.e();
            w71 liveUt = getLiveUt();
            ScriptBean scriptBean2 = this.e;
            e2.x(liveUt.E(scriptBean2 != null ? scriptBean2.getId() : null));
            DMNav.from(this.a).toUri(scriptBean.getActionUrl());
        }
    }
}
