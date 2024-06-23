package com.youku.playerservice.axp.dof;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.BinaryUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.o;
import okhttp3.q;
import tb.jl1;
import tb.ny0;

/* compiled from: Taobao */
public class DoFConfigManager {
    public static final String META_FILE_NAME = "dof_meta";
    private static final String TAG = "DoFConfigManager";

    private static OkHttpClient buildClient() {
        if (dofHttpDnsEnable()) {
            Log.d(TAG, "Use HttpDns");
            OkHttpClient.b bVar = new OkHttpClient.b();
            bVar.f(new Dns() {
                /* class com.youku.playerservice.axp.dof.DoFConfigManager.AnonymousClass1 */

                @Override // okhttp3.Dns
                public List<InetAddress> lookup(String str) {
                    Log.d(DoFConfigManager.TAG, "lookup:" + str);
                    ArrayList<ny0.a> b = ny0.b(DoFConfigManager.dofConfigDomainName(), true);
                    if (b != null && b.size() > 0) {
                        String b2 = b.get(0).b();
                        String d = b.get(0).d();
                        Log.d(DoFConfigManager.TAG, "ip:[" + b2 + "],protocol:[" + d + jl1.ARRAY_END_STR);
                        if (b2 != null && !b2.equals("")) {
                            List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(b2));
                            Log.d(DoFConfigManager.TAG, "inetAddresses:" + asList);
                            return asList;
                        }
                    }
                    return Dns.SYSTEM.lookup(str);
                }
            });
            return bVar.b();
        }
        Log.d(TAG, "Unuse HttpDns");
        return new OkHttpClient();
    }

    private static boolean checkDstFile(File file, String str) {
        return TextUtils.isEmpty(str) ? file.exists() : file.exists() && TextUtils.equals(str, BinaryUtil.toBase64String(BinaryUtil.calculateMd5(file)));
    }

    public static String dofConfigDomainName() {
        String config = ConfigFetcher.getInstance().getConfig("fvv_config", "config_domain_name", "sf.ykimg.com");
        Log.d(ApsUtil.TAG, "dofConfigDomainName: config" + config);
        return config;
    }

    public static boolean dofHttpDnsEnable() {
        String config = ConfigFetcher.getInstance().getConfig("fvv_config", "httpdns_enable", "1");
        Log.d(ApsUtil.TAG, "dofHttpDnsEnable: config" + config);
        return "1".equalsIgnoreCase(config);
    }

    public static boolean download(Context context, PlayInfoUpsResponse playInfoUpsResponse) {
        boolean z;
        List<BitStream> bitStreamList = playInfoUpsResponse.getBitStreamList();
        if (bitStreamList != null) {
            Iterator<BitStream> it = bitStreamList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BitStream next = it.next();
                if (next != null) {
                    String dofConfigFile = next.getDofConfigFile();
                    if (!TextUtils.isEmpty(dofConfigFile)) {
                        String filePath = getFilePath(context, dofConfigFile);
                        if (TextUtils.isEmpty(filePath) || !new File(filePath).exists()) {
                            z = true;
                        } else {
                            next.putString(dofConfigFile, filePath);
                        }
                    } else {
                        continue;
                    }
                }
            }
            z = true;
            return !z;
        }
        z = false;
        return !z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0066, code lost:
        r14 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006b, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006d, code lost:
        r14 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
        r6 = 0;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        r14 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0072, code lost:
        r6 = 0;
        r8 = 0;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0078, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0090, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0095, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0104, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0108, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010c, code lost:
        r13.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0076 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0100 A[SYNTHETIC, Splitter:B:60:0x0100] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0108 A[Catch:{ IOException -> 0x0104 }] */
    private static void downloadFile(File file, String str, q qVar) {
        Throwable th;
        FileOutputStream fileOutputStream;
        long j;
        long j2;
        File file2;
        int i;
        Exception e;
        TLogUtil.playLog("Begin downloadFile");
        InputStream inputStream = null;
        try {
            InputStream c = qVar.a().c();
            try {
                file2 = new File(file, str + ".tmp");
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    j2 = qVar.a().f();
                    TLogUtil.playLog("downloadFile contentLength=" + j2);
                    j = 0;
                    while (true) {
                        int read = c.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                            j += (long) read;
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    c.close();
                    fileOutputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    j = 0;
                    inputStream = c;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                        if (i >= 0) {
                        }
                        TLogUtil.playLog("download file SUCCESS! md5=" + str + " downloadSize=" + j + " contentLength=" + j2);
                        file2.renameTo(new File(file, str));
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                }
            } catch (Exception e4) {
                e = e4;
                j2 = 0;
                j = 0;
                file2 = null;
                fileOutputStream = null;
                inputStream = c;
                e.printStackTrace();
                if (inputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                if (i >= 0) {
                }
                TLogUtil.playLog("download file SUCCESS! md5=" + str + " downloadSize=" + j + " contentLength=" + j2);
                file2.renameTo(new File(file, str));
                return;
            } catch (Throwable th4) {
            }
        } catch (Exception e5) {
            e = e5;
            j2 = 0;
            j = 0;
            file2 = null;
            fileOutputStream = null;
            e.printStackTrace();
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i >= 0) {
            }
            TLogUtil.playLog("download file SUCCESS! md5=" + str + " downloadSize=" + j + " contentLength=" + j2);
            file2.renameTo(new File(file, str));
            return;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
        i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i >= 0 || (i > 0 && j == j2)) {
            TLogUtil.playLog("download file SUCCESS! md5=" + str + " downloadSize=" + j + " contentLength=" + j2);
            file2.renameTo(new File(file, str));
            return;
        }
        try {
            TLogUtil.playLog("download file FAIL! md5=" + str);
            if (file2 != null) {
                file2.delete();
            }
        } catch (Exception unused) {
            TLogUtil.playLog("download file FAIL! md5=" + str);
        }
    }

    public static String getDoFDir(Context context) {
        if (context == null || context.getExternalCacheDir() == null) {
            throw new IOException("No Cache Dir");
        }
        return context.getExternalCacheDir().getAbsolutePath() + "/" + META_FILE_NAME;
    }

    public static String getFilePath(Context context, String str) {
        TLogUtil.playLog("getFilePath request " + str);
        try {
            q execute = buildClient().newCall(new o.a().k(str).c().b()).execute();
            String g = execute.g("Content-MD5");
            TLogUtil.playLog("getFilePath ossContentMD5=" + g);
            String substring = TextUtils.isEmpty(g) ? str.substring(str.lastIndexOf("/")) : BinaryUtil.bytesToHexString(BinaryUtil.fromBase64String(g));
            TLogUtil.playLog("getFilePath fileName=" + substring);
            File file = new File(getDoFDir(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, substring);
            if (checkDstFile(file2, g)) {
                execute.close();
                String absolutePath = file2.getAbsolutePath();
                TLogUtil.playLog("getFilePath path=" + absolutePath);
                return absolutePath;
            }
            downloadFile(file, substring, execute);
            String absolutePath2 = checkDstFile(file2, g) ? file2.getAbsolutePath() : null;
            TLogUtil.playLog("getFilePath path=" + absolutePath2);
            return absolutePath2;
        } catch (IOException e) {
            e.printStackTrace();
            TLogUtil.playLog("IOException " + e.toString());
            return null;
        }
    }
}
