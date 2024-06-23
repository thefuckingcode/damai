package tb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: Taobao */
public class g4 {
    public int a;
    public float b = 0.0f;
    public float c = Float.MAX_VALUE;
    public float d;
    public int e = -1;
    private float[] f = {1.9f, 1.8f, 1.7f, 1.5f, 1.4f, 1.2f, 1.0f, 0.9f, 0.8f};
    private float[] g = {2.4f, 2.2f, 2.0f, 1.8f, 1.5f, 1.3f, 1.2f, 1.0f, 0.9f};

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.io.FileReader */
    /* JADX DEBUG: Multi-variable search result rejected for r6v1, resolved type: java.io.FileReader */
    /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: java.io.FileReader */
    /* JADX DEBUG: Multi-variable search result rejected for r6v9, resolved type: java.io.FileReader */
    /* JADX DEBUG: Multi-variable search result rejected for r6v10, resolved type: java.io.FileReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009b A[SYNTHETIC, Splitter:B:49:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a5 A[SYNTHETIC, Splitter:B:54:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    private void b() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        int i;
        BufferedReader bufferedReader2;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.a = availableProcessors;
        if (availableProcessors > 0) {
            BufferedReader bufferedReader3 = null;
            try {
                float[] fArr = new float[availableProcessors];
                float f2 = 0.0f;
                int i2 = 0;
                BufferedReader bufferedReader4 = bufferedReader3;
                while (true) {
                    try {
                        i = this.a;
                        if (i2 >= i) {
                            break;
                        }
                        File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                        if (file.exists()) {
                            FileReader fileReader2 = new FileReader(file);
                            try {
                                bufferedReader2 = new BufferedReader(fileReader2);
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = fileReader2;
                                bufferedReader3 = bufferedReader4;
                                fileReader = bufferedReader;
                                try {
                                    th.printStackTrace();
                                } finally {
                                    if (bufferedReader3 != null) {
                                        try {
                                            bufferedReader3.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (fileReader != 0) {
                                        try {
                                            fileReader.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                }
                            }
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    float parseLong = ((float) Long.parseLong(readLine)) / 1000000.0f;
                                    fArr[i2] = parseLong;
                                    if (this.b < parseLong) {
                                        this.b = parseLong;
                                    }
                                    if (this.d > parseLong) {
                                        this.d = parseLong;
                                    }
                                    f2 += parseLong;
                                }
                                try {
                                    fileReader2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                bufferedReader4 = bufferedReader2;
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedReader3 = bufferedReader2;
                                fileReader = fileReader2;
                                th.printStackTrace();
                            }
                        }
                        i2++;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = bufferedReader3;
                        bufferedReader3 = bufferedReader4;
                        fileReader = bufferedReader;
                        th.printStackTrace();
                        if (fileReader == 0) {
                            try {
                                return;
                            } catch (IOException e5) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                this.c = (float) (Math.round((f2 * 100.0f) / ((float) i)) / 100);
                if (bufferedReader4 != null) {
                    try {
                        bufferedReader4.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                fileReader = bufferedReader3;
                th.printStackTrace();
            }
        }
    }

    @Deprecated
    public void a() {
        float[] fArr;
        b();
        int i = 8;
        if (this.a >= 8) {
            fArr = this.f;
        } else {
            fArr = this.g;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= fArr.length) {
                i2 = 9;
                break;
            } else if (this.b >= fArr[i2]) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = 10 - i2;
        int i4 = this.a;
        if (i4 >= 16) {
            i = 10;
        } else if (i4 >= 8) {
            i = 9;
        } else if (i4 < 6) {
            i = i4 >= 4 ? 6 : i4 >= 2 ? 4 : 0;
        }
        this.e = (int) ((((float) i3) * 0.6f) + (((float) i) * 0.4f));
    }
}
