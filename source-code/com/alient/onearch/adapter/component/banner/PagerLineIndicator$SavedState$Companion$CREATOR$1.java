package com.alient.onearch.adapter.component.banner;

import android.os.Parcel;
import android.os.Parcelable;
import com.alient.onearch.adapter.component.banner.PagerLineIndicator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/alient/onearch/adapter/component/banner/PagerLineIndicator$SavedState$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/alient/onearch/adapter/component/banner/PagerLineIndicator$SavedState;", "Landroid/os/Parcel;", "in", "createFromParcel", "", "size", "", "newArray", "(I)[Lcom/alient/onearch/adapter/component/banner/PagerLineIndicator$SavedState;", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PagerLineIndicator$SavedState$Companion$CREATOR$1 implements Parcelable.Creator<PagerLineIndicator.SavedState> {
    PagerLineIndicator$SavedState$Companion$CREATOR$1() {
    }

    @Override // android.os.Parcelable.Creator
    @NotNull
    public PagerLineIndicator.SavedState createFromParcel(@NotNull Parcel parcel) {
        k21.i(parcel, "in");
        return new PagerLineIndicator.SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    @NotNull
    public PagerLineIndicator.SavedState[] newArray(int i) {
        return new PagerLineIndicator.SavedState[i];
    }
}
