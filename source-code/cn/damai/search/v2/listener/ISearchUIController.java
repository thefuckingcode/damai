package cn.damai.search.v2.listener;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public interface ISearchUIController {

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface UiInt {
    }

    void showUi(int i);
}
