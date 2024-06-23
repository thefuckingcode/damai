package com.taobao.android.routine;

import android.app.Activity;
import com.taobao.android.routine.UiAsyncTask;
import java.io.IOException;
import java.net.URL;

/* compiled from: Taobao */
public class UiAsyncTaskDemo {

    /* compiled from: Taobao */
    static class DemoActivity extends Activity implements UiAsyncTask.UiPostExecutable<Object> {
        DemoActivity() {
        }

        /* access modifiers changed from: protected */
        public void onResume() {
            super.onResume();
            new a(this, this).execute("http://...");
        }

        @Override // com.taobao.android.routine.UiAsyncTask.UiPostExecutable
        public void onUiPostExecute(Object obj) {
        }
    }

    /* compiled from: Taobao */
    static class a extends UiAsyncTask<String, Integer, Object> {
        public a(Activity activity, UiAsyncTask.UiPostExecutable<Object> uiPostExecutable) {
            super(activity, uiPostExecutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Object doInBackground(String... strArr) {
            try {
                return new URL(strArr[0]).getContent();
            } catch (IOException unused) {
                return null;
            }
        }
    }
}
