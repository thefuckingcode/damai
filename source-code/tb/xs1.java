package tb;

import androidx.annotation.NonNull;
import com.taobao.android.tlog.protocol.model.joint.point.StartupJointPoint;
import com.taobao.monitor.network.a;
import com.taobao.monitor.procedure.ProcedureImpl;
import com.taobao.monitor.procedure.f;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: Taobao */
public class xs1 implements ProcedureImpl.IProcedureLifeCycle {
    public static final String DEFAULT_SAVE_DIR = "apm";

    private void a(File file) {
        File[] listFiles;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length >= 10) {
            e(listFiles, 0, listFiles.length - 1);
            for (int i = 0; i < (listFiles.length - 10) + 1; i++) {
                listFiles[i].delete();
            }
        }
    }

    private void b(File file) {
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String c(f fVar) {
        Object obj = fVar.m().get("pageName");
        if (obj == null) {
            return "null";
        }
        return (String) obj;
    }

    @NonNull
    public static File d() {
        StringBuilder sb = new StringBuilder();
        sb.append(us1.d().a().getCacheDir());
        String str = File.separator;
        sb.append(str);
        sb.append(DEFAULT_SAVE_DIR);
        sb.append(str);
        return new File(sb.toString());
    }

    public static void e(File[] fileArr, int i, int i2) {
        if (i < i2) {
            File file = fileArr[i];
            int i3 = i;
            int i4 = i2;
            while (i3 < i4) {
                while (fileArr[i4].lastModified() >= file.lastModified() && i3 < i4) {
                    i4--;
                }
                while (fileArr[i3].lastModified() <= file.lastModified() && i3 < i4) {
                    i3++;
                }
                File file2 = fileArr[i4];
                fileArr[i4] = fileArr[i3];
                fileArr[i3] = file2;
            }
            fileArr[i] = fileArr[i3];
            fileArr[i3] = file;
            e(fileArr, i, i4 - 1);
            e(fileArr, i4 + 1, i2);
        }
    }

    private void f(f fVar) {
        if (fVar.v() != null) {
            if ("pageLoad".equals(fVar.o()) || StartupJointPoint.TYPE.equals(fVar.o())) {
                File d = d();
                a(d);
                g(d, fVar.o() + JSMethod.NOT_SET + c(fVar) + JSMethod.NOT_SET + fVar.n() + ".json", a.a(fVar));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056 A[SYNTHETIC, Splitter:B:23:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074 A[SYNTHETIC, Splitter:B:31:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e A[SYNTHETIC, Splitter:B:37:0x008e] */
    private void g(File file, String str, String str2) {
        Throwable th;
        FileNotFoundException e;
        IOException e2;
        File file2 = new File(file, str);
        b(file2);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                do {
                } while (fileOutputStream2.getChannel().write(Charset.forName("utf8").encode(str2)) != 0);
                try {
                    fileOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                t91.a("ProcedureStorage", "存储成功", file.getPath(), str);
            } catch (FileNotFoundException e4) {
                e = e4;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                t91.a("ProcedureStorage", "存储成功", file.getPath(), str);
            } catch (IOException e6) {
                e2 = e6;
                fileOutputStream = fileOutputStream2;
                try {
                    e2.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    t91.a("ProcedureStorage", "存储成功", file.getPath(), str);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                    }
                    t91.a("ProcedureStorage", "存储成功", file.getPath(), str);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                t91.a("ProcedureStorage", "存储成功", file.getPath(), str);
                throw th;
            }
        } catch (FileNotFoundException e9) {
            e = e9;
            e.printStackTrace();
            if (fileOutputStream != null) {
            }
            t91.a("ProcedureStorage", "存储成功", file.getPath(), str);
        } catch (IOException e10) {
            e2 = e10;
            e2.printStackTrace();
            if (fileOutputStream != null) {
            }
            t91.a("ProcedureStorage", "存储成功", file.getPath(), str);
        }
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void begin(f fVar) {
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void end(f fVar) {
        try {
            f(fVar);
        } catch (Exception e) {
            i20.a("ProcedureStorage", e);
        }
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void event(f fVar, te0 te0) {
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void stage(f fVar, td2 td2) {
    }
}
