package tb;

import androidx.fragment.app.FragmentActivity;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.DMVideoPlayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.youkuplayer.IYoukuPlayer;
import com.youku.youkuplayer.YoukuPlayer;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class bs {
    private static transient /* synthetic */ IpChange $ipChange;
    private gz0 a;
    private VideoInfo b;
    private ds c;
    private long d;
    private long e;
    private WeakReference<DMVideoPlayer> f;
    VideoInfo g;

    public bs(FragmentActivity fragmentActivity, DMVideoPlayer dMVideoPlayer) {
        f(fragmentActivity);
        this.f = new WeakReference<>(dMVideoPlayer);
    }

    private void f(FragmentActivity fragmentActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1549641308")) {
            ipChange.ipc$dispatch("-1549641308", new Object[]{this, fragmentActivity});
            return;
        }
        IYoukuPlayer create = YoukuPlayer.create(fragmentActivity.getApplication(), new as().a(), null);
        create.setWaterMarkImageView(new fs(fragmentActivity));
        this.a = new gz0(create);
        this.c = new ds();
    }

    public VideoInfo a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-7514891")) {
            return this.g;
        }
        return (VideoInfo) ipChange.ipc$dispatch("-7514891", new Object[]{this});
    }

    public gz0 b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1320519752")) {
            return this.a;
        }
        return (gz0) ipChange.ipc$dispatch("-1320519752", new Object[]{this});
    }

    public ds c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258038627")) {
            return (ds) ipChange.ipc$dispatch("-258038627", new Object[]{this});
        }
        if (this.c == null) {
            this.c = new ds();
        }
        return this.c;
    }

    public long d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-765411801")) {
            return this.e - this.d;
        }
        return ((Long) ipChange.ipc$dispatch("-765411801", new Object[]{this})).longValue();
    }

    public VideoInfo e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-181077013")) {
            return this.b;
        }
        return (VideoInfo) ipChange.ipc$dispatch("-181077013", new Object[]{this});
    }

    public void g(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "278308269")) {
            ipChange.ipc$dispatch("278308269", new Object[]{this, videoInfo});
            return;
        }
        this.g = videoInfo;
    }

    public void h(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-577709988")) {
            ipChange.ipc$dispatch("-577709988", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.e = j;
    }

    public void i(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "698645475")) {
            ipChange.ipc$dispatch("698645475", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.d = j;
    }

    public void j(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-126743301")) {
            ipChange.ipc$dispatch("-126743301", new Object[]{this, videoInfo});
            return;
        }
        this.b = videoInfo;
        DMVideoPlayer dMVideoPlayer = null;
        WeakReference<DMVideoPlayer> weakReference = this.f;
        if (weakReference != null) {
            dMVideoPlayer = weakReference.get();
        }
        if (dMVideoPlayer != null && dMVideoPlayer.getController() != null) {
            dMVideoPlayer.getController().refresh();
        }
    }
}
