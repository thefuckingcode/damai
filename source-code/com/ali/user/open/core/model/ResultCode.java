package com.ali.user.open.core.model;

import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.open.core.message.Message;
import com.ali.user.open.core.message.MessageUtils;

/* compiled from: Taobao */
public class ResultCode {
    public static final ResultCode CAPTCHA_RELOGIN = new ResultCode(103, "CAPTCHA_RELOGIN");
    public static final ResultCode CHECK = new ResultCode(108, "CHECK");
    public static final ResultCode CONTINUE_LOGIN = new ResultCode(105, "continueLogin");
    public static final ResultCode IGNORE = new ResultCode(-100, "IGNORE");
    public static final ResultCode SUCCESS = new ResultCode(100, "SUCCESS");
    public static final ResultCode SYSTEM_EXCEPTION = new ResultCode(10010, "SYSTEM_EXCEPTION");
    public static final ResultCode TRUST_LOGIN = new ResultCode(104, "TRUST_LOGIN");
    public static final ResultCode USER_CANCEL = new ResultCode(10003, LoginConstant.FETCH_IV_FAIL_CANCEL);
    public int code;
    public String message;

    public ResultCode(int i) {
        this(i, null);
    }

    public static ResultCode create(Message message2) {
        return new ResultCode(message2.code, message2.message);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.code == ((ResultCode) obj).code;
    }

    public int hashCode() {
        return 31 + this.code;
    }

    public boolean isSuccess() {
        return this.code == 100;
    }

    public ResultCode(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public static ResultCode create(int i, Object... objArr) {
        return new ResultCode(i, MessageUtils.getMessageContent(i, objArr));
    }
}
