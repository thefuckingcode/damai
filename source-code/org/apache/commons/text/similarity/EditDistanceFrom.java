package org.apache.commons.text.similarity;

import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
public class EditDistanceFrom<R> {
    private final EditDistance<R> editDistance;
    private final CharSequence left;

    public EditDistanceFrom(EditDistance<R> editDistance2, CharSequence charSequence) {
        Validate.isTrue(editDistance2 != null, "The edit distance may not be null.", new Object[0]);
        this.editDistance = editDistance2;
        this.left = charSequence;
    }

    public R apply(CharSequence charSequence) {
        return this.editDistance.apply(this.left, charSequence);
    }

    public EditDistance<R> getEditDistance() {
        return this.editDistance;
    }

    public CharSequence getLeft() {
        return this.left;
    }
}
