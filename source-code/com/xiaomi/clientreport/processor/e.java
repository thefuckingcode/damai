package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.data.a;
import com.xiaomi.push.ab;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class e {
    private static PerfClientReport a(PerfClientReport perfClientReport, String str) {
        long[] a;
        if (perfClientReport == null || (a = m191a(str)) == null) {
            return null;
        }
        perfClientReport.perfCounts = a[0];
        perfClientReport.perfLatencies = a[1];
        return perfClientReport;
    }

    private static PerfClientReport a(String str) {
        try {
            String[] a = m192a(str);
            if (a == null || a.length < 4 || TextUtils.isEmpty(a[0]) || TextUtils.isEmpty(a[1]) || TextUtils.isEmpty(a[2]) || TextUtils.isEmpty(a[3])) {
                return null;
            }
            PerfClientReport blankInstance = PerfClientReport.getBlankInstance();
            blankInstance.production = Integer.parseInt(a[0]);
            blankInstance.clientInterfaceId = a[1];
            blankInstance.reportType = Integer.parseInt(a[2]);
            blankInstance.code = Integer.parseInt(a[3]);
            return blankInstance;
        } catch (Exception unused) {
            b.c("parse per key error");
            return null;
        }
    }

    public static String a(PerfClientReport perfClientReport) {
        return perfClientReport.production + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + perfClientReport.clientInterfaceId + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + perfClientReport.reportType + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + perfClientReport.code;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static HashMap<String, String> m190a(String str) {
        Throwable th;
        Exception e;
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("%%%");
                    if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                        hashMap.put(split[0], split[1]);
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    try {
                        b.a(e);
                        ab.a(bufferedReader);
                        return hashMap;
                    } catch (Throwable th2) {
                        th = th2;
                        ab.a(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    ab.a(bufferedReader);
                    throw th;
                }
            }
            ab.a(bufferedReader2);
        } catch (Exception e3) {
            e = e3;
            b.a(e);
            ab.a(bufferedReader);
            return hashMap;
        }
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v10, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d5, code lost:
        if (r1 == null) goto L_0x00da;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f4  */
    public static List<String> a(Context context, String str) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        File file;
        Exception e;
        RandomAccessFile randomAccessFile3;
        FileLock lock;
        RandomAccessFile randomAccessFile4;
        RandomAccessFile randomAccessFile5;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return arrayList;
        }
        FileLock fileLock = null;
        try {
            file = new File(str + ".lock");
            try {
                ab.m248a(file);
                randomAccessFile2 = new RandomAccessFile(file, "rw");
            } catch (Exception e2) {
                e = e2;
                randomAccessFile2 = null;
                randomAccessFile3 = randomAccessFile2;
                try {
                    b.a(e);
                    try {
                        fileLock.release();
                    } catch (IOException e3) {
                        b.a(e3);
                    }
                    ab.a(randomAccessFile2);
                    ab.a(randomAccessFile3);
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile3;
                    try {
                        fileLock.release();
                    } catch (IOException e4) {
                        b.a(e4);
                    }
                    ab.a(randomAccessFile2);
                    ab.a(randomAccessFile);
                    if (file != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile2 = null;
                randomAccessFile = randomAccessFile2;
                fileLock.release();
                ab.a(randomAccessFile2);
                ab.a(randomAccessFile);
                if (file != null) {
                }
                throw th;
            }
            try {
                lock = randomAccessFile2.getChannel().lock();
            } catch (Exception e5) {
                e = e5;
                randomAccessFile3 = null;
                b.a(e);
                fileLock.release();
                ab.a(randomAccessFile2);
                ab.a(randomAccessFile3);
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileLock.release();
                ab.a(randomAccessFile2);
                ab.a(randomAccessFile);
                if (file != null) {
                }
                throw th;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("%%%");
                        if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                            PerfClientReport a = a(a(split[0]), split[1]);
                            if (a != null) {
                                arrayList.add(a.toJsonString());
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        randomAccessFile4 = bufferedReader;
                        fileLock = lock;
                        randomAccessFile3 = randomAccessFile4;
                        b.a(e);
                        fileLock.release();
                        ab.a(randomAccessFile2);
                        ab.a(randomAccessFile3);
                    } catch (Throwable th5) {
                        th = th5;
                        randomAccessFile5 = bufferedReader;
                        fileLock = lock;
                        randomAccessFile = randomAccessFile5;
                        fileLock.release();
                        ab.a(randomAccessFile2);
                        ab.a(randomAccessFile);
                        if (file != null) {
                        }
                        throw th;
                    }
                }
                if (lock != null && lock.isValid()) {
                    try {
                        lock.release();
                    } catch (IOException e7) {
                        b.a(e7);
                    }
                }
                ab.a(randomAccessFile2);
                ab.a(bufferedReader);
            } catch (Exception e8) {
                e = e8;
                randomAccessFile4 = null;
                fileLock = lock;
                randomAccessFile3 = randomAccessFile4;
                b.a(e);
                fileLock.release();
                ab.a(randomAccessFile2);
                ab.a(randomAccessFile3);
            } catch (Throwable th6) {
                th = th6;
                randomAccessFile5 = null;
                fileLock = lock;
                randomAccessFile = randomAccessFile5;
                fileLock.release();
                ab.a(randomAccessFile2);
                ab.a(randomAccessFile);
                if (file != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            file = null;
            randomAccessFile2 = null;
            randomAccessFile3 = randomAccessFile2;
            b.a(e);
            if (fileLock != null && fileLock.isValid()) {
                fileLock.release();
            }
            ab.a(randomAccessFile2);
            ab.a(randomAccessFile3);
        } catch (Throwable th7) {
            th = th7;
            file = null;
            randomAccessFile2 = null;
            randomAccessFile = randomAccessFile2;
            if (fileLock != null && fileLock.isValid()) {
                fileLock.release();
            }
            ab.a(randomAccessFile2);
            ab.a(randomAccessFile);
            if (file != null) {
                file.delete();
            }
            throw th;
        }
        file.delete();
        return arrayList;
    }

    private static void a(String str, HashMap<String, String> hashMap) {
        Throwable th;
        BufferedWriter bufferedWriter;
        Exception e;
        if (!(TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                try {
                    for (String str2 : hashMap.keySet()) {
                        bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                        bufferedWriter.newLine();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        b.a(e);
                        ab.a(bufferedWriter);
                    } catch (Throwable th2) {
                        th = th2;
                        ab.a(bufferedWriter);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                bufferedWriter = null;
                e = e3;
                b.a(e);
                ab.a(bufferedWriter);
            } catch (Throwable th3) {
                bufferedWriter = null;
                th = th3;
                ab.a(bufferedWriter);
                throw th;
            }
            ab.a(bufferedWriter);
        }
    }

    public static void a(String str, a[] aVarArr) {
        RandomAccessFile randomAccessFile;
        if (!(aVarArr == null || aVarArr.length <= 0 || TextUtils.isEmpty(str))) {
            FileLock fileLock = null;
            try {
                File file = new File(str + ".lock");
                ab.m248a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    HashMap<String, String> a = m190a(str);
                    for (a aVar : aVarArr) {
                        if (aVar != null) {
                            String a2 = a((PerfClientReport) aVar);
                            long j = ((PerfClientReport) aVar).perfCounts;
                            long j2 = ((PerfClientReport) aVar).perfLatencies;
                            if (!TextUtils.isEmpty(a2) && j > 0) {
                                if (j2 >= 0) {
                                    a(a, a2, j, j2);
                                }
                            }
                        }
                    }
                    a(str, a);
                    if (lock != null && lock.isValid()) {
                        try {
                            lock.release();
                        } catch (IOException e) {
                            IOException e2 = e;
                        }
                    }
                } catch (Throwable unused) {
                    try {
                        b.c("failed to write perf to file ");
                    } finally {
                        if (0 != 0 && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                b.a(e3);
                            }
                        }
                        ab.a(randomAccessFile);
                    }
                }
            } catch (Throwable unused2) {
                randomAccessFile = null;
                b.c("failed to write perf to file ");
            }
        }
    }

    private static void a(HashMap<String, String> hashMap, String str, long j, long j2) {
        StringBuilder sb;
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
        } else {
            long[] a = m191a(str2);
            if (a == null || a[0] <= 0 || a[1] < 0) {
                sb = new StringBuilder();
            } else {
                j += a[0];
                j2 += a[1];
                sb = new StringBuilder();
            }
        }
        sb.append(j);
        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        sb.append(j2);
        hashMap.put(str, sb.toString());
    }

    /* renamed from: a  reason: collision with other method in class */
    protected static long[] m191a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e) {
            b.a(e);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String[] m192a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
    }
}
