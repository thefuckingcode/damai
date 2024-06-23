package cn.damai.tetris.component.ip;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.net.mtop.netfit.DMMtopResultBaseData;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$raw;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.h5container.DamaiWebView;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.ip.IpInfoContract;
import cn.damai.tetris.component.ip.bean.IPInfoBean;
import cn.damai.tetris.component.ip.bean.IpTags;
import cn.damai.tetris.component.ip.mtop.PraiseRequest;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.msg.Message;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.DMThemeDialog;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.MsgID;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tb.d20;
import tb.gr;
import tb.hb2;
import tb.ln2;
import tb.ob;
import tb.p21;
import tb.rr1;
import tb.s50;
import tb.v50;
import tb.w9;
import tb.za;

/* compiled from: Taobao */
public class IpInfoPresenter extends BasePresenter<IpInfoContract.Model, IpInfoContract.View, BaseSection> implements IpInfoContract.Presenter<IpInfoContract.Model, IpInfoContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String followStateKey = "IpInfoPresenter_follow_stateKey_";
    ArrayList<String> initPraIds = new ArrayList<>();
    hb2 likedStack = new hb2(3);
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    public class FollowClick implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        IPInfoBean a;

        public FollowClick(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        public void onClick(final View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "14222673")) {
                ipChange.ipc$dispatch("14222673", new Object[]{this, view});
                return;
            }
            IpInfoPresenter.this.userTrackClick("favorite", false);
            FollowRequest followRequest = new FollowRequest();
            StringBuilder sb = new StringBuilder();
            sb.append(view.getTag());
            sb.append("");
            followRequest.operateType = "true".equals(sb.toString()) ? "0" : "1";
            followRequest.targetId = this.a.getId();
            followRequest.targetType = "5";
            followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
                /* class cn.damai.tetris.component.ip.IpInfoPresenter.FollowClick.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "796201092")) {
                        ipChange.ipc$dispatch("796201092", new Object[]{this, str, str2});
                        return;
                    }
                    view.setClickable(true);
                }

                public void onSuccess(FollowDataBean followDataBean) {
                    IpChange ipChange = $ipChange;
                    boolean z = false;
                    if (AndroidInstantRuntime.support(ipChange, "-1655979044")) {
                        ipChange.ipc$dispatch("-1655979044", new Object[]{this, followDataBean});
                        return;
                    }
                    view.setClickable(true);
                    if (followDataBean.getStatus() != 0) {
                        z = true;
                    }
                    view.setTag(Boolean.valueOf(z));
                    IpInfoPresenter.this.sendMsg(new Message(MsgID.MEDIA_INFO_VIDEO_START_RECOVER, new Pair("5", Pair.create(Integer.valueOf(followDataBean.getStatus()), FollowClick.this.a.getId()))));
                    IpInfoPresenter.this.updateWannaSeeUi(z, true);
                }
            });
            view.setClickable(false);
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;

        a(IpInfoPresenter ipInfoPresenter, PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-532441990")) {
                ipChange.ipc$dispatch("-532441990", new Object[]{this, view});
                return;
            }
            this.a.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        private int a(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1605550603")) {
                return ((Integer) ipChange.ipc$dispatch("1605550603", new Object[]{this, view})).intValue();
            }
            IpTags ipTags = (IpTags) view.getTag();
            int like = ipTags.getLike();
            view.setTag(ipTags);
            return like;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1578848379")) {
                ipChange.ipc$dispatch("1578848379", new Object[]{this, view});
            } else if (a(view) == 1) {
                IpInfoPresenter.this.grayTag(view);
                IpInfoPresenter.this.likedStack.b();
            } else {
                IpInfoPresenter.this.hightLightTag(view);
                View view2 = (View) IpInfoPresenter.this.likedStack.c(view);
                if (view2 != null) {
                    IpInfoPresenter.this.grayTag(view2);
                    a(view2);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;

        c(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-957977269")) {
                ipChange.ipc$dispatch("-957977269", new Object[]{this, view});
                return;
            }
            DMNav.from(((BasePresenter) IpInfoPresenter.this).mContext.getActivity()).toUri(this.a.getGuidelines());
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;

        d(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1153313100")) {
                ipChange.ipc$dispatch("1153313100", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("pic_info", (Serializable) this.a.getVerticalPicList());
            IpInfoPresenter.this.userTrackClick("poster", true);
            NavProxy.from(((BasePresenter) IpInfoPresenter.this).mContext.getActivity()).withExtras(bundle).toUri(INavUri.page("image_gallery"));
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;

        e(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1030363827")) {
                ipChange.ipc$dispatch("-1030363827", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(p21.ISSUE_PARAM_IPID, this.a.getId());
            NavProxy.from(((BasePresenter) IpInfoPresenter.this).mContext.getActivity()).withExtras(bundle).toUri(INavUri.page(gr.W));
            IpInfoPresenter.this.userTrackClick(ln2.PROJECT_EVALUATE, true);
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;
        final /* synthetic */ TextView b;

        f(IPInfoBean iPInfoBean, TextView textView) {
            this.a = iPInfoBean;
            this.b = textView;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1080926542")) {
                ipChange.ipc$dispatch("1080926542", new Object[]{this, view});
                return;
            }
            IpInfoPresenter.this.userTrackClick("seen", false);
            if (!LoginManager.k().q()) {
                DMNav.from(((BasePresenter) IpInfoPresenter.this).mContext.getActivity()).forResult(100).toUri(NavUri.b("login"));
            } else if (this.a.getIpTags() == null || this.a.getIpTags().size() == 0) {
                boolean booleanValue = ((Boolean) view.getTag()).booleanValue();
                if (!booleanValue) {
                    d20.T(IpInfoPresenter.this.followStateKey + this.a.getId(), !booleanValue ? "1" : "0");
                    view.setTag(Boolean.valueOf(!booleanValue));
                    IpInfoPresenter.this.updateHaveSeenText(this.b, !booleanValue);
                }
            } else {
                IpInfoPresenter.this.showTagsPopwindow(this.a, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;

        g(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1102750385")) {
                ipChange.ipc$dispatch("-1102750385", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(RankListFragment.KEY_RANK_ID, this.a.getRank().id);
            NavProxy.from(IpInfoPresenter.this.getContext().getActivity()).withExtras(bundle).toHost("ranking");
            HashMap hashMap = new HashMap();
            hashMap.put(za.PRE_CONTENT_ID, this.a.getRank().id);
            hashMap.put(za.PRE_CONTENT_TYPE, "randlist");
            if (IpInfoPresenter.this.mTrackInfo.getArgsMap() != null) {
                hashMap.putAll(IpInfoPresenter.this.mTrackInfo.getArgsMap());
            }
            IpInfoPresenter.this.userTrackClick("repertoire_ranklist", hashMap, true);
        }
    }

    /* compiled from: Taobao */
    public class h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;

        /* compiled from: Taobao */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a(h hVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "632561266")) {
                    ipChange.ipc$dispatch("632561266", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
            }
        }

        h(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1008539984")) {
                ipChange.ipc$dispatch("1008539984", new Object[]{this, view});
                return;
            }
            DMThemeDialog dMThemeDialog = new DMThemeDialog(IpInfoPresenter.this.getContext().getActivity());
            dMThemeDialog.r(DMThemeDialog.DMDialogTheme.THEME_GUARD_SUCCESS);
            dMThemeDialog.k(this.a.ipvuvDescription).i("知道了", new a(this)).g(false, null);
            dMThemeDialog.show();
        }
    }

    /* compiled from: Taobao */
    public class i implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;

        i(IpInfoPresenter ipInfoPresenter, PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1175136943")) {
                ipChange.ipc$dispatch("-1175136943", new Object[]{this, view});
                return;
            }
            this.a.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class j implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;

        j(IpInfoPresenter ipInfoPresenter, PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "936153426")) {
                ipChange.ipc$dispatch("936153426", new Object[]{this, view});
                return;
            }
            this.a.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class k implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;

        k(IpInfoPresenter ipInfoPresenter, PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1247523501")) {
                ipChange.ipc$dispatch("-1247523501", new Object[]{this, view});
                return;
            }
            this.a.dismiss();
        }
    }

    public IpInfoPresenter(IpInfoView ipInfoView, String str, w9 w9Var) {
        super(ipInfoView, str, w9Var);
    }

    private void bindItem(View view, IpTags ipTags) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1535589856")) {
            ipChange.ipc$dispatch("-1535589856", new Object[]{this, view, ipTags});
            return;
        }
        ob.a((TextView) view.findViewById(R$id.tv_ipinfo_tagleft), ipTags.getTagName());
        if (ipTags.getTagCount() > 100) {
            ob.a((TextView) view.findViewById(R$id.tv_ipinfo_tagright), ipTags.getTagCount() + "");
            return;
        }
        view.findViewById(R$id.tv_ipinfo_tagright).setVisibility(8);
    }

    private void bindPopTagItem(View view, IPInfoBean iPInfoBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319437919")) {
            ipChange.ipc$dispatch("1319437919", new Object[]{this, view, iPInfoBean, Integer.valueOf(i2)});
        } else if (i2 >= iPInfoBean.getIpTags().size() || iPInfoBean.getIpTags().get(i2) == null) {
            view.setVisibility(4);
        } else {
            bindSinglePopTagItem(view, iPInfoBean.getIpTags().get(i2));
        }
    }

    private void bindSinglePopTagItem(View view, IpTags ipTags) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877635121")) {
            ipChange.ipc$dispatch("1877635121", new Object[]{this, view, ipTags});
            return;
        }
        ob.a((TextView) view.findViewById(R$id.ip_tags_tag_title), ipTags.getTagName());
        if (ipTags.getTagCount() > 100) {
            ob.a((TextView) view.findViewById(R$id.ip_tags_tag_count), ipTags.getTagCount() + "");
            view.findViewById(R$id.ip_tags_tag_zan).setVisibility(0);
        } else {
            view.findViewById(R$id.ip_tags_tag_count).setVisibility(8);
            view.findViewById(R$id.ip_tags_tag_zan).setVisibility(8);
        }
        if (ipTags.getLike() == 1) {
            hightLightTag(view);
            this.likedStack.c(view);
            this.initPraIds.add(ipTags.getTagId());
        } else {
            grayTag(view);
        }
        view.setTag(ipTags);
        view.setOnClickListener(new b());
    }

    public static String getFansNum(long j2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1080330577")) {
            return (String) ipChange.ipc$dispatch("-1080330577", new Object[]{Long.valueOf(j2), str});
        } else if (j2 < 10000) {
            try {
                return j2 + str;
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        } else {
            return (((float) (j2 / 1000)) / 10.0f) + "万" + str;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void grayTag(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "260252300")) {
            ipChange.ipc$dispatch("260252300", new Object[]{this, view});
            return;
        }
        Resources resources = getContext().getActivity().getResources();
        int i2 = R$color.color_9C9CA5;
        ((TextView) view.findViewById(R$id.ip_tags_tag_count)).setTextColor(resources.getColor(i2));
        ((TextView) view.findViewById(R$id.ip_tags_tag_zan)).setTextColor(getContext().getActivity().getResources().getColor(R$color.color_3c3f44));
        ((TextView) view.findViewById(R$id.ip_tags_tag_title)).setTextColor(getContext().getActivity().getResources().getColor(i2));
        view.findViewById(R$id.ip_tags_tag_bg).setBackground(getContext().getActivity().getResources().getDrawable(R$drawable.bg_border_corner_15_0_r15));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hightLightTag(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170314005")) {
            ipChange.ipc$dispatch("-1170314005", new Object[]{this, view});
            return;
        }
        Resources resources = getContext().getActivity().getResources();
        int i2 = R$color.color_FF9200;
        ((TextView) view.findViewById(R$id.ip_tags_tag_count)).setTextColor(resources.getColor(i2));
        ((TextView) view.findViewById(R$id.ip_tags_tag_zan)).setTextColor(getContext().getActivity().getResources().getColor(i2));
        ((TextView) view.findViewById(R$id.ip_tags_tag_title)).setTextColor(getContext().getActivity().getResources().getColor(R$color.black));
        view.findViewById(R$id.ip_tags_tag_bg).setBackground(getContext().getActivity().getResources().getDrawable(R$drawable.bg_border_corner_0_r15));
    }

    private void setScore(IPInfoBean iPInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264484893")) {
            ipChange.ipc$dispatch("-1264484893", new Object[]{this, iPInfoBean});
            return;
        }
        TextView ipScore = ((IpInfoContract.View) getView()).getIpScore();
        ob.a(ipScore, iPInfoBean.getItemScore() + "");
        ob.a(((IpInfoContract.View) getView()).getIpScoreDesc(), iPInfoBean.getScoreDesc());
        ((IpInfoContract.View) getView()).getRatingBar().updateView((double) iPInfoBean.getItemScoreFloat());
        if (iPInfoBean.getContent() != null) {
            ob.a(((IpInfoContract.View) getView()).getUserComment(), iPInfoBean.getContent().getContent());
            cn.damai.uikit.image.a.a().loadinto(iPInfoBean.getContent().getHeadImg(), ((IpInfoContract.View) getView()).getUserImg());
        }
    }

    private void setTags(IPInfoBean iPInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462353592")) {
            ipChange.ipc$dispatch("-1462353592", new Object[]{this, iPInfoBean});
        } else if (iPInfoBean.getIpTags() != null) {
            LinearLayout linearLayout = (LinearLayout) ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_tags_parent);
            linearLayout.removeAllViews();
            for (int i2 = 0; i2 < iPInfoBean.getIpTags().size(); i2++) {
                View inflate = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_videoinfo_ip_tag, (ViewGroup) linearLayout, false);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                layoutParams.setMargins(0, 0, s50.a(this.mContext.getActivity(), 3.0f), 0);
                linearLayout.addView(inflate, layoutParams);
                bindItem(inflate, iPInfoBean.getIpTags().get(i2));
                userTrackExpose(inflate, "tag_" + i2);
            }
        }
    }

    private void showPopwindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1947614873")) {
            ipChange.ipc$dispatch("1947614873", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_popup_ip_scoretip, (ViewGroup) null);
        PopupWindow c2 = new rr1(inflate, s50.a(this.mContext.getActivity(), 287.0f)).g(this.mContext.getActivity()).c();
        inflate.setOnClickListener(new i(this, c2));
        inflate.findViewById(R$id.ip_tour_top_close).setOnClickListener(new j(this, c2));
        ((DamaiWebView) inflate.findViewById(R$id.mWebView)).loadUrl("https://m.damai.cn");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showTagsPopwindow(final IPInfoBean iPInfoBean, final TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "986271180")) {
            ipChange.ipc$dispatch("986271180", new Object[]{this, iPInfoBean, textView});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_popup_ip_tags, (ViewGroup) null);
        int a2 = s50.a(this.mContext.getActivity(), 42.0f);
        int size = iPInfoBean.getIpTags().size();
        this.initPraIds.clear();
        this.likedStack = new hb2(3);
        for (int i2 = 0; i2 < size; i2++) {
            View inflate2 = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_popup_ip_tag, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a2);
            bindPopTagItem(inflate2, iPInfoBean, i2);
            ((FlowLayout) inflate.findViewById(R$id.ip_tags_scroll_content)).addView(inflate2, layoutParams);
        }
        rr1 g2 = new rr1(inflate, (((size / 2) + 1) * a2) + s50.a(this.mContext.getActivity(), 149.0f)).g(this.mContext.getActivity());
        final PopupWindow c2 = g2.c();
        int f2 = g2.f();
        int i3 = R$id.sub_content;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) inflate.findViewById(i3).getLayoutParams();
        layoutParams2.height = f2;
        inflate.findViewById(i3).setLayoutParams(layoutParams2);
        inflate.setOnClickListener(new k(this, c2));
        inflate.findViewById(R$id.ip_tags_bottombar).setOnClickListener(new View.OnClickListener() {
            /* class cn.damai.tetris.component.ip.IpInfoPresenter.AnonymousClass10 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(final View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1651234937")) {
                    ipChange.ipc$dispatch("1651234937", new Object[]{this, view});
                } else if (IpInfoPresenter.this.likedStack.a() == null) {
                    ToastUtil.a().e(((BasePresenter) IpInfoPresenter.this).mContext.getActivity(), "请至少选择一个标签哦");
                } else {
                    c2.dismiss();
                    final PraiseRequest praiseRequest = new PraiseRequest();
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        View view2 = (View) IpInfoPresenter.this.likedStack.b();
                        if (view2 == null) {
                            break;
                        }
                        IpTags ipTags = (IpTags) view2.getTag();
                        if (ipTags != null) {
                            Log.d("likedStack", "praise tag : " + ipTags.getTagName());
                            praiseRequest.praiseTargetIdList.add(ipTags.getTagId());
                            stringBuffer.append(ipTags.getTagName());
                            stringBuffer.append("&");
                        }
                    }
                    if (IpInfoPresenter.this.mTrackInfo != null && !TextUtils.isEmpty(stringBuffer.toString())) {
                        IpInfoPresenter.this.mTrackInfo.put("titlelabel", (Object) stringBuffer.toString());
                    }
                    IpInfoPresenter.this.userTrackClick("finish", false);
                    Iterator<String> it = IpInfoPresenter.this.initPraIds.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!praiseRequest.praiseTargetIdList.contains(next)) {
                            Log.d("likedStack", "un praise tag : " + next);
                            praiseRequest.cancleTargetIdList.add(next);
                        }
                    }
                    praiseRequest.targetType = "3";
                    praiseRequest.request(new DMMtopRequestListener<DMMtopResultBaseData>(DMMtopResultBaseData.class) {
                        /* class cn.damai.tetris.component.ip.IpInfoPresenter.AnonymousClass10.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                        public void onFail(String str, String str2) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1581749844")) {
                                ipChange.ipc$dispatch("-1581749844", new Object[]{this, str, str2});
                                return;
                            }
                            view.setClickable(true);
                        }

                        public void onSuccess(DMMtopResultBaseData dMMtopResultBaseData) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1496781176")) {
                                ipChange.ipc$dispatch("-1496781176", new Object[]{this, dMMtopResultBaseData});
                                return;
                            }
                            view.setClickable(true);
                            AnonymousClass10 r6 = AnonymousClass10.this;
                            iPInfoBean.like = true;
                            IpInfoPresenter.this.updateHaveSeenText(textView, true);
                            for (IpTags ipTags : iPInfoBean.getIpTags()) {
                                if (praiseRequest.praiseTargetIdList.contains(ipTags.getTagId())) {
                                    ipTags.setLike(1);
                                } else if (praiseRequest.cancleTargetIdList.contains(ipTags.getTagId())) {
                                    ipTags.setLike(0);
                                }
                            }
                        }
                    });
                    view.setClickable(false);
                }
            }
        });
        inflate.findViewById(R$id.ip_tags_top_close).setOnClickListener(new a(this, c2));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateHaveSeenText(TextView textView, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2093215228")) {
            ipChange.ipc$dispatch("-2093215228", new Object[]{this, textView, Boolean.valueOf(z)});
            return;
        }
        int i2 = -16777216;
        textView.setTextColor(z ? Color.parseColor("#ff993a") : -16777216);
        textView.setText(getContext().getActivity().getResources().getString(z ? R$string.iconfont_pingfenmian_ : R$string.iconfont_pingfen_));
        View haveSeen = ((IpInfoContract.View) getView()).getHaveSeen();
        int i3 = R$id.ipinfo_showinfo_haveseen_text;
        TextView textView2 = (TextView) haveSeen.findViewById(i3);
        if (z) {
            i2 = Color.parseColor("#9c9ca5");
        }
        textView2.setTextColor(i2);
        ob.a((TextView) ((IpInfoContract.View) getView()).getHaveSeen().findViewById(i3), z ? "已看过" : "看过");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private void updateWannaSeeUi(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "794528276")) {
            ipChange.ipc$dispatch("794528276", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        ((IpInfoContract.View) getView()).getWannaSee().setTag(Boolean.valueOf(z));
        ((IpInfoContract.Model) getModel()).getIpInfo().setFocus(z);
        TextView textView = (TextView) ((IpInfoContract.View) getView()).getWannaSee().findViewById(R$id.ipinfo_showinfo_wannasee_text);
        textView.setText(z ? "已想看" : "想看");
        textView.setTextColor(z ? Color.parseColor("#9c9ca5") : -16777216);
        int i2 = z ? R$raw.lottie_favourite_click : R$raw.lottie_favorite_cancel;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ((IpInfoContract.View) getView()).getWannaSee().findViewById(R$id.ipinfo_showinfo_wannasee_icon);
        lottieAnimationView.setAnimation(i2);
        lottieAnimationView.invalidate();
        lottieAnimationView.setProgress(0.0f);
        if (z2) {
            lottieAnimationView.playAnimation();
        } else {
            lottieAnimationView.setProgress(1.0f);
        }
    }

    public SpannableString getFansDesc(long j2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067209632")) {
            return (SpannableString) ipChange.ipc$dispatch("1067209632", new Object[]{this, Long.valueOf(j2), str});
        }
        try {
            String fansNum = getFansNum(j2, str);
            SpannableString spannableString = new SpannableString(fansNum);
            spannableString.setSpan(new ForegroundColorSpan(this.mContext.getActivity().getResources().getColor(R$color.color_FF993A)), 0, fansNum.indexOf(str), 17);
            return spannableString;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new SpannableString("");
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1840397302")) {
            ipChange.ipc$dispatch("-1840397302", new Object[]{this, Integer.valueOf(i2), obj});
            return;
        }
        Log.e("msggsg", "i: " + i2 + " , o : " + obj);
        if (i2 == 10240 && (obj instanceof Pair)) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            if ((obj2 instanceof String) && "5".equals(obj2)) {
                Object obj3 = pair.second;
                if (obj3 instanceof Pair) {
                    Pair pair2 = (Pair) obj3;
                    if (getModel() != null && ((IpInfoContract.Model) getModel()).getIpInfo() != null && ((IpInfoContract.Model) getModel()).getIpInfo().getId().equals(pair2.second)) {
                        String str = ((IpInfoContract.Model) getModel()).getIpInfo().getFocus() ? "1" : "0";
                        if (!str.equals(pair2.first + "")) {
                            updateWannaSeeUi("1".equals(pair2.first + ""), false);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x057f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x05a9  */
    public void init(IpInfoContract.Model model) {
        boolean z;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-1186225059")) {
            ipChange.ipc$dispatch("-1186225059", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        if (((IpInfoContract.Model) getModel()).getIpInfo() != null) {
            IPInfoBean ipInfo = ((IpInfoContract.Model) getModel()).getIpInfo();
            ob.a(((IpInfoContract.View) getView()).getIpName(), ipInfo.getIpName());
            if (((IpInfoContract.View) getView()).getIpName() != null) {
                TextPaint paint = ((IpInfoContract.View) getView()).getIpName().getPaint();
                while (paint != null && paint.measureText(ipInfo.getIpName()) > ((float) v50.a(this.mContext.getActivity(), 200.0f)) && paint.getTextSize() > ((float) v50.a(this.mContext.getActivity(), 10.0f))) {
                    paint.setTextSize(paint.getTextSize() - 2.0f);
                }
            }
            ob.a(((IpInfoContract.View) getView()).getIpDesc(), ipInfo.getCategory());
            if (ipInfo.getIpvuv() > 0) {
                ((IpInfoContract.View) getView()).getIpUv().setVisibility(0);
                ((IpInfoContract.View) getView()).getIpUv().setText(getFansDesc(ipInfo.getIpvuv(), "人想看"));
            } else {
                ((IpInfoContract.View) getView()).getIpUv().setVisibility(4);
            }
            ((IpInfoContract.View) getView()).getScoreTip().setOnClickListener(new c(ipInfo));
            if (ipInfo.getVerticalPicList() == null || ipInfo.getVerticalPicList().size() <= 0) {
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.brand_ablum_tip).setVisibility(4);
            } else {
                cn.damai.uikit.image.a.a().loadinto(ipInfo.getVerticalPicList().get(0), ((IpInfoContract.View) getView()).getIpImg());
                ((IpInfoContract.View) getView()).getIpImg().setOnClickListener(new d(ipInfo));
                if (ipInfo.getVerticalPicList().size() > 1) {
                    ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.brand_ablum_tip).setVisibility(0);
                    ob.a((TextView) ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.brand_ablum_pcount), ipInfo.getVerticalPicList().size() + "");
                } else {
                    ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.brand_ablum_tip).setVisibility(4);
                }
            }
            ViewFlipper viewFlipper = (ViewFlipper) ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_descinfo);
            viewFlipper.removeAllViews();
            if (ipInfo.getAwardsList() != null) {
                for (String str : ipInfo.getAwardsList()) {
                    View inflate = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_videoinfo_ip_awardsitem, (ViewGroup) viewFlipper, false);
                    ob.a((TextView) inflate.findViewById(R$id.brand_header_desc_tag), str);
                    viewFlipper.addView(inflate);
                }
                if (ipInfo.getAwardsList().size() > 1) {
                    viewFlipper.setFlipInterval(3000);
                    viewFlipper.startFlipping();
                }
                viewFlipper.setVisibility(0);
                userTrackExpose(viewFlipper, "awards");
            } else {
                viewFlipper.setVisibility(8);
            }
            View rootView = ((IpInfoContract.View) getView()).getRootView();
            int i2 = R$id.ipinfo_score;
            rootView.findViewById(i2).setVisibility(0);
            if (ipInfo.getItemScoreFloat() == 0.0f && ipInfo.getIpTags() != null) {
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_value_root).setVisibility(8);
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_tags_div).setVisibility(8);
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_tags).setVisibility(0);
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_title_icon).setVisibility(8);
                setTags(ipInfo);
                ((ImageView) ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_titleimg)).setImageResource(R$drawable.dm_ip_score_highlight);
            } else if (ipInfo.getItemScoreFloat() > 0.0f && (ipInfo.getIpTags() == null || ipInfo.getIpTags().size() == 0)) {
                View rootView2 = ((IpInfoContract.View) getView()).getRootView();
                int i3 = R$id.ipinfo_score_value_root;
                rootView2.findViewById(i3).setVisibility(0);
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_tags_div).setVisibility(8);
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_tags).setVisibility(8);
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_title_icon).setVisibility(0);
                setScore(ipInfo);
                ((ImageView) ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_titleimg)).setImageResource(R$drawable.dm_ip_score_title);
                userTrackExpose(((IpInfoContract.View) getView()).getRootView().findViewById(i3), ln2.PROJECT_EVALUATE);
            } else if (ipInfo.getItemScoreFloat() == 0.0f && (ipInfo.getIpTags() == null || ipInfo.getIpTags().size() == 0)) {
                ((IpInfoContract.View) getView()).getRootView().findViewById(i2).setVisibility(8);
                z = false;
                ((IpInfoContract.View) getView()).getUserComment().setOnClickListener(new e(ipInfo));
                if (((IpInfoContract.View) getView()).getWannaSee().getTag() != null) {
                    ipInfo.focus = "true".equals(((IpInfoContract.View) getView()).getWannaSee().getTag() + "");
                }
                updateWannaSeeUi(ipInfo.focus, false);
                ((IpInfoContract.View) getView()).getWannaSee().setOnClickListener(new FollowClick(ipInfo));
                TextView textView = (TextView) ((IpInfoContract.View) getView()).getHaveSeen().findViewById(R$id.ipinfo_showinfo_haveseen_icon);
                boolean z3 = ipInfo.like;
                if (ipInfo.getIpTags() == null || ipInfo.getIpTags().size() == 0) {
                    z3 = "1".equals(d20.B(this.followStateKey + ipInfo.getId()));
                }
                updateHaveSeenText(textView, z3);
                ((IpInfoContract.View) getView()).getHaveSeen().setTag(Boolean.valueOf(z3));
                ((IpInfoContract.View) getView()).getHaveSeen().setOnClickListener(new f(ipInfo, textView));
                if (ipInfo.getRank() != null || TextUtils.isEmpty(ipInfo.getRank().formatStr())) {
                    ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_ranklist).setVisibility(8);
                    ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_ranklist_divline).setVisibility(8);
                    z2 = false;
                } else {
                    View rootView3 = ((IpInfoContract.View) getView()).getRootView();
                    int i4 = R$id.ipinfo_ranklist;
                    rootView3.findViewById(i4).setVisibility(0);
                    ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_ranklist_divline).setVisibility(0);
                    ob.a((TextView) ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.rank_tv), ipInfo.getRank().formatStr());
                    ((IpInfoContract.View) getView()).getRootView().findViewById(i4).setOnClickListener(new g(ipInfo));
                    userTrackExpose(((IpInfoContract.View) getView()).getRootView().findViewById(i4), "repertoire_ranklist");
                }
                if (!z || z2) {
                    ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_rank).setVisibility(0);
                } else {
                    ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_rank).setVisibility(8);
                }
                if (TextUtils.isEmpty(ipInfo.ipvuvDescription)) {
                    View rootView4 = ((IpInfoContract.View) getView()).getRootView();
                    int i5 = R$id.tv_fans_icon_tip;
                    rootView4.findViewById(i5).setVisibility(0);
                    ((IpInfoContract.View) getView()).getRootView().findViewById(i5).setOnClickListener(new h(ipInfo));
                    return;
                }
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.tv_fans_icon_tip).setVisibility(8);
                return;
            } else {
                View rootView5 = ((IpInfoContract.View) getView()).getRootView();
                int i6 = R$id.ipinfo_score_value_root;
                rootView5.findViewById(i6).setVisibility(0);
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_tags_div).setVisibility(0);
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_tags).setVisibility(0);
                ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_title_icon).setVisibility(0);
                ((ImageView) ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_titleimg)).setImageResource(R$drawable.dm_ip_score_title);
                setScore(ipInfo);
                setTags(ipInfo);
                userTrackExpose(((IpInfoContract.View) getView()).getRootView().findViewById(i6), ln2.PROJECT_EVALUATE);
            }
            z = true;
            ((IpInfoContract.View) getView()).getUserComment().setOnClickListener(new e(ipInfo));
            if (((IpInfoContract.View) getView()).getWannaSee().getTag() != null) {
            }
            updateWannaSeeUi(ipInfo.focus, false);
            ((IpInfoContract.View) getView()).getWannaSee().setOnClickListener(new FollowClick(ipInfo));
            TextView textView2 = (TextView) ((IpInfoContract.View) getView()).getHaveSeen().findViewById(R$id.ipinfo_showinfo_haveseen_icon);
            boolean z32 = ipInfo.like;
            z32 = "1".equals(d20.B(this.followStateKey + ipInfo.getId()));
            updateHaveSeenText(textView2, z32);
            ((IpInfoContract.View) getView()).getHaveSeen().setTag(Boolean.valueOf(z32));
            ((IpInfoContract.View) getView()).getHaveSeen().setOnClickListener(new f(ipInfo, textView2));
            if (ipInfo.getRank() != null) {
            }
            ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_ranklist).setVisibility(8);
            ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_ranklist_divline).setVisibility(8);
            z2 = false;
            if (!z) {
            }
            ((IpInfoContract.View) getView()).getRootView().findViewById(R$id.ipinfo_score_rank).setVisibility(0);
            if (TextUtils.isEmpty(ipInfo.ipvuvDescription)) {
            }
        }
    }
}
