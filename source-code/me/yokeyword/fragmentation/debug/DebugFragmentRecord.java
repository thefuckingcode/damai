package me.yokeyword.fragmentation.debug;

import java.util.List;

public class DebugFragmentRecord {
    public List<DebugFragmentRecord> childFragmentRecord;
    public CharSequence fragmentName;

    public DebugFragmentRecord(CharSequence charSequence, List<DebugFragmentRecord> list) {
        this.fragmentName = charSequence;
        this.childFragmentRecord = list;
    }
}
