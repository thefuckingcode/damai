package cn.damai.tetris.component.brand;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.brand.BrandIpContract;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.view.round.RoundImageView2;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BrandIpView extends AbsView<BrandIpContract.Presenter> implements BrandIpContract.View<BrandIpContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    View dynNews;
    ViewFlipper flipper;
    ImageView header;
    RoundImageView2 imgBg;
    ViewGroup line2;
    ViewGroup line3;
    private Context mContext;
    TextView subTitle;
    TextView title;

    public BrandIpView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.line2 = (ViewGroup) view.findViewById(R$id.ip_brand_card_line2);
        this.line3 = (ViewGroup) view.findViewById(R$id.ip_brand_card_line3);
        this.title = (TextView) view.findViewById(R$id.ip_brand_card_name);
        this.subTitle = (TextView) view.findViewById(R$id.ip_brand_card_desc);
        this.header = (ImageView) view.findViewById(R$id.ip_brand_card_img);
        this.imgBg = (RoundImageView2) view.findViewById(R$id.brandip_top_imgbg);
        this.flipper = (ViewFlipper) view.findViewById(R$id.ip_brand_card_dynnews_flipper);
        this.dynNews = view.findViewById(R$id.ip_brand_card_dynnews_card);
    }

    @Override // cn.damai.tetris.component.brand.BrandIpContract.View
    public ViewGroup get2ItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-63067954")) {
            return this.line3;
        }
        return (ViewGroup) ipChange.ipc$dispatch("-63067954", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandIpContract.View
    public ViewGroup get3ItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1662412943")) {
            return this.line2;
        }
        return (ViewGroup) ipChange.ipc$dispatch("1662412943", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandIpContract.View
    public View getDynNews() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1589939207")) {
            return this.dynNews;
        }
        return (View) ipChange.ipc$dispatch("1589939207", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandIpContract.View
    public ViewFlipper getFlipper() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1840074076")) {
            return this.flipper;
        }
        return (ViewFlipper) ipChange.ipc$dispatch("-1840074076", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandIpContract.View
    public ImageView getHeader() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1447711428")) {
            return this.header;
        }
        return (ImageView) ipChange.ipc$dispatch("1447711428", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandIpContract.View
    public RoundImageView2 getImgBg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2137181149")) {
            return this.imgBg;
        }
        return (RoundImageView2) ipChange.ipc$dispatch("2137181149", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandIpContract.View
    public TextView getSubTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1412270453")) {
            return this.subTitle;
        }
        return (TextView) ipChange.ipc$dispatch("1412270453", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandIpContract.View
    public TextView getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-20726131")) {
            return this.title;
        }
        return (TextView) ipChange.ipc$dispatch("-20726131", new Object[]{this});
    }
}
