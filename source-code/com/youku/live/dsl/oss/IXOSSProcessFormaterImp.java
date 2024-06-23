package com.youku.live.dsl.oss;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IConfig;
import tb.jl1;

/* compiled from: Taobao */
public class IXOSSProcessFormaterImp implements IXOSSProcessFormater {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String X_OSS_PROCESS = "x-oss-process=image";

    private static String replaceAccessTokenReg(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "40099000")) {
            return (String) ipChange.ipc$dispatch("40099000", new Object[]{str, str2, str3});
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) {
            return str;
        } else {
            return str.replaceAll(jl1.BRACKET_START_STR + str2 + "=[^&]*)", str2 + "=" + str3);
        }
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public String getImageFormat() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1345293585")) {
            return !isNeedOptimizeImageFormat() ? "" : "/format,webp";
        }
        return (String) ipChange.ipc$dispatch("-1345293585", new Object[]{this});
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public String getImageResize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851084748")) {
            return (String) ipChange.ipc$dispatch("1851084748", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (!isNeedOptimizeImageResize() || i + i2 <= 0) {
            return "";
        } else {
            return "/resize,m_fixed,w_" + i + ",h_" + i2;
        }
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public String getUrlWithOriginUrl(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1737451165")) {
            return getUrlWithOriginUrl(str, 0, 0);
        }
        return (String) ipChange.ipc$dispatch("-1737451165", new Object[]{this, str});
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public boolean isNeedOptimizeImageFormat() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-809735316")) {
            return "1".equals(((IConfig) Dsl.getService(IConfig.class)).getString("dago_liveconfig", "isNeedOptimizeImageFormat", "1"));
        }
        return ((Boolean) ipChange.ipc$dispatch("-809735316", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public boolean isNeedOptimizeImageResize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-476958321")) {
            return "1".equals(((IConfig) Dsl.getService(IConfig.class)).getString("dago_liveconfig", "isNeedOptimizeImageResize", "1"));
        }
        return ((Boolean) ipChange.ipc$dispatch("-476958321", new Object[]{this})).booleanValue();
    }

    public boolean isNoNeedOptimize(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "910325469")) {
            return TextUtils.isEmpty(str) || "0".equals(((IConfig) Dsl.getService(IConfig.class)).getString("dago_liveconfig", "image_format", "1"));
        }
        return ((Boolean) ipChange.ipc$dispatch("910325469", new Object[]{this, str})).booleanValue();
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public String getUrlWithOriginUrl(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1854726211")) {
            return (String) ipChange.ipc$dispatch("1854726211", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (isNoNeedOptimize(str)) {
            return str;
        } else {
            if (str.indexOf(X_OSS_PROCESS) > 0) {
                return str + getImageFormat() + getImageResize(i, i2);
            } else if (str.indexOf("?") > 0) {
                return str + "&" + X_OSS_PROCESS + getImageFormat() + getImageResize(i, i2);
            } else {
                return str + "?" + X_OSS_PROCESS + getImageFormat() + getImageResize(i, i2);
            }
        }
    }
}
