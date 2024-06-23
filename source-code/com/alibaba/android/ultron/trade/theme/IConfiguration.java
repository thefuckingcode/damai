package com.alibaba.android.ultron.trade.theme;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public interface IConfiguration {
    String getConfigurationPath();

    Map<String, List<String>> getCustomKV();
}
