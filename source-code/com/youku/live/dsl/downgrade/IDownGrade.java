package com.youku.live.dsl.downgrade;

import android.content.Context;
import android.os.Bundle;

/* compiled from: Taobao */
public interface IDownGrade {
    void downgradeWebview(Context context, String str, Bundle bundle);

    void downgradeWebview(String str, Bundle bundle);

    void downgradeWebviewForResult(Context context, String str, Bundle bundle, int i);
}
