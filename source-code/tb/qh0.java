package tb;

import com.taobao.android.sopatch.common.Constants;
import com.taobao.android.sopatch.storage.FileStorage;
import com.taobao.tao.log.TLogConstant;
import java.io.File;

/* compiled from: Taobao */
final class qh0 implements FileStorage {
    private final File a;
    private final File b;
    private final File c;

    qh0(File file) {
        File file2 = new File(file, Constants.SHARE_PREFERENCES_NAME);
        this.a = file2;
        b(file2);
        File file3 = new File(file2, ps0.d().a());
        this.b = file3;
        b(file3);
        File file4 = new File(file3, c22.a());
        this.c = file4;
        b(file4);
    }

    private void a(File file) {
        if (!file.equals(this.b)) {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    a(file2);
                }
            }
            try {
                file.delete();
            } catch (Throwable th) {
                s91.e(th);
            }
        }
    }

    private void b(File file) {
        try {
            if (!file.exists() || !file.isDirectory()) {
                file.delete();
                file.mkdir();
            }
        } catch (Throwable th) {
            s91.e(th);
        }
    }

    private void c() {
        b(this.a);
        b(this.b);
        b(this.c);
    }

    private File d(File file) {
        try {
            if (!file.exists() || file.isDirectory()) {
                file.delete();
                file.createNewFile();
            }
        } catch (Exception e) {
            s91.e(e);
        }
        return file;
    }

    @Override // com.taobao.android.sopatch.storage.FileStorage
    public void deleteInvalidFiles() {
        if (this.a.isDirectory()) {
            for (File file : this.a.listFiles()) {
                a(file);
            }
        }
    }

    @Override // com.taobao.android.sopatch.storage.FileStorage
    public File getSoFile(pc2 pc2) {
        c();
        File file = this.c;
        File file2 = new File(file, "" + pc2.c());
        b(file2);
        File file3 = new File(file2, pc2.a());
        b(file3);
        return d(new File(file3, pc2.b()));
    }

    @Override // com.taobao.android.sopatch.storage.FileStorage
    public File getSoPatchCacheFile() {
        c();
        File file = new File(this.b, "AdaLace.ada");
        try {
            if (file.isDirectory()) {
                file.delete();
            }
        } catch (Throwable th) {
            s91.e(th);
        }
        return d(file);
    }

    @Override // com.taobao.android.sopatch.storage.FileStorage
    public File getTmpFile(String str) {
        c();
        File file = new File(this.c, TLogConstant.RUBBISH_DIR);
        b(file);
        return d(new File(file, str));
    }

    @Override // com.taobao.android.sopatch.storage.FileStorage
    public File getZipFile(sc2 sc2) {
        c();
        File file = this.c;
        File file2 = new File(file, "" + sc2.d());
        b(file2);
        File file3 = new File(file2, sc2.c());
        b(file3);
        return d(new File(file3, "result.zip"));
    }
}
