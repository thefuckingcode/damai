package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/* compiled from: Taobao */
public final class kk {
    private static transient /* synthetic */ IpChange $ipChange;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "745003820")) {
            return (byte[]) ipChange.ipc$dispatch("745003820", new Object[]{bArr, bArr2});
        } else if (bArr == null || bArr2 == null || bArr.length <= 0 || bArr2.length != 24) {
            return null;
        } else {
            try {
                Cipher instance = Cipher.getInstance("DESede");
                instance.init(2, SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(bArr2)));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvalidKeySpecException e4) {
                e4.printStackTrace();
                return null;
            } catch (BadPaddingException e5) {
                e5.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e6) {
                e6.printStackTrace();
                return null;
            }
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1997495300")) {
            return (byte[]) ipChange.ipc$dispatch("1997495300", new Object[]{bArr, bArr2});
        } else if (bArr == null || bArr2 == null || bArr.length <= 0 || bArr2.length != 24) {
            return null;
        } else {
            try {
                Cipher instance = Cipher.getInstance("DESede");
                instance.init(1, SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(bArr2)));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvalidKeySpecException e4) {
                e4.printStackTrace();
                return null;
            } catch (BadPaddingException e5) {
                e5.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e6) {
                e6.printStackTrace();
                return null;
            }
        }
    }
}
