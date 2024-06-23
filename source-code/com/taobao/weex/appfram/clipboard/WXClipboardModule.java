package com.taobao.weex.appfram.clipboard;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.content.ClipboardManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXLogUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* compiled from: Taobao */
public class WXClipboardModule extends WXModule implements IWXClipboard {
    private static final String DATA = "data";
    private static final String RESULT = "result";
    private static final String RESULT_FAILED = "failed";
    private static final String RESULT_OK = "success";
    private final String CLIP_KEY = "WEEX_CLIP_KEY_MAIN";

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0069, code lost:
        if (r7 == null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0086, code lost:
        if (r7 == null) goto L_0x0089;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0064 A[SYNTHETIC, Splitter:B:38:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0073 A[SYNTHETIC, Splitter:B:47:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x007a A[SYNTHETIC, Splitter:B:51:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0081 A[SYNTHETIC, Splitter:B:58:0x0081] */
    @Nullable
    private CharSequence coerceToText(Context context, ClipData.Item item) {
        Uri uri;
        FileInputStream fileInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        IOException e;
        CharSequence text = item.getText();
        if (text != null) {
            return text;
        }
        uri = item.getUri();
        InputStreamReader inputStreamReader2 = null;
        if (uri != null) {
            try {
                fileInputStream = context.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null).createInputStream();
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                } catch (FileNotFoundException unused) {
                    if (inputStreamReader2 != null) {
                    }
                } catch (IOException e2) {
                    e = e2;
                    inputStreamReader = null;
                    try {
                        WXLogUtils.w("ClippedData Failure loading text.", e);
                        if (inputStreamReader != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader2 = inputStreamReader;
                        if (inputStreamReader2 != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
                try {
                    StringBuilder sb = new StringBuilder(128);
                    char[] cArr = new char[8192];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read <= 0) {
                            break;
                        }
                        sb.append(cArr, 0, read);
                    }
                    String sb2 = sb.toString();
                    try {
                        inputStreamReader.close();
                    } catch (IOException unused4) {
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    return sb2;
                } catch (FileNotFoundException unused6) {
                    inputStreamReader2 = inputStreamReader;
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (IOException unused7) {
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    WXLogUtils.w("ClippedData Failure loading text.", e);
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException unused8) {
                        }
                    }
                }
            } catch (FileNotFoundException unused9) {
                fileInputStream = null;
                if (inputStreamReader2 != null) {
                }
            } catch (IOException e4) {
                inputStreamReader = null;
                e = e4;
                fileInputStream = null;
                WXLogUtils.w("ClippedData Failure loading text.", e);
                if (inputStreamReader != null) {
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                if (inputStreamReader2 != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } else {
            Intent intent = item.getIntent();
            if (intent != null) {
                return intent.toUri(1);
            }
            return null;
        }
        return uri.toString();
    }

    @Override // com.taobao.weex.appfram.clipboard.IWXClipboard
    @JSMethod
    public void getString(@Nullable JSCallback jSCallback) {
        Context context = this.mWXSDKInstance.getContext();
        HashMap hashMap = new HashMap(2);
        ClipData primaryClip = ClipboardManager.getPrimaryClip((android.content.ClipboardManager) context.getSystemService("clipboard"));
        CharSequence charSequence = "";
        String str = "failed";
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            hashMap.put("result", str);
            hashMap.put("data", charSequence);
        } else {
            CharSequence coerceToText = coerceToText(context, primaryClip.getItemAt(0));
            if (coerceToText != null) {
                str = "success";
            }
            hashMap.put("result", str);
            if (coerceToText != null) {
                charSequence = coerceToText;
            }
            hashMap.put("data", charSequence);
        }
        if (jSCallback != null) {
            jSCallback.invoke(hashMap);
        }
    }

    @Override // com.taobao.weex.appfram.clipboard.IWXClipboard
    @JSMethod
    public void setString(String str) {
        if (str != null) {
            ((android.content.ClipboardManager) this.mWXSDKInstance.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("WEEX_CLIP_KEY_MAIN", str));
        }
    }
}
