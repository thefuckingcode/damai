package com.taobao.tao.log.task;

import com.taobao.android.tlog.protocol.model.CommandInfo;

/* compiled from: Taobao */
public interface ICommandTask {
    ICommandTask execute(CommandInfo commandInfo);
}
