package com.taobao.tao.log.godeye.core.module;

import android.os.Build;
import java.io.Serializable;

/* compiled from: Taobao */
public class GodEyeAppInfo {
    public BatteryInfo batteryInfo = new BatteryInfo();
    public CpuStat cpuStat = new CpuStat();
    public DeviceInfo deviceInfo = new DeviceInfo();
    public IOStat iOStat = new IOStat();
    public PerformanceInfo performanceInfo = new PerformanceInfo();
    public TrafficStatsInfo trafficStatsInfo = new TrafficStatsInfo();

    /* compiled from: Taobao */
    public static class BatteryInfo implements Serializable {
        public int batteryHealth;
        public int batteryPercent;
        public int batteryStatus;
        public double batteryTemp;
        public int batteryV;
    }

    /* compiled from: Taobao */
    public static class CpuStat implements Serializable {
        public boolean cpuAlarmInBg;
        public int iOWaitTimeAvg;
        public float mPidPerCpuLoadAvg;
        public int myAVGPidCPUPercent;
        public int myMaxPidCPUPercent;
        public int myPidCPUPercent;
        public int pidIoWaitCount;
        public int sysAvgCPUPercent;
        public int sysCPUPercent;
        public int sysMaxCPUPercent;
        public float systemLoadAvg;
    }

    /* compiled from: Taobao */
    public static class DeviceInfo implements Serializable {
        public int apiLevel = Build.VERSION.SDK_INT;
        public String cpuBrand;
        public float[] cpuFreqArray;
        public float cpuMaxFreq;
        public float cpuMinFreq;
        public String cpuModel;
        public int cpuProcessCount;
        public float density;
        public long deviceTotalMemory;
        public String gpuBrand;
        public long gpuMaxFreq;
        public String gpuModel;
        public boolean isRooted;
        public int memoryThreshold;
        public String mobileBrand = Build.BRAND;
        public String mobileModel = Build.MODEL;
        public int screenHeght;
        public int screenWidth;
        public int storeFreesize;
        public int storeTotalSize;
    }

    /* compiled from: Taobao */
    public static class IOStat implements Serializable {
        public int avgIOWaitTime;
        public int currentIOWaitTime;
        public int openedFileCount;
    }

    /* compiled from: Taobao */
    public static class PerformanceInfo implements Serializable {
        public int anrCount;
        public int appProgressImportance;
        public int cpuPerformance;
        public int deviceScore;
        public int ioPerformance;
        public boolean isLowPerformance;
        public int memPerformance;
        public int myPidScore = 0;
        public int runTimeThreadCount;
        public int runningThreadCount;
        public int schedPerformance;
        public int sysRunningProgress;
        public int sysRunningService;
        public int systemRunningScore = 0;
        public int threadCount;
    }

    /* compiled from: Taobao */
    public static class TrafficStatsInfo implements Serializable {
        public float activityMobileRxBytes;
        public float activityMobileTxBytes;
        public float activityTotalRxBytes;
        public float activityTotalTxBytes;
        public float totalMobileRxBytes;
        public float totalMobileTxBytes;
        public float totalTotalRxBytes;
        public float totalTotalTxBytes;
    }
}
