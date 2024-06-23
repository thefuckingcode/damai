package android.taobao.windvane.util;

import android.os.Environment;

/* compiled from: Taobao */
public class StorageMgr {
    public static final int ERROR = -1;

    public static boolean checkSDCard() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if (externalStorageState == null || !externalStorageState.equals("mounted")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
