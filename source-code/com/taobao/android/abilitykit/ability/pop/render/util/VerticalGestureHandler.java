package com.taobao.android.abilitykit.ability.pop.render.util;

import android.view.View;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public class VerticalGestureHandler implements IGestureHandler {
    private int a;
    @NonNull
    private final Callback b;
    private boolean c;

    /* compiled from: Taobao */
    public interface Callback {
        boolean canContentViewScrollVertical(int i);

        boolean isAnimating();

        boolean isPanEnabled();

        void onCloseBlocked(@NonNull View view);

        void onStateChanged(@NonNull View view, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface State {
        public static final int ANIMATING = 4;
        public static final int CLOSED = 3;
        public static final int COLLAPSE = 2;
        public static final int EXPAND = 1;
        public static final int INIT = 0;
    }
}
