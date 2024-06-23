package me.yokeyword.fragmentation.anim;

import android.os.Parcel;
import android.os.Parcelable;
import me.yokeyword.fragmentation.R;

public class DefaultVerticalAnimator extends FragmentAnimator implements Parcelable {
    public static final Parcelable.Creator<DefaultVerticalAnimator> CREATOR = new Parcelable.Creator<DefaultVerticalAnimator>() {
        /* class me.yokeyword.fragmentation.anim.DefaultVerticalAnimator.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public DefaultVerticalAnimator createFromParcel(Parcel parcel) {
            return new DefaultVerticalAnimator(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DefaultVerticalAnimator[] newArray(int i) {
            return new DefaultVerticalAnimator[i];
        }
    };

    @Override // me.yokeyword.fragmentation.anim.FragmentAnimator
    public int describeContents() {
        return 0;
    }

    public DefaultVerticalAnimator() {
        this.enter = R.anim.v_fragment_enter;
        this.exit = R.anim.v_fragment_exit;
        this.popEnter = R.anim.v_fragment_pop_enter;
        this.popExit = R.anim.v_fragment_pop_exit;
    }

    protected DefaultVerticalAnimator(Parcel parcel) {
        super(parcel);
    }

    @Override // me.yokeyword.fragmentation.anim.FragmentAnimator
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
