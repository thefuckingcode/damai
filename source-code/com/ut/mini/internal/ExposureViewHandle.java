package com.ut.mini.internal;

import android.view.View;
import java.util.Map;

/* compiled from: Taobao */
public interface ExposureViewHandle {
    Map<String, String> getExposureViewProperties(String str, View view);

    ExposureViewTag getExposureViewTag(String str, View view);

    boolean isExposureView(String str, View view);
}
