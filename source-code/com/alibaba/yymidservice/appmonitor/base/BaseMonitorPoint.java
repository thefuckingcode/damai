package com.alibaba.yymidservice.appmonitor.base;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bh0;
import tb.k21;

/* compiled from: Taobao */
public abstract class BaseMonitorPoint {
    public String mPointName;
    @Nullable
    private MonitorType mPointType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/alibaba/yymidservice/appmonitor/base/BaseMonitorPoint$MonitorType;", "", "", "eventId", "I", "getEventId", "()I", "<init>", "(Ljava/lang/String;II)V", "UT_PAGE", "UT_CLICK", "UT_EXPOSURE", "UT_CUSTOM", "APP_MONITOR", "yymidservice_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public enum MonitorType {
        UT_PAGE(2001),
        UT_CLICK(2101),
        UT_EXPOSURE(2201),
        UT_CUSTOM(3001),
        APP_MONITOR(4001);
        
        private final int eventId;

        private MonitorType(int i) {
            this.eventId = i;
        }

        public final int getEventId() {
            return this.eventId;
        }
    }

    public BaseMonitorPoint() {
        onCreate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0014 A[SYNTHETIC] */
    @NotNull
    public Map<String, String> checkAndCreateParamsMap() {
        String str;
        HashMap hashMap = new HashMap();
        Field[] declaredFields = getClass().getDeclaredFields();
        k21.h(declaredFields, "this.javaClass.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            if (!(field == null || ((MonitorKeyMark) field.getAnnotation(MonitorKeyMark.class)) == null)) {
                try {
                    field.setAccessible(true);
                    Object obj = field.get(this);
                    if (obj != null) {
                        if (!(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Boolean) && !(obj instanceof Short) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Float)) {
                            if (!(obj instanceof Double)) {
                                if (obj instanceof String) {
                                    str = (String) obj;
                                } else {
                                    str = bh0.INSTANCE.e(obj);
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    String name = field.getName();
                                    k21.h(name, "field.name");
                                    hashMap.put(name, str);
                                }
                            }
                        }
                        str = obj.toString();
                        if (!TextUtils.isEmpty(str)) {
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                str = "";
                if (!TextUtils.isEmpty(str)) {
                }
            }
        }
        return hashMap;
    }

    @NotNull
    public final String getMPointName() {
        String str = this.mPointName;
        if (str != null) {
            return str;
        }
        k21.A("mPointName");
        return null;
    }

    @Nullable
    public final MonitorType getMPointType() {
        return this.mPointType;
    }

    @NotNull
    public abstract String getPointName();

    @NotNull
    public abstract MonitorType getPointType();

    /* access modifiers changed from: protected */
    public void onCreate() {
        setMPointName(getPointName());
        this.mPointType = getPointType();
    }

    public abstract void release();

    public final void setMPointName(@NotNull String str) {
        k21.i(str, "<set-?>");
        this.mPointName = str;
    }

    public final void setMPointType(@Nullable MonitorType monitorType) {
        this.mPointType = monitorType;
    }
}
