package org.android.spdy;

import android.content.Context;
import cn.damai.h5container.H5MainActivity;
import com.alipay.sdk.m.n.a;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tb.o70;

/* compiled from: Taobao */
public final class SpdyAgent {
    public static final int ACCS_ONLINE_SERVER = 1;
    public static final int ACCS_TEST_SERVER = 0;
    private static final long DEFAULT_XQUIC_CACHE_EXPIRED_TIME = 604800000;
    private static final boolean HAVE_CLOSE = false;
    private static final int KB32 = 32768;
    private static final int KB8 = 8192;
    private static final int MAX_SPDY_SESSION_COUNT = 50;
    private static final int MB5 = 5242880;
    static final int SPDY_CUSTOM_CONTROL_FRAME_RECV = 4106;
    static final int SPDY_DATA_CHUNK_RECV = 4097;
    static final int SPDY_DATA_RECV = 4098;
    static final int SPDY_DATA_SEND = 4099;
    static final int SPDY_PING_RECV = 4101;
    static final int SPDY_REQUEST_RECV = 4102;
    static final int SPDY_SESSION_CLOSE = 4103;
    static final int SPDY_SESSION_CREATE = 4096;
    static final int SPDY_SESSION_FAILED_ERROR = 4105;
    static final int SPDY_STREAM_CLOSE = 4100;
    static final int SPDY_STREAM_RESPONSE_RECV = 4104;
    private static final String TNET_SO_VERSION = "tnet-4.0.0";
    private static final String XQUIC_SO_VERSION = "xquic";
    private static Object domainHashLock = new Object();
    private static HashMap<String, Integer> domainHashMap = new HashMap<>();
    public static volatile boolean enableDebug;
    public static volatile boolean enableTimeGaurd;
    private static volatile SpdyAgent gSingleInstance = null;
    private static volatile boolean loadSucc = false;
    private static Object lock = new Object();
    private static final Lock r;
    private static final ReentrantReadWriteLock rwLock;
    private static int totalDomain = 0;
    private static final Lock w;
    private static volatile boolean xquicLoadSucc = false;
    private AccsSSLCallback accsSSLCallback;
    private long agentNativePtr;
    private AtomicBoolean closed = new AtomicBoolean();
    private Context context = null;
    private volatile boolean enable_header_cache = true;
    private String proxyPassword = null;
    private String proxyUsername = null;
    private HashMap<String, SpdySession> sessionMgr = new HashMap<>(5);
    private LinkedList<SpdySession> sessionQueue = new LinkedList<>();
    private final QuicCacher xqcCache = new SecurityGuardCacherImp();

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        rwLock = reentrantReadWriteLock;
        r = reentrantReadWriteLock.readLock();
        w = reentrantReadWriteLock.writeLock();
    }

    private SpdyAgent(Context context2, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback2) throws UnsatisfiedLinkError {
        try {
            SoInstallMgrSdk.init(context2);
            try {
                xquicLoadSucc = SoInstallMgrSdk.initSo(XQUIC_SO_VERSION, 1);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            this.agentNativePtr = initAgent(spdyVersion.getInt(), spdySessionKind.getint(), SslVersion.SLIGHT_VERSION_V1.getint());
            this.accsSSLCallback = accsSSLCallback2;
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        this.context = context2;
        this.closed.set(false);
    }

    private int AndroidVerifyProof(String[] strArr) {
        return QuicProofVerifier.VerifyProof(null, strArr);
    }

    @Deprecated
    public static void InitializeCerts() {
    }

    static void InvlidCharJudge(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 255) < 32 || (bArr[i] & 255) > 126) {
                bArr[i] = 63;
            }
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if ((bArr2[i2] & 255) < 32 || (bArr2[i2] & 255) > 126) {
                bArr2[i2] = 63;
            }
        }
    }

    private void agentIsOpen() {
        if (!this.closed.get()) {
            checkLoadSo();
            return;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_ASYNC_CLOSE", (int) TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
    }

    private void bioPingRecvCallback(SpdySession spdySession, int i) {
        spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.bioPingRecvCallback(spdySession, i);
        }
    }

    private void checkLoadSo() throws SpdyErrorException {
        if (!loadSucc) {
            try {
                synchronized (lock) {
                    if (!loadSucc) {
                        loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
                        this.agentNativePtr = initAgent(0, 0, 0);
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            return;
        }
        if (!loadSucc) {
            throw new SpdyErrorException("TNET_JNI_ERR_LOAD_SO_FAIL", (int) TnetStatusCode.TNET_JNI_ERR_LOAD_SO_FAIL);
        }
    }

    public static boolean checkLoadSucc() {
        return loadSucc;
    }

    private void clearMultiPathProtocolModeFlag(SpdySession spdySession) {
        spdySession.setMode(spdySession.getMode() & -2049);
    }

    private native int closeSessionN(long j);

    private byte[] commonCacheLoad(final String str, int i) {
        byte[] load = this.xqcCache.load(str);
        if (i == 1) {
            return load;
        }
        byte[] bArr = null;
        if (load != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                String str2 = new String(load, 0, load.length);
                int indexOf = str2.indexOf(o70.DINAMIC_PREFIX_AT);
                if (!(indexOf == -1 || indexOf == 0)) {
                    String substring = str2.substring(0, indexOf);
                    if (substring == null) {
                        return null;
                    }
                    long parseLong = Long.parseLong(substring);
                    String substring2 = str2.substring(indexOf + 1);
                    if (substring2 != null) {
                        bArr = substring2.getBytes();
                    }
                    if (parseLong + 604800000 < currentTimeMillis) {
                        spduLog.Logd("tnet-jni", "xquic cache is expired");
                        e.b(new Runnable() {
                            /* class org.android.spdy.SpdyAgent.AnonymousClass2 */

                            public void run() {
                                SpdyAgent.this.xqcCache.remove(str);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return bArr;
    }

    private boolean commonCacheStore(final String str, final String str2, int i) {
        if (!(str == null || str2 == null)) {
            if (1 != i) {
                try {
                    str2 = generatePersistValueByTimeAndValue(str2);
                } catch (Throwable unused) {
                    spduLog.Loge("tnet-jni", "commonCacheStore fail");
                }
            }
            e.b(new Runnable() {
                /* class org.android.spdy.SpdyAgent.AnonymousClass1 */

                public void run() {
                    SpdyAgent.this.xqcCache.store(str, str2);
                }
            });
            return true;
        }
        return false;
    }

    public static int configIpStackMode(int i) {
        spduLog.Logi("tnet-jni", "[configIpStackMode] - ", (long) i);
        return configIpStackModeN(i);
    }

    private static native int configIpStackModeN(int i);

    private native int configLogFileN(String str, int i, int i2);

    private native int configLogFileN(String str, int i, int i2, int i3);

    private static void crashReporter(int i) {
    }

    private native long createSessionN(long j, SpdySession spdySession, int i, byte[] bArr, char c, byte[] bArr2, char c2, byte[] bArr3, byte[] bArr4, Object obj, int i2, int i3, int i4, byte[] bArr5, int i5, int i6, int i7);

    static byte[] dataproviderToByteArray(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider) {
        byte[] bArr;
        headJudge(spdyRequest.getHeaders());
        if (spdyDataProvider == null) {
            return null;
        }
        String mapBodyToString = mapBodyToString(spdyDataProvider.postBody);
        if (mapBodyToString != null) {
            bArr = mapBodyToString.getBytes();
        } else {
            bArr = spdyDataProvider.data;
        }
        if (bArr == null || bArr.length < 5242880) {
            return bArr;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + bArr.length, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    private native int freeAgent(long j);

    private String generatePersistValueByTimeAndValue(String str) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        return valueOf + o70.DINAMIC_PREFIX_AT + str;
    }

    private int getDomainHashIndex(String str) {
        Integer num;
        synchronized (domainHashLock) {
            num = domainHashMap.get(str);
            if (num == null) {
                HashMap<String, Integer> hashMap = domainHashMap;
                int i = totalDomain + 1;
                totalDomain = i;
                hashMap.put(str, Integer.valueOf(i));
                num = Integer.valueOf(totalDomain);
            }
        }
        return num.intValue();
    }

    public static SpdyAgent getInstance(Context context2, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind) throws UnsatisfiedLinkError, SpdyErrorException {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context2, spdyVersion, spdySessionKind, null);
                }
            }
        }
        return gSingleInstance;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    private int getNetWorkStatus() {
        boolean b = c.b();
        int i = b;
        if (c.a()) {
            boolean z = b ? 1 : 0;
            boolean z2 = b ? 1 : 0;
            i = z | true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("networkStatusFlag = ");
        int i2 = i == true ? 1 : 0;
        int i3 = i == true ? 1 : 0;
        int i4 = i == true ? 1 : 0;
        sb.append(i2);
        spduLog.Logi("tnet-jni", sb.toString());
        return i;
    }

    private void getPerformance(SpdySession spdySession, SslPermData sslPermData) {
    }

    private byte[] getSSLMeta(SpdySession spdySession) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[getSSLMeta] - session is null");
            return null;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb != null) {
            return intenalcb.getSSLMeta(spdySession);
        }
        spduLog.Logi("tnet-jni", "[getSSLMeta] - session.intenalcb is null");
        return null;
    }

    private byte[] getSSLPublicKey(int i, byte[] bArr) {
        AccsSSLCallback accsSSLCallback2 = this.accsSSLCallback;
        if (accsSSLCallback2 != null) {
            return accsSSLCallback2.getSSLPublicKey(i, bArr);
        }
        spduLog.Logd("tnet-jni", "[getSSLPublicKey] - accsSSLCallback is null.");
        return null;
    }

    private native long getSession(long j, byte[] bArr, char c);

    static void headJudge(Map<String, String> map) {
        if (map != null) {
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                InvlidCharJudge(key.getBytes(), value.getBytes());
                i += key.length() + 1 + value.length();
                securityCheck(i, value.length());
            }
        }
    }

    private native long initAgent(int i, int i2, int i3);

    @Deprecated
    public static void inspect(String str) {
    }

    private native void logFileCloseN();

    private native void logFileFlushN();

    static String mapBodyToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            return null;
        }
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append(a.h);
            sb.append(value);
            sb.append('&');
            i += key.length() + 1 + value.length();
            tableListJudge(i);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    static String[] mapToByteArray(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        String[] strArr = new String[(map.size() * 2)];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            strArr[i] = entry.getKey();
            strArr[i + 1] = entry.getValue();
            i += 2;
        }
        return strArr;
    }

    private int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[putSSLMeta] - session is null");
            return -1;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb != null) {
            return intenalcb.putSSLMeta(spdySession, bArr);
        }
        spduLog.Logi("tnet-jni", "[putSSLMeta] - session.intenalcb is null");
        return -1;
    }

    static void securityCheck(int i, int i2) {
        if (i >= 32768) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        } else if (i2 >= 8192) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:value=" + i2, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    private native int setConTimeout(long j, int i);

    private native int setSessionKind(long j, int i);

    private void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyCustomControlFrameFailCallback(spdySession, obj, i, i2);
        }
    }

    private void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyCustomControlFrameRecvCallback(spdySession, obj, i, i2, i3, i4, bArr);
        }
    }

    private void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, int i, SpdyByteArray spdyByteArray, int i2) {
        spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataChunkRecvCB(spdySession, z, j, spdyByteArray, i2);
        }
    }

    private void spdyDataRecvCallback(SpdySession spdySession, boolean z, int i, int i2, int i3) {
        spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataRecvCallback(spdySession, z, j, i2, i3);
        }
    }

    private void spdyDataSendCallback(SpdySession spdySession, boolean z, int i, int i2, int i3) {
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataSendCallback(spdySession, z, j, i2, i3);
        }
    }

    private void spdyPingRecvCallback(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyPingRecvCallback(spdySession, (long) i, obj);
        }
    }

    private void spdyRequestRecvCallback(SpdySession spdySession, int i, int i2) {
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyRequestRecvCallback(spdySession, j, i2);
        }
    }

    private void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - errorCode = ", (long) i);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session is null");
        } else {
            spdySession.setSuperviseConnectInfoOnDisconnectedCB(superviseConnectInfo);
            try {
                Intenalcb intenalcb = spdySession.intenalcb;
                if (intenalcb == null) {
                    spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session.intenalcb is null");
                } else {
                    intenalcb.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i);
                }
            } finally {
                spdySession.cleanUp();
            }
        }
        spdySession.releasePptr();
    }

    private void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session.intenalcb is null");
        } else {
            spdySession.setSuperviseConnectInfoOnConnectedCB(superviseConnectInfo);
            spdySession.intenalcb.spdySessionConnectCB(spdySession, superviseConnectInfo);
        }
    }

    private void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[spdySessionFailedError] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session is null");
        } else {
            try {
                Intenalcb intenalcb = spdySession.intenalcb;
                if (intenalcb == null) {
                    spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session.intenalcb is null");
                } else {
                    intenalcb.spdySessionFailedError(spdySession, i, obj);
                }
            } finally {
                spdySession.cleanUp();
            }
        }
        spdySession.releasePptr();
    }

    private void spdySessionOnWritable(SpdySession spdySession, Object obj, int i) {
        spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session is null");
            return;
        }
        try {
            Intenalcb intenalcb = spdySession.intenalcb;
            if (intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session.intenalcb is null");
            } else {
                intenalcb.spdySessionOnWritable(spdySession, obj, i);
            }
        } catch (Throwable th) {
            spduLog.Loge("tnet-jni", "[spdySessionOnWritable] - exception:", th);
        }
    }

    private void spdyStreamCloseCallback(SpdySession spdySession, int i, int i2, int i3, SuperviseData superviseData) {
        spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyStreamCloseCallback(spdySession, j, i2, i3, superviseData);
        }
    }

    private void spdyStreamResponseRecv(SpdySession spdySession, int i, byte[] bArr, int[] iArr, int i2) {
        spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - ");
        String[] strArr = new String[iArr.length];
        int i3 = 0;
        if (this.enable_header_cache) {
            b b = b.b();
            int i4 = 0;
            while (i3 < iArr.length) {
                strArr[i3] = b.a(ByteBuffer.wrap(bArr, i4, iArr[i3]));
                int i5 = i4 + iArr[i3];
                int i6 = i3 + 1;
                if (iArr[i6] > 32) {
                    strArr[i6] = new String(bArr, i5, iArr[i6]);
                } else {
                    strArr[i6] = b.a(ByteBuffer.wrap(bArr, i5, iArr[i6]));
                }
                i4 = i5 + iArr[i6];
                i3 += 2;
            }
        } else {
            int i7 = 0;
            while (i3 < iArr.length) {
                try {
                    strArr[i3] = new String(bArr, i7, iArr[i3], "utf-8");
                    i7 += iArr[i3];
                    int i8 = i3 + 1;
                    strArr[i8] = new String(bArr, i7, iArr[i8], "utf-8");
                    i7 += iArr[i8];
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                i3 += 2;
            }
        }
        Map<String, List<String>> stringArrayToMap = stringArrayToMap(strArr);
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session.intenalcb is null");
        } else {
            intenalcb.spdyOnStreamResponse(spdySession, j, stringArrayToMap, i2);
        }
    }

    static Map<String, List<String>> stringArrayToMap(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap(5);
        int i = 0;
        while (true) {
            int i2 = i + 2;
            if (i2 <= strArr.length) {
                if (strArr[i] == null) {
                    break;
                }
                int i3 = i + 1;
                if (strArr[i3] == null) {
                    break;
                }
                List list = (List) hashMap.get(strArr[i]);
                if (list == null) {
                    list = new ArrayList(1);
                    hashMap.put(strArr[i], list);
                }
                list.add(strArr[i3]);
                i = i2;
            } else {
                return hashMap;
            }
        }
        return null;
    }

    static void tableListJudge(int i) {
        if (i >= 5242880) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    public void InitializeSecurityStuff() {
        this.xqcCache.init(this.context);
        a.e().a();
        spduLog.Logd("tnet-jni", "[InitializeSecurityStuff] -  complete");
    }

    public native String ResolveHost(String str, String str2, int i);

    @Deprecated
    public int VerifyProof(String str, int i, String str2, String str3, String[] strArr, String str4) {
        return 0;
    }

    @Deprecated
    public byte[] cacher_load(String str) {
        return null;
    }

    @Deprecated
    public boolean cacher_store(String str, String str2) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void clearSpdySession(String str, String str2, int i) {
        if (str != null) {
            Lock lock2 = w;
            lock2.lock();
            try {
                HashMap<String, SpdySession> hashMap = this.sessionMgr;
                hashMap.remove(str + str2 + i);
                lock2.unlock();
            } catch (Throwable th) {
                w.unlock();
                throw th;
            }
        }
    }

    public void close() {
    }

    /* access modifiers changed from: package-private */
    public int closeSession(long j) {
        return closeSessionN(j);
    }

    public int configLogFile(String str, int i, int i2) {
        if (loadSucc) {
            return configLogFileN(str, i, i2);
        }
        return -1;
    }

    @Deprecated
    public SpdySession createSession(String str, Object obj, SessionCb sessionCb, int i) throws SpdyErrorException {
        return createSession(str, "", obj, sessionCb, null, i, 0);
    }

    public void disableHeaderCache() {
        this.enable_header_cache = false;
    }

    public HashMap<String, SpdySession> getAllSession() {
        return this.sessionMgr;
    }

    public void logFileClose() {
        if (loadSucc) {
            logFileFlushN();
            logFileCloseN();
        }
    }

    public void logFileFlush() {
        if (loadSucc) {
            logFileFlushN();
        }
    }

    /* access modifiers changed from: package-private */
    public void removeSession(SpdySession spdySession) {
        Lock lock2 = w;
        lock2.lock();
        try {
            this.sessionQueue.remove(spdySession);
            lock2.unlock();
        } catch (Throwable th) {
            w.unlock();
            throw th;
        }
    }

    public void setAccsSslCallback(AccsSSLCallback accsSSLCallback2) {
        spduLog.Logi("tnet-jni", "[setAccsSslCallback] - ", accsSSLCallback2.getClass());
        this.accsSSLCallback = accsSSLCallback2;
    }

    @Deprecated
    public int setConnectTimeOut(int i) {
        agentIsOpen();
        try {
            return setConTimeout(this.agentNativePtr, i);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void setProxyUsernamePassword(String str, String str2) {
        this.proxyUsername = str;
        this.proxyPassword = str2;
    }

    @Deprecated
    public int setSessionKind(SpdySessionKind spdySessionKind) {
        agentIsOpen();
        try {
            return setSessionKind(this.agentNativePtr, spdySessionKind.getint());
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i) throws SpdyErrorException {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i, 0, spdyRequest.getConnectionTimeoutMs());
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    @Deprecated
    public void switchAccsServer(int i) {
    }

    public int configLogFile(String str, int i, int i2, int i3) {
        if (loadSucc) {
            return configLogFileN(str, i, i2, i3);
        }
        return -1;
    }

    @Deprecated
    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, int i) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, null, i, 0);
    }

    @Deprecated
    public SpdySession createSession(String str, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i) throws SpdyErrorException {
        return createSession(str, "", obj, sessionCb, sslCertcb, i, 0);
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2) throws SpdyErrorException {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i, i2, spdyRequest.getConnectionTimeoutMs());
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    public SpdySession createSession(SessionInfo sessionInfo) throws SpdyErrorException {
        return createSession(sessionInfo.getAuthority(), sessionInfo.getDomain(), sessionInfo.getSessonUserData(), sessionInfo.getSessionCb(), null, sessionInfo.getMode(), sessionInfo.getPubKeySeqNum(), sessionInfo.getConnectionTimeoutMs(), sessionInfo.getCertHost(), sessionInfo.getXquicCongControl(), sessionInfo.getXquicPacing(), sessionInfo.getXquicLossDetect());
    }

    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i, int i2) throws SpdyErrorException {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, null, i, i2);
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i) throws SpdyErrorException {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, (SslCertcb) null, i);
    }

    @Deprecated
    public static SpdyAgent getInstance(Context context2, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback2) throws UnsatisfiedLinkError, SpdyErrorException {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context2, spdyVersion, spdySessionKind, accsSSLCallback2);
                }
            }
        }
        return gSingleInstance;
    }

    @Deprecated
    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i, i2, -1);
    }

    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2, int i3) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i, i2, i3, null, 0, 0);
    }

    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2, int i3, String str3) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i, i2, i3, str3, 0, 0);
    }

    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2, int i3, String str3, int i4, int i5) {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i, i2, i3, str3, i4, i5, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r37v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01ff  */
    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2, int i3, String str3, int i4, int i5, boolean z) throws SpdyErrorException {
        char c;
        byte[] bArr;
        String str4;
        SpdySession spdySession;
        Throwable th;
        SpdySession spdySession2;
        byte[] bArr2;
        SpdySession spdySession3;
        long j;
        int i6;
        if (str != null) {
            String[] split = str.split("/");
            int lastIndexOf = split[0].lastIndexOf(58);
            String substring = split[0].substring(0, lastIndexOf);
            String substring2 = split[0].substring(lastIndexOf + 1);
            byte[] bytes = "0.0.0.0".getBytes();
            if (split.length == 1 || (i & H5MainActivity.REQUEST_REALNAME) != 0) {
                str4 = str + "/0.0.0.0:0";
                bArr = bytes;
                c = 0;
            } else {
                String[] split2 = split[1].split(":");
                byte[] bytes2 = split2[0].getBytes();
                str4 = str;
                c = (char) Integer.parseInt(split2[1]);
                bArr = bytes2;
            }
            agentIsOpen();
            Lock lock2 = r;
            lock2.lock();
            try {
                SpdySession spdySession4 = this.sessionMgr.get(str4 + str2 + i);
                boolean z2 = this.sessionMgr.size() >= 50;
                lock2.unlock();
                if (z2) {
                    throw new SpdyErrorException("SPDY_SESSION_EXCEED_MAXED: session count exceed max", (int) TnetStatusCode.TNET_SESSION_EXCEED_MAXED);
                } else if (spdySession4 != null) {
                    spdySession4.increRefCount();
                    return spdySession4;
                } else {
                    w.lock();
                    SpdySession spdySession5 = null;
                    try {
                        spdySession = this.sessionMgr.get(str4 + str2 + i);
                    } catch (Throwable unused) {
                        spdySession = null;
                    }
                    if (spdySession != null) {
                        w.unlock();
                        spdySession.increRefCount();
                        return spdySession;
                    }
                    try {
                        SpdySession spdySession6 = new SpdySession(0, this, str4, str2, sessionCb, i, i2, obj);
                        if (!((i & 256) == 0 && (i & 4) == 0)) {
                            if (!xquicLoadSucc) {
                                throw new SpdyErrorException("create xquic session fail, because xquic so load fail", (int) TnetStatusCode.TNET_JNI_ERR_LOAD_XQC_SO_FAIL);
                            } else if (str3 == null) {
                                throw new SpdyErrorException("create xquic session fail, because certHost is null", (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
                            }
                        }
                        if (spdySession6.isMultiPathMode()) {
                            spdySession2 = spdySession6;
                            clearMultiPathProtocolModeFlag(spdySession2);
                        } else {
                            spdySession2 = spdySession6;
                        }
                        if (str3 == null) {
                            bArr2 = null;
                        } else {
                            bArr2 = str3.getBytes();
                        }
                        int domainHashIndex = getDomainHashIndex(str2 + i);
                        if ((i & 4) != 0) {
                            if ((i & 16) == 0) {
                                throw new SpdyErrorException("TNET_JNI_ERR_PROTOCOL_NOT_SUPPORT : QUIC protocol not support used alone", (int) TnetStatusCode.TNET_JNI_ERR_PROTOCOL_NOT_SUPPORT);
                            }
                        }
                        if (i != 0 && spdySession2.getMode() == 0) {
                            spdySession2.setMode(i);
                        }
                        if (this.proxyUsername != null) {
                            try {
                                if (this.proxyPassword != null) {
                                    spdySession3 = spdySession2;
                                    j = createSessionN(this.agentNativePtr, spdySession2, domainHashIndex, substring.getBytes(), (char) Integer.parseInt(substring2), bArr, c, this.proxyUsername.getBytes(), this.proxyPassword.getBytes(), obj, i, i2, i3, bArr2, i4, i5, z ? 1 : 0);
                                    spduLog.Logi("tnet-jni", " create new session: ", str);
                                    if ((j & 1) != 1) {
                                        i6 = (int) (j >> 1);
                                        j = 0;
                                    } else {
                                        i6 = 0;
                                    }
                                    if (j == 0) {
                                        spdySession3.setSessionNativePtr(j);
                                        try {
                                            this.sessionMgr.put(str4 + str2 + i, spdySession3);
                                            this.sessionQueue.add(spdySession3);
                                            spdySession5 = spdySession3;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            w.unlock();
                                            throw th;
                                        }
                                    } else if (i6 != 0) {
                                        throw new SpdyErrorException("create session error: " + i6, i6);
                                    }
                                    w.unlock();
                                    return spdySession5;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                w.unlock();
                                throw th;
                            }
                        }
                        spdySession3 = spdySession2;
                        j = createSessionN(this.agentNativePtr, spdySession3, domainHashIndex, substring.getBytes(), (char) Integer.parseInt(substring2), bArr, c, null, null, obj, i, i2, i3, bArr2, i4, i5, z);
                        spduLog.Logi("tnet-jni", " create new session: ", str);
                        if ((j & 1) != 1) {
                        }
                        if (j == 0) {
                        }
                        w.unlock();
                        return spdySession5;
                    } catch (Throwable th4) {
                        th = th4;
                        w.unlock();
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                r.unlock();
                throw th5;
            }
        } else {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM", (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }
}
