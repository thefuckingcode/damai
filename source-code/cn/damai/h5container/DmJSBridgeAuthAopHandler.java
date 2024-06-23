package cn.damai.h5container;

import android.net.Uri;
import android.taobao.windvane.jsbridge.WVJSAPIAuthCheck;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.mtop.wvplugin.MtopWVPlugin;
import tb.xf2;

/* compiled from: Taobao */
public class DmJSBridgeAuthAopHandler implements WVJSAPIAuthCheck {
    private static transient /* synthetic */ IpChange $ipChange;
    private String[] whiteList;

    @Override // android.taobao.windvane.jsbridge.WVJSAPIAuthCheck
    public boolean apiAuthCheck(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2028885308")) {
            return ((Boolean) ipChange.ipc$dispatch("-2028885308", new Object[]{this, str, str2, str3, str4})).booleanValue();
        }
        if (!xf2.j(str) && !xf2.j(str2) && !xf2.j(str3)) {
            try {
                String host = Uri.parse(str).getHost();
                Log.d("WVJSAPIAuthCheck", "url : " + str + ", obj : " + str2 + ", method : " + str3 + " , params : " + str4);
                if (MtopWVPlugin.API_SERVER_NAME.equals(str2) && "send".equals(str3)) {
                    if (host == null || ((!host.contains("tmall.com") && !host.contains("market.wapa.piao.cn") && !host.contains("m.piao.cn")) || this.whiteList != null)) {
                        String[] strArr = this.whiteList;
                        if (strArr != null && strArr.length > 0) {
                            for (String str5 : strArr) {
                                if (str.contains(str5)) {
                                    Log.d("WVJSAPIAuthCheck", "WVJSAPIAuthCheck return false :" + str5);
                                    return false;
                                }
                            }
                        }
                    } else {
                        Log.d("WVJSAPIAuthCheck", " tmall.com ，m.piao.cn ");
                        return false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void setAuthHost(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362685884")) {
            ipChange.ipc$dispatch("-362685884", new Object[]{this, str});
        } else if (!xf2.j(str) && str.split(",") != null) {
            Log.d("WVJSAPIAuthCheck", " setAuthHost host : " + str);
            this.whiteList = str.split(",");
        }
    }
}
