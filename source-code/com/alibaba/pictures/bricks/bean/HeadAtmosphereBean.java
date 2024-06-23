package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.rk1;

/* compiled from: Taobao */
public class HeadAtmosphereBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String backgroundPic;
    public String highLowType;
    public String id;
    public String lottie;
    public String schema;

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2053796501")) {
            return ((Boolean) ipChange.ipc$dispatch("-2053796501", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            HeadAtmosphereBean headAtmosphereBean = (HeadAtmosphereBean) obj;
            if (!rk1.a(this.id, headAtmosphereBean.id) || !rk1.a(this.backgroundPic, headAtmosphereBean.backgroundPic) || !rk1.a(this.schema, headAtmosphereBean.schema) || !rk1.a(this.lottie, headAtmosphereBean.lottie) || !rk1.a(this.highLowType, headAtmosphereBean.highLowType)) {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1292351266")) {
            return ((Integer) ipChange.ipc$dispatch("1292351266", new Object[]{this})).intValue();
        }
        return rk1.b(this.id, this.backgroundPic, this.schema, this.lottie, this.highLowType);
    }

    public boolean isLottieAtmosphere() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-762890333")) {
            return !TextUtils.isEmpty(this.lottie);
        }
        return ((Boolean) ipChange.ipc$dispatch("-762890333", new Object[]{this})).booleanValue();
    }

    public boolean isPicAtmosphere() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "632993698")) {
            return TextUtils.isEmpty(this.lottie) && !TextUtils.isEmpty(this.backgroundPic);
        }
        return ((Boolean) ipChange.ipc$dispatch("632993698", new Object[]{this})).booleanValue();
    }

    public boolean isShowPlaceholderHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1661898671")) {
            return TextUtils.equals("1", this.highLowType);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1661898671", new Object[]{this})).booleanValue();
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "672552178")) {
            return isLottieAtmosphere() || isPicAtmosphere();
        }
        return ((Boolean) ipChange.ipc$dispatch("672552178", new Object[]{this})).booleanValue();
    }
}
