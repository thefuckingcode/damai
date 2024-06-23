package com.taobao.android.protodb;

import android.app.Application;
import androidx.annotation.Keep;
import java.io.File;
import tb.f0;
import tb.u51;

@Keep
/* compiled from: Taobao */
public class Series extends NativeBridgedObject {
    public Series(long j) {
        super(j);
    }

    @Keep
    private native void nativeAppendRecord(String str, String str2, ValueWrapper[] valueWrapperArr);

    @Keep
    private native long nativeGetRecord(String str);

    @Keep
    private static native long nativeOpen(String str, Config config);

    public static Series open(String str, Config config) {
        Application a = f0.a();
        if (a == null) {
            throw new RuntimeException("failed to get android context!");
        } else if (!NativeBridgedObject.sNativeLibraryLoaded) {
            return null;
        } else {
            long nativeOpen = nativeOpen(a.getFilesDir() + File.separator + "lsdb-series-" + str, config);
            if (nativeOpen > 0) {
                return new Series(nativeOpen);
            }
            return null;
        }
    }

    public void appendRecord(u51 u51, String str, Object... objArr) {
        ValueWrapper[] valueWrapperArr = new ValueWrapper[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof String) {
                valueWrapperArr[i] = ValueWrapper.stringValue((String) obj);
            } else if (obj instanceof Number) {
                if (obj instanceof Integer) {
                    valueWrapperArr[i] = ValueWrapper.intValue(((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    valueWrapperArr[i] = ValueWrapper.longValue(((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    valueWrapperArr[i] = ValueWrapper.floatValue(((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    valueWrapperArr[i] = ValueWrapper.doubleValue(((Double) obj).doubleValue());
                }
            }
        }
        nativeAppendRecord(u51.a(), str, valueWrapperArr);
    }

    public Record getRecord(u51 u51) {
        long nativeGetRecord = nativeGetRecord(u51.a());
        if (nativeGetRecord > 0) {
            return new Record(nativeGetRecord);
        }
        return null;
    }

    public static Series open(String str, String str2, Config config) {
        if (!NativeBridgedObject.sNativeLibraryLoaded) {
            return null;
        }
        long nativeOpen = nativeOpen(str + File.separator + "lsdb-series-" + str2, config);
        if (nativeOpen > 0) {
            return new Series(nativeOpen);
        }
        return null;
    }
}
