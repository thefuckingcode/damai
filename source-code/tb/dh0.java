package tb;

import com.youku.live.livesdk.wkit.component.Constants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.collections.r;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class dh0 {
    @NotNull
    public static final dh0 INSTANCE = new dh0();

    private dh0() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            return CollectionsKt___CollectionsKt.y0(ServiceLoader.load(cls, classLoader));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        tb.dj.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0059, code lost:
        tb.jf0.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0077, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0078, code lost:
        tb.dj.a(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
        throw r1;
     */
    private final List<String> e(URL url) {
        String url2 = url.toString();
        if (o.L(url2, "jar", false, 2, null)) {
            String str = StringsKt__StringsKt.P0(StringsKt__StringsKt.K0(url2, "jar:file:", null, 2, null), '!', null, 2, null);
            String str2 = StringsKt__StringsKt.K0(url2, "!/", null, 2, null);
            JarFile jarFile = new JarFile(str, false);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(str2)), "UTF-8"));
            List<String> f = INSTANCE.f(bufferedReader);
            dj.a(bufferedReader, null);
            jarFile.close();
            return f;
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(url.openStream()));
        List<String> f2 = INSTANCE.f(bufferedReader2);
        dj.a(bufferedReader2, null);
        return f2;
    }

    private final List<String> f(BufferedReader bufferedReader) {
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return CollectionsKt___CollectionsKt.y0(linkedHashSet);
            }
            String str = StringsKt__StringsKt.Q0(readLine, Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, null, 2, null);
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj = StringsKt__StringsKt.T0(str).toString();
            boolean z2 = false;
            int i = 0;
            while (true) {
                if (i >= obj.length()) {
                    z = true;
                    break;
                }
                char charAt = obj.charAt(i);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                if (obj.length() > 0) {
                    z2 = true;
                }
                if (z2) {
                    linkedHashSet.add(obj);
                }
            } else {
                throw new IllegalArgumentException(k21.r("Illegal service provider class name: ", obj).toString());
            }
        }
    }

    @NotNull
    public final List<MainDispatcherFactory> c() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!eh0.a()) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 == null) {
                return arrayList;
            }
            arrayList.add(mainDispatcherFactory2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    @NotNull
    public final <S> List<S> d(@NotNull Class<S> cls, @NotNull ClassLoader classLoader) {
        ArrayList<URL> list = Collections.list(classLoader.getResources(k21.r("META-INF/services/", cls.getName())));
        k21.h(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            boolean unused = r.v(arrayList, INSTANCE.e(url));
        }
        Set<String> set = CollectionsKt___CollectionsKt.C0(arrayList);
        if (!set.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(n.q(set, 10));
            for (String str : set) {
                arrayList2.add(INSTANCE.a(str, classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
