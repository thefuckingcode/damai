package cn.damai.tetris.component.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.home.adapter.IVideoAdapter;
import cn.damai.tetris.component.home.bean.HomePageVideoBean;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.uikit.number.DMDigitTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.n42;
import tb.v50;
import tb.xf2;
import tb.zq;
import tb.zw0;

/* compiled from: Taobao */
public class HeaderVideoAdapter extends RecyclerView.Adapter<VideoItemViewHolder> implements IVideoAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<HomePageVideoBean.HomePageVideoItem> a;
    private IVideoAdapter.OnVideoItemClickListener b;
    private int c;
    private TrackInfo d;
    private int e = 166;
    private HomePageVideoBean.HomePageVideoItem f;

    /* compiled from: Taobao */
    public class VideoItemViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private ImageView b = ((ImageView) this.itemView.findViewById(R$id.homepage_video_item_image));
        private TextView c = ((TextView) this.itemView.findViewById(R$id.homepage_video_item_title));
        private DMDigitTextView d = ((DMDigitTextView) this.itemView.findViewById(R$id.homepage_video_item_desc));
        private TextView e = ((TextView) this.itemView.findViewById(R$id.homepage_video_item_buy_btn));
        private RelativeLayout f = ((RelativeLayout) this.itemView.findViewById(R$id.homepage_video_item_image_layout));
        private TextView g = ((TextView) this.itemView.findViewById(R$id.homepage_video_item_buy_btnarrow));
        private View h = this.itemView.findViewById(R$id.homepage_video_item_btn_single);

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-552671462")) {
                    ipChange.ipc$dispatch("-552671462", new Object[]{this, view});
                    return;
                }
                HomePageVideoBean.HomePageVideoItem homePageVideoItem = (HomePageVideoBean.HomePageVideoItem) view.getTag();
                if (HeaderVideoAdapter.this.b != null) {
                    HeaderVideoAdapter.this.b.onBuyClick(homePageVideoItem.index, homePageVideoItem.schema, homePageVideoItem.projectPic, homePageVideoItem.projectId);
                }
            }
        }

        /* compiled from: Taobao */
        public class b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1558618907")) {
                    ipChange.ipc$dispatch("1558618907", new Object[]{this, view});
                    return;
                }
                HomePageVideoBean.HomePageVideoItem homePageVideoItem = (HomePageVideoBean.HomePageVideoItem) view.getTag();
                if (HeaderVideoAdapter.this.b != null) {
                    HeaderVideoAdapter.this.b.onBuyClick(homePageVideoItem.index, homePageVideoItem.schema, homePageVideoItem.projectPic, homePageVideoItem.projectId);
                }
            }
        }

        /* compiled from: Taobao */
        public class c implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            c() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-625058020")) {
                    ipChange.ipc$dispatch("-625058020", new Object[]{this, view});
                    return;
                }
                HomePageVideoBean.HomePageVideoItem homePageVideoItem = (HomePageVideoBean.HomePageVideoItem) view.getTag();
                if (homePageVideoItem != null) {
                    for (HomePageVideoBean.HomePageVideoItem homePageVideoItem2 : HeaderVideoAdapter.this.a) {
                        if (homePageVideoItem2.isPlay) {
                            homePageVideoItem2.isPlay = false;
                        }
                    }
                    homePageVideoItem.isPlay = true;
                    HeaderVideoAdapter.this.f = homePageVideoItem;
                    HeaderVideoAdapter.this.notifyDataSetChanged();
                    if (homePageVideoItem.index != HeaderVideoAdapter.this.c) {
                        HeaderVideoAdapter.this.c = homePageVideoItem.index;
                        if (HeaderVideoAdapter.this.b != null) {
                            HeaderVideoAdapter.this.b.onItemClick(view, homePageVideoItem.index, homePageVideoItem);
                        }
                    } else if (HeaderVideoAdapter.this.b != null) {
                        HeaderVideoAdapter.this.b.onItemReClick(homePageVideoItem.index, homePageVideoItem.schema, homePageVideoItem.projectPic, homePageVideoItem.projectId);
                    }
                }
            }
        }

        public VideoItemViewHolder(Context context, int i2) {
            super(LayoutInflater.from(context).inflate(i2, (ViewGroup) null));
            this.a = context;
            if (HeaderVideoAdapter.this.getItemCount() > 1) {
                HeaderVideoAdapter.this.e = (DisplayMetrics.getwidthPixels(n42.c((Activity) this.a)) - v50.a(this.a, 42.0f)) / 2;
            } else {
                HeaderVideoAdapter.this.e = DisplayMetrics.getwidthPixels(n42.c((Activity) this.a)) - v50.a(this.a, 30.0f);
            }
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(HeaderVideoAdapter.this.e, v50.a(this.a, 60.0f)));
        }

        public void a(int i2) {
            TextView textView;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-880247404")) {
                ipChange.ipc$dispatch("-880247404", new Object[]{this, Integer.valueOf(i2)});
                return;
            }
            HomePageVideoBean.HomePageVideoItem homePageVideoItem = (HomePageVideoBean.HomePageVideoItem) HeaderVideoAdapter.this.a.get(i2);
            if (homePageVideoItem != null) {
                homePageVideoItem.index = i2;
                if ((HeaderVideoAdapter.this.f == null && i2 == 0) || homePageVideoItem.isPlay) {
                    homePageVideoItem.isPlay = true;
                    HeaderVideoAdapter.this.f = homePageVideoItem;
                    HeaderVideoAdapter.this.c = homePageVideoItem.index;
                }
                if (this.b.getTag() instanceof zq) {
                    ((zq) this.b.getTag()).cancel();
                }
                DMImageCreator f2 = cn.damai.common.image.a.b().f(homePageVideoItem.projectPic, HeaderVideoAdapter.this.e, v50.a(this.a, 60.0f));
                int i3 = R$drawable.uikit_default_image_bg_gradient;
                this.b.setTag(f2.i(i3).c(i3).g(this.b));
                if (!TextUtils.isEmpty(homePageVideoItem.projectName)) {
                    this.c.setText(homePageVideoItem.projectName);
                } else {
                    this.c.setText("");
                }
                if (!TextUtils.isEmpty(homePageVideoItem.priceLow)) {
                    DMDigitTextView dMDigitTextView = this.d;
                    dMDigitTextView.setText("¥" + homePageVideoItem.priceLow);
                } else {
                    this.d.setText("");
                }
                if (!homePageVideoItem.isPlay || HeaderVideoAdapter.this.getItemCount() <= 1) {
                    this.f.setBackground(this.a.getResources().getDrawable(R$drawable.bg_border_corner_6_headervideoitem));
                    TextView textView2 = this.e;
                    if (textView2 != null) {
                        Resources resources = this.a.getResources();
                        int i4 = R$color.color_80ffffff;
                        textView2.setTextColor(resources.getColor(i4));
                        this.g.setTextColor(this.a.getResources().getColor(i4));
                    }
                    this.c.setTextColor(this.a.getResources().getColor(R$color.color_80ffffff));
                } else {
                    this.f.setBackground(this.a.getResources().getDrawable(R$drawable.bg_border_corner_6_headervideoitemred));
                    TextView textView3 = this.e;
                    if (textView3 != null) {
                        Resources resources2 = this.a.getResources();
                        int i5 = R$color.white;
                        textView3.setTextColor(resources2.getColor(i5));
                        this.g.setTextColor(this.a.getResources().getColor(i5));
                    }
                    this.c.setTextColor(this.a.getResources().getColor(R$color.white));
                }
                this.itemView.setTag(homePageVideoItem);
                if (HeaderVideoAdapter.this.getItemCount() <= 1 || (textView = this.e) == null) {
                    View view = this.h;
                    if (view != null) {
                        view.setTag(homePageVideoItem);
                        this.h.setOnClickListener(new b());
                    }
                } else {
                    textView.setTag(homePageVideoItem);
                    this.e.setOnClickListener(new a());
                }
                this.itemView.setOnClickListener(new c());
                zw0.B().M(HeaderVideoAdapter.this.d, this.b, homePageVideoItem.projectId, homePageVideoItem.index);
                if (HeaderVideoAdapter.this.getItemCount() <= 1 || this.e == null) {
                    zw0.B().N(HeaderVideoAdapter.this.d, this.h, homePageVideoItem.projectId, homePageVideoItem.index);
                } else {
                    zw0.B().N(HeaderVideoAdapter.this.d, this.e, homePageVideoItem.projectId, homePageVideoItem.index);
                }
            }
        }
    }

    private int j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1962064001")) {
            return getItemCount() == 1 ? R$layout.dm_header_video_item_single : R$layout.dm_header_video_item;
        }
        return ((Integer) ipChange.ipc$dispatch("1962064001", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-632441138")) {
            return xf2.e(this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("-632441138", new Object[]{this})).intValue();
    }

    /* renamed from: k */
    public void onBindViewHolder(@NonNull VideoItemViewHolder videoItemViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615064075")) {
            ipChange.ipc$dispatch("-1615064075", new Object[]{this, videoItemViewHolder, Integer.valueOf(i)});
            return;
        }
        videoItemViewHolder.a(i);
    }

    @NonNull
    /* renamed from: l */
    public VideoItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1319839519")) {
            return new VideoItemViewHolder(viewGroup.getContext(), j());
        }
        return (VideoItemViewHolder) ipChange.ipc$dispatch("-1319839519", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter
    public void reset(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1432911622")) {
            ipChange.ipc$dispatch("-1432911622", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.c = 0;
            this.f = null;
        }
    }

    @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter
    public void setData(String str, List<HomePageVideoBean.HomePageVideoItem> list, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798516419")) {
            ipChange.ipc$dispatch("1798516419", new Object[]{this, str, list, trackInfo});
            return;
        }
        this.a = list;
        this.d = trackInfo;
        notifyDataSetChanged();
    }

    @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter
    public void setOnVideoItemClickListener(IVideoAdapter.OnVideoItemClickListener onVideoItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-138196400")) {
            ipChange.ipc$dispatch("-138196400", new Object[]{this, onVideoItemClickListener});
            return;
        }
        this.b = onVideoItemClickListener;
    }
}
