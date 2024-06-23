package com.taobao.android.dinamicx.template.download;

import android.content.res.AssetManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import tb.ry;
import tb.v00;
import tb.vx;

/* compiled from: Taobao */
public class b {
    public static String[] a(String str) {
        AssetManager assets;
        if (TextUtils.isEmpty(str) || (assets = DinamicXEngine.i().getAssets()) == null) {
            return null;
        }
        try {
            return assets.list(str);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:22|(2:26|27)|28|29|30) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:10|11|(2:12|(1:14)(1:32))|15|16|17|18|19|20) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0033 A[SYNTHETIC, Splitter:B:26:0x0033] */
    static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        if (inputStream == null) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(2048);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                inputStream.close();
                throw th;
            }
        } catch (Throwable th3) {
            byteArrayOutputStream = null;
            th = th3;
            if (byteArrayOutputStream != null) {
            }
            inputStream.close();
            throw th;
        }
    }

    public static byte[] c(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(v00.ASSET_DIR)) {
            return d(str);
        }
        return e(str);
    }

    private static byte[] d(String str) throws IOException {
        return b(DinamicXEngine.i().getAssets().open(str));
    }

    private static byte[] e(String str) throws IOException {
        int read;
        File file = new File(str);
        long length = file.length();
        if (length <= 2147483639) {
            FileInputStream fileInputStream = new FileInputStream(file);
            int i = (int) length;
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (true) {
                int read2 = fileInputStream.read(bArr, i2, i - i2);
                if (read2 > 0) {
                    i2 += read2;
                } else if (read2 < 0 || (read = fileInputStream.read()) < 0) {
                    fileInputStream.close();
                } else {
                    if (i <= 2147483639 - i) {
                        i = Math.max(i << 1, 8192);
                    } else if (i != 2147483639) {
                        i = 2147483639;
                    } else {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    bArr = Arrays.copyOf(bArr, i);
                    bArr[i2] = (byte) read;
                    i2++;
                }
            }
            fileInputStream.close();
            return i == i2 ? bArr : Arrays.copyOf(bArr, i2);
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    public static JSONObject f(String str) {
        byte[] bArr;
        try {
            bArr = c(v00.ASSET_DIR + str + v00.ASSET_PRESET_TEMPLATE_INFOLIST);
        } catch (Throwable unused) {
            if (DinamicXEngine.x()) {
                ry.u("DXTemplateInfoManager", str + "未使用内置模板索引文件");
            }
            bArr = null;
        }
        if (!(bArr == null || bArr.length == 0)) {
            try {
                return JSON.parseObject(new String(bArr));
            } catch (Throwable th) {
                if (DinamicXEngine.x()) {
                    ry.e("DXTemplateInfoManager", th, str + "内置模板索引文件格式错误");
                }
            }
        }
        return null;
    }

    public static boolean g(DXTemplateItem dXTemplateItem, byte[] bArr, String str, IDXUnzipCallback iDXUnzipCallback, @NonNull e eVar) {
        boolean z;
        Throwable th;
        if (dXTemplateItem == null || bArr == null || iDXUnzipCallback == null || TextUtils.isEmpty(str)) {
            eVar.c.add(new e.a("Downloader", "Downloader_download", 60002));
            return false;
        }
        HashMap hashMap = new HashMap();
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new ByteArrayInputStream(bArr)));
            loop0:
            while (true) {
                z = false;
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break loop0;
                    }
                    try {
                        byte[] bArr2 = new byte[8192];
                        String name = nextEntry.getName();
                        if (!nextEntry.getName().contains("../")) {
                            if (!nextEntry.isDirectory()) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                StringBuilder sb = new StringBuilder();
                                try {
                                    sb.append(str);
                                    sb.append(name);
                                    String sb2 = sb.toString();
                                    File file = new File(new File(sb2).getParent());
                                    if (!file.exists()) {
                                        file.mkdirs();
                                    }
                                    while (true) {
                                        int read = zipInputStream.read(bArr2, 0, 8192);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr2, 0, read);
                                    }
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    if (dXTemplateItem.packageInfo == null) {
                                        dXTemplateItem.packageInfo = new DXTemplatePackageInfo();
                                    }
                                    if (v00.DX_MAIN_TEMPLATE_NAME.equalsIgnoreCase(name)) {
                                        dXTemplateItem.packageInfo.mainFilePath = sb2;
                                    } else {
                                        DXTemplatePackageInfo dXTemplatePackageInfo = dXTemplateItem.packageInfo;
                                        if (dXTemplatePackageInfo.subFilePathDict == null) {
                                            dXTemplatePackageInfo.subFilePathDict = new HashMap();
                                        }
                                        dXTemplateItem.packageInfo.subFilePathDict.put(name, sb2);
                                    }
                                    hashMap.put(sb2, byteArray);
                                    byteArrayOutputStream.flush();
                                    z = true;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                e.a aVar = new e.a("Downloader", "Downloader_download", 60001);
                aVar.e = vx.a(th);
                eVar.c.add(aVar);
            }
            zipInputStream.close();
        } catch (Throwable th4) {
            hashMap.clear();
            e.a aVar2 = new e.a("Downloader", "Downloader_download", 60001);
            aVar2.e = vx.a(th4);
            eVar.c.add(aVar2);
            z = false;
        }
        if (z) {
            DXTemplatePackageInfo dXTemplatePackageInfo2 = dXTemplateItem.packageInfo;
            if (dXTemplatePackageInfo2 == null || TextUtils.isEmpty(dXTemplatePackageInfo2.mainFilePath)) {
                e.a aVar3 = new e.a("Downloader", "Downloader_download", 60001);
                aVar3.e = "模板zip中缺少main.dx";
                eVar.c.add(aVar3);
                return false;
            }
            iDXUnzipCallback.onUnzipFinished(dXTemplateItem, hashMap);
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039 A[Catch:{ all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f A[SYNTHETIC, Splitter:B:24:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067 A[SYNTHETIC, Splitter:B:29:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    public static boolean h(String str, byte[] bArr) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        File file = new File(str);
        File file2 = new File(file.getParent());
        if (!file2.exists()) {
            file2.mkdir();
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bufferedOutputStream.write(bArr);
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Exception e2) {
                e = e2;
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    e eVar = new e("DinamicX_File");
                    e.a aVar = new e.a("Template", "Template_Write", e.DX_TEMPLATE_IO_WRITE_ERROR);
                    aVar.e = vx.a(e);
                    eVar.c.add(aVar);
                    DXAppMonitor.n(eVar);
                    if (bufferedOutputStream != null) {
                        return false;
                    }
                    try {
                        bufferedOutputStream.close();
                        return false;
                    } catch (IOException unused2) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            bufferedOutputStream = null;
            e = e3;
            if (file.exists()) {
            }
            e eVar2 = new e("DinamicX_File");
            e.a aVar2 = new e.a("Template", "Template_Write", e.DX_TEMPLATE_IO_WRITE_ERROR);
            aVar2.e = vx.a(e);
            eVar2.c.add(aVar2);
            DXAppMonitor.n(eVar2);
            if (bufferedOutputStream != null) {
            }
        } catch (Throwable th3) {
            bufferedOutputStream = null;
            th = th3;
            if (bufferedOutputStream != null) {
            }
            throw th;
        }
    }
}
