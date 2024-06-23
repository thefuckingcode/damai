package com.taobao.alivfssdk.utils;

import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
public class a {
    public static void a(File file) throws IOException {
        if (file == null) {
            throw new IllegalStateException("Failed to get external storage files directory");
        } else if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IllegalStateException(file.getAbsolutePath() + " already exists and is not a directory");
            }
        } else if (!file.mkdirs()) {
            throw new IOException("Couldn't create directory " + file.getPath());
        }
    }
}
