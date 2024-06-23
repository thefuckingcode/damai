package cn.damai.projectfilter.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.projectfilter.bean.CategoryLevelOne;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.n42;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class CategoryMainAdapter extends RecyclerView.Adapter<MainVH> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<CategoryLevelOne> a;
    private Context b;
    private OnCategoryMainListener c;

    /* compiled from: Taobao */
    public class MainVH extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private final TextView a;
        private final TextView b;

        public MainVH(@NonNull View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.id_filter_category_main);
            this.b = (TextView) view.findViewById(R$id.id_filter_category_tag);
        }

        public void a(CategoryLevelOne categoryLevelOne) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "710502393")) {
                ipChange.ipc$dispatch("710502393", new Object[]{this, categoryLevelOne});
                return;
            }
            this.a.setText(categoryLevelOne.name);
            if (TextUtils.isEmpty(categoryLevelOne.tag)) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(0);
                if (xf2.h(categoryLevelOne.tag)) {
                    this.b.setPadding(0, 0, 0, 0);
                } else {
                    int a2 = n42.a(xs0.a(), 4.0f);
                    this.b.setPadding(a2, 0, a2, 0);
                }
                this.b.setText(categoryLevelOne.tag);
            }
            if (categoryLevelOne.select) {
                this.itemView.setBackgroundColor(-1);
                this.a.setTextColor(Color.parseColor("#FF2869"));
            } else {
                this.itemView.setBackgroundColor(0);
                this.a.setTextColor(Color.parseColor("#333333"));
            }
            this.itemView.setTag(categoryLevelOne);
            this.itemView.setOnClickListener(CategoryMainAdapter.this);
        }
    }

    /* compiled from: Taobao */
    public interface OnCategoryMainListener {
        void onSubClick(int i, CategoryLevelOne categoryLevelOne);
    }

    public CategoryMainAdapter(Context context, OnCategoryMainListener onCategoryMainListener) {
        this.b = context;
        this.c = onCategoryMainListener;
    }

    /* renamed from: a */
    public void onBindViewHolder(@NonNull MainVH mainVH, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-631878951")) {
            ipChange.ipc$dispatch("-631878951", new Object[]{this, mainVH, Integer.valueOf(i)});
            return;
        }
        CategoryLevelOne categoryLevelOne = this.a.get(i);
        categoryLevelOne.pos = i;
        mainVH.a(categoryLevelOne);
    }

    @NonNull
    /* renamed from: b */
    public MainVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1594857213")) {
            return new MainVH(LayoutInflater.from(this.b).inflate(R$layout.item_filter_category_new_main, viewGroup, false));
        }
        return (MainVH) ipChange.ipc$dispatch("1594857213", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public void c(List<CategoryLevelOne> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273262020")) {
            ipChange.ipc$dispatch("-1273262020", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698187615")) {
            return ((Integer) ipChange.ipc$dispatch("-1698187615", new Object[]{this})).intValue();
        }
        List<CategoryLevelOne> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913581349")) {
            ipChange.ipc$dispatch("1913581349", new Object[]{this, view});
        } else if ((view.getTag() instanceof CategoryLevelOne) && this.c != null) {
            CategoryLevelOne categoryLevelOne = (CategoryLevelOne) view.getTag();
            if (!categoryLevelOne.select) {
                this.c.onSubClick(categoryLevelOne.pos, categoryLevelOne);
            }
        }
    }
}
