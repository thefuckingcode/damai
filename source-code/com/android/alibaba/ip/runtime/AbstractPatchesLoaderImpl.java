package com.android.alibaba.ip.runtime;

import com.android.alibaba.ip.common.Log;
import java.lang.reflect.Field;
import java.util.logging.Level;

/* compiled from: Taobao */
public abstract class AbstractPatchesLoaderImpl implements PatchesLoader {
    public abstract String[] getPatchedClasses();

    @Override // com.android.alibaba.ip.runtime.PatchesLoader
    public boolean load() {
        Field declaredField;
        try {
            String[] patchedClasses = getPatchedClasses();
            for (String str : patchedClasses) {
                ClassLoader classLoader = getClass().getClassLoader();
                Object newInstance = classLoader.loadClass(str + "$ipReplace").newInstance();
                Field declaredField2 = classLoader.loadClass(str).getDeclaredField("$ipChange");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(null);
                if (!(obj == null || (declaredField = obj.getClass().getDeclaredField("$ipObsolete")) == null)) {
                    declaredField.set(null, Boolean.TRUE);
                }
                declaredField2.set(null, newInstance);
                Log.Logging logging = Log.logging;
                if (logging != null) {
                    Level level = Level.FINE;
                    if (logging.isLoggable(level)) {
                        Log.logging.log(level, String.format("patched %s", str));
                    }
                }
            }
            return true;
        } catch (Exception e) {
            Log.Logging logging2 = Log.logging;
            if (logging2 != null) {
                logging2.log(Level.SEVERE, String.format("Exception while patching %s", "foo.bar"), e);
            }
            return false;
        }
    }
}
