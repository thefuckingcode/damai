package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class vf2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "597401579")) {
            return (String) ipChange.ipc$dispatch("597401579", new Object[]{inputStream});
        } else if (inputStream == null) {
            return null;
        } else {
            try {
                byte[] bArr = new byte[1024];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        return sb.toString();
                    }
                    sb.append(new String(bArr, 0, read));
                }
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static <T> int b(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565542288")) {
            return ((Integer) ipChange.ipc$dispatch("-565542288", new Object[]{list})).intValue();
        } else if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    public static String c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1207841918")) {
            return (String) ipChange.ipc$dispatch("1207841918", new Object[]{str});
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException unused) {
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            if (Integer.toHexString(digest[i] & 255).length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(Integer.toHexString(digest[i] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(digest[i] & 255));
            }
        }
        return stringBuffer.toString();
    }
}
