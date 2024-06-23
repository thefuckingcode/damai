package me.yokeyword.fragmentation.anim;

import android.os.Parcel;
import android.os.Parcelable;
import me.yokeyword.fragmentation.R;

public class DefaultHorizontalAnimator extends FragmentAnimator implements Parcelable {
    public static final Parcelable.Creator<DefaultHorizontalAnimator> CREATOR = new Parcelable.Creator<DefaultHorizontalAnimator>() {
        /* class me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public DefaultHorizontalAnimator createFromParcel(Parcel parcel) {
            return new DefaultHorizontalAnimator(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DefaultHorizontalAnimator[] newArray(int i) {
            return new DefaultHorizontalAnimator[i];
        }
    };

    @Override // me.yokeyword.fragmentation.anim.FragmentAnimator
    public int describeContents() {
        return 0;
    }

    public DefaultHorizontalAnimator() {
        this.enter = R.anim.h_fragment_enter;
        this.exit = R.anim.h_fragment_exit;
        this.popEnter = R.anim.h_fragment_pop_enter;
        this.popExit = R.anim.h_fragment_pop_exit;
    }

    protected DefaultHorizontalAnimator(Parcel parcel) {
        super(parcel);
    }

    @Override // me.yokeyword.fragmentation.anim.FragmentAnimator
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
