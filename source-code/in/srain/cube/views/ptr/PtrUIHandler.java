package in.srain.cube.views.ptr;

import tb.rv1;

/* compiled from: Taobao */
public interface PtrUIHandler {
    void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rv1 rv1);

    void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout);

    void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout);

    void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout);

    void onUIReset(PtrFrameLayout ptrFrameLayout);
}
