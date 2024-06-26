package cn.damai.common.image.luban;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class Luban implements Handler.Callback {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private boolean b;
    private int c;
    private OnRenameListener d;
    private OnCompressListener e;
    private CompressionPredicate f;
    private List<InputStreamProvider> g;
    private Handler h;

    /* compiled from: Taobao */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private String b;
        private int c = 100;
        private OnRenameListener d;
        private OnCompressListener e;
        private CompressionPredicate f;
        private List<InputStreamProvider> g;

        /* renamed from: cn.damai.common.image.luban.Luban$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0012a implements InputStreamProvider {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ String a;

            C0012a(a aVar, String str) {
                this.a = str;
            }

            @Override // cn.damai.common.image.luban.InputStreamProvider
            public String getPath() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-168171661")) {
                    return this.a;
                }
                return (String) ipChange.ipc$dispatch("-168171661", new Object[]{this});
            }

            @Override // cn.damai.common.image.luban.InputStreamProvider
            public InputStream open() throws IOException {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1341696773")) {
                    return new FileInputStream(this.a);
                }
                return (InputStream) ipChange.ipc$dispatch("-1341696773", new Object[]{this});
            }
        }

        /* compiled from: Taobao */
        public class b implements InputStreamProvider {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ String a;

            b(a aVar, String str) {
                this.a = str;
            }

            @Override // cn.damai.common.image.luban.InputStreamProvider
            public String getPath() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "533428213")) {
                    return this.a;
                }
                return (String) ipChange.ipc$dispatch("533428213", new Object[]{this});
            }

            @Override // cn.damai.common.image.luban.InputStreamProvider
            public InputStream open() throws IOException {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-640096899")) {
                    return new FileInputStream(this.a);
                }
                return (InputStream) ipChange.ipc$dispatch("-640096899", new Object[]{this});
            }
        }

        a(Context context) {
            this.a = context;
            this.g = new ArrayList();
        }

        private Luban g() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-86372615")) {
                return new Luban(this);
            }
            return (Luban) ipChange.ipc$dispatch("-86372615", new Object[]{this});
        }

        public File h(String str) throws IOException {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-386196541")) {
                return g().f(new b(this, str), this.a);
            }
            return (File) ipChange.ipc$dispatch("-386196541", new Object[]{this, str});
        }

        public a i(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "880876978")) {
                return (a) ipChange.ipc$dispatch("880876978", new Object[]{this, Integer.valueOf(i)});
            }
            this.c = i;
            return this;
        }

        public void j() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1210627041")) {
                ipChange.ipc$dispatch("1210627041", new Object[]{this});
                return;
            }
            g().k(this.a);
        }

        public a k(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-881384590")) {
                return (a) ipChange.ipc$dispatch("-881384590", new Object[]{this, str});
            }
            this.g.add(new C0012a(this, str));
            return this;
        }

        public a l(OnCompressListener onCompressListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1115681228")) {
                return (a) ipChange.ipc$dispatch("1115681228", new Object[]{this, onCompressListener});
            }
            this.e = onCompressListener;
            return this;
        }

        public a m(OnRenameListener onRenameListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-160099884")) {
                return (a) ipChange.ipc$dispatch("-160099884", new Object[]{this, onRenameListener});
            }
            this.d = onRenameListener;
            return this;
        }

        public a n(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2007027746")) {
                return (a) ipChange.ipc$dispatch("-2007027746", new Object[]{this, str});
            }
            this.b = str;
            return this;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private File e(Context context, InputStreamProvider inputStreamProvider) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2129462926")) {
            return (File) ipChange.ipc$dispatch("2129462926", new Object[]{this, context, inputStreamProvider});
        }
        Checker checker = Checker.SINGLE;
        File i = i(context, checker.extSuffix(inputStreamProvider));
        OnRenameListener onRenameListener = this.d;
        if (onRenameListener != null) {
            i = j(context, onRenameListener.rename(inputStreamProvider.getPath()));
        }
        CompressionPredicate compressionPredicate = this.f;
        if (compressionPredicate != null) {
            if (!compressionPredicate.apply(inputStreamProvider.getPath()) || !checker.needCompress(this.c, inputStreamProvider.getPath())) {
                return new File(inputStreamProvider.getPath());
            }
            return new a(inputStreamProvider, i, this.b).a();
        } else if (checker.needCompress(this.c, inputStreamProvider.getPath())) {
            return new a(inputStreamProvider, i, this.b).a();
        } else {
            return new File(inputStreamProvider.getPath());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private File f(InputStreamProvider inputStreamProvider, Context context) throws IOException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1277884262")) {
            return new a(inputStreamProvider, i(context, Checker.SINGLE.extSuffix(inputStreamProvider)), this.b).a();
        }
        return (File) ipChange.ipc$dispatch("-1277884262", new Object[]{this, inputStreamProvider, context});
    }

    private File g(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1546356686")) {
            return h(context, "luban_disk_cache");
        }
        return (File) ipChange.ipc$dispatch("-1546356686", new Object[]{this, context});
    }

    private static File h(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1467246440")) {
            return (File) ipChange.ipc$dispatch("1467246440", new Object[]{context, str});
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            File file = new File(externalCacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable("Luban", 6)) {
            Log.e("Luban", "default disk cache dir is null");
        }
        return null;
    }

    private File i(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1918619665")) {
            return (File) ipChange.ipc$dispatch("-1918619665", new Object[]{this, context, str});
        }
        if (TextUtils.isEmpty(this.a)) {
            this.a = g(context).getAbsolutePath();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("/");
        sb.append(System.currentTimeMillis());
        sb.append((int) (Math.random() * 1000.0d));
        if (TextUtils.isEmpty(str)) {
            str = ".jpg";
        }
        sb.append(str);
        return new File(sb.toString());
    }

    private File j(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-568766842")) {
            return (File) ipChange.ipc$dispatch("-568766842", new Object[]{this, context, str});
        }
        if (TextUtils.isEmpty(this.a)) {
            this.a = g(context).getAbsolutePath();
        }
        return new File(this.a + "/" + str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k(final Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1016348802")) {
            ipChange.ipc$dispatch("-1016348802", new Object[]{this, context});
            return;
        }
        List<InputStreamProvider> list = this.g;
        if (list == null || (list.size() == 0 && this.e != null)) {
            this.e.onError(new NullPointerException("image file cannot be null"));
        }
        Iterator<InputStreamProvider> it = this.g.iterator();
        while (it.hasNext()) {
            final InputStreamProvider next = it.next();
            AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() {
                /* class cn.damai.common.image.luban.Luban.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "572537973")) {
                        ipChange.ipc$dispatch("572537973", new Object[]{this});
                        return;
                    }
                    try {
                        Luban.this.h.sendMessage(Luban.this.h.obtainMessage(1));
                        Luban.this.h.sendMessage(Luban.this.h.obtainMessage(0, Luban.this.e(context, next)));
                    } catch (IOException e) {
                        Luban.this.h.sendMessage(Luban.this.h.obtainMessage(2, e));
                    }
                }
            });
            it.remove();
        }
    }

    public static a l(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "287689835")) {
            return new a(context);
        }
        return (a) ipChange.ipc$dispatch("287689835", new Object[]{context});
    }

    public boolean handleMessage(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411317509")) {
            return ((Boolean) ipChange.ipc$dispatch("1411317509", new Object[]{this, message})).booleanValue();
        }
        OnCompressListener onCompressListener = this.e;
        if (onCompressListener == null) {
            return false;
        }
        int i = message.what;
        if (i == 0) {
            onCompressListener.onSuccess((File) message.obj);
        } else if (i == 1) {
            onCompressListener.onStart();
        } else if (i == 2) {
            onCompressListener.onError((Throwable) message.obj);
        }
        return false;
    }

    private Luban(a aVar) {
        this.a = aVar.b;
        this.d = aVar.d;
        this.g = aVar.g;
        this.e = aVar.e;
        this.c = aVar.c;
        this.f = aVar.f;
        this.h = new Handler(Looper.getMainLooper(), this);
    }
}
