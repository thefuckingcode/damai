package com.taobao.android.dinamic.tempate;

import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import tb.tb0;
import tb.tj2;

/* compiled from: Taobao */
public class SerialTaskManager {
    final ArrayDeque<DownLoadTask> a = new ArrayDeque<>();
    private volatile DownLoadTask b;

    /* compiled from: Taobao */
    public static final class DownLoadTask extends AsyncTask<Void, tb0, tb0> {
        private final com.taobao.android.dinamic.tempate.manager.a a;
        LayoutFileLoadListener b;
        List<DinamicTemplate> c;
        String d;
        private SerialTaskManager e;
        private Timer f;
        private long g = 3000;
        private volatile boolean h;
        private ArrayList<DinamicTemplate> i = new ArrayList<>();
        private ArrayList<DinamicTemplate> j = new ArrayList<>();
        private ArrayList<DinamicTemplate> k = new ArrayList<>();
        private ArrayList<DinamicTemplate> l = new ArrayList<>();
        private ArrayList<DinamicTemplate> m = new ArrayList<>();
        private TimerTask n = new TimerTask() {
            /* class com.taobao.android.dinamic.tempate.SerialTaskManager.DownLoadTask.AnonymousClass1 */

            public void run() {
                synchronized (DownLoadTask.this) {
                    if (!DownLoadTask.this.h) {
                        try {
                            if (DownLoadTask.this.i.size() > 0 || DownLoadTask.this.j.size() > 0) {
                                DownLoadTask downLoadTask = DownLoadTask.this;
                                downLoadTask.publishProgress(new tb0[]{downLoadTask.g()});
                                DownLoadTask.this.i.clear();
                                DownLoadTask.this.j.clear();
                            }
                        } catch (Exception e) {
                            DinamicLog.c("SerialTaskManager", e, "callback onFinished is error");
                        }
                    }
                }
            }
        };

        public DownLoadTask(com.taobao.android.dinamic.tempate.manager.a aVar, int i2) {
            this.a = aVar;
            this.g = (long) i2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private tb0 g() {
            tb0 tb0 = new tb0();
            tb0.a = (ArrayList) this.i.clone();
            tb0.b = (ArrayList) this.j.clone();
            ArrayList arrayList = (ArrayList) this.k.clone();
            ArrayList arrayList2 = (ArrayList) this.l.clone();
            ArrayList arrayList3 = (ArrayList) this.m.clone();
            return tb0;
        }

        private a h(@Nullable DinamicTemplate dinamicTemplate) {
            String j2 = j(dinamicTemplate);
            if (TextUtils.isEmpty(j2) || this.a.f(j2) != null) {
                return null;
            }
            a aVar = new a();
            aVar.a = j2;
            aVar.b = dinamicTemplate.templateUrl;
            aVar.c = dinamicTemplate;
            return aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: i */
        public tb0 doInBackground(Void... voidArr) {
            byte[] bArr;
            List<DinamicTemplate> list = this.c;
            if (list == null || list.isEmpty()) {
                this.h = true;
                return g();
            }
            HashSet hashSet = new HashSet();
            for (DinamicTemplate dinamicTemplate : this.c) {
                if (dinamicTemplate == null || TextUtils.isEmpty(dinamicTemplate.templateUrl) || TextUtils.isEmpty(dinamicTemplate.name) || TextUtils.isEmpty(dinamicTemplate.version)) {
                    this.j.add(dinamicTemplate);
                    this.l.add(dinamicTemplate);
                } else {
                    a h2 = h(dinamicTemplate);
                    if (h2 == null) {
                        this.m.add(dinamicTemplate);
                    } else {
                        hashSet.add(h2);
                    }
                }
            }
            if (!hashSet.isEmpty()) {
                Timer timer = new Timer();
                this.f = timer;
                TimerTask timerTask = this.n;
                long j2 = this.g;
                timer.schedule(timerTask, j2, j2);
                ArrayList arrayList = new ArrayList(hashSet);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a aVar = (a) arrayList.get(i2);
                    try {
                        bArr = this.a.b(aVar.c, aVar.a, aVar.b, new tj2(this.d));
                    } catch (Throwable th) {
                        DinamicLog.b("SerialTaskManager", "remote getTemplate", th);
                        bArr = null;
                    }
                    synchronized (this) {
                        if (bArr == null) {
                            this.l.add(aVar.c);
                            this.j.add(aVar.c);
                        } else {
                            this.k.add(aVar.c);
                            this.i.add(aVar.c);
                        }
                        if (i2 == size - 1) {
                            this.h = true;
                            this.f.cancel();
                        }
                    }
                }
            } else {
                this.h = true;
            }
            return g();
        }

        /* access modifiers changed from: package-private */
        public String j(DinamicTemplate dinamicTemplate) {
            return dinamicTemplate.name + JSMethod.NOT_SET + dinamicTemplate.version;
        }

        /* access modifiers changed from: protected */
        /* renamed from: k */
        public void onPostExecute(tb0 tb0) {
            try {
                this.b.onFinished(tb0);
            } catch (Exception e2) {
                DinamicLog.c("SerialTaskManager", e2, "callback onFinished is error");
            } catch (Throwable th) {
                this.e.c();
                throw th;
            }
            this.e.c();
        }

        /* access modifiers changed from: protected */
        /* renamed from: l */
        public void onProgressUpdate(tb0... tb0Arr) {
            try {
                this.b.onFinished(tb0Arr[0]);
            } catch (Exception e2) {
                DinamicLog.c("SerialTaskManager", e2, "callback onFinished is error");
            }
        }
    }

    /* compiled from: Taobao */
    public interface LayoutFileLoadListener {
        void onFinished(tb0 tb0);
    }

    /* compiled from: Taobao */
    public static final class a {
        public String a;
        public String b;
        public DinamicTemplate c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            return TextUtils.equals(this.a, ((a) obj).a);
        }

        public int hashCode() {
            String str = this.a;
            if (str == null) {
                return -1;
            }
            return str.hashCode();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void c() {
        DownLoadTask poll = this.a.poll();
        this.b = poll;
        if (poll != null) {
            this.b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public synchronized void b(DownLoadTask downLoadTask) {
        downLoadTask.e = this;
        this.a.offer(downLoadTask);
        if (this.b == null) {
            c();
        }
    }
}
