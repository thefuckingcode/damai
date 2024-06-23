package com.google.vr.cardboard;

import android.opengl.GLES20;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

@UsedByNative
/* compiled from: Taobao */
public class EglReadyListener {
    private volatile EGLContext a;
    private volatile int b;
    private volatile int c = 2;
    private final Object d = new Object();
    private volatile EventListener e;
    private final Object f = new Object();

    /* compiled from: Taobao */
    public interface EventListener {
        void onEglReady();
    }

    public static int e(String str) {
        if (str == null) {
            Log.e("EglReadyListener", "Unable to determine the OpenGL major version.");
            return 2;
        }
        int indexOf = str.indexOf(46);
        if (indexOf <= 0) {
            Log.e("EglReadyListener", "Unable to determine the OpenGL major version.");
            return 2;
        }
        int numericValue = Character.getNumericValue(str.charAt(indexOf - 1));
        if (numericValue >= 0) {
            return numericValue;
        }
        Log.e("EglReadyListener", "Unable to determine the OpenGL major version.");
        return 2;
    }

    public void a() {
        synchronized (this.d) {
            this.a = null;
            this.c = 2;
            this.b = 0;
        }
    }

    public EGLContext b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public void f() {
        synchronized (this.f) {
            this.e = null;
        }
    }

    public void g(EventListener eventListener) {
        synchronized (this.f) {
            this.e = eventListener;
        }
    }

    @UsedByNative
    public void onEglReady() {
        synchronized (this.d) {
            this.a = ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
            if (this.a == null || this.a == EGL10.EGL_NO_CONTEXT) {
                Log.e("EglReadyListener", "Unable to obtain the application's OpenGL context.");
            }
            this.c = e(GLES20.glGetString(7938));
            int[] iArr = new int[1];
            GLES20.glGetIntegerv(33310, iArr, 0);
            GLES20.glGetError();
            this.b = iArr[0];
        }
        synchronized (this.f) {
            if (this.e != null) {
                this.e.onEglReady();
            }
        }
    }
}
