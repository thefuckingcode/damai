package com.alibaba.emas.datalab.metrics.listener;

import java.util.Map;

/* compiled from: Taobao */
public interface DatalabMetricListener {
    void dataCommit(String str, String str2, Map<String, String> map, Map<String, Double> map2);
}
