package com.youku.arch.solid.monitor;

import com.youku.arch.solid.monitor.SolidMonitor;
import java.util.Map;

/* compiled from: Taobao */
public interface IMonitor {
    void reportStageResult(SolidMonitor.Stage stage, Map<SolidMonitor.Params, String> map);
}
