package com.google.vr.ndk.base;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.google.vr.cardboard.EglReadyListener;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import tb.uc0;

/* compiled from: Taobao */
public class GvrSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final int GL_CONTEXT_FLAG_NO_ERROR_BIT_KHR = 8;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    public static final int SWAPMODE_MANUAL = 2;
    public static final int SWAPMODE_QUEUED = 0;
    public static final int SWAPMODE_SINGLE = 1;
    private static final String TAG = "GvrSurfaceView";
    private EglReadyListener mAppContextListener;
    private int mDebugFlags;
    private boolean mDetached;
    private GLSurfaceView.EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private GLSurfaceView.EGLContextFactory mEGLContextFactory;
    private GLSurfaceView.EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private boolean mPreserveGlThreadOnDetachedFromWindow;
    private GLSurfaceView.Renderer mRenderer;
    private final WeakReference<GvrSurfaceView> mThisWeakRef = new WeakReference<>(this);

    /* compiled from: Taobao */
    abstract class BaseConfigChooser implements GLSurfaceView.EGLConfigChooser {
        protected int[] mConfigSpec;

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (GvrSurfaceView.this.mEGLContextClientVersion != 2 && GvrSurfaceView.this.mEGLContextClientVersion != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (GvrSurfaceView.this.mEGLContextClientVersion == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int i = 1;
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, null, 0, iArr)) {
                while (true) {
                    int[] iArr2 = this.mConfigSpec;
                    if (i >= iArr2.length) {
                        throw new IllegalArgumentException("eglChooseConfig failed");
                    } else if (iArr2[i - 1] == 12352 && iArr2[i] == 64) {
                        Log.w(GvrSurfaceView.TAG, "Failed to choose GLES 3 config, will try 2.");
                        this.mConfigSpec[i] = 4;
                        return chooseConfig(egl10, eGLDisplay);
                    } else {
                        i++;
                    }
                }
            } else {
                int i2 = iArr[0];
                if (i2 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                    if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i2, iArr)) {
                        EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                        if (chooseConfig != null) {
                            return chooseConfig;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
        }

        /* access modifiers changed from: package-private */
        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* compiled from: Taobao */
    class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ComponentSizeChooser(GvrSurfaceView gvrSurfaceView, int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }

        @Override // com.google.vr.ndk.base.GvrSurfaceView.BaseConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    class DefaultContextFactory implements GLSurfaceView.EGLContextFactory {
        private DefaultContextFactory() {
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, GvrSurfaceView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GvrSurfaceView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                String valueOf = String.valueOf(eGLDisplay);
                String valueOf2 = String.valueOf(eGLContext);
                StringBuilder sb = new StringBuilder(valueOf.length() + 18 + valueOf2.length());
                sb.append("display:");
                sb.append(valueOf);
                sb.append(" context: ");
                sb.append(valueOf2);
                Log.e("DefaultContextFactory", sb.toString());
                EglHelper.throwEglException("eglDestroyContext", egl10.eglGetError());
            }
        }
    }

    /* compiled from: Taobao */
    static class DefaultWindowSurfaceFactory implements GLSurfaceView.EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e(GvrSurfaceView.TAG, "eglCreateWindowSurface", e);
                return null;
            }
        }

        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class EglHelper {
        public static final int EGL_FRONT_BUFFER_AUTO_REFRESH = 12620;
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GvrSurfaceView> mGvrSurfaceViewWeakRef;
        EGLContext mPendingEglContext;
        EGLDisplay mPendingEglDisplay;

        public EglHelper(WeakReference<GvrSurfaceView> weakReference) {
            this.mGvrSurfaceViewWeakRef = weakReference;
        }

        private void createPendingEglContext() {
            EGLContext eGLContext;
            EGLDisplay eglGetDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mPendingEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(eglGetDisplay, new int[2])) {
                    GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
                    EGLContext eGLContext2 = null;
                    if (gvrSurfaceView == null) {
                        this.mEglConfig = null;
                        eGLContext = null;
                    } else {
                        if (gvrSurfaceView.mAppContextListener != null) {
                            EGLContext b = gvrSurfaceView.mAppContextListener.b();
                            if (b == null || b == EGL10.EGL_NO_CONTEXT) {
                                throwEglException("Unable to obtain application's OpenGL context.");
                            } else {
                                uc0 uc0 = (uc0) gvrSurfaceView.mEGLContextFactory;
                                int c = gvrSurfaceView.mAppContextListener.c();
                                uc0.c(b);
                                uc0.b((c & 8) == 0);
                                uc0.a(gvrSurfaceView.mAppContextListener.d());
                            }
                        }
                        this.mEglConfig = gvrSurfaceView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mPendingEglDisplay);
                        eGLContext = gvrSurfaceView.mEGLContextFactory.createContext(this.mEgl, this.mPendingEglDisplay, this.mEglConfig);
                    }
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        int eglGetError = this.mEgl.eglGetError();
                        if (eglGetError == 12294) {
                            Log.e("EglHelper", "Stashed EGL context has become invalid and can no longer be used for sharing.");
                            this.mPendingEglContext = null;
                            this.mPendingEglDisplay = null;
                            this.mEglConfig = null;
                            if (gvrSurfaceView.mAppContextListener != null) {
                                gvrSurfaceView.mAppContextListener.a();
                                return;
                            }
                            return;
                        }
                        throwEglException("createPendingEglContext", eglGetError);
                    } else {
                        eGLContext2 = eGLContext;
                    }
                    this.mPendingEglContext = eGLContext2;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.mEglSurface;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
                if (gvrSurfaceView != null) {
                    gvrSurfaceView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
        }

        public static String formatEglError(String str, int i) {
            String errorString = getErrorString(i);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 9 + String.valueOf(errorString).length());
            sb.append(str);
            sb.append(" failed: ");
            sb.append(errorString);
            return sb.toString();
        }

        private static String getErrorString(int i) {
            switch (i) {
                case MessageConstant$CommandId.COMMAND_BASE /*{ENCODED_INT: 12288}*/:
                    return "EGL_SUCCESS";
                case MessageConstant$CommandId.COMMAND_REGISTER /*{ENCODED_INT: 12289}*/:
                    return "EGL_NOT_INITIALIZED";
                case MessageConstant$CommandId.COMMAND_UNREGISTER /*{ENCODED_INT: 12290}*/:
                    return "EGL_BAD_ACCESS";
                case MessageConstant$CommandId.COMMAND_STATISTIC /*{ENCODED_INT: 12291}*/:
                    return "EGL_BAD_ALLOC";
                case MessageConstant$CommandId.COMMAND_SET_ALIAS /*{ENCODED_INT: 12292}*/:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case MessageConstant$CommandId.COMMAND_SET_PUSH_TIME /*{ENCODED_INT: 12298}*/:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case MessageConstant$CommandId.COMMAND_PAUSE_PUSH /*{ENCODED_INT: 12299}*/:
                    return "EGL_BAD_NATIVE_WINDOW";
                case MessageConstant$CommandId.COMMAND_RESUME_PUSH /*{ENCODED_INT: 12300}*/:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return getHex(i);
            }
        }

        private static String getHex(int i) {
            String valueOf = String.valueOf(Integer.toHexString(i));
            return valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        }

        private void initialize() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.mEgl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(eglGetDisplay, new int[2])) {
                    this.mEglSurface = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            Log.w(str, formatEglError(str2, i));
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        /* access modifiers changed from: package-private */
        public GL createGL() {
            GL gl = this.mEglContext.getGL();
            GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
            if (gvrSurfaceView == null) {
                return gl;
            }
            if (gvrSurfaceView.mGLWrapper != null) {
                gl = gvrSurfaceView.mGLWrapper.wrap(gl);
            }
            if ((gvrSurfaceView.mDebugFlags & 3) == 0) {
                return gl;
            }
            int i = 0;
            LogWriter logWriter = null;
            if ((gvrSurfaceView.mDebugFlags & 1) != 0) {
                i = 1;
            }
            if ((gvrSurfaceView.mDebugFlags & 2) != 0) {
                logWriter = new LogWriter();
            }
            return GLDebugHelper.wrap(gl, i, logWriter);
        }

        public boolean createSurface() {
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.mEglConfig != null) {
                destroySurfaceImp();
                GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
                if (gvrSurfaceView != null) {
                    this.mEglSurface = gvrSurfaceView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gvrSurfaceView.getHolder());
                } else {
                    this.mEglSurface = null;
                }
                EGLSurface eGLSurface = this.mEglSurface;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.mEgl.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                } else if (this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
                    return true;
                } else {
                    logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                    return false;
                }
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        public void finish() {
            if (this.mEglContext != null) {
                GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
                if (gvrSurfaceView != null) {
                    gvrSurfaceView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        public void renewPendingEglContext() {
            if (this.mEgl == null) {
                initialize();
            }
            EGLContext eGLContext = this.mPendingEglContext;
            if (eGLContext != null) {
                this.mEgl.eglDestroyContext(this.mEglDisplay, eGLContext);
            }
            createPendingEglContext();
        }

        public void setEglSurfaceAttrib(int i, int i2) {
            if (Build.VERSION.SDK_INT < 17) {
                Log.e("EglHelper", "Cannot call eglSurfaceAttrib. API version is too low.");
            } else if (!EGL14.eglSurfaceAttrib(EGL14.eglGetCurrentDisplay(), EGL14.eglGetCurrentSurface(12377), i, i2)) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("eglSurfaceAttrib() failed. attribute=");
                sb.append(i);
                sb.append(" value=");
                sb.append(i2);
                Log.e("EglHelper", sb.toString());
            }
        }

        public void start() {
            if (this.mEgl == null) {
                initialize();
            }
            EGLContext eGLContext = this.mEglContext;
            if (eGLContext != null) {
                this.mEgl.eglDestroyContext(this.mEglDisplay, eGLContext);
                this.mEglContext = null;
            }
            if (this.mPendingEglContext == null) {
                createPendingEglContext();
            }
            this.mEglContext = this.mPendingEglContext;
            this.mEglDisplay = this.mPendingEglDisplay;
            this.mPendingEglContext = null;
            this.mPendingEglDisplay = null;
        }

        public int swap() {
            return !this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface) ? this.mEgl.eglGetError() : MessageConstant$CommandId.COMMAND_BASE;
        }

        public static void throwEglException(String str, int i) {
            throw new RuntimeException(formatEglError(str, i));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class GLThread extends Thread implements EglReadyListener.EventListener {
        private EglHelper mEglHelper;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean mExited;
        private boolean mFinishedCreatingEglSurface;
        private final GLThreadManager mGLThreadManager = new GLThreadManager();
        private WeakReference<GvrSurfaceView> mGvrSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight = 0;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode = 1;
        private boolean mRequestPaused;
        private boolean mRequestRender = true;
        private int mRequestedSwapMode = 0;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private boolean mWantRenderNotification = false;
        private int mWidth = 0;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public static class GLThreadManager {
            private GLThreadManager() {
            }

            public void releaseEglContextLocked(GLThread gLThread) {
                notifyAll();
            }

            public synchronized void threadExiting(GLThread gLThread) {
                gLThread.mExited = true;
                notifyAll();
            }
        }

        GLThread(WeakReference<GvrSurfaceView> weakReference) {
            this.mGvrSurfaceViewWeakRef = weakReference;
            GvrSurfaceView gvrSurfaceView = weakReference.get();
            if (gvrSurfaceView != null && gvrSurfaceView.mAppContextListener != null) {
                gvrSurfaceView.mAppContextListener.g(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0150, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
            r19.mFinishedCreatingEglSurface = true;
            r19.mGLThreadManager.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x0159, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x015a, code lost:
            r7 = 0;
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x0160, code lost:
            r2 = r19.mGLThreadManager;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x0162, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
            r19.mFinishedCreatingEglSurface = true;
            r19.mSurfaceIsBad = true;
            r19.mGLThreadManager.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x016d, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x016e, code lost:
            r16 = r16;
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x0176, code lost:
            if (r11 == false) goto L_0x0182;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x0178, code lost:
            r8 = (javax.microedition.khronos.opengles.GL10) r19.mEglHelper.createGL();
            r11 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x0182, code lost:
            if (r9 == false) goto L_0x01a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x0184, code lost:
            r0 = r19.mGvrSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x018c, code lost:
            if (r0 == null) goto L_0x01a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
            com.google.vr.ndk.base.TraceCompat.beginSection("onSurfaceCreated");
            r0.mRenderer.onSurfaceCreated(r8, r19.mEglHelper.mEglConfig);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x01a2, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x01a3, code lost:
            com.google.vr.ndk.base.TraceCompat.endSection();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x01a6, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x01a7, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x01a8, code lost:
            if (r12 == false) goto L_0x01ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x01aa, code lost:
            r0 = r19.mGvrSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x01b2, code lost:
            if (r0 == null) goto L_0x01c9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
            com.google.vr.ndk.base.TraceCompat.beginSection("onSurfaceChanged");
            r0.mRenderer.onSurfaceChanged(r8, r15, r16);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x01c4, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x01c5, code lost:
            com.google.vr.ndk.base.TraceCompat.endSection();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x01c8, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x01c9, code lost:
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x01ca, code lost:
            if (r14 == false) goto L_0x01f1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x01cc, code lost:
            r0 = r19.mEglHelper;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x01cf, code lost:
            if (r7 != 1) goto L_0x01d8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d1, code lost:
            r16 = r16;
            r2 = 12421;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x01d8, code lost:
            r16 = r16;
            r2 = 12420;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x01de, code lost:
            r0.setEglSurfaceAttrib(12422, r2);
            r0 = r19.mEglHelper;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x01e8, code lost:
            if (r7 != 1) goto L_0x01ec;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x01ea, code lost:
            r3 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x01ec, code lost:
            r3 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x01ed, code lost:
            r0.setEglSurfaceAttrib(com.google.vr.ndk.base.GvrSurfaceView.EglHelper.EGL_FRONT_BUFFER_AUTO_REFRESH, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x01f1, code lost:
            r16 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x01f3, code lost:
            r0 = r19.mGvrSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x01fb, code lost:
            if (r0 == null) goto L_0x0212;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:?, code lost:
            com.google.vr.ndk.base.TraceCompat.beginSection("onDrawFrame");
            r0.mRenderer.onDrawFrame(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x020d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x020e, code lost:
            com.google.vr.ndk.base.TraceCompat.endSection();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0211, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0212, code lost:
            if (r14 != false) goto L_0x0219;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x0214, code lost:
            if (r7 != 0) goto L_0x0217;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x0219, code lost:
            r0 = r19.mEglHelper.swap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x0221, code lost:
            if (r0 == 12288) goto L_0x0217;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x0225, code lost:
            if (r0 == 12302) goto L_0x0240;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x0227, code lost:
            com.google.vr.ndk.base.GvrSurfaceView.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x022e, code lost:
            if (r7 != 0) goto L_0x0217;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x0230, code lost:
            r2 = r19.mGLThreadManager;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x0232, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
            r19.mSurfaceIsBad = true;
            r19.mGLThreadManager.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x023b, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0240, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x0242, code lost:
            r0 = false;
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x0243, code lost:
            if (r13 == false) goto L_0x0022;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x0245, code lost:
            r5 = true;
            r13 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x013b, code lost:
            if (r17 == null) goto L_0x0144;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x0144, code lost:
            if (r10 == false) goto L_0x0176;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x014c, code lost:
            if (r19.mEglHelper.createSurface() == false) goto L_0x0160;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x014e, code lost:
            r2 = r19.mGLThreadManager;
         */
        /* JADX WARNING: Removed duplicated region for block: B:186:0x0249  */
        /* JADX WARNING: Removed duplicated region for block: B:208:0x010e A[SYNTHETIC] */
        private void guardedRun() throws InterruptedException {
            boolean z;
            boolean z2;
            this.mEglHelper = new EglHelper(this.mGvrSurfaceViewWeakRef);
            boolean z3 = false;
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.mWantRenderNotification = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            int i = 0;
            GL10 gl10 = null;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                Runnable runnable = null;
                while (true) {
                    try {
                        synchronized (this.mGLThreadManager) {
                            while (!this.mShouldExit) {
                                if (!this.mEventQueue.isEmpty()) {
                                    ArrayList<Runnable> arrayList = this.mEventQueue;
                                    int i4 = z3 ? 1 : 0;
                                    int i5 = z3 ? 1 : 0;
                                    int i6 = z3 ? 1 : 0;
                                    int i7 = z3 ? 1 : 0;
                                    int i8 = z3 ? 1 : 0;
                                    int i9 = z3 ? 1 : 0;
                                    int i10 = z3 ? 1 : 0;
                                    int i11 = z3 ? 1 : 0;
                                    int i12 = z3 ? 1 : 0;
                                    int i13 = z3 ? 1 : 0;
                                    runnable = arrayList.remove(i4);
                                } else {
                                    boolean z13 = this.mPaused;
                                    boolean z14 = this.mRequestPaused;
                                    if (z13 != z14) {
                                        this.mPaused = z14;
                                        this.mGLThreadManager.notifyAll();
                                    } else {
                                        z14 = false;
                                    }
                                    if (this.mShouldReleaseEglContext) {
                                        stopEglSurfaceLocked();
                                        stopEglContextLocked();
                                        this.mShouldReleaseEglContext = false;
                                        z6 = true;
                                    }
                                    if (z4) {
                                        stopEglSurfaceLocked();
                                        stopEglContextLocked();
                                        z4 = false;
                                    }
                                    if (z14 && this.mHaveEglSurface) {
                                        stopEglSurfaceLocked();
                                    }
                                    if (z14 && this.mHaveEglContext) {
                                        GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
                                        if (gvrSurfaceView == null) {
                                            z2 = false;
                                        } else {
                                            z2 = gvrSurfaceView.mPreserveEGLContextOnPause;
                                        }
                                        if (!z2) {
                                            stopEglContextLocked();
                                        }
                                    }
                                    if (!this.mHasSurface && !this.mWaitingForSurface) {
                                        if (this.mHaveEglSurface) {
                                            stopEglSurfaceLocked();
                                        }
                                        this.mWaitingForSurface = true;
                                        this.mSurfaceIsBad = false;
                                        this.mGLThreadManager.notifyAll();
                                    }
                                    if (this.mHasSurface && this.mWaitingForSurface) {
                                        this.mWaitingForSurface = false;
                                        this.mGLThreadManager.notifyAll();
                                    }
                                    if (z5) {
                                        this.mWantRenderNotification = false;
                                        this.mRenderComplete = true;
                                        this.mGLThreadManager.notifyAll();
                                        z5 = false;
                                    }
                                    if (readyToDraw()) {
                                        if (!this.mHaveEglContext) {
                                            if (z6) {
                                                z = false;
                                            } else {
                                                try {
                                                    this.mEglHelper.start();
                                                    if (this.mEglHelper.mEglContext != null) {
                                                        this.mHaveEglContext = true;
                                                        this.mGLThreadManager.notifyAll();
                                                        z = z6;
                                                        z7 = true;
                                                    }
                                                } catch (RuntimeException e) {
                                                    this.mGLThreadManager.releaseEglContextLocked(this);
                                                    throw e;
                                                }
                                            }
                                            if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                                this.mHaveEglSurface = true;
                                                z8 = true;
                                                z9 = true;
                                                z10 = true;
                                            }
                                            if (!this.mHaveEglSurface) {
                                                if (this.mSizeChanged) {
                                                    i2 = this.mWidth;
                                                    int i14 = this.mHeight;
                                                    this.mWantRenderNotification = true;
                                                    this.mSizeChanged = false;
                                                    i3 = i14;
                                                    z3 = false;
                                                    z8 = true;
                                                    z10 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                this.mRequestRender = z3;
                                                this.mGLThreadManager.notifyAll();
                                                if (this.mWantRenderNotification) {
                                                    z11 = true;
                                                }
                                                int i15 = this.mRequestedSwapMode;
                                                z12 = i15 != i;
                                                i = i15;
                                                z6 = z;
                                            } else {
                                                z6 = z;
                                            }
                                        }
                                        z = z6;
                                        this.mHaveEglSurface = true;
                                        z8 = true;
                                        z9 = true;
                                        z10 = true;
                                        if (!this.mHaveEglSurface) {
                                        }
                                    }
                                    this.mGLThreadManager.wait();
                                    z3 = false;
                                }
                            }
                            synchronized (this.mGLThreadManager) {
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        synchronized (this.mGLThreadManager) {
                            stopEglSurfaceLocked();
                            stopEglContextLocked();
                            throw th;
                        }
                    }
                }
                runnable.run();
                i3 = i3;
            }
        }

        private boolean readyToDraw() {
            EglReadyListener eglReadyListener;
            GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
            if (gvrSurfaceView == null) {
                eglReadyListener = null;
            } else {
                eglReadyListener = gvrSurfaceView.mAppContextListener;
            }
            return !this.mPaused && (eglReadyListener == null || eglReadyListener.b() != null) && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                this.mGLThreadManager.releaseEglContextLocked(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        public int getRenderMode() {
            int i;
            synchronized (this.mGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public int getSwapMode() {
            int i;
            synchronized (this.mGLThreadManager) {
                i = this.mRequestedSwapMode;
            }
            return i;
        }

        @Override // com.google.vr.cardboard.EglReadyListener.EventListener
        public void onEglReady() {
            synchronized (this.mGLThreadManager) {
                this.mEglHelper.renewPendingEglContext();
                this.mGLThreadManager.notifyAll();
            }
        }

        public void onPause() {
            synchronized (this.mGLThreadManager) {
                this.mRequestPaused = true;
                this.mGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.mGLThreadManager) {
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.mGLThreadManager.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (this.mGLThreadManager) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() != this) {
                    this.mGLThreadManager.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.mGLThreadManager.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void queueEvent(Runnable runnable) {
            if (runnable != null) {
                synchronized (this.mGLThreadManager) {
                    this.mEventQueue.add(runnable);
                    this.mGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public void requestExitAndWait() {
            synchronized (this.mGLThreadManager) {
                this.mShouldExit = true;
                this.mGLThreadManager.notifyAll();
                while (!this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
                if (!(gvrSurfaceView == null || gvrSurfaceView.mAppContextListener == null)) {
                    gvrSurfaceView.mAppContextListener.f();
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            this.mGLThreadManager.notifyAll();
        }

        public void requestRender() {
            synchronized (this.mGLThreadManager) {
                this.mRequestRender = true;
                this.mGLThreadManager.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.mGLThreadManager) {
                if (Thread.currentThread() != this) {
                    this.mWantRenderNotification = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.mGLThreadManager.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.mGLThreadManager.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void run() {
            long id = getId();
            StringBuilder sb = new StringBuilder(29);
            sb.append("GLThread ");
            sb.append(id);
            setName(sb.toString());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                this.mGLThreadManager.threadExiting(this);
                throw th;
            }
            this.mGLThreadManager.threadExiting(this);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this.mGLThreadManager) {
                this.mRenderMode = i;
                this.mGLThreadManager.notifyAll();
            }
        }

        public void setSwapMode(int i) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("swapMode");
            }
            synchronized (this.mGLThreadManager) {
                this.mRequestedSwapMode = i;
                this.mGLThreadManager.notifyAll();
            }
        }

        public void surfaceCreated() {
            synchronized (this.mGLThreadManager) {
                this.mHasSurface = true;
                this.mFinishedCreatingEglSurface = false;
                this.mGLThreadManager.notifyAll();
                while (this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.mGLThreadManager) {
                this.mHasSurface = false;
                this.mGLThreadManager.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    public interface GLWrapper {
        GL wrap(GL gl);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v(GvrSurfaceView.TAG, this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
        public void close() {
            flushBuilder();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            flushBuilder();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }
    }

    /* compiled from: Taobao */
    class SimpleEGLConfigChooser extends ComponentSizeChooser {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleEGLConfigChooser(GvrSurfaceView gvrSurfaceView, boolean z) {
            super(gvrSurfaceView, 8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public GvrSurfaceView(Context context) {
        super(context);
        init();
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    /* access modifiers changed from: protected */
    public boolean isDetachedFromWindow() {
        return this.mDetached;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i;
        int i2;
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null && !this.mPreserveGlThreadOnDetachedFromWindow) {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                i2 = gLThread.getRenderMode();
                i = this.mGLThread.getSwapMode();
            } else {
                i2 = 1;
                i = 0;
            }
            GLThread gLThread2 = new GLThread(this.mThisWeakRef);
            this.mGLThread = gLThread2;
            if (i2 != 1) {
                gLThread2.setRenderMode(i2);
            }
            if (i != 0) {
                this.mGLThread.setSwapMode(i);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.mGLThread != null && !this.mPreserveGlThreadOnDetachedFromWindow) {
            requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.mGLThread.queueEvent(runnable);
    }

    public void requestExitAndWait() {
        this.mGLThread.requestExitAndWait();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setEglReadyListener(EglReadyListener eglReadyListener) {
        this.mAppContextListener = eglReadyListener;
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public void setPreserveGlThreadOnDetachedFromWindow(boolean z) {
        checkRenderThreadState();
        this.mPreserveGlThreadOnDetachedFromWindow = z;
    }

    public void setRenderMode(int i) {
        this.mGLThread.setRenderMode(i);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(this, true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        GLThread gLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.start();
    }

    public void setSwapMode(int i) {
        if (i != 1 || Build.VERSION.SDK_INT >= 17) {
            this.mGLThread.setSwapMode(i);
        } else {
            Log.e(TAG, "setSwapMode(SWAPMODE_SINGLE) requires Jellybean MR1 (EGL14 dependency)");
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mGLThread.onWindowResize(i2, i3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceDestroyed();
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        this.mGLThread.requestRenderAndWait();
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(this, z));
    }

    public GvrSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser(new ComponentSizeChooser(this, i, i2, i3, i4, i5, i6));
    }
}
