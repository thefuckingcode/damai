package androidx.renderscript;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import androidx.renderscript.Element;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tb.jl1;

/* compiled from: Taobao */
public class RenderScript {
    private static final String CACHE_PATH = "com.android.renderscript.cache";
    public static final int CREATE_FLAG_NONE = 0;
    static final boolean DEBUG = false;
    static final boolean LOG_ENABLED = false;
    static final String LOG_TAG = "RenderScript_jni";
    static final int SUPPORT_LIB_API = 23;
    static final int SUPPORT_LIB_VERSION = 2301;
    static Object lock = new Object();
    private static String mBlackList = "";
    static String mCachePath;
    private static ArrayList<RenderScript> mProcessContextList = new ArrayList<>();
    static Method registerNativeAllocation;
    static Method registerNativeFree;
    static boolean sInitialized;
    private static int sNative = -1;
    static int sPointerSize;
    static Object sRuntime;
    private static int sSdkVersion = -1;
    static boolean sUseGCHooks;
    private static boolean useIOlib = false;
    private static boolean useNative;
    private Context mApplicationContext;
    long mContext;
    private int mContextFlags = 0;
    private int mContextSdkVersion = 0;
    ContextType mContextType = ContextType.NORMAL;
    long mDev;
    Element mElement_ALLOCATION;
    Element mElement_A_8;
    Element mElement_BOOLEAN;
    Element mElement_CHAR_2;
    Element mElement_CHAR_3;
    Element mElement_CHAR_4;
    Element mElement_DOUBLE_2;
    Element mElement_DOUBLE_3;
    Element mElement_DOUBLE_4;
    Element mElement_ELEMENT;
    Element mElement_F32;
    Element mElement_F64;
    Element mElement_FLOAT_2;
    Element mElement_FLOAT_3;
    Element mElement_FLOAT_4;
    Element mElement_I16;
    Element mElement_I32;
    Element mElement_I64;
    Element mElement_I8;
    Element mElement_INT_2;
    Element mElement_INT_3;
    Element mElement_INT_4;
    Element mElement_LONG_2;
    Element mElement_LONG_3;
    Element mElement_LONG_4;
    Element mElement_MATRIX_2X2;
    Element mElement_MATRIX_3X3;
    Element mElement_MATRIX_4X4;
    Element mElement_RGBA_4444;
    Element mElement_RGBA_5551;
    Element mElement_RGBA_8888;
    Element mElement_RGB_565;
    Element mElement_RGB_888;
    Element mElement_SAMPLER;
    Element mElement_SCRIPT;
    Element mElement_SHORT_2;
    Element mElement_SHORT_3;
    Element mElement_SHORT_4;
    Element mElement_TYPE;
    Element mElement_U16;
    Element mElement_U32;
    Element mElement_U64;
    Element mElement_U8;
    Element mElement_UCHAR_2;
    Element mElement_UCHAR_3;
    Element mElement_UCHAR_4;
    Element mElement_UINT_2;
    Element mElement_UINT_3;
    Element mElement_UINT_4;
    Element mElement_ULONG_2;
    Element mElement_ULONG_3;
    Element mElement_ULONG_4;
    Element mElement_USHORT_2;
    Element mElement_USHORT_3;
    Element mElement_USHORT_4;
    RSErrorHandler mErrorCallback = null;
    long mIncCon;
    long mIncDev;
    boolean mIncLoaded;
    private boolean mIsProcessContext = false;
    RSMessageHandler mMessageCallback = null;
    MessageThread mMessageThread;
    private String mNativeLibDir;
    ReentrantReadWriteLock mRWLock;
    Sampler mSampler_CLAMP_LINEAR;
    Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
    Sampler mSampler_CLAMP_NEAREST;
    Sampler mSampler_MIRRORED_REPEAT_LINEAR;
    Sampler mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR;
    Sampler mSampler_MIRRORED_REPEAT_NEAREST;
    Sampler mSampler_WRAP_LINEAR;
    Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
    Sampler mSampler_WRAP_NEAREST;

    /* compiled from: Taobao */
    public enum ContextType {
        NORMAL(0),
        DEBUG(1),
        PROFILE(2);
        
        int mID;

        private ContextType(int i) {
            this.mID = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class MessageThread extends Thread {
        static final int RS_ERROR_FATAL_UNKNOWN = 4096;
        static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
        static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
        static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
        static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
        static final int RS_MESSAGE_TO_CLIENT_USER = 4;
        int[] mAuxData = new int[2];
        RenderScript mRS;
        boolean mRun = true;

        MessageThread(RenderScript renderScript) {
            super("RSMessageThread");
            this.mRS = renderScript;
        }

        public void run() {
            int[] iArr = new int[16];
            RenderScript renderScript = this.mRS;
            renderScript.nContextInitToClient(renderScript.mContext);
            while (this.mRun) {
                iArr[0] = 0;
                RenderScript renderScript2 = this.mRS;
                int nContextPeekMessage = renderScript2.nContextPeekMessage(renderScript2.mContext, this.mAuxData);
                int[] iArr2 = this.mAuxData;
                int i = iArr2[1];
                int i2 = iArr2[0];
                if (nContextPeekMessage == 4) {
                    if ((i >> 2) >= iArr.length) {
                        iArr = new int[((i + 3) >> 2)];
                    }
                    RenderScript renderScript3 = this.mRS;
                    if (renderScript3.nContextGetUserMessage(renderScript3.mContext, iArr) == 4) {
                        RSMessageHandler rSMessageHandler = this.mRS.mMessageCallback;
                        if (rSMessageHandler != null) {
                            rSMessageHandler.mData = iArr;
                            rSMessageHandler.mID = i2;
                            rSMessageHandler.mLength = i;
                            rSMessageHandler.run();
                        } else {
                            throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
                        }
                    } else {
                        throw new RSDriverException("Error processing message from RenderScript.");
                    }
                } else if (nContextPeekMessage == 3) {
                    RenderScript renderScript4 = this.mRS;
                    String nContextGetErrorMessage = renderScript4.nContextGetErrorMessage(renderScript4.mContext);
                    if (i2 < 4096) {
                        RSErrorHandler rSErrorHandler = this.mRS.mErrorCallback;
                        if (rSErrorHandler != null) {
                            rSErrorHandler.mErrorMessage = nContextGetErrorMessage;
                            rSErrorHandler.mErrorNum = i2;
                            rSErrorHandler.run();
                        } else {
                            Log.e(RenderScript.LOG_TAG, "non fatal RS error, " + nContextGetErrorMessage);
                        }
                    } else {
                        throw new RSRuntimeException("Fatal error " + i2 + ", details: " + nContextGetErrorMessage);
                    }
                } else {
                    try {
                        Thread.sleep(1, 0);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    public enum Priority {
        LOW(15),
        NORMAL(-4);
        
        int mID;

        private Priority(int i) {
            this.mID = i;
        }
    }

    /* compiled from: Taobao */
    public static class RSErrorHandler implements Runnable {
        protected String mErrorMessage;
        protected int mErrorNum;

        public void run() {
        }
    }

    /* compiled from: Taobao */
    public static class RSMessageHandler implements Runnable {
        protected int[] mData;
        protected int mID;
        protected int mLength;

        public void run() {
        }
    }

    RenderScript(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.mApplicationContext = applicationContext;
            if (Build.VERSION.SDK_INT > 8) {
                this.mNativeLibDir = applicationContext.getApplicationInfo().nativeLibraryDir;
            }
        }
        this.mIncDev = 0;
        this.mIncCon = 0;
        this.mIncLoaded = false;
        this.mRWLock = new ReentrantReadWriteLock();
    }

    public static RenderScript create(Context context) {
        return create(context, ContextType.NORMAL);
    }

    public static RenderScript createMultiContext(Context context, ContextType contextType, int i, int i2) {
        return internalCreate(context, i2, contextType, i);
    }

    public static void forceCompat() {
        sNative = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x012c  */
    private static RenderScript internalCreate(Context context, int i, ContextType contextType, int i2) {
        String str;
        RenderScript renderScript = new RenderScript(context);
        int i3 = sSdkVersion;
        if (i3 == -1) {
            sSdkVersion = i;
        } else if (i3 != i) {
            throw new RSRuntimeException("Can't have two contexts with different SDK versions in support lib");
        }
        useNative = setupNative(sSdkVersion, context);
        synchronized (lock) {
            str = null;
            if (!sInitialized) {
                try {
                    Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                    sRuntime = cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]);
                    Class<?> cls2 = Integer.TYPE;
                    registerNativeAllocation = cls.getDeclaredMethod("registerNativeAllocation", cls2);
                    registerNativeFree = cls.getDeclaredMethod("registerNativeFree", cls2);
                    sUseGCHooks = true;
                } catch (Exception unused) {
                    Log.e(LOG_TAG, "No GC methods");
                    sUseGCHooks = false;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 23 || renderScript.mNativeLibDir == null) {
                        System.loadLibrary("rsjni");
                    } else {
                        System.load(renderScript.mNativeLibDir + "/librsjni.so");
                    }
                    sInitialized = true;
                    sPointerSize = rsnSystemGetPointerSize();
                } catch (UnsatisfiedLinkError e) {
                    Log.e(LOG_TAG, "Error loading RS jni library: " + e);
                    throw new RSRuntimeException("Error loading RS jni library: " + e + " Support lib API: " + 2301);
                }
            }
        }
        if (useNative) {
            Log.v(LOG_TAG, "RS native mode");
        } else {
            Log.v(LOG_TAG, "RS compat mode");
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 14) {
            useIOlib = true;
        }
        int i5 = i < i4 ? i4 : i;
        if (i4 < 23 && renderScript.mNativeLibDir != null) {
            str = renderScript.mNativeLibDir + "/libRSSupport.so";
        }
        if (!renderScript.nLoadSO(useNative, i5, str)) {
            if (useNative) {
                Log.v(LOG_TAG, "Unable to load libRS.so, falling back to compat mode");
                useNative = false;
            }
            if (i4 < 23) {
                try {
                    if (renderScript.mNativeLibDir != null) {
                        System.load(str);
                        if (!renderScript.nLoadSO(false, i5, str)) {
                            Log.e(LOG_TAG, "Error loading RS Compat library: nLoadSO() failed; Support lib version: 2301");
                            throw new RSRuntimeException("Error loading libRSSupport library, Support lib version: 2301");
                        }
                    }
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(LOG_TAG, "Error loading RS Compat library: " + e2 + " Support lib version: " + 2301);
                    throw new RSRuntimeException("Error loading RS Compat library: " + e2 + " Support lib version: " + 2301);
                }
            }
            System.loadLibrary("RSSupport");
            if (!renderScript.nLoadSO(false, i5, str)) {
            }
        }
        if (useIOlib) {
            try {
                System.loadLibrary("RSSupportIO");
            } catch (UnsatisfiedLinkError unused2) {
                useIOlib = false;
            }
            if (!useIOlib || !renderScript.nLoadIOSO()) {
                Log.v(LOG_TAG, "Unable to load libRSSupportIO.so, USAGE_IO not supported");
                useIOlib = false;
            }
        }
        long nDeviceCreate = renderScript.nDeviceCreate();
        renderScript.mDev = nDeviceCreate;
        long nContextCreate = renderScript.nContextCreate(nDeviceCreate, 0, i, contextType.mID, renderScript.mNativeLibDir);
        renderScript.mContext = nContextCreate;
        renderScript.mContextType = contextType;
        renderScript.mContextFlags = i2;
        renderScript.mContextSdkVersion = i;
        if (nContextCreate != 0) {
            MessageThread messageThread = new MessageThread(renderScript);
            renderScript.mMessageThread = messageThread;
            messageThread.start();
            return renderScript;
        }
        throw new RSDriverException("Failed to create RS context.");
    }

    public static void releaseAllContexts() {
        ArrayList<RenderScript> arrayList;
        synchronized (mProcessContextList) {
            arrayList = mProcessContextList;
            mProcessContextList = new ArrayList<>();
        }
        Iterator<RenderScript> it = arrayList.iterator();
        while (it.hasNext()) {
            RenderScript next = it.next();
            next.mIsProcessContext = false;
            next.destroy();
        }
        arrayList.clear();
    }

    static native int rsnSystemGetPointerSize();

    public static void setBlackList(String str) {
        if (str != null) {
            mBlackList = str;
        }
    }

    public static void setupDiskCache(File file) {
        File file2 = new File(file, CACHE_PATH);
        mCachePath = file2.getAbsolutePath();
        file2.mkdirs();
    }

    private static boolean setupNative(int i, Context context) {
        int i2;
        ApplicationInfo applicationInfo;
        long j;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < i && i3 < 21) {
            sNative = 0;
        }
        if (sNative == -1) {
            try {
                i2 = ((Integer) Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(null, "debug.rs.forcecompat", new Integer(0))).intValue();
            } catch (Exception unused) {
                i2 = 0;
            }
            if (Build.VERSION.SDK_INT < 19 || i2 != 0) {
                sNative = 0;
            } else {
                sNative = 1;
            }
            if (sNative == 1) {
                try {
                    applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                } catch (PackageManager.NameNotFoundException unused2) {
                    applicationInfo = null;
                }
                if (applicationInfo != null) {
                    try {
                        Class<?> cls = Class.forName("android.renderscript.RenderScript");
                        j = Build.VERSION.SDK_INT <= 22 ? ((Long) cls.getDeclaredMethod("getMinorID", new Class[0]).invoke(null, new Object[0])).longValue() : ((Long) cls.getDeclaredMethod("getMinorVersion", new Class[0]).invoke(null, new Object[0])).longValue();
                    } catch (Exception unused3) {
                        j = 0;
                    }
                    Bundle bundle = applicationInfo.metaData;
                    if (bundle != null) {
                        if (bundle.getBoolean("com.android.support.v8.renderscript.EnableAsyncTeardown") && j == 0) {
                            sNative = 0;
                        }
                        if (applicationInfo.metaData.getBoolean("com.android.support.v8.renderscript.EnableBlurWorkaround") && Build.VERSION.SDK_INT <= 19) {
                            sNative = 0;
                        }
                    }
                }
            }
        }
        if (sNative != 1) {
            return false;
        }
        if (mBlackList.length() > 0) {
            if (mBlackList.contains('(' + com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER() + jl1.CONDITION_IF_MIDDLE + com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getPRODUCT() + jl1.CONDITION_IF_MIDDLE + com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL() + ')')) {
                sNative = 0;
                return false;
            }
        }
        return true;
    }

    public void contextDump() {
        validate();
        nContextDump(0);
    }

    public void destroy() {
        if (!this.mIsProcessContext) {
            validate();
            nContextFinish();
            if (this.mIncCon != 0) {
                nIncContextFinish();
                nIncContextDestroy();
                this.mIncCon = 0;
            }
            nContextDeinitToClient(this.mContext);
            MessageThread messageThread = this.mMessageThread;
            messageThread.mRun = false;
            try {
                messageThread.join();
            } catch (InterruptedException unused) {
            }
            nContextDestroy();
            nDeviceDestroy(this.mDev);
            long j = this.mIncDev;
            if (j != 0) {
                nIncDeviceDestroy(j);
                this.mIncDev = 0;
            }
            this.mDev = 0;
        }
    }

    public void finish() {
        nContextFinish();
    }

    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public RSErrorHandler getErrorHandler() {
        return this.mErrorCallback;
    }

    public RSMessageHandler getMessageHandler() {
        return this.mMessageCallback;
    }

    /* access modifiers changed from: package-private */
    public boolean isAlive() {
        return this.mContext != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isUseNative() {
        return useNative;
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationCopyFromBitmap(long j, Bitmap bitmap) {
        validate();
        rsnAllocationCopyFromBitmap(this.mContext, j, bitmap);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationCopyToBitmap(long j, Bitmap bitmap) {
        validate();
        rsnAllocationCopyToBitmap(this.mContext, j, bitmap);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nAllocationCreateBitmapBackedAllocation(long j, int i, Bitmap bitmap, int i2) {
        validate();
        return rsnAllocationCreateBitmapBackedAllocation(this.mContext, j, i, bitmap, i2);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nAllocationCreateBitmapRef(long j, Bitmap bitmap) {
        validate();
        return rsnAllocationCreateBitmapRef(this.mContext, j, bitmap);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nAllocationCreateFromAssetStream(int i, int i2, int i3) {
        validate();
        return rsnAllocationCreateFromAssetStream(this.mContext, i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nAllocationCreateFromBitmap(long j, int i, Bitmap bitmap, int i2) {
        validate();
        return rsnAllocationCreateFromBitmap(this.mContext, j, i, bitmap, i2);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nAllocationCreateTyped(long j, int i, int i2, long j2) {
        validate();
        return rsnAllocationCreateTyped(this.mContext, j, i, i2, j2);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nAllocationCubeCreateFromBitmap(long j, int i, Bitmap bitmap, int i2) {
        validate();
        return rsnAllocationCubeCreateFromBitmap(this.mContext, j, i, bitmap, i2);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationData1D(long j, int i, int i2, int i3, Object obj, int i4, Element.DataType dataType, int i5, boolean z) {
        validate();
        rsnAllocationData1D(this.mContext, j, i, i2, i3, obj, i4, dataType.mID, i5, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(long j, int i, int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, int i9, int i10) {
        validate();
        rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, i5, i6, j2, i7, i8, i9, i10);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationData3D(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, int i9, int i10, int i11) {
        validate();
        rsnAllocationData3D(this.mContext, j, i, i2, i3, i4, i5, i6, i7, j2, i8, i9, i10, i11);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationElementData1D(long j, int i, int i2, int i3, byte[] bArr, int i4) {
        validate();
        rsnAllocationElementData1D(this.mContext, j, i, i2, i3, bArr, i4);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationGenerateMipmaps(long j) {
        validate();
        rsnAllocationGenerateMipmaps(this.mContext, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nAllocationGetType(long j) {
        validate();
        return rsnAllocationGetType(this.mContext, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationIoReceive(long j) {
        validate();
        rsnAllocationIoReceive(this.mContext, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationIoSend(long j) {
        validate();
        rsnAllocationIoSend(this.mContext, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationRead(long j, Object obj, Element.DataType dataType, int i, boolean z) {
        validate();
        rsnAllocationRead(this.mContext, j, obj, dataType.mID, i, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationRead1D(long j, int i, int i2, int i3, Object obj, int i4, Element.DataType dataType, int i5, boolean z) {
        validate();
        rsnAllocationRead1D(this.mContext, j, i, i2, i3, obj, i4, dataType.mID, i5, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationRead2D(long j, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, Element.DataType dataType, int i8, boolean z) {
        validate();
        rsnAllocationRead2D(this.mContext, j, i, i2, i3, i4, i5, i6, obj, i7, dataType.mID, i8, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationResize1D(long j, int i) {
        validate();
        rsnAllocationResize1D(this.mContext, j, i);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationResize2D(long j, int i, int i2) {
        validate();
        rsnAllocationResize2D(this.mContext, j, i, i2);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationSetSurface(long j, Surface surface) {
        validate();
        rsnAllocationSetSurface(this.mContext, j, surface);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationSyncAll(long j, int i) {
        validate();
        rsnAllocationSyncAll(this.mContext, j, i);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nClosureCreate(long j, long j2, long[] jArr, long[] jArr2, int[] iArr, long[] jArr3, long[] jArr4) {
        long rsnClosureCreate;
        validate();
        rsnClosureCreate = rsnClosureCreate(this.mContext, j, j2, jArr, jArr2, iArr, jArr3, jArr4);
        if (rsnClosureCreate == 0) {
            throw new RSRuntimeException("Failed creating closure.");
        }
        return rsnClosureCreate;
    }

    /* access modifiers changed from: package-private */
    public synchronized void nClosureSetArg(long j, int i, long j2, int i2) {
        validate();
        rsnClosureSetArg(this.mContext, j, i, j2, i2);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nClosureSetGlobal(long j, long j2, long j3, int i) {
        validate();
        rsnClosureSetGlobal(this.mContext, j, j2, j3, i);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nContextCreate(long j, int i, int i2, int i3, String str) {
        return rsnContextCreate(j, i, i2, i3, str);
    }

    /* access modifiers changed from: package-private */
    public native void nContextDeinitToClient(long j);

    /* access modifiers changed from: package-private */
    public synchronized void nContextDestroy() {
        validate();
        ReentrantReadWriteLock.WriteLock writeLock = this.mRWLock.writeLock();
        writeLock.lock();
        long j = this.mContext;
        this.mContext = 0;
        writeLock.unlock();
        rsnContextDestroy(j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nContextDump(int i) {
        validate();
        rsnContextDump(this.mContext, i);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nContextFinish() {
        validate();
        rsnContextFinish(this.mContext);
    }

    /* access modifiers changed from: package-private */
    public native String nContextGetErrorMessage(long j);

    /* access modifiers changed from: package-private */
    public native int nContextGetUserMessage(long j, int[] iArr);

    /* access modifiers changed from: package-private */
    public native void nContextInitToClient(long j);

    /* access modifiers changed from: package-private */
    public native int nContextPeekMessage(long j, int[] iArr);

    /* access modifiers changed from: package-private */
    public synchronized void nContextSendMessage(int i, int[] iArr) {
        validate();
        rsnContextSendMessage(this.mContext, i, iArr);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nContextSetPriority(int i) {
        validate();
        rsnContextSetPriority(this.mContext, i);
    }

    /* access modifiers changed from: package-private */
    public native long nDeviceCreate();

    /* access modifiers changed from: package-private */
    public native void nDeviceDestroy(long j);

    /* access modifiers changed from: package-private */
    public native void nDeviceSetConfig(long j, int i, int i2);

    /* access modifiers changed from: package-private */
    public synchronized long nElementCreate(long j, int i, boolean z, int i2) {
        validate();
        return rsnElementCreate(this.mContext, j, i, z, i2);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nElementCreate2(long[] jArr, String[] strArr, int[] iArr) {
        validate();
        return rsnElementCreate2(this.mContext, jArr, strArr, iArr);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nElementGetNativeData(long j, int[] iArr) {
        validate();
        rsnElementGetNativeData(this.mContext, j, iArr);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nElementGetSubElements(long j, long[] jArr, String[] strArr, int[] iArr) {
        validate();
        rsnElementGetSubElements(this.mContext, j, jArr, strArr, iArr);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nIncAllocationCreateTyped(long j, long j2) {
        validate();
        return rsnIncAllocationCreateTyped(this.mContext, this.mIncCon, j, j2);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nIncContextCreate(long j, int i, int i2, int i3) {
        return rsnIncContextCreate(j, i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nIncContextDestroy() {
        validate();
        ReentrantReadWriteLock.WriteLock writeLock = this.mRWLock.writeLock();
        writeLock.lock();
        long j = this.mIncCon;
        this.mIncCon = 0;
        writeLock.unlock();
        rsnIncContextDestroy(j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nIncContextFinish() {
        validate();
        rsnIncContextFinish(this.mIncCon);
    }

    /* access modifiers changed from: package-private */
    public native long nIncDeviceCreate();

    /* access modifiers changed from: package-private */
    public native void nIncDeviceDestroy(long j);

    /* access modifiers changed from: package-private */
    public synchronized long nIncElementCreate(long j, int i, boolean z, int i2) {
        validate();
        return rsnIncElementCreate(this.mIncCon, j, i, z, i2);
    }

    /* access modifiers changed from: package-private */
    public native boolean nIncLoadSO(int i, String str);

    /* access modifiers changed from: package-private */
    public void nIncObjDestroy(long j) {
        long j2 = this.mIncCon;
        if (j2 != 0) {
            rsnIncObjDestroy(j2, j);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized long nIncTypeCreate(long j, int i, int i2, int i3, boolean z, boolean z2, int i4) {
        validate();
        return rsnIncTypeCreate(this.mIncCon, j, i, i2, i3, z, z2, i4);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nInvokeClosureCreate(long j, byte[] bArr, long[] jArr, long[] jArr2, int[] iArr) {
        long rsnInvokeClosureCreate;
        validate();
        rsnInvokeClosureCreate = rsnInvokeClosureCreate(this.mContext, j, bArr, jArr, jArr2, iArr);
        if (rsnInvokeClosureCreate == 0) {
            throw new RSRuntimeException("Failed creating closure.");
        }
        return rsnInvokeClosureCreate;
    }

    /* access modifiers changed from: package-private */
    public native boolean nLoadIOSO();

    /* access modifiers changed from: package-private */
    public native boolean nLoadSO(boolean z, int i, String str);

    /* access modifiers changed from: package-private */
    public void nObjDestroy(long j) {
        long j2 = this.mContext;
        if (j2 != 0) {
            rsnObjDestroy(j2, j);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized long nSamplerCreate(int i, int i2, int i3, int i4, int i5, float f) {
        validate();
        return rsnSamplerCreate(this.mContext, i, i2, i3, i4, i5, f);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptBindAllocation(long j, long j2, int i, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptBindAllocation(j3, j, j2, i, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nScriptCCreate(String str, String str2, byte[] bArr, int i) {
        validate();
        return rsnScriptCCreate(this.mContext, str, str2, bArr, i);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nScriptFieldIDCreate(long j, int i, boolean z) {
        long j2;
        validate();
        j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        return rsnScriptFieldIDCreate(j2, j, i, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptForEach(long j, int i, long j2, long j3, byte[] bArr, boolean z) {
        validate();
        if (bArr == null) {
            rsnScriptForEach(this.mContext, this.mIncCon, j, i, j2, j3, z);
        } else {
            rsnScriptForEach(this.mContext, this.mIncCon, j, i, j2, j3, bArr, z);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptForEachClipped(long j, int i, long j2, long j3, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        validate();
        if (bArr == null) {
            rsnScriptForEachClipped(this.mContext, this.mIncCon, j, i, j2, j3, i2, i3, i4, i5, i6, i7, z);
        } else {
            rsnScriptForEachClipped(this.mContext, this.mIncCon, j, i, j2, j3, bArr, i2, i3, i4, i5, i6, i7, z);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized long nScriptGroup2Create(String str, String str2, long[] jArr) {
        validate();
        return rsnScriptGroup2Create(this.mContext, str, str2, jArr);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptGroup2Execute(long j) {
        validate();
        rsnScriptGroup2Execute(this.mContext, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nScriptGroupCreate(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5) {
        validate();
        return rsnScriptGroupCreate(this.mContext, jArr, jArr2, jArr3, jArr4, jArr5);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptGroupExecute(long j) {
        validate();
        rsnScriptGroupExecute(this.mContext, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptGroupSetInput(long j, long j2, long j3) {
        validate();
        rsnScriptGroupSetInput(this.mContext, j, j2, j3);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptGroupSetOutput(long j, long j2, long j3) {
        validate();
        rsnScriptGroupSetOutput(this.mContext, j, j2, j3);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptIntrinsicBLAS_BNNM(long j, int i, int i2, int i3, long j2, int i4, long j3, int i5, long j4, int i6, int i7, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_BNNM(this.mContext, this.mIncCon, j, i, i2, i3, j2, i4, j3, i5, j4, i6, i7, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptIntrinsicBLAS_Complex(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, float f2, long j2, long j3, float f3, float f4, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Complex(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, f, f2, j2, j3, f3, f4, j4, i10, i11, i12, i13, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptIntrinsicBLAS_Double(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, long j2, long j3, double d2, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Double(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, d, j2, j3, d2, j4, i10, i11, i12, i13, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptIntrinsicBLAS_Single(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, long j2, long j3, float f2, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Single(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, f, j2, j3, f2, j4, i10, i11, i12, i13, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptIntrinsicBLAS_Z(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, double d2, long j2, long j3, double d3, double d4, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Z(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, d, d2, j2, j3, d3, d4, j4, i10, i11, i12, i13, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nScriptIntrinsicCreate(int i, long j, boolean z) {
        validate();
        if (!z) {
            return rsnScriptIntrinsicCreate(this.mContext, i, j, z);
        } else if (Build.VERSION.SDK_INT >= 21) {
            if (!this.mIncLoaded) {
                try {
                    System.loadLibrary("RSSupport");
                    if (nIncLoadSO(23, this.mNativeLibDir + "/libRSSupport.so")) {
                        this.mIncLoaded = true;
                    } else {
                        throw new RSRuntimeException("Error loading libRSSupport library for Incremental Intrinsic Support");
                    }
                } catch (UnsatisfiedLinkError e) {
                    Log.e(LOG_TAG, "Error loading RS Compat library for Incremental Intrinsic Support: " + e);
                    throw new RSRuntimeException("Error loading RS Compat library for Incremental Intrinsic Support: " + e);
                }
            }
            if (this.mIncDev == 0) {
                this.mIncDev = nIncDeviceCreate();
            }
            if (this.mIncCon == 0) {
                this.mIncCon = nIncContextCreate(this.mIncDev, 0, 0, 0);
            }
            return rsnScriptIntrinsicCreate(this.mIncCon, i, j, z);
        } else {
            Log.e(LOG_TAG, "Incremental Intrinsics are not supported, please change targetSdkVersion to >= 21");
            throw new RSRuntimeException("Incremental Intrinsics are not supported before Lollipop (API 21)");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptInvoke(long j, int i, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptInvoke(j2, j, i, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nScriptInvokeIDCreate(long j, int i) {
        validate();
        return rsnScriptInvokeIDCreate(this.mContext, j, i);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptInvokeV(long j, int i, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptInvokeV(j2, j, i, bArr, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nScriptKernelIDCreate(long j, int i, int i2, boolean z) {
        long j2;
        validate();
        j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        return rsnScriptKernelIDCreate(j2, j, i, i2, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptSetTimeZone(long j, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetTimeZone(j2, j, bArr, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptSetVarD(long j, int i, double d, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarD(j2, j, i, d, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptSetVarF(long j, int i, float f, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarF(j2, j, i, f, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptSetVarI(long j, int i, int i2, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarI(j2, j, i, i2, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptSetVarJ(long j, int i, long j2, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptSetVarJ(j3, j, i, j2, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptSetVarObj(long j, int i, long j2, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptSetVarObj(j3, j, i, j2, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptSetVarV(long j, int i, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarV(j2, j, i, bArr, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nScriptSetVarVE(long j, int i, byte[] bArr, long j2, int[] iArr, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptSetVarVE(j3, j, i, bArr, j2, iArr, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized long nTypeCreate(long j, int i, int i2, int i3, boolean z, boolean z2, int i4) {
        validate();
        return rsnTypeCreate(this.mContext, j, i, i2, i3, z, z2, i4);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nTypeGetNativeData(long j, long[] jArr) {
        validate();
        rsnTypeGetNativeData(this.mContext, j, jArr);
    }

    /* access modifiers changed from: package-private */
    public native void rsnAllocationCopyFromBitmap(long j, long j2, Bitmap bitmap);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationCopyToBitmap(long j, long j2, Bitmap bitmap);

    /* access modifiers changed from: package-private */
    public native long rsnAllocationCreateBitmapBackedAllocation(long j, long j2, int i, Bitmap bitmap, int i2);

    /* access modifiers changed from: package-private */
    public native long rsnAllocationCreateBitmapRef(long j, long j2, Bitmap bitmap);

    /* access modifiers changed from: package-private */
    public native long rsnAllocationCreateFromAssetStream(long j, int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    public native long rsnAllocationCreateFromBitmap(long j, long j2, int i, Bitmap bitmap, int i2);

    /* access modifiers changed from: package-private */
    public native long rsnAllocationCreateTyped(long j, long j2, int i, int i2, long j3);

    /* access modifiers changed from: package-private */
    public native long rsnAllocationCubeCreateFromBitmap(long j, long j2, int i, Bitmap bitmap, int i2);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData1D(long j, long j2, int i, int i2, int i3, Object obj, int i4, int i5, int i6, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, long j3, int i7, int i8, int i9, int i10);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, int i8, int i9, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, Bitmap bitmap);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData3D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j3, int i8, int i9, int i10, int i11);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData3D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, int i9, int i10, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationElementData1D(long j, long j2, int i, int i2, int i3, byte[] bArr, int i4);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationGenerateMipmaps(long j, long j2);

    /* access modifiers changed from: package-private */
    public native long rsnAllocationGetType(long j, long j2);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationIoReceive(long j, long j2);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationIoSend(long j, long j2);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationRead(long j, long j2, Object obj, int i, int i2, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationRead1D(long j, long j2, int i, int i2, int i3, Object obj, int i4, int i5, int i6, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationRead2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, int i8, int i9, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationResize1D(long j, long j2, int i);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationResize2D(long j, long j2, int i, int i2);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationSetSurface(long j, long j2, Surface surface);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationSyncAll(long j, long j2, int i);

    /* access modifiers changed from: package-private */
    public native long rsnClosureCreate(long j, long j2, long j3, long[] jArr, long[] jArr2, int[] iArr, long[] jArr3, long[] jArr4);

    /* access modifiers changed from: package-private */
    public native void rsnClosureSetArg(long j, long j2, int i, long j3, int i2);

    /* access modifiers changed from: package-private */
    public native void rsnClosureSetGlobal(long j, long j2, long j3, long j4, int i);

    /* access modifiers changed from: package-private */
    public native long rsnContextCreate(long j, int i, int i2, int i3, String str);

    /* access modifiers changed from: package-private */
    public native void rsnContextDestroy(long j);

    /* access modifiers changed from: package-private */
    public native void rsnContextDump(long j, int i);

    /* access modifiers changed from: package-private */
    public native void rsnContextFinish(long j);

    /* access modifiers changed from: package-private */
    public native void rsnContextSendMessage(long j, int i, int[] iArr);

    /* access modifiers changed from: package-private */
    public native void rsnContextSetPriority(long j, int i);

    /* access modifiers changed from: package-private */
    public native long rsnElementCreate(long j, long j2, int i, boolean z, int i2);

    /* access modifiers changed from: package-private */
    public native long rsnElementCreate2(long j, long[] jArr, String[] strArr, int[] iArr);

    /* access modifiers changed from: package-private */
    public native void rsnElementGetNativeData(long j, long j2, int[] iArr);

    /* access modifiers changed from: package-private */
    public native void rsnElementGetSubElements(long j, long j2, long[] jArr, String[] strArr, int[] iArr);

    /* access modifiers changed from: package-private */
    public native long rsnIncAllocationCreateTyped(long j, long j2, long j3, long j4);

    /* access modifiers changed from: package-private */
    public native long rsnIncContextCreate(long j, int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    public native void rsnIncContextDestroy(long j);

    /* access modifiers changed from: package-private */
    public native void rsnIncContextFinish(long j);

    /* access modifiers changed from: package-private */
    public native long rsnIncElementCreate(long j, long j2, int i, boolean z, int i2);

    /* access modifiers changed from: package-private */
    public native void rsnIncObjDestroy(long j, long j2);

    /* access modifiers changed from: package-private */
    public native long rsnIncTypeCreate(long j, long j2, int i, int i2, int i3, boolean z, boolean z2, int i4);

    /* access modifiers changed from: package-private */
    public native long rsnInvokeClosureCreate(long j, long j2, byte[] bArr, long[] jArr, long[] jArr2, int[] iArr);

    /* access modifiers changed from: package-private */
    public native void rsnObjDestroy(long j, long j2);

    /* access modifiers changed from: package-private */
    public native long rsnSamplerCreate(long j, int i, int i2, int i3, int i4, int i5, float f);

    /* access modifiers changed from: package-private */
    public native void rsnScriptBindAllocation(long j, long j2, long j3, int i, boolean z);

    /* access modifiers changed from: package-private */
    public native long rsnScriptCCreate(long j, String str, String str2, byte[] bArr, int i);

    /* access modifiers changed from: package-private */
    public native long rsnScriptFieldIDCreate(long j, long j2, int i, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptForEach(long j, long j2, long j3, int i, long j4, long j5, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptForEach(long j, long j2, long j3, int i, long j4, long j5, byte[] bArr, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptForEachClipped(long j, long j2, long j3, int i, long j4, long j5, int i2, int i3, int i4, int i5, int i6, int i7, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptForEachClipped(long j, long j2, long j3, int i, long j4, long j5, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z);

    /* access modifiers changed from: package-private */
    public native long rsnScriptGroup2Create(long j, String str, String str2, long[] jArr);

    /* access modifiers changed from: package-private */
    public native void rsnScriptGroup2Execute(long j, long j2);

    /* access modifiers changed from: package-private */
    public native long rsnScriptGroupCreate(long j, long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5);

    /* access modifiers changed from: package-private */
    public native void rsnScriptGroupExecute(long j, long j2);

    /* access modifiers changed from: package-private */
    public native void rsnScriptGroupSetInput(long j, long j2, long j3, long j4);

    /* access modifiers changed from: package-private */
    public native void rsnScriptGroupSetOutput(long j, long j2, long j3, long j4);

    /* access modifiers changed from: package-private */
    public native void rsnScriptIntrinsicBLAS_BNNM(long j, long j2, long j3, int i, int i2, int i3, long j4, int i4, long j5, int i5, long j6, int i6, int i7, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptIntrinsicBLAS_Complex(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, float f2, long j4, long j5, float f3, float f4, long j6, int i10, int i11, int i12, int i13, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptIntrinsicBLAS_Double(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, long j4, long j5, double d2, long j6, int i10, int i11, int i12, int i13, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptIntrinsicBLAS_Single(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, long j4, long j5, float f2, long j6, int i10, int i11, int i12, int i13, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptIntrinsicBLAS_Z(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, double d2, long j4, long j5, double d3, double d4, long j6, int i10, int i11, int i12, int i13, boolean z);

    /* access modifiers changed from: package-private */
    public native long rsnScriptIntrinsicCreate(long j, int i, long j2, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptInvoke(long j, long j2, int i, boolean z);

    /* access modifiers changed from: package-private */
    public native long rsnScriptInvokeIDCreate(long j, long j2, int i);

    /* access modifiers changed from: package-private */
    public native void rsnScriptInvokeV(long j, long j2, int i, byte[] bArr, boolean z);

    /* access modifiers changed from: package-private */
    public native long rsnScriptKernelIDCreate(long j, long j2, int i, int i2, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetTimeZone(long j, long j2, byte[] bArr, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarD(long j, long j2, int i, double d, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarF(long j, long j2, int i, float f, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarI(long j, long j2, int i, int i2, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarJ(long j, long j2, int i, long j3, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarObj(long j, long j2, int i, long j3, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarV(long j, long j2, int i, byte[] bArr, boolean z);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarVE(long j, long j2, int i, byte[] bArr, long j3, int[] iArr, boolean z);

    /* access modifiers changed from: package-private */
    public native long rsnTypeCreate(long j, long j2, int i, int i2, int i3, boolean z, boolean z2, int i4);

    /* access modifiers changed from: package-private */
    public native void rsnTypeGetNativeData(long j, long j2, long[] jArr);

    /* access modifiers changed from: package-private */
    public long safeID(BaseObj baseObj) {
        if (baseObj != null) {
            return baseObj.getID(this);
        }
        return 0;
    }

    public void sendMessage(int i, int[] iArr) {
        nContextSendMessage(i, iArr);
    }

    public void setErrorHandler(RSErrorHandler rSErrorHandler) {
        this.mErrorCallback = rSErrorHandler;
    }

    public void setMessageHandler(RSMessageHandler rSMessageHandler) {
        this.mMessageCallback = rSMessageHandler;
    }

    public void setPriority(Priority priority) {
        validate();
        nContextSetPriority(priority.mID);
    }

    /* access modifiers changed from: package-private */
    public boolean usingIO() {
        return useIOlib;
    }

    /* access modifiers changed from: package-private */
    public void validate() {
        if (this.mContext == 0) {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        }
    }

    public static RenderScript create(Context context, ContextType contextType) {
        return create(context, contextType, 0);
    }

    public static RenderScript create(Context context, ContextType contextType, int i) {
        return create(context, context.getApplicationInfo().targetSdkVersion, contextType, i);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(long j, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, Element.DataType dataType, int i8, boolean z) {
        validate();
        rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, i5, i6, obj, i7, dataType.mID, i8, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationData3D(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, Element.DataType dataType, int i9, boolean z) {
        validate();
        rsnAllocationData3D(this.mContext, j, i, i2, i3, i4, i5, i6, i7, obj, i8, dataType.mID, i9, z);
    }

    public static RenderScript create(Context context, int i) {
        return create(context, i, ContextType.NORMAL, 0);
    }

    public static RenderScript create(Context context, int i, ContextType contextType) {
        return create(context, i, contextType, 0);
    }

    public static RenderScript create(Context context, int i, ContextType contextType, int i2) {
        synchronized (mProcessContextList) {
            Iterator<RenderScript> it = mProcessContextList.iterator();
            while (it.hasNext()) {
                RenderScript next = it.next();
                if (next.mContextType == contextType && next.mContextFlags == i2 && next.mContextSdkVersion == i) {
                    return next;
                }
            }
            RenderScript internalCreate = internalCreate(context, i, contextType, i2);
            internalCreate.mIsProcessContext = true;
            mProcessContextList.add(internalCreate);
            return internalCreate;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(long j, int i, int i2, int i3, int i4, Bitmap bitmap) {
        validate();
        rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, bitmap);
    }
}
