package com.youku.playerservice.axp.utils;

import com.alimm.xadsdk.business.common.utils.AdUtils;
import java.util.Map;

/* compiled from: Taobao */
public class AdUtil {
    public static Map<String, String> getAdRequestParams(int i) {
        return AdUtils.getAdRequestParams(i, false);
    }
}
