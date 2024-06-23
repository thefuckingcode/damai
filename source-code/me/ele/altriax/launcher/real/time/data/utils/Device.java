package me.ele.altriax.launcher.real.time.data.utils;

/* compiled from: Taobao */
public class Device {
    private static final String DIMENSION_VALUE_DEVICE_HIGH = "high";
    private static final String DIMENSION_VALUE_DEVICE_LOW = "low";
    private static final String DIMENSION_VALUE_DEVICE_MEDIUM = "medium";
    private static final String DIMENSION_VALUE_DEVICE_UNKNOW = "unknow";

    public static String switchDeviceValue(int i) {
        return i != 0 ? i != 1 ? i != 2 ? DIMENSION_VALUE_DEVICE_UNKNOW : "low" : "medium" : "high";
    }
}
