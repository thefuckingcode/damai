package cn.damai.tetris.component.online.mvp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.online.bean.ArtistItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cq;
import tb.n42;
import tb.s71;
import tb.xs0;

/* compiled from: Taobao */
public class HeadPicListView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    public HeadPicListView(Context context) {
        super(context);
    }

    public void setData(List<ArtistItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "71672004")) {
            ipChange.ipc$dispatch("71672004", new Object[]{this, list});
        } else if (!s71.a(list)) {
            removeAllViews();
            for (int size = list.size() - 1; size >= 0; size--) {
                ArtistItemBean artistItemBean = list.get(size);
                if (artistItemBean != null && !TextUtils.isEmpty(artistItemBean.artistAvatar)) {
                    View inflate = LayoutInflater.from(getContext()).inflate(R$layout.online_headpic, (ViewGroup) null);
                    ImageView imageView = (ImageView) inflate.findViewById(R$id.image_quan);
                    DMImageCreator f = a.b().h(xs0.a()).f(artistItemBean.artistAvatar, n42.a(xs0.a(), 30.0f), n42.a(xs0.a(), 30.0f));
                    int i = R$drawable.uikit_user_default_icon_trans_white;
                    f.i(i).c(i).k(new cq()).g((ImageView) inflate.findViewById(R$id.image_buy_user));
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    if (size > 0) {
                        layoutParams.setMargins(n42.a(getContext(), (float) (size * 25)), 0, 0, 0);
                    }
                    addView(inflate, layoutParams);
                }
            }
        }
    }

    public HeadPicListView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
