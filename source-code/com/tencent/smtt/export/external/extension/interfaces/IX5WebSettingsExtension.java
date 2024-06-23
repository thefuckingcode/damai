package com.tencent.smtt.export.external.extension.interfaces;

import java.util.List;
import java.util.Map;

public interface IX5WebSettingsExtension {
    public static final int PicModel_NORMAL = 1;
    public static final int PicModel_NetNoPic = 3;
    public static final int PicModel_NoPic = 2;

    void customDiskCachePathEnabled(boolean z, String str);

    boolean getBlockLocalAddressEnable();

    boolean getPageSolarEnableFlag();

    boolean isFitScreen();

    boolean isReadModeWebView();

    boolean isWapSitePreferred();

    boolean isWebViewInBackground();

    void setARModeEnable(boolean z);

    void setAcceptCookie(boolean z);

    void setAdditionalHttpHeaders(Map<String, String> map);

    void setAutoDetectToOpenFitScreenEnabled(boolean z);

    void setAutoRecoredAndRestoreScaleEnabled(boolean z);

    void setBlockLocalAddressEnable(boolean z);

    void setContentCacheEnable(boolean z);

    void setDayOrNight(boolean z);

    void setDisplayCutoutEnable(boolean z);

    void setEnableUnderLine(boolean z);

    void setFirstScreenDetect(boolean z);

    void setFirstScreenSoftwareTextureDraw(boolean z);

    void setFitScreen(boolean z);

    void setForcePinchScaleEnabled(boolean z);

    void setFramePerformanceRecordEnable(boolean z);

    boolean setHttpDnsDomains(List<String> list);

    void setImageScanEnable(boolean z);

    void setImgAsDownloadFile(boolean z);

    void setIsViewSourceMode(boolean z);

    void setJSPerformanceRecordEnable(boolean z);

    void setJavaScriptOpenWindowsBlockedNotifyEnabled(boolean z);

    void setOnContextMenuEnable(boolean z);

    void setOnlyDomTreeBuild(boolean z);

    void setPageCacheCapacity(int i);

    void setPageSolarEnableFlag(boolean z);

    void setPicModel(int i);

    void setPreFectch(boolean z);

    void setPreFectchEnableWhenHasMedia(boolean z);

    void setReadModeWebView(boolean z);

    void setRecordRequestEnabled(boolean z);

    void setRememberScaleValue(boolean z);

    void setSelectionColorEnabled(boolean z);

    void setShouldRequestFavicon(boolean z);

    void setShouldTrackVisitedLinks(boolean z);

    void setSmartFullScreenEnabled(boolean z);

    void setTbsARShareType(int i);

    void setTextDecorationUnlineEnabled(boolean z);

    void setUseQProxy(boolean z);

    void setWapSitePreferred(boolean z);

    void setWebViewInBackground(boolean z);
}
