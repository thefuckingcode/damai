package cn.damai.commonbusiness.discover.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class ThemeShareBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public String shareImage;
    public String shareSubTitle;
    public String shareTitle;
    public String shareUrl;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "986941855")) {
            return !TextUtils.isEmpty(this.shareImage) && !TextUtils.isEmpty(this.shareUrl);
        }
        return ((Boolean) ipChange.ipc$dispatch("986941855", new Object[]{this})).booleanValue();
    }
}
