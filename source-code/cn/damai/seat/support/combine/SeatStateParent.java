package cn.damai.seat.support.combine;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
public interface SeatStateParent {
    @Nullable
    SeatStateChild getChild(String str);

    boolean isCompress();
}
