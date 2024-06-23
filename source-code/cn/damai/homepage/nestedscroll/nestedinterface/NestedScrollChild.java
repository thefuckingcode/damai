package cn.damai.homepage.nestedscroll.nestedinterface;

/* compiled from: Taobao */
public interface NestedScrollChild {
    boolean acceptNestedFling(int i);

    boolean acceptNestedScroll(int i);

    boolean dispatchNestedFling(int i);

    boolean dispatchNestedScroll(int i);

    int getNestedScrollChildHeight();

    void onScrolledByNestedParent(NestedScrollParent nestedScrollParent);

    void setNestedScrollParent(NestedScrollParent nestedScrollParent);
}
