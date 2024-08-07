package cn.damai.category.category.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.StarAndBrandItem;
import cn.damai.category.category.bean.StarBean;
import cn.damai.common.image.a;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.DMLRLabelView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cq;
import tb.n42;

/* compiled from: Taobao */
public class StarHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a = this.itemView.getContext();
    private View b = this.itemView.findViewById(R$id.view_xuxian);
    private ImageView c = ((ImageView) this.itemView.findViewById(R$id.image_star));
    private TextView d = ((TextView) this.itemView.findViewById(R$id.tv_name));
    private DMLRLabelView e = ((DMLRLabelView) this.itemView.findViewById(R$id.lrlabel_view));
    private TextView f = ((TextView) this.itemView.findViewById(R$id.tv_btn));
    private TextView g = ((TextView) this.itemView.findViewById(R$id.tv_tip));

    public StarHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.category_star_holder, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void a(StarAndBrandItem starAndBrandItem, int i, View.OnClickListener onClickListener) {
        StarBean starBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1629335730")) {
            ipChange.ipc$dispatch("-1629335730", new Object[]{this, starAndBrandItem, Integer.valueOf(i), onClickListener});
        } else if (starAndBrandItem != null && (starBean = starAndBrandItem.starBean) != null) {
            if (i == 0) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(0);
            }
            ImageView imageView = this.c;
            int i2 = R$drawable.uikit_user_default_icon_trans_white;
            imageView.setImageResource(i2);
            a.b().h(this.a).f(starBean.headPic, n42.a(this.a, 50.0f), n42.a(this.a, 50.0f)).i(i2).c(i2).k(new cq()).g(this.c);
            this.d.setText(starBean.name);
            this.g.setText(starBean.additionDescription);
            this.f.setTag(starAndBrandItem);
            this.e.setContent(starBean.vaccount == 1 ? "V" : null, starBean.subtypes);
            if (starBean.type == 4) {
                this.e.setColor(2);
            } else {
                this.e.setColor(1);
            }
            if (starBean.followStatus == 0) {
                this.f.setText("关注");
                this.f.setOnClickListener(onClickListener);
                this.f.setBackgroundResource(R$drawable.category_star_button_addfollow);
                this.f.setTextColor(this.a.getResources().getColor(R$color.white));
                return;
            }
            this.f.setText("已关注");
            this.f.setOnClickListener(null);
            this.f.setBackgroundResource(R$drawable.category_star_button_follow);
            this.f.setTextColor(this.a.getResources().getColor(R$color.color_999999));
        }
    }
}
