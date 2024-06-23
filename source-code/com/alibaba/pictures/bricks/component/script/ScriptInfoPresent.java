package com.alibaba.pictures.bricks.component.script;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$raw;
import com.alibaba.pictures.bricks.bean.SaleModelTagsBean;
import com.alibaba.pictures.bricks.component.script.ScriptInfoContract;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.o;
import tb.c52;
import tb.ca1;
import tb.d52;
import tb.e52;
import tb.eb0;
import tb.k21;
import tb.m40;

public final class ScriptInfoPresent extends AbsPresenter<GenericItem<ItemValue>, ScriptInfoModel, ScriptInfoView> implements ScriptInfoContract.Present {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final a Companion = new a(null);
    public static final String MSG_SCRIPT_BG_UPDATE;
    public static final String PRE_STICKY_HEADER;
    public static final int REQUEST_CODE_HAS_PLAYED_LOGIN;
    public static final int REQUEST_CODE_PUBLISH_SUCCESS;
    private String favoriteFlag = "-1";
    private boolean isCurrentUserFollowed;
    private boolean isCurrentUserHasPlayed;
    public LottieAnimationView mLottieWanna2SeeIcon;
    public TextView mWanna2SeeTv;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScriptInfoPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* access modifiers changed from: public */
    private final void followStatusChanged(String str, boolean z) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "562818042")) {
            ipChange.ipc$dispatch("562818042", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        boolean z2 = !o.x(str, "0", false, 2, null);
        this.isCurrentUserFollowed = z2;
        if (z2) {
            i = R$raw.lottie_favourite_click;
        } else {
            i = R$raw.lottie_favorite_cancel;
        }
        getMLottieWanna2SeeIcon().setAnimation(i);
        getMLottieWanna2SeeIcon().setProgress(1.0f);
        if (z) {
            getMLottieWanna2SeeIcon().playAnimation();
        } else {
            getMLottieWanna2SeeIcon().setProgress(1.0f);
        }
        getMWanna2SeeTv().setText(this.isCurrentUserFollowed ? "已想玩" : "想玩");
        if (this.isCurrentUserFollowed) {
            getMWanna2SeeTv().setTextColor(Color.parseColor("#ff70b8"));
        } else {
            getMWanna2SeeTv().setTextColor(Color.parseColor("#3B3F43"));
        }
    }

    /* renamed from: init$lambda-10 */
    public static final void m138init$lambda10(ScriptInfoPresent scriptInfoPresent, GenericItem genericItem, View view) {
        Action action;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-959206251")) {
            ipChange.ipc$dispatch("-959206251", new Object[]{scriptInfoPresent, genericItem, view});
            return;
        }
        k21.i(scriptInfoPresent, "this$0");
        k21.i(genericItem, "$item");
        if (!scriptInfoPresent.isCurrentUserHasPlayed) {
            if (!DoloresLoginHandler.Companion.a().c()) {
                ca1.a aVar = ca1.Companion;
                Activity activity = genericItem.getPageContext().getActivity();
                k21.g(activity, "null cannot be cast to non-null type android.content.Context");
                aVar.b(activity);
                return;
            }
            String id = ((ScriptInfoModel) scriptInfoPresent.getModel()).getScriptInfo().getId();
            k21.h(view, AdvanceSetting.NETWORK_TYPE);
            scriptInfoPresent.requestFollow(id, view);
            Map<String, Action> actions = scriptInfoPresent.getActions();
            if (actions != null && (action = actions.get("want_play")) != null && (trackInfo = action.getTrackInfo()) != null) {
                k21.h(trackInfo, "trackInfo");
                HashMap<String, String> args = trackInfo.getArgs();
                k21.h(args, "args");
                args.put("favoriteFlag", scriptInfoPresent.isCurrentUserFollowed ? "0" : "1");
                UserTrackProviderProxy.click(view, trackInfo, false);
            }
        }
    }

    /* renamed from: init$lambda-4$lambda-0 */
    public static final void m139init$lambda4$lambda0(String str, GenericItem genericItem, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1614020425")) {
            ipChange.ipc$dispatch("1614020425", new Object[]{str, genericItem, view});
            return;
        }
        k21.i(str, "$url");
        k21.i(genericItem, "$item");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        PicInfo picInfo = new PicInfo();
        picInfo.setPicUrl(str);
        arrayList.add(picInfo);
        Bundle bundle = new Bundle();
        bundle.putInt("position", 0);
        bundle.putParcelableArrayList("pic_info", arrayList);
        Action action = new Action();
        action.setActionType(1);
        action.setExtra(bundle);
        action.setActionUrl("damai://videobrowse");
        NavProviderProxy.getProxy().toUri(genericItem.getPageContext().getActivity(), action);
    }

    private final void updateTopPlayLayout(ScriptInfoHeaderBean scriptInfoHeaderBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "684505190")) {
            ipChange.ipc$dispatch("684505190", new Object[]{this, scriptInfoHeaderBean});
            return;
        }
        TextView textView = (TextView) ((ScriptInfoView) getView()).getItemView().findViewById(R$id.script_detail_top_play_tv);
        textView.setText(this.isCurrentUserHasPlayed ? "已玩过" : "玩过");
        textView.setTextColor(this.isCurrentUserHasPlayed ? Color.parseColor("#4D3B3F43") : Color.parseColor("#3B3F43"));
        ((TextView) ((ScriptInfoView) getView()).getItemView().findViewById(R$id.script_detail_top_play_icon)).setTextColor(this.isCurrentUserHasPlayed ? Color.parseColor("#4D3B3F43") : Color.parseColor("#3B3F43"));
        ((ScriptInfoView) getView()).getItemView().findViewById(R$id.script_detail_top_play_layout).setOnClickListener(new c52(this, scriptInfoHeaderBean));
    }

    /* renamed from: updateTopPlayLayout$lambda-16 */
    public static final void m140updateTopPlayLayout$lambda16(ScriptInfoPresent scriptInfoPresent, ScriptInfoHeaderBean scriptInfoHeaderBean, View view) {
        Action action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-549431936")) {
            ipChange.ipc$dispatch("-549431936", new Object[]{scriptInfoPresent, scriptInfoHeaderBean, view});
            return;
        }
        k21.i(scriptInfoPresent, "this$0");
        k21.i(scriptInfoHeaderBean, "$scriptInfo");
        if (scriptInfoPresent.isCurrentUserHasPlayed) {
            BricksToastUtil.INSTANCE.b("已玩过的剧本可以在「我的-动态」里编辑哟～");
        } else if (!DoloresLoginHandler.Companion.a().c()) {
            Activity activity = ((GenericItem) scriptInfoPresent.getItem()).getPageContext().getActivity();
            if (activity != null) {
                ca1.Companion.c(activity, REQUEST_CODE_HAS_PLAYED_LOGIN);
            }
        } else {
            Action action2 = null;
            Map<String, Action> actions = scriptInfoPresent.getActions();
            if (!(actions == null || (action = actions.get("played")) == null)) {
                TrackInfo trackInfo = action.getTrackInfo();
                if (trackInfo != null) {
                    k21.h(trackInfo, "trackInfo");
                    UserTrackProviderProxy.click(view, trackInfo, false);
                }
                Action action3 = new Action();
                action3.setActionType(1);
                action3.setExtra(action.getExtra());
                action3.setActionUrl(action.getActionUrl());
                NavProviderProxy.getProxy().toUri(((GenericItem) scriptInfoPresent.getItem()).getPageContext().getActivity(), action3);
                action2 = action;
            }
            if (action2 == null) {
                Action action4 = new Action();
                action4.setActionType(1);
                action4.setActionUrl("damai://V1/PublishPage?publisherType=ReleaseType_Evaluate&scriptId=" + scriptInfoHeaderBean.getId() + "&commentType=66");
                NavProviderProxy.getProxy().toUri(((GenericItem) scriptInfoPresent.getItem()).getPageContext().getActivity(), action4);
            }
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-857673051")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-857673051", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2017334248")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2017334248", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1626403408")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1626403408", new Object[]{this})).booleanValue();
    }

    public final String getFavoriteFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "475401021")) {
            return this.favoriteFlag;
        }
        return (String) ipChange.ipc$dispatch("475401021", new Object[]{this});
    }

    public final LottieAnimationView getMLottieWanna2SeeIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119621816")) {
            return (LottieAnimationView) ipChange.ipc$dispatch("-1119621816", new Object[]{this});
        }
        LottieAnimationView lottieAnimationView = this.mLottieWanna2SeeIcon;
        if (lottieAnimationView != null) {
            return lottieAnimationView;
        }
        k21.A("mLottieWanna2SeeIcon");
        return null;
    }

    public final TextView getMWanna2SeeTv() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687308686")) {
            return (TextView) ipChange.ipc$dispatch("-1687308686", new Object[]{this});
        }
        TextView textView = this.mWanna2SeeTv;
        if (textView != null) {
            return textView;
        }
        k21.A("mWanna2SeeTv");
        return null;
    }

    public final boolean isCurrentUserFollowed() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1202765477")) {
            return this.isCurrentUserFollowed;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1202765477", new Object[]{this})).booleanValue();
    }

    public final boolean isCurrentUserHasPlayed() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "299762842")) {
            return this.isCurrentUserHasPlayed;
        }
        return ((Boolean) ipChange.ipc$dispatch("299762842", new Object[]{this})).booleanValue();
    }

    public void requestFollow(String str, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-140523161")) {
            ipChange.ipc$dispatch("-140523161", new Object[]{this, str, view});
            return;
        }
        k21.i(str, "id");
        k21.i(view, "view");
        boolean z = this.isCurrentUserFollowed;
        view.setClickable(false);
        FollowRequest followRequest = new FollowRequest();
        followRequest.init(!z, "25:" + str);
        eb0.a(followRequest).doOnKTStart(ScriptInfoPresent$requestFollow$2.INSTANCE).doOnKTSuccess(new ScriptInfoPresent$requestFollow$3(this, view)).doOnKTFail(new ScriptInfoPresent$requestFollow$4(view));
    }

    public final void setCurrentUserFollowed(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44806397")) {
            ipChange.ipc$dispatch("44806397", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isCurrentUserFollowed = z;
    }

    public final void setCurrentUserHasPlayed(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693204386")) {
            ipChange.ipc$dispatch("-1693204386", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isCurrentUserHasPlayed = z;
    }

    public final void setFavoriteFlag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2044556479")) {
            ipChange.ipc$dispatch("-2044556479", new Object[]{this, str});
            return;
        }
        k21.i(str, "<set-?>");
        this.favoriteFlag = str;
    }

    public final void setMLottieWanna2SeeIcon(LottieAnimationView lottieAnimationView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447771992")) {
            ipChange.ipc$dispatch("447771992", new Object[]{this, lottieAnimationView});
            return;
        }
        k21.i(lottieAnimationView, "<set-?>");
        this.mLottieWanna2SeeIcon = lottieAnimationView;
    }

    public final void setMWanna2SeeTv(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923552018")) {
            ipChange.ipc$dispatch("923552018", new Object[]{this, textView});
            return;
        }
        k21.i(textView, "<set-?>");
        this.mWanna2SeeTv = textView;
    }

    public void init(GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1955017481")) {
            ipChange.ipc$dispatch("-1955017481", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        View itemView = ((ScriptInfoView) getView()).getItemView();
        TextView textView = (TextView) itemView.findViewById(R$id.script_info_header_name);
        if (textView != null) {
            textView.setText(((ScriptInfoModel) getModel()).getScriptInfo().getName());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (textView != null) {
                textView.setAutoSizeTextTypeWithDefaults(1);
            }
            if (textView != null) {
                textView.setAutoSizeTextTypeUniformWithConfiguration(10, 20, textView.getAutoSizeStepGranularity(), 1);
            }
        }
        ImageView imageView = (ImageView) itemView.findViewById(R$id.script_info_header_img);
        String url = ((ScriptInfoModel) getModel()).getScriptInfo().getUrl();
        if (url != null) {
            ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
            if (proxy != null) {
                int i2 = R$drawable.bricks_uikit_default_image_bg_grey;
                proxy.loadinto(url, imageView, i2, i2);
            }
            if (imageView != null) {
                imageView.setOnClickListener(new e52(url, genericItem));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("value", ((ScriptInfoModel) getModel()).getScriptInfo());
            Map<String, Action> actions = getActions();
            if (actions != null) {
                Action action = actions.get("share");
                if (action != null) {
                    hashMap.put("share", action);
                }
                Action action2 = actions.get("report");
                if (action2 != null) {
                    hashMap.put("report", action2);
                }
            }
            EventDispatcher eventDispatcher = genericItem.getPageContext().getEventDispatcher();
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent(MSG_SCRIPT_BG_UPDATE, hashMap);
            }
        }
        TextView textView2 = (TextView) itemView.findViewById(R$id.script_info_header_limit_tag);
        ArrayList<SaleModelTagsBean> saleModelTags = ((ScriptInfoModel) getModel()).getScriptInfo().getSaleModelTags();
        if (saleModelTags != null) {
            Iterator<SaleModelTagsBean> it = saleModelTags.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SaleModelTagsBean next = it.next();
                k21.h(next, AdvanceSetting.NETWORK_TYPE);
                SaleModelTagsBean saleModelTagsBean = next;
                if (k21.d("2", saleModelTagsBean.getType())) {
                    String desc = saleModelTagsBean.getDesc();
                    if (!(desc == null || (o.y(desc)))) {
                        textView2.setVisibility(0);
                        textView2.setText(saleModelTagsBean.getDesc());
                        break;
                    }
                }
                if (textView2.getVisibility() != 8) {
                    textView2.setVisibility(8);
                }
            }
        }
        View findViewById = itemView.findViewById(R$id.script_detail_top_wanna_2_see_icon);
        k21.h(findViewById, "rootview.findViewById(R.…ail_top_wanna_2_see_icon)");
        setMLottieWanna2SeeIcon((LottieAnimationView) findViewById);
        View findViewById2 = itemView.findViewById(R$id.script_detail_top_wanna_2_see_text);
        k21.h(findViewById2, "rootview.findViewById(R.…ail_top_wanna_2_see_text)");
        setMWanna2SeeTv((TextView) findViewById2);
        if (TextUtils.isEmpty(((ScriptInfoModel) getModel()).getScriptInfo().getFavoriteFlag())) {
            ((ScriptInfoModel) getModel()).getScriptInfo().setFavoriteFlag("0");
        }
        if (!"-1".equals(this.favoriteFlag)) {
            followStatusChanged(this.favoriteFlag, false);
        } else {
            followStatusChanged(((ScriptInfoModel) getModel()).getScriptInfo().getFavoriteFlag(), false);
        }
        ScriptInfoHeaderBean scriptInfo = ((ScriptInfoModel) getModel()).getScriptInfo();
        this.isCurrentUserHasPlayed = scriptInfo.getHasPlayed();
        itemView.findViewById(R$id.script_detail_top_place_h).setVisibility(this.isCurrentUserHasPlayed ? 4 : 8);
        LinearLayout linearLayout = (LinearLayout) itemView.findViewById(R$id.script_detail_top_follow_layout);
        if (this.isCurrentUserHasPlayed) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        linearLayout.setOnClickListener(new d52(this, genericItem));
        updateTopPlayLayout(scriptInfo);
    }
}
