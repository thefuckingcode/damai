package me.yokeyword.fragmentation.anim;

import android.os.Parcel;
import android.os.Parcelable;

public class DefaultNoAnimator extends FragmentAnimator implements Parcelable {
    public static final Parcelable.Creator<DefaultNoAnimator> CREATOR = new Parcelable.Creator<DefaultNoAnimator>() {
        /* class me.yokeyword.fragmentation.anim.DefaultNoAnimator.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public DefaultNoAnimator createFromParcel(Parcel parcel) {
            return new DefaultNoAnimator(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DefaultNoAnimator[] newArray(int i) {
            return new DefaultNoAnimator[i];
        }
    };

    @Override // me.yokeyword.fragmentation.anim.FragmentAnimator
    public int describeContents() {
        return 0;
    }

    public DefaultNoAnimator() {
        this.enter = 0;
        this.exit = 0;
        this.popEnter = 0;
        this.popExit = 0;
    }

    protected DefaultNoAnimator(Parcel parcel) {
        super(parcel);
    }

    @Override // me.yokeyword.fragmentation.anim.FragmentAnimator
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
