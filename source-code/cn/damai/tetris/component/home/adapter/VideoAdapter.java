package cn.damai.tetris.component.home.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMImageStrategyConfig;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.home.adapter.IVideoAdapter;
import cn.damai.tetris.component.home.bean.ArtistHeadBean;
import cn.damai.tetris.component.home.bean.HomePageVideoBean;
import cn.damai.tetris.component.home.utils.DMMarqueeView;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.view.LiveRoomView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.f92;
import tb.n42;
import tb.v50;
import tb.xf2;
import tb.xs0;
import tb.zq;
import tb.zw0;

/* compiled from: Taobao */
public class VideoAdapter extends RecyclerView.Adapter<VideoItemViewHolder> implements IVideoAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<HomePageVideoBean.HomePageVideoItem> a;
    private IVideoAdapter.OnVideoItemClickListener b;
    private int c;
    private TrackInfo d;
    private HomePageVideoBean.HomePageVideoItem e;

    /* compiled from: Taobao */
    public class VideoItemViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private ImageView b = ((ImageView) this.itemView.findViewById(R$id.homepage_video_item_image));
        private DMCategroyTagView c = ((DMCategroyTagView) this.itemView.findViewById(R$id.homepage_video_item_tag));
        private LiveRoomView d = ((LiveRoomView) this.itemView.findViewById(R$id.homepage_rank_item_live_room));
        private TextView e = ((TextView) this.itemView.findViewById(R$id.homepage_video_item_title));
        private FrameLayout f = ((FrameLayout) this.itemView.findViewById(R$id.homepage_video_item_price_layout));
        private DMDigitTextView g = ((DMDigitTextView) this.itemView.findViewById(R$id.homepage_video_item_price));
        private TextView h = ((TextView) this.itemView.findViewById(R$id.homepage_video_item_buy_btn));
        private ImageView i = ((ImageView) this.itemView.findViewById(R$id.homepage_video_play_cover));
        private ImageView j = ((ImageView) this.itemView.findViewById(R$id.homepage_video_play_border));
        private View k;
        private ImageView l;
        private TextView m;
        private DMMarqueeView n;
        private View o;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-623018771")) {
                    ipChange.ipc$dispatch("-623018771", new Object[]{this, view});
                    return;
                }
                HomePageVideoBean.HomePageVideoItem homePageVideoItem = (HomePageVideoBean.HomePageVideoItem) view.getTag();
                if (VideoAdapter.this.b != null) {
                    VideoAdapter.this.b.onBuyClick(homePageVideoItem.index, homePageVideoItem.schema, homePageVideoItem.projectPic, homePageVideoItem.projectId);
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
                if (AndroidInstantRuntime.support(ipChange, "1488271598")) {
                    ipChange.ipc$dispatch("1488271598", new Object[]{this, view});
                    return;
                }
                HomePageVideoBean.HomePageVideoItem homePageVideoItem = (HomePageVideoBean.HomePageVideoItem) view.getTag();
                if (homePageVideoItem != null) {
                    VideoAdapter.this.e.isPlay = false;
                    homePageVideoItem.isPlay = true;
                    VideoAdapter.this.e = homePageVideoItem;
                    VideoAdapter.this.e = homePageVideoItem;
                    VideoAdapter.this.notifyDataSetChanged();
                    if (homePageVideoItem.index != VideoAdapter.this.c) {
                        VideoAdapter.this.c = homePageVideoItem.index;
                        if (VideoAdapter.this.b != null) {
                            VideoAdapter.this.b.onItemClick(view, homePageVideoItem.index, homePageVideoItem);
                        }
                    } else if (VideoAdapter.this.b != null) {
                        VideoAdapter.this.b.onItemReClick(homePageVideoItem.index, homePageVideoItem.schema, homePageVideoItem.projectPic, homePageVideoItem.projectId);
                    }
                }
            }
        }

        public VideoItemViewHolder(Context context) {
            super(LayoutInflater.from(context).inflate(R$layout.homepage_video_itemv2, (ViewGroup) null));
            this.a = context;
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(v50.a(this.a, 98.0f), -2));
            this.n = (DMMarqueeView) this.itemView.findViewById(R$id.multi_user_layout);
            this.k = this.itemView.findViewById(R$id.single_user_layout);
            this.m = (TextView) this.itemView.findViewById(R$id.user_head_single_name);
            this.l = (ImageView) this.itemView.findViewById(R$id.user_head_single);
            this.o = this.itemView.findViewById(R$id.homepage_video_poster_mask);
        }

        public void a(int i2) {
            boolean z;
            IpChange ipChange = $ipChange;
            int i3 = 0;
            if (AndroidInstantRuntime.support(ipChange, "-649487519")) {
                ipChange.ipc$dispatch("-649487519", new Object[]{this, Integer.valueOf(i2)});
                return;
            }
            HomePageVideoBean.HomePageVideoItem homePageVideoItem = (HomePageVideoBean.HomePageVideoItem) VideoAdapter.this.a.get(i2);
            if (homePageVideoItem != null) {
                int a2 = n42.a(xs0.a(), 20.0f);
                DMImageStrategyConfig dMImageStrategyConfig = new DMImageStrategyConfig();
                dMImageStrategyConfig.g = a2;
                dMImageStrategyConfig.h = a2;
                List<ArtistHeadBean> list = homePageVideoItem.artistVOS;
                if (f92.d(list)) {
                    this.k.setVisibility(8);
                    this.n.setVisibility(8);
                    z = false;
                } else {
                    int e2 = xf2.e(list);
                    if (e2 == 1) {
                        ArtistHeadBean artistHeadBean = (ArtistHeadBean) f92.b(list, 0);
                        this.k.setVisibility(0);
                        this.n.setVisibility(8);
                        if (artistHeadBean != null) {
                            this.m.setText(artistHeadBean.name);
                            VideoAdapter.this.i(artistHeadBean.headPic, this.l);
                        }
                    } else {
                        this.n.setVisibility(0);
                        this.k.setVisibility(8);
                        ArrayList arrayList = new ArrayList();
                        for (int i4 = 0; i4 < e2; i4++) {
                            ArtistHeadBean artistHeadBean2 = (ArtistHeadBean) f92.b(list, i4);
                            if (artistHeadBean2 != null) {
                                View inflate = LayoutInflater.from(this.a).inflate(R$layout.homepage_video_item_artist, (ViewGroup) null);
                                ((TextView) inflate.findViewById(R$id.user_head_single_name)).setText(artistHeadBean2.name);
                                VideoAdapter.this.i(artistHeadBean2.headPic, (ImageView) inflate.findViewById(R$id.user_head_single));
                                arrayList.add(inflate);
                            }
                        }
                        this.n.setAnimationDuration(500);
                        this.n.setFlipInterval(3000);
                        this.n.setItems(arrayList);
                    }
                    z = true;
                }
                homePageVideoItem.index = i2;
                if ((VideoAdapter.this.e == null && i2 == 0) || homePageVideoItem.isPlay) {
                    homePageVideoItem.isPlay = true;
                    VideoAdapter.this.e = homePageVideoItem;
                    VideoAdapter.this.c = homePageVideoItem.index;
                }
                if (this.b.getTag() instanceof zq) {
                    ((zq) this.b.getTag()).cancel();
                }
                DMImageCreator f2 = cn.damai.common.image.a.b().f(homePageVideoItem.projectPic, v50.a(this.a, 98.0f), v50.a(this.a, 131.0f));
                int i5 = R$drawable.uikit_default_image_bg_gradient;
                this.b.setTag(f2.i(i5).c(i5).g(this.b));
                if (homePageVideoItem.isLiveRoom()) {
                    this.c.setVisibility(8);
                    this.d.setLiveType(homePageVideoItem.getLiveType());
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                    if (!TextUtils.isEmpty(homePageVideoItem.categoryName)) {
                        this.c.setTagName(homePageVideoItem.categoryName);
                        this.c.setVisibility(0);
                    } else {
                        this.c.setTagName("");
                        this.c.setVisibility(8);
                    }
                }
                if (!TextUtils.isEmpty(homePageVideoItem.projectName)) {
                    this.e.setText(homePageVideoItem.projectName);
                } else {
                    this.e.setText("");
                }
                if (!TextUtils.isEmpty(homePageVideoItem.priceLow)) {
                    this.g.setText(homePageVideoItem.priceLow);
                    this.f.setVisibility(0);
                } else {
                    this.g.setText("");
                    this.f.setVisibility(4);
                }
                this.j.setVisibility(homePageVideoItem.isPlay ? 0 : 8);
                this.i.setVisibility(homePageVideoItem.isPlay ? 8 : 0);
                View view = this.o;
                if (!z || !homePageVideoItem.isPlay) {
                    i3 = 8;
                }
                view.setVisibility(i3);
                this.h.setTag(homePageVideoItem);
                this.itemView.setTag(homePageVideoItem);
                this.h.setOnClickListener(new a());
                this.itemView.setOnClickListener(new b());
                zw0.B().M(VideoAdapter.this.d, this.b, homePageVideoItem.projectId, homePageVideoItem.index);
                zw0.B().N(VideoAdapter.this.d, this.h, homePageVideoItem.projectId, homePageVideoItem.index);
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        a(VideoAdapter videoAdapter, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "295435640")) {
                ipChange.ipc$dispatch("295435640", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004469458")) {
            ipChange.ipc$dispatch("1004469458", new Object[]{this, str, imageView});
            return;
        }
        int a2 = n42.a(xs0.a(), 20.0f);
        cn.damai.common.image.a.b().f(str, a2, a2).n(new a(this, imageView)).f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-495437279")) {
            return xf2.e(this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("-495437279", new Object[]{this})).intValue();
    }

    /* renamed from: j */
    public void onBindViewHolder(@NonNull VideoItemViewHolder videoItemViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1655632987")) {
            ipChange.ipc$dispatch("1655632987", new Object[]{this, videoItemViewHolder, Integer.valueOf(i)});
            return;
        }
        videoItemViewHolder.a(i);
    }

    @NonNull
    /* renamed from: k */
    public VideoItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1293249349")) {
            return new VideoItemViewHolder(viewGroup.getContext());
        }
        return (VideoItemViewHolder) ipChange.ipc$dispatch("-1293249349", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter
    public void reset(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "946847373")) {
            ipChange.ipc$dispatch("946847373", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter
    public void setData(String str, List<HomePageVideoBean.HomePageVideoItem> list, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1230652336")) {
            ipChange.ipc$dispatch("-1230652336", new Object[]{this, str, list, trackInfo});
            return;
        }
        this.a = list;
        this.d = trackInfo;
        notifyDataSetChanged();
    }

    @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter
    public void setOnVideoItemClickListener(IVideoAdapter.OnVideoItemClickListener onVideoItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944755613")) {
            ipChange.ipc$dispatch("-1944755613", new Object[]{this, onVideoItemClickListener});
            return;
        }
        this.b = onVideoItemClickListener;
    }
}
