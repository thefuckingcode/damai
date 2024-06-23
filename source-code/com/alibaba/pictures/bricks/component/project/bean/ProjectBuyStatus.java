package com.alibaba.pictures.bricks.component.project.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class ProjectBuyStatus implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -7074195426309848350L;
    public String desc;
    public String id;

    public boolean colorGrey() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2032433955")) {
            return TextUtils.isEmpty(this.id) || this.id.equals("2");
        }
        return ((Boolean) ipChange.ipc$dispatch("-2032433955", new Object[]{this})).booleanValue();
    }
}
