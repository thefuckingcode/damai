package com.youku.danmaku.engine.danmaku.model.android.stuffer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuEngineContext;
import com.youku.danmaku.engine.danmaku.model.android.AndroidDisplayer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;

/* compiled from: Taobao */
public class SimpleTextCacheStuffer extends BaseCacheStuffer {
    private Float getCacheHeight(BaseDanmaku baseDanmaku, Paint paint, IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        float density = DanmakuEngineContext.getDensity() * 24.0f;
        if (iDanmakuSettingPlugin != null) {
            density = iDanmakuSettingPlugin.getLineHeight();
        }
        return Float.valueOf(density);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void clearCaches() {
    }

    /* access modifiers changed from: protected */
    public void drawBackground(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, AndroidDisplayer.DisplayConfig displayConfig) {
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void drawDanmaku(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        float f3;
        float f4;
        float f5;
        float f6;
        String[] strArr;
        int i;
        float f7;
        int i2;
        float f8;
        float f9;
        boolean z2;
        float f10;
        float f11;
        displayConfig.definePaintParams(z);
        TextPaint paint = displayConfig.getPaint(baseDanmaku, !z);
        drawBackground(baseDanmaku, canvas, f, f2, displayConfig);
        float density = DanmakuEngineContext.getDensity() * 24.0f;
        float density2 = DanmakuEngineContext.getDensity() * 6.0f;
        IDanmakuSettingPlugin danmakuSettingPlugin = displayConfig.getDanmakuSettingPlugin();
        if (danmakuSettingPlugin != null) {
            density = danmakuSettingPlugin.getLineHeight();
            density2 = danmakuSettingPlugin.getLineSpace();
        }
        float f12 = density / 2.0f;
        float f13 = f2 + (density2 / 2.0f);
        if (baseDanmaku.borderColor != 0 || baseDanmaku.ykHasBorder) {
            f3 = f + displayConfig.BORDER_WIDTH + f12;
        } else {
            f3 = f;
        }
        String[] strArr2 = baseDanmaku.lines;
        boolean z3 = true;
        if (strArr2 == null) {
            f4 = f13;
            if (displayConfig.hasStroke(baseDanmaku)) {
                displayConfig.applyPaintConfig(baseDanmaku, paint, true);
                float textBaseLine = DanmakuUtils.getTextBaseLine(paint, f4, density);
                if (displayConfig.HAS_PROJECTION) {
                    f5 = textBaseLine + displayConfig.sProjectionOffsetY;
                    f6 = f3 + displayConfig.sProjectionOffsetX;
                } else {
                    f5 = textBaseLine;
                    f6 = f3;
                }
                drawStroke(baseDanmaku, null, canvas, f6, f5, paint);
            }
            displayConfig.applyPaintConfig(baseDanmaku, paint, false);
            drawText(baseDanmaku, null, canvas, f3, f4, paint, z, density);
        } else if (strArr2.length == 1) {
            if (displayConfig.hasStroke(baseDanmaku)) {
                displayConfig.applyPaintConfig(baseDanmaku, paint, true);
                float ascent = f13 - paint.ascent();
                if (displayConfig.HAS_PROJECTION) {
                    f10 = ascent + displayConfig.sProjectionOffsetY;
                    f11 = f3 + displayConfig.sProjectionOffsetX;
                } else {
                    f10 = ascent;
                    f11 = f3;
                }
                z2 = false;
                drawStroke(baseDanmaku, strArr2[0], canvas, f11, f10, paint);
            } else {
                z2 = false;
            }
            displayConfig.applyPaintConfig(baseDanmaku, paint, z2);
            char c = z2 ? 1 : 0;
            char c2 = z2 ? 1 : 0;
            char c3 = z2 ? 1 : 0;
            drawText(baseDanmaku, strArr2[c], canvas, f3, f13 - paint.ascent(), paint, z, density);
            f4 = f13;
        } else {
            boolean z4 = false;
            float length = (baseDanmaku.paintHeight - ((float) (baseDanmaku.padding * 2))) / ((float) strArr2.length);
            int i3 = 0;
            while (i3 < strArr2.length) {
                if (strArr2[i3] == null || strArr2[i3].length() == 0) {
                    i = i3;
                    strArr = strArr2;
                    f7 = f13;
                } else {
                    if (displayConfig.hasStroke(baseDanmaku)) {
                        displayConfig.applyPaintConfig(baseDanmaku, paint, z3);
                        float ascent2 = ((((float) i3) * length) + f13) - paint.ascent();
                        if (displayConfig.HAS_PROJECTION) {
                            f8 = ascent2 + displayConfig.sProjectionOffsetY;
                            f9 = f3 + displayConfig.sProjectionOffsetX;
                        } else {
                            f8 = ascent2;
                            f9 = f3;
                        }
                        i2 = i3;
                        drawStroke(baseDanmaku, strArr2[i3], canvas, f9, f8, paint);
                    } else {
                        i2 = i3;
                    }
                    displayConfig.applyPaintConfig(baseDanmaku, paint, z4);
                    i = i2;
                    strArr = strArr2;
                    f7 = f13;
                    drawText(baseDanmaku, strArr2[i2], canvas, f3, ((((float) i2) * length) + f13) - paint.ascent(), paint, z, density);
                }
                i3 = i + 1;
                f13 = f7;
                strArr2 = strArr;
                z3 = true;
                z4 = false;
            }
            f4 = f13;
        }
        if (baseDanmaku.underlineColor != 0) {
            Paint underlinePaint = displayConfig.getUnderlinePaint(baseDanmaku);
            float f14 = (f2 + baseDanmaku.paintHeight) - ((float) displayConfig.UNDERLINE_HEIGHT);
            canvas.drawLine(f, f14, f + baseDanmaku.paintWidth, f14, underlinePaint);
        }
        if (baseDanmaku.borderColor != 0 || baseDanmaku.ykHasBorder) {
            float f15 = displayConfig.BORDER_WIDTH / 2.0f;
            canvas.drawRoundRect(new RectF(f + f15, f4 - f15, (f + baseDanmaku.paintWidth) - f15, f4 + density + f15), f12, f12, displayConfig.getBorderPaint(baseDanmaku));
        }
    }

    /* access modifiers changed from: protected */
    public void drawStroke(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, Paint paint) {
        if (str != null) {
            canvas.drawText(str, f, f2, paint);
        } else if (!TextUtils.isEmpty(baseDanmaku.text)) {
            canvas.drawText(baseDanmaku.text.toString(), f, f2, paint);
        }
    }

    /* access modifiers changed from: protected */
    public void drawText(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z) {
        float textBaseLine = DanmakuUtils.getTextBaseLine(textPaint, f2, DanmakuEngineContext.getDensity() * 24.0f);
        if (str != null) {
            canvas.drawText(str, f, textBaseLine, textPaint);
        } else if (!TextUtils.isEmpty(baseDanmaku.text)) {
            canvas.drawText(baseDanmaku.text.toString(), f, textBaseLine, textPaint);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
    public void measure(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        float f = 0.0f;
        Float valueOf = Float.valueOf(0.0f);
        if (baseDanmaku.lines == null) {
            CharSequence charSequence = baseDanmaku.text;
            if (charSequence != null) {
                f = textPaint.measureText(charSequence.toString());
                valueOf = getCacheHeight(baseDanmaku, textPaint, displayConfig.getDanmakuSettingPlugin());
            }
            baseDanmaku.paintWidth = f;
            baseDanmaku.paintHeight = valueOf.floatValue();
            return;
        }
        Float cacheHeight = getCacheHeight(baseDanmaku, textPaint, displayConfig.getDanmakuSettingPlugin());
        String[] strArr = baseDanmaku.lines;
        for (String str : strArr) {
            if (str.length() > 0) {
                f = Math.max(textPaint.measureText(str), f);
            }
        }
        baseDanmaku.paintWidth = f;
        baseDanmaku.paintHeight = ((float) baseDanmaku.lines.length) * cacheHeight.floatValue();
    }

    /* access modifiers changed from: protected */
    public void drawText(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z, float f3) {
        float textBaseLine = DanmakuUtils.getTextBaseLine(textPaint, f2, f3);
        if (str != null) {
            canvas.drawText(str, f, textBaseLine, textPaint);
        } else if (!TextUtils.isEmpty(baseDanmaku.text)) {
            canvas.drawText(baseDanmaku.text.toString(), f, textBaseLine, textPaint);
        }
    }
}
