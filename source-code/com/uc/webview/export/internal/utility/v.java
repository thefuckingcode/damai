package com.uc.webview.export.internal.utility;

import java.io.File;
import java.io.FilenameFilter;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class v implements FilenameFilter {
    v() {
    }

    public final boolean accept(File file, String str) {
        return str.startsWith("uc_temp_dec_");
    }
}
