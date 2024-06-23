package com.youku.skinmanager.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class SkinResourceUtils {
    @Nullable
    public static Integer getColor(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (!TextUtils.isEmpty(string)) {
                if (!string.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                    string = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + string;
                }
                return Integer.valueOf(Color.parseColor(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static Drawable getDrawable(Context context, String str) {
        Bitmap decodeFile;
        if (TextUtils.isEmpty(str) || !str.endsWith(".png") || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        decodeFile.setDensity(320);
        return new BitmapDrawable(context.getResources(), decodeFile);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0052 A[SYNTHETIC, Splitter:B:28:0x0052] */
    public static String getJson(String str) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Exception e;
        StringBuilder sb = new StringBuilder();
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                bufferedInputStream.close();
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                    }
                    return sb.toString();
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                    }
                    throw th;
                }
            }
            return sb.toString();
        } catch (Exception e4) {
            e = e4;
            bufferedInputStream = null;
            e.printStackTrace();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return sb.toString();
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static ColorStateList makeColorList(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{i, i2});
    }
}
