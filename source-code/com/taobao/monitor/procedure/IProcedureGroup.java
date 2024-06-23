package com.taobao.monitor.procedure;

/* compiled from: Taobao */
public interface IProcedureGroup extends IProcedure {
    void addSubProcedure(IProcedure iProcedure);

    void removeSubProcedure(IProcedure iProcedure);
}
