package com.alibaba.security.biometrics.service.model.strategy;

import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import java.util.List;

/* compiled from: Taobao */
public interface ActionStrategy {
    List<ABDetectType> getDetectTypes(int i);
}
