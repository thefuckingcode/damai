package com.caverock.androidsvg;

/* compiled from: Taobao */
public class PreserveAspectRatio {
    public static final PreserveAspectRatio BOTTOM;
    public static final PreserveAspectRatio END;
    public static final PreserveAspectRatio FULLSCREEN;
    public static final PreserveAspectRatio FULLSCREEN_START;
    public static final PreserveAspectRatio LETTERBOX;
    public static final PreserveAspectRatio START;
    public static final PreserveAspectRatio STRETCH = new PreserveAspectRatio(Alignment.none, null);
    public static final PreserveAspectRatio TOP;
    public static final PreserveAspectRatio UNSCALED = new PreserveAspectRatio(null, null);
    private Alignment a;
    private Scale b;

    /* compiled from: Taobao */
    public enum Alignment {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    /* compiled from: Taobao */
    public enum Scale {
        meet,
        slice
    }

    static {
        Alignment alignment = Alignment.xMidYMid;
        Scale scale = Scale.meet;
        LETTERBOX = new PreserveAspectRatio(alignment, scale);
        Alignment alignment2 = Alignment.xMinYMin;
        START = new PreserveAspectRatio(alignment2, scale);
        END = new PreserveAspectRatio(Alignment.xMaxYMax, scale);
        TOP = new PreserveAspectRatio(Alignment.xMidYMin, scale);
        BOTTOM = new PreserveAspectRatio(Alignment.xMidYMax, scale);
        Scale scale2 = Scale.slice;
        FULLSCREEN = new PreserveAspectRatio(alignment, scale2);
        FULLSCREEN_START = new PreserveAspectRatio(alignment2, scale2);
    }

    PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.a = alignment;
        this.b = scale;
    }

    public Alignment a() {
        return this.a;
    }

    public Scale b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PreserveAspectRatio.class != obj.getClass()) {
            return false;
        }
        PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
        if (this.a == preserveAspectRatio.a && this.b == preserveAspectRatio.b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.a + " " + this.b;
    }
}
