package tb;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import java.io.File;
import java.util.UUID;

/* compiled from: Taobao */
public class h63 {
    private static volatile String a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            synchronized (h63.class) {
                if (TextUtils.isEmpty(a)) {
                    String b = b(context);
                    a = b;
                    if (TextUtils.isEmpty(b)) {
                        a = c(context);
                    }
                }
            }
        }
        return a;
    }

    private static String b(Context context) {
        try {
            File file = new File(n13.a(context), "efsid");
            if (file.exists()) {
                return w23.a(file);
            }
            return null;
        } catch (Exception e) {
            t43.c(Constants.TAG, "get uuid error", e);
            return null;
        }
    }

    private static String c(Context context) {
        String str = "";
        for (int i = 0; i < 3; i++) {
            try {
                str = UUID.randomUUID().toString();
                if (TextUtils.isEmpty(str)) {
                }
            } catch (Throwable unused) {
            }
        }
        try {
            File a2 = n13.a(context);
            File file = new File(a2, "efsid" + Process.myPid());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            w23.e(file, str);
            if (file.renameTo(new File(a2, "efsid"))) {
                file.delete();
            }
        } catch (Exception e) {
            t43.c(Constants.TAG, "save uuid '" + str + "' error", e);
        }
        return str;
    }
}
