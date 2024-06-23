package cn.damai.homepage.nestedscroll.nestedinterface;

/* compiled from: Taobao */
public interface NestedScrollParent {
    boolean acceptNestedFling(int i);

    boolean acceptNestedScroll(int i);

    boolean dispatchNestedFling(int i);

    boolean dispatchNestedScroll(int i);

    void setNestedScrollChild(NestedScrollChild nestedScrollChild);
}
