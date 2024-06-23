package com.airbnb.lottie.network;

import tb.o91;

/* compiled from: Taobao */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");
    
    public final String extension;

    private FileExtension(String str) {
        this.extension = str;
    }

    public static FileExtension forFile(String str) {
        FileExtension[] values = values();
        for (FileExtension fileExtension : values) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        o91.c("Unable to find correct extension for " + str);
        return JSON;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    public String toString() {
        return this.extension;
    }
}
