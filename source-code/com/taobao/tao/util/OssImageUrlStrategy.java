package com.taobao.tao.util;

import android.text.TextUtils;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.ImageStrategyExtra;
import com.taobao.tao.util.TaobaoImageUrlStrategy;
import com.taobao.weex.ui.component.WXComponent;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.u91;

/* compiled from: Taobao */
public class OssImageUrlStrategy {
    private static final String[] DEFAULT_FUZZY_EXCLUDES = {"getAvatar", "@watermark"};
    private static final String[] DEFAULT_OSS_DOMAINS = {"ossgw.alicdn.com"};
    public static final char FIRST_LEVEL_CONCAT = '@';
    private static final String GIF_EXTEND = ".gif";
    private static final String JPEG_EXTEND = ".jpg";
    private static final String SECOND_LEVEL_CONCAT = "_";
    private static final String SHARPEN_IMAGE = "1sh";
    private static final String SMALL_THAN_ORIGIN = "1l";
    private static final String WEBP_EXTEND = ".webp";
    private static final String WHITE_FILL = "1wh";
    private static OssImageUrlStrategy sInstance;
    private Pattern mCdnRuleRegex;
    private String[] mFuzzyExcludePath = DEFAULT_FUZZY_EXCLUDES;
    private String[] mOssDomains = DEFAULT_OSS_DOMAINS;
    private final ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[ImageStrategyConfig.SizeLimitType.values().length];
            a = iArr;
            iArr[ImageStrategyConfig.SizeLimitType.WIDTH_LIMIT.ordinal()] = 1;
            a[ImageStrategyConfig.SizeLimitType.HEIGHT_LIMIT.ordinal()] = 2;
            try {
                a[ImageStrategyConfig.SizeLimitType.ALL_LIMIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static boolean decideCut(ImageStrategyExtra.ImageUrlInfo imageUrlInfo, ImageStrategyConfig imageStrategyConfig) {
        if (imageStrategyConfig.b() == null || imageStrategyConfig.b() == TaobaoImageUrlStrategy.CutType.non) {
            return false;
        }
        imageUrlInfo.cj = imageStrategyConfig.b().getOssCut();
        return true;
    }

    private void decideExtend(ImageStrategyExtra.ImageUrlInfo imageUrlInfo, ImageStrategyConfig imageStrategyConfig) {
        if (!GIF_EXTEND.equals(imageUrlInfo.ext)) {
            if (imageStrategyConfig.m() || (!isConfigDisabled(imageStrategyConfig.l()) && TaobaoImageUrlStrategy.getInstance().isSupportWebP() && !imageUrlInfo.suffix.contains("imgwebptag=0"))) {
                imageUrlInfo.ext = WEBP_EXTEND;
            } else if (WEBP_EXTEND.equals(imageUrlInfo.ext)) {
                imageUrlInfo.ext = null;
            }
        }
    }

    private boolean decideQuality(ImageStrategyExtra.ImageUrlInfo imageUrlInfo, ImageStrategyConfig imageStrategyConfig) {
        if (isConfigDisabled(imageStrategyConfig.j()) || imageStrategyConfig.d() == TaobaoImageUrlStrategy.ImageQuality.non) {
            return false;
        }
        if (imageStrategyConfig.d() != null) {
            imageUrlInfo.quality = imageStrategyConfig.d().getOssQuality();
            return true;
        } else if (TaobaoImageUrlStrategy.getInstance().isNetworkSlow()) {
            imageUrlInfo.quality = TaobaoImageUrlStrategy.ImageQuality.q75.getOssQuality();
            return true;
        } else {
            imageUrlInfo.quality = TaobaoImageUrlStrategy.ImageQuality.q90.getOssQuality();
            return true;
        }
    }

    private boolean decideSharpen(ImageStrategyExtra.ImageUrlInfo imageUrlInfo, ImageStrategyConfig imageStrategyConfig) {
        if (isConfigDisabled(imageStrategyConfig.k()) || !TaobaoImageUrlStrategy.getInstance().isNetworkSlow()) {
            return false;
        }
        imageUrlInfo.sharpen = SHARPEN_IMAGE;
        return true;
    }

    private void decideWH(ImageStrategyExtra.ImageUrlInfo imageUrlInfo, ImageStrategyConfig imageStrategyConfig, int i) {
        int i2;
        TaobaoImageUrlStrategy instance = TaobaoImageUrlStrategy.getInstance();
        if (instance.isNetworkSlow()) {
            i2 = (int) (((double) (((float) i) * instance.getDip())) * 0.7d);
        } else {
            i2 = (int) (((float) i) * instance.getDip());
        }
        if (imageStrategyConfig.e() > 0 && imageStrategyConfig.c() > 0) {
            imageUrlInfo.width = imageStrategyConfig.e();
            imageUrlInfo.height = imageStrategyConfig.c();
        } else if ((imageStrategyConfig.g() != ImageStrategyConfig.SizeLimitType.ALL_LIMIT || imageUrlInfo.width <= 0 || imageUrlInfo.height <= 0) && i2 >= 0) {
            int taobaoCDNPatten = instance.taobaoCDNPatten(i2, true, !isConfigDisabled(imageStrategyConfig.h()));
            int i3 = a.a[imageStrategyConfig.g().ordinal()];
            if (i3 == 1) {
                imageUrlInfo.width = taobaoCDNPatten;
                imageUrlInfo.height = 0;
            } else if (i3 == 2) {
                imageUrlInfo.width = 0;
                imageUrlInfo.height = taobaoCDNPatten;
            } else if (i3 == 3) {
                imageUrlInfo.height = taobaoCDNPatten;
                imageUrlInfo.width = taobaoCDNPatten;
            }
        }
    }

    public static synchronized OssImageUrlStrategy getInstance() {
        OssImageUrlStrategy ossImageUrlStrategy;
        synchronized (OssImageUrlStrategy.class) {
            if (sInstance == null) {
                sInstance = new OssImageUrlStrategy();
            }
            ossImageUrlStrategy = sInstance;
        }
        return ossImageUrlStrategy;
    }

    private boolean isConfigDisabled(Boolean bool) {
        return bool != null && !bool.booleanValue();
    }

    private ImageStrategyExtra.ImageUrlInfo parseOssRule(String str) {
        ImageStrategyExtra.ImageUrlInfo baseUrlInfo = ImageStrategyExtra.getBaseUrlInfo(str);
        String str2 = baseUrlInfo.base;
        int lastIndexOf = str2.lastIndexOf(64);
        if (lastIndexOf < 0) {
            return baseUrlInfo;
        }
        if (this.mCdnRuleRegex == null) {
            this.mCdnRuleRegex = Pattern.compile(String.format("%s(?:(?:%s?(\\d+)w[%s\\.])|(?:%s?(\\d+)w$)|(?:%s?(\\d+)h)|(?:%s?(\\d+[Qq]))|(?:%s?[^%s.]+))+", '@', "_", "_", "_", "_", "_", "_", "_"));
        }
        Matcher matcher = this.mCdnRuleRegex.matcher(str2);
        baseUrlInfo.base = str2.substring(0, lastIndexOf);
        if (!matcher.find(lastIndexOf) || matcher.groupCount() < 4) {
            return baseUrlInfo;
        }
        try {
            String group = matcher.group(1);
            if (group == null) {
                group = matcher.group(2);
            }
            String group2 = matcher.group(3);
            String group3 = matcher.group(4);
            if (!TextUtils.isEmpty(group)) {
                baseUrlInfo.width = Integer.parseInt(group);
            }
            if (!TextUtils.isEmpty(group2)) {
                baseUrlInfo.height = Integer.parseInt(group2);
            }
            if (!TextUtils.isEmpty(group3)) {
                baseUrlInfo.quality = group3;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            u91.b(u91.COMMON_TAG, "ImageStrategyExtra parseImageUrl convert number error:%s", e.getMessage());
        }
        return baseUrlInfo;
    }

    public String decideUrl(String str, int i, ImageStrategyConfig imageStrategyConfig) {
        if (isFuzzyExclude(str)) {
            u91.a(u91.COMMON_TAG, "[OSS] fuzzy exclude, url=%s", str);
            return str;
        }
        String str2 = "";
        ImageStrategyExtra.ImageUrlInfo parseOssRule = parseOssRule(str);
        StringBuilder sb = new StringBuilder(parseOssRule.base.length() + 26);
        sb.append(parseOssRule.base);
        sb.append('@');
        decideWH(parseOssRule, imageStrategyConfig, i);
        if (parseOssRule.width > 0) {
            sb.append(str2);
            sb.append(parseOssRule.width);
            sb.append(WXComponent.PROP_FS_WRAP_CONTENT);
            str2 = "_";
        }
        if (parseOssRule.height > 0) {
            sb.append(str2);
            sb.append(parseOssRule.height);
            sb.append("h");
            str2 = "_";
        }
        decideQuality(parseOssRule, imageStrategyConfig);
        if (!TextUtils.isEmpty(parseOssRule.quality)) {
            sb.append(str2);
            sb.append(parseOssRule.quality);
            str2 = "_";
        }
        if (decideSharpen(parseOssRule, imageStrategyConfig)) {
            sb.append(str2);
            sb.append(parseOssRule.sharpen);
            str2 = "_";
        }
        if (decideCut(parseOssRule, imageStrategyConfig)) {
            sb.append(str2);
            sb.append(parseOssRule.cj);
            str2 = "_";
        }
        sb.append(str2);
        sb.append(SMALL_THAN_ORIGIN);
        decideExtend(parseOssRule, imageStrategyConfig);
        if (TextUtils.isEmpty(parseOssRule.ext)) {
            sb.append("_");
            sb.append(WHITE_FILL);
            sb.append(JPEG_EXTEND);
        } else {
            sb.append(parseOssRule.ext);
        }
        sb.append(parseOssRule.suffix);
        String substring = sb.substring(0);
        u91.a(u91.COMMON_TAG, "[OSS] origin url=%s\ndecide url=%s", str, substring);
        return substring;
    }

    /* JADX INFO: finally extract failed */
    public boolean isFuzzyExclude(String str) {
        this.mRWLock.readLock().lock();
        try {
            String[] strArr = this.mFuzzyExcludePath;
            if (strArr != null) {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    if (str.indexOf(this.mFuzzyExcludePath[i]) >= 0) {
                        this.mRWLock.readLock().unlock();
                        return true;
                    }
                }
            }
            this.mRWLock.readLock().unlock();
            return false;
        } catch (Throwable th) {
            this.mRWLock.readLock().unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean isOssDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mRWLock.readLock().lock();
        try {
            String[] strArr = this.mOssDomains;
            if (strArr != null) {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    if (str.indexOf(this.mOssDomains[i]) >= 0) {
                        this.mRWLock.readLock().unlock();
                        return true;
                    }
                }
            }
            this.mRWLock.readLock().unlock();
            return false;
        } catch (Throwable th) {
            this.mRWLock.readLock().unlock();
            throw th;
        }
    }

    public void setupConfigs(String[] strArr, String[] strArr2) {
        this.mRWLock.writeLock().lock();
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    this.mOssDomains = strArr;
                }
            } catch (Throwable th) {
                this.mRWLock.writeLock().unlock();
                throw th;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            this.mFuzzyExcludePath = strArr2;
        }
        this.mRWLock.writeLock().unlock();
    }
}
