package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.util.UIUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class LevelStatic {
    private static transient /* synthetic */ IpChange $ipChange;
    private static LevelStatic instance;
    private float density = UIUtil.getResources().getDisplayMetrics().density;
    private Map<String, Bitmap> mSource = new HashMap();

    private LevelStatic() {
    }

    public static LevelStatic getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1779503189")) {
            return (LevelStatic) ipChange.ipc$dispatch("1779503189", new Object[0]);
        }
        if (instance == null) {
            synchronized (LevelStatic.class) {
                if (instance == null) {
                    instance = new LevelStatic();
                }
            }
        }
        return instance;
    }

    public static Integer safeValueOf(String str, Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "566248881")) {
            return (Integer) ipChange.ipc$dispatch("566248881", new Object[]{str, num});
        } else if (str == null) {
            return num;
        } else {
            try {
                if (!"".equals(str)) {
                    return Integer.valueOf(str);
                }
                return num;
            } catch (Exception e) {
                e.printStackTrace();
                return num;
            }
        }
    }

    public Bitmap getAnchorLevelById(String str) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883208777")) {
            return (Bitmap) ipChange.ipc$dispatch("883208777", new Object[]{this, str});
        }
        Map<String, Bitmap> map = this.mSource;
        if (map.get("a_lv_" + str) == null) {
            try {
                float f = this.density;
                if (f < 1.5f) {
                    bitmap = BitmapFactory.decodeFile(LFFilePathUtils.getInstance().getAnchorlevelDirPath() + File.separator + str);
                } else if (f < 1.5f || f >= 2.5f) {
                    bitmap = BitmapFactory.decodeFile(LFFilePathUtils.getInstance().getAnchorlevelDirPath() + File.separator + str + "@3x");
                } else {
                    bitmap = BitmapFactory.decodeFile(LFFilePathUtils.getInstance().getAnchorlevelDirPath() + File.separator + str + "@2x");
                }
                if (bitmap != null) {
                    Map<String, Bitmap> map2 = this.mSource;
                    map2.put("a_lv_" + str, bitmap);
                }
            } catch (Exception unused) {
            }
        }
        Map<String, Bitmap> map3 = this.mSource;
        return map3.get("a_lv_" + str);
    }

    public Bitmap getUserLevelById(String str) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1644744223")) {
            return (Bitmap) ipChange.ipc$dispatch("1644744223", new Object[]{this, str});
        } else if (safeValueOf(str, 0).intValue() <= 0) {
            return null;
        } else {
            Map<String, Bitmap> map = this.mSource;
            if (map.get("user_lv_" + str) == null) {
                try {
                    float f = this.density;
                    if (f < 1.5f) {
                        bitmap = BitmapFactory.decodeFile(LFFilePathUtils.getInstance().getUserlevelDirPath() + File.separator + str);
                    } else if (f < 1.5f || f >= 2.5f) {
                        bitmap = BitmapFactory.decodeFile(LFFilePathUtils.getInstance().getUserlevelDirPath() + File.separator + str + "@3x");
                    } else {
                        bitmap = BitmapFactory.decodeFile(LFFilePathUtils.getInstance().getUserlevelDirPath() + File.separator + str + "@2x");
                    }
                    if (bitmap != null) {
                        Map<String, Bitmap> map2 = this.mSource;
                        map2.put("user_lv_" + str, bitmap);
                    }
                } catch (Exception unused) {
                }
            }
            Map<String, Bitmap> map3 = this.mSource;
            return map3.get("user_lv_" + str);
        }
    }
}
