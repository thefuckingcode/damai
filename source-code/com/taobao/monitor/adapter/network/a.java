package com.taobao.monitor.adapter.network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.qs0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a implements ILiteDb {
    private final File a = new File(qs0.e().a().getCacheDir() + "/" + "apm_db.db");

    private void a() throws Exception {
        if (!this.a.exists()) {
            this.a.createNewFile();
        } else if (this.a.isDirectory()) {
            this.a.delete();
            this.a.createNewFile();
        }
    }

    @Override // com.taobao.monitor.adapter.network.ILiteDb
    public void delete() {
        if (this.a.exists()) {
            this.a.delete();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    @Override // com.taobao.monitor.adapter.network.ILiteDb
    public void insert(String str) {
        Throwable th;
        try {
            a();
            if (this.a.length() < 4194304) {
                FileWriter fileWriter = null;
                try {
                    FileWriter fileWriter2 = new FileWriter(this.a, true);
                    try {
                        fileWriter2.append((CharSequence) str).append((CharSequence) StringUtils.LF);
                        fileWriter2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileWriter != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    @Override // com.taobao.monitor.adapter.network.ILiteDb
    public List<String> select() {
        Throwable th;
        BufferedReader bufferedReader;
        try {
            a();
            if (this.a.length() > 0) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(this.a));
                    try {
                        ArrayList arrayList = new ArrayList();
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            arrayList.add(readLine);
                        }
                        bufferedReader.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
