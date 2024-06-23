package me.ele.altriax.launcher.biz.strategy;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public interface Strategy {
    public static final String DAG_ALTRIAXB_LINK_DAMAI_NOMAL_APP = "dag_altriaxb_link_damai_app";

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DagStrategy {
    }

    boolean identify(@NonNull String str);
}
