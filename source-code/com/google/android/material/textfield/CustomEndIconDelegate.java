package com.google.android.material.textfield;

import androidx.annotation.NonNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class CustomEndIconDelegate extends EndIconDelegate {
    CustomEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconOnLongClickListener(null);
    }
}
