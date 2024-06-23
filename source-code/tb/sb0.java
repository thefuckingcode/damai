package tb;

import android.text.TextUtils;
import com.alipay.sdk.m.l.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class sb0 {
    public List<u21> a = new ArrayList();
    public io1 b = new io1();

    public sb0() {
    }

    public boolean a() {
        List<u21> list;
        if (this.b == null || (list = this.a) == null || list.isEmpty()) {
            m90.h("DownloadRequest", c.j, "param is null");
            return false;
        } else if (TextUtils.isEmpty(this.b.f)) {
            m90.h("DownloadRequest", c.j, "param fileStorePath is null");
            return false;
        } else {
            for (u21 u21 : this.a) {
                if (TextUtils.isEmpty(u21.a)) {
                    m90.h("DownloadRequest", c.j, "param url is null");
                    return false;
                }
            }
            ArrayList arrayList = new ArrayList();
            for (u21 u212 : this.a) {
                if (!arrayList.contains(u212)) {
                    arrayList.add(u212);
                }
            }
            this.a = arrayList;
            return true;
        }
    }

    public sb0(String str) {
        u21 u21 = new u21();
        u21.a = str;
        this.a.add(u21);
    }
}
