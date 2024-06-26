package com.taobao.accs.utl;

/* compiled from: Taobao */
public class HuaWeiRomCollecter extends RomInfoCollecter {
    @Override // com.taobao.accs.utl.RomInfoCollecter
    public String collect() {
        RomInfoCollecter romInfoCollecter;
        String emuiVersion = UtilityImpl.getEmuiVersion();
        return (emuiVersion != null || (romInfoCollecter = this.mNextCollecter) == null) ? emuiVersion : romInfoCollecter.collect();
    }
}
