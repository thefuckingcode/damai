package com.youku.arch.v3.util;

import android.os.SystemClock;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IdGenerator {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final SnowflakeIdWorker sIdWorker = new SnowflakeIdWorker(0, 0);

    /* compiled from: Taobao */
    public static class SnowflakeIdWorker {
        private static transient /* synthetic */ IpChange $ipChange;
        private long datacenterId;
        private final long datacenterIdBits = 5;
        private final long datacenterIdShift = 17;
        private long lastTimestamp = -1;
        private final long maxDatacenterId = 31;
        private final long maxWorkerId = 31;
        private long sequence = 0;
        private final long sequenceBits = 12;
        private final long sequenceMask = 4095;
        private final long startTime = System.currentTimeMillis();
        private final long timestampLeftShift = 22;
        private final long twepoch = 1514736000000L;
        private long workerId;
        private final long workerIdBits = 5;
        private final long workerIdShift = 12;

        public SnowflakeIdWorker(long j, long j2) {
            if (j > 31 || j < 0) {
                throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", 31L));
            } else if (j2 > 31 || j2 < 0) {
                throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", 31L));
            } else {
                this.workerId = j;
                this.datacenterId = j2;
            }
        }

        public synchronized long nextId() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "348010682")) {
                return ((Long) ipChange.ipc$dispatch("348010682", new Object[]{this})).longValue();
            }
            long timeGen = timeGen();
            long j = this.lastTimestamp;
            if (timeGen >= j) {
                if (j == timeGen) {
                    long j2 = (this.sequence + 1) & 4095;
                    this.sequence = j2;
                    if (j2 == 0) {
                        timeGen = tilNextMillis(j);
                    }
                } else {
                    this.sequence = 0;
                }
                this.lastTimestamp = timeGen;
                return ((timeGen - 1514736000000L) << 22) | (this.datacenterId << 17) | (this.workerId << 12) | this.sequence;
            }
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds，lastTimestamp is %d, now is ", Long.valueOf(this.lastTimestamp - timeGen), Long.valueOf(this.lastTimestamp), Long.valueOf(timeGen)));
        }

        /* access modifiers changed from: protected */
        public long tilNextMillis(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-432452238")) {
                return ((Long) ipChange.ipc$dispatch("-432452238", new Object[]{this, Long.valueOf(j)})).longValue();
            }
            long timeGen = timeGen();
            while (timeGen <= j) {
                timeGen = timeGen();
            }
            return timeGen;
        }

        /* access modifiers changed from: protected */
        public long timeGen() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-93516889")) {
                return this.startTime + SystemClock.elapsedRealtime();
            }
            return ((Long) ipChange.ipc$dispatch("-93516889", new Object[]{this})).longValue();
        }
    }

    public static long getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1399789856") ? ((Long) ipChange.ipc$dispatch("-1399789856", new Object[0])).longValue() : sIdWorker.nextId();
    }
}
