package com.taobao.accs.utl;

/* compiled from: Taobao */
public abstract class RomInfoCollecter {
    protected RomInfoCollecter mNextCollecter;

    public static RomInfoCollecter getCollecter() {
        return new HuaWeiRomCollecter();
    }

    public abstract String collect();
}
