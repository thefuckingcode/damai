package com.taobao.monitor.procedure;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/* compiled from: Taobao */
public interface IProcedureManager {
    @NonNull
    IProcedure getActivityProcedure(Activity activity);

    @NonNull
    @Deprecated
    IProcedure getCurrentActivityProcedure();

    @NonNull
    @Deprecated
    IProcedure getCurrentFragmentProcedure();

    @NonNull
    @Deprecated
    IProcedure getCurrentProcedure();

    @NonNull
    IProcedure getFragmentProcedure(Fragment fragment);

    @NonNull
    IProcedure getLauncherProcedure();

    @NonNull
    IProcedure getProcedure(View view);

    @NonNull
    IProcedure getRootProcedure();
}
