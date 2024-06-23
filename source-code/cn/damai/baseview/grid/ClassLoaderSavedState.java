package cn.damai.baseview.grid;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class ClassLoaderSavedState implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ClassLoaderSavedState> CREATOR = new a();
    public static final ClassLoaderSavedState EMPTY_STATE = new ClassLoaderSavedState() {
        /* class cn.damai.baseview.grid.ClassLoaderSavedState.AnonymousClass1 */
    };
    private ClassLoader mClassLoader;
    private Parcelable mSuperState;

    /* compiled from: Taobao */
    public static final class a implements Parcelable.Creator<ClassLoaderSavedState> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public ClassLoaderSavedState createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1436600116")) {
                return (ClassLoaderSavedState) ipChange.ipc$dispatch("-1436600116", new Object[]{this, parcel});
            } else if (parcel.readParcelable(null) == null) {
                return ClassLoaderSavedState.EMPTY_STATE;
            } else {
                throw new IllegalStateException("superState must be null");
            }
        }

        /* renamed from: b */
        public ClassLoaderSavedState[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1982922631")) {
                return new ClassLoaderSavedState[i];
            }
            return (ClassLoaderSavedState[]) ipChange.ipc$dispatch("-1982922631", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1192205517")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1192205517", new Object[]{this})).intValue();
    }

    public final Parcelable getSuperState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "82361762")) {
            return this.mSuperState;
        }
        return (Parcelable) ipChange.ipc$dispatch("82361762", new Object[]{this});
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "754596766")) {
            ipChange.ipc$dispatch("754596766", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.mSuperState, i);
    }

    private ClassLoaderSavedState() {
        this.mSuperState = EMPTY_STATE;
        this.mSuperState = null;
        this.mClassLoader = null;
    }

    protected ClassLoaderSavedState(Parcelable parcelable, ClassLoader classLoader) {
        ClassLoaderSavedState classLoaderSavedState = EMPTY_STATE;
        this.mSuperState = classLoaderSavedState;
        this.mClassLoader = classLoader;
        if (parcelable != null) {
            this.mSuperState = parcelable == classLoaderSavedState ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.os.Parcelable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    protected ClassLoaderSavedState(Parcel parcel) {
        ClassLoaderSavedState classLoaderSavedState = EMPTY_STATE;
        this.mSuperState = classLoaderSavedState;
        ?? readParcelable = parcel.readParcelable(this.mClassLoader);
        this.mSuperState = readParcelable != 0 ? readParcelable : classLoaderSavedState;
    }
}
