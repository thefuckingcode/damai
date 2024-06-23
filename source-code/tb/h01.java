package tb;

import android.text.TextUtils;
import cn.damai.h5container.H5MainActivity;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.ui.WebConstant;
import com.alibaba.pictures.bricks.coupon.view.ImageConfig;
import com.alibaba.security.biometrics.service.common.ABDefaultConfig;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alimm.xadsdk.base.constant.AdConstants;
import com.alipay.sdk.m.u.n;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.youku.alixplayer.MsgID;
import com.youku.alixplayer.util.PlaybackParamKey;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import com.youku.passport.libs.BuildConfig;
import com.youku.resource.widget.PlayerGuideTipsView;
import com.youku.uplayer.AliMediaPlayer;
import java.util.Arrays;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class h01 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String IMAGE_TO_WEBP = "damai_webp";
    @NotNull
    public static final h01 INSTANCE = new h01();
    @Nullable
    private static int[][] a = {new int[]{16, 16}, new int[]{20, 20}, new int[]{24, 24}, new int[]{30, 30}, new int[]{32, 32}, new int[]{36, 36}, new int[]{40, 40}, new int[]{48, 48}, new int[]{50, 50}, new int[]{60, 30}, new int[]{60, 60}, new int[]{60, 90}, new int[]{64, 64}, new int[]{70, 70}, new int[]{70, 1000}, new int[]{72, 72}, new int[]{75, 75}, new int[]{75, 100}, new int[]{80, 40}, new int[]{80, 60}, new int[]{80, 65}, new int[]{81, 65}, new int[]{80, 80}, new int[]{80, 1000}, new int[]{88, 88}, new int[]{90, 45}, new int[]{90, 60}, new int[]{90, 90}, new int[]{90, 135}, new int[]{96, 54}, new int[]{100, 50}, new int[]{100, 75}, new int[]{100, 100}, new int[]{100, 150}, new int[]{100, 1000}, new int[]{110, 90}, new int[]{110, 110}, new int[]{110, 10000}, new int[]{115, 100}, new int[]{120, 60}, new int[]{120, 97}, new int[]{120, 90}, new int[]{120, 120}, new int[]{120, 160}, new int[]{121, 75}, new int[]{125, 125}, new int[]{128, 128}, new int[]{130, 130}, new int[]{135, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{140, 70}, new int[]{140, 100}, new int[]{140, 140}, new int[]{140, 10000}, new int[]{142, 142}, new int[]{145, 145}, new int[]{150, 150}, new int[]{150, 200}, new int[]{150, 10000}, new int[]{157, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{160, 80}, new int[]{160, 90}, new int[]{160, 130}, new int[]{160, 160}, new int[]{160, 180}, new int[]{160, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{165, 5000}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 10000}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 120}, new int[]{180, 90}, new int[]{180, 180}, new int[]{180, PlayerGuideTipsView.ANIM_DURATION_ALPHA}, new int[]{AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH, 43}, new int[]{AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH, AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH}, new int[]{196, 196}, new int[]{200, 100}, new int[]{200, 200}, new int[]{200, 162}, new int[]{210, 140}, new int[]{210, 210}, new int[]{210, 1000}, new int[]{220, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD}, new int[]{220, 220}, new int[]{220, 330}, new int[]{220, 5000}, new int[]{220, 10000}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 5000}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, 87}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, PlayerGuideTipsView.ANIM_DURATION_ALPHA}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, 10000}, new int[]{234, 234}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 180}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, BuildConfig.VERSION_CODE}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 5000}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 10000}, new int[]{250, 225}, new int[]{250, 250}, new int[]{H5MainActivity.REQUEST_REALNAME, SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE}, new int[]{H5MainActivity.REQUEST_REALNAME, H5MainActivity.REQUEST_REALNAME}, new int[]{WebConstant.OPEN_WEB_LOGIN_IV_REQCODE, 100}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, 180}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, 450}, new int[]{ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE, 192}, new int[]{ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE, 410}, new int[]{284, 284}, new int[]{288, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{290, 290}, new int[]{290, 10000}, new int[]{292, 292}, new int[]{294, 430}, new int[]{300, 1000}, new int[]{300, 10000}, new int[]{310, 310}, new int[]{312, 312}, new int[]{300, 300}, new int[]{315, 315}, new int[]{320, H5MainActivity.REQUEST_REALNAME}, new int[]{320, 320}, new int[]{320, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{320, 5000}, new int[]{336, 336}, new int[]{350, 350}, new int[]{350, 1000}, new int[]{PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH, PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH}, new int[]{360, 234}, new int[]{360, 360}, new int[]{360, 10000}, new int[]{375, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{375, 375}, new int[]{400, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR}, new int[]{400, 200}, new int[]{400, 400}, new int[]{420, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{430, 430}, new int[]{438, 438}, new int[]{440, 440}, new int[]{450, 300}, new int[]{450, 600}, new int[]{450, 5000}, new int[]{450, 10000}, new int[]{n.g, n.g}, new int[]{468, 468}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, 420}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{485, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_LOADING_FACTOR_STEP}, new int[]{490, 330}, new int[]{490, 490}, new int[]{500, 375}, new int[]{500, 450}, new int[]{500, 500}, new int[]{500, 1000}, new int[]{540, 540}, new int[]{560, AdConstants.TEMPLATE_LONG_VIDEO_INTERACTION}, new int[]{560, 560}, new int[]{560, 840}, new int[]{568, 568}, new int[]{570, 570}, new int[]{570, 10000}, new int[]{580, 580}, new int[]{580, 10000}, new int[]{600, 600}, new int[]{600, 800}, new int[]{620, 10000}, new int[]{640, 360}, new int[]{640, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{640, 640}, new int[]{660, 440}, new int[]{667, 667}, new int[]{670, 670}, new int[]{LoginConstant.RESULT_WINDWANE_CLOSEW, LoginConstant.RESULT_WINDWANE_CLOSEW}, new int[]{728, 728}, new int[]{FeatureFactory.PRIORITY_ABOVE_NORMAL, 388}, new int[]{FeatureFactory.PRIORITY_ABOVE_NORMAL, 1000}, new int[]{760, 760}, new int[]{790, 420}, new int[]{790, 10000}, new int[]{800, 800}, new int[]{960, 960}, new int[]{970, 970}, new int[]{1080, 1800}, new int[]{1136, 1136}, new int[]{1152, 1920}, new int[]{1200, 1200}, new int[]{1280, 960}, new int[]{1280, 1280}, new int[]{2200, 2200}, new int[]{10000, 220}, new int[]{10000, MsgID.TYPE_MSG_BEGIN_PLAYBACK}, new int[]{10000, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}, new int[]{10000, 500}};

    private h01() {
    }

    private final int[] a(int i, int i2, boolean z) {
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1800367761")) {
            return (int[]) ipChange.ipc$dispatch("-1800367761", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
        }
        if (i < 0 || i2 < 0) {
            return new int[]{i, i2};
        }
        if (z) {
            float f = (float) i;
            float f2 = (float) i2;
            float max = Math.max(f / 4096.0f, f2 / 4096.0f);
            return max > 1.0f ? new int[]{Math.min(4096, (int) (f / max)), Math.min(4096, (int) (f2 / max))} : new int[]{i, i2};
        }
        int i5 = Integer.MAX_VALUE;
        int[][] iArr = a;
        if (iArr == null) {
            i3 = 0;
        } else {
            k21.f(iArr);
            i3 = iArr.length;
        }
        int i6 = -100;
        int i7 = -100;
        for (int i8 = 0; i8 < i3; i8++) {
            int[][] iArr2 = a;
            k21.f(iArr2);
            int i9 = iArr2[i8][0];
            int[][] iArr3 = a;
            k21.f(iArr3);
            int i10 = iArr3[i8][1];
            if (i9 >= i && i10 >= i2 && (i4 = i9 * i10) < i5) {
                i6 = i9;
                i7 = i10;
                i5 = i4;
            }
        }
        return new int[]{i6, i7};
    }

    private final boolean e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1609399939")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1609399939", new Object[]{this})).booleanValue();
    }

    private final boolean f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1911161014")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1911161014", new Object[]{this})).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0100, code lost:
        if (f() != false) goto L_0x00cf;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0109  */
    private final String g(String str, ImageConfig imageConfig) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436096736")) {
            return (String) ipChange.ipc$dispatch("-1436096736", new Object[]{this, str, imageConfig});
        }
        StringBuilder sb = new StringBuilder(str);
        String substring = str.substring(StringsKt__StringsKt.l0(str, "/", 0, false, 6, null));
        k21.h(substring, "this as java.lang.String).substring(startIndex)");
        if ((StringsKt__StringsKt.Q(substring, ".png_", false, 2, null)) || (StringsKt__StringsKt.Q(substring, ".jpeg_", false, 2, null)) || (StringsKt__StringsKt.Q(substring, ".jpg_", false, 2, null)) || (StringsKt__StringsKt.Q(substring, ".gif", false, 2, null))) {
            return str;
        }
        int[] a2 = a(imageConfig.i(), imageConfig.h(), false);
        sb.append(JSMethod.NOT_SET);
        if (a2[0] > 0 && a2[1] > 0) {
            sb.append(a2[0]);
            sb.append(Constants.Name.X);
            sb.append(a2[1]);
        }
        String str3 = "";
        if (imageConfig.f() && imageConfig.b() != null) {
            if (imageConfig.b() == ImageConfig.DMImageCropType.cy500) {
                str2 = "cy500i";
            } else {
                str2 = imageConfig.b() == ImageConfig.DMImageCropType.cy100 ? "cy100i" : str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
                sb.append(imageConfig.a());
            }
        }
        if (imageConfig.g()) {
            if (imageConfig.c() != null) {
                if (imageConfig.c() != ImageConfig.DMImageQuality.q90) {
                    if (imageConfig.c() != ImageConfig.DMImageQuality.q75) {
                        if (imageConfig.c() == ImageConfig.DMImageQuality.q60) {
                            str3 = "q60";
                        } else if (imageConfig.c() == ImageConfig.DMImageQuality.q50) {
                            str3 = "q50";
                        } else if (imageConfig.c() == ImageConfig.DMImageQuality.q30) {
                            str3 = "q30";
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            sb.append(str3);
                        }
                    }
                    str3 = "q75";
                    if (!TextUtils.isEmpty(str3)) {
                    }
                }
            }
            str3 = "q90";
            if (!TextUtils.isEmpty(str3)) {
            }
        }
        if (imageConfig.d()) {
            if (f()) {
                sb.append("s150");
            } else {
                sb.append("s150");
            }
        }
        sb.append(".jpg");
        if (imageConfig.e()) {
            sb.append("_.webp");
        }
        String sb2 = sb.toString();
        k21.h(sb2, "cdnUrl.toString()");
        return sb2;
    }

    private final String h(String str, ImageConfig imageConfig) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10534898")) {
            return (String) ipChange.ipc$dispatch("-10534898", new Object[]{this, str, imageConfig});
        }
        StringBuilder sb = new StringBuilder(str);
        if ((StringsKt__StringsKt.Q(str, "x-oss-process=", false, 2, null)) || (StringsKt__StringsKt.Q(str, ".gif", false, 2, null))) {
            return str;
        }
        sb.append("?x-oss-process=image");
        int[] a2 = a(imageConfig.i(), imageConfig.h(), true);
        if (a2[0] > 0 && a2[1] > 0) {
            sb.append("/resize");
            sb.append(",");
            sb.append("w_");
            sb.append(a2[0]);
            sb.append(",");
            sb.append("h_");
            sb.append(a2[1]);
        }
        if (imageConfig.g()) {
            if (imageConfig.c() != null) {
                if (imageConfig.c() == ImageConfig.DMImageQuality.q90) {
                    str2 = "q_90";
                } else if (imageConfig.c() == ImageConfig.DMImageQuality.q75) {
                    str2 = "q_75";
                } else if (imageConfig.c() == ImageConfig.DMImageQuality.q60) {
                    str2 = "q_60";
                } else if (imageConfig.c() == ImageConfig.DMImageQuality.q50) {
                    str2 = "q_50";
                } else {
                    str2 = imageConfig.c() == ImageConfig.DMImageQuality.q30 ? "q_30" : "";
                }
            } else if (f()) {
                ef2 ef2 = ef2.INSTANCE;
                k21.h("q", "this as java.lang.String…ing(startIndex, endIndex)");
                k21.h("90", "this as java.lang.String).substring(startIndex)");
                str2 = String.format("%s_%s", Arrays.copyOf(new Object[]{"q", "90"}, 2));
                k21.h(str2, "format(format, *args)");
            } else {
                ef2 ef22 = ef2.INSTANCE;
                k21.h("q", "this as java.lang.String…ing(startIndex, endIndex)");
                k21.h("75", "this as java.lang.String).substring(startIndex)");
                str2 = String.format("%s_%s", Arrays.copyOf(new Object[]{"q", "75"}, 2));
                k21.h(str2, "format(format, *args)");
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append("/quality");
                sb.append(",");
                sb.append(str2);
            }
        }
        if (imageConfig.d()) {
            sb.append("/sharpen");
            sb.append(",");
            if (f()) {
                k21.h("150", "this as java.lang.String).substring(startIndex)");
                sb.append("150");
            } else {
                k21.h("150", "this as java.lang.String).substring(startIndex)");
                sb.append("150");
            }
        }
        if (imageConfig.e()) {
            sb.append("/format,webp");
        }
        String sb2 = sb.toString();
        k21.h(sb2, "cdnUrl.toString()");
        return sb2;
    }

    @NotNull
    public final ImageConfig b(@NotNull String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1277592786")) {
            return (ImageConfig) ipChange.ipc$dispatch("-1277592786", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        k21.i(str, "imageUrl");
        if (!e()) {
            return new ImageConfig();
        }
        if (TextUtils.isEmpty(str)) {
            return new ImageConfig();
        }
        if (StringsKt__StringsKt.Q(str, ".gif", false, 2, null)) {
            return new ImageConfig();
        }
        if (!(StringsKt__StringsKt.Q(str, ".alicdn.com", false, 2, null)) && !(StringsKt__StringsKt.Q(str, ".aliyun-inc.com", false, 2, null)) && !(StringsKt__StringsKt.Q(str, ".aliyuncs.com", false, 2, null))) {
            return new ImageConfig();
        }
        boolean z = (StringsKt__StringsKt.Q(str, ".aliyun-inc.com", false, 2, null)) || (StringsKt__StringsKt.Q(str, ".aliyuncs.com", false, 2, null));
        ImageConfig imageConfig = new ImageConfig();
        imageConfig.j("default");
        int[] a2 = a(i, i2, z);
        if (a2[0] > 0 && a2[1] > 0) {
            imageConfig.r(a2[0]);
            imageConfig.q(a2[1]);
        }
        imageConfig.m(true);
        imageConfig.n(true);
        imageConfig.o(false);
        imageConfig.p(true);
        return imageConfig;
    }

    @NotNull
    public final String c(@NotNull String str, @NotNull ImageConfig imageConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-610146628")) {
            return (String) ipChange.ipc$dispatch("-610146628", new Object[]{this, str, imageConfig});
        }
        k21.i(str, "imageUrl");
        k21.i(imageConfig, com.youku.arch.v3.core.Constants.CONFIG);
        if (!e() || TextUtils.isEmpty(str) || (o.L(str, "res://", false, 2, null)) || (o.L(str, "file://", false, 2, null)) || (o.L(str, "asset://", false, 2, null))) {
            return str;
        }
        if (StringsKt__StringsKt.Q(str, ".alicdn.com", false, 2, null)) {
            return g(str, imageConfig);
        }
        return ((StringsKt__StringsKt.Q(str, ".aliyun-inc.com", false, 2, null)) || (StringsKt__StringsKt.Q(str, ".aliyuncs.com", false, 2, null))) ? h(str, imageConfig) : str;
    }

    public final boolean d(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1132001834")) {
            return ((Boolean) ipChange.ipc$dispatch("-1132001834", new Object[]{this, str})).booleanValue();
        }
        k21.i(str, "imageUrl");
        if (!TextUtils.isEmpty(str) && (StringsKt__StringsKt.Q(str, ".alicdn.com", false, 2, null))) {
            String substring = str.substring(StringsKt__StringsKt.l0(str, "/", 0, false, 6, null));
            k21.h(substring, "this as java.lang.String).substring(startIndex)");
            if (!(StringsKt__StringsKt.Q(substring, ".png_", false, 2, null)) && !(StringsKt__StringsKt.Q(substring, ".jpeg_", false, 2, null)) && !(StringsKt__StringsKt.Q(substring, ".jpg_", false, 2, null))) {
                return !StringsKt__StringsKt.Q(substring, ".gif", false, 2, null);
            }
        }
        return false;
    }
}
