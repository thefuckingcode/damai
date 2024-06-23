package com.youku.live.widgets.model.template;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.arch.CloneUtils;
import com.youku.live.widgets.protocol.IDeepClonable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class WidgetAttributesModel implements IDeepClonable<WidgetAttributesModel> {
    private static transient /* synthetic */ IpChange $ipChange;
    public Map<String, String> extra;
    public OrientationModel landscape;
    public OrientationModel portrait;

    /* compiled from: Taobao */
    public static class DimensionsModel implements IDeepClonable<DimensionsModel> {
        public Integer h;
        public Integer w;

        @Override // com.youku.live.widgets.protocol.IDeepClonable
        public DimensionsModel deepClone() {
            DimensionsModel dimensionsModel = new DimensionsModel();
            dimensionsModel.w = CloneUtils.clone(this.w);
            dimensionsModel.h = CloneUtils.clone(this.h);
            return dimensionsModel;
        }
    }

    /* compiled from: Taobao */
    public static class MarginModel implements IDeepClonable<MarginModel> {
        public Integer b;
        public boolean hasAppendSafeArea = false;
        public Integer l;
        public Integer r;
        public Integer t;

        @Override // com.youku.live.widgets.protocol.IDeepClonable
        public MarginModel deepClone() {
            MarginModel marginModel = new MarginModel();
            marginModel.t = CloneUtils.clone(this.t);
            marginModel.l = CloneUtils.clone(this.l);
            marginModel.b = CloneUtils.clone(this.b);
            marginModel.r = CloneUtils.clone(this.r);
            return marginModel;
        }
    }

    /* compiled from: Taobao */
    public static class OrientationModel implements IDeepClonable<OrientationModel> {
        public static final String UNIT_DP = "pt";
        public Double aspectRatio;
        public DimensionsModel dimensions;
        public MarginModel margin;
        public Boolean safeArea;
        public String unit;
        public Boolean visible = Boolean.TRUE;

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00be  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x00d7  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x00f4  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x011f  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0129  */
        public RectModel compute(int i, int i2, float f) {
            int i3;
            int i4;
            MarginModel marginModel;
            int i5;
            int i6;
            int i7;
            int i8;
            Boolean bool;
            Boolean bool2;
            Double d;
            double doubleValue;
            boolean z;
            int i9;
            DimensionsModel dimensionsModel = this.dimensions;
            if (dimensionsModel != null) {
                Integer num = dimensionsModel.w;
                i4 = num != null ? (int) (((float) num.intValue()) * f) : Integer.MAX_VALUE;
                Integer num2 = this.dimensions.h;
                if (num2 != null) {
                    i3 = (int) (((float) num2.intValue()) * f);
                    marginModel = this.margin;
                    boolean z2 = false;
                    if (marginModel == null) {
                        Integer num3 = marginModel.l;
                        i8 = num3 != null ? (int) (((float) num3.intValue()) * f) : Integer.MAX_VALUE;
                        Integer num4 = this.margin.t;
                        i7 = num4 != null ? (int) (((float) num4.intValue()) * f) : Integer.MAX_VALUE;
                        Integer num5 = this.margin.r;
                        i6 = num5 != null ? (int) (((float) num5.intValue()) * f) : Integer.MAX_VALUE;
                        Integer num6 = this.margin.b;
                        i5 = num6 != null ? (int) ((((float) num6.intValue()) * f) + 0.5f) : Integer.MAX_VALUE;
                    } else {
                        i5 = Integer.MAX_VALUE;
                        i8 = 0;
                        i7 = 0;
                        i6 = Integer.MAX_VALUE;
                    }
                    if (i4 != Integer.MAX_VALUE) {
                        if (i8 != Integer.MAX_VALUE && i6 != Integer.MAX_VALUE) {
                            i4 = (i - i6) - i8;
                            if (i3 == Integer.MAX_VALUE) {
                            }
                            i3 = i2;
                            i7 = 0;
                            if (i4 != Integer.MAX_VALUE) {
                            }
                            if (i3 != Integer.MAX_VALUE) {
                            }
                            boolean z3 = true;
                            doubleValue = d.doubleValue();
                            if (doubleValue > 0.0d) {
                            }
                            RectModel rectModel = new RectModel();
                            rectModel.pw = i;
                            rectModel.ph = i2;
                            rectModel.w = i4;
                            rectModel.h = i3;
                            rectModel.l = i8;
                            rectModel.t = i7;
                            bool = this.visible;
                            if (bool != null) {
                            }
                            rectModel.v = z3;
                            bool2 = this.safeArea;
                            if (bool2 != null) {
                            }
                            rectModel.sa = z2;
                            return rectModel;
                        } else if (i8 != Integer.MAX_VALUE) {
                            i4 = i - i8;
                            if (i3 == Integer.MAX_VALUE) {
                                if (i7 != Integer.MAX_VALUE && i5 != Integer.MAX_VALUE) {
                                    i3 = (i2 - i7) - i5;
                                    if (i4 != Integer.MAX_VALUE) {
                                    }
                                    if (i3 != Integer.MAX_VALUE) {
                                    }
                                    boolean z32 = true;
                                    doubleValue = d.doubleValue();
                                    if (doubleValue > 0.0d) {
                                    }
                                    RectModel rectModel2 = new RectModel();
                                    rectModel2.pw = i;
                                    rectModel2.ph = i2;
                                    rectModel2.w = i4;
                                    rectModel2.h = i3;
                                    rectModel2.l = i8;
                                    rectModel2.t = i7;
                                    bool = this.visible;
                                    if (bool != null) {
                                    }
                                    rectModel2.v = z32;
                                    bool2 = this.safeArea;
                                    if (bool2 != null) {
                                    }
                                    rectModel2.sa = z2;
                                    return rectModel2;
                                } else if (i7 != Integer.MAX_VALUE) {
                                    i3 = i2 - i7;
                                    if (i4 != Integer.MAX_VALUE) {
                                        i4 = 0;
                                    } else if (i4 > i) {
                                        i4 = i;
                                    }
                                    if (i3 != Integer.MAX_VALUE) {
                                        i3 = 0;
                                    } else if (i3 > i2) {
                                        i3 = i2;
                                    }
                                    boolean z322 = true;
                                    if (i4 > 0 && i3 > 0 && (d = this.aspectRatio) != null) {
                                        doubleValue = d.doubleValue();
                                        if (doubleValue > 0.0d) {
                                            int i10 = (int) ((((double) i4) / doubleValue) + 0.5d);
                                            if (i10 < i3) {
                                                i3 = i10;
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            if (!z && (i9 = (int) ((((double) i3) * doubleValue) + 0.5d)) < i4) {
                                                i4 = i9;
                                            }
                                        }
                                    }
                                    RectModel rectModel22 = new RectModel();
                                    rectModel22.pw = i;
                                    rectModel22.ph = i2;
                                    rectModel22.w = i4;
                                    rectModel22.h = i3;
                                    rectModel22.l = i8;
                                    rectModel22.t = i7;
                                    bool = this.visible;
                                    if (bool != null) {
                                        z322 = bool.booleanValue();
                                    }
                                    rectModel22.v = z322;
                                    bool2 = this.safeArea;
                                    if (bool2 != null) {
                                        z2 = bool2.booleanValue();
                                    }
                                    rectModel22.sa = z2;
                                    return rectModel22;
                                } else if (i5 != Integer.MAX_VALUE) {
                                    i3 = i2 - i5;
                                    i7 = 0;
                                    if (i4 != Integer.MAX_VALUE) {
                                    }
                                    if (i3 != Integer.MAX_VALUE) {
                                    }
                                    boolean z3222 = true;
                                    doubleValue = d.doubleValue();
                                    if (doubleValue > 0.0d) {
                                    }
                                    RectModel rectModel222 = new RectModel();
                                    rectModel222.pw = i;
                                    rectModel222.ph = i2;
                                    rectModel222.w = i4;
                                    rectModel222.h = i3;
                                    rectModel222.l = i8;
                                    rectModel222.t = i7;
                                    bool = this.visible;
                                    if (bool != null) {
                                    }
                                    rectModel222.v = z3222;
                                    bool2 = this.safeArea;
                                    if (bool2 != null) {
                                    }
                                    rectModel222.sa = z2;
                                    return rectModel222;
                                }
                            } else if (i7 == Integer.MAX_VALUE || i5 == Integer.MAX_VALUE) {
                                if (i7 == Integer.MAX_VALUE) {
                                    if (i5 != Integer.MAX_VALUE) {
                                        i7 = (i2 - i5) - i3;
                                    }
                                }
                                if (i4 != Integer.MAX_VALUE) {
                                }
                                if (i3 != Integer.MAX_VALUE) {
                                }
                                boolean z32222 = true;
                                doubleValue = d.doubleValue();
                                if (doubleValue > 0.0d) {
                                }
                                RectModel rectModel2222 = new RectModel();
                                rectModel2222.pw = i;
                                rectModel2222.ph = i2;
                                rectModel2222.w = i4;
                                rectModel2222.h = i3;
                                rectModel2222.l = i8;
                                rectModel2222.t = i7;
                                bool = this.visible;
                                if (bool != null) {
                                }
                                rectModel2222.v = z32222;
                                bool2 = this.safeArea;
                                if (bool2 != null) {
                                }
                                rectModel2222.sa = z2;
                                return rectModel2222;
                            } else {
                                i3 = (i - i5) - i7;
                                if (i4 != Integer.MAX_VALUE) {
                                }
                                if (i3 != Integer.MAX_VALUE) {
                                }
                                boolean z322222 = true;
                                doubleValue = d.doubleValue();
                                if (doubleValue > 0.0d) {
                                }
                                RectModel rectModel22222 = new RectModel();
                                rectModel22222.pw = i;
                                rectModel22222.ph = i2;
                                rectModel22222.w = i4;
                                rectModel22222.h = i3;
                                rectModel22222.l = i8;
                                rectModel22222.t = i7;
                                bool = this.visible;
                                if (bool != null) {
                                }
                                rectModel22222.v = z322222;
                                bool2 = this.safeArea;
                                if (bool2 != null) {
                                }
                                rectModel22222.sa = z2;
                                return rectModel22222;
                            }
                            i3 = i2;
                            i7 = 0;
                            if (i4 != Integer.MAX_VALUE) {
                            }
                            if (i3 != Integer.MAX_VALUE) {
                            }
                            boolean z3222222 = true;
                            doubleValue = d.doubleValue();
                            if (doubleValue > 0.0d) {
                            }
                            RectModel rectModel222222 = new RectModel();
                            rectModel222222.pw = i;
                            rectModel222222.ph = i2;
                            rectModel222222.w = i4;
                            rectModel222222.h = i3;
                            rectModel222222.l = i8;
                            rectModel222222.t = i7;
                            bool = this.visible;
                            if (bool != null) {
                            }
                            rectModel222222.v = z3222222;
                            bool2 = this.safeArea;
                            if (bool2 != null) {
                            }
                            rectModel222222.sa = z2;
                            return rectModel222222;
                        } else if (i6 != Integer.MAX_VALUE) {
                            i4 = i - i6;
                            i8 = 0;
                            if (i3 == Integer.MAX_VALUE) {
                            }
                            i3 = i2;
                            i7 = 0;
                            if (i4 != Integer.MAX_VALUE) {
                            }
                            if (i3 != Integer.MAX_VALUE) {
                            }
                            boolean z32222222 = true;
                            doubleValue = d.doubleValue();
                            if (doubleValue > 0.0d) {
                            }
                            RectModel rectModel2222222 = new RectModel();
                            rectModel2222222.pw = i;
                            rectModel2222222.ph = i2;
                            rectModel2222222.w = i4;
                            rectModel2222222.h = i3;
                            rectModel2222222.l = i8;
                            rectModel2222222.t = i7;
                            bool = this.visible;
                            if (bool != null) {
                            }
                            rectModel2222222.v = z32222222;
                            bool2 = this.safeArea;
                            if (bool2 != null) {
                            }
                            rectModel2222222.sa = z2;
                            return rectModel2222222;
                        }
                    } else if (i8 == Integer.MAX_VALUE || i6 == Integer.MAX_VALUE) {
                        if (i8 == Integer.MAX_VALUE) {
                            if (i6 != Integer.MAX_VALUE) {
                                i8 = (i - i6) - i4;
                            }
                        }
                        if (i3 == Integer.MAX_VALUE) {
                        }
                        i3 = i2;
                        i7 = 0;
                        if (i4 != Integer.MAX_VALUE) {
                        }
                        if (i3 != Integer.MAX_VALUE) {
                        }
                        boolean z322222222 = true;
                        doubleValue = d.doubleValue();
                        if (doubleValue > 0.0d) {
                        }
                        RectModel rectModel22222222 = new RectModel();
                        rectModel22222222.pw = i;
                        rectModel22222222.ph = i2;
                        rectModel22222222.w = i4;
                        rectModel22222222.h = i3;
                        rectModel22222222.l = i8;
                        rectModel22222222.t = i7;
                        bool = this.visible;
                        if (bool != null) {
                        }
                        rectModel22222222.v = z322222222;
                        bool2 = this.safeArea;
                        if (bool2 != null) {
                        }
                        rectModel22222222.sa = z2;
                        return rectModel22222222;
                    } else {
                        i4 = (i - i8) - i6;
                        if (i3 == Integer.MAX_VALUE) {
                        }
                        i3 = i2;
                        i7 = 0;
                        if (i4 != Integer.MAX_VALUE) {
                        }
                        if (i3 != Integer.MAX_VALUE) {
                        }
                        boolean z3222222222 = true;
                        doubleValue = d.doubleValue();
                        if (doubleValue > 0.0d) {
                        }
                        RectModel rectModel222222222 = new RectModel();
                        rectModel222222222.pw = i;
                        rectModel222222222.ph = i2;
                        rectModel222222222.w = i4;
                        rectModel222222222.h = i3;
                        rectModel222222222.l = i8;
                        rectModel222222222.t = i7;
                        bool = this.visible;
                        if (bool != null) {
                        }
                        rectModel222222222.v = z3222222222;
                        bool2 = this.safeArea;
                        if (bool2 != null) {
                        }
                        rectModel222222222.sa = z2;
                        return rectModel222222222;
                    }
                    i4 = i;
                    i8 = 0;
                    if (i3 == Integer.MAX_VALUE) {
                    }
                    i3 = i2;
                    i7 = 0;
                    if (i4 != Integer.MAX_VALUE) {
                    }
                    if (i3 != Integer.MAX_VALUE) {
                    }
                    boolean z32222222222 = true;
                    doubleValue = d.doubleValue();
                    if (doubleValue > 0.0d) {
                    }
                    RectModel rectModel2222222222 = new RectModel();
                    rectModel2222222222.pw = i;
                    rectModel2222222222.ph = i2;
                    rectModel2222222222.w = i4;
                    rectModel2222222222.h = i3;
                    rectModel2222222222.l = i8;
                    rectModel2222222222.t = i7;
                    bool = this.visible;
                    if (bool != null) {
                    }
                    rectModel2222222222.v = z32222222222;
                    bool2 = this.safeArea;
                    if (bool2 != null) {
                    }
                    rectModel2222222222.sa = z2;
                    return rectModel2222222222;
                }
            } else {
                i4 = Integer.MAX_VALUE;
            }
            i3 = Integer.MAX_VALUE;
            marginModel = this.margin;
            boolean z22 = false;
            if (marginModel == null) {
            }
            if (i4 != Integer.MAX_VALUE) {
            }
            i4 = i;
            i8 = 0;
            if (i3 == Integer.MAX_VALUE) {
            }
            i3 = i2;
            i7 = 0;
            if (i4 != Integer.MAX_VALUE) {
            }
            if (i3 != Integer.MAX_VALUE) {
            }
            boolean z322222222222 = true;
            doubleValue = d.doubleValue();
            if (doubleValue > 0.0d) {
            }
            RectModel rectModel22222222222 = new RectModel();
            rectModel22222222222.pw = i;
            rectModel22222222222.ph = i2;
            rectModel22222222222.w = i4;
            rectModel22222222222.h = i3;
            rectModel22222222222.l = i8;
            rectModel22222222222.t = i7;
            bool = this.visible;
            if (bool != null) {
            }
            rectModel22222222222.v = z322222222222;
            bool2 = this.safeArea;
            if (bool2 != null) {
            }
            rectModel22222222222.sa = z22;
            return rectModel22222222222;
        }

        public boolean useDp() {
            return TextUtils.equals(this.unit, "pt");
        }

        @Override // com.youku.live.widgets.protocol.IDeepClonable
        public OrientationModel deepClone() {
            OrientationModel orientationModel = new OrientationModel();
            MarginModel marginModel = this.margin;
            DimensionsModel dimensionsModel = null;
            orientationModel.margin = marginModel != null ? marginModel.deepClone() : null;
            DimensionsModel dimensionsModel2 = this.dimensions;
            if (dimensionsModel2 != null) {
                dimensionsModel = dimensionsModel2.deepClone();
            }
            orientationModel.dimensions = dimensionsModel;
            orientationModel.aspectRatio = CloneUtils.clone(this.aspectRatio);
            orientationModel.visible = CloneUtils.clone(this.visible);
            orientationModel.safeArea = CloneUtils.clone(this.safeArea);
            orientationModel.unit = (String) CloneUtils.clone(this.unit);
            return orientationModel;
        }
    }

    /* compiled from: Taobao */
    public static class RectModel {
        public int h;
        public int l;
        public int ph;
        public int pw;
        public boolean sa;
        public int sath;
        public int t;
        public boolean v;
        public int w;
    }

    @Override // com.youku.live.widgets.protocol.IDeepClonable
    public WidgetAttributesModel deepClone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1435075665")) {
            return (WidgetAttributesModel) ipChange.ipc$dispatch("1435075665", new Object[]{this});
        }
        WidgetAttributesModel widgetAttributesModel = new WidgetAttributesModel();
        widgetAttributesModel.portrait = (OrientationModel) CloneUtils.clone(this.portrait);
        widgetAttributesModel.landscape = (OrientationModel) CloneUtils.clone(this.landscape);
        if (this.extra != null) {
            HashMap hashMap = new HashMap();
            widgetAttributesModel.extra = hashMap;
            hashMap.putAll(this.extra);
        }
        return widgetAttributesModel;
    }
}
