package cn.damai.tetris.component.brand;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.scriptmurder.coupon.CouponDetailFragment;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.tetris.component.brand.BrandIpContract;
import cn.damai.tetris.component.brand.bean.IpBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.ScoreStarViewV2;
import cn.damai.uikit.view.round.RoundImageView2;
import cn.damai.user.userprofile.FeedsViewModel;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import tb.gr;
import tb.ob;
import tb.v50;
import tb.w9;

/* compiled from: Taobao */
public class BrandIpPresenter extends BasePresenter<BrandIpContract.Model, BrandIpContract.View, BaseSection> implements BrandIpContract.Presenter<BrandIpContract.Model, BrandIpContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    AttentionView attentionView;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(BrandIpPresenter brandIpPresenter) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1475354764")) {
                ipChange.ipc$dispatch("-1475354764", new Object[]{this, dVar});
                return;
            }
            Log.e("BrandIpPresenter", "DMImageCreator.FailEvent: " + dVar.a);
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements DMRGBUtil.OnFetchColorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
            public void onFetchColor(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-973584436")) {
                    ipChange.ipc$dispatch("-973584436", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                int i2 = DMRGBUtil.i(i);
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, DMRGBUtil.c(i2));
                ((RoundImageView2) ((BrandIpContract.View) BrandIpPresenter.this.getView()).getRootView().findViewById(R$id.brandip_top_imgbg_cover)).setImageDrawable(new ColorDrawable(i2));
                ((RoundImageView2) ((BrandIpContract.View) BrandIpPresenter.this.getView()).getRootView().findViewById(R$id.brandip_top_imgbg_bottomshadow)).setImageDrawable(gradientDrawable);
            }
        }

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1226610167")) {
                ipChange.ipc$dispatch("-1226610167", new Object[]{this, eVar});
            } else if (eVar != null && (bitmap = eVar.b) != null) {
                DMRGBUtil.g(1.0f, bitmap, ((BrandIpContract.Model) BrandIpPresenter.this.getModel()).getBrandInfo().backgroundPic, new a());
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HashMap a;

        c(HashMap hashMap) {
            this.a = hashMap;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-887492284")) {
                ipChange.ipc$dispatch("-887492284", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(FeedsViewModel.ARG_USERID, ((BrandIpContract.Model) BrandIpPresenter.this.getModel()).getBrandInfo().activityDO.targetId);
            bundle.putString(CouponDetailFragment.COUPON_ID, ((BrandIpContract.Model) BrandIpPresenter.this.getModel()).getBrandInfo().activityDO.couponId);
            bundle.putString("usertype", "4");
            bundle.putBoolean("followLottery", true);
            DMNav.from(((BasePresenter) BrandIpPresenter.this).mContext.getActivity()).forResult(1).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
            BrandIpPresenter.this.userTrackClick("coupon_btn", this.a, true);
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HashMap a;

        d(HashMap hashMap) {
            this.a = hashMap;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1223798085")) {
                ipChange.ipc$dispatch("1223798085", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(FeedsViewModel.ARG_USERID, ((BrandIpContract.Model) BrandIpPresenter.this.getModel()).getBrandInfo().id);
            bundle.putString("usertype", "4");
            DMNav.from(((BasePresenter) BrandIpPresenter.this).mContext.getActivity()).forResult(1).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
            BrandIpPresenter.this.userTrackClick("card", this.a, true);
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IpBean a;
        final /* synthetic */ int b;

        e(IpBean ipBean, int i) {
            this.a = ipBean;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-959878842")) {
                ipChange.ipc$dispatch("-959878842", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("id", this.a.id);
            DMNav.from(((BasePresenter) BrandIpPresenter.this).mContext.getActivity()).withExtras(bundle).toUri(NavUri.b("ipdrama"));
            BrandIpPresenter brandIpPresenter = BrandIpPresenter.this;
            brandIpPresenter.userTrackClick("repertoire_item_" + this.b, true);
        }
    }

    public BrandIpPresenter(BrandIpView brandIpView, String str, w9 w9Var) {
        super(brandIpView, str, w9Var);
    }

    private void bindItem(IpBean ipBean, ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1926412024")) {
            ipChange.ipc$dispatch("1926412024", new Object[]{this, ipBean, viewGroup, Integer.valueOf(i)});
            return;
        }
        ((DMPosterView) viewGroup.findViewById(R$id.brandip_top_item_image)).setImageUrl(ipBean.pic);
        ob.a((TextView) viewGroup.findViewById(R$id.brandip_top_item_title), ipBean.subTitle);
        ob.a((TextView) viewGroup.findViewById(R$id.brandip_top_item_desc), ipBean.briefIntroduction);
        if (ipBean.getItemScoreFloat() > 0.0f) {
            int i2 = R$id.brandip_grade_star;
            viewGroup.findViewById(i2).setVisibility(0);
            ((ScoreStarViewV2) viewGroup.findViewById(i2)).updateView((double) ipBean.getItemScoreFloat());
            ob.a((TextView) viewGroup.findViewById(R$id.brandip_grade_score), ipBean.getItemScoreFloat() + "");
        } else {
            viewGroup.findViewById(R$id.brandip_grade_star).setVisibility(8);
            if (ipBean.ipvuv < 10000) {
                ((TextView) viewGroup.findViewById(R$id.brandip_grade_score)).setText("人气飙升");
            } else {
                ((TextView) viewGroup.findViewById(R$id.brandip_grade_score)).setText(getFansDesc((long) ipBean.ipvuv, "人想看"));
            }
        }
        viewGroup.setOnClickListener(new e(ipBean, i));
        HashMap hashMap = new HashMap();
        if (!(getModel() == null || ((BrandIpContract.Model) getModel()).getTrackInfo() == null)) {
            hashMap.putAll(((BrandIpContract.Model) getModel()).getTrackInfo().getArgsMap());
        }
        hashMap.put("cur_repertoire_id", ipBean.id);
        userTrackExpose(viewGroup, "repertoire_item_" + i, hashMap, false);
    }

    private void bindItems(ArrayList<IpBean> arrayList, int[] iArr) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1412207029")) {
            ipChange.ipc$dispatch("1412207029", new Object[]{this, arrayList, iArr});
            return;
        }
        while (i < iArr.length && i < 3) {
            IpBean ipBean = arrayList.get(i);
            ViewGroup viewGroup = (ViewGroup) ((BrandIpContract.View) getView()).getRootView().findViewById(iArr[i]);
            if (viewGroup != null) {
                bindItem(ipBean, viewGroup, i);
                if (iArr.length == 3) {
                    int i2 = R$id.brandip_top_item_image;
                    ViewGroup.LayoutParams layoutParams = viewGroup.findViewById(i2).getLayoutParams();
                    int a2 = (DisplayMetrics.getwidthPixels(v50.b(this.mContext.getActivity())) - v50.a(this.mContext.getActivity(), 126.0f)) / 3;
                    layoutParams.width = a2;
                    layoutParams.height = (a2 / 3) * 4;
                    viewGroup.findViewById(i2).setLayoutParams(layoutParams);
                }
            }
            i++;
        }
    }

    public static int getColorAlpha(float f, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "746906027")) {
            return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
        }
        return ((Integer) ipChange.ipc$dispatch("746906027", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue();
    }

    public static String getFansNum(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-256437530")) {
            return (String) ipChange.ipc$dispatch("-256437530", new Object[]{Long.valueOf(j), str});
        } else if (j < 10000) {
            try {
                return j + str;
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        } else {
            return (((float) (j / 1000)) / 10.0f) + "万" + str;
        }
    }

    private void showAttention() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1903480517")) {
            ipChange.ipc$dispatch("1903480517", new Object[]{this});
            return;
        }
        this.attentionView.setVisibility(0);
        ((BrandIpContract.View) getView()).getRootView().findViewById(R$id.brandip_top_imgbg_4).setVisibility(8);
        ((BrandIpContract.View) getView()).getHeader().setVisibility(0);
    }

    private void showBorder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58037595")) {
            ipChange.ipc$dispatch("58037595", new Object[]{this});
            return;
        }
        View view = (View) ((BrandIpContract.View) getView()).getDynNews().getParent();
        if (view != null) {
            view.setBackground(this.mContext.getActivity().getResources().getDrawable(R$drawable.bg_border_nocorner_0_3border));
        }
    }

    private void showGetGiftAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-569913108")) {
            ipChange.ipc$dispatch("-569913108", new Object[]{this});
            return;
        }
        ((BrandIpContract.View) getView()).getHeader().setVisibility(8);
        this.attentionView.setVisibility(8);
        ((BrandIpContract.View) getView()).getRootView().findViewById(R$id.brandip_top_imgbg_4).setVisibility(0);
    }

    public SpannableString getFansDesc(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1612412727")) {
            return (SpannableString) ipChange.ipc$dispatch("-1612412727", new Object[]{this, Long.valueOf(j), str});
        }
        try {
            String fansNum = getFansNum(j, str);
            SpannableString spannableString = new SpannableString(fansNum);
            spannableString.setSpan(new ForegroundColorSpan(this.mContext.getActivity().getResources().getColor(R$color.color_FF993A)), 0, fansNum.indexOf(str), 17);
            return spannableString;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new SpannableString("");
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697525759")) {
            ipChange.ipc$dispatch("-1697525759", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 10241 && this.attentionView != null && obj != null && (obj instanceof Bundle) && ((BrandIpContract.Model) getModel()).getBrandInfo() != null && ((BrandIpContract.Model) getModel()).getBrandInfo().followStatus != null) {
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("brandId");
            String string2 = bundle.getString("followState");
            if (!TextUtils.isEmpty(string) && string.equals(((BrandIpContract.Model) getModel()).getBrandInfo().id)) {
                try {
                    this.attentionView.setState(Integer.parseInt(string2));
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                if (((BrandIpContract.Model) getModel()).getBrandInfo().activityDO == null || !((BrandIpContract.Model) getModel()).getBrandInfo().activityDO.isValid() || this.attentionView.followed()) {
                    showAttention();
                } else {
                    showGetGiftAnim();
                }
            }
        }
    }

    public void init(BrandIpContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360747459")) {
            ipChange.ipc$dispatch("-1360747459", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        TextView textView = (TextView) ((BrandIpContract.View) getView()).getRootView().findViewById(R$id.ip_brand_title);
        if (!(textView == null || ((BrandIpContract.Model) getModel()).getStyleInfo() == null || TextUtils.isEmpty(((BrandIpContract.Model) getModel()).getStyleInfo().getString("title")))) {
            textView.setText(((BrandIpContract.Model) getModel()).getStyleInfo().getString("title"));
        }
        if (((BrandIpContract.Model) getModel()).getBeanList() == null || ((BrandIpContract.Model) getModel()).getBeanList().size() < 2) {
            ((BrandIpContract.View) getView()).get2ItemView().setVisibility(8);
            ((BrandIpContract.View) getView()).get3ItemView().setVisibility(8);
            ((BrandIpContract.View) getView()).getRootView().findViewById(R$id.brandip_top_imgbg_4).setVisibility(0);
        } else if (((BrandIpContract.Model) getModel()).getBeanList().size() == 2) {
            ((BrandIpContract.View) getView()).get2ItemView().setVisibility(0);
            ((BrandIpContract.View) getView()).get3ItemView().setVisibility(8);
            bindItems(((BrandIpContract.Model) getModel()).getBeanList(), new int[]{R$id.ip_brand_card_item1, R$id.ip_brand_card_item2});
            showBorder();
        } else if (((BrandIpContract.Model) getModel()).getBeanList().size() >= 3) {
            ((BrandIpContract.View) getView()).get2ItemView().setVisibility(8);
            ((BrandIpContract.View) getView()).get3ItemView().setVisibility(0);
            bindItems(((BrandIpContract.Model) getModel()).getBeanList(), new int[]{R$id.mine_brand_project_1, R$id.mine_brand_project_2, R$id.mine_brand_project_3});
            showBorder();
        }
        if (((BrandIpContract.Model) getModel()).getBrandInfo() != null) {
            cn.damai.uikit.image.a.a().loadinto(((BrandIpContract.Model) getModel()).getBrandInfo().pic, ((BrandIpContract.View) getView()).getHeader());
            ob.a(((BrandIpContract.View) getView()).getTitle(), ((BrandIpContract.Model) getModel()).getBrandInfo().name);
            ob.a(((BrandIpContract.View) getView()).getSubTitle(), ((BrandIpContract.Model) getModel()).getBrandInfo().subTitle);
            HashMap hashMap = new HashMap();
            if (!(getModel() == null || ((BrandIpContract.Model) getModel()).getTrackInfo() == null)) {
                hashMap.putAll(((BrandIpContract.Model) getModel()).getTrackInfo().getArgsMap());
            }
            hashMap.put("brand_id", ((BrandIpContract.Model) getModel()).getBrandInfo().id);
            if (((BrandIpContract.Model) getModel()).getBrandInfo().activityDO != null) {
                hashMap.put("coupon_id", ((BrandIpContract.Model) getModel()).getBrandInfo().activityDO.couponId);
            }
            hashMap.put("status", ((BrandIpContract.Model) getModel()).getBrandInfo().followStatus);
            userTrackExpose(((BrandIpContract.View) getView()).getTitle(), "card", hashMap, true);
            cn.damai.common.image.a.b().c(((BrandIpContract.Model) getModel()).getBrandInfo().backgroundPic).n(new b()).e(new a(this)).f();
            AttentionView attentionView2 = (AttentionView) ((BrandIpContract.View) getView()).getRootView().findViewById(R$id.attent_view_ipbrand);
            this.attentionView = attentionView2;
            attentionView2.setCancelFollow(false);
            if (((BrandIpContract.Model) getModel()).getTrackInfo() != null) {
                this.attentionView.setPage(((BrandIpContract.Model) getModel()).getTrackInfo().trackB);
                this.attentionView.setPageBdian(((BrandIpContract.Model) getModel()).getTrackInfo().trackB);
                this.attentionView.setModule(((BrandIpContract.Model) getModel()).getTrackInfo().trackC);
                this.attentionView.setArgsMap(hashMap);
            }
            if (!TextUtils.isEmpty(((BrandIpContract.Model) getModel()).getBrandInfo().followStatus)) {
                try {
                    this.attentionView.setState(Integer.parseInt(((BrandIpContract.Model) getModel()).getBrandInfo().followStatus));
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            this.attentionView.setInitParams(((BrandIpContract.Model) getModel()).getBrandInfo().id, "4");
            if (((BrandIpContract.Model) getModel()).getBrandInfo().activityDO == null || !((BrandIpContract.Model) getModel()).getBrandInfo().activityDO.isValid()) {
                showAttention();
            } else {
                View rootView = ((BrandIpContract.View) getView()).getRootView();
                int i = R$id.brandip_top_imgbg_4;
                if (rootView.findViewById(i) != null) {
                    showGetGiftAnim();
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ((BrandIpContract.View) getView()).getRootView().findViewById(i);
                    lottieAnimationView.setImageAssetsFolder("coupon/images/");
                    lottieAnimationView.setAnimation("coupon/getcoupon.json");
                    lottieAnimationView.playAnimation();
                    userTrackExpose(lottieAnimationView, "coupon_btn");
                    ((BrandIpContract.View) getView()).getRootView().findViewById(R$id.attent_view_ipbrand).setVisibility(8);
                    ((BrandIpContract.View) getView()).getHeader().setVisibility(8);
                    ((RelativeLayout.LayoutParams) ((BrandIpContract.View) getView()).getTitle().getLayoutParams()).setMargins(v50.a(this.mContext.getActivity(), 12.0f), v50.a(this.mContext.getActivity(), 11.0f), 0, 0);
                    ((RelativeLayout.LayoutParams) ((BrandIpContract.View) getView()).getSubTitle().getLayoutParams()).setMargins(v50.a(this.mContext.getActivity(), 12.0f), v50.a(this.mContext.getActivity(), 3.0f), 0, 0);
                    lottieAnimationView.setOnClickListener(new c(hashMap));
                }
            }
            ((BrandIpContract.View) getView()).getRootView().findViewById(R$id.ip_brand_card_line1).setOnClickListener(new d(hashMap));
        }
    }
}
