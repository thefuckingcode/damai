package com.taobao.application.common;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
public interface IAppPreferences {
    public static final IAppPreferences DEFAULT = new a();

    /* compiled from: Taobao */
    static class a implements IAppPreferences {
        a() {
        }

        @Override // com.taobao.application.common.IAppPreferences
        public boolean getBoolean(String str, boolean z) {
            return z;
        }

        @Override // com.taobao.application.common.IAppPreferences
        public float getFloat(String str, float f) {
            return f;
        }

        @Override // com.taobao.application.common.IAppPreferences
        public int getInt(String str, int i) {
            return i;
        }

        @Override // com.taobao.application.common.IAppPreferences
        public long getLong(String str, long j) {
            return j;
        }

        @Override // com.taobao.application.common.IAppPreferences
        @Nullable
        public String getString(String str, @Nullable String str2) {
            return str2;
        }
    }

    boolean getBoolean(String str, boolean z);

    float getFloat(String str, float f);

    int getInt(String str, int i);

    long getLong(String str, long j);

    @Nullable
    String getString(String str, @Nullable String str2);
}
