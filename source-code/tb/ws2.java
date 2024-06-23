package tb;

import android.content.Context;
import androidx.annotation.NonNull;
import com.uploader.export.IUploaderDependency;
import com.uploader.export.IUploaderEnvironment;
import com.uploader.export.IUploaderLog;
import com.uploader.export.IUploaderStatistics;
import com.uploader.export.UploaderGlobal;

/* compiled from: Taobao */
public class ws2 implements IUploaderDependency {
    static Context d;
    private IUploaderEnvironment a;
    private IUploaderLog b;
    private IUploaderStatistics c;

    public ws2() {
        this(null, new ys2(UploaderGlobal.f()), new at2(), new bt2());
    }

    @Override // com.uploader.export.IUploaderDependency
    @NonNull
    public IUploaderEnvironment getEnvironment() {
        return this.a;
    }

    @Override // com.uploader.export.IUploaderDependency
    public IUploaderLog getLog() {
        return this.b;
    }

    @Override // com.uploader.export.IUploaderDependency
    public IUploaderStatistics getStatistics() {
        return this.c;
    }

    public ws2(Context context) {
        this(context, new ys2(context), new at2(), new bt2());
    }

    public ws2(Context context, IUploaderEnvironment iUploaderEnvironment) {
        this(context, iUploaderEnvironment, new at2(), new bt2());
    }

    public ws2(Context context, IUploaderEnvironment iUploaderEnvironment, IUploaderLog iUploaderLog, IUploaderStatistics iUploaderStatistics) {
        if (context == null) {
            d = UploaderGlobal.f();
        } else {
            d = context;
        }
        this.a = iUploaderEnvironment;
        this.b = iUploaderLog;
        this.c = iUploaderStatistics;
    }
}
