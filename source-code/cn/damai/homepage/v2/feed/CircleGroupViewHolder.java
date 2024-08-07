package cn.damai.homepage.v2.feed;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.image.a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.discover.bean.CircleCard;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.AvatarRecyclerView;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.f92;
import tb.gr;
import tb.gw0;
import tb.v50;

/* compiled from: Taobao */
public class CircleGroupViewHolder extends BaseViewHolder<CircleCard> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public CircleGroupViewHolder(View view) {
        super(view);
    }

    private List<AvatarRecyclerView.AvatarItem> toAvatarList(List<String> list, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1112483676")) {
            return (List) ipChange.ipc$dispatch("1112483676", new Object[]{this, list, Integer.valueOf(i)});
        } else if (f92.d(list)) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                arrayList.add(new AvatarRecyclerView.b(str));
                i2++;
                if (i2 >= i) {
                    break;
                }
            }
            if (arrayList.size() > 0) {
                Collections.reverse(arrayList);
            }
            return arrayList;
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1369258720")) {
            ipChange.ipc$dispatch("-1369258720", new Object[]{this, iItem});
        } else if (!TextUtils.isEmpty(((CircleCard) getValue()).name)) {
            this.itemView.setOnClickListener(this);
            TextView textView = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_circle_title);
            textView.setText(((CircleCard) getValue()).name);
            textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, textView.getPaint().getTextSize() * ((float) textView.getText().length()), 0.0f, Color.parseColor("#FF6785"), Color.parseColor("#FFB57B"), Shader.TileMode.CLAMP));
            if (!TextUtils.isEmpty(((CircleCard) getValue()).title)) {
                ((TextView) this.itemView.findViewById(R$id.homepage_waterflow_circle_title_subtitle)).setText(((CircleCard) getValue()).title);
            }
            if (!TextUtils.isEmpty(((CircleCard) getValue()).subTitle)) {
                ((TextView) this.itemView.findViewById(R$id.homepage_waterflow_circle_title_fansnum)).setText(((CircleCard) getValue()).subTitle);
            }
            if (!f92.d(((CircleCard) getValue()).headImgList)) {
                AvatarRecyclerView avatarRecyclerView = (AvatarRecyclerView) this.itemView.findViewById(R$id.homepage_waterflow_circle_avatar_view);
                avatarRecyclerView.setHeight(14);
                avatarRecyclerView.getAdapter().e(toAvatarList(((CircleCard) getValue()).headImgList, 3));
            }
            if (!f92.d(((CircleCard) getValue()).contentImgList)) {
                LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_circle_ll);
                linearLayout.removeAllViews();
                int i = 0;
                for (String str : ((CircleCard) getValue()).contentImgList) {
                    View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.circle_card_img_item, (ViewGroup) linearLayout, false);
                    linearLayout.addView(inflate);
                    inflate.setOnClickListener(this);
                    int a = v50.a(this.itemView.getContext(), 3.0f);
                    int a2 = i == 0 ? v50.a(this.itemView.getContext(), 9.0f) : 0;
                    int i2 = R$id.circle_card_img_item_img;
                    ((FrameLayout.LayoutParams) inflate.findViewById(i2).getLayoutParams()).setMargins(a2, 0, a, 0);
                    a.b().c(str).g((ImageView) inflate.findViewById(i2));
                    i++;
                }
            }
            if (!TextUtils.isEmpty(((CircleCard) getValue()).backgroundImg)) {
                a.b().c(((CircleCard) getValue()).backgroundImg).g((ImageView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_image));
            }
            gw0.i().k(gw0.g(getComponentActions()), this.itemView, "", "", "", "13", ((CircleCard) getValue()).id, iItem.getIndex());
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262665770")) {
            ipChange.ipc$dispatch("262665770", new Object[]{this, view});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("themeId", String.valueOf(((CircleCard) getValue()).id));
        DMNav.from(this.context).withExtras(bundle).toUri(NavUri.b(gr.DISCOVER_CIRCLE_THEME_PAGE));
        gw0.i().m(gw0.g(getComponentActions()), "", "", "", "13", ((CircleCard) getValue()).id, getData().getIndex());
    }
}
