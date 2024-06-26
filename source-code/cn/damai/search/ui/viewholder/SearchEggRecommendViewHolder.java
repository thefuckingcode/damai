package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.SearchEggs;
import cn.damai.search.helper.SearchListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class SearchEggRecommendViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int LIMIT_PIC_ITEM_NUM = 4;
    private ImageView a = ((ImageView) this.itemView.findViewById(R$id.iv_recommend_1));
    private ImageView b = ((ImageView) this.itemView.findViewById(R$id.iv_recommend_2));
    private ImageView c = ((ImageView) this.itemView.findViewById(R$id.iv_recommend_3));
    private ImageView d = ((ImageView) this.itemView.findViewById(R$id.iv_recommend_4));
    private View e = this.itemView.findViewById(R$id.container);
    private SearchListener f;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1905578542")) {
                ipChange.ipc$dispatch("-1905578542", new Object[]{this, view});
            } else if (SearchEggRecommendViewHolder.this.f != null) {
                SearchEggRecommendViewHolder.this.f.onSearchEggsRecommendItemClick(view);
            }
        }
    }

    public SearchEggRecommendViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_egg_recommend_list, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    private void c(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705901066")) {
            ipChange.ipc$dispatch("-1705901066", new Object[]{this, str, imageView});
            return;
        }
        DMImageCreator c2 = cn.damai.common.image.a.b().c(str);
        int i = R$drawable.uikit_default_image_bg_gradient;
        c2.i(i).c(i).g(imageView);
    }

    private void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521272315")) {
            ipChange.ipc$dispatch("-521272315", new Object[]{this, view});
        } else if (view != null) {
            view.setOnClickListener(new a());
        }
    }

    public void b(SearchEggs searchEggs) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "700939345")) {
            ipChange.ipc$dispatch("700939345", new Object[]{this, searchEggs});
        } else if (searchEggs == null) {
            this.e.setVisibility(8);
        } else {
            List<SearchEggs.SearchEggHeader> list = searchEggs.header;
            if (list == null || list.size() < 4) {
                this.e.setVisibility(8);
                return;
            }
            this.e.setVisibility(0);
            c(searchEggs.header.get(0).pic, this.a);
            this.a.setTag(searchEggs.header.get(0).url);
            ImageView imageView = this.a;
            int i = R$id.search_eggs_item_index;
            imageView.setTag(i, "0");
            onClick(this.a);
            c(searchEggs.header.get(1).pic, this.b);
            this.b.setTag(searchEggs.header.get(1).url);
            this.b.setTag(i, "1");
            onClick(this.b);
            c(searchEggs.header.get(2).pic, this.c);
            this.c.setTag(searchEggs.header.get(2).url);
            this.c.setTag(i, "2");
            onClick(this.c);
            c(searchEggs.header.get(3).pic, this.d);
            this.d.setTag(searchEggs.header.get(3).url);
            this.d.setTag(i, "3");
            onClick(this.d);
        }
    }

    public void d(SearchListener searchListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199801731")) {
            ipChange.ipc$dispatch("199801731", new Object[]{this, searchListener});
            return;
        }
        this.f = searchListener;
    }
}
