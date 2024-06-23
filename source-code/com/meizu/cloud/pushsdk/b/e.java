package com.meizu.cloud.pushsdk.b;

import android.util.Log;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import org.apache.commons.net.SocketClient;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class e {
    private final SimpleDateFormat a = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT);
    private final d b = new d("lo");
    private BufferedWriter c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Comparator<File> {
        a() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            int i = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
            if (i > 0) {
                return -1;
            }
            return i == 0 ? 0 : 1;
        }
    }

    public void a() throws IOException {
        BufferedWriter bufferedWriter = this.c;
        if (bufferedWriter != null) {
            bufferedWriter.flush();
            this.c.close();
            this.c = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(File file) {
        File[] listFiles = file.listFiles(new FileFilter() {
            /* class com.meizu.cloud.pushsdk.b.e.AnonymousClass1 */

            public boolean accept(File file) {
                return file.getName().endsWith(".log.txt");
            }
        });
        if (listFiles != null) {
            if (listFiles.length > 7) {
                Arrays.sort(listFiles, new a());
                for (int i = 7; i < listFiles.length; i++) {
                    listFiles[i].delete();
                }
            }
        }
    }

    public void a(String str) throws IOException {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            String format = this.a.format(new Date());
            File file2 = new File(str, format + ".log.txt");
            if (!file2.exists()) {
                if (!file2.createNewFile()) {
                    Log.e("EncryptionWriter", "create new file " + format + " failed !!!");
                } else {
                    a(file);
                }
            }
            this.c = new BufferedWriter(new FileWriter(file2, true));
            return;
        }
        throw new IOException("create " + str + " dir failed!!!");
    }

    public void a(String str, String str2, String str3) throws IOException {
        if (this.c != null) {
            this.c.write(this.b.a((str + str2 + " " + str3).getBytes()));
            this.c.write(SocketClient.NETASCII_EOL);
        }
    }
}
