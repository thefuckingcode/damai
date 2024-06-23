package me.ele.altriax.launcher.biz.strategy.intent;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Message;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: Taobao */
public class AltriaXLaunchManager9OrAbove extends AltriaXLaunchManager {
    private static final String NAME_CLIENT_TRANSACTION = "android.app.servertransaction.ClientTransaction";
    private static final String NAME_LAUNCH_ACTIVITY_ITEM = "android.app.servertransaction.LaunchActivityItem";
    private static Field activityCallbacksField;
    private static Field activityInfoField;
    private static Field intentField;
    private static Field referrerField;

    static {
        Class<?> cls;
        try {
            Field declaredField = Class.forName(NAME_CLIENT_TRANSACTION).getDeclaredField("mActivityCallbacks");
            activityCallbacksField = declaredField;
            declaredField.setAccessible(true);
            cls = Class.forName(NAME_LAUNCH_ACTIVITY_ITEM);
            Field declaredField2 = cls.getDeclaredField("mIntent");
            intentField = declaredField2;
            declaredField2.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchFieldException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                Field declaredField3 = cls.getDeclaredField("mReferrer");
                referrerField = declaredField3;
                declaredField3.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            try {
                Field declaredField4 = cls.getDeclaredField("mInfo");
                activityInfoField = declaredField4;
                declaredField4.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060 A[SYNTHETIC, Splitter:B:32:0x0060] */
    @Override // me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManager
    public AltriaXLaunchContext resolveMessage(Message message) {
        Field field;
        String str;
        String str2;
        Field field2;
        String str3;
        if (!(message.what != 159 || (field = activityCallbacksField) == null || intentField == null)) {
            try {
                List list = (List) field.get(message.obj);
                if (list != null && list.size() > 0) {
                    for (Object obj : list) {
                        if (NAME_LAUNCH_ACTIVITY_ITEM.equals(obj.getClass().getName())) {
                            Intent intent = (Intent) intentField.get(obj);
                            Field field3 = activityInfoField;
                            if (field3 != null) {
                                try {
                                    ActivityInfo activityInfo = (ActivityInfo) field3.get(obj);
                                    if (activityInfo != null) {
                                        str = activityInfo.processName;
                                        try {
                                            str2 = activityInfo.packageName;
                                        } catch (IllegalAccessException unused) {
                                        }
                                        field2 = referrerField;
                                        if (field2 != null) {
                                            try {
                                                str3 = (String) field2.get(obj);
                                            } catch (IllegalAccessException unused2) {
                                            }
                                            return new AltriaXLaunchContext(str, str2, str3, intent);
                                        }
                                        str3 = null;
                                        return new AltriaXLaunchContext(str, str2, str3, intent);
                                    }
                                } catch (IllegalAccessException unused3) {
                                    str = null;
                                    str2 = null;
                                    field2 = referrerField;
                                    if (field2 != null) {
                                    }
                                    str3 = null;
                                    return new AltriaXLaunchContext(str, str2, str3, intent);
                                }
                            }
                            str2 = null;
                            str = null;
                            field2 = referrerField;
                            if (field2 != null) {
                            }
                            str3 = null;
                            return new AltriaXLaunchContext(str, str2, str3, intent);
                        }
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
        return null;
    }
}
