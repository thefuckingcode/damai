package tb;

import android.os.Build;
import android.util.Log;
import com.ali.alihadeviceevaluator.old.CalScore;
import com.ali.alihadeviceevaluator.old.HardWareInfo;
import com.alibaba.security.realidentity.a.a;

/* compiled from: Taobao */
public class bu0 implements CalScore {
    String a;
    int b = 4;
    private String c = "SDM845,KIRIN970,MSM8998,EXYNOS8895";
    private String d = "MSM8997,HI3660";
    private String e = "MSM8996,MSM8996PRO,MSM8996 PRO,EXYNOS8890,MT6799";
    private String f = "SDM660,SDM630,MSM8994,MSM8992,HI3650,EXYNOS7420,VBOX86";
    private String g = "MSM8956,MSM8946,MT6797X,MT6797X,MT6797T,MT6797D";
    private String h = "APQ8084,MSM8084,MSM8953,HI3630,EXYNOS5433,HI3635,EXYNOS5";
    private String i = "MSM8X74,MSM8X74AA,MSM8X74AB,MSM8X74AC,MSM8674,MSM8274,MSM8074,EXYNOS5430,EXYNOS7870,EXYNOS7580,EXYNOS5433,MT679X,MT6797T,MT6797,EXYNOS5420,UNIVERSAL5420,RANCHU";
    private String j = "MT675X,MT6795,MT6755,MT6752,MT6753,EXYNOS5800,EXYNOS5422,EXYNOS5410,MSM8952,MSM8940,PXA1936,HI6210SFT";
    private String k = "EXYNOS5260,EXYNOS5250,MT6750,MT6735,MSM8939V2,MSM8937,MSM8929,APQ8064,MSM8917,EXYNOS52,K3V2+,REDHOOKBAY,PXA1908,SC9860,HI6620OEM";
    private String l = "MT6595,MT6592,MT6582,MSM8936,MSM8909,MSM8909V2,MSM8916V2,MSM8208,MSM8960T,MSM8260A,MSM8660A,MSM8960,MSM8X12,MSM8X10,MSM8X30,LC1860";
    private String m = "K3V2E,K3V2,MT6589,EXYNOS4210,EXYNOS4212,MSM8X25Q,MSM8X26,PXA1088,PXA1L88,MSM8260,MSM8660,MSM8625,MSM8225,MSM8655,APQ8055,MSM7230,MSM7630,GOLDFISH,MSM8255T,MSM8655T,MSM7627A,MSM7227A,MSM7627T,MSM7227T,MT6577T,MT6572M,MT6515M,MT6575,QSD8650,QSD8250,OMAP4470,SP8810,SC8810MT6516,MT6573,MT6513,S5PC100,S5L8900,HI3611,HI3620,OMAP4460,OMAP4440,OMAP4430,EXYNOS3475,EXYNOS3110";
    String[] n = {"K3V2E,K3V2,MT6589,EXYNOS4210,EXYNOS4212,MSM8X25Q,MSM8X26,PXA1088,PXA1L88,MSM8260,MSM8660,MSM8625,MSM8225,MSM8655,APQ8055,MSM7230,MSM7630,GOLDFISH,MSM8255T,MSM8655T,MSM7627A,MSM7227A,MSM7627T,MSM7227T,MT6577T,MT6572M,MT6515M,MT6575,QSD8650,QSD8250,OMAP4470,SP8810,SC8810MT6516,MT6573,MT6513,S5PC100,S5L8900,HI3611,HI3620,OMAP4460,OMAP4440,OMAP4430,EXYNOS3475,EXYNOS3110", "MT6595,MT6592,MT6582,MSM8936,MSM8909,MSM8909V2,MSM8916V2,MSM8208,MSM8960T,MSM8260A,MSM8660A,MSM8960,MSM8X12,MSM8X10,MSM8X30,LC1860", "EXYNOS5260,EXYNOS5250,MT6750,MT6735,MSM8939V2,MSM8937,MSM8929,APQ8064,MSM8917,EXYNOS52,K3V2+,REDHOOKBAY,PXA1908,SC9860,HI6620OEM", "MT675X,MT6795,MT6755,MT6752,MT6753,EXYNOS5800,EXYNOS5422,EXYNOS5410,MSM8952,MSM8940,PXA1936,HI6210SFT", "MSM8X74,MSM8X74AA,MSM8X74AB,MSM8X74AC,MSM8674,MSM8274,MSM8074,EXYNOS5430,EXYNOS7870,EXYNOS7580,EXYNOS5433,MT679X,MT6797T,MT6797,EXYNOS5420,UNIVERSAL5420,RANCHU", "APQ8084,MSM8084,MSM8953,HI3630,EXYNOS5433,HI3635,EXYNOS5", "MSM8956,MSM8946,MT6797X,MT6797X,MT6797T,MT6797D", "SDM660,SDM630,MSM8994,MSM8992,HI3650,EXYNOS7420,VBOX86", "MSM8996,MSM8996PRO,MSM8996 PRO,EXYNOS8890,MT6799", "MSM8997,HI3660", "SDM845,KIRIN970,MSM8998,EXYNOS8895"};

    /* access modifiers changed from: package-private */
    public int a(String str) {
        if (this.a == null) {
            return -1;
        }
        for (int length = this.n.length - 1; length >= 0; length--) {
            String str2 = this.n[length];
            if (str2 != null && str2.contains(str)) {
                Log.e("OnlineMonitor", "cpuModel=" + str + ",score=" + length);
                return length;
            }
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (r4 >= 1.0f) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00c1, code lost:
        if (r0 >= 1.0f) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00c3, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00f5, code lost:
        if (r0 >= 1.0f) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00f8, code lost:
        r2 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c5  */
    public int b(HardWareInfo hardWareInfo) {
        int i2;
        if (hardWareInfo == null) {
            return 0;
        }
        int i3 = hardWareInfo.f;
        int i4 = 8;
        if (i3 >= 8) {
            float f2 = hardWareInfo.g;
            if (f2 < 1.9f) {
                if (f2 < 1.8f) {
                    if (f2 < 1.7f) {
                        if (f2 < 1.5f) {
                            if (f2 < 1.4f) {
                                if (f2 < 1.3f) {
                                    if (f2 >= 1.2f) {
                                        i2 = 4;
                                        float f3 = hardWareInfo.k;
                                        if (i3 >= 8) {
                                            if (f3 < 1.6f) {
                                                if (f3 < 1.5f) {
                                                    if (f3 < 1.4f) {
                                                        if (f3 < 1.3f) {
                                                            if (f3 < 1.2f) {
                                                                if (f3 < 1.1f) {
                                                                }
                                                                i4 = 3;
                                                            }
                                                            i4 = 5;
                                                        }
                                                    }
                                                    return (i2 + i4) / 2;
                                                }
                                                i4 = 9;
                                                return (i2 + i4) / 2;
                                            }
                                            i4 = 10;
                                            return (i2 + i4) / 2;
                                        }
                                        if (f3 < 2.0f) {
                                            if (f3 < 1.8f) {
                                                if (f3 < 1.6f) {
                                                    if (f3 >= 1.5f) {
                                                        i4 = 7;
                                                    } else if (f3 < 1.4f) {
                                                        if (f3 < 1.3f) {
                                                            if (f3 >= 1.2f) {
                                                                i4 = 4;
                                                            } else {
                                                                if (f3 < 1.1f) {
                                                                }
                                                                i4 = 3;
                                                            }
                                                        }
                                                        i4 = 5;
                                                    }
                                                }
                                                return (i2 + i4) / 2;
                                            }
                                            i4 = 9;
                                            return (i2 + i4) / 2;
                                        }
                                        i4 = 10;
                                        return (i2 + i4) / 2;
                                        i4 = 6;
                                        return (i2 + i4) / 2;
                                    }
                                }
                                i2 = 5;
                                float f32 = hardWareInfo.k;
                                if (i3 >= 8) {
                                }
                                i4 = 6;
                                return (i2 + i4) / 2;
                            }
                            i2 = 6;
                            float f322 = hardWareInfo.k;
                            if (i3 >= 8) {
                            }
                            i4 = 6;
                            return (i2 + i4) / 2;
                        }
                        i2 = 7;
                        float f3222 = hardWareInfo.k;
                        if (i3 >= 8) {
                        }
                        i4 = 6;
                        return (i2 + i4) / 2;
                    }
                    i2 = 8;
                    float f32222 = hardWareInfo.k;
                    if (i3 >= 8) {
                    }
                    i4 = 6;
                    return (i2 + i4) / 2;
                }
                i2 = 9;
                float f322222 = hardWareInfo.k;
                if (i3 >= 8) {
                }
                i4 = 6;
                return (i2 + i4) / 2;
            }
        } else {
            float f4 = hardWareInfo.g;
            if (f4 < 2.4f) {
                if (f4 < 2.2f) {
                    if (f4 < 2.0f) {
                        if (f4 < 1.8f) {
                            if (f4 < 1.5f) {
                                if (f4 < 1.3f) {
                                    if (f4 < 1.2f) {
                                        if (f4 >= 1.0f) {
                                            i2 = 2;
                                            float f3222222 = hardWareInfo.k;
                                            if (i3 >= 8) {
                                            }
                                            i4 = 6;
                                            return (i2 + i4) / 2;
                                        }
                                        i2 = 1;
                                        float f32222222 = hardWareInfo.k;
                                        if (i3 >= 8) {
                                        }
                                        i4 = 6;
                                        return (i2 + i4) / 2;
                                    }
                                    i2 = 3;
                                    float f322222222 = hardWareInfo.k;
                                    if (i3 >= 8) {
                                    }
                                    i4 = 6;
                                    return (i2 + i4) / 2;
                                }
                                i2 = 5;
                                float f3222222222 = hardWareInfo.k;
                                if (i3 >= 8) {
                                }
                                i4 = 6;
                                return (i2 + i4) / 2;
                            }
                            i2 = 6;
                            float f32222222222 = hardWareInfo.k;
                            if (i3 >= 8) {
                            }
                            i4 = 6;
                            return (i2 + i4) / 2;
                        }
                        i2 = 7;
                        float f322222222222 = hardWareInfo.k;
                        if (i3 >= 8) {
                        }
                        i4 = 6;
                        return (i2 + i4) / 2;
                    }
                    i2 = 8;
                    float f3222222222222 = hardWareInfo.k;
                    if (i3 >= 8) {
                    }
                    i4 = 6;
                    return (i2 + i4) / 2;
                }
                i2 = 9;
                float f32222222222222 = hardWareInfo.k;
                if (i3 >= 8) {
                }
                i4 = 6;
                return (i2 + i4) / 2;
            }
        }
        i2 = 10;
        float f322222222222222 = hardWareInfo.k;
        if (i3 >= 8) {
        }
        i4 = 6;
        return (i2 + i4) / 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01b3, code lost:
        if (r0 >= 2) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01c8, code lost:
        if (r0 >= 2) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fb, code lost:
        if (r0 >= 2) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014f, code lost:
        if (r0 >= 2) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0177, code lost:
        if (r1 >= 2) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0185, code lost:
        if (r0 >= 2) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0194, code lost:
        if (r0 >= 2) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a4, code lost:
        if (r0 >= 2) goto L_0x01b5;
     */
    @Override // com.ali.alihadeviceevaluator.old.CalScore
    public int getScore(HardWareInfo hardWareInfo) {
        int i2 = 0;
        if (hardWareInfo == null) {
            return 0;
        }
        this.b = hardWareInfo.f;
        String str = hardWareInfo.e;
        this.a = str;
        if (str == null) {
            return 0;
        }
        int a2 = a(str);
        if (a2 < 0) {
            if (this.a.startsWith("MSM") && this.a.length() > 5) {
                a2 = a(this.a.substring(0, 4) + "X" + this.a.substring(5));
            } else if (this.a.startsWith("MT")) {
                String str2 = this.a;
                char charAt = str2.charAt(str2.length() - 1);
                if (charAt >= '0' && charAt <= '9') {
                    StringBuilder sb = new StringBuilder();
                    String str3 = this.a;
                    sb.append(str3.substring(0, str3.length() - 1));
                    sb.append("X");
                    a2 = a(sb.toString());
                }
            }
        }
        if (a2 >= 0) {
            return a2;
        }
        String upperCase = Build.HARDWARE.toUpperCase();
        if (upperCase == null) {
            upperCase = "";
        }
        if (upperCase.contains("MSM") || upperCase.contains("EXYNOS8") || upperCase.contains("KIRIN")) {
            int i3 = this.b;
            if (i3 >= 10) {
                i2 = 10;
                return ((i2 * 2) + b(hardWareInfo)) / 3;
            } else if (i3 < 8) {
                if (i3 < 4) {
                }
                i2 = 8;
                return ((i2 * 2) + b(hardWareInfo)) / 3;
            }
        } else {
            if (upperCase.contains("SDM") || upperCase.contains("EXYNOS7") || upperCase.contains("HI")) {
                int i4 = this.b;
                if (i4 < 10) {
                    if (i4 < 8) {
                        if (i4 < 4) {
                        }
                    }
                    i2 = 8;
                    return ((i2 * 2) + b(hardWareInfo)) / 3;
                }
            } else {
                if (upperCase.contains("QCOM") || upperCase.contains("QUALCOMM") || upperCase.contains("APQ")) {
                    int i5 = this.b;
                    if (i5 < 10) {
                        if (i5 < 8) {
                            if (i5 < 4) {
                            }
                        }
                    }
                    i2 = 8;
                    return ((i2 * 2) + b(hardWareInfo)) / 3;
                }
                if (upperCase.contains("MOOREFIELD")) {
                    int i6 = this.b;
                    if (i6 < 10) {
                        if (i6 < 8) {
                            if (i6 < 4) {
                            }
                            i2 = 5;
                            return ((i2 * 2) + b(hardWareInfo)) / 3;
                        }
                    }
                } else if (upperCase.contains("MERRIFIELD") || upperCase.contains("CLOVERTRAIL") || upperCase.contains("REDHOOKBAY") || upperCase.contains("TEGRA") || upperCase.contains("NVIDIA") || upperCase.contains("K3")) {
                    int i7 = this.b;
                    if (i7 < 10) {
                        if (i7 < 8) {
                            if (i7 < 4) {
                            }
                            i2 = 5;
                            return ((i2 * 2) + b(hardWareInfo)) / 3;
                        }
                    }
                } else if (upperCase.contains("SMDK") || upperCase.contains("MT")) {
                    int i8 = this.b;
                    if (i8 < 10) {
                        if (i8 < 8) {
                            if (i8 < 4) {
                            }
                            i2 = 5;
                            return ((i2 * 2) + b(hardWareInfo)) / 3;
                        }
                    }
                } else {
                    if (upperCase.contains("PXA")) {
                        int i9 = this.b;
                        if (i9 < 8) {
                            if (i9 < 4) {
                            }
                        }
                        i2 = 5;
                        return ((i2 * 2) + b(hardWareInfo)) / 3;
                    }
                    if (upperCase.contains("SP") || upperCase.contains(a.X) || upperCase.contains("OMAP")) {
                        int i10 = this.b;
                        if (i10 < 8) {
                            if (i10 < 4) {
                            }
                            i2 = 2;
                            return ((i2 * 2) + b(hardWareInfo)) / 3;
                        }
                        i2 = 4;
                        return ((i2 * 2) + b(hardWareInfo)) / 3;
                    }
                    i2 = 5;
                    return ((i2 * 2) + b(hardWareInfo)) / 3;
                    i2 = 1;
                    return ((i2 * 2) + b(hardWareInfo)) / 3;
                }
                i2 = 3;
                return ((i2 * 2) + b(hardWareInfo)) / 3;
                i2 = 6;
                return ((i2 * 2) + b(hardWareInfo)) / 3;
            }
            i2 = 7;
            return ((i2 * 2) + b(hardWareInfo)) / 3;
        }
        i2 = 9;
        return ((i2 * 2) + b(hardWareInfo)) / 3;
    }
}
