package com.alipay.sdk.m.a0;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public final class c implements FileFilter {
    public final /* synthetic */ b a;

    public c(b bVar) {
        this.a = bVar;
    }

    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
