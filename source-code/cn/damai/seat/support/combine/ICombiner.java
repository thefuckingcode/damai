package cn.damai.seat.support.combine;

/* compiled from: Taobao */
public interface ICombiner {
    void combineIfNeed();

    boolean isPrepared();

    void removeDynamic();
}
