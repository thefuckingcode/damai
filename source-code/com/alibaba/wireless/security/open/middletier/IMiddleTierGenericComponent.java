package com.alibaba.wireless.security.open.middletier;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

@InterfacePluginInfo(pluginName = "middletier")
/* compiled from: Taobao */
public interface IMiddleTierGenericComponent extends IComponent {
    public static final int OPEN_MIDDLETIER_ENV_DAILY = 2;
    public static final int OPEN_MIDDLETIER_ENV_ONLINE = 0;
    public static final int OPEN_MIDDLETIER_ENV_PRE = 1;

    HashMap<String, String> getMiniWua(HashMap<String, Object> hashMap) throws SecException;

    HashMap<String, String> getSign(HashMap<String, Object> hashMap) throws SecException;

    HashMap<String, String> getWua(HashMap<String, Object> hashMap) throws SecException;

    boolean init(HashMap<String, Object> hashMap) throws SecException;
}
