package tb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.discover.content.net.CliqueInfo;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class wm extends ym2<CliqueInfo> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView d;
    private View e;

    public wm(Context context) {
        super(context);
    }

    @Override // tb.ym2
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-90388785")) {
            return R$layout.live_content_detail_circle;
        }
        return ((Integer) ipChange.ipc$dispatch("-90388785", new Object[]{this})).intValue();
    }

    @Override // tb.ym2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322339356")) {
            ipChange.ipc$dispatch("1322339356", new Object[]{this});
            return;
        }
        this.d = (TextView) this.b.findViewById(R$id.live_content_detail_circle);
        View findViewById = this.b.findViewById(R$id.live_content_circle_layout);
        this.e = findViewById;
        findViewById.setOnClickListener(this);
    }

    public void d(CliqueInfo cliqueInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "185294771")) {
            ipChange.ipc$dispatch("185294771", new Object[]{this, cliqueInfo});
        } else if (cliqueInfo == null) {
            c(false);
        } else {
            this.e.setTag(cliqueInfo);
            this.d.setText(cliqueInfo.name);
            c(true);
        }
    }

    @Override // tb.ym2
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1068472188")) {
            ipChange.ipc$dispatch("-1068472188", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        CliqueInfo cliqueInfo = (CliqueInfo) view.getTag();
        c.e().x(getLiveUt().v(cliqueInfo.name, String.valueOf(cliqueInfo.id)));
        Bundle bundle = new Bundle();
        bundle.putString("themeId", String.valueOf(cliqueInfo.id));
        DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(gr.DISCOVER_CIRCLE_THEME_PAGE));
    }
}
