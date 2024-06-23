package com.scwang.smartrefresh.layout.constant;

public class DimensionStatus {
    public static final DimensionStatus CodeExact;
    public static final DimensionStatus CodeExactUnNotify;
    public static final DimensionStatus DeadLock;
    public static final DimensionStatus DeadLockUnNotify;
    public static final DimensionStatus Default;
    public static final DimensionStatus DefaultUnNotify;
    public static final DimensionStatus XmlExact;
    public static final DimensionStatus XmlExactUnNotify;
    public static final DimensionStatus XmlLayout;
    public static final DimensionStatus XmlLayoutUnNotify;
    public static final DimensionStatus XmlWrap;
    public static final DimensionStatus XmlWrapUnNotify;
    public static final DimensionStatus[] values;
    public final boolean notified;
    public final int ordinal;

    static {
        DimensionStatus dimensionStatus = new DimensionStatus(0, false);
        DefaultUnNotify = dimensionStatus;
        DimensionStatus dimensionStatus2 = new DimensionStatus(1, true);
        Default = dimensionStatus2;
        DimensionStatus dimensionStatus3 = new DimensionStatus(2, false);
        XmlWrapUnNotify = dimensionStatus3;
        DimensionStatus dimensionStatus4 = new DimensionStatus(3, true);
        XmlWrap = dimensionStatus4;
        DimensionStatus dimensionStatus5 = new DimensionStatus(4, false);
        XmlExactUnNotify = dimensionStatus5;
        DimensionStatus dimensionStatus6 = new DimensionStatus(5, true);
        XmlExact = dimensionStatus6;
        DimensionStatus dimensionStatus7 = new DimensionStatus(6, false);
        XmlLayoutUnNotify = dimensionStatus7;
        DimensionStatus dimensionStatus8 = new DimensionStatus(7, true);
        XmlLayout = dimensionStatus8;
        DimensionStatus dimensionStatus9 = new DimensionStatus(8, false);
        CodeExactUnNotify = dimensionStatus9;
        DimensionStatus dimensionStatus10 = new DimensionStatus(9, true);
        CodeExact = dimensionStatus10;
        DimensionStatus dimensionStatus11 = new DimensionStatus(10, false);
        DeadLockUnNotify = dimensionStatus11;
        DimensionStatus dimensionStatus12 = new DimensionStatus(10, true);
        DeadLock = dimensionStatus12;
        values = new DimensionStatus[]{dimensionStatus, dimensionStatus2, dimensionStatus3, dimensionStatus4, dimensionStatus5, dimensionStatus6, dimensionStatus7, dimensionStatus8, dimensionStatus9, dimensionStatus10, dimensionStatus11, dimensionStatus12};
    }

    private DimensionStatus(int i, boolean z) {
        this.ordinal = i;
        this.notified = z;
    }

    public DimensionStatus unNotify() {
        if (!this.notified) {
            return this;
        }
        DimensionStatus dimensionStatus = values[this.ordinal - 1];
        if (!dimensionStatus.notified) {
            return dimensionStatus;
        }
        return DefaultUnNotify;
    }

    public DimensionStatus notified() {
        return !this.notified ? values[this.ordinal + 1] : this;
    }

    public boolean canReplaceWith(DimensionStatus dimensionStatus) {
        int i = this.ordinal;
        int i2 = dimensionStatus.ordinal;
        return i < i2 || ((!this.notified || CodeExact == this) && i == i2);
    }
}
