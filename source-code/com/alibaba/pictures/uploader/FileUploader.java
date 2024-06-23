package com.alibaba.pictures.uploader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderTask;
import com.uploader.export.UploaderGlobal;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ej2;
import tb.f90;
import tb.k21;
import tb.m40;
import tb.os2;
import tb.ps2;
import tb.ss2;
import tb.us2;
import tb.wn;
import tb.ws2;
import tb.ys2;

/* compiled from: Taobao */
public final class FileUploader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String TAG = "Pic:FileUploader";
    @Nullable
    private static IImageCompressor l;
    public static String m;
    public static Context n;
    private static int o;
    @Nullable
    private static Boolean p = Boolean.FALSE;
    private ArrayList<ss2> a;
    private ArrayList<us2> b;
    private AtomicInteger c;
    private AtomicInteger d;
    private int e;
    private FileUploadListener f;
    private Job g;
    private Boolean h;
    private os2 i;
    private b j;
    @Nullable
    private String k;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @JvmStatic
        @NotNull
        public final FileUploader a(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1034538392")) {
                return new FileUploader(str, null);
            }
            return (FileUploader) ipChange.ipc$dispatch("1034538392", new Object[]{this, str});
        }

        @NotNull
        public final Context b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1381479442")) {
                return (Context) ipChange.ipc$dispatch("-1381479442", new Object[]{this});
            }
            Context context = FileUploader.n;
            if (context == null) {
                k21.A(WPKFactory.INIT_KEY_CONTEXT);
            }
            return context;
        }

        @Nullable
        public final Boolean c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "108040501")) {
                return FileUploader.p;
            }
            return (Boolean) ipChange.ipc$dispatch("108040501", new Object[]{this});
        }

        @NotNull
        public final String d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1418376391")) {
                return (String) ipChange.ipc$dispatch("1418376391", new Object[]{this});
            }
            String str = FileUploader.m;
            if (str == null) {
                k21.A("defaultBizType");
            }
            return str;
        }

        public final int e() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1149919227")) {
                return FileUploader.o;
            }
            return ((Integer) ipChange.ipc$dispatch("-1149919227", new Object[]{this})).intValue();
        }

        @Nullable
        public final IImageCompressor f() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-977067199")) {
                return (IImageCompressor) ipChange.ipc$dispatch("-977067199", new Object[]{this});
            }
            if (FileUploader.l == null) {
                FileUploader.l = new ps2();
            }
            return FileUploader.l;
        }

        @JvmStatic
        public final void g(@Nullable Context context, @Nullable Integer num, @NotNull String str, @NotNull String str2) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1008665972")) {
                ipChange.ipc$dispatch("1008665972", new Object[]{this, context, num, str, str2});
                return;
            }
            k21.i(str, "appKey");
            k21.i(str2, "defaultBizType");
            if (context != null) {
                Context applicationContext = context.getApplicationContext();
                k21.h(applicationContext, "context.applicationContext");
                i(applicationContext);
                j(str2);
                UploaderGlobal.g(context);
                if (num != null) {
                    i = num.intValue();
                }
                k(i);
                UploaderGlobal.e(e(), str);
                ys2 ys2 = new ys2(context);
                ys2.setEnvironment(e());
                UploaderGlobal.c(new ws2(context, ys2));
            }
        }

        public final void h(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1907181215")) {
                ipChange.ipc$dispatch("-1907181215", new Object[]{this, str});
            } else if (k21.d(c(), Boolean.TRUE)) {
                if (str == null) {
                    str = "--";
                }
                Log.d(FileUploader.TAG, str);
            }
        }

        public final void i(@NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-126905082")) {
                ipChange.ipc$dispatch("-126905082", new Object[]{this, context});
                return;
            }
            k21.i(context, "<set-?>");
            FileUploader.n = context;
        }

        public final void j(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1902888439")) {
                ipChange.ipc$dispatch("1902888439", new Object[]{this, str});
                return;
            }
            k21.i(str, "<set-?>");
            FileUploader.m = str;
        }

        public final void k(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-367694171")) {
                ipChange.ipc$dispatch("-367694171", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            FileUploader.o = i;
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FileUploader a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FileUploader fileUploader, Looper looper) {
            super(looper);
            this.a = fileUploader;
        }

        public void handleMessage(@NotNull Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "624329147")) {
                ipChange.ipc$dispatch("624329147", new Object[]{this, message});
                return;
            }
            k21.i(message, "msg");
            int i = message.what;
            UploadErrorCode uploadErrorCode = UploadErrorCode.TIME_OUT;
            if (i == uploadErrorCode.getValue()) {
                FileUploadListener fileUploadListener = this.a.f;
                if (fileUploadListener != null) {
                    fileUploadListener.onFailure(uploadErrorCode, this.a.a);
                }
                this.a.p();
            }
        }
    }

    private FileUploader(String str) {
        this.k = str;
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.c = new AtomicInteger(0);
        this.d = new AtomicInteger(0);
        this.h = Boolean.FALSE;
        this.j = new b(this, Looper.getMainLooper());
    }

    public static /* synthetic */ FileUploader A(FileUploader fileUploader, os2 os2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            os2 = null;
        }
        return fileUploader.z(os2);
    }

    public static final void B(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595746607")) {
            ipChange.ipc$dispatch("-595746607", new Object[]{bool});
            return;
        }
        p = bool;
    }

    public static /* synthetic */ void F(FileUploader fileUploader, String str, Long l2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l2 = null;
        }
        fileUploader.E(str, l2);
    }

    public static /* synthetic */ void I(FileUploader fileUploader, List list, Long l2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l2 = null;
        }
        fileUploader.H(list, l2);
    }

    @JvmStatic
    @NotNull
    public static final FileUploader q(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1729571888")) {
            return Companion.a(str);
        }
        return (FileUploader) ipChange.ipc$dispatch("-1729571888", new Object[]{str});
    }

    @JvmStatic
    public static final void s(@Nullable Context context, @Nullable Integer num, @NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921978796")) {
            ipChange.ipc$dispatch("1921978796", new Object[]{context, num, str, str2});
            return;
        }
        Companion.g(context, num, str, str2);
    }

    @NotNull
    public final FileUploader C(@Nullable FileUploadListener fileUploadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1761799520")) {
            return (FileUploader) ipChange.ipc$dispatch("-1761799520", new Object[]{this, fileUploadListener});
        }
        this.f = fileUploadListener;
        return this;
    }

    @JvmOverloads
    public final void D(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961503504")) {
            ipChange.ipc$dispatch("-1961503504", new Object[]{this, str});
            return;
        }
        F(this, str, null, 2, null);
    }

    @JvmOverloads
    public final void E(@Nullable String str, @Nullable Long l2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1324231983")) {
            ipChange.ipc$dispatch("1324231983", new Object[]{this, str, l2});
            return;
        }
        Companion.h("startUpload---");
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            FileUploadListener fileUploadListener = this.f;
            if (fileUploadListener != null) {
                fileUploadListener.onFailure(UploadErrorCode.FAIL_SELF, this.a);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        H(arrayList, l2);
    }

    @JvmOverloads
    public final void G(@Nullable List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309161706")) {
            ipChange.ipc$dispatch("-309161706", new Object[]{this, list});
            return;
        }
        I(this, list, null, 2, null);
    }

    @JvmOverloads
    public final void H(@Nullable List<String> list, @Nullable Long l2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-240525995")) {
            ipChange.ipc$dispatch("-240525995", new Object[]{this, list, l2});
            return;
        }
        this.b.clear();
        this.a.clear();
        int size = list != null ? list.size() : 0;
        this.e = size;
        this.c.set(size);
        this.d.set(this.e);
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (z) {
            FileUploadListener fileUploadListener = this.f;
            if (fileUploadListener != null) {
                fileUploadListener.onFailure(UploadErrorCode.FAIL_SELF, this.a);
                return;
            }
            return;
        }
        if (l2 != null && l2.longValue() > 0) {
            a aVar = Companion;
            aVar.h("startUpLoadGroup---开始超时处理=" + l2);
            Message obtain = Message.obtain();
            obtain.what = UploadErrorCode.TIME_OUT.getValue();
            this.j.sendMessageDelayed(obtain, l2.longValue());
        }
        this.g = f.b(wn.a(f90.b()), null, null, new FileUploader$uploadGroup$1(this, list, null), 3, null);
    }

    public final void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895211123")) {
            ipChange.ipc$dispatch("-895211123", new Object[]{this});
            return;
        }
        for (T t : this.b) {
            if (t.a().b() != null) {
                com.uploader.export.a.a().cancelAsync(t);
            }
        }
        Job job = this.g;
        if (job != null && job.isActive()) {
            Job.a.b(job, null, 1, null);
        }
    }

    @Nullable
    public final String r() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1794624849")) {
            return this.k;
        }
        return (String) ipChange.ipc$dispatch("-1794624849", new Object[]{this});
    }

    public final void t(@Nullable IUploaderTask iUploaderTask) {
        FileUploadListener fileUploadListener;
        ss2 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1067112244")) {
            ipChange.ipc$dispatch("-1067112244", new Object[]{this, iUploaderTask});
            return;
        }
        if (!(iUploaderTask instanceof us2)) {
            iUploaderTask = null;
        }
        us2 us2 = (us2) iUploaderTask;
        if (!(us2 == null || (a2 = us2.a()) == null)) {
            a2.k(UploadStatus.CANCEL);
        }
        if (this.c.decrementAndGet() <= 0 && (fileUploadListener = this.f) != null) {
            fileUploadListener.onFailure(UploadErrorCode.FAIL, this.a);
        }
    }

    public final void u(@Nullable IUploaderTask iUploaderTask, @Nullable ej2 ej2) {
        FileUploadListener fileUploadListener;
        ss2 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073050430")) {
            ipChange.ipc$dispatch("1073050430", new Object[]{this, iUploaderTask, ej2});
            return;
        }
        if (!(iUploaderTask instanceof us2)) {
            iUploaderTask = null;
        }
        us2 us2 = (us2) iUploaderTask;
        if (!(us2 == null || (a2 = us2.a()) == null)) {
            a2.k(UploadStatus.FAILURE);
            a2.f(ej2);
        }
        if (this.c.decrementAndGet() <= 0 && (fileUploadListener = this.f) != null) {
            fileUploadListener.onFailure(UploadErrorCode.FAIL, this.a);
        }
    }

    public final void v(@Nullable IUploaderTask iUploaderTask, @Nullable UploadStatus uploadStatus) {
        ss2 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1309913608")) {
            ipChange.ipc$dispatch("1309913608", new Object[]{this, iUploaderTask, uploadStatus});
            return;
        }
        if (!(iUploaderTask instanceof us2)) {
            iUploaderTask = null;
        }
        us2 us2 = (us2) iUploaderTask;
        if (us2 != null && (a2 = us2.a()) != null) {
            a2.k(uploadStatus);
        }
    }

    public final void w(@Nullable IUploaderTask iUploaderTask, int i2) {
        ss2 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431548708")) {
            ipChange.ipc$dispatch("1431548708", new Object[]{this, iUploaderTask, Integer.valueOf(i2)});
            return;
        }
        if (!(iUploaderTask instanceof us2)) {
            iUploaderTask = null;
        }
        us2 us2 = (us2) iUploaderTask;
        if (us2 != null && (a2 = us2.a()) != null) {
            a2.k(UploadStatus.UPLOADING);
            a2.i(i2);
            FileUploadListener fileUploadListener = this.f;
            if (fileUploadListener != null) {
                fileUploadListener.onSingleTaskProgress(a2);
            }
        }
    }

    public final void x(@Nullable IUploaderTask iUploaderTask, @Nullable ITaskResult iTaskResult) {
        ss2 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353463395")) {
            ipChange.ipc$dispatch("-353463395", new Object[]{this, iUploaderTask, iTaskResult});
            return;
        }
        if (!(iUploaderTask instanceof us2)) {
            iUploaderTask = null;
        }
        us2 us2 = (us2) iUploaderTask;
        if (!(us2 == null || (a2 = us2.a()) == null)) {
            a2.k(UploadStatus.SUCCESS);
            a2.j(iTaskResult);
        }
        int decrementAndGet = this.d.decrementAndGet();
        int i2 = this.e;
        float f2 = 1.0f;
        if (i2 > 0) {
            f2 = (((float) (i2 - decrementAndGet)) * 1.0f) / ((float) i2);
        }
        FileUploadListener fileUploadListener = this.f;
        if (fileUploadListener != null) {
            fileUploadListener.onAllTaskProgress(f2);
        }
        if (this.c.decrementAndGet() > 0) {
            return;
        }
        if (decrementAndGet <= 0) {
            FileUploadListener fileUploadListener2 = this.f;
            if (fileUploadListener2 != null) {
                fileUploadListener2.onAllSuccess(this.a);
                return;
            }
            return;
        }
        FileUploadListener fileUploadListener3 = this.f;
        if (fileUploadListener3 != null) {
            fileUploadListener3.onFailure(UploadErrorCode.FAIL, this.a);
        }
    }

    @JvmOverloads
    @NotNull
    public final FileUploader y() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2022835651")) {
            return A(this, null, 1, null);
        }
        return (FileUploader) ipChange.ipc$dispatch("2022835651", new Object[]{this});
    }

    @JvmOverloads
    @NotNull
    public final FileUploader z(@Nullable os2 os2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511929856")) {
            return (FileUploader) ipChange.ipc$dispatch("-511929856", new Object[]{this, os2});
        }
        this.h = Boolean.TRUE;
        this.i = os2;
        return this;
    }

    public /* synthetic */ FileUploader(String str, m40 m40) {
        this(str);
    }
}
