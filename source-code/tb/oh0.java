package tb;

import com.taobao.phenix.builder.Builder;
import com.taobao.phenix.loader.file.FileLoader;
import com.taobao.phenix.loader.file.a;

/* compiled from: Taobao */
public class oh0 implements Builder<FileLoader> {
    private boolean a;
    private FileLoader b;

    /* renamed from: a */
    public synchronized FileLoader build() {
        if (this.a) {
            return this.b;
        }
        this.a = true;
        if (this.b == null) {
            this.b = new a();
        }
        return this.b;
    }

    /* renamed from: b */
    public oh0 with(FileLoader fileLoader) {
        cs1.e(!this.a, "FileLoaderBuilder has been built, not allow with() now");
        this.b = fileLoader;
        return this;
    }
}
