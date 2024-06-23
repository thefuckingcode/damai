package com.taobao.tao.log.godeye.api.command;

import com.taobao.tao.log.godeye.api.control.AbsCommandController;

/* compiled from: Taobao */
public interface ICommandManager {
    TraceTask getRawCommandString(AbsCommandController absCommandController);

    void removeLocalCommand(AbsCommandController absCommandController);

    void saveRawCommandString(AbsCommandController absCommandController, TraceTask traceTask);
}
