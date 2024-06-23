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
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class SearchEggRecommendViewHolderV2 extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int LIMIT_PIC_ITEM_NUM = 4;
    private ImageView a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private View e;
    private OnEggListener f;
    private List<ImageView> g = new ArrayList();
    private SearchEggs h;

    /* compiled from: Taobao */
    public interface OnEggListener {
        void onImgClick(SearchEggs searchEggs, ImageView imageView, SearchEggs.SearchEggHeader searchEggHeader, int i);

        void onImgExpose(ImageView imageView, SearchEggs.SearchEggHeader searchEggHeader, int i);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;
        final /* synthetic */ SearchEggs.SearchEggHeader b;
        final /* synthetic */ int c;

        a(ImageView imageView, SearchEggs.SearchEggHeader searchEggHeader, int i) {
            this.a = imageView;
            this.b = searchEggHeader;
            this.c = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-327755090")) {
                ipChange.ipc$dispatch("-327755090", new Object[]{this, view});
            } else if (SearchEggRecommendViewHolderV2.this.f != null) {
                SearchEggRecommendViewHolderV2.this.f.onImgClick(SearchEggRecommendViewHolderV2.this.h, this.a, this.b, this.c);
            }
        }
    }

    public SearchEggRecommendViewHolderV2(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_egg_recommend_list, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.e = this.itemView.findViewById(R$id.container);
        this.a = (ImageView) this.itemView.findViewById(R$id.iv_recommend_1);
        this.b = (ImageView) this.itemView.findViewById(R$id.iv_recommend_2);
        this.c = (ImageView) this.itemView.findViewById(R$id.iv_recommend_3);
        this.d = (ImageView) this.itemView.findViewById(R$id.iv_recommend_4);
        this.g.add(this.a);
        this.g.add(this.b);
        this.g.add(this.c);
        this.g.add(this.d);
    }

    private void c(ImageView imageView, SearchEggs.SearchEggHeader searchEggHeader, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193673242")) {
            ipChange.ipc$dispatch("193673242", new Object[]{this, imageView, searchEggHeader, Integer.valueOf(i)});
        } else if (imageView != null && searchEggHeader != null) {
            e(searchEggHeader.pic, imageView);
            OnEggListener onEggListener = this.f;
            if (onEggListener != null) {
                onEggListener.onImgExpose(imageView, searchEggHeader, i);
            }
            imageView.setOnClickListener(new a(imageView, searchEggHeader, i));
        }
    }

    private void e(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027317658")) {
            ipChange.ipc$dispatch("1027317658", new Object[]{this, str, imageView});
            return;
        }
        DMImageCreator c2 = cn.damai.common.image.a.b().c(str);
        int i = R$drawable.uikit_default_image_bg_gradient;
        c2.i(i).c(i).g(imageView);
    }

    public void d(SearchEggs searchEggs) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1858665461")) {
            ipChange.ipc$dispatch("1858665461", new Object[]{this, searchEggs});
            return;
        }
        this.h = searchEggs;
        if (searchEggs == null) {
            this.e.setVisibility(8);
            return;
        }
        List<SearchEggs.SearchEggHeader> list = searchEggs.header;
        if (list == null || list.size() < 4) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        List<SearchEggs.SearchEggHeader> list2 = searchEggs.header;
        for (int i = 0; i < 4; i++) {
            try {
                c(this.g.get(i), list2.get(i), i);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    public void f(OnEggListener onEggListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548084386")) {
            ipChange.ipc$dispatch("1548084386", new Object[]{this, onEggListener});
            return;
        }
        this.f = onEggListener;
    }
}
