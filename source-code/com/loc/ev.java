package com.loc;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;
import tb.h53;
import tb.y43;

/* compiled from: Taobao */
public final class ev {
    private LinkedList<h53> a = new LinkedList<>();
    private File b;
    private boolean c = false;
    private Handler d;
    private String e = null;
    private boolean f;
    private Runnable g = new Runnable() {
        /* class com.loc.ev.AnonymousClass1 */

        public final void run() {
            if (!ev.this.c) {
                if (ev.this.f) {
                    ev.this.f();
                    ev.this.f = false;
                }
                if (ev.this.d != null) {
                    ev.this.d.postDelayed(ev.this.g, DateUtils.MILLIS_PER_MINUTE);
                }
            }
        }
    };

    public ev(Context context, Handler handler) {
        this.d = handler;
        String path = context.getFilesDir().getPath();
        if (this.e == null) {
            this.e = m1.e0(context);
        }
        try {
            this.b = new File(path, "hisloc");
        } catch (Throwable th) {
            y43.a(th);
        }
        b();
        Handler handler2 = this.d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.g);
            this.d.postDelayed(this.g, DateUtils.MILLIS_PER_MINUTE);
        }
    }

    private void b() {
        LinkedList<h53> linkedList = this.a;
        if (linkedList == null || linkedList.size() <= 0) {
            for (String str : m1.l(this.b)) {
                try {
                    String str2 = new String(e1.h(p1.g(str), this.e), "UTF-8");
                    h53 h53 = new h53();
                    h53.b(new JSONObject(str2));
                    this.a.add(h53);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f() {
        StringBuilder sb = new StringBuilder();
        Iterator<h53> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                String a2 = it.next().a();
                sb.append(p1.f(e1.e(a2.getBytes("UTF-8"), this.e)) + StringUtils.LF);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            m1.m(this.b, sb2);
        }
    }

    private static boolean i(ArrayList<b1> arrayList, ArrayList<y0> arrayList2) {
        return arrayList == null || arrayList.size() <= 0 || arrayList2 == null || arrayList2.size() <= 0 || (((long) arrayList.size()) < 4 && ((long) arrayList2.size()) < 20);
    }

    public final List<h53> a(ArrayList<b1> arrayList, ArrayList<y0> arrayList2) {
        if (!i(arrayList, arrayList2)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList3 = new ArrayList();
        int i = 0;
        Iterator<h53> it = this.a.iterator();
        while (it.hasNext()) {
            h53 next = it.next();
            if (currentTimeMillis - next.d < 21600000000L) {
                arrayList3.add(next);
                i++;
            }
            if (i == 10) {
                break;
            }
        }
        return arrayList3;
    }

    public final void c(h53 h53) {
        Iterator<h53> it = this.a.iterator();
        h53 h532 = null;
        h53 h533 = null;
        int i = 0;
        while (it.hasNext()) {
            h53 next = it.next();
            if (next.a == 1) {
                if (h533 == null) {
                    h533 = next;
                }
                i++;
                h532 = next;
            }
        }
        if (h532 != null) {
            new Location(GeocodeSearch.GPS);
            if (h53.d - h532.d < 20000) {
                if (m1.e(new double[]{h53.b, h53.c, h532.b, h532.c}) < 20.0f) {
                    return;
                }
            }
        }
        if (((long) i) >= 5) {
            this.a.remove(h533);
        }
        if (((long) this.a.size()) >= 10) {
            this.a.removeFirst();
        }
        this.a.add(h53);
        this.f = true;
    }

    public final void d(boolean z) {
        if (!z) {
            this.g.run();
        }
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacks(this.g);
        }
        this.c = true;
    }

    public final void g(h53 h53) {
        if (this.a.size() > 0) {
            int i = h53.a;
            if (i == 6 || i == 5) {
                h53 last = this.a.getLast();
                if (last.c != h53.c || last.b != h53.b || last.e != h53.e) {
                    if (((long) this.a.size()) >= 10) {
                        this.a.removeFirst();
                    }
                    this.a.add(h53);
                    this.f = true;
                }
            } else if (!this.a.contains(h53)) {
                if (((long) this.a.size()) >= 10) {
                    this.a.removeFirst();
                }
                this.a.add(h53);
                this.f = true;
            }
        }
    }
}
