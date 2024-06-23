package com.youku.opengl.filter;

import android.opengl.GLES20;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class YkGLFilter$2 implements Runnable {
    final /* synthetic */ b this$0;
    final /* synthetic */ float val$floatValue;
    final /* synthetic */ int val$location;

    YkGLFilter$2(b bVar, int i, float f) {
        this.this$0 = bVar;
        this.val$location = i;
        this.val$floatValue = f;
    }

    public void run() {
        this.this$0.d();
        GLES20.glUniform1f(this.val$location, this.val$floatValue);
    }
}
