package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class NoEndIconDelegate extends EndIconDelegate {
    NoEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconDrawable((Drawable) null);
        this.textInputLayout.setEndIconContentDescription((CharSequence) null);
    }
}
