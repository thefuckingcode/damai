package tb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.responsive.R$dimen;
import com.youku.middlewareservice.provider.youku.mode.LargeFontModeProviderProxy;
import com.youku.modeconfig.FontModeManager;

/* compiled from: Taobao */
public class x21 {
    public static z02 a(Context context, int i, int i2, int i3, int i4, int i5, String str, z02 z02) {
        return b(context, i, i2, i3, i4, i5, str, z02, -1, -1);
    }

    public static z02 b(Context context, int i, int i2, int i3, int i4, int i5, String str, z02 z02, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        float f;
        int c;
        int c2;
        int c3;
        int i12;
        int i13;
        int i14;
        Activity activity;
        if (!(context instanceof Activity) || (activity = (Activity) context) == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            i8 = i6;
            i9 = i7;
        } else {
            i8 = activity.getWindow().getDecorView().getMeasuredWidth();
            i9 = activity.getWindow().getDecorView().getMeasuredHeight();
        }
        if (i8 == 0) {
            i8 = f12.d(context);
        }
        if (i9 == 0) {
            i9 = f12.c(context);
        }
        z02 z022 = z02 == null ? new z02() : z02;
        if (i != 31) {
            float f2 = 3.0f;
            switch (i) {
                case 11:
                    if (!f12.i(context) || (c = y02.d().c(context)) <= ad2.c()) {
                        i11 = i8 - (i4 * 2);
                    } else {
                        float c4 = ((float) c) / ((float) ad2.c());
                        if (c4 <= 3.0f) {
                            f2 = c4;
                        }
                        i11 = (int) (((float) i8) / f2);
                    }
                    i10 = Math.round((((float) i11) * 176.0f) / 351.0f);
                    break;
                case 12:
                    if (!f12.i(context)) {
                        i11 = Math.round((((float) i8) * 268.0f) / 375.0f);
                        break;
                    } else {
                        i11 = Math.round(((((float) i8) * 268.0f) / 375.0f) / ((float) ad2.f(context, 1)));
                        break;
                    }
                case 13:
                    if (f12.i(context)) {
                        int f3 = ad2.f(context, 1);
                        i11 = ((i8 - (i4 * 2)) - ((f3 - 1) * i5)) / f3;
                        break;
                    }
                    i11 = i2;
                    break;
                case 14:
                    i11 = (!f12.i(context) || (c2 = y02.d().c(context)) <= ad2.c()) ? i8 - (i4 * 2) : (int) (((float) i8) / (((float) c2) / ((float) ad2.c())));
                    i10 = Math.round((((float) i11) * 130.0f) / 351.0f);
                    break;
                case 15:
                    if (!f12.i(context) || (c3 = y02.d().c(context)) <= ad2.c()) {
                        i11 = i8;
                    } else {
                        i11 = (int) (((float) i8) / (((float) c3) / ((float) ad2.c())));
                        if (d70.k()) {
                            i11 = (int) (((double) i11) * 1.3d);
                        }
                    }
                    i10 = Math.round((((float) i11) * 176.0f) / 351.0f);
                    break;
                case 16:
                    if (!f12.i(context)) {
                        i11 = Math.round((((float) i8) * 268.0f) / 375.0f);
                        break;
                    } else {
                        i11 = Math.round((((((float) i8) * 268.0f) / 375.0f) / ((float) ad2.f(context, 1))) * 1.2f);
                        break;
                    }
                default:
                    float f4 = 2.2f;
                    switch (i) {
                        case 21:
                            int f5 = ad2.f(context, 2);
                            i12 = ((i8 - (i4 * 2)) - ((f5 - 1) * i5)) / f5;
                            int a = d70.k() ? f12.a(context, 52.0f) : f12.a(context, 77.0f);
                            if (!TextUtils.isEmpty(str)) {
                                String[] split = str.split(":");
                                if (split.length == 2) {
                                    i13 = Math.round(((((float) (Integer.valueOf(split[1]).intValue() * i12)) * 1.0f) / ((float) Integer.valueOf(split[0]).intValue())) + ((float) a));
                                }
                                i13 = i3;
                            } else {
                                i13 = Math.round(((((float) (i12 * 9)) * 1.0f) / 16.0f) + ((float) a));
                            }
                            i10 = i13;
                            i11 = i12;
                            break;
                        case 22:
                            if (!f12.i(context)) {
                                boolean isNeedChangeLayout = LargeFontModeProviderProxy.isNeedChangeLayout();
                                float min = (float) ((Math.min(i8, i9) - (i4 * 2)) - (i5 * 2));
                                if (isNeedChangeLayout) {
                                    f2 = 2.2f;
                                }
                                f = min / f2;
                                i11 = (int) f;
                                break;
                            } else {
                                int f6 = ad2.f(context, 3);
                                i11 = ((i8 - (i4 * 2)) - ((f6 - 1) * i5)) / f6;
                                break;
                            }
                        case 23:
                            if (f12.i(context)) {
                                int f7 = ad2.f(context, 3);
                                i14 = ((i8 - (i4 * 2)) - ((f7 - 1) * i5)) / f7;
                            } else {
                                float f8 = (float) ((i8 - (i4 * 2)) - (i5 * 2));
                                if (!LargeFontModeProviderProxy.isNeedChangeLayout()) {
                                    f4 = 3.0f;
                                }
                                i14 = (int) (f8 / f4);
                            }
                            i11 = Math.round((((float) i14) * 90.0f) / 102.0f);
                            i10 = Math.round((((float) i11) * 4.0f) / 3.0f);
                            break;
                        case 24:
                            int f9 = ad2.f(context, 2);
                            i11 = ((i8 - (i4 * 2)) - ((f9 - 1) * i5)) / f9;
                            if (TextUtils.isEmpty(str)) {
                                i10 = Math.round((((float) i11) * 4.0f) / 3.0f);
                                break;
                            } else {
                                String[] split2 = str.split(":");
                                if (split2.length == 2) {
                                    i10 = Math.round((((float) (Integer.valueOf(split2[1]).intValue() * i11)) * 1.0f) / ((float) Integer.valueOf(split2[0]).intValue()));
                                    break;
                                }
                            }
                            break;
                        case 25:
                            int f10 = ad2.f(context, 2);
                            i12 = ((i8 - (i4 * 2)) - ((f10 - 1) * i5)) / f10;
                            int a2 = d70.k() ? f12.a(context, 52.0f) : context.getResources().getDimensionPixelSize(R$dimen.l2s5_bottom_height);
                            if (FontModeManager.getInstance().isNeedChangeLayout()) {
                                a2 = (int) (((float) a2) * FontModeManager.getInstance().getIconScale());
                            }
                            if (!TextUtils.isEmpty(str)) {
                                String[] split3 = str.split(":");
                                if (split3.length == 2) {
                                    i13 = Math.round(((((float) (Integer.valueOf(split3[1]).intValue() * i12)) * 1.0f) / ((float) Integer.valueOf(split3[0]).intValue())) + ((float) a2));
                                }
                                i13 = i3;
                            } else {
                                i13 = Math.round(((((float) (i12 * 9)) * 1.0f) / 16.0f) + ((float) a2));
                            }
                            i10 = i13;
                            i11 = i12;
                            break;
                        default:
                            i11 = i2;
                            break;
                    }
            }
            z022.h(i11);
            z022.g(i10);
            z022.f(i8);
            z022.e(i9);
            return z022;
        } else if (f12.i(context)) {
            int f11 = ad2.f(context, 4);
            f = ((float) ((i8 - i4) - (f11 * i5))) / (((float) f11) + 0.5f);
            i11 = (int) f;
        } else {
            i11 = (int) (((float) ((Math.min(i8, i9) - i4) - (i5 * 4))) / 4.5f);
        }
        i10 = i3;
        z022.h(i11);
        z022.g(i10);
        z022.f(i8);
        z022.e(i9);
        return z022;
    }
}
