package cn.damai.ticklet.utils;

import android.content.Context;
import android.util.Base64;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import tb.fs1;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ALGORITHM = "PBEWITHMD5andDES";

    public static byte[] a(byte[] bArr, String str, byte[] bArr2) throws Exception {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "24993544")) {
            return (byte[]) ipChange.ipc$dispatch("24993544", new Object[]{bArr, str, bArr2});
        }
        Key e = e(str);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr2, 100);
        Cipher instance = Cipher.getInstance(ALGORITHM);
        instance.init(2, e, pBEParameterSpec);
        return instance.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr, String str, byte[] bArr2) throws Exception {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1225218528")) {
            return (byte[]) ipChange.ipc$dispatch("1225218528", new Object[]{bArr, str, bArr2});
        }
        Key e = e(str);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr2, 100);
        Cipher instance = Cipher.getInstance(ALGORITHM);
        instance.init(1, e, pBEParameterSpec);
        return instance.doFinal(bArr);
    }

    private static byte[] c() throws Exception {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "910297955")) {
            return (byte[]) ipChange.ipc$dispatch("910297955", new Object[0]);
        }
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static byte[] d(Context context) throws Exception {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1075947087")) {
            return (byte[]) ipChange.ipc$dispatch("1075947087", new Object[]{context});
        } else if (!fs1.b(context, "salt", "").equals("")) {
            return fs1.b(context, "salt", "").getBytes();
        } else {
            byte[] encode = Base64.encode(c(), 2);
            fs1.d(context, "salt", new String(encode));
            return encode;
        }
    }

    private static Key e(String str) throws Exception {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1786885956")) {
            return (Key) ipChange.ipc$dispatch("1786885956", new Object[]{str});
        }
        return SecretKeyFactory.getInstance(ALGORITHM).generateSecret(new PBEKeySpec(str.toCharArray()));
    }
}
