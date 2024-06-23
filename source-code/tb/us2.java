package tb;

import android.graphics.BitmapFactory;
import com.alibaba.pictures.uploader.FileUploader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.IUploaderTask;
import java.util.Map;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class us2 implements IUploaderTask {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private String a;
    @Nullable
    private BitmapFactory.Options b;
    @NotNull
    private ss2 c;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @NotNull
        public final String a(@Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1752618352")) {
                return str != null ? str : "task_default";
            }
            return (String) ipChange.ipc$dispatch("-1752618352", new Object[]{this, str, str2});
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public us2(@NotNull ss2 ss2) {
        k21.i(ss2, "uploadInfo");
        this.c = ss2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        ur2 ur2 = ur2.INSTANCE;
        this.b = options;
        BitmapFactory.decodeFile(this.c.b(), this.b);
        Companion.a(getFilePath(), this.a);
    }

    @NotNull
    public final ss2 a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-939637940")) {
            return this.c;
        }
        return (ss2) ipChange.ipc$dispatch("-939637940", new Object[]{this});
    }

    @Override // com.uploader.export.IUploaderTask
    @NotNull
    public String getBizType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340389588")) {
            return (String) ipChange.ipc$dispatch("340389588", new Object[]{this});
        }
        String str = this.a;
        return str != null ? str : FileUploader.Companion.d();
    }

    @Override // com.uploader.export.IUploaderTask
    @NotNull
    public String getFilePath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1642572816")) {
            return (String) ipChange.ipc$dispatch("-1642572816", new Object[]{this});
        }
        String a2 = this.c.a();
        if (a2 == null) {
            a2 = this.c.b();
        }
        return a2 != null ? a2 : "";
    }

    @Override // com.uploader.export.IUploaderTask
    @NotNull
    public String getFileType() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122181765")) {
            return (String) ipChange.ipc$dispatch("1122181765", new Object[]{this});
        }
        BitmapFactory.Options options = this.b;
        String str2 = null;
        if (!(options == null || (str = options.outMimeType) == null)) {
            if (!(StringsKt__StringsKt.Q(str, "/", false, 2, null))) {
                str = null;
            }
            if (str != null) {
                String substring = str.substring(StringsKt__StringsKt.l0(str, "/", 0, false, 6, null) + 1);
                k21.h(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        String b2 = this.c.b();
        if (b2 == null) {
            return "";
        }
        if (StringsKt__StringsKt.Q(b2, ".", false, 2, null)) {
            str2 = b2;
        }
        if (str2 == null) {
            return "";
        }
        String substring2 = str2.substring(StringsKt__StringsKt.l0(str2, ".", 0, false, 6, null) + 1);
        k21.h(substring2, "(this as java.lang.String).substring(startIndex)");
        FileUploader.Companion.h("UploadTask-upload file【oriPath】 type:" + substring2);
        return substring2;
    }

    @Override // com.uploader.export.IUploaderTask
    @Nullable
    public Map<String, String> getMetaInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1922615661")) {
            return null;
        }
        return (Map) ipChange.ipc$dispatch("-1922615661", new Object[]{this});
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public us2(@NotNull ss2 ss2, @Nullable String str) {
        this(ss2);
        k21.i(ss2, "uploadInfo");
        this.a = str;
    }
}
