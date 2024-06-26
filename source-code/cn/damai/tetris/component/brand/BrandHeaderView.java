package cn.damai.tetris.component.brand;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.tetris.component.brand.BrandHeaderContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* compiled from: Taobao */
public class BrandHeaderView extends AbsView<BrandHeaderContract.Presenter> implements BrandHeaderContract.View<BrandHeaderContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    AttentionView attentionView;
    View cover;
    TextView desc2;
    ImageView header;
    ImageView imgBg;
    ImageView imgBg1;
    ImageView imgBg2;
    MagicIndicator indicator;
    private Context mContext;
    RecyclerView scrollView;
    View shareBtn;
    TextView subTitle;
    TextView title;
    DmViewPager viewPager;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1990818977")) {
                ipChange.ipc$dispatch("-1990818977", new Object[]{this, view});
            } else if (BrandHeaderView.this.getContext().getActivity() != null) {
                BrandHeaderView.this.getContext().getActivity().finish();
            }
        }
    }

    public BrandHeaderView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.imgBg = (ImageView) view.findViewById(R$id.brand_header_bg);
        this.cover = view.findViewById(R$id.brand_header_bg_cover);
        this.imgBg1 = (ImageView) view.findViewById(R$id.brand_header_bg_1);
        this.imgBg2 = (ImageView) view.findViewById(R$id.brand_header_bg_2);
        this.header = (ImageView) view.findViewById(R$id.brand_header_img);
        this.title = (TextView) view.findViewById(R$id.brand_header_tv_name);
        this.subTitle = (TextView) view.findViewById(R$id.brand_header_tv_fans);
        this.desc2 = (TextView) view.findViewById(R$id.brand_header_tv_desc2);
        this.attentionView = (AttentionView) view.findViewById(R$id.attent_view_brand);
        this.viewPager = (DmViewPager) view.findViewById(R$id.brand_header_viewpager);
        this.indicator = (MagicIndicator) view.findViewById(R$id.brand_header_indicator);
        this.shareBtn = view.findViewById(R$id.brand_header_share);
        this.scrollView = (RecyclerView) view.findViewById(R$id.brand_header_couponview);
        view.findViewById(R$id.brand_header_back).setOnClickListener(new a());
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public AttentionView getAttentionView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1750111697")) {
            return this.attentionView;
        }
        return (AttentionView) ipChange.ipc$dispatch("-1750111697", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public View getCover() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1365748866")) {
            return this.cover;
        }
        return (View) ipChange.ipc$dispatch("1365748866", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public TextView getDesc2() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "865228394")) {
            return this.desc2;
        }
        return (TextView) ipChange.ipc$dispatch("865228394", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public ImageView getHeader() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1041034198")) {
            return this.header;
        }
        return (ImageView) ipChange.ipc$dispatch("-1041034198", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public ImageView getImgBg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1469184127")) {
            return this.imgBg;
        }
        return (ImageView) ipChange.ipc$dispatch("-1469184127", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public ImageView getImgBg1() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-602410650")) {
            return this.imgBg1;
        }
        return (ImageView) ipChange.ipc$dispatch("-602410650", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public ImageView getImgBg2() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "90691047")) {
            return this.imgBg2;
        }
        return (ImageView) ipChange.ipc$dispatch("90691047", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public MagicIndicator getIndicator() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-543107468")) {
            return this.indicator;
        }
        return (MagicIndicator) ipChange.ipc$dispatch("-543107468", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public RecyclerView getRecyclerView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1404200630")) {
            return this.scrollView;
        }
        return (RecyclerView) ipChange.ipc$dispatch("1404200630", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public View getShareBtn() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1163358216")) {
            return this.shareBtn;
        }
        return (View) ipChange.ipc$dispatch("-1163358216", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public TextView getSubTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1570567375")) {
            return this.subTitle;
        }
        return (TextView) ipChange.ipc$dispatch("1570567375", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public TextView getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2019139955")) {
            return this.title;
        }
        return (TextView) ipChange.ipc$dispatch("2019139955", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.View
    public DmViewPager getViewPager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-451885256")) {
            return this.viewPager;
        }
        return (DmViewPager) ipChange.ipc$dispatch("-451885256", new Object[]{this});
    }
}
