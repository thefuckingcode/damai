package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.k;

public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    private IX5WebSettings a;
    private android.webkit.WebSettings b;
    private boolean c;

    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(TbsListener.ErrorCode.DOWNLOAD_THROWABLE),
        LARGEST(150);
        
        int value;

        private TextSize(int i) {
            this.value = i;
        }
    }

    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        private ZoomDensity(int i) {
            this.value = i;
        }
    }

    WebSettings(IX5WebSettings iX5WebSettings) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = iX5WebSettings;
        this.b = null;
        this.c = true;
    }

    WebSettings(android.webkit.WebSettings webSettings) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = null;
        this.b = webSettings;
        this.c = false;
    }

    public void setNavDump(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setNavDump(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            k.a(webSettings, "setNavDump", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized int getMixedContentMode() {
        IX5WebSettings iX5WebSettings;
        int i = -1;
        if (this.c && (iX5WebSettings = this.a) != null) {
            try {
                return iX5WebSettings.getMixedContentMode();
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        } else if (Build.VERSION.SDK_INT < 21) {
            return -1;
        } else {
            Object a2 = k.a(this.b, "getMixedContentMode", new Class[0], new Object[0]);
            if (a2 != null) {
                i = ((Integer) a2).intValue();
            }
            return i;
        }
    }

    public boolean getNavDump() {
        android.webkit.WebSettings webSettings;
        Object a2;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getNavDump();
        }
        if (z || (webSettings = this.b) == null || (a2 = k.a(webSettings, "getNavDump")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public void setSupportZoom(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSupportZoom(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setSupportZoom(z);
        }
    }

    public boolean supportZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.supportZoom();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.supportZoom();
    }

    public void setBuiltInZoomControls(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setBuiltInZoomControls(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setBuiltInZoomControls(z);
        }
    }

    public boolean getBuiltInZoomControls() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getBuiltInZoomControls();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getBuiltInZoomControls();
    }

    public void setDisplayZoomControls(boolean z) {
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDisplayZoomControls(z);
        } else if (!z2 && this.b != null && Build.VERSION.SDK_INT >= 11) {
            k.a(this.b, "setDisplayZoomControls", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public boolean getDisplayZoomControls() {
        Object a2;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getDisplayZoomControls();
        }
        if (z || this.b == null || Build.VERSION.SDK_INT < 11 || (a2 = k.a(this.b, "getDisplayZoomControls")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public void setAllowFileAccess(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowFileAccess(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setAllowFileAccess(z);
        }
    }

    public boolean getAllowFileAccess() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getAllowFileAccess();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getAllowFileAccess();
    }

    public void setAllowContentAccess(boolean z) {
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowContentAccess(z);
        } else if (!z2 && this.b != null && Build.VERSION.SDK_INT >= 11) {
            k.a(this.b, "setAllowContentAccess", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setMixedContentMode(int i) {
        boolean z = this.c;
        if ((!z || this.a == null) && !z && this.b != null && Build.VERSION.SDK_INT >= 21) {
            k.a(this.b, "setMixedContentMode", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public boolean getAllowContentAccess() {
        Object a2;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getAllowContentAccess();
        }
        if (z || this.b == null || Build.VERSION.SDK_INT < 11 || (a2 = k.a(this.b, "getAllowContentAccess")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public void setLoadWithOverviewMode(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLoadWithOverviewMode(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setLoadWithOverviewMode(z);
        }
    }

    public boolean getLoadWithOverviewMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getLoadWithOverviewMode();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLoadWithOverviewMode();
    }

    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setEnableSmoothTransition(z);
        } else if (!z2 && this.b != null && Build.VERSION.SDK_INT >= 11) {
            k.a(this.b, "setEnableSmoothTransition", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        Object a2;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.enableSmoothTransition();
        }
        if (z || this.b == null || Build.VERSION.SDK_INT < 11 || (a2 = k.a(this.b, "enableSmoothTransition")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUseWebViewBackgroundForOverscrollBackground(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            k.a(webSettings, "setUseWebViewBackgroundForOverscrollBackground", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        android.webkit.WebSettings webSettings;
        Object a2;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getUseWebViewBackgroundForOverscrollBackground();
        }
        if (z || (webSettings = this.b) == null || (a2 = k.a(webSettings, "getUseWebViewBackgroundForOverscrollBackground")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public void setSaveFormData(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSaveFormData(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setSaveFormData(z);
        }
    }

    public boolean getSaveFormData() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getSaveFormData();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getSaveFormData();
    }

    public void setSavePassword(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSavePassword(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setSavePassword(z);
        }
    }

    public boolean getSavePassword() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getSavePassword();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getSavePassword();
    }

    public synchronized void setTextZoom(int i) {
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setTextZoom(i);
        } else if (!z && this.b != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                try {
                    this.b.setTextZoom(i);
                } catch (Exception unused) {
                    k.a(this.b, "setTextZoom", new Class[]{Integer.TYPE}, Integer.valueOf(i));
                }
            }
        }
    }

    public synchronized int getTextZoom() {
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getTextZoom();
        }
        int i = 0;
        if (z || this.b == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        try {
            return this.b.getTextZoom();
        } catch (Exception unused) {
            Object a2 = k.a(this.b, "getTextZoom");
            if (a2 != null) {
                i = ((Integer) a2).intValue();
            }
            return i;
        }
    }

    public void setTextSize(TextSize textSize) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setTextSize(IX5WebSettings.TextSize.valueOf(textSize.name()));
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setTextSize(WebSettings.TextSize.valueOf(textSize.name()));
        }
    }

    public TextSize getTextSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return TextSize.valueOf(iX5WebSettings.getTextSize().name());
        }
        if (z || (webSettings = this.b) == null) {
            return null;
        }
        return TextSize.valueOf(webSettings.getTextSize().name());
    }

    public void setDefaultZoom(ZoomDensity zoomDensity) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        }
    }

    public ZoomDensity getDefaultZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return ZoomDensity.valueOf(iX5WebSettings.getDefaultZoom().name());
        }
        if (z || (webSettings = this.b) == null) {
            return null;
        }
        return ZoomDensity.valueOf(webSettings.getDefaultZoom().name());
    }

    public void setLightTouchEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLightTouchEnabled(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setLightTouchEnabled(z);
        }
    }

    public boolean getLightTouchEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getLightTouchEnabled();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLightTouchEnabled();
    }

    public void setUserAgent(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUserAgent(str);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setUserAgentString(str);
        }
    }

    public String getUserAgentString() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getUserAgentString();
        }
        return iX5WebSettings.getUserAgentString();
    }

    public void setUserAgentString(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUserAgentString(str);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setUserAgentString(str);
        }
    }

    public void setUseWideViewPort(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUseWideViewPort(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setUseWideViewPort(z);
        }
    }

    public synchronized boolean getUseWideViewPort() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getUseWideViewPort();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getUseWideViewPort();
    }

    public void setSupportMultipleWindows(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSupportMultipleWindows(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setSupportMultipleWindows(z);
        }
    }

    public synchronized boolean supportMultipleWindows() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.supportMultipleWindows();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.supportMultipleWindows();
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        }
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return LayoutAlgorithm.valueOf(iX5WebSettings.getLayoutAlgorithm().name());
        }
        if (z || (webSettings = this.b) == null) {
            return null;
        }
        return LayoutAlgorithm.valueOf(webSettings.getLayoutAlgorithm().name());
    }

    public synchronized void setStandardFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setStandardFontFamily(str);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setStandardFontFamily(str);
        }
    }

    public synchronized String getStandardFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getStandardFontFamily();
        }
        return iX5WebSettings.getStandardFontFamily();
    }

    public synchronized void setFixedFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setFixedFontFamily(str);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setFixedFontFamily(str);
        }
    }

    public synchronized String getFixedFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getFixedFontFamily();
        }
        return iX5WebSettings.getFixedFontFamily();
    }

    public synchronized void setSansSerifFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSansSerifFontFamily(str);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setSansSerifFontFamily(str);
        }
    }

    public synchronized String getSansSerifFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getSansSerifFontFamily();
        }
        return iX5WebSettings.getSansSerifFontFamily();
    }

    public synchronized void setSerifFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSerifFontFamily(str);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setSerifFontFamily(str);
        }
    }

    public synchronized String getSerifFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getSerifFontFamily();
        }
        return iX5WebSettings.getSerifFontFamily();
    }

    public synchronized void setCursiveFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setCursiveFontFamily(str);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setCursiveFontFamily(str);
        }
    }

    public synchronized String getCursiveFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getCursiveFontFamily();
        }
        return iX5WebSettings.getCursiveFontFamily();
    }

    public synchronized void setFantasyFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setFantasyFontFamily(str);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setFantasyFontFamily(str);
        }
    }

    public synchronized String getFantasyFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getFantasyFontFamily();
        }
        return iX5WebSettings.getFantasyFontFamily();
    }

    public synchronized void setMinimumFontSize(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setMinimumFontSize(i);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setMinimumFontSize(i);
        }
    }

    public synchronized int getMinimumFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getMinimumFontSize();
        }
        if (z || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getMinimumFontSize();
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setMinimumLogicalFontSize(i);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setMinimumLogicalFontSize(i);
        }
    }

    public synchronized int getMinimumLogicalFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getMinimumLogicalFontSize();
        }
        if (z || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getMinimumLogicalFontSize();
    }

    public synchronized void setDefaultFontSize(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDefaultFontSize(i);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setDefaultFontSize(i);
        }
    }

    public synchronized int getDefaultFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getDefaultFontSize();
        }
        if (z || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getDefaultFontSize();
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDefaultFixedFontSize(i);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setDefaultFixedFontSize(i);
        }
    }

    public synchronized int getDefaultFixedFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getDefaultFixedFontSize();
        }
        if (z || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getDefaultFixedFontSize();
    }

    public void setLoadsImagesAutomatically(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLoadsImagesAutomatically(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setLoadsImagesAutomatically(z);
        }
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getLoadsImagesAutomatically();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLoadsImagesAutomatically();
    }

    public void setBlockNetworkImage(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setBlockNetworkImage(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setBlockNetworkImage(z);
        }
    }

    public synchronized boolean getBlockNetworkImage() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getBlockNetworkImage();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getBlockNetworkImage();
    }

    public synchronized void setBlockNetworkLoads(boolean z) {
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setBlockNetworkLoads(z);
        } else if (!z2 && this.b != null) {
            if (Build.VERSION.SDK_INT >= 8) {
                this.b.setBlockNetworkLoads(z);
            }
        }
    }

    public synchronized boolean getBlockNetworkLoads() {
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getBlockNetworkLoads();
        }
        if (z || this.b == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 8) {
            return this.b.getBlockNetworkLoads();
        }
        return false;
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        try {
            boolean z2 = this.c;
            if (z2 && (iX5WebSettings = this.a) != null) {
                iX5WebSettings.setJavaScriptEnabled(z);
            } else if (!z2 && (webSettings = this.b) != null) {
                webSettings.setJavaScriptEnabled(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowUniversalAccessFromFileURLs(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            k.a(webSettings, "setAllowUniversalAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setAllowFileAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowFileAccessFromFileURLs(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            k.a(webSettings, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setPluginsEnabled(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            k.a(webSettings, "setPluginsEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setPluginState(IX5WebSettings.PluginState.valueOf(pluginState.name()));
        } else if (!z && this.b != null) {
            if (Build.VERSION.SDK_INT >= 8) {
                k.a(this.b, "setPluginState", new Class[]{WebSettings.PluginState.class}, WebSettings.PluginState.valueOf(pluginState.name()));
            }
        }
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setPluginsPath(str);
        } else if (!z && (webSettings = this.b) != null) {
            k.a(webSettings, "setPluginsPath", new Class[]{String.class}, str);
        }
    }

    @Deprecated
    public void setDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDatabasePath(str);
        } else if (!z && (webSettings = this.b) != null) {
            k.a(webSettings, "setDatabasePath", new Class[]{String.class}, str);
        }
    }

    public void setGeolocationDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setGeolocationDatabasePath(str);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setGeolocationDatabasePath(str);
        }
    }

    public void setAppCacheEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAppCacheEnabled(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setAppCacheEnabled(z);
        }
    }

    public void setAppCachePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAppCachePath(str);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setAppCachePath(str);
        }
    }

    public void setAppCacheMaxSize(long j) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAppCacheMaxSize(j);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setAppCacheMaxSize(j);
        }
    }

    public void setDatabaseEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDatabaseEnabled(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setDatabaseEnabled(z);
        }
    }

    public void setDomStorageEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDomStorageEnabled(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setDomStorageEnabled(z);
        }
    }

    public synchronized boolean getDomStorageEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getDomStorageEnabled();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getDomStorageEnabled();
    }

    public synchronized String getDatabasePath() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getDatabasePath();
        }
        return iX5WebSettings.getDatabasePath();
    }

    public synchronized boolean getDatabaseEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getDatabaseEnabled();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getDatabaseEnabled();
    }

    public void setGeolocationEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setGeolocationEnabled(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setGeolocationEnabled(z);
        }
    }

    public synchronized boolean getJavaScriptEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getJavaScriptEnabled();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getJavaScriptEnabled();
    }

    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getPluginsEnabled();
        }
        boolean z2 = false;
        if (z || this.b == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT <= 17) {
            Object a2 = k.a(this.b, "getPluginsEnabled");
            if (a2 != null) {
                z2 = ((Boolean) a2).booleanValue();
            }
            return z2;
        } else if (Build.VERSION.SDK_INT != 18) {
            return false;
        } else {
            if (WebSettings.PluginState.ON == this.b.getPluginState()) {
                z2 = true;
            }
            return z2;
        }
    }

    @Deprecated
    public synchronized PluginState getPluginState() {
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return PluginState.valueOf(iX5WebSettings.getPluginState().name());
        }
        if (z || this.b == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return null;
        }
        Object a2 = k.a(this.b, "getPluginState");
        if (a2 == null) {
            return null;
        }
        return PluginState.valueOf(((WebSettings.PluginState) a2).name());
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        String str;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getPluginsPath();
        }
        if (z || this.b == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT > 17) {
            return "";
        }
        Object a2 = k.a(this.b, "getPluginsPath");
        if (a2 == null) {
            str = null;
        } else {
            str = (String) a2;
        }
        return str;
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setJavaScriptCanOpenWindowsAutomatically(z);
        }
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getJavaScriptCanOpenWindowsAutomatically();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getJavaScriptCanOpenWindowsAutomatically();
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDefaultTextEncodingName(str);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setDefaultTextEncodingName(str);
        }
    }

    public synchronized String getDefaultTextEncodingName() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getDefaultTextEncodingName();
        }
        return iX5WebSettings.getDefaultTextEncodingName();
    }

    public static String getDefaultUserAgent(Context context) {
        Object a2;
        if (u.a().b()) {
            return u.a().c().i(context);
        }
        if (Build.VERSION.SDK_INT >= 17 && (a2 = k.a((Class<?>) android.webkit.WebSettings.class, "getDefaultUserAgent", (Class<?>[]) new Class[]{Context.class}, context)) != null) {
            return (String) a2;
        }
        return null;
    }

    public boolean getMediaPlaybackRequiresUserGesture() {
        Object a2;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getMediaPlaybackRequiresUserGesture();
        }
        if (z || this.b == null || Build.VERSION.SDK_INT < 17 || (a2 = k.a(this.b, "getMediaPlaybackRequiresUserGesture")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setMediaPlaybackRequiresUserGesture(z);
        } else if (!z2 && this.b != null && Build.VERSION.SDK_INT >= 17) {
            k.a(this.b, "setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setNeedInitialFocus(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setNeedInitialFocus(z);
        } else if (!z2 && (webSettings = this.b) != null) {
            webSettings.setNeedInitialFocus(z);
        }
    }

    public void setRenderPriority(RenderPriority renderPriority) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setRenderPriority(WebSettings.RenderPriority.valueOf(renderPriority.name()));
        }
    }

    public void setCacheMode(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setCacheMode(i);
        } else if (!z && (webSettings = this.b) != null) {
            webSettings.setCacheMode(i);
        }
    }

    public int getCacheMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getCacheMode();
        }
        if (z || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getCacheMode();
    }
}
