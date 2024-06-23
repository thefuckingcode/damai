package com.youku.live.livesdk.preloader.templates;

import com.youku.live.widgets.model.template.TemplateModel;

/* compiled from: Taobao */
public interface ITemplate {
    String getLandscapeLayout();

    TemplateModel getLandscapeModel();

    String getPortraitLayout();

    TemplateModel getPortraitModel();

    void init();
}
