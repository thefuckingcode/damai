package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
public class Finalizer implements Runnable {
    private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
    @NullableDecl
    private static final Constructor<Thread> bigThreadConstructor;
    @NullableDecl
    private static final Field inheritableThreadLocals;
    private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue;

    static {
        Constructor<Thread> bigThreadConstructor2 = getBigThreadConstructor();
        bigThreadConstructor = bigThreadConstructor2;
        inheritableThreadLocals = bigThreadConstructor2 == null ? getInheritableThreadLocalsField() : null;
    }

    private Finalizer(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        this.queue = referenceQueue;
        this.finalizableReferenceClassReference = new WeakReference<>(cls);
        this.frqReference = phantomReference;
    }

    private boolean cleanUp(Reference<?> reference) {
        Method finalizeReferentMethod = getFinalizeReferentMethod();
        if (finalizeReferentMethod == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.frqReference) {
                return false;
            }
            try {
                finalizeReferentMethod.invoke(reference, new Object[0]);
            } catch (Throwable th) {
                logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.queue.poll();
        } while (reference != null);
        return true;
    }

    @NullableDecl
    private static Constructor<Thread> getBigThreadConstructor() {
        try {
            return Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    private Method getFinalizeReferentMethod() {
        Class<?> cls = this.finalizableReferenceClassReference.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    @NullableDecl
    private static Field getInheritableThreadLocalsField() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056 A[Catch:{ all -> 0x005a }] */
    public static void startFinalizer(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        Thread thread;
        Field field;
        if (cls.getName().equals(FINALIZABLE_REFERENCE)) {
            Finalizer finalizer = new Finalizer(cls, referenceQueue, phantomReference);
            String name = Finalizer.class.getName();
            Constructor<Thread> constructor = bigThreadConstructor;
            if (constructor != null) {
                try {
                    thread = constructor.newInstance(null, finalizer, name, 0L, Boolean.FALSE);
                } catch (Throwable th) {
                    logger.log(Level.INFO, "Failed to create a thread without inherited thread-local values", th);
                }
                if (thread == null) {
                    thread = new Thread(null, finalizer, name);
                }
                thread.setDaemon(true);
                field = inheritableThreadLocals;
                if (field != null) {
                    field.set(thread, null);
                }
                thread.start();
                return;
            }
            thread = null;
            if (thread == null) {
            }
            thread.setDaemon(true);
            try {
                field = inheritableThreadLocals;
                if (field != null) {
                }
            } catch (Throwable th2) {
                logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", th2);
            }
            thread.start();
            return;
        }
        throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:0|1|(2:5|3)(2:7|4)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:4:0x0000, LOOP_START, SYNTHETIC, Splitter:B:0:0x0000] */
    public void run() {
        while (true) {
            if (!cleanUp(this.queue.remove())) {
                return;
            }
        }
    }
}
