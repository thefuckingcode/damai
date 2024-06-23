package cn.damai.player.video.decor;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.listener.VideoOperateListener;
import cn.damai.player.video.view.ApiPlayer;
import cn.damai.videoplayer.R$id;
import cn.damai.videoplayer.R$layout;
import cn.damai.videoplayer.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.he0;
import tb.xs0;

/* compiled from: Taobao */
public class HomeVideoUiFacade extends a implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View c;
    private View d = this.c.findViewById(R$id.video_loading);
    private View e;
    private ImageView f = ((ImageView) this.c.findViewById(R$id.video_cover));
    private TextView g = ((TextView) this.c.findViewById(R$id.video_voice_btn));
    private View h = this.c.findViewById(R$id.video_error_ui);
    private TextView i = ((TextView) this.c.findViewById(R$id.video_error_tips));

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-728038636")) {
                ipChange.ipc$dispatch("-728038636", new Object[]{this, view});
                return;
            }
            HomeVideoUiFacade homeVideoUiFacade = HomeVideoUiFacade.this;
            VideoOperateListener videoOperateListener = homeVideoUiFacade.b;
            if (videoOperateListener != null) {
                videoOperateListener.onPlayClick(homeVideoUiFacade.a.getPlayInfo());
            }
        }
    }

    public HomeVideoUiFacade(ApiPlayer apiPlayer) {
        super(apiPlayer);
        View inflate = LayoutInflater.from(xs0.a()).inflate(R$layout.video_home_decor, (ViewGroup) null);
        this.c = inflate;
        this.e = inflate.findViewById(R$id.video_play);
        this.c.setOnClickListener(new a());
        this.g.setOnClickListener(this);
        this.c.findViewById(R$id.video_error_refresh).setOnClickListener(this);
    }

    private void m(@Nullable VideoInfo videoInfo, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1072732248")) {
            ipChange.ipc$dispatch("-1072732248", new Object[]{this, videoInfo, Boolean.valueOf(z)});
        } else if (z) {
            final String picUrl = videoInfo == null ? "" : videoInfo.getPicUrl();
            this.f.setVisibility(0);
            this.f.setImageDrawable(null);
            if (!TextUtils.isEmpty(picUrl)) {
                this.f.post(new Runnable() {
                    /* class cn.damai.player.video.decor.HomeVideoUiFacade.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1711233083")) {
                            ipChange.ipc$dispatch("1711233083", new Object[]{this});
                            return;
                        }
                        cn.damai.common.image.a.b().f(picUrl, HomeVideoUiFacade.this.f.getWidth(), HomeVideoUiFacade.this.f.getHeight()).g(HomeVideoUiFacade.this.f);
                    }
                });
            }
        } else {
            this.f.setVisibility(8);
        }
    }

    private void n(boolean z) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-88637025")) {
            ipChange.ipc$dispatch("-88637025", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.h;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    private void o(boolean z) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "794339359")) {
            ipChange.ipc$dispatch("794339359", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.d;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    private void q(boolean z) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "349370088")) {
            ipChange.ipc$dispatch("349370088", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.e;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    @Override // cn.damai.player.video.decor.a
    public View a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-438302789")) {
            return this.c;
        }
        return (View) ipChange.ipc$dispatch("-438302789", new Object[]{this});
    }

    @Override // cn.damai.player.video.decor.a
    public void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-793551552")) {
            ipChange.ipc$dispatch("-793551552", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.g.setText(xs0.a().getString(R$string.iconfont_shengyinguan22));
        } else {
            this.g.setText(xs0.a().getString(R$string.iconfont_shengyinkai22));
        }
    }

    @Override // cn.damai.player.video.decor.a
    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1222885856")) {
            ipChange.ipc$dispatch("-1222885856", new Object[]{this});
            return;
        }
        n(false);
        o(false);
        q(true);
        m(this.a.getPlayInfo(), true);
    }

    @Override // cn.damai.player.video.decor.a
    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041162104")) {
            ipChange.ipc$dispatch("2041162104", new Object[]{this});
            return;
        }
        o(false);
    }

    @Override // cn.damai.player.video.decor.a
    public void f(int i2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1943772932")) {
            ipChange.ipc$dispatch("1943772932", new Object[]{this, Integer.valueOf(i2), str});
            return;
        }
        q(false);
        o(false);
        m(null, false);
        n(true);
        this.i.setText(he0.b(xs0.a()));
    }

    @Override // cn.damai.player.video.decor.a
    public void g(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134875863")) {
            ipChange.ipc$dispatch("1134875863", new Object[]{this, videoInfo});
            return;
        }
        o(false);
        m(videoInfo, true);
        n(false);
        q(true);
    }

    @Override // cn.damai.player.video.decor.a
    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "494237109")) {
            ipChange.ipc$dispatch("494237109", new Object[]{this});
            return;
        }
        q(false);
        o(true);
    }

    @Override // cn.damai.player.video.decor.a
    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153086021")) {
            ipChange.ipc$dispatch("-1153086021", new Object[]{this});
            return;
        }
        q(true);
    }

    @Override // cn.damai.player.video.decor.a
    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001679997")) {
            ipChange.ipc$dispatch("-2001679997", new Object[]{this});
            return;
        }
        q(false);
        n(false);
        m(null, false);
        o(false);
    }

    @Override // cn.damai.player.video.decor.a
    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1109981233")) {
            ipChange.ipc$dispatch("-1109981233", new Object[]{this});
            return;
        }
        q(false);
    }

    public void onClick(View view) {
        VideoInfo playInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-667532857")) {
            ipChange.ipc$dispatch("-667532857", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.video_voice_btn) {
            ApiPlayer apiPlayer = this.a;
            apiPlayer.mute(!apiPlayer.isMute());
            VideoOperateListener videoOperateListener = this.b;
            if (videoOperateListener != null) {
                videoOperateListener.onMuteClick(this.a.getPlayInfo(), this.a.isMute());
            }
        } else if (id == R$id.video_error_refresh && (playInfo = this.a.getPlayInfo()) != null) {
            this.a.play(playInfo);
        }
    }

    public void p(boolean z) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "2023616308")) {
            ipChange.ipc$dispatch("2023616308", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        TextView textView = this.g;
        if (!z) {
            i2 = 4;
        }
        textView.setVisibility(i2);
    }
}
