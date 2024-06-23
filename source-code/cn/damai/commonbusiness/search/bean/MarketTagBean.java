package cn.damai.commonbusiness.search.bean;

import android.text.TextUtils;
import android.view.ViewGroup;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.tag.DMTagType;
import com.alibaba.pictures.bricks.component.project.bean.ProjectVipTagBean;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MarketTagBean extends ProjectVipTagBean {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int SUB_TYPE_WEDNESDAY_DISCOUNT = 1;
    public static final String TYPE_ZAONIAO = "ZAONIAO";
    public String prefix;
    public String shortTag;
    public int subType;
    public String tag;
    public String type;
    public String value;

    public DMCommonTagView addMarketTagView(ViewGroup viewGroup, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045652522")) {
            return (DMCommonTagView) ipChange.ipc$dispatch("1045652522", new Object[]{this, viewGroup, Boolean.valueOf(z)});
        } else if (((TextUtils.isEmpty(this.tag) || TextUtils.isEmpty(this.prefix)) && !specialTag()) || z) {
            DMCommonTagView dMCommonTagView = new DMCommonTagView(viewGroup.getContext());
            dMCommonTagView.adjustTagHeight(z);
            if (isWednesdayDiscount()) {
                if (z) {
                    dMCommonTagView.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT_HOME);
                } else {
                    dMCommonTagView.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT);
                }
                viewGroup.addView(dMCommonTagView);
            } else if (z && !TextUtils.isEmpty(this.shortTag)) {
                if ("VIP".equalsIgnoreCase(this.type)) {
                    dMCommonTagView.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_FF866E).setTagName(this.shortTag);
                    dMCommonTagView.setTagAutoTextSize(true);
                } else if ("VIP_PRIVILEGE".equalsIgnoreCase(this.type)) {
                    dMCommonTagView.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_VIP_PRIVILEGE).setTagName(this.shortTag);
                    dMCommonTagView.setTagAutoTextSize(true);
                } else {
                    dMCommonTagView.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION).setTagName(this.shortTag);
                    dMCommonTagView.setTagAutoTextSize(false);
                }
                viewGroup.addView(dMCommonTagView);
            } else if (!TextUtils.isEmpty(this.tag)) {
                dMCommonTagView.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION).setTagName(this.tag);
                dMCommonTagView.setTagAutoTextSize(false);
                viewGroup.addView(dMCommonTagView);
            }
            return dMCommonTagView;
        } else {
            DMCommonTagView dMCommonTagView2 = new DMCommonTagView(viewGroup.getContext());
            dMCommonTagView2.adjustTagHeight(false);
            if (vipTag()) {
                dMCommonTagView2.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_VIP).setTagContent(this.prefix, this.tag);
            } else if (isWednesdayDiscount()) {
                dMCommonTagView2.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT);
            } else {
                dMCommonTagView2.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_2PART).setTagContent(this.prefix, this.tag);
            }
            viewGroup.addView(dMCommonTagView2);
            return dMCommonTagView2;
        }
    }

    public boolean isWednesdayDiscount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1588836215")) {
            return 1 == this.subType && "SINGLE".equals(this.type);
        }
        return ((Boolean) ipChange.ipc$dispatch("1588836215", new Object[]{this})).booleanValue();
    }

    public boolean showOnPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "840982038")) {
            return "ZAONIAO".equals(this.type);
        }
        return ((Boolean) ipChange.ipc$dispatch("840982038", new Object[]{this})).booleanValue();
    }

    public boolean specialTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-693510771")) {
            return vipTag() || BQCScanEngine.COUPON_ENGINE.equalsIgnoreCase(this.type);
        }
        return ((Boolean) ipChange.ipc$dispatch("-693510771", new Object[]{this})).booleanValue();
    }

    public boolean vipTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "608992369")) {
            return "VIP".equalsIgnoreCase(this.type) || "VIP_PRIVILEGE".equalsIgnoreCase(this.type);
        }
        return ((Boolean) ipChange.ipc$dispatch("608992369", new Object[]{this})).booleanValue();
    }
}
