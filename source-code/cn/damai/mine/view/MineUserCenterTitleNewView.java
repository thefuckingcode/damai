package cn.damai.mine.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.user.userhome.bean.UserInfoBean;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import tb.d20;
import tb.gr;
import tb.ne2;
import tb.tu0;
import tb.v50;
import tb.wk;
import tb.xf2;
import tb.yd1;
import tb.zd1;

/* compiled from: Taobao */
public class MineUserCenterTitleNewView extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isInDarkModeNow = false;
    private boolean isSetAlphaFirstTime = true;
    private Context mContext;
    int mHeightTitleStatusBar;
    private FrameLayout mMessageLayout;
    private TextView mTvMsgBadgePoint;
    private DMIconFontTextView mTvTitleMessage;
    private DMIconFontTextView mTvTitleSetting;
    private TextView mTvUserNickName;
    private DMAvatar mUserAvatar;
    UserInfoBean mUserInfo;
    private LinearLayout mUserInfoLayout;
    private boolean showModifyBg = false;
    private View tv_modify_bg;
    private ImageView userTagView;
    private View user_tag_view_oldvip;

    public MineUserCenterTitleNewView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void gotoMessageBoxPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "847431280")) {
            ipChange.ipc$dispatch("847431280", new Object[]{this});
        } else if (this.mContext != null) {
            c.e().x(yd1.x().I());
            if (!LoginManager.k().q()) {
                DMNav.from(this.mContext).withExtras(new Bundle()).toUri(gr.f());
                return;
            }
            setMsgBadgePointDisappear();
            DMNav.from(this.mContext).toUri(NavUri.b(gr.x));
        }
    }

    private void gotoSettingPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1947095032")) {
            ipChange.ipc$dispatch("-1947095032", new Object[]{this});
            return;
        }
        c.e().x(yd1.x().J());
        Bundle bundle = new Bundle();
        long n = xf2.n(d20.E());
        if (n > 0) {
            bundle.putLong("userCode", n);
        }
        Context context = this.mContext;
        if (context != null) {
            DMNav.from(context).withExtras(bundle).toUri(gr.k());
        }
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1633136106")) {
            ipChange.ipc$dispatch("-1633136106", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R$layout.layout_mine_user_center_title, this);
        this.mTvTitleSetting = (DMIconFontTextView) findViewById(R$id.tv_setting);
        this.mMessageLayout = (FrameLayout) findViewById(R$id.ll_message);
        this.mTvMsgBadgePoint = (TextView) findViewById(R$id.view_msg_badge);
        this.mTvTitleMessage = (DMIconFontTextView) findViewById(R$id.tv_message);
        this.userTagView = (ImageView) findViewById(R$id.user_tag_view);
        this.user_tag_view_oldvip = findViewById(R$id.user_tag_view_oldvip);
        View findViewById = findViewById(R$id.tv_modify_bg);
        this.tv_modify_bg = findViewById;
        findViewById.setOnClickListener(this);
        updateTitleIconColor(false);
        initHeadUserInfo();
        initImmersionStyle();
        initSettingDisappear();
        setListener();
    }

    private void initHeadUserInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1949457219")) {
            ipChange.ipc$dispatch("-1949457219", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_user_info);
        this.mUserInfoLayout = linearLayout;
        this.mUserAvatar = (DMAvatar) linearLayout.findViewById(R$id.fl_user_avatar);
        this.mTvUserNickName = (TextView) this.mUserInfoLayout.findViewById(R$id.tv_nick_name);
        resetAvatar();
        this.mUserInfoLayout.setVisibility(4);
    }

    private void initImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "847908848")) {
            ipChange.ipc$dispatch("847908848", new Object[]{this});
            return;
        }
        this.mHeightTitleStatusBar = v50.a(this.mContext, 45.0f);
        View findViewById = findViewById(R$id.mine_title_bar_space);
        Activity activity = (Activity) getContext();
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                int a = ne2.a(activity);
                findViewById.getLayoutParams().height = a;
                findViewById.setVisibility(0);
                this.mHeightTitleStatusBar += a;
            }
            ne2.f(activity, true, R$color.black);
            ne2.d(true, activity);
            ne2.e(activity);
            return;
        }
        ne2.f(activity, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void initSettingDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "507227107")) {
            ipChange.ipc$dispatch("507227107", new Object[]{this});
            return;
        }
        this.mTvTitleSetting.setVisibility(0);
        this.mMessageLayout.setVisibility(0);
        setMsgBadgePointDisappear();
    }

    private void resetAvatar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099008484")) {
            ipChange.ipc$dispatch("-2099008484", new Object[]{this});
            return;
        }
        this.mUserAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_30x30);
        cn.damai.uikit.view.DMAvatar dMAvatar = this.mUserAvatar;
        int i = R$drawable.mine_account_default;
        dMAvatar.setAvatarPlaceholder(i);
        this.mUserAvatar.setAvatar(i);
        this.mUserAvatar.setAvatarBorderVisibility(8);
        this.mUserAvatar.setAvatarCrownVisibility(8);
        this.mUserAvatar.setAvatarVTagVisibility(8);
        this.mUserAvatar.setAvatarYYmemberTagVisibility(8);
    }

    private void setListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1378178478")) {
            ipChange.ipc$dispatch("1378178478", new Object[]{this});
            return;
        }
        this.mTvTitleSetting.setOnClickListener(this);
        this.mMessageLayout.setOnClickListener(this);
    }

    private void setMsgBadgePointDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2101373645")) {
            ipChange.ipc$dispatch("2101373645", new Object[]{this});
            return;
        }
        this.mTvMsgBadgePoint.setVisibility(4);
    }

    private void setYYMemberTag(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038576842")) {
            ipChange.ipc$dispatch("-2038576842", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        this.mUserAvatar.setYYMemberTagView(z, str);
    }

    public int getTitleHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1627889968")) {
            return this.mHeightTitleStatusBar;
        }
        return ((Integer) ipChange.ipc$dispatch("-1627889968", new Object[]{this})).intValue();
    }

    public void gotoAliMeCustomerService() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1837896734")) {
            ipChange.ipc$dispatch("-1837896734", new Object[]{this});
        } else if (this.mContext != null) {
            c.e().x(yd1.x().g0(wk.MY_ALIME_PAGE));
            if (LoginManager.k().q()) {
                AliMeUtil.k(this.mContext, AliMeUtil.FROM_MINE);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("from", 1);
            DMNav.from(this.mContext).withExtras(bundle).toUri(gr.f());
        }
    }

    public void gotoUserEditPage(UserInfoBean userInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "9848226")) {
            ipChange.ipc$dispatch("9848226", new Object[]{this, userInfoBean});
        } else if (this.mContext != null) {
            Bundle bundle = new Bundle();
            bundle.putString("nickName", userInfoBean.getUserNick());
            bundle.putString("userIntro", userInfoBean.userIntro);
            bundle.putString("birthday", userInfoBean.birthday);
            bundle.putInt("sex", userInfoBean.sex);
            DMNav.from(this.mContext).withExtras(bundle).toUri(NavUri.b("editaccount"));
        }
    }

    public void onClick(View view) {
        UserInfoBean userInfoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-583075753")) {
            ipChange.ipc$dispatch("-583075753", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (R$id.tv_setting == id) {
            gotoSettingPage();
        } else if (R$id.ll_message == id) {
            gotoMessageBoxPage();
        } else if (R$id.tv_modify_bg == id) {
            Context context = this.mContext;
            if ((context instanceof Activity) && (userInfoBean = this.mUserInfo) != null) {
                tu0.j((Activity) context, userInfoBean.headBgImg);
            }
        } else if (R$id.ll_kefu == id) {
            gotoAliMeCustomerService();
        } else if (R$id.ll_edit == id) {
            c.e().x(yd1.x().i0(Constants.TAG_FOR_EDIT));
            Object tag = view.getTag();
            if (tag == null || !zd1.d()) {
                DMNav.from(this.mContext).withExtras(new Bundle()).toUri(gr.f());
            } else if (tag instanceof UserInfoBean) {
                gotoUserEditPage((UserInfoBean) tag);
            }
        }
    }

    public void setBackGroundAlpha(float f, String str) {
        boolean z;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271551534")) {
            ipChange.ipc$dispatch("-1271551534", new Object[]{this, Float.valueOf(f), str});
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (this.showModifyBg) {
            if (((double) f) < 0.1d) {
                this.tv_modify_bg.setVisibility(0);
                this.tv_modify_bg.setClickable(true);
            } else if (this.tv_modify_bg.getVisibility() != 4) {
                this.tv_modify_bg.setVisibility(4);
                this.tv_modify_bg.setClickable(false);
            }
        }
        int i2 = (f > 0.5f ? 1 : (f == 0.5f ? 0 : -1));
        boolean z2 = i2 > 0;
        if (!this.isSetAlphaFirstTime && this.isInDarkModeNow == z2) {
            z = false;
        } else {
            z = true;
        }
        this.isInDarkModeNow = z2;
        this.isSetAlphaFirstTime = false;
        if (i2 > 0) {
            i = Color.argb(Math.round(f * 255.0f), 255, 255, 255);
            setClickable(true);
        } else {
            setClickable(false);
            i = 0;
        }
        setBackgroundColor(i);
        if (z) {
            Context context = getContext();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (z2) {
                    ne2.f(activity, true, -16777216);
                    ne2.d(true, activity);
                    updateTitleIconColor(false);
                    if (zd1.d()) {
                        this.mUserInfoLayout.setVisibility(0);
                    } else {
                        this.mUserInfoLayout.setVisibility(4);
                    }
                } else {
                    ne2.e(activity);
                    if (LoginManager.k().q() || !TextUtils.isEmpty(str)) {
                        updateTitleIconColor(true);
                    } else {
                        updateTitleIconColor(false);
                    }
                    this.mUserInfoLayout.setVisibility(4);
                }
            }
        }
    }

    public void setShowModifyBg(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-861149842")) {
            ipChange.ipc$dispatch("-861149842", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.showModifyBg = z;
    }

    public void updateMessageCount(int i) {
        String str;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1424247950")) {
            ipChange.ipc$dispatch("1424247950", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TextView textView = this.mTvMsgBadgePoint;
        if (textView != null) {
            if (i > 9) {
                str = "9+";
            } else {
                str = String.valueOf(i);
            }
            textView.setText(str);
            TextView textView2 = this.mTvMsgBadgePoint;
            if (i <= 0) {
                i2 = 8;
            }
            textView2.setVisibility(i2);
        }
    }

    public void updateTitleIconColor(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "716405513")) {
            ipChange.ipc$dispatch("716405513", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mTvTitleSetting.setTextColor(-1);
            this.mTvTitleMessage.setTextColor(-1);
        } else {
            DMIconFontTextView dMIconFontTextView = this.mTvTitleSetting;
            Resources resources = getResources();
            int i = R$color.color_3C3F44;
            dMIconFontTextView.setTextColor(resources.getColor(i));
            this.mTvTitleMessage.setTextColor(getResources().getColor(i));
        }
    }

    public void updateUserInfo(UserInfoBean userInfoBean, String str) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1093596785")) {
            ipChange.ipc$dispatch("1093596785", new Object[]{this, userInfoBean, str});
        } else if (userInfoBean == null) {
            resetAvatar();
            this.mTvUserNickName.setText("");
        } else {
            this.mUserInfo = userInfoBean;
            this.mTvUserNickName.setText(userInfoBean.getUserNick());
            this.mUserAvatar.setAvatar(userInfoBean.getImgUrl());
            boolean isVip = userInfoBean.isVip();
            this.mUserAvatar.setAvatarCrownVisibility(8);
            this.mUserAvatar.setAvatarBorderVisibility(8);
            if (userInfoBean.userTypeCode == 2) {
                this.mUserAvatar.setAvatarVTagVisibility(0);
            } else {
                this.mUserAvatar.setAvatarVTagVisibility(8);
                setYYMemberTag(false, userInfoBean.getMemberFlag());
            }
            int i2 = userInfoBean.userTypeCode;
            if (i2 > 0) {
                if (i2 == 1) {
                    i = R$drawable.uikit_user_tag_editor_mai;
                    this.userTagView.setVisibility(0);
                } else if (i2 == 3) {
                    i = R$drawable.uikit_user_tag_city_amusement;
                    this.userTagView.setVisibility(0);
                } else {
                    i = 0;
                }
                this.userTagView.setImageResource(i);
            } else {
                this.userTagView.setVisibility(8);
            }
            if (isVip) {
                this.user_tag_view_oldvip.setVisibility(0);
            } else {
                this.user_tag_view_oldvip.setVisibility(8);
            }
            if (!TextUtils.isEmpty(userInfoBean.headBgImg) || !TextUtils.isEmpty(str)) {
                setShowModifyBg(false);
                this.tv_modify_bg.setVisibility(4);
                this.tv_modify_bg.setClickable(false);
                if (this.mUserInfoLayout.getVisibility() != 0) {
                    DMIconFontTextView dMIconFontTextView = this.mTvTitleSetting;
                    Resources resources = getResources();
                    int i3 = R$color.white;
                    dMIconFontTextView.setTextColor(resources.getColor(i3));
                    this.mTvTitleMessage.setTextColor(getResources().getColor(i3));
                    return;
                }
                return;
            }
            setShowModifyBg(true);
            this.tv_modify_bg.setVisibility(0);
            this.tv_modify_bg.setClickable(true);
            DMIconFontTextView dMIconFontTextView2 = this.mTvTitleSetting;
            Resources resources2 = getResources();
            int i4 = R$color.color_3C3F44;
            dMIconFontTextView2.setTextColor(resources2.getColor(i4));
            this.mTvTitleMessage.setTextColor(getResources().getColor(i4));
        }
    }

    public MineUserCenterTitleNewView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public MineUserCenterTitleNewView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }
}
