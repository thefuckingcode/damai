package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@IgnoreJRERequirement
/* compiled from: Taobao */
enum FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator implements FuturesGetChecked.GetCheckedTypeValidator {
    INSTANCE;
    
    private static final ClassValue<Boolean> isValidClass = new a();

    /* compiled from: Taobao */
    static class a extends ClassValue<Boolean> {
        a() {
        }
    }

    @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
    public void validateClass(Class<? extends Exception> cls) {
        isValidClass.get(cls);
    }
}
