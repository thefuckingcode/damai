package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.taobao.windvane.jsbridge.api.WVFile;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.push.ab;
import com.xiaomi.push.af;
import com.xiaomi.push.bp;
import com.xiaomi.push.bt;
import com.xiaomi.push.i;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
public class a implements IEventProcessor {
    protected Context a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f21a;

    public a(Context context) {
        a(context);
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        com.xiaomi.channel.commonutils.logger.b.d(r9);
     */
    private List<String> a(String str) {
        Throwable th;
        Exception e;
        String str2;
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(str));
            while (true) {
                try {
                    int read = fileInputStream2.read(bArr);
                    if (read != -1) {
                        if (read == 4 && af.a(bArr) == -573785174) {
                            int read2 = fileInputStream2.read(bArr2);
                            if (read2 == -1) {
                                break;
                            } else if (read2 != 4) {
                                str2 = "eventData read from cache file failed cause lengthBuffer error";
                                break;
                            } else {
                                int a2 = af.a(bArr2);
                                if (a2 < 1 || a2 > 4096) {
                                    str2 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K";
                                } else {
                                    byte[] bArr3 = new byte[a2];
                                    if (fileInputStream2.read(bArr3) != a2) {
                                        str2 = "eventData read from cache file failed cause buffer size not equal length";
                                        break;
                                    }
                                    String bytesToString = bytesToString(bArr3);
                                    if (!TextUtils.isEmpty(bytesToString)) {
                                        arrayList.add(bytesToString);
                                    }
                                }
                            }
                        }
                    } else {
                        break;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        b.a(e);
                        ab.a(fileInputStream);
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        ab.a(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    ab.a(fileInputStream);
                    throw th;
                }
            }
            b.d("eventData read from cache file failed because magicNumber error");
            ab.a(fileInputStream2);
        } catch (Exception e3) {
            e = e3;
            b.a(e);
            ab.a(fileInputStream);
            return arrayList;
        }
        return arrayList;
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e) {
                b.a(e);
            }
        }
        ab.a(randomAccessFile);
    }

    private void a(String str, String str2) {
        com.xiaomi.clientreport.manager.a a2 = com.xiaomi.clientreport.manager.a.a(this.a);
        EventClientReport a3 = a2.a(5001, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a3.toJsonString());
        a(arrayList);
    }

    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        String b = b(aVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        try {
            File file = new File(b + ".lock");
            ab.m248a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(b), true));
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream = null;
                    try {
                        b.a("event data write to cache file failed cause exception", e);
                        ab.a(bufferedOutputStream);
                        a(randomAccessFile, fileLock);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream2 = bufferedOutputStream;
                        ab.a(bufferedOutputStream2);
                        a(randomAccessFile, fileLock);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ab.a(bufferedOutputStream2);
                    a(randomAccessFile, fileLock);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileLock = null;
                bufferedOutputStream = null;
                b.a("event data write to cache file failed cause exception", e);
                ab.a(bufferedOutputStream);
                a(randomAccessFile, fileLock);
                return null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
                ab.a(bufferedOutputStream2);
                a(randomAccessFile, fileLock);
                throw th;
            }
            try {
                int i = 0;
                for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                    if (aVar != null) {
                        byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                        if (stringToBytes != null && stringToBytes.length >= 1) {
                            if (stringToBytes.length <= 4096) {
                                if (!bt.m298a(this.a, b)) {
                                    int length = aVarArr.length - i;
                                    com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                                    System.arraycopy(aVarArr, i, aVarArr2, 0, length);
                                    ab.a(bufferedOutputStream);
                                    a(randomAccessFile, fileLock);
                                    return aVarArr2;
                                }
                                bufferedOutputStream.write(af.a(-573785174));
                                bufferedOutputStream.write(af.a(stringToBytes.length));
                                bufferedOutputStream.write(stringToBytes);
                                bufferedOutputStream.flush();
                                i++;
                            }
                        }
                        b.d("event data throw a invalid item ");
                    }
                }
            } catch (Exception e4) {
                e = e4;
                b.a("event data write to cache file failed cause exception", e);
                ab.a(bufferedOutputStream);
                a(randomAccessFile, fileLock);
                return null;
            }
        } catch (Exception e5) {
            e = e5;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
            b.a("event data write to cache file failed cause exception", e);
            ab.a(bufferedOutputStream);
            a(randomAccessFile, fileLock);
            return null;
        } catch (Throwable th5) {
            th = th5;
            fileLock = null;
            randomAccessFile = null;
            ab.a(bufferedOutputStream2);
            a(randomAccessFile, fileLock);
            throw th;
        }
        ab.a(bufferedOutputStream);
        a(randomAccessFile, fileLock);
        return null;
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        File externalFilesDir = this.a.getExternalFilesDir("event");
        String a2 = a(aVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + a2;
        for (int i = 0; i < 100; i++) {
            String str2 = str + i;
            if (bt.m298a(this.a, str2)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x010c A[SYNTHETIC] */
    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        Throwable th;
        Exception e;
        RandomAccessFile randomAccessFile;
        bt.a(this.a, "event", "eventUploading");
        File[] a2 = bt.m299a(this.a, "eventUploading");
        if (a2 != null && a2.length > 0) {
            FileLock fileLock = null;
            RandomAccessFile randomAccessFile2 = null;
            File file = null;
            for (File file2 : a2) {
                if (file2 == null) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            b.a(e2);
                        }
                    }
                    ab.a(randomAccessFile2);
                    if (file == null) {
                    }
                } else {
                    try {
                        if (file2.length() > WVFile.FILE_MAX_SIZE) {
                            b.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                            a(file2.getName(), Formatter.formatFileSize(this.a, file2.length()));
                            file2.delete();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e3) {
                                    b.a(e3);
                                }
                            }
                            ab.a(randomAccessFile2);
                            if (file == null) {
                            }
                        } else {
                            String absolutePath = file2.getAbsolutePath();
                            File file3 = new File(absolutePath + ".lock");
                            try {
                                ab.m248a(file3);
                                randomAccessFile = new RandomAccessFile(file3, "rw");
                            } catch (Exception e4) {
                                e = e4;
                                file = file3;
                                try {
                                    b.a(e);
                                    try {
                                        fileLock.release();
                                    } catch (IOException e5) {
                                        b.a(e5);
                                    }
                                    ab.a(randomAccessFile2);
                                    if (file == null) {
                                    }
                                    file.delete();
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        fileLock.release();
                                    } catch (IOException e6) {
                                        b.a(e6);
                                    }
                                    ab.a(randomAccessFile2);
                                    if (file != null) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                file = file3;
                                if (fileLock != null && fileLock.isValid()) {
                                    fileLock.release();
                                }
                                ab.a(randomAccessFile2);
                                if (file != null) {
                                    file.delete();
                                }
                                throw th;
                            }
                            try {
                                fileLock = randomAccessFile.getChannel().lock();
                                a(a(absolutePath));
                                file2.delete();
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e7) {
                                        b.a(e7);
                                    }
                                }
                                ab.a(randomAccessFile);
                                file3.delete();
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                            } catch (Exception e8) {
                                e = e8;
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                                b.a(e);
                                fileLock.release();
                                ab.a(randomAccessFile2);
                                if (file == null) {
                                }
                                file.delete();
                            } catch (Throwable th4) {
                                th = th4;
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                                fileLock.release();
                                ab.a(randomAccessFile2);
                                if (file != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e9) {
                        e = e9;
                        b.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            fileLock.release();
                        }
                        ab.a(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    }
                }
                file.delete();
            }
        }
    }

    public void a(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a  reason: collision with other method in class */
    public void m187a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f21a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a2 = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f21a.get(a2);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f21a.put(a2, arrayList);
        }
    }

    public void a(List<String> list) {
        bt.a(this.a, list);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m188a(com.xiaomi.clientreport.data.a[] aVarArr) {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            b.m182a("event data write to cache file failed because data null");
            return;
        }
        do {
            aVarArr = a(aVarArr);
            if (aVarArr == null || aVarArr.length <= 0) {
                return;
            }
        } while (aVarArr[0] != null);
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.f21a;
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (String str : this.f21a.keySet()) {
                    ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f21a.get(str);
                    if (arrayList != null && arrayList.size() > 0) {
                        com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                        arrayList.toArray(aVarArr);
                        m188a(aVarArr);
                    }
                }
            }
            this.f21a.clear();
        }
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] a2;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.clientreport.manager.a.a(this.a).m184a().isEventEncrypted()) {
                return bp.b(bArr);
            }
            String a3 = bt.a(this.a);
            if (!TextUtils.isEmpty(a3) && (a2 = bt.a(a3)) != null && a2.length > 0) {
                try {
                    return bp.b(Base64.decode(i.a(a2, bArr), 2));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                    b.a(e);
                }
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap) {
        this.f21a = hashMap;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!com.xiaomi.clientreport.manager.a.a(this.a).m184a().isEventEncrypted()) {
            return bp.m293a(str);
        }
        String a3 = bt.a(this.a);
        byte[] a4 = bp.m293a(str);
        if (!TextUtils.isEmpty(a3) && a4 != null && a4.length > 1 && (a2 = bt.a(a3)) != null) {
            try {
                if (a2.length > 1) {
                    return i.b(a2, Base64.encode(a4, 2));
                }
            } catch (Exception e) {
                b.a(e);
            }
        }
        return null;
    }
}
