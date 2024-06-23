package tb;

import com.alibaba.pictures.uploader.FileUploadListener;
import com.alibaba.pictures.uploader.UploadErrorCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class s40 implements FileUploadListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public void a(@NotNull ss2 ss2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871904213")) {
            ipChange.ipc$dispatch("-871904213", new Object[]{this, ss2});
            return;
        }
        k21.i(ss2, "uploadInfo");
    }

    public void b(@NotNull ss2 ss2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099993518")) {
            ipChange.ipc$dispatch("-1099993518", new Object[]{this, ss2});
            return;
        }
        k21.i(ss2, "uploadInfo");
    }

    @Override // com.alibaba.pictures.uploader.FileUploadListener
    public void onAllSuccess(@NotNull List<ss2> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1123051479")) {
            ipChange.ipc$dispatch("1123051479", new Object[]{this, list});
            return;
        }
        k21.i(list, "uploadInfoGroup");
        if (list.size() == 1) {
            b(list.get(0));
        }
    }

    @Override // com.alibaba.pictures.uploader.FileUploadListener
    public void onAllTaskProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2040911855")) {
            ipChange.ipc$dispatch("-2040911855", new Object[]{this, Float.valueOf(f)});
        }
    }

    @Override // com.alibaba.pictures.uploader.FileUploadListener
    public void onCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917046258")) {
            ipChange.ipc$dispatch("-1917046258", new Object[]{this});
        }
    }

    @Override // com.alibaba.pictures.uploader.FileUploadListener
    public void onFailure(@NotNull UploadErrorCode uploadErrorCode, @NotNull List<ss2> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-268957234")) {
            ipChange.ipc$dispatch("-268957234", new Object[]{this, uploadErrorCode, list});
            return;
        }
        k21.i(uploadErrorCode, "errorCode");
        k21.i(list, "uploadInfoGroup");
        if (list.size() == 1) {
            a(list.get(0));
        }
    }

    @Override // com.alibaba.pictures.uploader.FileUploadListener
    public void onSingleTaskProgress(@Nullable ss2 ss2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548842854")) {
            ipChange.ipc$dispatch("548842854", new Object[]{this, ss2});
        }
    }
}
