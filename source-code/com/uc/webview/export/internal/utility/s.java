package com.uc.webview.export.internal.utility;

import java.io.File;
import java.io.FilenameFilter;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class s implements FilenameFilter {
    s() {
    }

    public final boolean accept(File file, String str) {
        return str.startsWith("libkernel") && str.endsWith("_uc.so");
    }
}
