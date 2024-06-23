package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.BrandAndArtists;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.uikit.image.DMImageView;
import cn.damai.uikit.view.DMLRLabelView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cq;
import tb.ln2;
import tb.s71;
import tb.tt1;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class ProjectBrandAndArtistMultiViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private RecyclerView b;
    private MultiAdapter c;

    /* compiled from: Taobao */
    public static class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private List<BrandAndArtists> b;
        private String c;
        private String d;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1424359089")) {
                    ipChange.ipc$dispatch("1424359089", new Object[]{this, view});
                    return;
                }
                BrandAndArtists brandAndArtists = (BrandAndArtists) view.getTag();
                if (brandAndArtists != null) {
                    int i = brandAndArtists.type;
                    if (i == 1) {
                        tt1.j(MultiAdapter.this.a, brandAndArtists, MultiAdapter.this.c, brandAndArtists.index, MultiAdapter.this.d);
                    } else if (i == 2) {
                        tt1.k(MultiAdapter.this.a, brandAndArtists, MultiAdapter.this.c, brandAndArtists.index, MultiAdapter.this.d);
                    }
                }
            }
        }

        public MultiAdapter(Context context) {
            this.a = context;
        }

        private void d(View view, int i, BrandAndArtists brandAndArtists) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-583437595")) {
                ipChange.ipc$dispatch("-583437595", new Object[]{this, view, Integer.valueOf(i), brandAndArtists});
            } else if (brandAndArtists != null) {
                ln2 r = ln2.r();
                String valueOf = String.valueOf(this.c);
                r.o2(view, valueOf, brandAndArtists.type + "", String.valueOf(brandAndArtists.id), i, this.d);
            }
        }

        public void e(List<BrandAndArtists> list, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1501875102")) {
                ipChange.ipc$dispatch("1501875102", new Object[]{this, list, str, str2});
                return;
            }
            this.b = list;
            this.c = str;
            this.d = str2;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1939258784")) {
                return xf2.e(this.b);
            }
            return ((Integer) ipChange.ipc$dispatch("-1939258784", new Object[]{this})).intValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2118228327")) {
                ipChange.ipc$dispatch("-2118228327", new Object[]{this, viewHolder, Integer.valueOf(i)});
                return;
            }
            MultiViewHolder multiViewHolder = (MultiViewHolder) viewHolder;
            BrandAndArtists brandAndArtists = this.b.get(i);
            if (brandAndArtists != null) {
                brandAndArtists.index = i;
                if (i == 0) {
                    multiViewHolder.itemView.setPadding(v50.a(this.a, 12.0f), multiViewHolder.itemView.getPaddingTop(), 0, multiViewHolder.itemView.getPaddingBottom());
                } else if (i == getItemCount() - 1) {
                    View view = multiViewHolder.itemView;
                    view.setPadding(0, view.getPaddingTop(), v50.a(this.a, 12.0f), multiViewHolder.itemView.getPaddingBottom());
                } else {
                    View view2 = multiViewHolder.itemView;
                    view2.setPadding(0, view2.getPaddingTop(), 0, multiViewHolder.itemView.getPaddingBottom());
                }
                multiViewHolder.a(brandAndArtists);
                multiViewHolder.itemView.setTag(brandAndArtists);
                multiViewHolder.itemView.setOnClickListener(new a());
                d(multiViewHolder.itemView, i, brandAndArtists);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1823931523")) {
                return new MultiViewHolder(LayoutInflater.from(this.a).inflate(R$layout.project_item_artist_multi_item_layout, viewGroup, false));
            }
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1823931523", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
    }

    /* compiled from: Taobao */
    public static class MultiViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public Context a;
        public DMImageView b;
        public TextView c;
        public DMLRLabelView d;
        public TextView e;

        public MultiViewHolder(View view) {
            super(view);
            this.a = view.getContext();
            b();
        }

        private void b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1266160979")) {
                ipChange.ipc$dispatch("-1266160979", new Object[]{this});
                return;
            }
            this.b = (DMImageView) this.itemView.findViewById(R$id.iv_artist_image);
            this.c = (TextView) this.itemView.findViewById(R$id.tv_artist_name);
            this.d = (DMLRLabelView) this.itemView.findViewById(R$id.tv_tag);
            this.e = (TextView) this.itemView.findViewById(R$id.tv_artist_desc);
        }

        public void a(BrandAndArtists brandAndArtists) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1581548541")) {
                ipChange.ipc$dispatch("1581548541", new Object[]{this, brandAndArtists});
            } else if (brandAndArtists != null) {
                DMImageCreator c2 = a.b().h(this.a).c(brandAndArtists.picUrl);
                int i = R$drawable.uikit_user_default_icon;
                c2.i(i).c(i).k(new cq()).g(this.b);
                if (!TextUtils.isEmpty(brandAndArtists.name)) {
                    this.c.setText(brandAndArtists.name);
                } else {
                    this.c.setText("");
                }
                if (brandAndArtists.type == 1) {
                    this.d.setColor(1);
                } else {
                    this.d.setColor(2);
                }
                if (!TextUtils.isEmpty(brandAndArtists.tag)) {
                    this.d.setContent("V", brandAndArtists.tag);
                } else {
                    this.d.setContent("V", "");
                    this.d.setVisibility(4);
                }
                if (!TextUtils.isEmpty(brandAndArtists.label)) {
                    this.e.setVisibility(0);
                    this.e.setText(brandAndArtists.label);
                } else if (!TextUtils.isEmpty(brandAndArtists.desc)) {
                    this.e.setText(brandAndArtists.desc);
                    this.e.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                }
            }
        }
    }

    public ProjectBrandAndArtistMultiViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_artist_multi_layout, viewGroup, false));
        this.a = context;
        a();
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-673617404")) {
            ipChange.ipc$dispatch("-673617404", new Object[]{this});
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        linearLayoutManager.setOrientation(0);
        this.c = new MultiAdapter(this.a);
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R$id.iv_artist);
        this.b = recyclerView;
        recyclerView.setLayoutManager(linearLayoutManager);
        this.b.setAdapter(this.c);
    }

    public void b(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920623689")) {
            ipChange.ipc$dispatch("-1920623689", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null && !s71.a(projectDataHolder.brandAndArtistsList)) {
            this.c.e(projectDataHolder.brandAndArtistsList, projectDataHolder.getProjectId(), projectDataHolder.getTheaterValue());
        }
    }
}
