package cn.damai.player.video.decor;

import android.view.View;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.listener.VideoOperateListener;
import cn.damai.player.video.view.ApiPlayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class a {
    private static transient /* synthetic */ IpChange $ipChange;
    protected ApiPlayer a;
    protected VideoOperateListener b;

    public a(ApiPlayer apiPlayer) {
        this.a = apiPlayer;
    }

    public abstract View a();

    public void b(VideoOperateListener videoOperateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749968545")) {
            ipChange.ipc$dispatch("1749968545", new Object[]{this, videoOperateListener});
            return;
        }
        this.b = videoOperateListener;
    }

    public abstract void c(boolean z);

    public abstract void d();

    public abstract void e();

    public abstract void f(int i, String str);

    public abstract void g(VideoInfo videoInfo);

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();
}
