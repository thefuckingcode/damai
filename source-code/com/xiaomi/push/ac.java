package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ac implements FileFilter {
    ac() {
    }

    public boolean accept(File file) {
        return file.isDirectory();
    }
}
