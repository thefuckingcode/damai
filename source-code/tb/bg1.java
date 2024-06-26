package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.musicfestival.adapter.OnMarkListener;
import cn.damai.musicfestival.bean.CityFilterBean;
import cn.damai.musicfestival.bean.CityMusicBean;
import cn.damai.musicfestival.view.MusicFestivalMapView;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.uplayer.AliMediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class bg1 extends MusicFestivalMapView.b<a> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CLICK_TYPE_CLOSE = 2;
    public static final int CLICK_TYPE_ITEM = 1;
    private Context b;
    private int c;
    private OnMarkListener<CityMusicBean, CityFilterBean> d;
    private List e = new ArrayList();
    private boolean f;

    /* compiled from: Taobao */
    public static abstract class a<T> extends MusicFestivalMapView.e {
        public a(View view) {
            super(view);
        }

        public abstract void a(T t, int i);
    }

    /* compiled from: Taobao */
    public class b extends a<CityFilterBean> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private RoundImageView d;
        private TextView e;
        private OnMarkListener<CityMusicBean, CityFilterBean> f;
        private CityFilterBean g;
        private int h;

        /* compiled from: Taobao */
        public class a implements IImageLoader.IImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
            public void onSuccess(IImageLoader.b bVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-358501162")) {
                    ipChange.ipc$dispatch("-358501162", new Object[]{this, bVar});
                    return;
                }
                b.this.d.setImageDrawable(bVar.a);
            }
        }

        /* renamed from: tb.bg1$b$b  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0298b implements IImageLoader.IImageFailListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C0298b() {
            }

            @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
            public void onFail(IImageLoader.a aVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-246133313")) {
                    ipChange.ipc$dispatch("-246133313", new Object[]{this, aVar});
                    return;
                }
                b.this.d.setImageDrawable(null);
            }
        }

        public b(View view, OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener) {
            super(view);
            this.d = (RoundImageView) view.findViewById(R$id.mark_s4_filter_icon);
            this.e = (TextView) view.findViewById(R$id.mark_s4_filter_title);
            this.f = onMarkListener;
        }

        /* renamed from: c */
        public void a(CityFilterBean cityFilterBean, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-15072157")) {
                ipChange.ipc$dispatch("-15072157", new Object[]{this, cityFilterBean, Integer.valueOf(i2)});
                return;
            }
            this.g = cityFilterBean;
            this.h = i2;
            MusicFestivalMapView.MfmLayoutParams.setLocationAndZ(this.c.getLayoutParams(), cityFilterBean.xRatioInWidth, cityFilterBean.yRatioInHeight, 0, n42.a(xs0.a(), 10.0f));
            this.e.setText(cityFilterBean.title);
            cn.damai.common.image.a.b().load(cityFilterBean.iconUrl, bg1.this.c, bg1.this.c, new a(), new C0298b());
            this.c.setOnClickListener(this);
        }

        public void onClick(View view) {
            CityFilterBean cityFilterBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "516193097")) {
                ipChange.ipc$dispatch("516193097", new Object[]{this, view});
                return;
            }
            OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener = this.f;
            if (onMarkListener != null && (cityFilterBean = this.g) != null) {
                onMarkListener.onFilterClick(cityFilterBean, this.h);
            }
        }
    }

    /* compiled from: Taobao */
    public static class c extends a<CityMusicBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        private View d;
        private View e;
        private View f;
        private uf0 g;
        private kj1 h;
        private List<View> i = new ArrayList();
        public CityMusicBean j;
        public int k;

        public c(View view, OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener) {
            super(view);
            this.d = view.findViewById(R$id.mark_s1_layout_normal);
            this.e = view.findViewById(R$id.mark_s2_layout_highlight);
            this.f = view.findViewById(R$id.mark_s3_layout_point);
            this.i.add(this.d);
            this.i.add(this.e);
            this.i.add(this.f);
            this.g = new uf0(this.e, onMarkListener);
            this.h = new kj1(this.d, onMarkListener);
        }

        private void c(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "875077443")) {
                ipChange.ipc$dispatch("875077443", new Object[]{this, view});
                return;
            }
            for (View view2 : this.i) {
                if (view2 == view) {
                    view2.setVisibility(0);
                } else {
                    view2.setVisibility(8);
                }
            }
        }

        /* renamed from: b */
        public void a(CityMusicBean cityMusicBean, int i2) {
            int i3;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-38313800")) {
                ipChange.ipc$dispatch("-38313800", new Object[]{this, cityMusicBean, Integer.valueOf(i2)});
            } else if (cityMusicBean != null) {
                this.j = cityMusicBean;
                this.k = i2;
                if (!cityMusicBean.isShowFull()) {
                    c(this.f);
                } else if (cityMusicBean.high) {
                    i3 = 100;
                    c(this.e);
                    this.g.a(cityMusicBean, i2);
                    MusicFestivalMapView.MfmLayoutParams.setLocationAndZ(this.c.getLayoutParams(), cityMusicBean.getXRatioInWidth(), cityMusicBean.getYRatioInHeight(), i3, 0);
                } else {
                    c(this.d);
                    this.h.a(cityMusicBean, i2);
                }
                i3 = 0;
                MusicFestivalMapView.MfmLayoutParams.setLocationAndZ(this.c.getLayoutParams(), cityMusicBean.getXRatioInWidth(), cityMusicBean.getYRatioInHeight(), i3, 0);
            }
        }
    }

    public bg1(Context context, OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener) {
        this.b = context;
        this.d = onMarkListener;
        this.c = n42.a(context, 16.0f);
    }

    @Override // cn.damai.musicfestival.view.MusicFestivalMapView.b
    public int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305532109")) {
            return ((Integer) ipChange.ipc$dispatch("1305532109", new Object[]{this})).intValue();
        }
        List list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // cn.damai.musicfestival.view.MusicFestivalMapView.b
    public int c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-86269196")) {
            return ((Integer) ipChange.ipc$dispatch("-86269196", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        Class<?> cls = this.e.get(i).getClass();
        if (cls == CityMusicBean.class) {
            return 136;
        }
        if (cls == CityFilterBean.class) {
            return AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX;
        }
        return super.c(i);
    }

    public boolean i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "610849388")) {
            return this.f;
        }
        return ((Boolean) ipChange.ipc$dispatch("610849388", new Object[]{this})).booleanValue();
    }

    /* renamed from: j */
    public void f(@NonNull a aVar, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845551376")) {
            ipChange.ipc$dispatch("1845551376", new Object[]{this, aVar, Integer.valueOf(i)});
            return;
        }
        aVar.a(this.e.get(i), i);
    }

    /* renamed from: k */
    public a g(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-186175962")) {
            return (a) ipChange.ipc$dispatch("-186175962", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i == 136) {
            return new c(LayoutInflater.from(this.b).inflate(R$layout.item_city_map_mark, viewGroup, false), this.d);
        } else {
            if (i == 153) {
                return new b(LayoutInflater.from(this.b).inflate(R$layout.item_city_mark_filter_city, viewGroup, false), this.d);
            }
            return null;
        }
    }

    public boolean l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793556345")) {
            return ((Boolean) ipChange.ipc$dispatch("-1793556345", new Object[]{this})).booleanValue();
        } else if (f92.d(this.e)) {
            return false;
        } else {
            boolean z = false;
            for (Object obj : this.e) {
                if (obj instanceof CityMusicBean) {
                    CityMusicBean cityMusicBean = (CityMusicBean) obj;
                    if (cityMusicBean.isHighlight()) {
                        z = true;
                    }
                    cityMusicBean.high = false;
                }
            }
            return z;
        }
    }

    public void m(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495675752")) {
            ipChange.ipc$dispatch("495675752", new Object[]{this, list});
            return;
        }
        this.e.clear();
        if (!f92.d(list)) {
            this.e.addAll(list);
            this.f = list.get(0) instanceof CityMusicBean;
        } else {
            this.f = false;
        }
        d();
    }
}
