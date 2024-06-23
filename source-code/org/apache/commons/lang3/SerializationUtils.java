package org.apache.commons.lang3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.taobao.aranger.constant.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class SerializationUtils {

    /* compiled from: Taobao */
    static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes;
        private final ClassLoader classLoader;

        static {
            HashMap hashMap = new HashMap();
            primitiveTypes = hashMap;
            hashMap.put("byte", Byte.TYPE);
            hashMap.put("short", Short.TYPE);
            hashMap.put("int", Integer.TYPE);
            hashMap.put("long", Long.TYPE);
            hashMap.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
            hashMap.put("double", Double.TYPE);
            hashMap.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
            hashMap.put("char", Character.TYPE);
            hashMap.put(Constants.VOID, Void.TYPE);
        }

        ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader2) throws IOException {
            super(inputStream);
            this.classLoader = classLoader2;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0005 */
        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.lang.String */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Class<?>, java.lang.Class] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
            return java.lang.Class.forName(r3, false, java.lang.Thread.currentThread().getContextClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
            r3 = org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.primitiveTypes.get(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
            if (r3 != null) goto L_0x0024;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000c */
        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            String name = objectStreamClass.getName();
            name = Class.forName(name, false, this.classLoader);
            return name;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        throw r1;
     */
    public static <T extends Serializable> T clone(T t) {
        if (t == null) {
            return null;
        }
        try {
            ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream = new ClassLoaderAwareObjectInputStream(new ByteArrayInputStream(serialize(t)), t.getClass().getClassLoader());
            T t2 = (T) ((Serializable) classLoaderAwareObjectInputStream.readObject());
            classLoaderAwareObjectInputStream.close();
            return t2;
        } catch (ClassNotFoundException e) {
            throw new SerializationException("ClassNotFoundException while reading cloned object data", e);
        } catch (IOException e2) {
            throw new SerializationException("IOException while reading or closing cloned object data", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0025, code lost:
        throw r1;
     */
    public static <T> T deserialize(InputStream inputStream) {
        Validate.isTrue(inputStream != null, "The InputStream must not be null", new Object[0]);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            T t = (T) objectInputStream.readObject();
            objectInputStream.close();
            return t;
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException(e);
        }
    }

    public static <T extends Serializable> T roundtrip(T t) {
        return (T) ((Serializable) deserialize(serialize(t)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0024, code lost:
        throw r4;
     */
    public static void serialize(Serializable serializable, OutputStream outputStream) {
        Validate.isTrue(outputStream != null, "The OutputStream must not be null", new Object[0]);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    public static <T> T deserialize(byte[] bArr) {
        Validate.isTrue(bArr != null, "The byte[] must not be null", new Object[0]);
        return (T) deserialize(new ByteArrayInputStream(bArr));
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
