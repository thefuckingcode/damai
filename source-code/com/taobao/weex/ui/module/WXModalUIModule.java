package com.taobao.weex.ui.module;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;

/* compiled from: Taobao */
public class WXModalUIModule extends WXSDKEngine.DestroyableModule {
    public static final String CANCEL = "Cancel";
    public static final String CANCEL_TITLE = "cancelTitle";
    public static final String DATA = "data";
    public static final String DEFAULT = "default";
    public static final String DURATION = "duration";
    public static final String MESSAGE = "message";
    public static final String OK = "OK";
    public static final String OK_TITLE = "okTitle";
    public static final String RESULT = "result";
    private Dialog activeDialog;
    private Toast toast;

    private void tracking(Dialog dialog) {
        this.activeDialog = dialog;
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass6 */

            public void onDismiss(DialogInterface dialogInterface) {
                WXModalUIModule.this.activeDialog = null;
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    @JSMethod(uiThread = true)
    public void alert(JSONObject jSONObject, final JSCallback jSCallback) {
        String str;
        String str2;
        Exception e;
        if (this.mWXSDKInstance.getContext() instanceof Activity) {
            final String str3 = OK;
            String str4 = "";
            if (jSONObject != null) {
                try {
                    str2 = jSONObject.getString("message");
                    try {
                        str = jSONObject.getString(OK_TITLE);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    str2 = str4;
                    WXLogUtils.e("[WXModalUIModule] alert param parse error ", e);
                    str = str3;
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
                    builder.setMessage(str4);
                    if (!TextUtils.isEmpty(str)) {
                    }
                    builder.setPositiveButton(str3, new DialogInterface.OnClickListener() {
                        /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass1 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            JSCallback jSCallback = jSCallback;
                            if (jSCallback != null) {
                                jSCallback.invoke(str3);
                            }
                        }
                    });
                    AlertDialog create = builder.create();
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                    tracking(create);
                    return;
                }
            } else {
                str = str3;
                str2 = str4;
            }
            if (!TextUtils.isEmpty(str2)) {
                str4 = str2;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
            builder2.setMessage(str4);
            if (!TextUtils.isEmpty(str)) {
                str3 = str;
            }
            builder2.setPositiveButton(str3, new DialogInterface.OnClickListener() {
                /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass1 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    JSCallback jSCallback = jSCallback;
                    if (jSCallback != null) {
                        jSCallback.invoke(str3);
                    }
                }
            });
            AlertDialog create2 = builder2.create();
            create2.setCanceledOnTouchOutside(false);
            create2.show();
            tracking(create2);
            return;
        }
        WXLogUtils.e("[WXModalUIModule] when call alert mWXSDKInstance.getContext() must instanceof Activity");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c  */
    @JSMethod(uiThread = true)
    public void confirm(JSONObject jSONObject, final JSCallback jSCallback) {
        String str;
        String str2;
        String str3;
        Exception e;
        if (this.mWXSDKInstance.getContext() instanceof Activity) {
            final String str4 = CANCEL;
            final String str5 = OK;
            String str6 = "";
            if (jSONObject != null) {
                try {
                    str3 = jSONObject.getString("message");
                    try {
                        str2 = jSONObject.getString(OK_TITLE);
                        try {
                            str = jSONObject.getString(CANCEL_TITLE);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str2 = str5;
                        WXLogUtils.e("[WXModalUIModule] confirm param parse error ", e);
                        str = str4;
                        if (!TextUtils.isEmpty(str3)) {
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
                        builder.setMessage(str6);
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        if (!TextUtils.isEmpty(str)) {
                        }
                        builder.setPositiveButton(str5, new DialogInterface.OnClickListener() {
                            /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass2 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                JSCallback jSCallback = jSCallback;
                                if (jSCallback != null) {
                                    jSCallback.invoke(str5);
                                }
                            }
                        });
                        builder.setNegativeButton(str4, new DialogInterface.OnClickListener() {
                            /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass3 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                JSCallback jSCallback = jSCallback;
                                if (jSCallback != null) {
                                    jSCallback.invoke(str4);
                                }
                            }
                        });
                        AlertDialog create = builder.create();
                        create.setCanceledOnTouchOutside(false);
                        create.show();
                        tracking(create);
                        return;
                    }
                } catch (Exception e4) {
                    e = e4;
                    str2 = str5;
                    str3 = str6;
                    WXLogUtils.e("[WXModalUIModule] confirm param parse error ", e);
                    str = str4;
                    if (!TextUtils.isEmpty(str3)) {
                    }
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
                    builder2.setMessage(str6);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    if (!TextUtils.isEmpty(str)) {
                    }
                    builder2.setPositiveButton(str5, new DialogInterface.OnClickListener() {
                        /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass2 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            JSCallback jSCallback = jSCallback;
                            if (jSCallback != null) {
                                jSCallback.invoke(str5);
                            }
                        }
                    });
                    builder2.setNegativeButton(str4, new DialogInterface.OnClickListener() {
                        /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass3 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            JSCallback jSCallback = jSCallback;
                            if (jSCallback != null) {
                                jSCallback.invoke(str4);
                            }
                        }
                    });
                    AlertDialog create2 = builder2.create();
                    create2.setCanceledOnTouchOutside(false);
                    create2.show();
                    tracking(create2);
                    return;
                }
            } else {
                str = str4;
                str2 = str5;
                str3 = str6;
            }
            if (!TextUtils.isEmpty(str3)) {
                str6 = str3;
            }
            AlertDialog.Builder builder22 = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
            builder22.setMessage(str6);
            if (!TextUtils.isEmpty(str2)) {
                str5 = str2;
            }
            if (!TextUtils.isEmpty(str)) {
                str4 = str;
            }
            builder22.setPositiveButton(str5, new DialogInterface.OnClickListener() {
                /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass2 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    JSCallback jSCallback = jSCallback;
                    if (jSCallback != null) {
                        jSCallback.invoke(str5);
                    }
                }
            });
            builder22.setNegativeButton(str4, new DialogInterface.OnClickListener() {
                /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass3 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    JSCallback jSCallback = jSCallback;
                    if (jSCallback != null) {
                        jSCallback.invoke(str4);
                    }
                }
            });
            AlertDialog create22 = builder22.create();
            create22.setCanceledOnTouchOutside(false);
            create22.show();
            tracking(create22);
            return;
        }
        WXLogUtils.e("[WXModalUIModule] when call confirm mWXSDKInstance.getContext() must instanceof Activity");
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        Dialog dialog = this.activeDialog;
        if (dialog != null && dialog.isShowing()) {
            this.activeDialog.dismiss();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
    @JSMethod(uiThread = true)
    public void prompt(JSONObject jSONObject, final JSCallback jSCallback) {
        String str;
        String str2;
        String str3;
        String str4;
        Exception e;
        if (this.mWXSDKInstance.getContext() instanceof Activity) {
            final String str5 = CANCEL;
            final String str6 = OK;
            String str7 = "";
            if (jSONObject != null) {
                try {
                    str4 = jSONObject.getString("message");
                    try {
                        str3 = jSONObject.getString(OK_TITLE);
                    } catch (Exception e2) {
                        e = e2;
                        str2 = str5;
                        str3 = str6;
                        WXLogUtils.e("[WXModalUIModule] confirm param parse error ", e);
                        str = str7;
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
                        builder.setMessage(str7);
                        final EditText editText = new EditText(this.mWXSDKInstance.getContext());
                        editText.setText(str);
                        builder.setView(editText);
                        if (!TextUtils.isEmpty(str3)) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        builder.setPositiveButton(str6, new DialogInterface.OnClickListener() {
                            /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass5 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (jSCallback != null) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("result", str6);
                                    hashMap.put("data", editText.getText().toString());
                                    jSCallback.invoke(hashMap);
                                }
                            }
                        }).setNegativeButton(str5, new DialogInterface.OnClickListener() {
                            /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass4 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (jSCallback != null) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("result", str5);
                                    hashMap.put("data", editText.getText().toString());
                                    jSCallback.invoke(hashMap);
                                }
                            }
                        });
                        AlertDialog create = builder.create();
                        create.setCanceledOnTouchOutside(false);
                        create.show();
                        tracking(create);
                        return;
                    }
                    try {
                        str2 = jSONObject.getString(CANCEL_TITLE);
                        try {
                            str = jSONObject.getString("default");
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str2 = str5;
                        WXLogUtils.e("[WXModalUIModule] confirm param parse error ", e);
                        str = str7;
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
                        builder2.setMessage(str7);
                        final EditText editText2 = new EditText(this.mWXSDKInstance.getContext());
                        editText2.setText(str);
                        builder2.setView(editText2);
                        if (!TextUtils.isEmpty(str3)) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        builder2.setPositiveButton(str6, new DialogInterface.OnClickListener() {
                            /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass5 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (jSCallback != null) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("result", str6);
                                    hashMap.put("data", editText2.getText().toString());
                                    jSCallback.invoke(hashMap);
                                }
                            }
                        }).setNegativeButton(str5, new DialogInterface.OnClickListener() {
                            /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass4 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (jSCallback != null) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("result", str5);
                                    hashMap.put("data", editText2.getText().toString());
                                    jSCallback.invoke(hashMap);
                                }
                            }
                        });
                        AlertDialog create2 = builder2.create();
                        create2.setCanceledOnTouchOutside(false);
                        create2.show();
                        tracking(create2);
                        return;
                    }
                } catch (Exception e5) {
                    e = e5;
                    str2 = str5;
                    str3 = str6;
                    str4 = str7;
                    WXLogUtils.e("[WXModalUIModule] confirm param parse error ", e);
                    str = str7;
                    if (!TextUtils.isEmpty(str4)) {
                    }
                    AlertDialog.Builder builder22 = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
                    builder22.setMessage(str7);
                    final EditText editText22 = new EditText(this.mWXSDKInstance.getContext());
                    editText22.setText(str);
                    builder22.setView(editText22);
                    if (!TextUtils.isEmpty(str3)) {
                    }
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    builder22.setPositiveButton(str6, new DialogInterface.OnClickListener() {
                        /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass5 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (jSCallback != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("result", str6);
                                hashMap.put("data", editText22.getText().toString());
                                jSCallback.invoke(hashMap);
                            }
                        }
                    }).setNegativeButton(str5, new DialogInterface.OnClickListener() {
                        /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass4 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (jSCallback != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("result", str5);
                                hashMap.put("data", editText22.getText().toString());
                                jSCallback.invoke(hashMap);
                            }
                        }
                    });
                    AlertDialog create22 = builder22.create();
                    create22.setCanceledOnTouchOutside(false);
                    create22.show();
                    tracking(create22);
                    return;
                }
            } else {
                str2 = str5;
                str3 = str6;
                str = str7;
                str4 = str;
            }
            if (!TextUtils.isEmpty(str4)) {
                str7 = str4;
            }
            AlertDialog.Builder builder222 = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
            builder222.setMessage(str7);
            final EditText editText222 = new EditText(this.mWXSDKInstance.getContext());
            editText222.setText(str);
            builder222.setView(editText222);
            if (!TextUtils.isEmpty(str3)) {
                str6 = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                str5 = str2;
            }
            builder222.setPositiveButton(str6, new DialogInterface.OnClickListener() {
                /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass5 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (jSCallback != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("result", str6);
                        hashMap.put("data", editText222.getText().toString());
                        jSCallback.invoke(hashMap);
                    }
                }
            }).setNegativeButton(str5, new DialogInterface.OnClickListener() {
                /* class com.taobao.weex.ui.module.WXModalUIModule.AnonymousClass4 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (jSCallback != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("result", str5);
                        hashMap.put("data", editText222.getText().toString());
                        jSCallback.invoke(hashMap);
                    }
                }
            });
            AlertDialog create222 = builder222.create();
            create222.setCanceledOnTouchOutside(false);
            create222.show();
            tracking(create222);
            return;
        }
        WXLogUtils.e("when call prompt mWXSDKInstance.getContext() must instanceof Activity");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    @JSMethod(uiThread = true)
    @SuppressLint({"ShowToast"})
    public void toast(JSONObject jSONObject) {
        int i;
        if (this.mWXSDKInstance.getContext() != null) {
            String str = "";
            if (jSONObject != null) {
                try {
                    str = jSONObject.getString("message");
                    if (jSONObject.containsKey("duration")) {
                        i = jSONObject.getInteger("duration").intValue();
                        if (!TextUtils.isEmpty(str)) {
                            WXLogUtils.e("[WXModalUIModule] toast param parse is null ");
                            return;
                        }
                        int i2 = i > 3 ? 1 : 0;
                        Toast toast2 = this.toast;
                        if (toast2 == null) {
                            this.toast = Toast.makeText(this.mWXSDKInstance.getContext(), str, i2);
                        } else {
                            toast2.setDuration(i2);
                            this.toast.setText(str);
                        }
                        this.toast.setGravity(17, 0, 0);
                        this.toast.show();
                        return;
                    }
                } catch (Exception e) {
                    WXLogUtils.e("[WXModalUIModule] alert param parse error ", e);
                }
            }
            i = 0;
            if (!TextUtils.isEmpty(str)) {
            }
        }
    }
}
