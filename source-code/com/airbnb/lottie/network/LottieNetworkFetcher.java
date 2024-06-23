package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.IOException;

/* compiled from: Taobao */
public interface LottieNetworkFetcher {
    @NonNull
    @WorkerThread
    LottieFetchResult fetchSync(@NonNull String str) throws IOException;
}
