package com.alibaba.android.ultron.vfw.template;

import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.List;
import tb.mc0;

/* compiled from: Taobao */
public interface ITemplateProvider {
    boolean checkTemplate(IDMComponent iDMComponent);

    void downloadTemplates(List<mc0> list, TemplateDownloadListener templateDownloadListener);
}
