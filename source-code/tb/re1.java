package tb;

import android.app.Application;
import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.loader.LocalSchemeHandler;
import java.io.InputStream;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class re1 implements LocalSchemeHandler {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.taobao.phenix.loader.LocalSchemeHandler
    @Nullable
    public r02 handleScheme(@Nullable String str) {
        InputStream openInputStream;
        InputStream openInputStream2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1355263590")) {
            return (r02) ipChange.ipc$dispatch("-1355263590", new Object[]{this, str});
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            Application c = ne1.INSTANCE.c();
            if (c != null) {
                Uri parse = Uri.parse(str);
                k21.h(parse, "uri");
                if (k21.d(ke1.SCHEME_FILE_Q, parse.getScheme())) {
                    String path = parse.getPath();
                    if (path != null) {
                        if (path.length() != 0) {
                            z = false;
                        }
                    }
                    if (!z) {
                        a01 a01 = a01.INSTANCE;
                        String path2 = parse.getPath();
                        k21.f(path2);
                        k21.h(path2, "uri.path!!");
                        Uri a = a01.a(c, path2);
                        if (!(a == null || (openInputStream2 = c.getContentResolver().openInputStream(a)) == null)) {
                            return new r02(openInputStream2, openInputStream2.available());
                        }
                    }
                }
                if (k21.d("content", parse.getScheme()) && (openInputStream = c.getContentResolver().openInputStream(parse)) != null) {
                    r02 r02 = new r02(openInputStream, openInputStream.available());
                    me1 me1 = me1.INSTANCE;
                    me1.a("MoLocalSchemeHandler:handleScheme" + str + ",duration:" + ((System.currentTimeMillis() - currentTimeMillis) - currentTimeMillis));
                    return r02;
                }
            }
        } catch (Exception e) {
            me1 me12 = me1.INSTANCE;
            me12.c("MoLocalSchemeHandler:handleScheme" + e);
        }
        return null;
    }

    @Override // com.taobao.phenix.loader.LocalSchemeHandler
    public boolean isSupported(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "912566397")) {
            return ((Boolean) ipChange.ipc$dispatch("912566397", new Object[]{this, str})).booleanValue();
        }
        try {
            if (ne1.INSTANCE.c() != null) {
                Uri parse = Uri.parse(str);
                k21.h(parse, "uri");
                if (k21.d(ke1.SCHEME_FILE_Q, parse.getScheme()) || k21.d("content", parse.getScheme())) {
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            me1 me1 = me1.INSTANCE;
            me1.c("MoLocalSchemeHandler:isSupported" + e);
        }
        return false;
    }
}
