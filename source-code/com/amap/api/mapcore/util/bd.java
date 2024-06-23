package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
public class bd extends Thread {
    private Context a;
    private bp b;

    public bd(Context context) {
        this.a = context;
        this.b = bp.a(context);
    }

    private bk a(File file) {
        String a2 = eq.a(file);
        bk bkVar = new bk();
        bkVar.b(a2);
        return bkVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        if (r10 != false) goto L_0x008b;
     */
    private void b(ArrayList<String> arrayList, String str) {
        File[] listFiles;
        String[] list;
        File file = new File(eq.a(this.a) + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && (list = file2.list()) != null) {
                        boolean z = true;
                        if (list.length >= 1 && !arrayList.contains(name)) {
                            if (name.equals("a0")) {
                                int length = list.length;
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        break;
                                    } else if ("m1.ans".equals(list[i])) {
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                            } else {
                                boolean z2 = false;
                                boolean z3 = false;
                                for (String str2 : list) {
                                    if ("m1.ans".equals(str2)) {
                                        z2 = true;
                                    }
                                    if ("m3.ans".equals(str2)) {
                                        z3 = true;
                                    }
                                }
                                if (z2) {
                                }
                            }
                            z = false;
                            if (z) {
                                arrayList.add(name);
                            }
                        }
                    }
                }
            }
        }
    }

    public void run() {
        try {
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() {
        bk a2;
        String c;
        int indexOf;
        String c2;
        int indexOf2;
        String c3;
        int indexOf3;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<bk> a3 = this.b.a();
        a(arrayList, "vmap/");
        a(arrayList, "map/");
        b(arrayList, "map/");
        ArrayList<String> b2 = b();
        Iterator<bk> it = a3.iterator();
        while (it.hasNext()) {
            bk next = it.next();
            if (!(next == null || next.d() == null)) {
                int i = next.l;
                boolean z = true;
                if (i == 4 || i == 7) {
                    boolean contains = arrayList.contains(next.i());
                    if (contains || (c = bx.c(next.g())) == null || (indexOf = arrayList.indexOf(c)) == -1) {
                        z = contains;
                    } else {
                        arrayList.set(indexOf, next.i());
                    }
                    if (!z) {
                        this.b.b(next);
                    }
                } else {
                    boolean z2 = false;
                    if (i == 0 || i == 1) {
                        if (b2.contains(next.f()) || b2.contains(next.i())) {
                            z2 = true;
                        }
                        if (z2 || (c2 = bx.c(next.g())) == null || (indexOf2 = b2.indexOf(c2)) == -1) {
                            z = z2;
                        } else {
                            b2.set(indexOf2, next.i());
                        }
                        if (!z) {
                            this.b.b(next);
                        }
                    } else if (i == 3 && next.h() != 0) {
                        if (b2.contains(next.f()) || b2.contains(next.i())) {
                            z2 = true;
                        }
                        if (z2 || (c3 = bx.c(next.g())) == null || (indexOf3 = b2.indexOf(c3)) == -1) {
                            z = z2;
                        } else {
                            b2.set(indexOf3, next.i());
                        }
                        if (!z) {
                            this.b.b(next);
                        }
                    }
                }
            }
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!a(next2, a3) && (a2 = a(next2)) != null) {
                this.b.a(a2);
            }
        }
        ba a4 = ba.a(this.a);
        if (a4 != null) {
            a4.a((ArrayList<bk>) null);
        }
    }

    private ArrayList<String> b() {
        File[] listFiles;
        String name;
        int lastIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(eq.c(this.a));
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return arrayList;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(".zip") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) > -1 && lastIndexOf < name.length()) {
                arrayList.add(name.substring(0, lastIndexOf));
            }
        }
        return arrayList;
    }

    private bk a(String str) {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        ba a2 = ba.a(this.a);
        bk bkVar = null;
        if (a2 != null) {
            String f = a2.f(str);
            File[] listFiles = new File(eq.c(this.a)).listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file : listFiles) {
                if (!(!((file.getName().contains(f) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) || (bkVar = a(file)) == null || bkVar.d() == null)) {
                    return bkVar;
                }
            }
        }
        return bkVar;
    }

    private boolean a(String str, ArrayList<bk> arrayList) {
        Iterator<bk> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().i())) {
                return true;
            }
        }
        return false;
    }

    private void a(ArrayList<String> arrayList, String str) {
        File[] listFiles;
        String name;
        int lastIndexOf;
        File file = new File(eq.b(this.a) + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".dat") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) > -1 && lastIndexOf < name.length()) {
                    String substring = name.substring(0, lastIndexOf);
                    if (!arrayList.contains(substring)) {
                        arrayList.add(substring);
                    }
                }
            }
        }
    }
}
