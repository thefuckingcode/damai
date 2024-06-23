package com.ali.alihadeviceevaluator.old;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import tb.i4;
import tb.rs0;
import tb.uk1;

/* compiled from: Taobao */
public class HardWareInfo {
    public int a = i4.d().c().b;
    public int b = i4.d().c().c;
    public float c = i4.d().c().a;
    public String d;
    public String e;
    public int f = 0;
    public float g;
    public String h;
    public String i;
    public long j;
    public float k;
    public float[] l;
    public String m;
    String n;
    boolean o;
    private uk1 p = new uk1();

    /* compiled from: Taobao */
    class OnlineGLSurfaceView extends GLSurfaceView {
        a mRenderer;

        public OnlineGLSurfaceView(Context context) {
            super(context);
            setEGLConfigChooser(8, 8, 8, 8, 0, 0);
            HardWareInfo.this.getClass();
            a aVar = new a();
            this.mRenderer = aVar;
            setRenderer(aVar);
        }
    }

    /* compiled from: Taobao */
    class a implements GLSurfaceView.Renderer {
        a() {
        }

        public void onDrawFrame(GL10 gl10) {
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                HardWareInfo.this.h = gl10.glGetString(7937);
                HardWareInfo.this.i = gl10.glGetString(7936);
                HardWareInfo.this.b();
                try {
                    HardWareInfo hardWareInfo = HardWareInfo.this;
                    hardWareInfo.j = hardWareInfo.f();
                } catch (Throwable unused) {
                }
                HardWareInfo.this.p.a(HardWareInfo.this);
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d6, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d7, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x017a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x017b, code lost:
        r2 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x017a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0198 A[SYNTHETIC, Splitter:B:63:0x0198] */
    public HardWareInfo(Context context) {
        Exception e2;
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            this.n = filesDir.getAbsolutePath() + "/deviceInfo";
        } else {
            this.n = "";
        }
        File file = new File(this.n);
        if (file.exists()) {
            this.o = true;
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                try {
                    this.d = bufferedReader2.readLine();
                    this.e = bufferedReader2.readLine();
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        this.f = Integer.parseInt(readLine);
                    }
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        this.g = Float.parseFloat(readLine2);
                    }
                    String readLine3 = bufferedReader2.readLine();
                    if (readLine3 != null) {
                        float parseFloat = Float.parseFloat(readLine3);
                        this.k = parseFloat;
                        if (parseFloat <= 0.0f) {
                            this.k = this.g;
                        }
                    }
                    String readLine4 = bufferedReader2.readLine();
                    if (this.l == null) {
                        this.l = new float[d()];
                    }
                    if (readLine4 != null) {
                        String[] split = readLine4.split(",");
                        if (split != null && split.length > 0) {
                            for (int i2 = 0; i2 < split.length; i2++) {
                                this.l[i2] = Float.parseFloat(split[i2]);
                            }
                        }
                    }
                    this.h = bufferedReader2.readLine();
                    this.i = bufferedReader2.readLine();
                    String readLine5 = bufferedReader2.readLine();
                    if (readLine5 != null) {
                        this.j = Long.parseLong(readLine5);
                    }
                    try {
                        String readLine6 = bufferedReader2.readLine();
                        if (!TextUtils.isEmpty(readLine6)) {
                            this.m = readLine6;
                        } else {
                            this.m = c();
                        }
                    } catch (Throwable unused) {
                    }
                    Log.d(rs0.TAG, "load local file succ: cpuBrand=" + this.d + ", cpuName=" + this.e + ",cpuCount=" + this.f + ",maxFreq=" + this.g + ",minFreq=" + this.k + ",freqCount" + this.l.length + ",GpuName" + this.h + ",GpuBrand=" + this.i + ",GpuFreq=" + this.j + ",CpuArch=" + this.m);
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    bufferedReader = bufferedReader2;
                    try {
                        Log.e(rs0.TAG, "load local file failed!!");
                        e2.printStackTrace();
                        if (bufferedReader != null) {
                        }
                        d();
                        e();
                        h();
                        c();
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                }
            } catch (Exception e6) {
                e2 = e6;
                Log.e(rs0.TAG, "load local file failed!!");
                e2.printStackTrace();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                d();
                e();
                h();
                c();
            }
        }
        d();
        e();
        h();
        c();
    }

    /* access modifiers changed from: package-private */
    public void b() {
    }

    public String c() {
        String str;
        int i2;
        String str2 = "UnKnown";
        if (!TextUtils.isEmpty(this.m)) {
            return this.m;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            String readLine = bufferedReader.readLine();
            while (true) {
                if (readLine == null) {
                    str = str2;
                    break;
                } else if (readLine.contains("AArch") || readLine.contains("ARM") || readLine.contains("Intel(R)") || readLine.contains("model name")) {
                    int indexOf = readLine.indexOf(": ");
                    if (indexOf >= 0) {
                        readLine = readLine.substring(indexOf + 2);
                        if (!readLine.contains("Intel(R)")) {
                            i2 = readLine.indexOf(32);
                        } else {
                            i2 = readLine.lastIndexOf(41) + 1;
                        }
                        if (i2 > 0) {
                            str = readLine.substring(0, i2);
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    readLine = bufferedReader.readLine();
                }
            }
            bufferedReader.close();
            str2 = str;
        } catch (Exception unused) {
        }
        this.m = str2;
        return str2;
    }

    public int d() {
        if (this.f == 0) {
            this.f = Runtime.getRuntime().availableProcessors();
        }
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        String str;
        String upperCase = Build.HARDWARE.toUpperCase();
        if (TextUtils.isEmpty(upperCase)) {
            return;
        }
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.d)) {
            if (upperCase.contains("EXYNOS")) {
                str = upperCase.replace("samsung", "");
            } else {
                str = null;
                try {
                    Method declaredMethod = Class.forName("android.os.Build").getDeclaredMethod("getString", String.class);
                    declaredMethod.setAccessible(true);
                    String str2 = (String) declaredMethod.invoke(Build.class, "ro.board.platform");
                    if (str2 != null) {
                        try {
                            if (str2.equals("mtk")) {
                                str2 = upperCase;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    str = str2;
                } catch (Exception unused2) {
                }
                if (upperCase.length() >= 4 && (TextUtils.isEmpty(str) || str.equals("unknown") || str.contains("samsungexynos") || str.contains("mrvl"))) {
                    str = upperCase;
                }
            }
            if (str != null) {
                str = str.toUpperCase();
            }
            if (str != null) {
                if (str.contains("EXYNOS") || str.contains("SMDK") || str.contains("UNIVERSAL")) {
                    this.d = "三星";
                } else if (str.contains("MSM") || str.contains("APQ") || str.contains("QSD") || str.contains("SDM")) {
                    this.d = "高通";
                } else if (str.contains("REDHOOKBAY") || str.contains("MOOREFIELD") || str.contains("MERRIFIELD")) {
                    this.d = "英特尔";
                } else if (str.contains("MT")) {
                    this.d = "联发科";
                } else if (str.contains("OMAP")) {
                    this.d = "德州仪器";
                } else if (str.contains("PXA")) {
                    this.d = "Marvell";
                } else if (str.contains("HI") || str.contains("K3")) {
                    this.d = "华为海思";
                } else if (str.contains("SP") || str.contains(com.alibaba.security.realidentity.a.a.X)) {
                    this.d = "展讯";
                } else if (str.contains("TEGRA") || str.contains("NVIDIA")) {
                    this.d = "NVIDIA";
                } else if (str.startsWith("LC")) {
                    this.d = "联芯科技";
                } else {
                    this.d = upperCase;
                }
                this.e = str;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public long f() {
        long j2;
        try {
            File file = new File("/sys/devices/platform/gpusysfs/gpu_max_clock");
            if (!file.exists()) {
                file = new File("/sys/devices/platform/gpusysfs/max_freq");
            }
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                String readLine = new BufferedReader(fileReader).readLine();
                if (readLine != null) {
                    j2 = Long.parseLong(readLine);
                    if (j2 > 0) {
                        try {
                            j2 = (j2 / 1000) / 1000;
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    j2 = 0;
                }
                fileReader.close();
                if (j2 > 0) {
                    return j2;
                }
            } else {
                j2 = 0;
            }
            File file2 = new File("/sys/class/devfreq/");
            if (file2.exists() && file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles == null) {
                    return 0;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= listFiles.length) {
                        break;
                    } else if (listFiles[i2].getName().contains("kgsl")) {
                        File file3 = new File(listFiles[i2].getAbsolutePath() + "/max_freq");
                        if (!file3.exists()) {
                            file3 = new File(listFiles[i2].getAbsolutePath() + "/max_gpuclk");
                        }
                        if (file3.exists()) {
                            FileReader fileReader2 = new FileReader(file3);
                            String readLine2 = new BufferedReader(fileReader2).readLine();
                            if (readLine2 != null) {
                                j2 = Long.parseLong(readLine2);
                                if (j2 > 0) {
                                    j2 = (j2 / 1000) / 1000;
                                }
                            }
                            fileReader2.close();
                        }
                    } else {
                        i2++;
                    }
                }
            }
        } catch (Exception unused2) {
            j2 = 0;
        }
        return j2 == 0 ? g("/sys/devices/") : j2;
    }

    /* access modifiers changed from: package-private */
    public long g(String str) {
        long j2;
        long j3 = 0;
        try {
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                j2 = 0;
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return 0;
                }
                j2 = 0;
                for (File file2 : listFiles) {
                    try {
                        if (file2 != null && file2.getName().contains("kgsl") && file2.isDirectory()) {
                            j2 = g(file2.getAbsolutePath());
                            if (j2 > 0) {
                                return j2;
                            }
                        }
                    } catch (Exception unused) {
                        j3 = j2;
                    }
                }
            }
            File file3 = new File(str + "/max_freq");
            if (!file3.exists()) {
                file3 = new File(str + "/max_gpuclk");
            }
            if (!file3.exists()) {
                return j2;
            }
            FileReader fileReader = new FileReader(file3);
            String readLine = new BufferedReader(fileReader).readLine();
            if (readLine != null) {
                long parseLong = Long.parseLong(readLine);
                if (parseLong > 0) {
                    try {
                        j2 = (parseLong / 1000) / 1000;
                    } catch (Exception unused2) {
                        j3 = parseLong;
                    }
                } else {
                    j3 = parseLong;
                    fileReader.close();
                    return j3;
                }
            }
            j3 = j2;
            fileReader.close();
            return j3;
        } catch (Exception unused3) {
        }
    }

    public float h() {
        float f2 = this.g;
        if (f2 > 0.0f && this.l != null) {
            return f2;
        }
        if (this.l == null) {
            this.l = new float[d()];
        }
        for (int i2 = 0; i2 < d(); i2++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    FileReader fileReader = new FileReader(file);
                    String readLine = new BufferedReader(fileReader).readLine();
                    fileReader.close();
                    if (readLine != null) {
                        float parseLong = ((float) Long.parseLong(readLine)) / 1000000.0f;
                        this.l[i2] = parseLong;
                        if (this.g < parseLong) {
                            this.g = parseLong;
                        }
                        float f3 = this.k;
                        if (f3 == 0.0f) {
                            this.k = parseLong;
                        } else if (f3 > parseLong) {
                            this.k = parseLong;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (this.k == 0.0f) {
            this.k = this.g;
        }
        if (this.o) {
            this.o = false;
            i();
        }
        return this.g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d9 A[SYNTHETIC, Splitter:B:38:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    public void i() {
        Throwable th;
        Exception e2;
        if (!this.o && this.h != null) {
            this.o = true;
            File file = new File(this.n);
            if (file.exists()) {
                file.delete();
            }
            BufferedWriter bufferedWriter = null;
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                try {
                    bufferedWriter2.write(this.d);
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(this.e);
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(String.valueOf(this.f));
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(String.valueOf(this.g));
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(String.valueOf(this.k));
                    bufferedWriter2.newLine();
                    StringBuilder sb = new StringBuilder(50);
                    float[] fArr = this.l;
                    if (fArr != null && fArr.length > 0) {
                        int i2 = 0;
                        while (true) {
                            float[] fArr2 = this.l;
                            if (i2 >= fArr2.length) {
                                break;
                            }
                            sb.append(fArr2[i2]);
                            if (i2 < this.l.length - 1) {
                                sb.append(',');
                            }
                            i2++;
                        }
                    }
                    bufferedWriter2.write(sb.toString());
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(this.h);
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(this.i);
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(String.valueOf(this.j));
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(String.valueOf(this.m));
                    bufferedWriter2.newLine();
                    try {
                        bufferedWriter2.flush();
                        bufferedWriter2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    bufferedWriter = bufferedWriter2;
                    try {
                        e2.printStackTrace();
                        this.o = false;
                        if (bufferedWriter == null) {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.flush();
                                bufferedWriter.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e2 = e6;
                e2.printStackTrace();
                this.o = false;
                if (bufferedWriter == null) {
                }
            }
        }
    }
}
