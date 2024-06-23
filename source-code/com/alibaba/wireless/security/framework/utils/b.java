package com.alibaba.wireless.security.framework.utils;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: Taobao */
public class b {
    private FileChannel a = null;
    private FileLock b = null;
    private RandomAccessFile c = null;
    private File d = null;
    private boolean e = true;
    private String f = null;

    public b(Context context, String str) {
        this.f = str;
        this.e = c();
    }

    private boolean c() {
        try {
            File file = new File(this.f);
            this.d = file;
            if (!file.exists()) {
                this.d.createNewFile();
            }
        } catch (Exception unused) {
            File file2 = this.d;
            if (file2 != null && !file2.exists()) {
                try {
                    this.d.createNewFile();
                } catch (Exception unused2) {
                }
            }
        }
        File file3 = this.d;
        return file3 != null && file3.exists();
    }

    public boolean a() {
        if (!this.e) {
            boolean c2 = c();
            this.e = c2;
            if (!c2) {
                return true;
            }
        }
        try {
            if (this.d != null) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.d, "rw");
                this.c = randomAccessFile;
                FileChannel channel = randomAccessFile.getChannel();
                this.a = channel;
                this.b = channel.lock();
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public boolean b() {
        boolean z = true;
        if (!this.e) {
            return true;
        }
        try {
            FileLock fileLock = this.b;
            if (fileLock != null) {
                fileLock.release();
                this.b = null;
            }
        } catch (IOException unused) {
            z = false;
        }
        try {
            FileChannel fileChannel = this.a;
            if (fileChannel != null) {
                fileChannel.close();
                this.a = null;
            }
        } catch (IOException unused2) {
            z = false;
        }
        try {
            RandomAccessFile randomAccessFile = this.c;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.c = null;
            }
            return z;
        } catch (IOException unused3) {
            return false;
        }
    }
}
