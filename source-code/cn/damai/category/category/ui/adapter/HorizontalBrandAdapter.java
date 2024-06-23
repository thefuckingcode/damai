package cn.damai.category.category.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.BrandBean;
import cn.damai.category.category.bean.BrandStatusBean;
import cn.damai.category.category.bean.StarAndBrandItem;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.d20;
import tb.sc;
import tb.xf2;

/* compiled from: Taobao */
public class HorizontalBrandAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private StarAndBrandItem b;
    private List<BrandBean> c = new ArrayList();
    private View.OnClickListener d;
    private View.OnClickListener e;

    /* compiled from: Taobao */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private View a = this.itemView.findViewById(R$id.layout_left);
        private View b = this.itemView.findViewById(R$id.layout_right);
        private DMPosterView c = ((DMPosterView) this.itemView.findViewById(R$id.poster));
        private TextView d = ((TextView) this.itemView.findViewById(R$id.tv_title));
        private TextView e = ((TextView) this.itemView.findViewById(R$id.tv_see_people_num));
        private View f = this.itemView.findViewById(R$id.layout_price);
        private TextView g = ((TextView) this.itemView.findViewById(R$id.tv_price_tag));
        private TextView h = ((TextView) this.itemView.findViewById(R$id.tv_price));
        private TextView i = ((TextView) this.itemView.findViewById(R$id.tv_qi));

        public ViewHolder() {
            super(LayoutInflater.from(HorizontalBrandAdapter.this.a).inflate(R$layout.category_brand_galley_item, (ViewGroup) null));
        }

        public void a(BrandBean brandBean, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1542758198")) {
                ipChange.ipc$dispatch("-1542758198", new Object[]{this, brandBean, Integer.valueOf(i2)});
            } else if (brandBean != null) {
                if (brandBean.position == 0) {
                    this.a.setVisibility(0);
                } else {
                    this.a.setVisibility(8);
                }
                if (i2 >= 6 || brandBean.position != i2 - 1) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setVisibility(0);
                }
                this.c.setImageUrl(brandBean.verticalPic);
                this.c.setVideoIconVisibility(brandBean.isVideoSupport ? 0 : 8);
                this.c.setCategoryTagName(brandBean.getCategoryNameCompat());
                BrandStatusBean brandStatusBean = brandBean.showStatus;
                if (brandStatusBean == null || brandStatusBean.id != 2) {
                    this.c.setLabelType(null);
                } else {
                    this.c.setLabelType(DMLabelType.LABEL_TYPE_SOLD_OUT);
                }
                this.c.setScoreStar(brandBean.itemScore, true);
                this.d.setText(brandBean.name);
                if (!TextUtils.isEmpty(brandBean.showTag)) {
                    this.e.setVisibility(0);
                    this.e.setText(brandBean.showTag);
                } else {
                    this.e.setVisibility(4);
                }
                if (TextUtils.isEmpty(brandBean.priceLow)) {
                    this.h.setTextSize(1, 12.0f);
                    this.g.setVisibility(8);
                    this.i.setVisibility(8);
                    this.h.setText("价格待定");
                } else if (brandBean.priceLow.contains("待定")) {
                    this.h.setTextSize(1, 12.0f);
                    this.g.setVisibility(8);
                    this.i.setVisibility(8);
                    this.h.setText("价格待定");
                } else {
                    this.h.setTextSize(1, 16.0f);
                    this.g.setVisibility(0);
                    this.i.setVisibility(0);
                    this.h.setText(brandBean.priceLow);
                }
                this.itemView.setOnClickListener(HorizontalBrandAdapter.this.d);
            }
        }
    }

    /* compiled from: Taobao */
    class a extends RecyclerView.ViewHolder {

        /* renamed from: cn.damai.category.category.ui.adapter.HorizontalBrandAdapter$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class View$OnClickListenerC0008a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC0008a(HorizontalBrandAdapter horizontalBrandAdapter) {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-151735165")) {
                    ipChange.ipc$dispatch("-151735165", new Object[]{this, view});
                    return;
                }
                HorizontalBrandAdapter.this.e.onClick(view);
            }
        }

        public a() {
            super(LayoutInflater.from(HorizontalBrandAdapter.this.a).inflate(R$layout.category_brand_galley_item_all, (ViewGroup) null));
            this.itemView.setOnClickListener(new View$OnClickListenerC0008a(HorizontalBrandAdapter.this));
        }
    }

    public HorizontalBrandAdapter(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.a = context;
        this.d = onClickListener;
        this.e = onClickListener2;
    }

    public void d(StarAndBrandItem starAndBrandItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "499747187")) {
            ipChange.ipc$dispatch("499747187", new Object[]{this, starAndBrandItem});
        } else if (starAndBrandItem != null && xf2.e(starAndBrandItem.brandList) > 0) {
            this.c = starAndBrandItem.brandList;
            this.b = starAndBrandItem;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271293806")) {
            return ((Integer) ipChange.ipc$dispatch("1271293806", new Object[]{this})).intValue();
        }
        List<BrandBean> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-328860907")) {
            return this.c.get(i).viewType;
        }
        return ((Integer) ipChange.ipc$dispatch("-328860907", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618348747")) {
            ipChange.ipc$dispatch("618348747", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            BrandBean brandBean = this.c.get(i);
            brandBean.position = i;
            int i2 = brandBean.viewType;
            if (i2 == 8) {
                ((ViewHolder) viewHolder).a(brandBean, this.c.size());
                brandBean.cardIndex = this.b.index;
                viewHolder.itemView.setTag(brandBean);
                sc.j(viewHolder.itemView, brandBean.cardIndex, brandBean.position, d20.E(), brandBean.id);
            } else if (i2 == 9) {
                ((a) viewHolder).itemView.setTag(this.b);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723016309")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-723016309", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i == 8) {
            return new ViewHolder();
        } else {
            if (i != 9) {
                return null;
            }
            return new a();
        }
    }
}
