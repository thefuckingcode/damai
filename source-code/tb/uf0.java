package tb;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.musicfestival.adapter.OnMarkListener;
import cn.damai.musicfestival.bean.CityFilterBean;
import cn.damai.musicfestival.bean.CityMusicBean;
import cn.damai.musicfestival.bean.MusicIpBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.bg1;

/* compiled from: Taobao */
public class uf0 extends bg1.a<CityMusicBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View d;
    private TextView e;
    private View f;
    private List<View> g = new ArrayList();
    private OnMarkListener<CityMusicBean, CityFilterBean> h;
    private CityMusicBean i;
    private int j;

    public uf0(View view, OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener) {
        super(view);
        this.d = view.findViewById(R$id.mark_s2_layout_highlight);
        this.e = (TextView) view.findViewById(R$id.mark_s2_city_name);
        View findViewById = view.findViewById(R$id.mark_s2_show_layout_1);
        View findViewById2 = view.findViewById(R$id.mark_s2_show_layout_2);
        View findViewById3 = view.findViewById(R$id.mark_s2_show_layout_3);
        this.f = view.findViewById(R$id.mark_s2_close);
        this.g.add(findViewById);
        this.g.add(findViewById2);
        this.g.add(findViewById3);
        this.h = onMarkListener;
    }

    private String c(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1603783552")) {
            return (String) ipChange.ipc$dispatch("1603783552", new Object[]{this, str, str2, str3});
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public void a(CityMusicBean cityMusicBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978233888")) {
            ipChange.ipc$dispatch("-978233888", new Object[]{this, cityMusicBean, Integer.valueOf(i2)});
            return;
        }
        this.i = cityMusicBean;
        this.j = i2;
        this.f.setOnClickListener(this);
        this.e.setText(cityMusicBean.cityName);
        List<MusicIpBean> list = cityMusicBean.musicIpInfos;
        for (int i3 = 0; i3 < 3; i3++) {
            View view = this.g.get(i3);
            MusicIpBean musicIpBean = (MusicIpBean) f92.b(list, i3);
            if (musicIpBean == null) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
                ((TextView) view.findViewById(R$id.item_city_music_p_time)).setText(c(musicIpBean.showTime, musicIpBean.musicIpShortName, " "));
                view.setOnClickListener(this);
                view.setTag(musicIpBean);
            }
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1475200729")) {
            ipChange.ipc$dispatch("1475200729", new Object[]{this, view});
        } else if (this.h != null && this.i != null) {
            int id = view.getId();
            if (id == R$id.mark_s2_close) {
                this.h.onMarkClick(this.i, 2, this.j);
            } else if (id == R$id.mark_s2_show_layout_1 || id == R$id.mark_s2_show_layout_2 || id == R$id.mark_s2_show_layout_3) {
                Object tag = view.getTag();
                if (tag instanceof MusicIpBean) {
                    MusicIpBean musicIpBean = (MusicIpBean) tag;
                    if (!f92.d(musicIpBean.projects)) {
                        this.h.onExpandProjectClick(musicIpBean.projects.get(0).projectId);
                    }
                }
            }
        }
    }
}
