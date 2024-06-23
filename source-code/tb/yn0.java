package tb;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import io.flutter.wpkbridge.WPKFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class yn0 implements GXRegisterCenter.GXIExtensionTemplateSource {
    @NotNull
    private final Context a;
    @NotNull
    private final Map<String, List<vq0>> b = new LinkedHashMap();

    public yn0(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
    }

    private final void a(vq0 vq0) {
        List<vq0> list = this.b.get(vq0.a());
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(vq0.a(), list);
        }
        list.add(vq0);
    }

    private final vq0 b(byte[] bArr, String str, String str2) {
        String str3;
        String str4;
        JSONObject c = bo0.INSTANCE.c(bArr);
        String string = c.getString("layer");
        if (string != null) {
            String string2 = c.getString("css");
            String str5 = string2 == null ? "" : string2;
            String string3 = c.getString("databinding");
            if (string3 == null) {
                str3 = "";
            } else {
                str3 = string3;
            }
            String string4 = c.getString("js");
            if (string4 == null) {
                str4 = "";
            } else {
                str4 = string4;
            }
            return new vq0(str2, str, -1, string, str5, str3, str4);
        }
        throw new IllegalArgumentException("Layer mustn't empty, templateBiz = " + str + ", templateId = " + str2);
    }

    private final vq0 c(String str, String str2) {
        List<vq0> list = this.b.get(str);
        Object obj = null;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (k21.d(t.d(), str2)) {
                arrayList.add(t);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                int h = ((vq0) obj).h();
                do {
                    Object next = it.next();
                    int h2 = ((vq0) next).h();
                    if (h < h2) {
                        obj = next;
                        h = h2;
                    }
                } while (it.hasNext());
            }
        }
        return (vq0) obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        tb.dj.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        throw r2;
     */
    private final byte[] d(GXTemplateEngine.h hVar) {
        try {
            String b2 = hVar.b();
            if (b2.length() == 0) {
                b2 = hVar.a();
            }
            Resources resources = this.a.getResources();
            if (resources == null) {
                return null;
            }
            AssetManager assets = resources.getAssets();
            if (assets == null) {
                return null;
            }
            InputStream open = assets.open(b2 + v00.DIR + hVar.d());
            if (open == null) {
                return null;
            }
            byte[] c = wd.c(open);
            dj.a(open, null);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateSource
    @Nullable
    public vq0 getTemplate(@NotNull GXTemplateEngine.h hVar) {
        k21.i(hVar, "gxTemplateItem");
        vq0 c = c(hVar.a(), hVar.d());
        if (c != null) {
            return c;
        }
        byte[] d = d(hVar);
        if (d == null) {
            return null;
        }
        vq0 b2 = b(d, hVar.a(), hVar.d());
        b2.i("assets_binary");
        a(b2);
        return c(hVar.a(), hVar.d());
    }
}
