package com.taobao.android.abilitykit.ability.pop.render;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import tb.j;

/* compiled from: Taobao */
public interface IAKPopRenderCallback {
    void onRenderFailed(@NonNull j jVar, @Nullable View view);

    void onRenderSuccess(@NonNull View view);
}
