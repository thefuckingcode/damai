package com.uc.webview.export.internal.utility;

import java.io.File;
import java.io.FilenameFilter;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class k implements FilenameFilter {
    k() {
    }

    public final boolean accept(File file, String str) {
        return str.contains("sdk_shell");
    }
}
