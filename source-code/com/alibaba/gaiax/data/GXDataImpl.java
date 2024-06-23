package com.alibaba.gaiax.data;

import android.content.Context;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import kotlin.Lazy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ro0;
import tb.so0;
import tb.to0;
import tb.uo0;
import tb.vq0;

/* compiled from: Taobao */
public final class GXDataImpl {
    @NotNull
    private final Context a;
    @NotNull
    private final Lazy b = kotlin.b.b(new GXDataImpl$templateInfoSource$2(this));
    @NotNull
    private final Lazy c = kotlin.b.b(new GXDataImpl$templateSource$2(this));

    /* compiled from: Taobao */
    public static final class a implements GXRegisterCenter.GXIExtensionTemplateInfoSource {
        @NotNull
        private final PriorityQueue<C0084a> a = new PriorityQueue<>(11, so0.a);
        @NotNull
        private final List<C0084a> b = new ArrayList();

        /* renamed from: com.alibaba.gaiax.data.GXDataImpl$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0084a {
            private final int a;
            @NotNull
            private final GXRegisterCenter.GXIExtensionTemplateInfoSource b;

            public C0084a(int i, @NotNull GXRegisterCenter.GXIExtensionTemplateInfoSource gXIExtensionTemplateInfoSource) {
                k21.i(gXIExtensionTemplateInfoSource, "source");
                this.a = i;
                this.b = gXIExtensionTemplateInfoSource;
            }

            public final int a() {
                return this.a;
            }

            @NotNull
            public final GXRegisterCenter.GXIExtensionTemplateInfoSource b() {
                return this.b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!k21.d(C0084a.class, obj == null ? null : obj.getClass())) {
                    return false;
                }
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.gaiax.data.GXDataImpl.GXTemplateInfoSource.Value");
                return this.a == ((C0084a) obj).a;
            }

            public int hashCode() {
                return this.a;
            }

            @NotNull
            public String toString() {
                return "Value(priority=" + this.a + ", source=" + this.b + ')';
            }
        }

        public a(@NotNull Context context) {
            k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        }

        /* access modifiers changed from: private */
        public static final int c(C0084a aVar, C0084a aVar2) {
            int i = 0;
            int a2 = aVar2 == null ? 0 : aVar2.a();
            if (aVar != null) {
                i = aVar.a();
            }
            return a2 - i;
        }

        /* access modifiers changed from: private */
        public static final int e(C0084a aVar, C0084a aVar2) {
            int i = 0;
            int a2 = aVar2 == null ? 0 : aVar2.a();
            if (aVar != null) {
                i = aVar.a();
            }
            return a2 - i;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v6, resolved type: java.util.List<com.alibaba.gaiax.data.GXDataImpl$a$a> */
        /* JADX WARN: Multi-variable type inference failed */
        public final void d(@NotNull GXRegisterCenter.GXIExtensionTemplateInfoSource gXIExtensionTemplateInfoSource, int i) {
            k21.i(gXIExtensionTemplateInfoSource, "source");
            T t = null;
            for (T t2 : this.a) {
                if (t2.a() == i) {
                    t = t2;
                }
            }
            this.a.remove(t);
            this.a.add(new C0084a(i, gXIExtensionTemplateInfoSource));
            PriorityQueue priorityQueue = new PriorityQueue(11, ro0.a);
            priorityQueue.addAll(this.a);
            this.b.clear();
            while (!priorityQueue.isEmpty()) {
                List<C0084a> list = this.b;
                Object poll = priorityQueue.poll();
                k21.h(poll, "dataSource.poll()");
                list.add(poll);
            }
        }

        @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateInfoSource
        @NotNull
        public GXTemplateInfo getTemplateInfo(@NotNull GXTemplateEngine.h hVar) {
            k21.i(hVar, "gxTemplateItem");
            Iterator<T> it = this.b.iterator();
            while (it.hasNext()) {
                GXTemplateInfo templateInfo = it.next().b().getTemplateInfo(hVar);
                if (templateInfo != null) {
                    return templateInfo;
                }
            }
            throw new IllegalArgumentException(k21.r("Not found target gxTemplateInfo, templateItem = ", hVar));
        }
    }

    /* compiled from: Taobao */
    public static final class b implements GXRegisterCenter.GXIExtensionTemplateSource {
        @NotNull
        private final PriorityQueue<a> a = new PriorityQueue<>(11, uo0.a);
        @NotNull
        private final List<a> b = new ArrayList();

        /* compiled from: Taobao */
        public static final class a {
            private final int a;
            @NotNull
            private final GXRegisterCenter.GXIExtensionTemplateSource b;

            public a(int i, @NotNull GXRegisterCenter.GXIExtensionTemplateSource gXIExtensionTemplateSource) {
                k21.i(gXIExtensionTemplateSource, "source");
                this.a = i;
                this.b = gXIExtensionTemplateSource;
            }

            public final int a() {
                return this.a;
            }

            @NotNull
            public final GXRegisterCenter.GXIExtensionTemplateSource b() {
                return this.b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!k21.d(a.class, obj == null ? null : obj.getClass())) {
                    return false;
                }
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.gaiax.data.GXDataImpl.GXTemplateSource.Value");
                return this.a == ((a) obj).a;
            }

            public int hashCode() {
                return this.a;
            }

            @NotNull
            public String toString() {
                return "Value(priority=" + this.a + ", source=" + this.b + ')';
            }
        }

        public b(@NotNull Context context) {
            k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        }

        /* access modifiers changed from: private */
        public static final int c(a aVar, a aVar2) {
            int i = 0;
            int a2 = aVar2 == null ? 0 : aVar2.a();
            if (aVar != null) {
                i = aVar.a();
            }
            return a2 - i;
        }

        /* access modifiers changed from: private */
        public static final int e(a aVar, a aVar2) {
            int i = 0;
            int a2 = aVar2 == null ? 0 : aVar2.a();
            if (aVar != null) {
                i = aVar.a();
            }
            return a2 - i;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v6, resolved type: java.util.List<com.alibaba.gaiax.data.GXDataImpl$b$a> */
        /* JADX WARN: Multi-variable type inference failed */
        public final void d(@NotNull GXRegisterCenter.GXIExtensionTemplateSource gXIExtensionTemplateSource, int i) {
            k21.i(gXIExtensionTemplateSource, "source");
            T t = null;
            for (T t2 : this.a) {
                if (t2.a() == i) {
                    t = t2;
                }
            }
            this.a.remove(t);
            this.a.add(new a(i, gXIExtensionTemplateSource));
            PriorityQueue priorityQueue = new PriorityQueue(11, to0.a);
            priorityQueue.addAll(this.a);
            this.b.clear();
            while (!priorityQueue.isEmpty()) {
                List<a> list = this.b;
                Object poll = priorityQueue.poll();
                k21.h(poll, "dataSource.poll()");
                list.add(poll);
            }
        }

        @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateSource
        @NotNull
        public vq0 getTemplate(@NotNull GXTemplateEngine.h hVar) {
            k21.i(hVar, "gxTemplateItem");
            Iterator<T> it = this.b.iterator();
            while (it.hasNext()) {
                vq0 template = it.next().b().getTemplate(hVar);
                if (template != null) {
                    return template;
                }
            }
            throw new IllegalArgumentException(k21.r("Not found target gxTemplate, templateItem = ", hVar));
        }
    }

    public GXDataImpl(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
    }

    @NotNull
    public final Context a() {
        return this.a;
    }

    @NotNull
    public final GXTemplateInfo b(@NotNull GXTemplateEngine.h hVar) {
        k21.i(hVar, "templateItem");
        GXRegisterCenter.GXIExtensionBizMap b2 = GXRegisterCenter.Companion.a().b();
        if (b2 != null) {
            b2.convert(hVar);
        }
        return c().getTemplateInfo(hVar);
    }

    @NotNull
    public final a c() {
        return (a) this.b.getValue();
    }

    @NotNull
    public final b d() {
        return (b) this.c.getValue();
    }
}
