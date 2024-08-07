package cn.damai.tetris.component.brand;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.brand.BrandQuickReportContract;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.rr;
import tb.v50;

/* compiled from: Taobao */
public class BrandQuickReportView extends AbsView<BrandQuickReportContract.Presenter> implements BrandQuickReportContract.View<BrandQuickReportContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    View blackHolder;
    RelativeLayout brandLayout;
    TextView brandNew;
    LinearLayout itemLayout;
    FrameLayout itemShadow;
    LinearLayout llMore;
    private Context mContext;
    RelativeLayout normalItemOne;
    DMPosterView normalItemOneImg;
    TextView normalItemOneIpvuv;
    TextView normalItemOneTitle;
    RelativeLayout normalItemTwo;
    DMPosterView normalItemTwoImg;
    TextView normalItemTwoIpvuv;
    TextView normalItemTwoTitle;
    DMPosterView specialImg;
    TextView specialIpvuv;
    RelativeLayout specialItem;
    TextView specialTitle;
    TextView updateTime;
    TextView updateTimePoint;

    public BrandQuickReportView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.brandLayout = (RelativeLayout) view.findViewById(R$id.brand_quickreport_layout);
        this.itemLayout = (LinearLayout) view.findViewById(R$id.brand_quickreport_item_layout);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.brand_quickreport_item_layout_fr_shadow);
        this.itemShadow = frameLayout;
        rr.b(frameLayout, Color.parseColor("#00000000"), v50.a(this.mContext, 10.0f), Color.parseColor("#1A6A7A99"), v50.a(this.mContext, 10.0f), v50.a(this.mContext, 10.0f), v50.a(this.mContext, 10.0f));
        this.brandNew = (TextView) view.findViewById(R$id.brand_quickreport_title);
        this.updateTime = (TextView) view.findViewById(R$id.brand_quickreport_update_time);
        this.updateTimePoint = (TextView) view.findViewById(R$id.brand_quickreport_update_time_point);
        this.llMore = (LinearLayout) view.findViewById(R$id.brand_ll_quickreport_more);
        this.specialItem = (RelativeLayout) view.findViewById(R$id.brand_quickreport_special);
        this.specialImg = (DMPosterView) view.findViewById(R$id.brand_quickreport_special_img);
        this.specialTitle = (TextView) view.findViewById(R$id.brand_quickreport_tv_special_title);
        this.specialIpvuv = (TextView) view.findViewById(R$id.brand_quickreport_tv_special_ipuv);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.card_brand_normal_item_one);
        this.normalItemOne = relativeLayout;
        int i = R$id.brand_quickreport_normal_img;
        this.normalItemOneImg = (DMPosterView) relativeLayout.findViewById(i);
        RelativeLayout relativeLayout2 = this.normalItemOne;
        int i2 = R$id.brand_quickreport_tv_normal_title;
        this.normalItemOneTitle = (TextView) relativeLayout2.findViewById(i2);
        RelativeLayout relativeLayout3 = this.normalItemOne;
        int i3 = R$id.brand_quickreport_tv_normal_ipuv;
        this.normalItemOneIpvuv = (TextView) relativeLayout3.findViewById(i3);
        RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R$id.card_brand_normal_item_two);
        this.normalItemTwo = relativeLayout4;
        this.normalItemTwoImg = (DMPosterView) relativeLayout4.findViewById(i);
        this.normalItemTwoTitle = (TextView) this.normalItemTwo.findViewById(i2);
        this.normalItemTwoIpvuv = (TextView) this.normalItemTwo.findViewById(i3);
        this.blackHolder = view.findViewById(R$id.card_brand_normal_item_black_holder);
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public View getBlackHolder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1473754838")) {
            return this.blackHolder;
        }
        return (View) ipChange.ipc$dispatch("1473754838", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public RelativeLayout getBrandLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1948232866")) {
            return this.brandLayout;
        }
        return (RelativeLayout) ipChange.ipc$dispatch("-1948232866", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getBrandNew() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1560147046")) {
            return this.brandNew;
        }
        return (TextView) ipChange.ipc$dispatch("1560147046", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public LinearLayout getLlMore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1065024019")) {
            return this.llMore;
        }
        return (LinearLayout) ipChange.ipc$dispatch("-1065024019", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public RelativeLayout getNormalItemOne() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "670857827")) {
            return this.normalItemOne;
        }
        return (RelativeLayout) ipChange.ipc$dispatch("670857827", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public DMPosterView getNormalItemOneImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1225757940")) {
            return this.normalItemOneImg;
        }
        return (DMPosterView) ipChange.ipc$dispatch("1225757940", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getNormalItemOneIpvuv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2030948453")) {
            return this.normalItemOneIpvuv;
        }
        return (TextView) ipChange.ipc$dispatch("-2030948453", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getNormalItemOneTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1537054547")) {
            return this.normalItemOneTitle;
        }
        return (TextView) ipChange.ipc$dispatch("1537054547", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public RelativeLayout getNormalItemTwo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1846868797")) {
            return this.normalItemTwo;
        }
        return (RelativeLayout) ipChange.ipc$dispatch("1846868797", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public DMPosterView getNormalItemTwoImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-959018418")) {
            return this.normalItemTwoImg;
        }
        return (DMPosterView) ipChange.ipc$dispatch("-959018418", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getNormalItemTwoIpvuv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1715917951")) {
            return this.normalItemTwoIpvuv;
        }
        return (TextView) ipChange.ipc$dispatch("-1715917951", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getNormalItemTwoTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1852085049")) {
            return this.normalItemTwoTitle;
        }
        return (TextView) ipChange.ipc$dispatch("1852085049", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public DMPosterView getSpecialImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1098871161")) {
            return this.specialImg;
        }
        return (DMPosterView) ipChange.ipc$dispatch("-1098871161", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getSpecialIpvuv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1309112984")) {
            return this.specialIpvuv;
        }
        return (TextView) ipChange.ipc$dispatch("-1309112984", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public RelativeLayout getSpecialItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1588313885")) {
            return this.specialItem;
        }
        return (RelativeLayout) ipChange.ipc$dispatch("-1588313885", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getSpecialTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2036077280")) {
            return this.specialTitle;
        }
        return (TextView) ipChange.ipc$dispatch("-2036077280", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getUpdateTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2086234583")) {
            return this.updateTime;
        }
        return (TextView) ipChange.ipc$dispatch("-2086234583", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getUpdateTimePoint() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1035194425")) {
            return this.updateTimePoint;
        }
        return (TextView) ipChange.ipc$dispatch("1035194425", new Object[]{this});
    }
}
