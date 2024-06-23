package com.alibaba.security.common.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: Taobao */
public final class i {
    static final int a = 1;
    private static final String b = "LocalBroadcastManager";
    private static final boolean c = false;
    private static final Object i = new Object();
    private static i j;
    private final Context d;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> e = new HashMap<>();
    private final HashMap<String, ArrayList<b>> f = new HashMap<>();
    private final ArrayList<a> g = new ArrayList<>();
    private final c h;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        final Intent a;
        final ArrayList<b> b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            sb.append("}");
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c extends Handler {
        private final i a;

        public c(i iVar) {
            super(Looper.getMainLooper());
            this.a = iVar;
        }

        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                this.a.b();
            }
        }
    }

    private i(Context context) {
        this.d = context;
        this.h = new c(this);
    }

    private void b(Intent intent) {
        if (a(intent)) {
            b();
        }
    }

    public static i a(Context context) {
        i iVar;
        synchronized (i) {
            if (j == null) {
                j = new i(context.getApplicationContext());
            }
            iVar = j;
        }
        return iVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r3 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r4 = r2[r3];
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r5 >= r4.b.size()) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r4.b.get(r5).b.onReceive(r9.d, r4.a);
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r3 = 0;
     */
    private void b() {
        while (true) {
            synchronized (this.e) {
                int size = this.g.size();
                if (size > 0) {
                    a[] aVarArr = new a[size];
                    this.g.toArray(aVarArr);
                    this.g.clear();
                } else {
                    return;
                }
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.e) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.e.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.e.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<b> arrayList2 = this.f.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.e) {
            ArrayList<IntentFilter> remove = this.e.remove(broadcastReceiver);
            if (remove != null) {
                for (int i2 = 0; i2 < remove.size(); i2++) {
                    IntentFilter intentFilter = remove.get(i2);
                    for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                        String action = intentFilter.getAction(i3);
                        ArrayList<b> arrayList = this.f.get(action);
                        if (arrayList != null) {
                            int i4 = 0;
                            while (i4 < arrayList.size()) {
                                if (arrayList.get(i4).b == broadcastReceiver) {
                                    arrayList.remove(i4);
                                    i4--;
                                }
                                i4++;
                            }
                            if (arrayList.size() <= 0) {
                                this.f.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    public final boolean a(Intent intent) {
        String str;
        ArrayList<b> arrayList;
        String str2;
        int i2;
        ArrayList arrayList2;
        synchronized (this.e) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.d.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                com.alibaba.security.common.c.a.f(b, "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.f.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    com.alibaba.security.common.c.a.f(b, "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    b bVar = arrayList3.get(i3);
                    if (z) {
                        com.alibaba.security.common.c.a.f(b, "Matching against filter " + bVar.a);
                    }
                    if (bVar.c) {
                        if (z) {
                            com.alibaba.security.common.c.a.f(b, "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList = arrayList3;
                        str2 = action;
                        str = resolveTypeIfNeeded;
                        arrayList2 = arrayList4;
                    } else {
                        i2 = i3;
                        str2 = action;
                        arrayList2 = arrayList4;
                        arrayList = arrayList3;
                        str = resolveTypeIfNeeded;
                        int match = bVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, b);
                        if (match >= 0) {
                            if (z) {
                                com.alibaba.security.common.c.a.f(b, "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                            arrayList4.add(bVar);
                            bVar.c = true;
                            i3 = i2 + 1;
                            action = str2;
                            arrayList3 = arrayList;
                            resolveTypeIfNeeded = str;
                        }
                    }
                    arrayList4 = arrayList2;
                    i3 = i2 + 1;
                    action = str2;
                    arrayList3 = arrayList;
                    resolveTypeIfNeeded = str;
                }
                if (arrayList4 != null) {
                    for (int i4 = 0; i4 < arrayList4.size(); i4++) {
                        ((b) arrayList4.get(i4)).c = false;
                    }
                    this.g.add(new a(intent, arrayList4));
                    if (!this.h.hasMessages(1)) {
                        this.h.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public static void a() {
        j = null;
    }
}
