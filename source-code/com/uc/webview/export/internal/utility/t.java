package com.uc.webview.export.internal.utility;

import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.File;
import java.io.FilenameFilter;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class t implements FilenameFilter {
    t() {
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(SolidMonitor.CHECK_TYPE_LIB) && str.endsWith("_kr_uc.so");
    }
}
