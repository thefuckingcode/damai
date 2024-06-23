package tb;

import com.alibaba.pictures.uploader.FileUploader;
import com.alibaba.pictures.uploader.UploadStatus;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderTask;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class vs2 implements ITaskListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final FileUploader a;

    public vs2(@NotNull FileUploader fileUploader) {
        k21.i(fileUploader, "fileUploader");
        this.a = fileUploader;
    }

    @Override // com.uploader.export.ITaskListener
    public void onCancel(@Nullable IUploaderTask iUploaderTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1523913329")) {
            ipChange.ipc$dispatch("-1523913329", new Object[]{this, iUploaderTask});
            return;
        }
        this.a.t(iUploaderTask);
    }

    @Override // com.uploader.export.ITaskListener
    public void onFailure(@Nullable IUploaderTask iUploaderTask, @Nullable ej2 ej2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671126527")) {
            ipChange.ipc$dispatch("-671126527", new Object[]{this, iUploaderTask, ej2});
            return;
        }
        this.a.u(iUploaderTask, ej2);
    }

    @Override // com.uploader.export.ITaskListener
    public void onPause(@Nullable IUploaderTask iUploaderTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "394997361")) {
            ipChange.ipc$dispatch("394997361", new Object[]{this, iUploaderTask});
            return;
        }
        this.a.v(iUploaderTask, UploadStatus.PAUSE);
    }

    @Override // com.uploader.export.ITaskListener
    public void onProgress(@Nullable IUploaderTask iUploaderTask, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-673180799")) {
            ipChange.ipc$dispatch("-673180799", new Object[]{this, iUploaderTask, Integer.valueOf(i)});
            return;
        }
        this.a.w(iUploaderTask, i);
    }

    @Override // com.uploader.export.ITaskListener
    public void onResume(@Nullable IUploaderTask iUploaderTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-399464190")) {
            ipChange.ipc$dispatch("-399464190", new Object[]{this, iUploaderTask});
            return;
        }
        this.a.v(iUploaderTask, UploadStatus.RESUME);
    }

    @Override // com.uploader.export.ITaskListener
    public void onStart(@Nullable IUploaderTask iUploaderTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-952132643")) {
            ipChange.ipc$dispatch("-952132643", new Object[]{this, iUploaderTask});
            return;
        }
        this.a.v(iUploaderTask, UploadStatus.START);
    }

    @Override // com.uploader.export.ITaskListener
    public void onSuccess(@Nullable IUploaderTask iUploaderTask, @Nullable ITaskResult iTaskResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1470273632")) {
            ipChange.ipc$dispatch("-1470273632", new Object[]{this, iUploaderTask, iTaskResult});
            return;
        }
        this.a.x(iUploaderTask, iTaskResult);
    }

    @Override // com.uploader.export.ITaskListener
    public void onWait(@Nullable IUploaderTask iUploaderTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "127653770")) {
            ipChange.ipc$dispatch("127653770", new Object[]{this, iUploaderTask});
            return;
        }
        this.a.v(iUploaderTask, UploadStatus.WAIT);
    }
}
