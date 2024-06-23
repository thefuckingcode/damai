package cn.damai.category.ranksquare.ui.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cq;
import tb.n42;
import tb.s71;
import tb.xs0;

/* compiled from: Taobao */
public class HeaderPicListViewHolder extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int IMAGE_MARGIN = 10;
    private final int IMAGE_SCALE = 16;
    private final int MAX = 3;
    private final int ORIGINAL = 0;

    public HeaderPicListViewHolder(Context context) {
        super(context);
    }

    public void setData(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078171263")) {
            ipChange.ipc$dispatch("-2078171263", new Object[]{this, list});
        } else if (!s71.a(list)) {
            removeAllViews();
            for (int i = 3; i >= 0; i--) {
                View inflate = LayoutInflater.from(getContext()).inflate(R$layout.square_header_pic, (ViewGroup) null);
                DMImageCreator f = a.b().h(xs0.a()).f(list.get(i), n42.a(xs0.a(), 16.0f), n42.a(xs0.a(), 16.0f));
                int i2 = R$drawable.uikit_user_default_icon_trans_white;
                f.i(i2).c(i2).k(new cq()).g((ImageView) inflate.findViewById(R$id.image_buy_user));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                if (i > 0) {
                    layoutParams.setMargins(n42.a(getContext(), (float) (i * 10)), 0, 0, 0);
                }
                addView(inflate, layoutParams);
            }
        }
    }

    public HeaderPicListViewHolder(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
