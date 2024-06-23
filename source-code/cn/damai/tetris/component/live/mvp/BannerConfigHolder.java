package cn.damai.tetris.component.live.mvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.live.bean.LiveHeaderCardItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BannerConfigHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a = this.itemView.findViewById(R$id.layout_left);
    private View b = this.itemView.findViewById(R$id.layout_right);
    private ImageView c = ((ImageView) this.itemView.findViewById(R$id.image_view));
    private TextView d = ((TextView) this.itemView.findViewById(R$id.tv_title));

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BannerPresenter a;
        final /* synthetic */ int b;

        a(BannerConfigHolder bannerConfigHolder, BannerPresenter bannerPresenter, int i) {
            this.a = bannerPresenter;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1066007885")) {
                ipChange.ipc$dispatch("-1066007885", new Object[]{this, view});
                return;
            }
            LiveHeaderCardItemBean liveHeaderCardItemBean = (LiveHeaderCardItemBean) view.getTag();
            BannerPresenter bannerPresenter = this.a;
            if (bannerPresenter != null) {
                bannerPresenter.itemClick(liveHeaderCardItemBean, this.b);
            }
        }
    }

    public BannerConfigHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.live_banner_config_item, (ViewGroup) null));
        layoutInflater.getContext();
    }

    public void a(int i, int i2, LiveHeaderCardItemBean liveHeaderCardItemBean, BannerPresenter bannerPresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-464490845")) {
            ipChange.ipc$dispatch("-464490845", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), liveHeaderCardItemBean, bannerPresenter});
        } else if (liveHeaderCardItemBean != null) {
            if (i == 0) {
                this.a.setVisibility(0);
            } else {
                this.a.setVisibility(8);
            }
            if (i == i2 - 1) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
            cn.damai.uikit.image.a.a().loadinto(liveHeaderCardItemBean.pic, this.c);
            this.d.setText(liveHeaderCardItemBean.name);
            this.itemView.setOnClickListener(new a(this, bannerPresenter, i));
        }
    }
}
