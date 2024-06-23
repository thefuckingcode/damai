package com.youku.android.audio;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public enum OprAudioFormat {
    NONE(-1),
    U8(1),
    S16(2),
    S32(3),
    FLT(4),
    DBL(5),
    U8P(6),
    S16P(7),
    S32P(8),
    FLTP(9),
    DBLP(10),
    S64(11),
    S64P(12),
    NB(13);

    private OprAudioFormat(int i) {
    }
}
