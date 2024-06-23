package com.youku.live.dsl.oss;

/* compiled from: Taobao */
public interface IXOSSProcessFormater {
    String getImageFormat();

    String getImageResize(int i, int i2);

    String getUrlWithOriginUrl(String str);

    String getUrlWithOriginUrl(String str, int i, int i2);

    boolean isNeedOptimizeImageFormat();

    boolean isNeedOptimizeImageResize();
}
