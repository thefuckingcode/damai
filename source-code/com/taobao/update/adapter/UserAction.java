package com.taobao.update.adapter;

/* compiled from: Taobao */
public interface UserAction {
    String getCancelText();

    String getConfirmText();

    String getTitleText();

    void onCancel();

    void onConfirm();
}
