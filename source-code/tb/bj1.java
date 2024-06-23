package tb;

import android.view.View;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.decor.a;
import cn.damai.player.video.listener.VideoOperateListener;
import cn.damai.player.video.view.VideoView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class bj1 extends a {
    private static transient /* synthetic */ IpChange $ipChange;
    private a c;

    public bj1(VideoView videoView) {
        super(videoView);
    }

    @Override // cn.damai.player.video.decor.a
    public View a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462043421")) {
            return (View) ipChange.ipc$dispatch("-1462043421", new Object[]{this});
        }
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    @Override // cn.damai.player.video.decor.a
    public void b(VideoOperateListener videoOperateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "171627819")) {
            ipChange.ipc$dispatch("171627819", new Object[]{this, videoOperateListener});
            return;
        }
        super.b(videoOperateListener);
        a aVar = this.c;
        if (aVar != null) {
            aVar.b(this.b);
        }
    }

    @Override // cn.damai.player.video.decor.a
    public void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "651229288")) {
            ipChange.ipc$dispatch("651229288", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    @Override // cn.damai.player.video.decor.a
    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62935224")) {
            ipChange.ipc$dispatch("-62935224", new Object[]{this});
            return;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // cn.damai.player.video.decor.a
    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62222496")) {
            ipChange.ipc$dispatch("62222496", new Object[]{this});
            return;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // cn.damai.player.video.decor.a
    public void f(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1467498452")) {
            ipChange.ipc$dispatch("-1467498452", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.f(i, str);
        }
    }

    @Override // cn.damai.player.video.decor.a
    public void g(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1094866431")) {
            ipChange.ipc$dispatch("1094866431", new Object[]{this, videoInfo});
            return;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.g(videoInfo);
        }
    }

    @Override // cn.damai.player.video.decor.a
    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1962197107")) {
            ipChange.ipc$dispatch("-1962197107", new Object[]{this});
            return;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.h();
        }
    }

    @Override // cn.damai.player.video.decor.a
    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525919123")) {
            ipChange.ipc$dispatch("1525919123", new Object[]{this});
            return;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // cn.damai.player.video.decor.a
    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-163146917")) {
            ipChange.ipc$dispatch("-163146917", new Object[]{this});
            return;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // cn.damai.player.video.decor.a
    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569023911")) {
            ipChange.ipc$dispatch("1569023911", new Object[]{this});
            return;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void l(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1790887998")) {
            ipChange.ipc$dispatch("1790887998", new Object[]{this, aVar});
            return;
        }
        this.c = aVar;
        b(this.b);
    }
}
