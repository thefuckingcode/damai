package cn.damai.login.authlogin.resp;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import tb.xf2;

/* compiled from: Taobao */
public class AuthInfoBean implements Serializable {
    public String fromIconUrl;
    public ArrayList<String> infoList;
    public String infoTitle;
    public ArrayList<ProtocolInfo> protocolList;
    public String protocolTitle;
    public String toIconUrl;

    /* compiled from: Taobao */
    public static class ProtocolInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String protocolName;
        public String protocolUrl;

        public boolean isValid() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-516555157")) {
                return !xf2.j(this.protocolName) && !xf2.j(this.protocolUrl);
            }
            return ((Boolean) ipChange.ipc$dispatch("-516555157", new Object[]{this})).booleanValue();
        }
    }
}
