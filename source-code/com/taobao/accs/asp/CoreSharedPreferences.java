package com.taobao.accs.asp;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.asp.BaseSharedPreferences;
import com.taobao.accs.asp.StatMonitor;
import com.taobao.accs.utl.ALog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class CoreSharedPreferences extends BaseSharedPreferences {
    private static final String TAG = "CoreSharedPreferences";
    private SharedPreferences.Editor sysEditor;

    /* compiled from: Taobao */
    final class CoreEditor extends BaseSharedPreferences.BaseEditor {
        CoreEditor() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.taobao.accs.asp.BaseSharedPreferences.BaseEditor
        public void commitToDisk(BaseSharedPreferences.MemoryCommitResult memoryCommitResult) {
            boolean z;
            ModifiedRecord modifiedRecord = memoryCommitResult.modifiedRecord;
            if (modifiedRecord != null) {
                PrefsIPCChannel.getInstance().dataUpdateEvent(modifiedRecord);
                long currentTimeMillis = System.currentTimeMillis();
                if (CoreSharedPreferences.this.sysEditor == null) {
                    CoreSharedPreferences coreSharedPreferences = CoreSharedPreferences.this;
                    coreSharedPreferences.sysEditor = coreSharedPreferences.mSystemSP.edit();
                }
                if (modifiedRecord.isClear) {
                    CoreSharedPreferences.this.sysEditor.clear();
                }
                for (String str : modifiedRecord.modified.keySet()) {
                    Object obj = modifiedRecord.modified.get(str);
                    if (obj == null) {
                        CoreSharedPreferences.this.sysEditor.remove(str);
                    } else if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (((long) str2.length()) >= 5120) {
                            StatMonitor.SizeAlarm sizeAlarm = new StatMonitor.SizeAlarm(CoreSharedPreferences.this.mName);
                            sizeAlarm.key = str;
                            sizeAlarm.keySize = (long) str.length();
                            sizeAlarm.value = str2;
                            sizeAlarm.valueSize = (long) str2.length();
                            sizeAlarm.commit();
                        }
                        CoreSharedPreferences.this.sysEditor.putString(str, str2);
                    } else if (obj instanceof Integer) {
                        CoreSharedPreferences.this.sysEditor.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        CoreSharedPreferences.this.sysEditor.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Boolean) {
                        CoreSharedPreferences.this.sysEditor.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof ArrayList) {
                        CoreSharedPreferences.this.sysEditor.putStringSet(str, new HashSet((ArrayList) obj));
                    } else if (obj instanceof Float) {
                        CoreSharedPreferences.this.sysEditor.putFloat(str, ((Float) obj).floatValue());
                    }
                }
                FileLock fileLock = null;
                try {
                    fileLock = new RandomAccessFile(CoreSharedPreferences.this.mLockFile, "rw").getChannel().lock();
                    z = CoreSharedPreferences.this.sysEditor.commit();
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    ALog.e(CoreSharedPreferences.TAG, "[commitToDisk]error.", e2, new Object[0]);
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    z = false;
                } catch (Throwable th) {
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                ALog.i(CoreSharedPreferences.TAG, "commitToDisk", "cost", Long.valueOf(currentTimeMillis2));
                StatMonitor.Performance performance = new StatMonitor.Performance(CoreSharedPreferences.this.mName, 2);
                performance.costTime = currentTimeMillis2;
                int i = z ? 1 : 0;
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                performance.result = i;
                performance.commit();
            }
        }
    }

    CoreSharedPreferences(Context context, String str, SharedPreferences sharedPreferences) {
        super(context, str, sharedPreferences, 0);
    }

    /* access modifiers changed from: package-private */
    @Override // com.taobao.accs.asp.BaseSharedPreferences
    public BaseSharedPreferences.BaseEditor customEdit() {
        return new CoreEditor();
    }

    /* access modifiers changed from: package-private */
    @Override // com.taobao.accs.asp.BaseSharedPreferences
    public void loadFromSP() {
        if (!this.mLoaded) {
            long currentTimeMillis = System.currentTimeMillis();
            for (Map.Entry<String, ?> entry : this.mSystemSP.getAll().entrySet()) {
                BaseSharedPreferences.MemoryObject memoryObject = new BaseSharedPreferences.MemoryObject(entry.getValue());
                this.mMap.put(entry.getKey(), memoryObject);
            }
            this.mLoaded = true;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            ALog.i(TAG, "loadFromSP", "cost", Long.valueOf(currentTimeMillis2));
            StatMonitor.Performance performance = new StatMonitor.Performance(this.mName, 1);
            performance.costTime = currentTimeMillis2;
            performance.result = 1;
            performance.commit();
        }
    }
}
