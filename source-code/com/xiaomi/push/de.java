package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.bv;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
class de {
    private static String a = "/MiPushLog";

    /* renamed from: a  reason: collision with other field name */
    private int f193a;
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: a  reason: collision with other field name */
    private final SimpleDateFormat f194a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<File> f195a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private boolean f196a;
    private int b = 2097152;

    /* renamed from: b  reason: collision with other field name */
    private String f197b;
    private String c;

    de() {
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= read || !matcher.find(i)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.f197b.length() + start);
                if (this.f196a) {
                    if (substring.compareTo(this.c) > 0) {
                        read = start;
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.f197b) >= 0) {
                    this.f196a = true;
                    i2 = start;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f197b.length();
                }
                i = start + indexOf;
            }
            if (this.f196a) {
                int i3 = read - i2;
                this.f193a += i3;
                bufferedWriter.write(cArr, i2, i3);
                if (z || this.f193a > this.b) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    private void a(File file) {
        Throwable th;
        BufferedReader bufferedReader;
        String str;
        FileNotFoundException e;
        IOException e2;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                bufferedWriter.write("model :" + Build.getMODEL() + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + bv.m837a() + "; lng :" + Locale.getDefault().toString() + "; sdk :" + 48 + "; andver :" + Build.VERSION.SDK_INT + StringUtils.LF);
                this.f193a = 0;
                Iterator<File> it = this.f195a.iterator();
                while (it.hasNext()) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                    try {
                        a(bufferedReader, bufferedWriter, compile);
                        bufferedReader.close();
                        bufferedReader2 = bufferedReader;
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        bufferedReader2 = bufferedWriter;
                        str = "LOG: filter error = " + e.getMessage();
                        b.c(str);
                        ab.a(bufferedReader2);
                        ab.a(bufferedReader);
                    } catch (IOException e4) {
                        e2 = e4;
                        bufferedReader2 = bufferedWriter;
                        str = "LOG: filter error = " + e2.getMessage();
                        b.c(str);
                        ab.a(bufferedReader2);
                        ab.a(bufferedReader);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedWriter;
                        ab.a(bufferedReader2);
                        ab.a(bufferedReader);
                        throw th;
                    }
                }
                bufferedWriter.write(cv.a().c());
                ab.a(bufferedWriter);
                ab.a(bufferedReader2);
            } catch (FileNotFoundException e5) {
                e = e5;
                bufferedReader = null;
                bufferedReader2 = bufferedWriter;
                str = "LOG: filter error = " + e.getMessage();
                b.c(str);
                ab.a(bufferedReader2);
                ab.a(bufferedReader);
            } catch (IOException e6) {
                e2 = e6;
                bufferedReader = null;
                bufferedReader2 = bufferedWriter;
                str = "LOG: filter error = " + e2.getMessage();
                b.c(str);
                ab.a(bufferedReader2);
                ab.a(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                bufferedReader2 = bufferedWriter;
                ab.a(bufferedReader2);
                ab.a(bufferedReader);
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            bufferedReader = null;
            str = "LOG: filter error = " + e.getMessage();
            b.c(str);
            ab.a(bufferedReader2);
            ab.a(bufferedReader);
        } catch (IOException e8) {
            e2 = e8;
            bufferedReader = null;
            str = "LOG: filter error = " + e2.getMessage();
            b.c(str);
            ab.a(bufferedReader2);
            ab.a(bufferedReader);
        } catch (Throwable th4) {
            th = th4;
            ab.a(bufferedReader2);
            ab.a(bufferedReader);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public de m349a(File file) {
        if (file.exists()) {
            this.f195a.add(file);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public de a(Date date, Date date2) {
        String str;
        if (date.after(date2)) {
            this.f197b = this.f194a.format(date2);
            str = this.f194a.format(date);
        } else {
            this.f197b = this.f194a.format(date);
            str = this.f194a.format(date2);
        }
        this.c = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public File a(Context context, Date date, Date date2, File file) {
        File file2;
        File file3;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file3 = new File(context.getExternalFilesDir(null), bk.N);
            if (!file3.exists()) {
                file3 = new File(context.getFilesDir(), bk.N);
            }
            if (!file3.exists()) {
                file3 = context.getFilesDir();
            }
            m349a(new File(file3, "xmsf.log.1"));
            file2 = new File(file3, "xmsf.log");
        } else {
            file3 = new File(context.getExternalFilesDir(null) + a);
            m349a(new File(file3, "log0.txt"));
            file2 = new File(file3, "log1.txt");
        }
        m349a(file2);
        if (!file3.isDirectory()) {
            return null;
        }
        File file4 = new File(file, date.getTime() + "-" + date2.getTime() + ".zip");
        if (file4.exists()) {
            return null;
        }
        a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file5 = new File(file, "log.txt");
        a(file5);
        b.c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file5.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            ab.a(file4, file5);
            b.c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file5.delete();
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        if (i != 0) {
            this.b = i;
        }
    }
}
