package tb;

import android.content.Context;
import android.view.View;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.view.DMTagView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ym extends ym2<DmInfo> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private DMTagView d;
    @Nullable
    private View e;

    public ym(@Nullable Context context) {
        super(context);
    }

    @Override // tb.ym2
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1131506144")) {
            return R$layout.live_content_detail_dm;
        }
        return ((Integer) ipChange.ipc$dispatch("1131506144", new Object[]{this})).intValue();
    }

    @Override // tb.ym2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1085530195")) {
            ipChange.ipc$dispatch("-1085530195", new Object[]{this});
            return;
        }
        this.d = (DMTagView) this.b.findViewById(R$id.dm_tag_view);
        this.e = this.b.findViewById(R$id.live_content_dm_layout);
    }

    public void d(@Nullable DmInfo dmInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "578267161")) {
            ipChange.ipc$dispatch("578267161", new Object[]{this, dmInfo});
        } else if (dmInfo == null) {
            c(false);
        } else {
            View view = this.e;
            k21.f(view);
            view.setTag(dmInfo);
            DMTagView dMTagView = this.d;
            k21.f(dMTagView);
            dMTagView.setDmBaseData(dmInfo.dmHeadImageUrl, dmInfo.dmName);
            ArrayList<String> arrayList = dmInfo.dmTags;
            if (arrayList != null) {
                DMTagView dMTagView2 = this.d;
                k21.f(dMTagView2);
                dMTagView2.setDmTagData(arrayList);
            }
            c(true);
        }
    }

    @Override // tb.ym2
    public void onClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "267460947")) {
            ipChange.ipc$dispatch("267460947", new Object[]{this, view});
            return;
        }
        k21.i(view, "v");
        super.onClick(view);
    }
}
