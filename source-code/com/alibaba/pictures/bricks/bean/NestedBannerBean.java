package com.alibaba.pictures.bricks.bean;

import android.graphics.Color;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alient.onearch.adapter.view.GenericViewCard;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.rk1;

/* compiled from: Taobao */
public class NestedBannerBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public JSONObject action;
    public String color;
    public String id;
    public String pic;
    public String picHigh;
    public String schema;
    public String subPic1;
    public String subPic2;
    public String subPic3;
    public String subPicText1;
    public String subPicText2;
    public String subPicText3;
    @JSONField(deserialize = false, serialize = false)
    public GenericViewCard temp;
    public String type;

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-824095540")) {
            return ((Boolean) ipChange.ipc$dispatch("-824095540", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            NestedBannerBean nestedBannerBean = (NestedBannerBean) obj;
            if (!rk1.a(this.id, nestedBannerBean.id) || !rk1.a(this.pic, nestedBannerBean.pic) || !rk1.a(this.picHigh, nestedBannerBean.picHigh) || !rk1.a(this.schema, nestedBannerBean.schema) || !rk1.a(this.color, nestedBannerBean.color) || !rk1.a(this.subPic1, nestedBannerBean.subPic1) || !rk1.a(this.subPicText1, nestedBannerBean.subPicText1) || !rk1.a(this.subPic2, nestedBannerBean.subPic2) || !rk1.a(this.subPicText2, nestedBannerBean.subPicText2) || !rk1.a(this.subPic3, nestedBannerBean.subPic3) || !rk1.a(this.type, nestedBannerBean.type)) {
                return false;
            }
            return true;
        }
    }

    public int getBgColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1280223722")) {
            return ((Integer) ipChange.ipc$dispatch("-1280223722", new Object[]{this})).intValue();
        }
        try {
            return Color.parseColor(this.color);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-782739325")) {
            return ((Integer) ipChange.ipc$dispatch("-782739325", new Object[]{this})).intValue();
        }
        return rk1.b(this.id, this.pic, this.picHigh, this.schema, this.color, this.subPic1, this.subPicText1, this.subPic2, this.subPicText2, this.subPic3, this.type);
    }

    public boolean isSuperFrameBanner() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1618054215")) {
            return "1".equalsIgnoreCase(this.type);
        }
        return ((Boolean) ipChange.ipc$dispatch("1618054215", new Object[]{this})).booleanValue();
    }
}
