package me.yokeyword.fragmentation.anim;

import android.os.Parcel;
import android.os.Parcelable;

public class FragmentAnimator implements Parcelable {
    public static final Parcelable.Creator<FragmentAnimator> CREATOR = new Parcelable.Creator<FragmentAnimator>() {
        /* class me.yokeyword.fragmentation.anim.FragmentAnimator.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public FragmentAnimator createFromParcel(Parcel parcel) {
            return new FragmentAnimator(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FragmentAnimator[] newArray(int i) {
            return new FragmentAnimator[i];
        }
    };
    protected int enter;
    protected int exit;
    protected int popEnter;
    protected int popExit;

    public int describeContents() {
        return 0;
    }

    public FragmentAnimator() {
    }

    public FragmentAnimator(int i, int i2) {
        this.enter = i;
        this.exit = i2;
    }

    public FragmentAnimator(int i, int i2, int i3, int i4) {
        this.enter = i;
        this.exit = i2;
        this.popEnter = i3;
        this.popExit = i4;
    }

    public FragmentAnimator copy() {
        return new FragmentAnimator(getEnter(), getExit(), getPopEnter(), getPopExit());
    }

    protected FragmentAnimator(Parcel parcel) {
        this.enter = parcel.readInt();
        this.exit = parcel.readInt();
        this.popEnter = parcel.readInt();
        this.popExit = parcel.readInt();
    }

    public int getEnter() {
        return this.enter;
    }

    public void setEnter(int i) {
        this.enter = i;
    }

    public int getExit() {
        return this.exit;
    }

    public void setExit(int i) {
        this.exit = i;
    }

    public int getPopEnter() {
        return this.popEnter;
    }

    public void setPopEnter(int i) {
        this.popEnter = i;
    }

    public int getPopExit() {
        return this.popExit;
    }

    public void setPopExit(int i) {
        this.popExit = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.enter);
        parcel.writeInt(this.exit);
        parcel.writeInt(this.popEnter);
        parcel.writeInt(this.popExit);
    }
}
