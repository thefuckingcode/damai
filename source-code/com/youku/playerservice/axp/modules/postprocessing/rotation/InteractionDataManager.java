package com.youku.playerservice.axp.modules.postprocessing.rotation;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.base.constant.AdType;
import com.youku.alixplayer.ExtraID;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.middlewareservice.provider.task.TaskRunnerProviderProxy;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.modules.postprocessing.rotation.Data;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.BinaryUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.vpm.proxy.VpmCommit;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.internal.a;
import okhttp3.o;
import okhttp3.q;
import org.apache.commons.lang3.StringUtils;
import tb.o70;

/* compiled from: Taobao */
public class InteractionDataManager implements Runnable {
    private static final String INTERACTION_DIR = "i_data";
    private static final int MAX_SUPPORT_CONFIG_VERSION = 3;
    private static final int MIN_SUPPORT_CONFIG_VERSION = 2;
    private static final int ROUND_BIT = 2;
    private static final String TAG = "InteractionDataManager";
    private static File cacheDir;
    private static Boolean isRegisterByPassDataDownload;
    boolean callbackCalled = false;
    private List<IndexItem> indexList;
    private BitStream mBitStream;
    private TreeMap<Double, InteractionData> mDataMap;
    private Runnable mFailCallback;
    private Map<Double, Data.Frame> mFrameMap;
    private String mIndexUrl;
    private Map<String, Data.Person> mPersonMap;
    private PlayInfo mPlayInfo;
    private int mStartTimeMs = 0;
    private Runnable mSuccessCallback;
    private String mUrl;
    private int requestState = -2;
    private String requestVid;
    private double timeOffset = 0.001d;
    private String versionStr = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class IndexItem {
        int length;
        int offset;
        double startTime;

        IndexItem() {
        }
    }

    public InteractionDataManager(Context context) {
        if (context != null) {
            try {
                File file = new File(context.getExternalCacheDir(), INTERACTION_DIR);
                cacheDir = file;
                file.mkdirs();
            } catch (Exception unused) {
                cacheDir = null;
            }
        }
        TaskRunnerProviderProxy.initTaskGroup(TAG, 1);
        TLogUtil.loge(TAG, "create InteractionDataManager " + toString());
        try {
            this.timeOffset = ((double) Integer.parseInt(ConfigFetcher.getInstance().getConfig("interaction_config", "time_offset_ms", "1"))) / 1000.0d;
        } catch (Exception unused2) {
        }
    }

    private boolean checkDstFile(File file, String str) {
        boolean exists = file.exists();
        String str2 = null;
        if (exists && !TextUtils.isEmpty(str)) {
            try {
                str2 = BinaryUtil.toBase64String(BinaryUtil.calculateMd5(file));
                exists = TextUtils.equals(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TLogUtil.loge(TAG, "checkDstFile File=" + file + " fileMD5=" + str2 + " checkMD5=" + str + " result=" + exists);
        return exists;
    }

    public static void commitByPassDataDownload(Map<String, String> map, Map<String, Double> map2) {
        isRegisterByPassDataDownload = Boolean.valueOf(VpmCommit.commitStatistics("byPassDataDownload", isRegisterByPassDataDownload.booleanValue(), map, map2));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void commitVpm(String str, String str2, String str3, Double d, Double d2, Double d3, String str4) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            if (isValid()) {
                hashMap.put("vid", this.requestVid);
                hashMap.put("downloadType", str);
                hashMap.put("downloadSuccess", str2);
                hashMap.put("downloadUrl", str3);
                hashMap.put("version", this.versionStr);
                hashMap.put("errorCode", str4);
                hashMap2.put("downloadTime", d);
                hashMap2.put("rangeStart", d2);
                hashMap2.put("rangeSize", d3);
                commitByPassDataDownload(hashMap, hashMap2);
                TLogUtil.loge(TAG, "算法数据下载统计 " + hashMap + " " + hashMap2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void commitVpm(String str, String str2, String str3, Double d, String str4) {
        commitVpm(str, str2, str3, d, Double.valueOf(0.0d), Double.valueOf(-1.0d), str4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040 A[SYNTHETIC, Splitter:B:21:0x0040] */
    private String convertStreamToString(InputStream inputStream) {
        Throwable th;
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
            try {
                StringBuilder sb = new StringBuilder();
                Boolean bool = Boolean.TRUE;
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    } else if (bool.booleanValue()) {
                        sb.append(readLine);
                        bool = Boolean.FALSE;
                    } else {
                        sb.append(StringUtils.LF);
                        sb.append(readLine);
                    }
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return sb2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    private boolean enableData(PlayInfoUpsResponse playInfoUpsResponse, BitStream bitStream) {
        String str;
        String config = ConfigFetcher.getInstance().getConfig("dk_config", "enable_rotation_data", "1");
        boolean hasVideoFeature = playInfoUpsResponse.hasVideoFeature("AUTOORNT");
        String config2 = ConfigFetcher.getInstance().getConfig("interaction_config", "enable_pick", "1");
        boolean hasVideoFeature2 = playInfoUpsResponse.hasVideoFeature("RETARGET");
        String config3 = ConfigFetcher.getInstance().getConfig("interaction_config", "enable_data", "1");
        TLogUtil.loge(TAG, "enableData aps:" + config3);
        boolean z = (bitStream == null || bitStream.getHlsPlayConf() == null) ? false : true;
        try {
            StringBuilder sb = new StringBuilder();
            if (bitStream == null) {
                str = "bitstream is null";
            } else {
                if (bitStream.getHlsPlayConf() == null) {
                    str = "&& getHlsPlayConf() is null";
                }
                TLogUtil.loge(TAG, "enableData hasPlayConf:" + sb.toString());
                if (!"1".equals(config) && hasVideoFeature) {
                    return true;
                }
                if ("1".equals(config2) || !hasVideoFeature2) {
                    return !"1".equals(config3) && z;
                }
                return true;
            }
            sb.append(str);
            TLogUtil.loge(TAG, "enableData hasPlayConf:" + sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!"1".equals(config)) {
        }
        if ("1".equals(config2)) {
        }
        if (!"1".equals(config3)) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isValid() {
        return false;
    }

    private void parseFrameData(String str) {
        this.mFrameMap = new HashMap();
        this.mPersonMap = new HashMap();
        Data data = (Data) JSON.parseObject(str, Data.class);
        Data.Frame[] frameArr = data.frames;
        for (Data.Frame frame : frameArr) {
            this.mFrameMap.put(Double.valueOf(new BigDecimal(frame.t).setScale(2, 4).doubleValue()), frame);
        }
        Data.Person[] personArr = data.persons;
        if (personArr != null) {
            for (Data.Person person : personArr) {
                this.mPersonMap.put(person.id, person);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b6 A[SYNTHETIC, Splitter:B:35:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c6 A[SYNTHETIC, Splitter:B:41:0x00c6] */
    private boolean parseIndex(q qVar, String str, int i) {
        Throwable th;
        Exception e;
        BufferedReader bufferedReader = null;
        IndexItem indexItem = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(qVar.a().c()));
            boolean z = false;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(",", 0);
                    if (split.length == 3) {
                        IndexItem indexItem2 = new IndexItem();
                        indexItem2.startTime = Double.parseDouble(split[0].trim());
                        indexItem2.offset = Integer.parseInt(split[1].trim());
                        indexItem2.length = Integer.parseInt(split[2].trim());
                        this.indexList.add(indexItem2);
                        if (!z) {
                            if (indexItem2.startTime > ((double) i) / 1000.0d) {
                                parseRangeDataByIndexItem(str, indexItem, i);
                                z = true;
                            } else {
                                indexItem = indexItem2;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    try {
                        e.printStackTrace();
                        TLogUtil.loge(TAG, "parseIndex Exception " + e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        a.g(qVar);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        a.g(qVar);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    a.g(qVar);
                    throw th;
                }
            }
            if (!z && indexItem.startTime <= ((double) i) / 1000.0d) {
                parseRangeDataByIndexItem(str, indexItem, i);
            }
            try {
                bufferedReader2.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            a.g(qVar);
            return true;
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            TLogUtil.loge(TAG, "parseIndex Exception " + e.toString());
            if (bufferedReader != null) {
            }
            a.g(qVar);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v5, resolved type: okhttp3.q */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c A[SYNTHETIC, Splitter:B:26:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013a  */
    private boolean parseInteractionData(String str, String str2, int i) {
        Throwable th;
        Closeable closeable;
        boolean z;
        FileInputStream fileInputStream;
        File file;
        int i2;
        FileInputStream fileInputStream2;
        File file2;
        int i3 = 0;
        if (TextUtils.isEmpty(str) && !str.contains("/")) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i4 = -1;
        q qVar = 0;
        try {
            this.mDataMap = new TreeMap<>();
            this.indexList = new ArrayList();
            String substring = str.substring(str.lastIndexOf("/"));
            if (TextUtils.isEmpty(substring) || (file2 = cacheDir) == null || !file2.exists()) {
                file = null;
                fileInputStream2 = null;
            } else {
                File file3 = new File(cacheDir, substring);
                if (file3.exists()) {
                    FileInputStream fileInputStream3 = new FileInputStream(file3);
                    try {
                        z = parseInteractionDataImpl(fileInputStream3, i);
                        fileInputStream = fileInputStream3;
                        file = file3;
                        i2 = 3;
                        if (z) {
                            try {
                                currentTimeMillis = System.currentTimeMillis();
                                if (!TextUtils.isEmpty(str2)) {
                                    try {
                                        parseRangeData(str, str2, i);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                try {
                                    qVar = new OkHttpClient().newCall(new o.a().k(str).c().b()).execute();
                                    if (qVar.isSuccessful()) {
                                        String g = qVar.g("Content-MD5");
                                        if (TextUtils.isEmpty(g) || file == null) {
                                            z = parseInteractionDataImpl(qVar.a().c(), i);
                                        } else {
                                            File file4 = new File(cacheDir, substring + ".tmp");
                                            boolean parseInteractionDataImpl = parseInteractionDataImpl(qVar.a().c(), i, true, file4);
                                            try {
                                                if (checkDstFile(file4, g)) {
                                                    file4.renameTo(file);
                                                } else {
                                                    file4.delete();
                                                }
                                            } catch (Exception unused) {
                                            }
                                            z = parseInteractionDataImpl;
                                        }
                                        if (!z) {
                                            i4 = 20000;
                                        }
                                    } else {
                                        i4 = qVar.e() + 10000;
                                    }
                                } catch (Exception e2) {
                                    i4 = e2 instanceof SocketTimeoutException ? AdType.NATIVE_EXPRESS : 20001;
                                    e2.printStackTrace();
                                    TLogUtil.loge(TAG, "parseInteractionData Exception " + e2.toString());
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = null;
                                qVar = fileInputStream;
                                a.g(qVar);
                                a.g(closeable);
                                throw th;
                            }
                        } else {
                            i3 = i2;
                        }
                        commitVpm(String.valueOf(i3), !z ? "1" : "0", str, Double.valueOf((double) (System.currentTimeMillis() - currentTimeMillis)), String.valueOf(i4));
                        a.g(fileInputStream);
                        a.g(qVar);
                        return z;
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = null;
                        qVar = fileInputStream3;
                        a.g(qVar);
                        a.g(closeable);
                        throw th;
                    }
                } else {
                    file = file3;
                    fileInputStream2 = null;
                }
            }
            i2 = 0;
            z = false;
            fileInputStream = fileInputStream2;
            if (z) {
            }
            commitVpm(String.valueOf(i3), !z ? "1" : "0", str, Double.valueOf((double) (System.currentTimeMillis() - currentTimeMillis)), String.valueOf(i4));
            a.g(fileInputStream);
            a.g(qVar);
            return z;
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            a.g(qVar);
            a.g(closeable);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean parseInteractionDataImpl(InputStream inputStream, int i) {
        return parseInteractionDataImpl(inputStream, i, false, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x012d, code lost:
        r24 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0046, code lost:
        r3 = r6;
        r11 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
        r3 = r6;
        r11 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c4, code lost:
        r24 = r6;
        r3 = r14;
        r22 = -1.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x011a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0128, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0129, code lost:
        r24 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x012c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x004a */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0130 A[EDGE_INSN: B:122:0x0130->B:101:0x0130 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0045 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0014] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dd A[Catch:{ Exception -> 0x011c, all -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011a A[ExcHandler: all (th java.lang.Throwable), PHI: r24 
      PHI: (r24v9 java.io.BufferedReader) = (r24v11 java.io.BufferedReader), (r24v15 java.io.BufferedReader), (r24v15 java.io.BufferedReader), (r24v15 java.io.BufferedReader), (r24v15 java.io.BufferedReader) binds: [B:72:0x00d2, B:48:0x0086, B:49:?, B:51:0x0090, B:57:0x009f] A[DONT_GENERATE, DONT_INLINE], Splitter:B:72:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0128 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:35:0x0059] */
    private boolean parseInteractionDataImpl(InputStream inputStream, int i, boolean z, File file) {
        FileWriter fileWriter;
        BufferedReader bufferedReader;
        Throwable th;
        int i2;
        Exception e;
        FileWriter fileWriter2;
        FileWriter fileWriter3;
        boolean z2;
        BufferedReader bufferedReader2;
        String readLine;
        boolean z3;
        InteractionData interactionData;
        double d;
        double d2;
        double d3;
        InteractionData interactionData2;
        Runnable runnable;
        Exception e2;
        boolean z4 = false;
        char c = 1;
        try {
            BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(inputStream));
            if (z) {
                try {
                    fileWriter2 = new FileWriter(file);
                } catch (Exception e3) {
                    e3.printStackTrace();
                } catch (Throwable th2) {
                }
                fileWriter3 = fileWriter2;
                z2 = true;
                i2 = 0;
                boolean z5 = false;
                while (true) {
                    try {
                        readLine = bufferedReader3.readLine();
                        if (readLine != null) {
                            break;
                        }
                        i2++;
                        if (fileWriter3 != null) {
                            if (z2) {
                                z2 = false;
                            } else {
                                try {
                                    fileWriter3.write(StringUtils.LF);
                                } catch (Exception unknown) {
                                    a.g(fileWriter3);
                                    z3 = z2;
                                    fileWriter = null;
                                } catch (Throwable th3) {
                                }
                            }
                            fileWriter3.write(readLine);
                        }
                        fileWriter = fileWriter3;
                        z3 = z2;
                        try {
                            String[] split = readLine.split(",", 0);
                            if (split.length > 2) {
                                interactionData = new InteractionData();
                                d = -1.0d;
                                d3 = Double.parseDouble(split[0]);
                                double parseDouble = Double.parseDouble(split[c]);
                                if (parseDouble == -1.0d) {
                                    bufferedReader2 = bufferedReader3;
                                    d2 = Double.MAX_VALUE;
                                } else {
                                    bufferedReader2 = bufferedReader3;
                                    d2 = parseDouble;
                                }
                                try {
                                    interactionData2 = interactionData;
                                } catch (Exception e4) {
                                    e2 = e4;
                                    interactionData2 = interactionData;
                                    d = d3;
                                    try {
                                        e2.printStackTrace();
                                        d3 = d;
                                        if (d3 >= 0.0d) {
                                        }
                                        c = 1;
                                        z2 = z3;
                                        fileWriter3 = fileWriter;
                                        bufferedReader3 = bufferedReader2;
                                    } catch (Exception e5) {
                                        e = e5;
                                        bufferedReader = bufferedReader2;
                                        try {
                                            e.printStackTrace();
                                            TLogUtil.loge(TAG, "parseInteractionDataImpl Exception " + e.toString());
                                            a.g(bufferedReader);
                                            a.g(fileWriter);
                                            TLogUtil.loge(TAG, "parseInteractionDataImpl pares " + i2 + " lines data");
                                            return z4;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            a.g(bufferedReader);
                                            a.g(fileWriter);
                                            throw th;
                                        }
                                    } catch (Throwable th5) {
                                    }
                                } catch (Throwable th52) {
                                }
                                try {
                                    interactionData.setTime(d3, d2, this.timeOffset);
                                    for (int i3 = 2; i3 < split.length; i3++) {
                                        String str = split[i3];
                                        if (str.length() > 2) {
                                            try {
                                                int parseInt = Integer.parseInt(str.substring(0, 2), 16);
                                                if (parseInt != 0) {
                                                    interactionData2.put(Integer.valueOf(parseInt), str.substring(2));
                                                }
                                            } catch (Exception e6) {
                                                e6.printStackTrace();
                                            } catch (Throwable th522) {
                                            }
                                        }
                                    }
                                } catch (Exception e7) {
                                    e2 = e7;
                                    d = d3;
                                    e2.printStackTrace();
                                    d3 = d;
                                    if (d3 >= 0.0d) {
                                    }
                                    c = 1;
                                    z2 = z3;
                                    fileWriter3 = fileWriter;
                                    bufferedReader3 = bufferedReader2;
                                } catch (Throwable th5222) {
                                }
                                if (d3 >= 0.0d) {
                                    if (d2 >= 0.0d) {
                                        this.mDataMap.put(Double.valueOf(d2 - this.timeOffset), interactionData2);
                                        if (!z5 && d2 > ((double) i) / 1000.0d) {
                                            c = 1;
                                            this.requestState = 1;
                                            if (isValid() && (runnable = this.mSuccessCallback) != null && !this.callbackCalled) {
                                                this.callbackCalled = true;
                                                runnable.run();
                                            }
                                            z5 = true;
                                        }
                                        c = 1;
                                    }
                                }
                                c = 1;
                            } else {
                                bufferedReader2 = bufferedReader3;
                            }
                        } catch (Exception e8) {
                            e2 = e8;
                            bufferedReader2 = bufferedReader3;
                            interactionData2 = interactionData;
                            d2 = -1.0d;
                            e2.printStackTrace();
                            d3 = d;
                            if (d3 >= 0.0d) {
                            }
                            c = 1;
                            z2 = z3;
                            fileWriter3 = fileWriter;
                            bufferedReader3 = bufferedReader2;
                        } catch (Throwable th6) {
                        }
                        z2 = z3;
                        fileWriter3 = fileWriter;
                        bufferedReader3 = bufferedReader2;
                    } catch (Exception e9) {
                        e = e9;
                        bufferedReader2 = bufferedReader3;
                        fileWriter = fileWriter3;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        TLogUtil.loge(TAG, "parseInteractionDataImpl Exception " + e.toString());
                        a.g(bufferedReader);
                        a.g(fileWriter);
                        TLogUtil.loge(TAG, "parseInteractionDataImpl pares " + i2 + " lines data");
                        return z4;
                    } catch (Throwable th7) {
                        th = th7;
                        bufferedReader2 = bufferedReader3;
                        fileWriter = fileWriter3;
                        bufferedReader = bufferedReader2;
                        a.g(bufferedReader);
                        a.g(fileWriter);
                        throw th;
                    }
                }
                a.g(bufferedReader3);
                a.g(fileWriter3);
                z4 = true;
                TLogUtil.loge(TAG, "parseInteractionDataImpl pares " + i2 + " lines data");
                return z4;
            }
            fileWriter2 = null;
            fileWriter3 = fileWriter2;
            z2 = true;
            i2 = 0;
            boolean z52 = false;
            while (true) {
                readLine = bufferedReader3.readLine();
                if (readLine != null) {
                }
                z2 = z3;
                fileWriter3 = fileWriter;
                bufferedReader3 = bufferedReader2;
            }
            a.g(bufferedReader3);
            a.g(fileWriter3);
            z4 = true;
        } catch (Exception e10) {
            e = e10;
            bufferedReader = null;
            i2 = 0;
            fileWriter = null;
            e.printStackTrace();
            TLogUtil.loge(TAG, "parseInteractionDataImpl Exception " + e.toString());
            a.g(bufferedReader);
            a.g(fileWriter);
            TLogUtil.loge(TAG, "parseInteractionDataImpl pares " + i2 + " lines data");
            return z4;
        } catch (Throwable th8) {
            th = th8;
            bufferedReader = null;
            fileWriter = null;
            a.g(bufferedReader);
            a.g(fileWriter);
            throw th;
        }
        TLogUtil.loge(TAG, "parseInteractionDataImpl pares " + i2 + " lines data");
        return z4;
    }

    private void parseRangeData(final String str, final String str2, final int i) {
        TLogUtil.loge(TAG, "算法Index数据开始请求 " + str2);
        final long currentTimeMillis = System.currentTimeMillis();
        new OkHttpClient().newCall(new o.a().k(str2).c().b()).enqueue(new Callback() {
            /* class com.youku.playerservice.axp.modules.postprocessing.rotation.InteractionDataManager.AnonymousClass1 */

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                InteractionDataManager.this.commitVpm("2", "0", str2, Double.valueOf((double) (System.currentTimeMillis() - currentTimeMillis)), String.valueOf(iOException instanceof SocketTimeoutException ? AdType.NATIVE_EXPRESS : ExtraID.ERRCODE_PARSER_SEEK_BUFFER_ERR));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, q qVar) {
                int i;
                boolean z;
                if (qVar.isSuccessful()) {
                    z = InteractionDataManager.this.parseIndex(qVar, str, i);
                    i = !z ? 20000 : -1;
                } else {
                    i = qVar.e() + 10000;
                    z = false;
                }
                InteractionDataManager.this.commitVpm("2", z ? "1" : "0", str2, Double.valueOf((double) (System.currentTimeMillis() - currentTimeMillis)), String.valueOf(i));
            }
        });
    }

    private void parseRangeDataByIndexItem(final String str, final IndexItem indexItem, final int i) {
        if (indexItem != null && !this.callbackCalled) {
            TLogUtil.loge(TAG, "算法Range数据开始请求 " + str);
            String format = String.format(Locale.CHINESE, "bytes=%d-%d", Integer.valueOf(indexItem.offset), Integer.valueOf((indexItem.offset + indexItem.length) - 1));
            final long currentTimeMillis = System.currentTimeMillis();
            new OkHttpClient().newCall(new o.a().k(str).a("Range", format).c().b()).enqueue(new Callback() {
                /* class com.youku.playerservice.axp.modules.postprocessing.rotation.InteractionDataManager.AnonymousClass2 */

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    InteractionDataManager.this.commitVpm("1", "0", str, Double.valueOf((double) (System.currentTimeMillis() - currentTimeMillis)), Double.valueOf((double) indexItem.offset), Double.valueOf((double) indexItem.length), String.valueOf(iOException instanceof SocketTimeoutException ? AdType.NATIVE_EXPRESS : ExtraID.ERRCODE_PARSER_SEEK_BUFFER_ERR));
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, q qVar) {
                    boolean z;
                    int i;
                    try {
                        if (qVar.isSuccessful()) {
                            z = InteractionDataManager.this.parseInteractionDataImpl(qVar.a().c(), i);
                            if (z) {
                                TLogUtil.loge(InteractionDataManager.TAG, "算法Range数据请求成功");
                                InteractionDataManager.this.requestState = 1;
                                if (InteractionDataManager.this.isValid() && InteractionDataManager.this.mSuccessCallback != null) {
                                    InteractionDataManager interactionDataManager = InteractionDataManager.this;
                                    if (!interactionDataManager.callbackCalled) {
                                        interactionDataManager.callbackCalled = true;
                                        interactionDataManager.mSuccessCallback.run();
                                    }
                                }
                                i = -1;
                            } else {
                                i = 20000;
                            }
                        } else {
                            i = qVar.e() + 10000;
                            z = false;
                        }
                        InteractionDataManager.this.commitVpm("1", z ? "1" : "0", str, Double.valueOf((double) (System.currentTimeMillis() - currentTimeMillis)), Double.valueOf((double) indexItem.offset), Double.valueOf((double) indexItem.length), String.valueOf(i));
                    } finally {
                        a.g(qVar);
                    }
                }
            });
        }
    }

    private String request(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        String str = null;
        str = null;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                str = convertStreamToString(fileInputStream);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                a.g(fileInputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            a.g(fileInputStream2);
            throw th;
        }
        a.g(fileInputStream);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055  */
    private String request(String str) {
        String str2;
        File file;
        File file2;
        q execute = new OkHttpClient().newCall(new o.a().k(str).c().b()).execute();
        String g = execute.g("Content-MD5");
        if (!TextUtils.isEmpty(g) && (file2 = cacheDir) != null && file2.exists()) {
            File file3 = new File(cacheDir, BinaryUtil.bytesToHexString(BinaryUtil.fromBase64String(g)));
            if (checkDstFile(file3, g)) {
                str2 = request(file3);
                if (TextUtils.isEmpty(str2)) {
                    str2 = execute.a().k();
                    if (!TextUtils.isEmpty(g) && (file = cacheDir) != null && file.exists()) {
                        saveString2File(str2, g);
                    }
                }
                return str2;
            }
        }
        str2 = null;
        if (TextUtils.isEmpty(str2)) {
        }
        return str2;
    }

    private void requestPlayConf(JSONObject jSONObject) {
        int i;
        TLogUtil.loge(TAG, "InteractionDataManager playConf" + jSONObject);
        String string = jSONObject.getString("version");
        this.versionStr = string;
        if (string.contains(".")) {
            string = string.substring(0, string.indexOf("."));
        }
        try {
            i = Integer.parseInt(string);
        } catch (Exception unused) {
            i = 1;
        }
        if (i >= 2 && i < 3) {
            this.mUrl = jSONObject.getString("configFile");
            this.mIndexUrl = jSONObject.getString("indexFile");
            if (!TextUtils.isEmpty(this.mUrl)) {
                TaskRunnerProviderProxy.execute(this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035 A[SYNTHETIC, Splitter:B:20:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    private void saveString2File(String str, String str2) {
        Throwable th;
        Exception e;
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(new File(cacheDir, BinaryUtil.bytesToHexString(BinaryUtil.fromBase64String(str2))));
            try {
                fileWriter2.write(str);
                try {
                    fileWriter2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = fileWriter2;
                try {
                    e.printStackTrace();
                    if (fileWriter == null) {
                        fileWriter.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileWriter = fileWriter2;
                if (fileWriter != null) {
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            if (fileWriter == null) {
            }
        }
    }

    public Map<Integer, String> getData(double d) {
        Map.Entry<Double, InteractionData> higherEntry;
        try {
            TreeMap<Double, InteractionData> treeMap = this.mDataMap;
            if (treeMap == null || (higherEntry = treeMap.higherEntry(Double.valueOf(d))) == null) {
                return null;
            }
            InteractionData value = higherEntry.getValue();
            if (value.startTime <= d) {
                return value.data;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public Data.Frame getFrame(double d) {
        try {
            Map<Double, Data.Frame> map = this.mFrameMap;
            if (map != null) {
                return map.get(Double.valueOf(new BigDecimal(d).setScale(2, 4).doubleValue()));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public Map<String, Data.Person> getPersons() {
        return this.mPersonMap;
    }

    public PlayParams getPlayParams() {
        PlayInfo playInfo = this.mPlayInfo;
        if (playInfo != null) {
            return playInfo.getPlayParams();
        }
        return null;
    }

    public int getRequestState() {
        return this.requestState;
    }

    public String request(URI uri) {
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme)) {
            String lowerCase = scheme.toLowerCase();
            if (TextUtils.equals(lowerCase, "http") || TextUtils.equals(lowerCase, "https")) {
                return request(uri.toString());
            }
        }
        return request(new File(uri.toString()));
    }

    public void request(PlayInfo playInfo, BitStream bitStream) {
        PlayInfoResponse playInfoResponse;
        if (playInfo != null && bitStream != null && (playInfoResponse = playInfo.getPlayInfoResponse()) != null) {
            this.mPlayInfo = playInfo;
            this.requestVid = playInfo.getPlayId();
            boolean enableData = enableData((PlayInfoUpsResponse) playInfoResponse, bitStream);
            TLogUtil.loge(TAG, "enableData " + enableData);
            if (!enableData) {
                this.requestState = -2;
                return;
            }
            this.requestState = -1;
            this.mBitStream = bitStream;
            JSONObject hlsPlayConf = bitStream.getHlsPlayConf();
            if (hlsPlayConf != null) {
                requestPlayConf(hlsPlayConf);
            }
        }
    }

    public void run() {
        boolean z;
        Runnable runnable;
        Runnable runnable2;
        try {
            TLogUtil.loge(TAG, "算法数据开始请求：" + toString() + " " + this.mUrl);
            z = parseInteractionData(this.mUrl, this.mIndexUrl, this.mStartTimeMs);
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        if (z) {
            TLogUtil.loge(TAG, "算法数据请求成功 " + toString());
            this.requestState = 1;
            if (isValid() && (runnable2 = this.mSuccessCallback) != null && !this.callbackCalled) {
                this.callbackCalled = true;
                runnable2.run();
                return;
            }
            return;
        }
        TLogUtil.loge(TAG, "算法数据请求失败！！！ " + toString());
        this.requestState = 0;
        if (isValid() && (runnable = this.mFailCallback) != null) {
            runnable.run();
        }
    }

    public InteractionDataManager setOnFailCallback(Runnable runnable) {
        this.mFailCallback = runnable;
        return this;
    }

    public InteractionDataManager setOnSuccessCallback(Runnable runnable) {
        this.mSuccessCallback = runnable;
        return this;
    }

    public InteractionDataManager setStartTimeMs(int i) {
        this.mStartTimeMs = i;
        return this;
    }

    public String toString() {
        return getClass().getName() + o70.DINAMIC_PREFIX_AT + Integer.toHexString(hashCode()) + " " + super.toString();
    }
}
