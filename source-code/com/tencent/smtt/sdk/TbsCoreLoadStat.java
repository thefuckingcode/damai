package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.util.Arrays;

public class TbsCoreLoadStat {
    private static TbsCoreLoadStat d = null;
    public static volatile int mLoadErrorCode = -1;
    private TbsSequenceQueue a = null;
    private boolean b = false;
    private final int c = 3;

    private TbsCoreLoadStat() {
    }

    public static TbsCoreLoadStat getInstance() {
        if (d == null) {
            d = new TbsCoreLoadStat();
        }
        return d;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        TbsSequenceQueue tbsSequenceQueue = this.a;
        if (tbsSequenceQueue != null) {
            tbsSequenceQueue.clear();
        }
        this.b = false;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, int i) {
        a(context, i, null);
        TbsLog.e(TbsListener.tag_load_error, "" + i);
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(Context context, int i, Throwable th) {
        if (mLoadErrorCode == -1) {
            mLoadErrorCode = i;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, "code=%d,desc=%s", Integer.valueOf(i), String.valueOf(th));
            if (th != null) {
                TbsLogReport.getInstance(context).setLoadErrorCode(i, th);
            } else {
                TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + i + "; Check & correct it!");
            }
            return;
        }
        TbsLog.w("TbsCoreLoadStat", "setLoadErrorCode :: error(" + mLoadErrorCode + ") was already reported; " + i + " is duplicated. Try to remove it!");
    }

    public class TbsSequenceQueue {
        private int b;
        private int c;
        private int[] d;
        private int e;
        private int f;

        public TbsSequenceQueue() {
            this.b = 10;
            this.e = 0;
            this.f = 0;
            this.c = 10;
            this.d = new int[10];
        }

        public TbsSequenceQueue(int i, int i2) {
            this.b = 10;
            this.e = 0;
            this.f = 0;
            this.c = i2;
            int[] iArr = new int[i2];
            this.d = iArr;
            iArr[0] = i;
            this.f = 0 + 1;
        }

        public int length() {
            return this.f - this.e;
        }

        public void add(int i) {
            int i2 = this.f;
            if (i2 <= this.c - 1) {
                int[] iArr = this.d;
                this.f = i2 + 1;
                iArr[i2] = i;
                return;
            }
            throw new IndexOutOfBoundsException("sequeue is full");
        }

        public int remove() {
            if (!empty()) {
                int[] iArr = this.d;
                int i = this.e;
                int i2 = iArr[i];
                this.e = i + 1;
                iArr[i] = 0;
                return i2;
            }
            throw new IndexOutOfBoundsException("sequeue is null");
        }

        public int element() {
            if (!empty()) {
                return this.d[this.e];
            }
            throw new IndexOutOfBoundsException("sequeue is null");
        }

        public boolean empty() {
            return this.f == this.e;
        }

        public void clear() {
            Arrays.fill(this.d, 0);
            this.e = 0;
            this.f = 0;
        }

        public String toString() {
            if (empty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder("[");
            for (int i = this.e; i < this.f; i++) {
                sb.append(String.valueOf(this.d[i]) + ",");
            }
            int length = sb.length();
            StringBuilder delete = sb.delete(length - 1, length);
            delete.append("]");
            return delete.toString();
        }
    }
}
