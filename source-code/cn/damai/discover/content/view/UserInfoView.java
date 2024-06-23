package cn.damai.discover.content.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$styleable;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.uikit.view.UserTagView;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v50;

/* compiled from: Taobao */
public class UserInfoView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMAvatar avatar;
    private int avatarRightMargin;
    private View avatarRightMarginView;
    private DMAvatar.DMAvatarSize avatarSize;
    private LinearLayout llDNA;
    private TextView tvDNAValue;
    private TextView userDesc;
    private TextView userName;
    private int userNameBottomMargin;
    private View userNameBottomMarginView;
    private UserTagView userTagView;
    private UserTagView utvOldVipTag;

    /* compiled from: Taobao */
    public interface DnaClickListener {
        void onDnaClick();
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DnaClickListener a;

        a(UserInfoView userInfoView, DnaClickListener dnaClickListener) {
            this.a = dnaClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1451074690")) {
                ipChange.ipc$dispatch("1451074690", new Object[]{this, view});
                return;
            }
            this.a.onDnaClick();
        }
    }

    public UserInfoView(Context context) {
        this(context, null);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333290714")) {
            ipChange.ipc$dispatch("333290714", new Object[]{this, context, attributeSet});
            return;
        }
        this.avatarSize = DMAvatar.DMAvatarSize.SIZE_33x33;
        this.avatarRightMargin = v50.a(context, 9.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UserInfoView);
        int i = obtainStyledAttributes.getInt(R$styleable.UserInfoView_userAvatarSize, 0);
        this.avatarRightMargin = obtainStyledAttributes.getDimensionPixelSize(R$styleable.UserInfoView_avatarRightMargin, this.avatarRightMargin);
        this.userNameBottomMargin = obtainStyledAttributes.getDimensionPixelSize(R$styleable.UserInfoView_userNameBottomMargin, 0);
        if (i == 0) {
            this.avatarSize = DMAvatar.DMAvatarSize.SIZE_30x30;
        } else if (i == 1) {
            this.avatarSize = DMAvatar.DMAvatarSize.SIZE_40x40;
        } else if (i == 2) {
            this.avatarSize = DMAvatar.DMAvatarSize.SIZE_50x50;
        } else if (i == 3) {
            this.avatarSize = DMAvatar.DMAvatarSize.SIZE_60x60;
        } else if (i == 4) {
            this.avatarSize = DMAvatar.DMAvatarSize.SIZE_80x80;
        } else if (i == 5) {
            this.avatarSize = DMAvatar.DMAvatarSize.SIZE_100x100;
        }
        obtainStyledAttributes.recycle();
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1906108391")) {
            ipChange.ipc$dispatch("-1906108391", new Object[]{this, context});
            return;
        }
        LinearLayout.inflate(context, R$layout.widget_user_info_view, this);
        this.avatar = (cn.damai.uikit.view.DMAvatar) findViewById(R$id.user_icon);
        this.avatarRightMarginView = findViewById(R$id.user_icon_right_margin);
        this.userName = (TextView) findViewById(R$id.user_name);
        this.userNameBottomMarginView = findViewById(R$id.user_name_bottom_margin);
        UserTagView userTagView2 = (UserTagView) findViewById(R$id.user_tag_view);
        this.userTagView = userTagView2;
        userTagView2.setIconSize(context, 13, 12);
        UserTagView userTagView3 = (UserTagView) findViewById(R$id.user_old_vip_tag_view);
        this.utvOldVipTag = userTagView3;
        userTagView3.setIconSize(context, 13, 12);
        this.userDesc = (TextView) findViewById(R$id.user_desc);
        this.llDNA = (LinearLayout) findViewById(R$id.ll_user_dna);
        this.tvDNAValue = (TextView) findViewById(R$id.tv_user_dna_value);
        this.avatar.setAvatarSize(this.avatarSize);
        setAvatarRightMargin(this.avatarRightMargin);
        setUserNameBottomMargin(this.userNameBottomMargin);
    }

    public View getDnaView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "362858912")) {
            return this.llDNA;
        }
        return (View) ipChange.ipc$dispatch("362858912", new Object[]{this});
    }

    public void setAvatarRightMargin(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1167786098")) {
            ipChange.ipc$dispatch("-1167786098", new Object[]{this, Integer.valueOf(i)});
        } else if (this.avatarRightMarginView != null) {
            this.avatarRightMarginView.setLayoutParams(new LinearLayout.LayoutParams(i, -1));
        }
    }

    public void setAvatarSize(DMAvatar.DMAvatarSize dMAvatarSize) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "541350042")) {
            ipChange.ipc$dispatch("541350042", new Object[]{this, dMAvatarSize});
            return;
        }
        cn.damai.uikit.view.DMAvatar dMAvatar = this.avatar;
        if (dMAvatar != null) {
            dMAvatar.setAvatarSize(dMAvatarSize);
        }
    }

    public void setAvatarUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642978502")) {
            ipChange.ipc$dispatch("-642978502", new Object[]{this, str});
        } else if (this.avatar != null && !TextUtils.isEmpty(str)) {
            this.avatar.setAvatar(str);
        }
    }

    public void setBorderVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017673315")) {
            ipChange.ipc$dispatch("-2017673315", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        cn.damai.uikit.view.DMAvatar dMAvatar = this.avatar;
        if (dMAvatar != null) {
            dMAvatar.setAvatarBorderVisibility(i);
        }
    }

    public void setCrownVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2102036826")) {
            ipChange.ipc$dispatch("-2102036826", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        cn.damai.uikit.view.DMAvatar dMAvatar = this.avatar;
        if (dMAvatar != null) {
            dMAvatar.setAvatarCrownVisibility(i);
        }
    }

    public void setDna(boolean z, String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1948438127")) {
            ipChange.ipc$dispatch("1948438127", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        LinearLayout linearLayout = this.llDNA;
        if (!z) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        this.userDesc.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.tvDNAValue.setText(str);
        }
    }

    public void setDnaClickListener(DnaClickListener dnaClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-960488276")) {
            ipChange.ipc$dispatch("-960488276", new Object[]{this, dnaClickListener});
            return;
        }
        this.llDNA.setOnClickListener(new a(this, dnaClickListener));
    }

    public void setIsOldVip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1663303344")) {
            ipChange.ipc$dispatch("-1663303344", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        UserTagView userTagView2 = this.utvOldVipTag;
        if (userTagView2 != null) {
            if (z) {
                userTagView2.setVisibility(0);
                this.utvOldVipTag.setTagType(4);
                this.utvOldVipTag.setTagNameVisibility(8);
                return;
            }
            userTagView2.setVisibility(8);
        }
    }

    public void setTagName(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-193849109")) {
            ipChange.ipc$dispatch("-193849109", new Object[]{this, str});
            return;
        }
        UserTagView userTagView2 = this.userTagView;
        if (userTagView2 != null) {
            userTagView2.setTagNameVisibility(8);
            boolean z = !TextUtils.isEmpty(str);
            UserTagView userTagView3 = this.userTagView;
            if (!z) {
                i = 8;
            }
            userTagView3.setVisibility(i);
        }
    }

    public void setUserDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1210417774")) {
            ipChange.ipc$dispatch("-1210417774", new Object[]{this, str});
        } else if (this.userDesc != null) {
            if (TextUtils.isEmpty(str)) {
                this.userDesc.setVisibility(8);
            }
            this.userDesc.setVisibility(0);
            this.userDesc.setText(str);
        }
    }

    public void setUserName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1100554712")) {
            ipChange.ipc$dispatch("1100554712", new Object[]{this, str});
            return;
        }
        TextView textView = this.userName;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setUserNameBottomMargin(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111385074")) {
            ipChange.ipc$dispatch("-2111385074", new Object[]{this, Integer.valueOf(i)});
        } else if (this.userNameBottomMarginView != null) {
            this.userNameBottomMarginView.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
        }
    }

    public void setUserTagType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1531059878")) {
            ipChange.ipc$dispatch("1531059878", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setUserTagType(i, false);
    }

    public void setVTagVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-830817035")) {
            ipChange.ipc$dispatch("-830817035", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        cn.damai.uikit.view.DMAvatar dMAvatar = this.avatar;
        if (dMAvatar != null) {
            dMAvatar.setAvatarVTagVisibility(i);
        }
    }

    public void setVip(boolean z, String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "745040117")) {
            ipChange.ipc$dispatch("745040117", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        setCrownVisibility(z ? 0 : 8);
        if (!z) {
            i = 8;
        }
        setBorderVisibility(i);
        cn.damai.uikit.view.DMAvatar dMAvatar = this.avatar;
        if (dMAvatar != null) {
            dMAvatar.setYYMemberTagView(z, str);
        }
    }

    public void showUserTagType(boolean z) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-4729734")) {
            ipChange.ipc$dispatch("-4729734", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        UserTagView userTagView2 = this.userTagView;
        if (!z) {
            i = 8;
        }
        userTagView2.setVisibility(i);
    }

    public UserInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setUserTagType(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "218261742")) {
            ipChange.ipc$dispatch("218261742", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        UserTagView userTagView2 = this.userTagView;
        if (userTagView2 != null) {
            userTagView2.setVisibility(0);
            this.userTagView.setTagNameVisibility(8);
            if (z) {
                this.userTagView.setIconSize(getContext(), 63, 16);
            } else {
                this.userTagView.setIconSize(getContext(), 13, 12);
            }
            this.userTagView.setTagType(i, z);
        }
    }

    public UserInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttrs(context, attributeSet);
        initView(context);
    }
}
