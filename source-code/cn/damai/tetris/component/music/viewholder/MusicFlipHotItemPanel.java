package cn.damai.tetris.component.music.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.musicfestival.bean.MusicDispatchBean;
import cn.damai.uikit.banner.sub.RoundRadiusImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public class MusicFlipHotItemPanel implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final int g = n42.a(xs0.a(), 26.0f);
    private final View a;
    private final TextView b;
    private final View c;
    private final RoundRadiusImageView d;
    private OnOneFlipperItemListener e;
    public MusicDispatchBean f;

    /* compiled from: Taobao */
    public interface OnOneFlipperItemListener {
        void onIpIconClick(MusicFlipHotItemPanel musicFlipHotItemPanel, MusicDispatchBean musicDispatchBean);

        void onItemClick(MusicFlipHotItemPanel musicFlipHotItemPanel, MusicDispatchBean musicDispatchBean);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "443252770")) {
                ipChange.ipc$dispatch("443252770", new Object[]{this, view});
                return;
            }
            OnOneFlipperItemListener onOneFlipperItemListener = MusicFlipHotItemPanel.this.e;
            MusicFlipHotItemPanel musicFlipHotItemPanel = MusicFlipHotItemPanel.this;
            onOneFlipperItemListener.onIpIconClick(musicFlipHotItemPanel, musicFlipHotItemPanel.f);
        }
    }

    public MusicFlipHotItemPanel(ViewGroup viewGroup, OnOneFlipperItemListener onOneFlipperItemListener) {
        this.e = onOneFlipperItemListener;
        View inflate = LayoutInflater.from(xs0.a()).inflate(R$layout.item_tetris_music_festival_hot, viewGroup, false);
        this.a = inflate;
        this.b = (TextView) inflate.findViewById(R$id.mfh_text);
        this.c = inflate.findViewById(R$id.mfh_text_layout);
        RoundRadiusImageView roundRadiusImageView = new RoundRadiusImageView(xs0.a());
        this.d = roundRadiusImageView;
        roundRadiusImageView.setRoundRadius(n42.a(xs0.a(), 13.0f));
        roundRadiusImageView.setOnClickListener(new a());
        inflate.setTag(this);
    }

    public void b(MusicDispatchBean musicDispatchBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460224734")) {
            ipChange.ipc$dispatch("-460224734", new Object[]{this, musicDispatchBean});
        } else if (musicDispatchBean != null) {
            this.f = musicDispatchBean;
            this.b.setText(musicDispatchBean.title);
            this.b.setOnClickListener(this);
            cn.damai.common.image.a b2 = cn.damai.common.image.a.b();
            String str = musicDispatchBean.picUrl;
            int i = g;
            b2.f(str, i, i).g(this.d);
        }
    }

    public View c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-312510688")) {
            return this.d;
        }
        return (View) ipChange.ipc$dispatch("-312510688", new Object[]{this});
    }

    public View d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2079928353")) {
            return this.c;
        }
        return (View) ipChange.ipc$dispatch("-2079928353", new Object[]{this});
    }

    public View e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-602271718")) {
            return this.a;
        }
        return (View) ipChange.ipc$dispatch("-602271718", new Object[]{this});
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1904301483")) {
            ipChange.ipc$dispatch("-1904301483", new Object[]{this, view});
        } else if (this.f != null && view.getId() == R$id.mfh_text) {
            this.e.onItemClick(this, this.f);
        }
    }
}
