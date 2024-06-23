package tb;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.musicfestival.adapter.OnMarkListener;
import cn.damai.musicfestival.bean.CityFilterBean;
import cn.damai.musicfestival.bean.CityMusicBean;
import cn.damai.musicfestival.bean.MusicIpBean;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.bg1;

/* compiled from: Taobao */
public class kj1 extends bg1.a<CityMusicBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View d;
    private TextView e;
    private TextView f;
    private List<ViewGroup> g = new ArrayList();
    private final int h;
    private OnMarkListener<CityMusicBean, CityFilterBean> i;
    private CityMusicBean j;
    private int k;

    /* compiled from: Taobao */
    public class a implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        a(kj1 kj1, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1416839628")) {
                ipChange.ipc$dispatch("-1416839628", new Object[]{this, bVar});
                return;
            }
            this.a.setImageDrawable(bVar.a);
        }
    }

    /* compiled from: Taobao */
    public class b implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(kj1 kj1) {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1545680285")) {
                ipChange.ipc$dispatch("1545680285", new Object[]{this, aVar});
            }
        }
    }

    public kj1(View view, OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener) {
        super(view);
        this.d = view.findViewById(R$id.mark_s1_layout_normal);
        this.g.add((ViewGroup) view.findViewById(R$id.mark_s1_img_1_ui));
        this.g.add((ViewGroup) view.findViewById(R$id.mark_s1_img_2_ui));
        this.g.add((ViewGroup) view.findViewById(R$id.mark_s1_img_3_ui));
        this.e = (TextView) view.findViewById(R$id.mark_s1_city_name);
        this.f = (TextView) view.findViewById(R$id.mark_s1_city_name_shining);
        this.h = n42.a(xs0.a(), 16.0f);
        this.i = onMarkListener;
    }

    /* renamed from: b */
    public void a(CityMusicBean cityMusicBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-93453646")) {
            ipChange.ipc$dispatch("-93453646", new Object[]{this, cityMusicBean, Integer.valueOf(i2)});
            return;
        }
        this.j = cityMusicBean;
        this.k = i2;
        this.d.setOnClickListener(this);
        this.e.setText(cityMusicBean.cityName);
        this.f.setText(cityMusicBean.cityName);
        List<MusicIpBean> list = cityMusicBean.musicIpInfos;
        if (TextUtils.isEmpty(cityMusicBean.shiningIpId)) {
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        } else {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
        }
        for (int i3 = 0; i3 < 3; i3++) {
            ViewGroup viewGroup = this.g.get(i3);
            MusicIpBean musicIpBean = (MusicIpBean) f92.b(list, i3);
            if (musicIpBean == null) {
                viewGroup.setVisibility(8);
            } else {
                viewGroup.setVisibility(0);
                View childAt = viewGroup.getChildAt(0);
                if (childAt instanceof ImageView) {
                    cn.damai.common.image.a b2 = cn.damai.common.image.a.b();
                    String str = musicIpBean.musicIpIcon;
                    int i4 = this.h;
                    b2.load(str, i4, i4, new a(this, (ImageView) childAt), new b(this));
                }
            }
        }
    }

    public void onClick(View view) {
        CityMusicBean cityMusicBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-650652117")) {
            ipChange.ipc$dispatch("-650652117", new Object[]{this, view});
            return;
        }
        OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener = this.i;
        if (onMarkListener != null && (cityMusicBean = this.j) != null) {
            onMarkListener.onMarkClick(cityMusicBean, 1, this.k);
        }
    }
}
