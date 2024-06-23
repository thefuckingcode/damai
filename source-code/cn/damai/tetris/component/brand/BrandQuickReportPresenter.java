package cn.damai.tetris.component.brand;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.tetris.component.brand.BrandQuickReportContract;
import cn.damai.tetris.component.brand.bean.BrandQuickReportContentBean;
import cn.damai.tetris.component.ip.bean.ContentInfo;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import tb.d20;
import tb.jl1;
import tb.ob;
import tb.w9;
import tb.za;

/* compiled from: Taobao */
public class BrandQuickReportPresenter extends BasePresenter<BrandQuickReportContract.Model, BrandQuickReportContract.View, BaseSection> implements BrandQuickReportContract.Presenter<BrandQuickReportContract.Model, BrandQuickReportContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String idList;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BrandQuickReportContract.Model a;

        a(BrandQuickReportContract.Model model) {
            this.a = model;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "324316660")) {
                ipChange.ipc$dispatch("324316660", new Object[]{this, view});
                return;
            }
            NavProxy.from(((BasePresenter) BrandQuickReportPresenter.this).mContext.getActivity()).toUri(this.a.getSchema());
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", d20.E());
            if (BrandQuickReportPresenter.this.mTrackInfo != null) {
                BrandQuickReportPresenter brandQuickReportPresenter = BrandQuickReportPresenter.this;
                brandQuickReportPresenter.userTrack(TrackType.click, view, brandQuickReportPresenter.mTrackInfo.trackB, BrandQuickReportPresenter.this.mTrackInfo.trackC, "all", hashMap, true);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ContentInfo a;
        final /* synthetic */ int b;

        b(ContentInfo contentInfo, int i) {
            this.a = contentInfo;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1859360267")) {
                ipChange.ipc$dispatch("-1859360267", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(this.a.schema)) {
                NavProxy.from(((BasePresenter) BrandQuickReportPresenter.this).mContext.getActivity()).toUri(this.a.schema);
                HashMap hashMap = new HashMap();
                hashMap.put("usercode", d20.E());
                hashMap.put(za.CNT_CONTENT_ID, this.a.id);
                if (BrandQuickReportPresenter.this.mTrackInfo != null) {
                    BrandQuickReportPresenter brandQuickReportPresenter = BrandQuickReportPresenter.this;
                    TrackType trackType = TrackType.click;
                    String str = brandQuickReportPresenter.mTrackInfo.trackB;
                    String str2 = BrandQuickReportPresenter.this.mTrackInfo.trackC;
                    brandQuickReportPresenter.userTrack(trackType, view, str, str2, "content_" + this.b, hashMap, true);
                }
            }
        }
    }

    public BrandQuickReportPresenter(BrandQuickReportView brandQuickReportView, String str, w9 w9Var) {
        super(brandQuickReportView, str, w9Var);
    }

    private void imgShow(DMPosterView dMPosterView, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1034312762")) {
            ipChange.ipc$dispatch("1034312762", new Object[]{this, dMPosterView, str, str2});
            return;
        }
        dMPosterView.setPlaceholder(R$drawable.uikit_default_image_bg_gradient);
        dMPosterView.setImageUrl(str);
        dMPosterView.getImageView().setGifRoundCornerSupport(true);
        dMPosterView.getImageView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        if ("2".equals(str2)) {
            dMPosterView.setVideoIconVisibility(0);
        } else {
            dMPosterView.setVideoIconVisibility(8);
        }
    }

    private void ipvuvShow(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1274518553")) {
            ipChange.ipc$dispatch("-1274518553", new Object[]{this, textView, str});
        } else if (!TextUtils.isEmpty(str)) {
            ob.a(textView, str + "人阅读");
        } else {
            ob.a(textView, "");
        }
    }

    private void item(ArrayList<BrandQuickReportContentBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472147961")) {
            ipChange.ipc$dispatch("-472147961", new Object[]{this, arrayList});
            return;
        }
        if (!(this.mContext.getActivity() == null || this.mContext.getActivity().isFinishing() || this.mContext.getActivity().getResources() == null)) {
            if (arrayList.size() == 1) {
                ((BrandQuickReportContract.View) getView()).getSpecialItem().setBackground(this.mContext.getActivity().getResources().getDrawable(R$drawable.brand_card_quickreport_item_allradus_bg));
                ((BrandQuickReportContract.View) getView()).getNormalItemOne().setVisibility(8);
                ((BrandQuickReportContract.View) getView()).getNormalItemTwo().setVisibility(8);
                ((BrandQuickReportContract.View) getView()).getBlackHolder().setVisibility(8);
                this.idList = jl1.ARRAY_START_STR + arrayList.get(0).contentInfo.id + jl1.ARRAY_END_STR;
            } else {
                ((BrandQuickReportContract.View) getView()).getSpecialItem().setBackground(this.mContext.getActivity().getResources().getDrawable(R$drawable.brand_card_quickreport_item_bg));
                ((BrandQuickReportContract.View) getView()).getBlackHolder().setVisibility(0);
                ((BrandQuickReportContract.View) getView()).getNormalItemOne().setVisibility(0);
                if (arrayList.size() == 2) {
                    ((BrandQuickReportContract.View) getView()).getNormalItemTwo().setVisibility(8);
                    this.idList = jl1.ARRAY_START_STR + arrayList.get(0).contentInfo.id + "," + arrayList.get(1).contentInfo.id + jl1.ARRAY_END_STR;
                } else if (arrayList.size() > 2) {
                    ((BrandQuickReportContract.View) getView()).getNormalItemTwo().setVisibility(0);
                    this.idList = jl1.ARRAY_START_STR + arrayList.get(0).contentInfo.id + "," + arrayList.get(1).contentInfo.id + "," + arrayList.get(2).contentInfo.id + jl1.ARRAY_END_STR;
                }
            }
        }
        if (arrayList.get(0) != null) {
            BrandQuickReportContentBean brandQuickReportContentBean = arrayList.get(0);
            imgShow(((BrandQuickReportContract.View) getView()).getSpecialImg(), brandQuickReportContentBean.coverImage, brandQuickReportContentBean.contentTag);
            ((BrandQuickReportContract.View) getView()).getSpecialImg().setVideoIconSize(24.0f, 40.0f, 22.0f);
            ipvuvShow(((BrandQuickReportContract.View) getView()).getSpecialIpvuv(), brandQuickReportContentBean.ipvuv);
            if (brandQuickReportContentBean.contentInfo != null) {
                ob.a(((BrandQuickReportContract.View) getView()).getSpecialTitle(), brandQuickReportContentBean.contentInfo.title);
                onClickJump(((BrandQuickReportContract.View) getView()).getSpecialItem(), brandQuickReportContentBean.contentInfo, 0);
            }
        }
        if (arrayList.size() > 1 && arrayList.get(1) != null) {
            BrandQuickReportContentBean brandQuickReportContentBean2 = arrayList.get(1);
            imgShow(((BrandQuickReportContract.View) getView()).getNormalItemOneImg(), brandQuickReportContentBean2.coverImage, brandQuickReportContentBean2.contentTag);
            ((BrandQuickReportContract.View) getView()).getNormalItemOneImg().setVideoIconSize((float) 14, (float) 31, (float) 21);
            ipvuvShow(((BrandQuickReportContract.View) getView()).getNormalItemOneIpvuv(), brandQuickReportContentBean2.ipvuv);
            if (brandQuickReportContentBean2.contentInfo != null) {
                ob.a(((BrandQuickReportContract.View) getView()).getNormalItemOneTitle(), brandQuickReportContentBean2.contentInfo.title);
                onClickJump(((BrandQuickReportContract.View) getView()).getNormalItemOne(), brandQuickReportContentBean2.contentInfo, 1);
            }
        }
        if (arrayList.size() > 2 && arrayList.get(2) != null) {
            BrandQuickReportContentBean brandQuickReportContentBean3 = arrayList.get(2);
            imgShow(((BrandQuickReportContract.View) getView()).getNormalItemTwoImg(), brandQuickReportContentBean3.coverImage, brandQuickReportContentBean3.contentTag);
            ((BrandQuickReportContract.View) getView()).getNormalItemTwoImg().setVideoIconSize((float) 14, (float) 31, (float) 21);
            ipvuvShow(((BrandQuickReportContract.View) getView()).getNormalItemTwoIpvuv(), brandQuickReportContentBean3.ipvuv);
            if (brandQuickReportContentBean3.contentInfo != null) {
                ob.a(((BrandQuickReportContract.View) getView()).getNormalItemTwoTitle(), brandQuickReportContentBean3.contentInfo.title);
                onClickJump(((BrandQuickReportContract.View) getView()).getNormalItemTwo(), brandQuickReportContentBean3.contentInfo, 2);
            }
        }
    }

    private void onClickJump(RelativeLayout relativeLayout, ContentInfo contentInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-290607960")) {
            ipChange.ipc$dispatch("-290607960", new Object[]{this, relativeLayout, contentInfo, Integer.valueOf(i)});
            return;
        }
        relativeLayout.setOnClickListener(new b(contentInfo, i));
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-558103373")) {
            ipChange.ipc$dispatch("-558103373", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1353412080")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1353412080", new Object[]{this})).booleanValue();
    }

    public void init(BrandQuickReportContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-562335025")) {
            ipChange.ipc$dispatch("-562335025", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        ob.a(((BrandQuickReportContract.View) getView()).getBrandNew(), model.getBrandNew());
        if (!TextUtils.isEmpty(model.getLatestPublishTimeStr())) {
            ((BrandQuickReportContract.View) getView()).getUpdateTimePoint().setVisibility(0);
            TextView updateTime = ((BrandQuickReportContract.View) getView()).getUpdateTime();
            updateTime.setText(model.getLatestPublishTimeStr() + "更新");
        } else {
            ((BrandQuickReportContract.View) getView()).getUpdateTime().setText("");
            ((BrandQuickReportContract.View) getView()).getUpdateTimePoint().setVisibility(8);
        }
        if (!TextUtils.isEmpty(model.getTotal())) {
            try {
                if (Integer.parseInt(model.getTotal()) <= 3 || TextUtils.isEmpty(model.getSchema())) {
                    ((BrandQuickReportContract.View) getView()).getLlMore().setVisibility(8);
                } else {
                    ((BrandQuickReportContract.View) getView()).getLlMore().setVisibility(0);
                    ((BrandQuickReportContract.View) getView()).getLlMore().setOnClickListener(new a(model));
                }
            } catch (Exception unused) {
                ((BrandQuickReportContract.View) getView()).getLlMore().setVisibility(8);
            }
        }
        if (model.getContents() != null && model.getContents().size() > 0) {
            item(model.getContents());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode_m", d20.E());
        hashMap.put(za.CNT_CONTENT_ID, this.idList);
        userTrackExpose(((BrandQuickReportContract.View) getView()).getBrandLayout(), "content", hashMap, false);
    }
}
