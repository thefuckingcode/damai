package com.youku.opengl.filter;

import android.opengl.GLES20;

/* compiled from: Taobao */
class YkGLFilter$8 implements Runnable {
    final /* synthetic */ b this$0;
    final /* synthetic */ int val$location;
    final /* synthetic */ float[] val$matrix;

    YkGLFilter$8(b bVar, int i, float[] fArr) {
        this.this$0 = bVar;
        this.val$location = i;
        this.val$matrix = fArr;
    }

    public void run() {
        this.this$0.d();
        GLES20.glUniformMatrix3fv(this.val$location, 1, false, this.val$matrix, 0);
    }
}
