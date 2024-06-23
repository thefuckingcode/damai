package kotlin;

/* compiled from: Taobao */
public interface Lazy<T> {
    T getValue();

    boolean isInitialized();
}
