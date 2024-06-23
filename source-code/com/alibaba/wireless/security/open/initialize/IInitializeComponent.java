package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;

/* compiled from: Taobao */
public interface IInitializeComponent {

    /* compiled from: Taobao */
    public interface IInitFinishListener {
        void onError();

        void onSuccess();
    }

    /* compiled from: Taobao */
    public interface IInitFinishListenerV2 extends IInitFinishListener {
        void onStart();
    }

    int initialize(Context context) throws SecException;

    void initializeAsync(Context context);

    boolean isSoValid(Context context) throws SecException;

    void loadLibraryAsync(Context context) throws SecException;

    void loadLibraryAsync(Context context, String str) throws SecException;

    int loadLibrarySync(Context context) throws SecException;

    int loadLibrarySync(Context context, String str) throws SecException;

    void registerInitFinishListener(IInitFinishListener iInitFinishListener) throws SecException;

    void unregisterInitFinishListener(IInitFinishListener iInitFinishListener) throws SecException;
}
