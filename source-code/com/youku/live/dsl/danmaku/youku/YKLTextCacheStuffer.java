package com.youku.live.dsl.danmaku.youku;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.android.AndroidDisplayer;
import com.youku.danmaku.engine.danmaku.model.danmaku.SpecialDanmaku;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class YKLTextCacheStuffer extends SimpleTextCacheStuffer {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final Map<Float, Float> sTextHeightCache = new HashMap();

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer, com.youku.live.dsl.danmaku.youku.SimpleTextCacheStuffer
    public void clearCaches() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1320671976")) {
            ipChange.ipc$dispatch("-1320671976", new Object[]{this});
            return;
        }
        sTextHeightCache.clear();
    }

    @Override // com.youku.live.dsl.danmaku.youku.SimpleTextCacheStuffer
    public void drawStroke(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545883560")) {
            ipChange.ipc$dispatch("1545883560", new Object[]{this, baseDanmaku, str, canvas, Float.valueOf(f), Float.valueOf(f2), paint});
        } else if (str != null) {
            canvas.drawText(str, f, f2, paint);
        } else {
            CharSequence charSequence = baseDanmaku.text;
            if (charSequence != null) {
                canvas.drawText(charSequence.toString(), f, f2, paint);
            }
        }
    }

    @Override // com.youku.live.dsl.danmaku.youku.SimpleTextCacheStuffer
    public void drawText(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "994012812")) {
            ipChange.ipc$dispatch("994012812", new Object[]{this, baseDanmaku, str, canvas, Float.valueOf(f), Float.valueOf(f2), textPaint, Boolean.valueOf(z)});
            return;
        }
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.set(textPaint);
        if (z && (baseDanmaku instanceof SpecialDanmaku)) {
            textPaint2.setAlpha(255);
        }
        if (str != null) {
            canvas.drawText(str, f, f2, textPaint2);
            return;
        }
        CharSequence charSequence = baseDanmaku.text;
        if (charSequence != null) {
            canvas.drawText(charSequence.toString(), f, f2, textPaint2);
        }
    }

    /* access modifiers changed from: protected */
    public Float getCacheHeight(BaseDanmaku baseDanmaku, Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1903538417")) {
            return (Float) ipChange.ipc$dispatch("-1903538417", new Object[]{this, baseDanmaku, paint});
        }
        Float valueOf = Float.valueOf(paint.getTextSize());
        Map<Float, Float> map = sTextHeightCache;
        Float f = map.get(valueOf);
        if (f != null) {
            return f;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        Float valueOf2 = Float.valueOf((fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading);
        map.put(valueOf, valueOf2);
        return valueOf2;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer, com.youku.live.dsl.danmaku.youku.SimpleTextCacheStuffer
    public void measure(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339110934")) {
            ipChange.ipc$dispatch("339110934", new Object[]{this, baseDanmaku, textPaint, Boolean.valueOf(z), displayConfig});
            return;
        }
        float f = 0.0f;
        Float valueOf = Float.valueOf(0.0f);
        if (baseDanmaku.lines == null) {
            CharSequence charSequence = baseDanmaku.text;
            if (charSequence != null) {
                f = textPaint.measureText(charSequence.toString());
                valueOf = getCacheHeight(baseDanmaku, textPaint);
            }
            baseDanmaku.paintWidth = f;
            baseDanmaku.paintHeight = valueOf.floatValue();
            return;
        }
        Float cacheHeight = getCacheHeight(baseDanmaku, textPaint);
        String[] strArr = baseDanmaku.lines;
        for (String str : strArr) {
            if (str.length() > 0) {
                f = Math.max(textPaint.measureText(str), f);
            }
        }
        baseDanmaku.paintWidth = f;
        baseDanmaku.paintHeight = ((float) baseDanmaku.lines.length) * cacheHeight.floatValue();
    }
}
