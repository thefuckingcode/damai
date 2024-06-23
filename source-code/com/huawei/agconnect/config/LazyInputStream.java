package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.config.a.j;
import java.io.InputStream;

@Deprecated
/* compiled from: Taobao */
public abstract class LazyInputStream {
    private final Context mContext;
    private InputStream mInput;

    public LazyInputStream(Context context) {
        this.mContext = context;
    }

    public final void close() {
        j.a(this.mInput);
    }

    public abstract InputStream get(Context context);

    public InputStream loadInputStream() {
        if (this.mInput == null) {
            this.mInput = get(this.mContext);
        }
        return this.mInput;
    }
}
