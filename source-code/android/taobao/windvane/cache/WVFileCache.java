package android.taobao.windvane.cache;

import android.os.Process;
import android.taobao.windvane.file.FileAccesser;
import android.taobao.windvane.file.NotEnoughSpace;
import android.taobao.windvane.util.TaoLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class WVFileCache {
    public static final int CREATE = 4;
    public static final int DELETE = 3;
    private static final String FILE_INFO = "wv_web_info.dat";
    public static final int READ = 1;
    private static String TAG = "WVFileCache";
    public static final int WRITE = 2;
    private String baseDirPath;
    private FileChannel fInfoChannel;
    private RandomAccessFile fInfoOs;
    private String infoDirPath;
    private boolean isInit;
    private boolean isNoSpaceClear = true;
    private int maxCapacity = 100;
    private boolean sdcard;
    private Map<String, WVFileInfo> storedFile = Collections.synchronizedMap(new FixedSizeLinkedHashMap());

    /* compiled from: Taobao */
    protected class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private static final long serialVersionUID = 1;

        protected FixedSizeLinkedHashMap() {
        }

        /* access modifiers changed from: protected */
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            if (size() <= WVFileCache.this.maxCapacity) {
                return false;
            }
            if (TaoLog.getLogStatus()) {
                String str = WVFileCache.TAG;
                TaoLog.d(str, "removeEldestEntry, size:" + size() + " " + ((Object) entry.getKey()));
            }
            V value = entry.getValue();
            if (!(value instanceof WVFileInfo)) {
                return true;
            }
            V v = value;
            if (!FileAccesser.deleteFile(new File(WVFileCache.this.baseDirPath, v.fileName))) {
                return true;
            }
            WVFileInfoParser.updateFileInfo(3, v, WVFileCache.this.fInfoChannel);
            return true;
        }
    }

    public WVFileCache(String str, String str2, int i, boolean z) {
        this.baseDirPath = str;
        this.infoDirPath = str2;
        this.maxCapacity = i;
        this.sdcard = z;
        this.isInit = false;
    }

    private boolean collectFiles() {
        byte[] bArr;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ByteBuffer allocate = ByteBuffer.allocate((int) this.fInfoChannel.size());
            this.fInfoChannel.read(allocate);
            bArr = allocate.array();
        } catch (IOException e) {
            String str = TAG;
            TaoLog.e(str, "collectFiles fInfoChannel.read error:" + e.getMessage());
            bArr = null;
        }
        if (TaoLog.getLogStatus()) {
            String str2 = TAG;
            TaoLog.d(str2, "collectFiles read fileinfo:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (bArr == null) {
            return false;
        }
        TaoLog.d("collectFiles", "read fileinfo success");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 60;
        boolean z = false;
        int i2 = 0;
        while (i < bArr.length) {
            if (bArr[i] == 10) {
                int i3 = i - i2;
                WVFileInfo fileInfo = WVFileInfoParser.getFileInfo(bArr, i2, i3);
                if (fileInfo != null) {
                    String str3 = fileInfo.fileName;
                    if (!this.storedFile.containsKey(str3)) {
                        fileInfo.pos = (long) byteArrayOutputStream.size();
                        this.storedFile.put(str3, fileInfo);
                        byteArrayOutputStream.write(bArr, i2, i3 + 1);
                        i2 = i + 1;
                        i += 60;
                    }
                }
                z = true;
                i2 = i + 1;
                i += 60;
            }
            i++;
        }
        if (TaoLog.getLogStatus()) {
            String str4 = TAG;
            TaoLog.d(str4, "parse fileinfo:" + (System.currentTimeMillis() - currentTimeMillis2));
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        if (z) {
            try {
                this.fInfoChannel.truncate(0L);
                this.fInfoChannel.position(0L);
                ByteBuffer wrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                wrap.position(0);
                this.fInfoChannel.write(wrap);
            } catch (IOException e2) {
                String str5 = TAG;
                TaoLog.e(str5, "collectFiles fInfoChannel.write error:" + e2.getMessage());
            }
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        if (TaoLog.getLogStatus()) {
            String str6 = TAG;
            TaoLog.d(str6, "write fileinfo:" + (System.currentTimeMillis() - currentTimeMillis3));
        }
        return true;
    }

    private void onFileOverflow() {
        TaoLog.d(TAG, "onFileOverflow");
        ArrayList arrayList = new ArrayList();
        Set<Map.Entry<String, WVFileInfo>> entrySet = this.storedFile.entrySet();
        int size = this.storedFile.size();
        for (Map.Entry<String, WVFileInfo> entry : entrySet) {
            if (size < this.maxCapacity) {
                break;
            }
            WVFileInfo value = entry.getValue();
            if (value != null) {
                arrayList.add(value);
            }
            size--;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            delete(((WVFileInfo) it.next()).fileName);
        }
    }

    private void setCapacity(int i) {
        if (this.storedFile.size() > i) {
            onFileOverflow();
        }
    }

    public boolean clear() {
        String[] list;
        if (!this.isInit || (list = new File(this.baseDirPath).list()) == null) {
            return false;
        }
        boolean z = true;
        for (String str : list) {
            z &= delete(str);
        }
        return z;
    }

    public boolean delete(String str) {
        WVFileInfo wVFileInfo;
        boolean z = false;
        if (this.isInit && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(this.baseDirPath, str);
            if (file.isFile()) {
                z = file.delete();
            }
            if ((z || !file.exists()) && (wVFileInfo = this.storedFile.get(str)) != null) {
                TaoLog.d(TAG, "delete success");
                WVFileInfoParser.updateFileInfo(3, wVFileInfo, this.fInfoChannel);
                this.storedFile.remove(str);
                if (!TaoLog.getLogStatus()) {
                    return true;
                }
                String str2 = TAG;
                TaoLog.d(str2, "delete time cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return true;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        RandomAccessFile randomAccessFile = this.fInfoOs;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        FileChannel fileChannel = this.fInfoChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        super.finalize();
    }

    public String getDirPath() {
        return this.baseDirPath;
    }

    public WVFileInfo getFileInfo(String str) {
        WVFileInfo wVFileInfo;
        if (!this.isInit || (wVFileInfo = this.storedFile.get(str)) == null) {
            return null;
        }
        if (new File(this.baseDirPath, str).exists()) {
            return wVFileInfo;
        }
        WVFileInfoParser.updateFileInfo(3, wVFileInfo, this.fInfoChannel);
        return null;
    }

    public synchronized boolean init() {
        if (!this.isInit) {
            File file = new File(this.infoDirPath, FILE_INFO);
            if (!file.exists()) {
                new File(this.infoDirPath).mkdirs();
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    String str = TAG;
                    TaoLog.e(str, "init createNewFile:" + e.getMessage());
                    return false;
                }
            }
            new File(this.baseDirPath).mkdirs();
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file.getAbsolutePath(), "rw");
                this.fInfoOs = randomAccessFile;
                if (this.fInfoChannel == null) {
                    this.fInfoChannel = randomAccessFile.getChannel();
                }
                if (TaoLog.getLogStatus()) {
                    String str2 = TAG;
                    TaoLog.d(str2, "lock success process is " + Process.myPid());
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (!collectFiles()) {
                    return false;
                }
                if (TaoLog.getLogStatus()) {
                    String str3 = TAG;
                    TaoLog.d(str3, "init time cost:" + (System.currentTimeMillis() - currentTimeMillis));
                }
                this.isInit = true;
                setCapacity(this.maxCapacity);
                if (this.storedFile.size() == 0) {
                    clear();
                }
            } catch (Exception e2) {
                String str4 = TAG;
                TaoLog.e(str4, "init fInfoOs RandomAccessFile:" + e2.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean isSdcard() {
        return this.sdcard;
    }

    public byte[] read(String str) {
        if (TaoLog.getLogStatus()) {
            String str2 = TAG;
            TaoLog.d(str2, "read:" + str);
        }
        if (!this.isInit) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        WVFileInfo wVFileInfo = this.storedFile.get(str);
        if (wVFileInfo == null) {
            return null;
        }
        this.storedFile.remove(str);
        this.storedFile.put(str, WVFileInfoParser.updateFileInfo(1, wVFileInfo, this.fInfoChannel));
        byte[] read = FileAccesser.read(new File(this.baseDirPath, str));
        if (TaoLog.getLogStatus()) {
            String str3 = TAG;
            TaoLog.d(str3, "read time cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return read;
    }

    public int size() {
        if (this.isInit) {
            return this.storedFile.size();
        }
        return 0;
    }

    public void updateFileInfo(WVFileInfo wVFileInfo) {
        String str;
        WVFileInfo wVFileInfo2;
        if (this.isInit && wVFileInfo != null && (str = wVFileInfo.fileName) != null && (wVFileInfo2 = this.storedFile.get(str)) != null) {
            TaoLog.d(TAG, "update info success");
            wVFileInfo.pos = wVFileInfo2.pos;
            this.storedFile.put(str, WVFileInfoParser.updateFileInfo(2, wVFileInfo, this.fInfoChannel));
        }
    }

    public boolean write(WVFileInfo wVFileInfo, ByteBuffer byteBuffer) {
        String str;
        boolean z;
        if (!(wVFileInfo == null || (str = wVFileInfo.fileName) == null)) {
            if (TaoLog.getLogStatus()) {
                String str2 = TAG;
                TaoLog.d(str2, "write:" + str);
            }
            if (this.isInit) {
                File file = new File(this.baseDirPath, str);
                try {
                    z = FileAccesser.write(file, byteBuffer);
                } catch (NotEnoughSpace e) {
                    String str3 = TAG;
                    TaoLog.e(str3, "write error. fileName=" + str + ". NotEnoughSpace: " + e.getMessage());
                    if (this.isNoSpaceClear) {
                        clear();
                        try {
                            z = FileAccesser.write(file, byteBuffer);
                        } catch (NotEnoughSpace e2) {
                            e2.printStackTrace();
                        }
                    }
                    z = false;
                }
                if (z) {
                    WVFileInfo wVFileInfo2 = this.storedFile.get(str);
                    if (wVFileInfo2 != null) {
                        TaoLog.d(TAG, "writed success, file exist");
                        wVFileInfo.pos = wVFileInfo2.pos;
                        this.storedFile.put(str, WVFileInfoParser.updateFileInfo(2, wVFileInfo, this.fInfoChannel).convertToFileInfo());
                        return true;
                    }
                    TaoLog.d(TAG, "writed success, file do not exist");
                    this.storedFile.put(str, WVFileInfoParser.updateFileInfo(4, wVFileInfo, this.fInfoChannel).convertToFileInfo());
                    return true;
                }
            }
        }
        return false;
    }
}
