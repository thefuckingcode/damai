package com.taobao.accs.asp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class BaseSharedPreferences implements SharedPreferences {
    private static final Object CONTENT = new Object();
    static final int TYPE_CORE = 0;
    static final int TYPE_EDGE = 1;
    private static final Handler sUiHandler = new Handler(Looper.getMainLooper());
    private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> mListeners = new WeakHashMap<>();
    boolean mLoaded;
    private final Object mLock = new Object();
    final File mLockFile;
    Map<String, MemoryObject> mMap = new HashMap();
    final String mName;
    final SharedPreferences mSystemSP;
    private final int mType;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public abstract class BaseEditor implements SharedPreferences.Editor {
        private boolean mClear = false;
        private final Object mEditorLock = new Object();
        private Bundle mModified = new Bundle();

        BaseEditor() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private MemoryCommitResult commitToMemory(long j) {
            HashSet hashSet;
            ArrayList arrayList;
            boolean z;
            MemoryCommitResult memoryCommitResult;
            Object obj;
            synchronized (BaseSharedPreferences.this.mLock) {
                boolean z2 = BaseSharedPreferences.this.mListeners.size() > 0;
                if (z2) {
                    arrayList = new ArrayList();
                    hashSet = new HashSet(BaseSharedPreferences.this.mListeners.keySet());
                } else {
                    arrayList = null;
                    hashSet = null;
                }
                synchronized (this.mEditorLock) {
                    if (!this.mClear || BaseSharedPreferences.this.mMap.isEmpty()) {
                        z = false;
                    } else {
                        BaseSharedPreferences.this.mMap.clear();
                        z = true;
                    }
                    for (String str : this.mModified.keySet()) {
                        Object obj2 = this.mModified.get(str);
                        if (obj2 instanceof ArrayList) {
                            obj2 = new HashSet((ArrayList) obj2);
                        }
                        MemoryObject memoryObject = BaseSharedPreferences.this.mMap.get(str);
                        if (memoryObject == null || memoryObject.timestampVersion < j) {
                            if (obj2 == null) {
                                if (BaseSharedPreferences.this.mMap.containsKey(str)) {
                                    BaseSharedPreferences.this.mMap.remove(str);
                                }
                            } else if (!BaseSharedPreferences.this.mMap.containsKey(str) || (obj = BaseSharedPreferences.this.mMap.get(str).value) == null || !obj.equals(obj2)) {
                                BaseSharedPreferences baseSharedPreferences = BaseSharedPreferences.this;
                                baseSharedPreferences.mMap.put(str, new MemoryObject(obj2, j));
                            }
                            if (z2) {
                                arrayList.add(str);
                            }
                            z = true;
                        }
                    }
                    memoryCommitResult = new MemoryCommitResult(z, arrayList, hashSet);
                    memoryCommitResult.changesMade = z;
                    if (z) {
                        ModifiedRecord modifiedRecord = new ModifiedRecord(BaseSharedPreferences.this.mName);
                        modifiedRecord.isClear = this.mClear;
                        modifiedRecord.modified = new Bundle(this.mModified);
                        modifiedRecord.timestampVersion = j;
                        memoryCommitResult.modifiedRecord = modifiedRecord;
                    }
                    this.mModified.clear();
                    this.mClear = false;
                }
            }
            return memoryCommitResult;
        }

        private void saveEditor() {
            final MemoryCommitResult commitToMemory = commitToMemory(SystemClock.elapsedRealtimeNanos());
            if (commitToMemory.changesMade) {
                AThreadPool.submitWriteTask(new Runnable() {
                    /* class com.taobao.accs.asp.BaseSharedPreferences.BaseEditor.AnonymousClass1 */

                    public void run() {
                        BaseEditor.this.commitToDisk(commitToMemory);
                    }
                });
            }
            BaseSharedPreferences.this.notifyListeners(commitToMemory);
        }

        public void apply() {
            saveEditor();
        }

        public SharedPreferences.Editor clear() {
            synchronized (this.mEditorLock) {
                this.mClear = true;
            }
            return this;
        }

        public boolean commit() {
            saveEditor();
            return true;
        }

        /* access modifiers changed from: package-private */
        public abstract void commitToDisk(MemoryCommitResult memoryCommitResult);

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            synchronized (this.mEditorLock) {
                this.mModified.putBoolean(str, z);
            }
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f) {
            synchronized (this.mEditorLock) {
                this.mModified.putFloat(str, f);
            }
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i) {
            synchronized (this.mEditorLock) {
                this.mModified.putInt(str, i);
            }
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j) {
            synchronized (this.mEditorLock) {
                this.mModified.putLong(str, j);
            }
            return this;
        }

        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            synchronized (this.mEditorLock) {
                this.mModified.putString(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            synchronized (this.mEditorLock) {
                this.mModified.putStringArrayList(str, set == null ? null : new ArrayList<>(set));
            }
            return this;
        }

        public SharedPreferences.Editor remove(String str) {
            synchronized (this.mEditorLock) {
                this.mModified.putParcelable(str, null);
            }
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class MemoryCommitResult {
        boolean changesMade;
        @Nullable
        final List<String> keysModified;
        @Nullable
        final Set<SharedPreferences.OnSharedPreferenceChangeListener> listeners;
        ModifiedRecord modifiedRecord;

        private MemoryCommitResult(boolean z, @Nullable List<String> list, @Nullable Set<SharedPreferences.OnSharedPreferenceChangeListener> set) {
            this.changesMade = z;
            this.keysModified = list;
            this.listeners = set;
        }
    }

    BaseSharedPreferences(Context context, String str, SharedPreferences sharedPreferences, int i) {
        this.mName = str;
        this.mLockFile = getLockFile(context, str);
        this.mLoaded = false;
        this.mSystemSP = sharedPreferences;
        this.mType = i;
        AThreadPool.submitLoadTask(new Runnable() {
            /* class com.taobao.accs.asp.BaseSharedPreferences.AnonymousClass1 */

            public void run() {
                synchronized (BaseSharedPreferences.this.mLock) {
                    BaseSharedPreferences.this.loadFromSP();
                    BaseSharedPreferences.this.mLock.notifyAll();
                }
            }
        });
    }

    private void awaitLoadedLocked() {
        while (!this.mLoaded) {
            try {
                this.mLock.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private File getLockFile(Context context, String str) {
        File file = new File(context.getFilesDir(), "shared_prefs");
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(file, str + ".lock");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyListeners(MemoryCommitResult memoryCommitResult) {
        List<String> list;
        if (!(memoryCommitResult.listeners == null || !memoryCommitResult.changesMade || (list = memoryCommitResult.keysModified) == null || list.size() == 0)) {
            for (int size = memoryCommitResult.keysModified.size() - 1; size >= 0; size--) {
                final String str = memoryCommitResult.keysModified.get(size);
                for (final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : memoryCommitResult.listeners) {
                    if (onSharedPreferenceChangeListener != null) {
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
                        } else {
                            sUiHandler.post(new Runnable() {
                                /* class com.taobao.accs.asp.BaseSharedPreferences.AnonymousClass3 */

                                public void run() {
                                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(BaseSharedPreferences.this, str);
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    public boolean contains(String str) {
        boolean containsKey;
        synchronized (this.mLock) {
            awaitLoadedLocked();
            containsKey = this.mMap.containsKey(str);
        }
        return containsKey;
    }

    /* access modifiers changed from: package-private */
    public abstract BaseEditor customEdit();

    public SharedPreferences.Editor edit() {
        synchronized (this.mLock) {
            awaitLoadedLocked();
        }
        return customEdit();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap;
        synchronized (this.mLock) {
            awaitLoadedLocked();
            hashMap = new HashMap();
            for (Map.Entry<String, MemoryObject> entry : this.mMap.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().value);
            }
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            Boolean bool = null;
            if (memoryObject != null) {
                bool = (Boolean) memoryObject.value;
            }
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public float getFloat(String str, float f) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            Float f2 = null;
            if (memoryObject != null) {
                f2 = (Float) memoryObject.value;
            }
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    public int getInt(String str, int i) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            Integer num = null;
            if (memoryObject != null) {
                num = (Integer) memoryObject.value;
            }
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    public long getLong(String str, long j) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            Long l = null;
            if (memoryObject != null) {
                l = (Long) memoryObject.value;
            }
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    @Nullable
    public String getString(String str, @Nullable String str2) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            String str3 = null;
            if (memoryObject != null) {
                str3 = (String) memoryObject.value;
            }
            if (str3 != null) {
                str2 = str3;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            Set<String> set2 = null;
            if (memoryObject != null) {
                set2 = (Set) memoryObject.value;
            }
            if (set2 != null) {
                set = set2;
            }
        }
        return set;
    }

    /* access modifiers changed from: package-private */
    public abstract void loadFromSP();

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.mLock) {
            this.mListeners.put(onSharedPreferenceChangeListener, CONTENT);
        }
    }

    /* access modifiers changed from: package-private */
    public void sync(ModifiedRecord modifiedRecord) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
        }
        final BaseEditor customEdit = customEdit();
        customEdit.mModified = modifiedRecord.modified;
        customEdit.mClear = modifiedRecord.isClear;
        final MemoryCommitResult commitToMemory = customEdit.commitToMemory(modifiedRecord.timestampVersion);
        if (commitToMemory.changesMade && this.mType == 0) {
            AThreadPool.submitWriteTask(new Runnable() {
                /* class com.taobao.accs.asp.BaseSharedPreferences.AnonymousClass2 */

                public void run() {
                    customEdit.commitToDisk(commitToMemory);
                }
            });
        }
        notifyListeners(commitToMemory);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.mLock) {
            this.mListeners.remove(onSharedPreferenceChangeListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class MemoryObject {
        long timestampVersion;
        Object value;

        MemoryObject(Object obj) {
            this.value = obj;
        }

        MemoryObject(Object obj, long j) {
            this.value = obj;
            this.timestampVersion = j;
        }
    }
}
