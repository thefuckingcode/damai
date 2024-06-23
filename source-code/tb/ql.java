package tb;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;

/* compiled from: Taobao */
public final class ql implements Disposable, DisposableContainer {
    OpenHashSet<Disposable> a;
    volatile boolean b;

    public void a() {
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    OpenHashSet<Disposable> openHashSet = this.a;
                    this.a = null;
                    b(openHashSet);
                }
            }
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean add(@NonNull Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "d is null");
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    OpenHashSet<Disposable> openHashSet = this.a;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.a = openHashSet;
                    }
                    openHashSet.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(OpenHashSet<Disposable> openHashSet) {
        if (openHashSet != null) {
            ArrayList arrayList = null;
            Object[] keys = openHashSet.keys();
            for (Object obj : keys) {
                if (obj instanceof Disposable) {
                    try {
                        ((Disposable) obj).dispose();
                    } catch (Throwable th) {
                        ff0.b(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw ExceptionHelper.wrapOrThrow((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }

    public int c() {
        int i = 0;
        if (this.b) {
            return 0;
        }
        synchronized (this) {
            if (this.b) {
                return 0;
            }
            OpenHashSet<Disposable> openHashSet = this.a;
            if (openHashSet != null) {
                i = openHashSet.size();
            }
            return i;
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean delete(@NonNull Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "Disposable item is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            if (this.b) {
                return false;
            }
            OpenHashSet<Disposable> openHashSet = this.a;
            if (openHashSet != null) {
                if (openHashSet.remove(disposable)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    this.b = true;
                    OpenHashSet<Disposable> openHashSet = this.a;
                    this.a = null;
                    b(openHashSet);
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.b;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean remove(@NonNull Disposable disposable) {
        if (!delete(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }
}
