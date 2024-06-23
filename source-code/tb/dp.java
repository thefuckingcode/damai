package tb;

import android.view.View;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder.CreditExchangeInfoViewHolder;
import com.alibaba.pictures.moimage.MoImageView;

/* compiled from: Taobao */
public final /* synthetic */ class dp implements View.OnClickListener {
    public final /* synthetic */ MoImageView a;
    public final /* synthetic */ ProjectMemberPrompt.BannerVO b;

    public /* synthetic */ dp(MoImageView moImageView, ProjectMemberPrompt.BannerVO bannerVO) {
        this.a = moImageView;
        this.b = bannerVO;
    }

    public final void onClick(View view) {
        CreditExchangeInfoViewHolder.e(this.a, this.b, view);
    }
}
