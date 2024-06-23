package cn.damai.tetris.component.home.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.home.bean.HomePageRankBean;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.a03;
import tb.g91;
import tb.gr;
import tb.v50;
import tb.xf2;
import tb.zq;
import tb.zw0;

/* compiled from: Taobao */
public class RankTopAdapter extends RecyclerView.Adapter<RankTopItemViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<HomePageRankBean.Content.RankLists> a;
    private Context b;
    private String c;
    private int d;
    private TrackInfo e;
    private JSONObject f;
    int g = 0;
    private String h;
    private View.OnClickListener i = new a();

    /* compiled from: Taobao */
    public class RankTopItemViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private ImageView a = ((ImageView) this.itemView.findViewById(R$id.homepage_rank_top_item_image));
        private TextView b = ((TextView) this.itemView.findViewById(R$id.homepage_rank_top_item_title));
        private TextView c = ((TextView) this.itemView.findViewById(R$id.homepage_rank_top_item_subtitle));

        public RankTopItemViewHolder() {
            super(LayoutInflater.from(RankTopAdapter.this.b).inflate(R$layout.homepage_rank_top_item, (ViewGroup) null));
            this.itemView.setOnClickListener(RankTopAdapter.this.i);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(v50.a(RankTopAdapter.this.b, 98.0f), -2));
            this.itemView.setPadding(0, v50.a(RankTopAdapter.this.b, (float) RankTopAdapter.this.g), 0, 0);
        }

        public void a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "247392417")) {
                ipChange.ipc$dispatch("247392417", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            HomePageRankBean.Content.RankLists rankLists = (HomePageRankBean.Content.RankLists) RankTopAdapter.this.a.get(i);
            if (rankLists != null) {
                rankLists.position = i;
                if (this.a.getTag() instanceof zq) {
                    ((zq) this.a.getTag()).cancel();
                }
                this.a.setImageDrawable(null);
                DMImageCreator f = cn.damai.common.image.a.b().f(rankLists.pic, v50.a(RankTopAdapter.this.b, 86.0f), v50.a(RankTopAdapter.this.b, 115.0f));
                int i2 = R$drawable.uikit_default_image_bg_gradient;
                this.a.setTag(f.i(i2).c(i2).g(this.a));
                this.b.setText(rankLists.title);
                this.c.setText(rankLists.desc);
                this.itemView.setTag(rankLists);
                if (RankTopAdapter.this.e != null) {
                    TrackInfo trackInfo = RankTopAdapter.this.e;
                    trackInfo.put("index", (Object) ("tab_" + RankTopAdapter.this.d));
                    RankTopAdapter.this.e.put("item_id", (Object) rankLists.id);
                    zw0.B().E(RankTopAdapter.this.e, this.itemView, true, RankTopAdapter.this.c, rankLists.alg, rankLists.scm, rankLists.id, RankTopAdapter.this.d, rankLists.position);
                    return;
                }
                TrackInfo e = a03.e(RankTopAdapter.this.h + rankLists.position, RankTopAdapter.this.f);
                if (e != null) {
                    e.put("index", (Object) ("tab_" + RankTopAdapter.this.d));
                    e.put("item_id", (Object) rankLists.id);
                    TrackProxy.ITrack a2 = TrackProxy.a();
                    TrackType trackType = TrackType.expose;
                    View view = this.itemView;
                    String str = e.trackB;
                    String str2 = e.trackC;
                    a2.userTrack(trackType, view, str, str2, e.trackD + rankLists.position, e.getArgsMap(), false);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "773527908")) {
                ipChange.ipc$dispatch("773527908", new Object[]{this, view});
                return;
            }
            HomePageRankBean.Content.RankLists rankLists = (HomePageRankBean.Content.RankLists) view.getTag();
            Bundle bundle = new Bundle();
            long j = 0;
            try {
                j = Long.parseLong(rankLists.id);
            } catch (Exception e) {
                g91.b("RankTopAdapter", e.getMessage());
            }
            bundle.putLong(RankListFragment.KEY_RANK_ID, j);
            DMNav.from(RankTopAdapter.this.b).withExtras(bundle).toUri(NavUri.b(gr.C));
            if (RankTopAdapter.this.e != null) {
                TrackInfo trackInfo = RankTopAdapter.this.e;
                trackInfo.put("index", (Object) ("tab_" + RankTopAdapter.this.d));
                RankTopAdapter.this.e.put("item_id", (Object) rankLists.id);
                zw0.B().j(RankTopAdapter.this.e, RankTopAdapter.this.c, rankLists.alg, RankTopAdapter.this.d, rankLists.position, rankLists.id);
                return;
            }
            TrackInfo e2 = a03.e(RankTopAdapter.this.h + rankLists.position, RankTopAdapter.this.f);
            if (e2 != null) {
                e2.put("index", (Object) ("tab_" + RankTopAdapter.this.d));
                e2.put("item_id", (Object) rankLists.id);
                TrackProxy.ITrack a2 = TrackProxy.a();
                TrackType trackType = TrackType.click;
                String str = e2.trackB;
                String str2 = e2.trackC;
                a2.userTrack(trackType, null, str, str2, e2.trackD + rankLists.position, e2.getArgsMap(), true);
            }
        }
    }

    public RankTopAdapter(Context context) {
        this.b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2023236371")) {
            return ((Integer) ipChange.ipc$dispatch("2023236371", new Object[]{this})).intValue();
        } else if (xf2.e(this.a) > 10) {
            return 10;
        } else {
            return xf2.e(this.a);
        }
    }

    /* renamed from: i */
    public void onBindViewHolder(@NonNull RankTopItemViewHolder rankTopItemViewHolder, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700352653")) {
            ipChange.ipc$dispatch("1700352653", new Object[]{this, rankTopItemViewHolder, Integer.valueOf(i2)});
            return;
        }
        rankTopItemViewHolder.a(i2);
    }

    @NonNull
    /* renamed from: j */
    public RankTopItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "959136457")) {
            return new RankTopItemViewHolder();
        }
        return (RankTopItemViewHolder) ipChange.ipc$dispatch("959136457", new Object[]{this, viewGroup, Integer.valueOf(i2)});
    }

    public void k(String str, int i2, List<HomePageRankBean.Content.RankLists> list, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122861859")) {
            ipChange.ipc$dispatch("-122861859", new Object[]{this, str, Integer.valueOf(i2), list, trackInfo});
            return;
        }
        this.a = list;
        this.c = str;
        this.d = i2;
        this.e = trackInfo;
        notifyDataSetChanged();
    }

    public void l(String str, int i2, List<HomePageRankBean.Content.RankLists> list, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1751685246")) {
            ipChange.ipc$dispatch("1751685246", new Object[]{this, str, Integer.valueOf(i2), list, jSONObject});
            return;
        }
        this.a = list;
        this.c = str;
        this.d = i2;
        this.f = jSONObject;
        notifyDataSetChanged();
    }

    public void m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-993691688")) {
            ipChange.ipc$dispatch("-993691688", new Object[]{this, str});
            return;
        }
        this.h = str;
    }
}
