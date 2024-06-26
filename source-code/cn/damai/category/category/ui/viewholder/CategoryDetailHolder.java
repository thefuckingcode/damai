package cn.damai.category.category.ui.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.CategoryEntity;
import cn.damai.category.category.bean.SubCategory;
import cn.damai.category.common.bean.CategoryBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n42;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class CategoryDetailHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a = ((TextView) this.itemView.findViewById(R$id.tv_name));
    private FlowLayout b = ((FlowLayout) this.itemView.findViewById(R$id.layout_sub));
    private Context c;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CategoryBean a;
        final /* synthetic */ SubCategory b;
        final /* synthetic */ int c;
        final /* synthetic */ CategoryEntity d;
        final /* synthetic */ View.OnClickListener e;

        a(CategoryDetailHolder categoryDetailHolder, CategoryBean categoryBean, SubCategory subCategory, int i, CategoryEntity categoryEntity, View.OnClickListener onClickListener) {
            this.a = categoryBean;
            this.b = subCategory;
            this.c = i;
            this.d = categoryEntity;
            this.e = onClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "898944084")) {
                ipChange.ipc$dispatch("898944084", new Object[]{this, view});
                return;
            }
            CategoryEntity categoryEntity = new CategoryEntity();
            CategoryBean categoryBean = this.a;
            categoryEntity.categoryId = categoryBean.id;
            categoryEntity.categoryName = categoryBean.name;
            if ("全部".equals(this.b.name)) {
                categoryEntity.subCategoryId = null;
            } else {
                categoryEntity.subCategoryId = this.b.id;
            }
            SubCategory subCategory = this.b;
            categoryEntity.subName = subCategory.name;
            categoryEntity.subNum = subCategory.count;
            categoryEntity.isSelected = true;
            categoryEntity.index = this.c;
            categoryEntity.subIndex = subCategory.index;
            if (this.d != null && !TextUtils.isEmpty(categoryEntity.subCategoryId) && !TextUtils.isEmpty(this.d.subCategoryId) && categoryEntity.categoryId.equals(this.d.categoryId) && categoryEntity.subCategoryId.equals(this.d.subCategoryId) && this.d.isSelected) {
                categoryEntity.subCategoryId = null;
                categoryEntity.subName = "全部";
            }
            view.setTag(categoryEntity);
            this.e.onClick(view);
        }
    }

    public CategoryDetailHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.category_detali_item, (ViewGroup) null));
        this.c = layoutInflater.getContext();
    }

    private void b(boolean z, View view, TextView textView, TextView textView2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2100555495")) {
            ipChange.ipc$dispatch("-2100555495", new Object[]{this, Boolean.valueOf(z), view, textView, textView2});
        } else if (z) {
            view.setBackgroundResource(R$drawable.category_select_tran01bg);
            Resources resources = this.c.getResources();
            int i = R$color.color_FF2D79;
            textView.setTextColor(resources.getColor(i));
            textView2.setTextColor(this.c.getResources().getColor(i));
        } else {
            view.setBackgroundResource(R$drawable.category_normal_bg);
            textView.setTextColor(this.c.getResources().getColor(R$color.color_000000));
            textView2.setTextColor(this.c.getResources().getColor(R$color.color_999999));
        }
    }

    public void a(int i, CategoryBean categoryBean, CategoryEntity categoryEntity, View.OnClickListener onClickListener) {
        int i2;
        IpChange ipChange = $ipChange;
        int i3 = 3;
        int i4 = 2;
        int i5 = 5;
        if (AndroidInstantRuntime.support(ipChange, "1439040577")) {
            ipChange.ipc$dispatch("1439040577", new Object[]{this, Integer.valueOf(i), categoryBean, categoryEntity, onClickListener});
        } else if (categoryBean != null && xf2.e(categoryBean.subCategories) != 0) {
            this.a.setText(categoryBean.name);
            DisplayMetrics b2 = n42.b(this.c);
            this.b.removeAllViews();
            int i6 = 0;
            while (i6 < categoryBean.subCategories.size()) {
                SubCategory subCategory = categoryBean.subCategories.get(i6);
                subCategory.index = i6;
                if (subCategory.name == null) {
                    i2 = i6;
                } else {
                    View inflate = LayoutInflater.from(this.c).inflate(R$layout.category_detail_item_text, (ViewGroup) null);
                    View findViewById = inflate.findViewById(R$id.tv_layout);
                    if (subCategory.name.length() >= i5) {
                        findViewById.setMinimumWidth((com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b2) - v50.a(this.c, 123.0f)) / i4);
                    } else {
                        findViewById.setMinimumWidth((com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b2) - v50.a(this.c, 129.0f)) / i3);
                    }
                    TextView textView = (TextView) inflate.findViewById(R$id.tv_sub);
                    TextView textView2 = (TextView) inflate.findViewById(R$id.tv_num);
                    textView.setText(subCategory.name);
                    textView2.setText(subCategory.count + "");
                    if (categoryEntity == null) {
                        b(false, findViewById, textView, textView2);
                    } else if (!categoryEntity.categoryId.equals(categoryBean.id) || !categoryEntity.isSelected) {
                        b(false, findViewById, textView, textView2);
                    } else if (!TextUtils.isEmpty(categoryEntity.subCategoryId)) {
                        if (categoryEntity.subCategoryId.equals(subCategory.id)) {
                            b(true, findViewById, textView, textView2);
                        } else {
                            b(false, findViewById, textView, textView2);
                        }
                    } else if ("全部".equals(subCategory.name)) {
                        b(true, findViewById, textView, textView2);
                    } else {
                        b(false, findViewById, textView, textView2);
                    }
                    i2 = i6;
                    findViewById.setOnClickListener(new a(this, categoryBean, subCategory, i, categoryEntity, onClickListener));
                    this.b.addView(inflate);
                }
                i6 = i2 + 1;
                i3 = 3;
                i4 = 2;
                i5 = 5;
            }
        }
    }
}
