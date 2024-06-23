package tb;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import anet.channel.status.NetworkStatusHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.compat.mtop.MtopConnectTimeoutException;
import com.taobao.phenix.compat.mtop.MtopIndifferentException;
import com.taobao.phenix.loader.network.HttpCodeResponseException;
import com.taobao.phenix.loader.network.HttpLoader;
import com.youku.alixplayer.MsgID;
import com.youku.phone.xcdnengine.Xcdn;
import com.youku.phone.xcdnengine.XcdnEngine;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.text.o;
import mtopsdk.mtop.util.ErrorConstant;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class b03 implements HttpLoader {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private XcdnEngine a;
    private final rf1 b;
    private final Context c;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final String b(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2145300885")) {
                return (String) ipChange.ipc$dispatch("2145300885", new Object[]{this, str});
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                Charset charset = ph.UTF_8;
                if (str != null) {
                    byte[] bytes = str.getBytes(charset);
                    k21.h(bytes, "(this as java.lang.String).getBytes(charset)");
                    instance.update(bytes);
                    byte[] digest = instance.digest();
                    StringBuilder sb = new StringBuilder();
                    k21.h(digest, "messageDigest");
                    for (byte b : digest) {
                        String hexString = Integer.toHexString(b & 255);
                        while (hexString.length() < 2) {
                            hexString = YKUpsConvert.CHAR_ZERO + hexString;
                        }
                        sb.append(hexString);
                    }
                    String sb2 = sb.toString();
                    k21.h(sb2, "hexString.toString()");
                    return sb2;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            } catch (Error e2) {
                e2.printStackTrace();
                return "";
            }
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements XcdnEngine.Callback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ b03 a;
        final /* synthetic */ String b;
        final /* synthetic */ HttpLoader.FinishCallback c;

        b(b03 b03, String str, HttpLoader.FinishCallback finishCallback) {
            this.a = b03;
            this.b = str;
            this.c = finishCallback;
        }

        @Override // com.youku.phone.xcdnengine.XcdnEngine.Callback, com.youku.phone.xcdn.api.IXcdnCallback
        public final void onEvent(long j, int i, int i2, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1182055195")) {
                ipChange.ipc$dispatch("-1182055195", new Object[]{this, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
            } else if (i != 8) {
            } else {
                if (i2 == 32) {
                    if (this.a.e(this.b) != null) {
                        this.c.onFinished(new r02(this.a.e(this.b), 0, (int) new File(this.b).length()));
                    } else {
                        this.c.onError(new HttpCodeResponseException(10000));
                    }
                } else if (i2 <= 1000 || i2 >= 2000) {
                    this.c.onError(new HttpCodeResponseException(i2));
                } else if (!NetworkStatusHelper.n()) {
                    this.c.onError(new MtopIndifferentException(-200, ErrorConstant.ERRMSG_NO_NETWORK));
                } else {
                    this.c.onError(new MtopConnectTimeoutException(i2));
                }
            }
        }
    }

    public b03(@NotNull Context context) {
        k21.i(context, "mContext");
        this.c = context;
        this.b = new rf1(context);
    }

    private final boolean b(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "258994239")) {
            return o.L(str, "http", false, 2, null);
        }
        return ((Boolean) ipChange.ipc$dispatch("258994239", new Object[]{this, str})).booleanValue();
    }

    private final boolean c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022176629")) {
            return ((Boolean) ipChange.ipc$dispatch("2022176629", new Object[]{this, str})).booleanValue();
        }
        Uri parse = Uri.parse(str);
        k21.h(parse, "uri");
        String host = parse.getHost();
        if (host == null || !k21.d(host, "gw.alicdn.com")) {
            return false;
        }
        return true;
    }

    private final Future<?> d(String str, Map<String, String> map, boolean z, HttpLoader.FinishCallback finishCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1980355425")) {
            return (Future) ipChange.ipc$dispatch("-1980355425", new Object[]{this, str, map, Boolean.valueOf(z), finishCallback});
        }
        if (this.a == null) {
            this.a = new XcdnEngine(this.c);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("biz_id", z ? "27" : "9");
        hashMap.put(Xcdn.Config.CONFIG_USE_MINER, z ? "1" : "0");
        hashMap.put("support_http", "1");
        hashMap.put("dwn_prio", "2");
        hashMap.put(Xcdn.Config.CONFIG_START_TIMEMS, String.valueOf(System.currentTimeMillis()) + "");
        hashMap.put("retry_count", "1");
        StringBuilder sb = new StringBuilder();
        File cacheDir = this.c.getCacheDir();
        k21.h(cacheDir, "mContext.cacheDir");
        sb.append(cacheDir.getAbsolutePath());
        sb.append("/xcdn-file/");
        sb.append(Companion.b(str));
        String sb2 = sb.toString();
        XcdnEngine xcdnEngine = this.a;
        k21.f(xcdnEngine);
        long xcdnDownload = xcdnEngine.xcdnDownload(str, sb2, hashMap, new b(this, sb2, finishCallback));
        if (xcdnDownload >= 0) {
            return null;
        }
        finishCallback.onError(new HttpCodeResponseException((int) xcdnDownload));
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0074 A[SYNTHETIC, Splitter:B:37:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007d A[SYNTHETIC, Splitter:B:42:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0088 A[SYNTHETIC, Splitter:B:49:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0091 A[SYNTHETIC, Splitter:B:54:0x0091] */
    private final byte[] e(String str) {
        FileChannel fileChannel;
        FileInputStream fileInputStream;
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683130594")) {
            return (byte[]) ipChange.ipc$dispatch("683130594", new Object[]{this, str});
        }
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                fileChannel = fileInputStream.getChannel();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ByteBuffer allocate = ByteBuffer.allocate(MsgID.MEDIA_INFO_VIDEO_START_RECOVER);
                    while (true) {
                        int read = fileChannel.read(allocate);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(allocate.array(), 0, read);
                        allocate.position(0);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        fileInputStream.close();
                    } catch (Exception unused) {
                        Log.e("XcdnLoader", "close fis exception");
                    }
                    try {
                        fileChannel.close();
                    } catch (Exception unused2) {
                        Log.e("XcdnLoader", "close fc exception");
                    }
                    return byteArray;
                } catch (Exception unused3) {
                    try {
                        Log.e("XcdnLoader", "read file exception");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused4) {
                                Log.e("XcdnLoader", "close fis exception");
                            }
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (Exception unused5) {
                                Log.e("XcdnLoader", "close fc exception");
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused6) {
                                Log.e("XcdnLoader", "close fis exception");
                            }
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (Exception unused7) {
                                Log.e("XcdnLoader", "close fc exception");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception unused8) {
                fileChannel = null;
                Log.e("XcdnLoader", "read file exception");
                if (fileInputStream != null) {
                }
                if (fileChannel != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
                if (fileInputStream != null) {
                }
                if (fileChannel != null) {
                }
                throw th;
            }
        } catch (Exception unused9) {
            fileChannel = null;
            fileInputStream = null;
            Log.e("XcdnLoader", "read file exception");
            if (fileInputStream != null) {
            }
            if (fileChannel != null) {
            }
            return null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            fileChannel = null;
            if (fileInputStream != null) {
            }
            if (fileChannel != null) {
            }
            throw th;
        }
    }

    @Override // com.taobao.phenix.loader.network.HttpLoader
    public void connectTimeout(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1738713143")) {
            ipChange.ipc$dispatch("1738713143", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.b.connectTimeout(i);
    }

    @Override // com.taobao.phenix.loader.network.HttpLoader
    @Nullable
    public Future<?> load(@NotNull String str, @NotNull Map<String, String> map, @NotNull HttpLoader.FinishCallback finishCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004241747")) {
            return (Future) ipChange.ipc$dispatch("1004241747", new Object[]{this, str, map, finishCallback});
        }
        k21.i(str, "url");
        k21.i(map, "map");
        k21.i(finishCallback, "finishCallback");
        if (c(str) || !b(str)) {
            return this.b.load(str, map, finishCallback);
        }
        return d(str, map, true, finishCallback);
    }

    @Override // com.taobao.phenix.loader.network.HttpLoader
    public void readTimeout(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "114548839")) {
            ipChange.ipc$dispatch("114548839", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.b.readTimeout(i);
    }
}
