package com.youku.uplayer;

import java.util.Map;

/* compiled from: Taobao */
public interface OnPlayerHostListener {
    String getHost(String str, Map<String, String> map);

    boolean isDoubleChannelEnable(Map<String, String> map);
}
