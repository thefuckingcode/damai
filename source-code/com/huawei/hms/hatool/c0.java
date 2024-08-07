package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
public class c0 {
    public String a = b.i().getFilesDir().getPath();

    public static boolean b(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    y.c("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                b(file2);
            }
        }
        return file.delete();
    }

    public static boolean d() {
        return b(new File(b.i().getFilesDir().getPath() + "/" + "hms"));
    }

    public String a() {
        String str;
        String str2;
        String str3;
        String str4;
        String c = c();
        if (b()) {
            y.c("hmsSdk", "refresh components");
            str = EncryptUtil.generateSecureRandomStr(128);
            a("aprpap", str);
            str2 = EncryptUtil.generateSecureRandomStr(128);
            a("febdoc", str2);
            str3 = EncryptUtil.generateSecureRandomStr(128);
            a("marfil", str3);
            str4 = EncryptUtil.generateSecureRandomStr(128);
            a("maywnj", str4);
            g0.b(b.i(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            str = b("aprpap");
            str2 = b("febdoc");
            str3 = b("marfil");
            str4 = b("maywnj");
        }
        return HexUtil.byteArray2HexStr(PBKDF2.pbkdf2(a(str, str2, str3, c), HexUtil.hexStr2ByteArray(str4), 10000, 16));
    }

    public final String a(String str) {
        return this.a + "/hms/component/".replace("component", str);
    }

    public final void a(String str, String str2) {
        File file = new File(a(str));
        String a2 = a(str);
        File file2 = new File(a2, "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            y.c("hmsSdk", "file directory is mkdirs");
        }
        if (a(file2)) {
            t0.a(file2, str2);
        } else {
            y.f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    public final boolean a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            y.f("hmsSdk", "create new file error!");
            return false;
        }
    }

    public final char[] a(String str, String str2, String str3, String str4) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        byte[] hexStr2ByteArray4 = HexUtil.hexStr2ByteArray(str4);
        int length = hexStr2ByteArray.length;
        if (length > hexStr2ByteArray2.length) {
            length = hexStr2ByteArray2.length;
        }
        if (length > hexStr2ByteArray3.length) {
            length = hexStr2ByteArray3.length;
        }
        if (length > hexStr2ByteArray4.length) {
            length = hexStr2ByteArray4.length;
        }
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (((hexStr2ByteArray[i] ^ hexStr2ByteArray2[i]) ^ hexStr2ByteArray3[i]) ^ hexStr2ByteArray4[i]);
        }
        return cArr;
    }

    public final String b(String str) {
        String a2 = a(str);
        File file = new File(a2, "hianalytics_" + str);
        if (a(file)) {
            return t0.a(file);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(128);
        t0.a(file, generateSecureRandomStr);
        return generateSecureRandomStr;
    }

    public final boolean b() {
        long a2 = g0.a(b.i(), "Privacy_MY", "assemblyFlash", -1);
        if (-1 != a2) {
            return System.currentTimeMillis() - a2 > 31536000000L;
        }
        y.c("hmsSdk", "First init components");
        return true;
    }

    public final String c() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }
}
