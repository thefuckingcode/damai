package tb;

import android.os.AsyncTask;
import com.taobao.update.adapter.ThreadExecutor;

/* compiled from: Taobao */
public class mk2 implements ThreadExecutor {

    /* compiled from: Taobao */
    class a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ Runnable a;

        a(mk2 mk2, Runnable runnable) {
            this.a = runnable;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.a.run();
            return null;
        }
    }

    /* compiled from: Taobao */
    class b extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ int a;
        final /* synthetic */ Runnable b;

        b(mk2 mk2, int i, Runnable runnable) {
            this.a = i;
            this.b = runnable;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                Thread.sleep((long) this.a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.b.run();
            return null;
        }
    }

    @Override // com.taobao.update.adapter.ThreadExecutor
    public void delayExecute(Runnable runnable, int i) {
        new b(this, i, runnable).execute(new Void[0]);
    }

    @Override // com.taobao.update.adapter.ThreadExecutor
    public void execute(Runnable runnable) {
        new a(this, runnable).execute(new Void[0]);
    }
}
