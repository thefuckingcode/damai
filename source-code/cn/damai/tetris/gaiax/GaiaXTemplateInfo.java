package cn.damai.tetris.gaiax;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.io.Serializable;

@Keep
/* compiled from: Taobao */
public class GaiaXTemplateInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bizKey;
    public String componentId;
    public String identifier;
    public String version;

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "424710920")) {
            return ((Boolean) ipChange.ipc$dispatch("424710920", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            GaiaXTemplateInfo gaiaXTemplateInfo = (GaiaXTemplateInfo) obj;
            if (!TextUtils.equals(this.componentId, gaiaXTemplateInfo.componentId) || !TextUtils.equals(this.version, gaiaXTemplateInfo.version)) {
                return false;
            }
            return true;
        }
    }

    public String getIdentifier() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2059982660")) {
            return (String) ipChange.ipc$dispatch("-2059982660", new Object[]{this});
        }
        if (TextUtils.isEmpty(this.identifier)) {
            this.identifier = this.componentId + JSMethod.NOT_SET + this.version;
        }
        return this.identifier;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "640915135")) {
            return getIdentifier().hashCode();
        }
        return ((Integer) ipChange.ipc$dispatch("640915135", new Object[]{this})).intValue();
    }
}
