package cn.damai.tetris.component.ip;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.UTExposureInfo;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.ip.IpBottomBarContract;
import cn.damai.tetris.component.ip.bean.BottomItem;
import cn.damai.tetris.component.ip.bean.IpBottomBarBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.util.ColorTextUtil;
import cn.damai.uikit.view.DMThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.MsgID;
import java.util.ArrayList;
import java.util.Map;
import tb.br;
import tb.ob;
import tb.rr1;
import tb.s50;
import tb.w9;
import tb.wk;

/* compiled from: Taobao */
public class IpBottomBarPresenter extends BasePresenter<IpBottomBarContract.Model, IpBottomBarContract.View, BaseSection> implements IpBottomBarContract.Presenter<IpBottomBarContract.Model, IpBottomBarContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;
    private long startDialogOpenTimeMillis;
    private long startDialogSeeTimeMillis;
    private long startShowTimeMillis;

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-343518607")) {
                ipChange.ipc$dispatch("-343518607", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            long currentTimeMillis = System.currentTimeMillis() - IpBottomBarPresenter.this.startDialogOpenTimeMillis;
            if (IpBottomBarPresenter.this.mTrackInfo.getArgsMap() != null) {
                Map<String, String> argsMap = IpBottomBarPresenter.this.mTrackInfo.getArgsMap();
                argsMap.put("spm-url", "a2o4t." + IpBottomBarPresenter.this.mTrackInfo.trackB + ".tips.gotoopen");
            }
            cn.damai.common.user.c.e().C("gotoopen", "tips", IpBottomBarPresenter.this.mTrackInfo.trackB, "1.0", currentTimeMillis, IpBottomBarPresenter.this.mTrackInfo.getArgsMap(), 2201);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + IpBottomBarPresenter.this.getContext().getActivity().getPackageName()));
            IpBottomBarPresenter.this.getContext().getActivity().startActivity(intent);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;
        final /* synthetic */ int b;

        b(PopupWindow popupWindow, int i) {
            this.a = popupWindow;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "254019135")) {
                ipChange.ipc$dispatch("254019135", new Object[]{this, view});
                return;
            }
            this.a.dismiss();
            IpBottomBarPresenter.this.setExpo(this.b);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;
        final /* synthetic */ int b;

        c(PopupWindow popupWindow, int i) {
            this.a = popupWindow;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1929657792")) {
                ipChange.ipc$dispatch("-1929657792", new Object[]{this, view});
                return;
            }
            this.a.dismiss();
            IpBottomBarPresenter.this.setExpo(this.b);
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BottomItem a;
        final /* synthetic */ int b;

        d(BottomItem bottomItem, int i) {
            this.a = bottomItem;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "181632577")) {
                ipChange.ipc$dispatch("181632577", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, this.a.getId() + "");
            bundle.putString("projectName", this.a.name);
            bundle.putString("projectImage", this.a.verticalPic);
            DMNav.from(((BasePresenter) IpBottomBarPresenter.this).mContext.getActivity()).withExtras(bundle).toUri(NavUri.b(wk.PROJECT_DETAIL_PAGE));
            IpBottomBarPresenter.this.setExpo(this.b);
        }
    }

    public IpBottomBarPresenter(IpBottomBarView ipBottomBarView, String str, w9 w9Var) {
        super(ipBottomBarView, str, w9Var);
    }

    private void bindItem(ViewGroup viewGroup, int i, BottomItem bottomItem, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006179839")) {
            ipChange.ipc$dispatch("-1006179839", new Object[]{this, viewGroup, Integer.valueOf(i), bottomItem, Integer.valueOf(i2)});
            return;
        }
        if (i == 0) {
            viewGroup.findViewById(R$id.ip_tour_item_divline_top).setVisibility(4);
        }
        View findViewById = viewGroup.findViewById(R$id.ip_tour_item_buy);
        View findViewById2 = viewGroup.findViewById(R$id.ip_tour_item_btn);
        TextView textView = (TextView) viewGroup.findViewById(R$id.ip_tour_item_buy_midtext);
        TextView textView2 = (TextView) viewGroup.findViewById(R$id.ip_tour_item_buy_desc);
        TextView textView3 = (TextView) viewGroup.findViewById(R$id.ip_tour_item_month);
        TextView textView4 = (TextView) viewGroup.findViewById(R$id.ip_tour_item_city);
        ob.a(textView3, bottomItem.getStartDate());
        ob.a(textView4, bottomItem.getCityName());
        ob.a((TextView) viewGroup.findViewById(R$id.ip_tour_item_date), "时间 " + bottomItem.getShowTime());
        ob.a((TextView) viewGroup.findViewById(R$id.ip_tour_item_place), "地点 " + bottomItem.getVenueName());
        ob.a((TextView) viewGroup.findViewById(R$id.ip_tour_item_time), "场次 " + bottomItem.getTotal() + "场");
        if (bottomItem.getType() == 2) {
            findViewById.setVisibility(4);
            findViewById2.setVisibility(0);
            findViewById2.setBackground(getContext().getActivity().getResources().getDrawable(R$drawable.buy_btn_normal_blue_bg));
            textView.setTextColor(getContext().getActivity().getResources().getColor(R$color.white));
            ob.a(textView, "去预约");
        } else if (bottomItem.getType() == 3) {
            findViewById.setVisibility(4);
            findViewById2.setVisibility(0);
            findViewById2.setBackground(getContext().getActivity().getResources().getDrawable(R$drawable.buy_btn_normal_white_bg));
            textView.setTextColor(getContext().getActivity().getResources().getColor(R$color.color_9C9CA5));
            ob.a(textView, "筹备中");
        } else {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(4);
            ((TextView) viewGroup.findViewById(R$id.tv_project_price)).setText(bottomItem.getPriceLow());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams.setMargins(0, s50.a(getContext().getActivity(), 4.0f), s50.a(getContext().getActivity(), 8.0f), 0);
            textView2.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(bottomItem.getDiscount())) {
                textView2.setVisibility(0);
                textView2.setText(bottomItem.getDiscount() + "折起");
            }
        }
        if (bottomItem.getIsClosest()) {
            Resources resources = getContext().getActivity().getResources();
            int i3 = R$color.color_FF2869;
            textView3.setTextColor(resources.getColor(i3));
            textView4.setTextColor(getContext().getActivity().getResources().getColor(i3));
            viewGroup.findViewById(R$id.ip_tour_item_city_nearest).setVisibility(0);
            ((ImageView) viewGroup.findViewById(R$id.ip_tour_item_divline_dot)).setImageResource(R$drawable.shape_circle_ff2869);
        }
        viewGroup.setOnClickListener(new d(bottomItem, i2));
    }

    private String getTourStr(IpBottomBarBean ipBottomBarBean) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-838633752")) {
            return (String) ipChange.ipc$dispatch("-838633752", new Object[]{this, ipBottomBarBean});
        }
        if (ipBottomBarBean.getTourCities() > 0) {
            str = ipBottomBarBean.getTourCities() + "个城市巡演中";
        } else {
            str = "";
        }
        if (ipBottomBarBean.getPrepareCities() > 0) {
            if (!TextUtils.isEmpty(str)) {
                str = str + " | ";
            }
            return str + ipBottomBarBean.getPrepareCities() + "个城市筹备中";
        } else if (TextUtils.isEmpty(ipBottomBarBean.getDiscount())) {
            return str;
        } else {
            if (!TextUtils.isEmpty(str)) {
                str = str + " | ";
            }
            return str + ipBottomBarBean.getDiscount() + "折起";
        }
    }

    private String getWantSeeTipsContent(IpBottomBarBean ipBottomBarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1885543805")) {
            return (String) ipChange.ipc$dispatch("-1885543805", new Object[]{this, ipBottomBarBean});
        } else if (ipBottomBarBean.getTourCities() > 0) {
            return ipBottomBarBean.getTourCities() + "个城市巡演中";
        } else if (ipBottomBarBean.getPrepareCities() <= 0) {
            return "";
        } else {
            return ipBottomBarBean.getPrepareCities() + "个城市筹备中";
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setExpo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "913361388")) {
            ipChange.ipc$dispatch("913361388", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mTrackInfo != null) {
            ArrayList<UTExposureInfo.UTExposureBean> arrayList = new ArrayList<>();
            String str = "a2o4t." + this.mTrackInfo.trackB + "." + this.mTrackInfo.trackC;
            long currentTimeMillis = System.currentTimeMillis() - this.startShowTimeMillis;
            for (int i2 = 0; i2 < i; i2++) {
                String str2 = str + ".item_" + i2;
                UTExposureInfo.UTExposureBean uTExposureBean = new UTExposureInfo.UTExposureBean();
                uTExposureBean.area = "1.0";
                uTExposureBean.duration = currentTimeMillis;
                uTExposureBean.exargs = this.mTrackInfo.getArgsMap();
                uTExposureBean.viewid = str2;
                uTExposureBean.spm = str2;
                arrayList.add(uTExposureBean);
            }
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            TrackInfo trackInfo = this.mTrackInfo;
            e.B(trackInfo.trackC, trackInfo.trackB, arrayList, 2201);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showPopwindow(SpannableStringBuilder spannableStringBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "459687980")) {
            ipChange.ipc$dispatch("459687980", new Object[]{this, spannableStringBuilder});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_popup_ip_tour, (ViewGroup) null);
        ((TextView) inflate.findViewById(R$id.ip_tour_top_title)).setText(spannableStringBuilder);
        int a2 = s50.a(this.mContext.getActivity(), 92.0f);
        int size = ((IpBottomBarContract.Model) getModel()).getBottomBarBean().getItems().size();
        for (int i = 0; i < size; i++) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_popup_ip_tour_item, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(R$id.ip_tour_scroll_content)).addView(viewGroup, new LinearLayout.LayoutParams(-1, a2));
            bindItem(viewGroup, i, ((IpBottomBarContract.Model) getModel()).getBottomBarBean().getItems().get(i), size);
        }
        int a3 = (a2 * size) + s50.a(this.mContext.getActivity(), 80.0f);
        if (size == 1) {
            a3 += s50.a(this.mContext.getActivity(), 34.0f);
        }
        rr1 g = new rr1(inflate, a3).g(this.mContext.getActivity());
        PopupWindow c2 = g.c();
        int f = g.f();
        recordStartShowTimeMillis();
        int i2 = R$id.sub_content;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) inflate.findViewById(i2).getLayoutParams();
        layoutParams.height = f;
        inflate.findViewById(i2).setLayoutParams(layoutParams);
        inflate.setOnClickListener(new b(c2, size));
        inflate.findViewById(R$id.ip_tour_top_close).setOnClickListener(new c(c2, size));
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-556014340")) {
            ipChange.ipc$dispatch("-556014340", new Object[]{this, Integer.valueOf(i), obj});
        } else if (this.mContext.getActivity() != null) {
            if (i != 10240) {
                if (i == 10245) {
                    long currentTimeMillis = System.currentTimeMillis() - this.startDialogSeeTimeMillis;
                    TrackInfo trackInfo = this.mTrackInfo;
                    if (!(trackInfo == null || trackInfo.getArgsMap() == null)) {
                        Map<String, String> argsMap = this.mTrackInfo.getArgsMap();
                        argsMap.put("spm-url", "a2o4t." + this.mTrackInfo.trackB + ".tips.gotosee");
                    }
                    if (this.mTrackInfo != null) {
                        cn.damai.common.user.c e = cn.damai.common.user.c.e();
                        TrackInfo trackInfo2 = this.mTrackInfo;
                        e.C("gotosee", "tips", trackInfo2.trackB, "1.0", currentTimeMillis, trackInfo2.getArgsMap(), 2201);
                    }
                    ((IpBottomBarContract.View) getView()).getBuyView().performClick();
                }
            } else if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                Object obj2 = pair.first;
                if ((obj2 instanceof String) && "5".equals(obj2)) {
                    Object obj3 = pair.second;
                    if (obj3 instanceof Pair) {
                        Pair pair2 = (Pair) obj3;
                        if (getModel() != null && ((IpBottomBarContract.Model) getModel()).getBottomBarBean() != null && ((IpBottomBarContract.Model) getModel()).getBottomBarBean().ipId != null && ((IpBottomBarContract.Model) getModel()).getBottomBarBean().ipId.equals(pair2.second)) {
                            String str = ((IpBottomBarContract.Model) getModel()).getBottomBarBean().focus ? "1" : "0";
                            if (!str.equals(pair2.first + "")) {
                                try {
                                    IpBottomBarBean bottomBarBean = ((IpBottomBarContract.Model) getModel()).getBottomBarBean();
                                    bottomBarBean.focus = "1".equals(pair2.first + "");
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                if (((IpBottomBarContract.Model) getModel()).getBottomBarBean().getTourCities() + ((IpBottomBarContract.Model) getModel()).getBottomBarBean().getPrepareCities() <= 0) {
                                    ((IpBottomBarContract.View) getView()).getBuyView().setText(((IpBottomBarContract.Model) getModel()).getBottomBarBean().focus ? "已想看" : "想看");
                                    ((IpBottomBarContract.View) getView()).getBuyView().setBackground(this.mContext.getActivity().getResources().getDrawable(((IpBottomBarContract.Model) getModel()).getBottomBarBean().focus ? R$drawable.buy_btn_pressed_bg_gray : R$drawable.buy_btn_usable_bg_selector));
                                    if (!((IpBottomBarContract.Model) getModel()).getBottomBarBean().focus) {
                                        return;
                                    }
                                    if (getContext().getActivity() == null || PermissionsHelper.a(getContext().getActivity())) {
                                        br.c("ip_drama_want_see_tips_show", getWantSeeTipsContent(((IpBottomBarContract.Model) getModel()).getBottomBarBean()));
                                        return;
                                    }
                                    DMThemeDialog dMThemeDialog = new DMThemeDialog(getContext().getActivity());
                                    dMThemeDialog.o("赞～已收到你的想看").r(DMThemeDialog.DMDialogTheme.THEME_GUARD_SUCCESS).k(Html.fromHtml("目前暂无可售项目,建议您先<font color='#FF0000'>开启消息提醒</font>，方便第一时间捕获可售项目")).i("去开启", new a()).g(false, null);
                                    dMThemeDialog.show();
                                    this.startDialogOpenTimeMillis = System.currentTimeMillis();
                                } else if (((IpBottomBarContract.Model) getModel()).getBottomBarBean().focus) {
                                    this.startDialogSeeTimeMillis = System.currentTimeMillis();
                                    br.c("ip_drama_want_see_tips_show", getWantSeeTipsContent(((IpBottomBarContract.Model) getModel()).getBottomBarBean()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void recordStartShowTimeMillis() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "363436426")) {
            ipChange.ipc$dispatch("363436426", new Object[]{this});
            return;
        }
        this.startShowTimeMillis = System.currentTimeMillis();
    }

    public void init(IpBottomBarContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1902755423")) {
            ipChange.ipc$dispatch("-1902755423", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        if (((IpBottomBarContract.Model) getModel()).getBottomBarBean() != null) {
            String tourStr = getTourStr(((IpBottomBarContract.Model) getModel()).getBottomBarBean());
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tourStr);
            if (!TextUtils.isEmpty(tourStr)) {
                if (((IpBottomBarContract.Model) getModel()).getBottomBarBean().getTourCities() > 0) {
                    int indexOf = tourStr.indexOf(((IpBottomBarContract.Model) getModel()).getBottomBarBean().getTourCities() + "");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#ff2869")), indexOf, (((IpBottomBarContract.Model) getModel()).getBottomBarBean().getTourCities() + "").length() + indexOf, 33);
                }
                if (((IpBottomBarContract.Model) getModel()).getBottomBarBean().getPrepareCities() > 0) {
                    int indexOf2 = tourStr.indexOf(((IpBottomBarContract.Model) getModel()).getBottomBarBean().getPrepareCities() + "");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#ff2869")), indexOf2, (((IpBottomBarContract.Model) getModel()).getBottomBarBean().getPrepareCities() + "").length() + indexOf2, 33);
                } else if (!TextUtils.isEmpty(((IpBottomBarContract.Model) getModel()).getBottomBarBean().getDiscount())) {
                    String str = ((IpBottomBarContract.Model) getModel()).getBottomBarBean().getDiscount() + "折起";
                    int indexOf3 = tourStr.indexOf(str);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#ff2869")), indexOf3, str.length() + indexOf3, 33);
                }
                ((IpBottomBarContract.View) getView()).getDescView().setText(spannableStringBuilder);
            } else {
                String str2 = "暂无演出计划";
                if (!TextUtils.isEmpty(((IpBottomBarContract.Model) getModel()).getBottomBarBean().getIpvuv())) {
                    str2 = str2 + "," + ((IpBottomBarContract.Model) getModel()).getBottomBarBean().getIpvuv() + "人求演出";
                }
                ob.a(((IpBottomBarContract.View) getView()).getDescView(), str2);
                if (!TextUtils.isEmpty(((IpBottomBarContract.Model) getModel()).getBottomBarBean().getIpvuv())) {
                    ColorTextUtil.a(((IpBottomBarContract.View) getView()).getDescView(), ((IpBottomBarContract.Model) getModel()).getBottomBarBean().getIpvuv(), R$color.color_FF2869);
                }
            }
            if (model.getBottomBarBean() == null || ((IpBottomBarContract.Model) getModel()).getBottomBarBean().getItems() == null || ((IpBottomBarContract.Model) getModel()).getBottomBarBean().getItems().size() <= 0) {
                ((IpBottomBarContract.View) getView()).getBuyView().setText(((IpBottomBarContract.Model) getModel()).getBottomBarBean().focus ? "已想看" : "想看");
                ((IpBottomBarContract.View) getView()).getBuyView().setBackground(this.mContext.getActivity().getResources().getDrawable(((IpBottomBarContract.Model) getModel()).getBottomBarBean().focus ? R$drawable.buy_btn_pressed_bg_gray : R$drawable.buy_btn_usable_bg_selector));
                userTrackExpose(((IpBottomBarContract.View) getView()).getBuyView(), "favorite");
            } else {
                if (((IpBottomBarContract.Model) getModel()).getBottomBarBean().getTourCities() > 0) {
                    ((IpBottomBarContract.View) getView()).getBuyView().setText("立即购买");
                } else if (((IpBottomBarContract.Model) getModel()).getBottomBarBean().getPrepareCities() > 0) {
                    ((IpBottomBarContract.View) getView()).getBuyView().setText("去看看");
                }
                userTrackExpose(((IpBottomBarContract.View) getView()).getBuyView(), "buy");
            }
            ((IpBottomBarContract.View) getView()).getBuyView().setTag(Boolean.valueOf(((IpBottomBarContract.Model) getModel()).getBottomBarBean().focus));
            ((IpBottomBarContract.View) getView()).getBuyView().setOnClickListener(new View.OnClickListener() {
                /* class cn.damai.tetris.component.ip.IpBottomBarPresenter.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(final View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "326405693")) {
                        ipChange.ipc$dispatch("326405693", new Object[]{this, view});
                    } else if (((IpBottomBarContract.Model) IpBottomBarPresenter.this.getModel()).getBottomBarBean().getTourCities() + ((IpBottomBarContract.Model) IpBottomBarPresenter.this.getModel()).getBottomBarBean().getPrepareCities() > 0) {
                        IpBottomBarPresenter.this.showPopwindow(spannableStringBuilder);
                        IpBottomBarPresenter.this.userTrackClick("buy", false);
                    } else {
                        IpBottomBarPresenter.this.userTrackClick("favorite", false);
                        FollowRequest followRequest = new FollowRequest();
                        StringBuilder sb = new StringBuilder();
                        sb.append(view.getTag());
                        sb.append("");
                        followRequest.operateType = "true".equals(sb.toString()) ? "0" : "1";
                        followRequest.targetId = ((IpBottomBarContract.Model) IpBottomBarPresenter.this.getModel()).getBottomBarBean().ipId;
                        followRequest.targetType = "5";
                        followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
                            /* class cn.damai.tetris.component.ip.IpBottomBarPresenter.AnonymousClass1.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                            public void onFail(String str, String str2) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "240170608")) {
                                    ipChange.ipc$dispatch("240170608", new Object[]{this, str, str2});
                                    return;
                                }
                                view.setClickable(true);
                            }

                            public void onSuccess(FollowDataBean followDataBean) {
                                IpChange ipChange = $ipChange;
                                boolean z = false;
                                if (AndroidInstantRuntime.support(ipChange, "988651120")) {
                                    ipChange.ipc$dispatch("988651120", new Object[]{this, followDataBean});
                                    return;
                                }
                                view.setClickable(true);
                                if (followDataBean.getStatus() != 0) {
                                    z = true;
                                }
                                ((IpBottomBarContract.View) IpBottomBarPresenter.this.getView()).getBuyView().setTag(Boolean.valueOf(z));
                                if (z) {
                                    ToastUtil.a().e(((BasePresenter) IpBottomBarPresenter.this).mContext.getActivity(), "你的请求收到啦");
                                }
                                IpBottomBarPresenter.this.sendMsg(new Message(MsgID.MEDIA_INFO_VIDEO_START_RECOVER, new Pair("5", Pair.create(Integer.valueOf(followDataBean.getStatus()), ((IpBottomBarContract.Model) IpBottomBarPresenter.this.getModel()).getBottomBarBean().ipId))));
                            }
                        });
                    }
                }
            });
        }
    }
}
