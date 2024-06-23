package com.amap.api.mapcore.util;

import android.opengl.GLSurfaceView;
import com.amap.api.mapcore.util.n;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: Taobao */
public class dx implements GLSurfaceView.EGLContextFactory, n.f {
    @Override // com.amap.api.mapcore.util.n.f
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        return null;
    }

    @Override // com.amap.api.mapcore.util.n.f
    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
    }
}
