package cn.damai.category.venue.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.venue.bean.ProjectVo;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.view.RoundImageView;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.n42;
import tb.tb2;
import tb.xf2;

/* compiled from: Taobao */
public class VenueProjectGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ProjectVo> b = new ArrayList();
    private String c;
    private String d;
    private String e;
    private String f;
    private int g = 1;

    /* compiled from: Taobao */
    public class ViewHolder extends RecyclerView.ViewHolder {
        RoundImageView a;
        DMCategroyTagView b;
        TextView c;
        TextView d;
        DMDigitTextView e;
        LinearLayout f;

        public ViewHolder(VenueProjectGridAdapter venueProjectGridAdapter, View view) {
            super(view);
            this.a = (RoundImageView) view.findViewById(R$id.venus_rank_item_image);
            this.b = (DMCategroyTagView) view.findViewById(R$id.venus_rank_item_image_tag);
            TextView textView = (TextView) view.findViewById(R$id.venus_rank_item_rank);
            this.c = (TextView) view.findViewById(R$id.venus_rank_item_title);
            this.d = (TextView) view.findViewById(R$id.venus_rank_item_time);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.venus_rank_item_price_layout);
            this.e = (DMDigitTextView) view.findViewById(R$id.venus_rank_item_price);
            TextView textView2 = (TextView) view.findViewById(R$id.venus_rank_item_price_label);
            this.f = (LinearLayout) view.findViewById(R$id.project_layout);
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectVo a;
        final /* synthetic */ int b;

        a(ProjectVo projectVo, int i) {
            this.a = projectVo;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1078049252")) {
                ipChange.ipc$dispatch("1078049252", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(MonitorType.SKIP, true);
            bundle.putString("from_page", "venue");
            bundle.putString("id", this.a.projectId);
            tb2.a(VenueProjectGridAdapter.this.a, this.a.schema, bundle);
            HashMap hashMap = new HashMap();
            hashMap.put("city", VenueProjectGridAdapter.this.f);
            hashMap.put("titlelabel", VenueProjectGridAdapter.this.d);
            hashMap.put("contentlabel", this.a.projectName);
            hashMap.put("venue_id", VenueProjectGridAdapter.this.c);
            hashMap.put("item_id", this.a.projectId);
            if (VenueProjectGridAdapter.this.g == 1) {
                c.e().x(new b().e("venue", "venue_card_" + VenueProjectGridAdapter.this.e, "item_" + this.b, hashMap, Boolean.TRUE));
                return;
            }
            c.e().x(new b().e("venue", "nearby_venue_card_" + VenueProjectGridAdapter.this.e, "item_" + this.b, hashMap, Boolean.TRUE));
        }
    }

    public VenueProjectGridAdapter(Context context, List<ProjectVo> list, String str, String str2, String str3, String str4, int i) {
        this.b = list;
        this.a = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = i;
    }

    /* renamed from: g */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825413319")) {
            ipChange.ipc$dispatch("825413319", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        ProjectVo projectVo = this.b.get(i);
        viewHolder.c.setText(projectVo.projectName);
        DMDigitTextView dMDigitTextView = viewHolder.e;
        dMDigitTextView.setText(String.valueOf("¥" + projectVo.priceLow));
        cn.damai.common.image.a.b().f(projectVo.projectPic, n42.a(this.a, 111.0f), n42.a(this.a, 148.0f)).c(R$drawable.uikit_default_image_bg_grey).g(viewHolder.a);
        viewHolder.f.setOnClickListener(new a(projectVo, i));
        String str = projectVo.categoryName;
        if (str == null || str.isEmpty()) {
            viewHolder.b.setVisibility(8);
        } else {
            viewHolder.b.setTagName(projectVo.categoryName);
            viewHolder.b.setVisibility(0);
        }
        viewHolder.d.setText(projectVo.projectDatetime);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-653278317")) {
            return xf2.e(this.b);
        }
        return ((Integer) ipChange.ipc$dispatch("-653278317", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-33573929")) {
            return (long) i;
        }
        return ((Long) ipChange.ipc$dispatch("-33573929", new Object[]{this, Integer.valueOf(i)})).longValue();
    }

    @NonNull
    /* renamed from: h */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2033964943")) {
            return new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.category_venue_project_item, viewGroup, false));
        }
        return (ViewHolder) ipChange.ipc$dispatch("2033964943", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }
}
