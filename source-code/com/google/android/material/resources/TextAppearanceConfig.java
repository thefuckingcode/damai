package com.google.android.material.resources;

@Deprecated
/* compiled from: Taobao */
public class TextAppearanceConfig {
    private static boolean shouldLoadFontSynchronously;

    public static void setShouldLoadFontSynchronously(boolean z) {
        shouldLoadFontSynchronously = z;
    }

    public static boolean shouldLoadFontSynchronously() {
        return shouldLoadFontSynchronously;
    }
}
