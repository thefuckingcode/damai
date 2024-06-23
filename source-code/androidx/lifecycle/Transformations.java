package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

/* compiled from: Taobao */
public class Transformations {
    private Transformations() {
    }

    @NonNull
    @MainThread
    public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> liveData) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() {
            /* class androidx.lifecycle.Transformations.AnonymousClass3 */
            boolean mFirstTime = true;

            @Override // androidx.lifecycle.Observer
            public void onChanged(X x) {
                Object value = mediatorLiveData.getValue();
                if (this.mFirstTime || ((value == null && x != null) || (value != null && !value.equals(x)))) {
                    this.mFirstTime = false;
                    mediatorLiveData.setValue(x);
                }
            }
        });
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull final Function<X, Y> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() {
            /* class androidx.lifecycle.Transformations.AnonymousClass1 */

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable X x) {
                mediatorLiveData.setValue(function.apply(x));
            }
        });
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull final Function<X, LiveData<Y>> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() {
            /* class androidx.lifecycle.Transformations.AnonymousClass2 */
            LiveData<Y> mSource;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable X x) {
                LiveData<Y> liveData = (LiveData) function.apply(x);
                LiveData<Y> liveData2 = this.mSource;
                if (liveData2 != liveData) {
                    if (liveData2 != null) {
                        mediatorLiveData.removeSource(liveData2);
                    }
                    this.mSource = liveData;
                    if (liveData != null) {
                        mediatorLiveData.addSource(liveData, new Observer<Y>() {
                            /* class androidx.lifecycle.Transformations.AnonymousClass2.AnonymousClass1 */

                            @Override // androidx.lifecycle.Observer
                            public void onChanged(@Nullable Y y) {
                                mediatorLiveData.setValue(y);
                            }
                        });
                    }
                }
            }
        });
        return mediatorLiveData;
    }
}
