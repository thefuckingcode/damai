package com.taobao.tao.util;

import android.text.TextUtils;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.ImageStrategyExtra;
import com.taobao.tao.util.TaobaoImageUrlStrategy;
import tb.u91;

/* compiled from: Taobao */
public class ImageStrategyDecider {
    public static String decideUrl(String str, Integer num, Integer num2, Object obj) {
        ImageStrategyConfig imageStrategyConfig;
        int i;
        if (obj instanceof ImageStrategyConfig) {
            imageStrategyConfig = (ImageStrategyConfig) obj;
        } else {
            imageStrategyConfig = ImageStrategyConfig.o("default").a();
        }
        if (imageStrategyConfig.g() == ImageStrategyConfig.SizeLimitType.WIDTH_LIMIT) {
            i = num.intValue();
        } else if (imageStrategyConfig.g() == ImageStrategyConfig.SizeLimitType.HEIGHT_LIMIT) {
            i = num2.intValue();
        } else {
            i = Math.max(num.intValue(), num2.intValue());
        }
        if (i > 0) {
            i = (int) (((float) i) / TaobaoImageUrlStrategy.getInstance().getDip());
        }
        if (u91.f(u91.LEVEL_D)) {
            u91.a(u91.COMMON_TAG, "ImageStrategyDecider decideUrl, url=%s, width=%d, height=%d, info=%s", str, num, num2, imageStrategyConfig.q());
        }
        return TaobaoImageUrlStrategy.getInstance().decideUrl(str, i, imageStrategyConfig);
    }

    private static String doStrictConvergeAndWebP(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        TaobaoImageUrlStrategy.UriCDNInfo uriCDNInfo = new TaobaoImageUrlStrategy.UriCDNInfo(str);
        if (OssImageUrlStrategy.getInstance().isOssDomain(uriCDNInfo.host)) {
            if (OssImageUrlStrategy.getInstance().isFuzzyExclude(str)) {
                return str;
            }
            ImageStrategyExtra.ImageUrlInfo baseUrlInfo = ImageStrategyExtra.getBaseUrlInfo(str);
            String str2 = baseUrlInfo.base;
            if (TextUtils.isEmpty(str2) || str2.indexOf(64) <= 0) {
                return str;
            }
            if (!".jpg".equals(baseUrlInfo.ext) && !".png".equals(baseUrlInfo.ext)) {
                return str;
            }
            return str2.substring(0, str2.length() - 4) + ".webp" + baseUrlInfo.suffix;
        } else if (!TaobaoImageUrlStrategy.getInstance().isStrictCdnImage(uriCDNInfo)) {
            return str;
        } else {
            if (TaobaoImageUrlStrategy.getInstance().isDomainSwitch()) {
                str = TaobaoImageUrlStrategy.getInstance().strictConvergenceUrl(uriCDNInfo, false);
            }
            ImageStrategyExtra.ImageUrlInfo baseUrlInfo2 = ImageStrategyExtra.getBaseUrlInfo(str);
            String str3 = baseUrlInfo2.base;
            if (TextUtils.isEmpty(str3) || str3.endsWith("_.webp")) {
                return str;
            }
            return str3 + "_.webp" + baseUrlInfo2.suffix;
        }
    }

    public static String justConvergeAndWebP(String str) {
        String doStrictConvergeAndWebP = doStrictConvergeAndWebP(str);
        u91.a(u91.COMMON_TAG, "ImageStrategyDecider justConvergeAndWebP, raw=%s, ret=%s", str, doStrictConvergeAndWebP);
        return doStrictConvergeAndWebP;
    }
}
