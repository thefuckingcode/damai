package tb;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import io.flutter.wpkbridge.WPKFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class zn0 implements GXRegisterCenter.GXIExtensionTemplateSource {
    @NotNull
    private final Context context;
    @NotNull
    private final Map<String, List<vq0>> templateCache = new LinkedHashMap();

    public zn0(@NotNull Context context2) {
        k21.i(context2, WPKFactory.INIT_KEY_CONTEXT);
        this.context = context2;
    }

    private final void addToCache(vq0 vq0) {
        List<vq0> list = this.templateCache.get(vq0.a());
        if (list == null) {
            list = new ArrayList<>();
            this.templateCache.put(vq0.a(), list);
        }
        list.add(vq0);
    }

    private final vq0 getFromCache(String str, String str2) {
        List<vq0> list = this.templateCache.get(str);
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

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        tb.dj.a(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        throw r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035 A[SYNTHETIC] */
    private final String readFileFromAssets(String str) {
        BufferedReader bufferedReader;
        String str2;
        try {
            Resources resources = getContext().getResources();
            if (resources != null) {
                AssetManager assets = resources.getAssets();
                if (assets != null) {
                    InputStream open = assets.open(str);
                    if (open != null) {
                        InputStreamReader inputStreamReader = new InputStreamReader(open, ph.UTF_8);
                        bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                        if (bufferedReader != null) {
                            str2 = null;
                        } else {
                            str2 = ek2.c(bufferedReader);
                        }
                        dj.a(bufferedReader, null);
                        return str2;
                    }
                }
            }
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            dj.a(bufferedReader, null);
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }

    @NotNull
    public Context getContext() {
        return this.context;
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateSource
    @Nullable
    public vq0 getTemplate(@NotNull GXTemplateEngine.h hVar) {
        k21.i(hVar, "gxTemplateItem");
        vq0 fromCache = getFromCache(hVar.a(), hVar.d());
        if (fromCache != null) {
            return fromCache;
        }
        String b = hVar.b();
        if (b.length() == 0) {
            b = hVar.a();
        }
        String str = b + v00.DIR + hVar.d() + "/index.json";
        String str2 = b + v00.DIR + hVar.d() + "/index.css";
        String str3 = b + v00.DIR + hVar.d() + "/index.databinding";
        String readFileFromAssets = readFileFromAssets(str);
        String readFileFromAssets2 = readFileFromAssets(str2);
        String readFileFromAssets3 = readFileFromAssets(str3);
        String readFileFromAssets4 = readFileFromAssets(b + v00.DIR + hVar.d() + "/index.js");
        if (readFileFromAssets == null) {
            return null;
        }
        vq0 vq0 = new vq0(hVar.d(), hVar.a(), -1, readFileFromAssets, readFileFromAssets2 == null ? "" : readFileFromAssets2, readFileFromAssets3 == null ? "" : readFileFromAssets3, readFileFromAssets4 == null ? "" : readFileFromAssets4);
        vq0.i("assets");
        addToCache(vq0);
        return vq0;
    }
}
