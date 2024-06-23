package com.uc.webview.export.internal.utility;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class r implements FileFilter {
    private Pattern a = Pattern.compile("cpu[0-9]+", 0);

    r() {
    }

    public final boolean accept(File file) {
        return this.a.matcher(file.getName()).matches();
    }
}
