package com.tencent.smtt.utils;

import android.os.Build;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsCopyVerify */
public class p {
    private b a = null;
    private b b = null;

    /* access modifiers changed from: package-private */
    /* compiled from: TbsCopyVerify */
    public class a {
        private String b;
        private long c;
        private long d;

        a(String str, long j, long j2) {
            this.b = str;
            this.c = j;
            this.d = j2;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public long b() {
            return this.d;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: TbsCopyVerify */
    public class b {
        private Map<String, a> b;

        /* access modifiers changed from: package-private */
        public Map<String, a> a() {
            return this.b;
        }

        b(File file) {
            HashMap hashMap = new HashMap();
            this.b = hashMap;
            hashMap.clear();
            a(file);
        }

        private void a(File file) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null || Build.VERSION.SDK_INT < 26) {
                    for (File file2 : listFiles) {
                        a(file2);
                    }
                }
            } else if (file.isFile()) {
                a(file.getName(), file.length(), file.lastModified());
            }
        }

        private void a(String str, long j, long j2) {
            if (str != null && str.length() > 0 && j > 0 && j2 > 0) {
                a aVar = new a(str, j, j2);
                if (!this.b.containsKey(str)) {
                    this.b.put(str, aVar);
                }
            }
        }
    }

    public void a(File file) {
        this.a = new b(file);
    }

    public void b(File file) {
        this.b = new b(file);
    }

    public boolean a() {
        b bVar = this.b;
        if (bVar == null || this.a == null || bVar.a().size() != this.a.a().size() || !a(this.a, this.b)) {
            return false;
        }
        return true;
    }

    private boolean a(b bVar, b bVar2) {
        if (bVar == null || bVar.a() == null || bVar2 == null || bVar2.a() == null) {
            return false;
        }
        Map<String, a> a2 = bVar.a();
        Map<String, a> a3 = bVar2.a();
        for (Map.Entry<String, a> entry : a2.entrySet()) {
            String key = entry.getKey();
            a value = entry.getValue();
            if (a3.containsKey(key)) {
                a aVar = a3.get(key);
                if (value.a() == aVar.a()) {
                    if (value.b() != aVar.b()) {
                    }
                }
            }
            return false;
        }
        return true;
    }
}
