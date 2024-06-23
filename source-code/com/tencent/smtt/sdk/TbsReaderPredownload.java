package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.sdk.TbsReaderView;
import java.util.LinkedList;

public class TbsReaderPredownload {
    public static final int READER_SO_SUCCESS = 2;
    public static final int READER_WAIT_IN_QUEUE = 3;
    static final String[] b = {"docx", "pptx", "xlsx", "pdf", "epub", "txt"};
    Handler a = null;
    LinkedList<String> c = new LinkedList<>();
    boolean d;
    ReaderWizard e;
    TbsReaderView.ReaderCallback f;
    Object g;
    Context h;
    ReaderPreDownloadCallback i;
    String j;

    public interface ReaderPreDownloadCallback {
        public static final int NOTIFY_PLUGIN_FAILED = -1;
        public static final int NOTIFY_PLUGIN_SUCCESS = 0;

        void onEvent(String str, int i, boolean z);
    }

    public TbsReaderPredownload(ReaderPreDownloadCallback readerPreDownloadCallback) {
        this.d = false;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = "";
        this.i = readerPreDownloadCallback;
        for (String str : b) {
            this.c.add(str);
        }
        a();
    }

    public boolean init(Context context) {
        if (context == null) {
            return false;
        }
        this.h = context.getApplicationContext();
        boolean a2 = TbsReaderView.a(context.getApplicationContext());
        AnonymousClass1 r2 = new TbsReaderView.ReaderCallback() {
            /* class com.tencent.smtt.sdk.TbsReaderPredownload.AnonymousClass1 */

            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                int intValue;
                if (num.intValue() == 5012 && 5014 != (intValue = ((Integer) obj).intValue())) {
                    if (5013 == intValue) {
                        TbsReaderPredownload.this.a(0);
                    } else if (intValue == 0) {
                        TbsReaderPredownload.this.a(0);
                    } else {
                        TbsReaderPredownload.this.a(-1);
                    }
                    TbsReaderPredownload.this.j = "";
                    TbsReaderPredownload.this.a(3, 100);
                }
            }
        };
        this.f = r2;
        try {
            if (this.e == null) {
                this.e = new ReaderWizard(r2);
            }
            if (this.g == null) {
                this.g = this.e.getTbsReader();
            }
            Object obj = this.g;
            if (obj != null) {
                return this.e.initTbsReader(obj, context.getApplicationContext());
            }
            return a2;
        } catch (NullPointerException unused) {
            Log.e("TbsReaderPredownload", "Unexpect null object!");
            return false;
        }
    }

    public void startAll() {
        this.d = false;
        if (!false && !c(3)) {
            a(3, 100);
        }
    }

    public void start(String str) {
        this.d = false;
        b(3);
        this.c.add(str);
        a(3, 100);
    }

    public void pause() {
        this.d = true;
    }

    public void shutdown() {
        this.i = null;
        this.d = false;
        this.c.clear();
        b();
        ReaderWizard readerWizard = this.e;
        if (readerWizard != null) {
            readerWizard.destroy(this.g);
            this.g = null;
        }
        this.h = null;
    }

    private void b() {
        b(3);
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        if (this.g == null || this.e == null || !ReaderWizard.isSupportExt(str)) {
            return false;
        }
        return this.e.checkPlugin(this.g, this.h, str, true);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.i != null) {
            this.i.onEvent(this.j, i2, this.c.isEmpty());
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.a = new Handler(Looper.getMainLooper()) {
            /* class com.tencent.smtt.sdk.TbsReaderPredownload.AnonymousClass2 */

            public void handleMessage(Message message) {
                if (message.what == 3 && !TbsReaderPredownload.this.c.isEmpty() && !TbsReaderPredownload.this.d) {
                    String removeFirst = TbsReaderPredownload.this.c.removeFirst();
                    TbsReaderPredownload.this.j = removeFirst;
                    if (!TbsReaderPredownload.this.a(removeFirst)) {
                        TbsReaderPredownload.this.a(-1);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.a.removeMessages(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2) {
        return this.a.hasMessages(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        this.a.sendMessageDelayed(this.a.obtainMessage(i2), (long) i3);
    }
}
