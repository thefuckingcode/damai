package com.youku.alixplayer.opensdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.drm.DrmInfo;
import android.drm.DrmInfoRequest;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import android.os.Build;
import android.util.Log;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.youku.alixplayer.opensdk.drm.DrmType;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.jl1;

/* compiled from: Taobao */
public class ProvisionAuthenticator {
    private static final String PROVISION_URL = "https://www.googleapis.cn/certificateprovisioning/v1/devicecertificates/create";
    private static final String TAG = "ProvisionAuthenticator";
    private static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
    private static MediaDrm mMediaDrm = null;
    private static boolean sCbcsSupported = false;
    private static boolean sCencSupported = false;
    private static boolean sHasChecked = false;
    private static boolean sIsProvisioned = false;
    private static boolean sPermanentDisableWidevine;
    private static WidevineLevel sWidevineLevel = WidevineLevel.L3;
    private static int sWidevineStatus = 0;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum DrmSupport {
        WV_SUPPORT_L1,
        WV_SUPPORT_L2,
        WV_SUPPORT_L3,
        WV_NO_PLUGIN,
        WV_PROVISION,
        WV_OS_VERSION,
        WV_CODEC_LIST,
        WV_BLACK_LIST,
        WV_CODEC_ERROR;

        /* access modifiers changed from: package-private */
        public int getBit() {
            return 1 << ordinal();
        }
    }

    /* compiled from: Taobao */
    public enum WidevineLevel {
        L1,
        L2,
        L3;

        /* access modifiers changed from: package-private */
        public int getBit() {
            return 1 << ordinal();
        }
    }

    public static void checkProvision() {
        if (!sHasChecked) {
            sHasChecked = true;
            fixedThreadPool.execute(new Runnable() {
                /* class com.youku.alixplayer.opensdk.utils.ProvisionAuthenticator.AnonymousClass1 */

                public void run() {
                    Logger.d(ProvisionAuthenticator.TAG, "start checkProvision");
                    ProvisionAuthenticator.checkWideVine();
                    ProvisionAuthenticator.checkWideVineLevel();
                    boolean unused = ProvisionAuthenticator.sCencSupported = ProvisionAuthenticator.isWidevineDrmSupported(DrmType.WV_CENC);
                    boolean unused2 = ProvisionAuthenticator.sCbcsSupported = ProvisionAuthenticator.isWidevineDrmSupported(DrmType.WV_CBCS);
                    ProvisionAuthenticator.checkWidevineStatus();
                    Logger.d(ProvisionAuthenticator.TAG, "end checkProvision");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(19)
    public static void checkWideVine() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                MediaDrm mediaDrm = new MediaDrm(WIDEVINE_UUID);
                mMediaDrm = mediaDrm;
                byte[] openSession = mediaDrm.openSession();
                if (openSession != null) {
                    mMediaDrm.closeSession(openSession);
                    sIsProvisioned = true;
                }
            } catch (UnsupportedSchemeException unused) {
                Logger.d("checkWideVine UnsupportedSchemeException");
            } catch (ResourceBusyException unused2) {
                Logger.d("checkWideVine ResourceBusyException");
            } catch (NotProvisionedException unused3) {
                Logger.d("checkWideVine NotProvisionedException");
                try {
                    doProvision();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable unused4) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static void checkWideVineLevel() {
        try {
            MediaDrm mediaDrm = new MediaDrm(WIDEVINE_UUID);
            sWidevineLevel = WidevineLevel.valueOf(mediaDrm.getPropertyString("securityLevel"));
            mediaDrm.release();
        } catch (UnsupportedSchemeException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (Throwable unused) {
        }
        Logger.d("WIDEVINE_DETECT", "widevine level:" + sWidevineLevel);
    }

    /* access modifiers changed from: private */
    public static void checkWidevineStatus() {
        sWidevineStatus |= getWidevineLevel().getBit();
        if (!hardwareRendererSupported()) {
            sWidevineStatus |= DrmSupport.WV_CODEC_LIST.getBit();
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 18 || !MediaDrm.isCryptoSchemeSupported(WIDEVINE_UUID)) {
            sWidevineStatus |= DrmSupport.WV_NO_PLUGIN.getBit();
        }
        if (!isProvisioned()) {
            sWidevineStatus |= DrmSupport.WV_PROVISION.getBit();
        }
        if (i <= 19) {
            sWidevineStatus |= DrmSupport.WV_OS_VERSION.getBit();
        }
        if (isInBlackList()) {
            sWidevineStatus |= DrmSupport.WV_BLACK_LIST.getBit();
        }
        if (isWidevinePermanentDisabled()) {
            sWidevineStatus |= DrmSupport.WV_CODEC_ERROR.getBit();
        }
    }

    @TargetApi(19)
    private static void doProvision() {
        Logger.d("doProvision");
        byte[] doQuest = doQuest(true);
        if (doQuest == null) {
            doQuest = doQuest(false);
        }
        if (doQuest != null) {
            try {
                mMediaDrm.provideProvisionResponse(doQuest);
                sIsProvisioned = true;
            } catch (Throwable th) {
                Logger.d("doProvision exception=" + th.getMessage());
            }
        }
    }

    @TargetApi(19)
    private static byte[] doQuest(boolean z) {
        Throwable th;
        Exception e;
        HttpURLConnection httpURLConnection;
        String str;
        MediaDrm.ProvisionRequest provisionRequest = mMediaDrm.getProvisionRequest();
        byte[] bArr = null;
        bArr = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            String defaultUrl = provisionRequest.getDefaultUrl();
            if (z) {
                int indexOf = defaultUrl.indexOf(63);
                if (indexOf > 0) {
                    str = (PROVISION_URL + defaultUrl.substring(indexOf)) + '&';
                } else {
                    str = PROVISION_URL + jl1.CONDITION_IF;
                }
            } else {
                str = defaultUrl + "&";
            }
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str + "signedRequest=" + new String(provisionRequest.getData(), "UTF-8")).openConnection();
            try {
                httpURLConnection3.setRequestMethod("POST");
                httpURLConnection3.setDoOutput(true);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setConnectTimeout(5000);
                httpURLConnection3.connect();
                if (httpURLConnection3.getResponseCode() == 200) {
                    bArr = inputStreamTOByte(httpURLConnection3.getInputStream());
                }
                httpURLConnection3.disconnect();
            } catch (Exception e2) {
                httpURLConnection = httpURLConnection3;
                e = e2;
                try {
                    e.printStackTrace();
                    httpURLConnection.disconnect();
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    httpURLConnection2.disconnect();
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection2 = httpURLConnection3;
                th = th3;
                httpURLConnection2.disconnect();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            e.printStackTrace();
            httpURLConnection.disconnect();
            return bArr;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection2.disconnect();
            throw th;
        }
        return bArr;
    }

    @TargetApi(18)
    public static WidevineLevel getWidevineLevel() {
        return sWidevineLevel;
    }

    public static int getWidevineStats() {
        return sWidevineStatus;
    }

    private static boolean hardwareRendererSupported() {
        return "HW".equals(ConfigFetcher.getInstance().getConfig("player_config", "decode_mode", "HW"));
    }

    private static byte[] inputStreamTOByte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[20480];
        while (true) {
            int read = inputStream.read(bArr, 0, 20480);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean isCbcsSupported() {
        return sCbcsSupported && !sPermanentDisableWidevine;
    }

    public static boolean isCencSupported() {
        return sCencSupported && !sPermanentDisableWidevine;
    }

    public static boolean isInBlackList() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("widevine_config", "widevine_blacklist", "0"));
    }

    public static boolean isProvisioned() {
        return sIsProvisioned;
    }

    /* access modifiers changed from: private */
    @TargetApi(18)
    public static boolean isWidevineDrmSupported(DrmType drmType) {
        int i;
        if (isInBlackList() || (i = Build.VERSION.SDK_INT) < 18 || !hardwareRendererSupported() || !MediaDrm.isCryptoSchemeSupported(WIDEVINE_UUID) || !isProvisioned()) {
            return false;
        }
        if (drmType == DrmType.WV_CENC) {
            if (i >= 21) {
                return true;
            }
            return false;
        } else if (drmType != DrmType.WV_CBCS || i < 25) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isWidevineL1(Context context) {
        Object obj;
        int i = -1;
        try {
            DrmInfo acquireDrmInfo = new DrmManagerClient(context).acquireDrmInfo(new DrmInfoRequest(1, DXRecyclerLayout.LOAD_MORE_EMPTY));
            if (!(acquireDrmInfo == null || (obj = acquireDrmInfo.get("WVDrmInfoRequestStatusKey")) == null)) {
                i = Integer.parseInt((String) obj);
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("widevine Level 1 support:");
        sb.append(i == 0 ? "true" : "false");
        Log.d("WIDEVINE_DETECT", sb.toString());
        if (i == 0) {
            return true;
        }
        return false;
    }

    public static boolean isWidevinePermanentDisabled() {
        return sPermanentDisableWidevine;
    }

    public static void setPermanentDisableWidevine(boolean z) {
        sPermanentDisableWidevine = z;
    }
}
