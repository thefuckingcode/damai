package tb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: Taobao */
public class th0 {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC, Splitter:B:20:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004e A[SYNTHETIC, Splitter:B:32:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005a A[SYNTHETIC, Splitter:B:39:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    public static String a(File file) {
        String str;
        Throwable th;
        FileNotFoundException e;
        BufferedReader bufferedReader;
        IOException e2;
        BufferedReader bufferedReader2 = null;
        if (file != null) {
            try {
                if (file.exists()) {
                    StringBuilder sb = new StringBuilder();
                    bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                            }
                        } catch (IOException e4) {
                            e2 = e4;
                            try {
                                e2.printStackTrace();
                                if (bufferedReader != null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader2 = bufferedReader;
                                if (bufferedReader2 != null) {
                                }
                                throw th;
                            }
                        }
                    }
                    str = sb.toString();
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return str;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = null;
                e.printStackTrace();
                if (bufferedReader != null) {
                    return null;
                }
                bufferedReader.close();
                return null;
            } catch (IOException e7) {
                e2 = e7;
                bufferedReader = null;
                e2.printStackTrace();
                if (bufferedReader != null) {
                    return null;
                }
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException e8) {
                    e8.printStackTrace();
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                throw th;
            }
        }
        str = null;
        if (bufferedReader2 != null) {
        }
        return str;
    }
}
