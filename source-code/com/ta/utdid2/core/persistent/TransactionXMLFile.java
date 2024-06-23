package com.ta.utdid2.core.persistent;

import com.ta.utdid2.core.persistent.MySharedPreferences;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: Taobao */
public class TransactionXMLFile {
    private static final Object GLOBAL_COMMIT_LOCK = new Object();
    public static final int MODE_PRIVATE = 0;
    private File mPreferencesDir;
    private final Object mSync = new Object();
    private HashMap<File, MySharedPreferencesImpl> sSharedPrefs = new HashMap<>();

    /* compiled from: Taobao */
    private static final class MySharedPreferencesImpl implements MySharedPreferences {
        private static final Object mContent = new Object();
        private boolean hasChange = false;
        private final File mBackupFile;
        private final File mFile;
        private WeakHashMap<MySharedPreferences.OnSharedPreferenceChangeListener, Object> mListeners;
        private Map mMap;
        private final int mMode;

        /* compiled from: Taobao */
        public final class EditorImpl implements MySharedPreferences.MyEditor {
            private boolean mClear = false;
            private final Map<String, Object> mModified = new HashMap();

            public EditorImpl() {
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor clear() {
                synchronized (this) {
                    this.mClear = true;
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public boolean commit() {
                boolean z;
                ArrayList arrayList;
                HashSet<MySharedPreferences.OnSharedPreferenceChangeListener> hashSet;
                boolean writeFileLocked;
                synchronized (TransactionXMLFile.GLOBAL_COMMIT_LOCK) {
                    z = MySharedPreferencesImpl.this.mListeners.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(MySharedPreferencesImpl.this.mListeners.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.mClear) {
                            MySharedPreferencesImpl.this.mMap.clear();
                            this.mClear = false;
                        }
                        for (Map.Entry<String, Object> entry : this.mModified.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                MySharedPreferencesImpl.this.mMap.remove(key);
                            } else {
                                MySharedPreferencesImpl.this.mMap.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.mModified.clear();
                    }
                    writeFileLocked = MySharedPreferencesImpl.this.writeFileLocked();
                    if (writeFileLocked) {
                        MySharedPreferencesImpl.this.setHasChange(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (MySharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : hashSet) {
                            if (onSharedPreferenceChangeListener != null) {
                                onSharedPreferenceChangeListener.onSharedPreferenceChanged(MySharedPreferencesImpl.this, str);
                            }
                        }
                    }
                }
                return writeFileLocked;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor putBoolean(String str, boolean z) {
                synchronized (this) {
                    this.mModified.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor putFloat(String str, float f) {
                synchronized (this) {
                    this.mModified.put(str, Float.valueOf(f));
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor putInt(String str, int i) {
                synchronized (this) {
                    this.mModified.put(str, Integer.valueOf(i));
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor putLong(String str, long j) {
                synchronized (this) {
                    this.mModified.put(str, Long.valueOf(j));
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor putString(String str, String str2) {
                synchronized (this) {
                    this.mModified.put(str, str2);
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor remove(String str) {
                synchronized (this) {
                    this.mModified.put(str, this);
                }
                return this;
            }
        }

        MySharedPreferencesImpl(File file, int i, Map map) {
            this.mFile = file;
            this.mBackupFile = TransactionXMLFile.makeBackupFile(file);
            this.mMode = i;
            this.mMap = map == null ? new HashMap() : map;
            this.mListeners = new WeakHashMap<>();
        }

        private FileOutputStream createFileOutputStream(File file) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
            return fileOutputStream;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean writeFileLocked() {
            if (this.mFile.exists()) {
                if (this.mBackupFile.exists()) {
                    this.mFile.delete();
                } else if (!this.mFile.renameTo(this.mBackupFile)) {
                    return false;
                }
            }
            try {
                FileOutputStream createFileOutputStream = createFileOutputStream(this.mFile);
                if (createFileOutputStream == null) {
                    return false;
                }
                XmlUtils.writeMapXml(this.mMap, createFileOutputStream);
                createFileOutputStream.close();
                this.mBackupFile.delete();
                return true;
            } catch (Exception unused) {
                if (this.mFile.exists()) {
                    this.mFile.delete();
                }
                return false;
            }
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public boolean checkFile() {
            return this.mFile != null && new File(this.mFile.getAbsolutePath()).exists();
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public boolean contains(String str) {
            boolean containsKey;
            synchronized (this) {
                containsKey = this.mMap.containsKey(str);
            }
            return containsKey;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public MySharedPreferences.MyEditor edit() {
            return new EditorImpl();
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public Map<String, ?> getAll() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.mMap);
            }
            return hashMap;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public boolean getBoolean(String str, boolean z) {
            synchronized (this) {
                Boolean bool = (Boolean) this.mMap.get(str);
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            return z;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public float getFloat(String str, float f) {
            synchronized (this) {
                Float f2 = (Float) this.mMap.get(str);
                if (f2 != null) {
                    f = f2.floatValue();
                }
            }
            return f;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public int getInt(String str, int i) {
            synchronized (this) {
                Integer num = (Integer) this.mMap.get(str);
                if (num != null) {
                    i = num.intValue();
                }
            }
            return i;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public long getLong(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.mMap.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public String getString(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.mMap.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }

        public boolean hasFileChanged() {
            boolean z;
            synchronized (this) {
                z = this.hasChange;
            }
            return z;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public void registerOnSharedPreferenceChangeListener(MySharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            synchronized (this) {
                this.mListeners.put(onSharedPreferenceChangeListener, mContent);
            }
        }

        public void replace(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.mMap = map;
                }
            }
        }

        public void setHasChange(boolean z) {
            synchronized (this) {
                this.hasChange = z;
            }
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public void unregisterOnSharedPreferenceChangeListener(MySharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            synchronized (this) {
                this.mListeners.remove(onSharedPreferenceChangeListener);
            }
        }
    }

    public TransactionXMLFile(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.mPreferencesDir = new File(str);
    }

    private File getPreferencesDir() {
        File file;
        synchronized (this.mSync) {
            file = this.mPreferencesDir;
        }
        return file;
    }

    private File getSharedPrefsFile(String str) {
        File preferencesDir = getPreferencesDir();
        return makeFilename(preferencesDir, str + ".xml");
    }

    /* access modifiers changed from: private */
    public static File makeBackupFile(File file) {
        return new File(file.getPath() + ".bak");
    }

    private File makeFilename(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:46|47|(2:52|53)|54|55) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r0 = makeBackupFile(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r0.exists() == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r6.delete();
        r0.renameTo(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r6.exists() == false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (r6.canRead() == false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0 = new java.io.FileInputStream(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r2 = com.ta.utdid2.core.persistent.XmlUtils.readMapXml(r0);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        r2 = r0;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        r2 = r0;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0055, code lost:
        if (r2 != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x005a, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005c, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r3 = new java.io.FileInputStream(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r3.read(new byte[r3.available()]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0071, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0072, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0074, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0076, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0077, code lost:
        if (r2 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x007d, code lost:
        if (r2 != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0082, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0084, code lost:
        if (r2 != null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0089, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x008a, code lost:
        if (r3 != null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x008c, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0092, code lost:
        monitor-enter(com.ta.utdid2.core.persistent.TransactionXMLFile.GLOBAL_COMMIT_LOCK);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0093, code lost:
        if (r1 != null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r1.replace(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0099, code lost:
        r1 = r5.sSharedPrefs.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00a2, code lost:
        if (r1 == null) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00a4, code lost:
        r1 = new com.ta.utdid2.core.persistent.TransactionXMLFile.MySharedPreferencesImpl(r6, r7, r2);
        r5.sSharedPrefs.put(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00af, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x007c */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057 A[SYNTHETIC, Splitter:B:33:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0079 A[SYNTHETIC, Splitter:B:52:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0086 A[SYNTHETIC, Splitter:B:63:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0093  */
    public MySharedPreferences getMySharedPreferences(String str, int i) {
        File sharedPrefsFile = getSharedPrefsFile(str);
        synchronized (GLOBAL_COMMIT_LOCK) {
            MySharedPreferencesImpl mySharedPreferencesImpl = this.sSharedPrefs.get(sharedPrefsFile);
            if (mySharedPreferencesImpl != null && !mySharedPreferencesImpl.hasFileChanged()) {
                return mySharedPreferencesImpl;
            }
        }
    }
}
