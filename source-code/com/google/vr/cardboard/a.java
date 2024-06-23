package com.google.vr.cardboard;

import android.os.Environment;
import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import tb.xw2;

/* compiled from: Taobao */
public class a {
    public static final String CARDBOARD_CONFIG_FOLDER = "Cardboard";
    public static final String URI_KEY_PARAMS = "p";
    private static final String a = "a";

    private static File a(String str) throws IllegalStateException {
        File file = new File(Environment.getExternalStorageDirectory(), CARDBOARD_CONFIG_FOLDER);
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            String valueOf = String.valueOf(file);
            StringBuilder sb = new StringBuilder(valueOf.length() + 61);
            sb.append(valueOf);
            sb.append(" already exists as a file, but is expected to be a directory.");
            throw new IllegalStateException(sb.toString());
        }
        return new File(file, str);
    }

    public static CardboardDevice.DeviceParams b() {
        return c(CardboardDevice.DeviceParams.class, "current_device_params", 894990891, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        r4 = com.google.vr.cardboard.a.a;
        r3 = java.lang.String.valueOf(r3);
        r6 = new java.lang.StringBuilder(r3.length() + 26);
        r6.append("Error reading parameters: ");
        r6.append(r3);
        android.util.Log.w(r4, r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r6 != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        r4 = com.google.vr.cardboard.a.a;
        r3 = java.lang.String.valueOf(r3);
        r6 = new java.lang.StringBuilder(r3.length() + 39);
        r6.append("Parameters file not found for reading: ");
        r6.append(r3);
        android.util.Log.d(r4, r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0066, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x0013, B:15:0x0020] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0020 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[SYNTHETIC, Splitter:B:13:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0021 A[ExcHandler: IllegalStateException (r3v1 'e' java.lang.IllegalStateException A[CUSTOM_DECLARE]), Splitter:B:5:0x0013] */
    private static <T extends MessageNano> T c(Class<T> cls, String str, int i, boolean z) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(a(str)));
            try {
                T t = (T) d(cls, bufferedInputStream, i);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused) {
                } catch (IllegalStateException e) {
                }
                return t;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            throw th;
        }
    }

    private static <T extends MessageNano> T d(Class<T> cls, InputStream inputStream, int i) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            if (inputStream.read(allocate.array(), 0, allocate.array().length) == -1) {
                Log.e(a, "Error parsing param record: end of stream.");
                return null;
            }
            int i2 = allocate.getInt();
            int i3 = allocate.getInt();
            if (i2 != i) {
                Log.e(a, "Error parsing param record: incorrect sentinel.");
                return null;
            }
            byte[] bArr = new byte[i3];
            if (inputStream.read(bArr, 0, i3) != -1) {
                return (T) MessageNano.mergeFrom(cls.newInstance(), bArr);
            }
            Log.e(a, "Error parsing param record: end of stream.");
            return null;
        } catch (InvalidProtocolBufferNanoException e) {
            String str = a;
            String valueOf = String.valueOf(e.toString());
            Log.w(str, valueOf.length() != 0 ? "Error parsing protocol buffer: ".concat(valueOf) : new String("Error parsing protocol buffer: "));
            return null;
        } catch (IOException e2) {
            String str2 = a;
            String valueOf2 = String.valueOf(e2.toString());
            Log.w(str2, valueOf2.length() != 0 ? "Error reading parameters: ".concat(valueOf2) : new String("Error reading parameters: "));
            return null;
        } catch (InstantiationException e3) {
            String str3 = a;
            String valueOf3 = String.valueOf(e3.toString());
            Log.w(str3, valueOf3.length() != 0 ? "Error creating parameters: ".concat(valueOf3) : new String("Error creating parameters: "));
            return null;
        } catch (IllegalAccessException e4) {
            String str4 = a;
            String valueOf4 = String.valueOf(e4.toString());
            Log.w(str4, valueOf4.length() != 0 ? "Error accessing parameter type: ".concat(valueOf4) : new String("Error accessing parameter type: "));
            return null;
        }
    }

    public static Phone.PhoneParams e() {
        return c(Phone.PhoneParams.class, xw2.PHONE_PARAMS_SETTING, 779508118, false);
    }

    public static boolean f() {
        boolean z;
        try {
            File a2 = a("current_device_params");
            z = a2.exists() ? a2.delete() : true;
        } catch (IllegalStateException e) {
            String str = a;
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 34);
            sb.append("Error clearing device parameters: ");
            sb.append(valueOf);
            Log.w(str, sb.toString());
            z = false;
        }
        if (!z) {
            Log.e(a, "Could not clear Cardboard parameters from external storage.");
        }
        return z;
    }

    public static boolean g(CardboardDevice.DeviceParams deviceParams) {
        boolean h = h(deviceParams, "current_device_params", 894990891);
        if (!h) {
            Log.e(a, "Could not write Cardboard parameters to external storage.");
        }
        return h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r0 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        if (r0 != null) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071 A[SYNTHETIC, Splitter:B:27:0x0071] */
    private static boolean h(MessageNano messageNano, String str, int i) {
        Throwable th;
        FileNotFoundException e;
        IllegalStateException e2;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(a(str)));
            try {
                boolean i2 = i(messageNano, bufferedOutputStream2, i);
                try {
                    bufferedOutputStream2.close();
                    return i2;
                } catch (IOException unused) {
                    return i2;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                bufferedOutputStream = bufferedOutputStream2;
                String str2 = a;
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(valueOf.length() + 39);
                sb.append("Parameters file not found for writing: ");
                sb.append(valueOf);
                Log.e(str2, sb.toString());
            } catch (IllegalStateException e4) {
                e2 = e4;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    String str3 = a;
                    String valueOf2 = String.valueOf(e2);
                    StringBuilder sb2 = new StringBuilder(valueOf2.length() + 26);
                    sb2.append("Error writing parameters: ");
                    sb2.append(valueOf2);
                    Log.w(str3, sb2.toString());
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            String str22 = a;
            String valueOf3 = String.valueOf(e);
            StringBuilder sb3 = new StringBuilder(valueOf3.length() + 39);
            sb3.append("Parameters file not found for writing: ");
            sb3.append(valueOf3);
            Log.e(str22, sb3.toString());
        } catch (IllegalStateException e6) {
            e2 = e6;
            String str32 = a;
            String valueOf22 = String.valueOf(e2);
            StringBuilder sb22 = new StringBuilder(valueOf22.length() + 26);
            sb22.append("Error writing parameters: ");
            sb22.append(valueOf22);
            Log.w(str32, sb22.toString());
        }
        return false;
    }

    private static boolean i(MessageNano messageNano, OutputStream outputStream, int i) {
        try {
            byte[] byteArray = MessageNano.toByteArray(messageNano);
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(i);
            allocate.putInt(byteArray.length);
            outputStream.write(allocate.array());
            outputStream.write(byteArray);
            return true;
        } catch (IOException e) {
            String str = a;
            String valueOf = String.valueOf(e.toString());
            Log.w(str, valueOf.length() != 0 ? "Error writing parameters: ".concat(valueOf) : new String("Error writing parameters: "));
            return false;
        }
    }
}
