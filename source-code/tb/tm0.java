package tb;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.discover.main.bean.FollowPeopleBean;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class tm0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private View b;
    private RoundImageView c;
    private RoundImageView d;
    private TextView e;

    public tm0(View view) {
        this.a = view;
        view.getContext();
        this.b = view.findViewById(R$id.layout_image);
        this.c = (RoundImageView) view.findViewById(R$id.image_head1);
        this.d = (RoundImageView) view.findViewById(R$id.image_head2);
        this.e = (TextView) view.findViewById(R$id.tv_desc);
    }

    public View a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1670569641")) {
            return this.a;
        }
        return (View) ipChange.ipc$dispatch("-1670569641", new Object[]{this});
    }

    public void b(FollowPeopleBean followPeopleBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1000693487")) {
            ipChange.ipc$dispatch("1000693487", new Object[]{this, followPeopleBean});
            return;
        }
        if (followPeopleBean == null) {
            this.a.setVisibility(8);
        }
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        if (!u80.g(followPeopleBean.userDataList)) {
            this.b.setVisibility(0);
            if (followPeopleBean.userDataList.size() >= 1) {
                this.c.setVisibility(0);
                DMImageCreator e2 = a.b().e(followPeopleBean.userDataList.get(0).headImg);
                int i = R$drawable.live_common_round_image_default;
                e2.c(i).g(this.c);
                if (followPeopleBean.userDataList.size() >= 2) {
                    this.d.setVisibility(0);
                    a.b().e(followPeopleBean.userDataList.get(1).headImg).c(i).g(this.d);
                }
            }
        }
        if (!TextUtils.isEmpty(followPeopleBean.focusUserText)) {
            this.e.setVisibility(0);
            this.e.setText(followPeopleBean.focusUserText);
            return;
        }
        this.e.setVisibility(8);
    }
}
