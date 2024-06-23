package android.taobao.windvane.ha;

import android.os.Handler;
import android.os.HandlerThread;
import android.taobao.windvane.WVPerformanceManager;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.extra.uc.preRender.BasePreInitManager;
import android.taobao.windvane.grey.GreyPageInfo;
import android.taobao.windvane.grey.GreyPageManager;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.uc.webview.export.WebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class UCHAReporter {
    private static UCHAReporter INSTANCE = null;
    public static final String TAG = "UCHAReporter";
    private static long commonID;
    private static Runnable mLogRunnable = new Runnable() {
        /* class android.taobao.windvane.ha.UCHAReporter.AnonymousClass1 */

        public void run() {
            UCHAReporter.getInstance().commitUCHA();
        }
    };
    private String activityName = "";
    private String currentUrl = "";
    private String linkId = "";
    private LruCache<String, String> linkIdUrlCache = new LruCache<>(10);
    private Handler logHandler = null;
    private int minUploadInterval = 1000;
    private int reportType = -1;
    private StringBuffer sb = new StringBuffer();
    private WeakReference<WebView> webViewWeakReference;

    private UCHAReporter() {
        HandlerThread handlerThread = new HandlerThread("UC_HA");
        handlerThread.start();
        this.logHandler = new Handler(handlerThread.getLooper());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void commitUCHA() {
        GreyPageInfo greyPageInfo;
        if (!TextUtils.isEmpty(this.sb) && !WVPerformanceManager.getInstance().getConfig().closeUCHA()) {
            HashMap hashMap = new HashMap();
            String str = this.linkId;
            String remove = str != null ? this.linkIdUrlCache.remove(str) : this.currentUrl;
            hashMap.put("url", remove);
            hashMap.put("error", this.sb.toString());
            if (this.reportType == 0 && !TextUtils.isEmpty(remove) && (greyPageInfo = GreyPageManager.getInstance().getGreyPageInfo(remove)) != null) {
                String str2 = TAG;
                TaoLog.v(str2, "found grey page: " + remove);
                hashMap.put(GreyPageInfo.KEY_AIR_TAG, greyPageInfo.generateOutputString());
            }
            int i = this.reportType;
            String str3 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? "" : "WindVane.Memory" : "WindVane.BlackScreen" : "WindVane.UCHAR" : "TEMP_H5_ERROR_EVENT";
            if (!TextUtils.isEmpty(str3)) {
                WVHAManager.commitData(str3, remove, String.valueOf(commonID), this.activityName, hashMap);
            }
            StringBuffer stringBuffer = this.sb;
            stringBuffer.delete(0, stringBuffer.length());
            end();
        }
    }

    private void end() {
        this.logHandler.removeCallbacks(mLogRunnable);
    }

    public static UCHAReporter getInstance() {
        if (INSTANCE == null) {
            synchronized (UCHAReporter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UCHAReporter();
                }
            }
        }
        return INSTANCE;
    }

    private boolean isPreRenderPage(int i, String str) {
        if (i != 0) {
            return false;
        }
        try {
            if (!WVCommonConfig.commonConfig.skipPreRenderBackgroundWhitePage) {
                return false;
            }
            String str2 = str != null ? this.linkIdUrlCache.get(str) : this.currentUrl;
            if (TextUtils.isEmpty(str2) || !str2.contains(BasePreInitManager.PRE_RENDER_URL_ADDITION_JUDGE)) {
                String str3 = TAG;
                TaoLog.e(str3, "upload white page :" + str2);
                return false;
            }
            TaoLog.e(TAG, "IPreRenderWebView skip upload white page");
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void putLinkIdWithUrl(String str, String str2) {
        this.linkIdUrlCache.put(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void reset(String str, String str2) {
        commitUCHA();
        this.currentUrl = str;
        commonID = System.currentTimeMillis();
        this.activityName = str2;
    }

    public void set(String str, int i, String str2) {
        if (!isPreRenderPage(i, str2)) {
            this.logHandler.removeCallbacks(mLogRunnable);
            if (!TextUtils.equals(this.linkId, str2)) {
                if (!TextUtils.isEmpty(this.linkId)) {
                    commitUCHA();
                }
                this.linkId = str2;
            }
            this.reportType = i;
            this.logHandler.postDelayed(mLogRunnable, (long) this.minUploadInterval);
            StringBuffer stringBuffer = this.sb;
            stringBuffer.append(str);
            stringBuffer.append(StringUtils.LF);
        }
    }

    public void setWebview(WebView webView) {
        this.webViewWeakReference = new WeakReference<>(webView);
    }
}
