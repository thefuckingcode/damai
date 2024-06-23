package me.ele.altriax.launcher.biz.strategy.intent;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Message;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.lang.reflect.Field;

/* compiled from: Taobao */
public class AltriaXLaunchManagerUnder9 extends AltriaXLaunchManager {
    private static Field activityInfoField;
    private static Field intentField;
    private static Field referrerField;

    static {
        Class<?> cls = null;
        try {
            cls = Class.forName("android.app.ActivityThread$ActivityClientRecord");
            Field declaredField = cls.getDeclaredField(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            intentField = declaredField;
            declaredField.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchFieldException unused) {
        }
        if (cls != null) {
            try {
                Field declaredField2 = cls.getDeclaredField("referrer");
                referrerField = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            try {
                Field declaredField3 = cls.getDeclaredField("activityInfo");
                activityInfoField = declaredField3;
                declaredField3.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029 A[SYNTHETIC, Splitter:B:18:0x0029] */
    @Override // me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManager
    public AltriaXLaunchContext resolveMessage(Message message) {
        Field field;
        Intent intent;
        String str;
        Field field2;
        String str2;
        String str3;
        String str4 = null;
        if (message.what != 100 || (field = intentField) == null) {
            return null;
        }
        try {
            intent = (Intent) field.get(message.obj);
        } catch (IllegalAccessException unused) {
            intent = null;
        }
        Field field3 = referrerField;
        if (field3 != null) {
            try {
                str = (String) field3.get(message.obj);
            } catch (IllegalAccessException unused2) {
            }
            field2 = activityInfoField;
            if (field2 != null) {
                try {
                    ActivityInfo activityInfo = (ActivityInfo) field2.get(message.obj);
                    if (activityInfo != null) {
                        str3 = activityInfo.processName;
                        try {
                            str2 = activityInfo.packageName;
                        } catch (IllegalAccessException unused3) {
                        }
                        str4 = str3;
                        return new AltriaXLaunchContext(str4, str2, str, intent);
                    }
                } catch (IllegalAccessException unused4) {
                    str3 = null;
                    str2 = null;
                    str4 = str3;
                    return new AltriaXLaunchContext(str4, str2, str, intent);
                }
            }
            str2 = null;
            return new AltriaXLaunchContext(str4, str2, str, intent);
        }
        str = null;
        field2 = activityInfoField;
        if (field2 != null) {
        }
        str2 = null;
        return new AltriaXLaunchContext(str4, str2, str, intent);
    }
}
