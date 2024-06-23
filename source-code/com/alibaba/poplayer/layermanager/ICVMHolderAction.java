package com.alibaba.poplayer.layermanager;

import android.app.Activity;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public interface ICVMHolderAction {
    void acceptRequests(ArrayList<PopRequest> arrayList);

    void attach(Activity activity);

    void removeRequests(ArrayList<PopRequest> arrayList);

    void viewReadyNotify(PopRequest popRequest);
}
