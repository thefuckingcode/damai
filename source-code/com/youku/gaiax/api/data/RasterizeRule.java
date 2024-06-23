package com.youku.gaiax.api.data;

import android.content.Context;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSONObject;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/youku/gaiax/api/data/RasterizeRule;", "", "<init>", "()V", org.android.agoo.common.Config.TAG, UTConstans.CustomEvent.UT_REG_RESULT, "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class RasterizeRule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010(\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\"\u0010+\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010 \u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\"\u0010.\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$¨\u00063"}, d2 = {"Lcom/youku/gaiax/api/data/RasterizeRule$Config;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Lcom/alibaba/fastjson/JSONObject;", "rawJson", "Lcom/alibaba/fastjson/JSONObject;", "getRawJson", "()Lcom/alibaba/fastjson/JSONObject;", "setRawJson", "(Lcom/alibaba/fastjson/JSONObject;)V", "", "ruleName", "Ljava/lang/String;", "getRuleName", "()Ljava/lang/String;", "setRuleName", "(Ljava/lang/String;)V", "", "screenWidth", UTConstant.Args.UT_SUCCESS_F, "getScreenWidth", "()F", "setScreenWidth", "(F)V", "", "edgeLeft", "I", "getEdgeLeft", "()I", "setEdgeLeft", "(I)V", "edgeRight", "getEdgeRight", "setEdgeRight", "edgeTop", "getEdgeTop", "setEdgeTop", "edgeBottom", "getEdgeBottom", "setEdgeBottom", "lineSpacing", "getLineSpacing", "setLineSpacing", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Config {
        @Nullable
        private Context context;
        private int edgeBottom;
        private int edgeLeft;
        private int edgeRight;
        private int edgeTop;
        private int lineSpacing;
        @Nullable
        private JSONObject rawJson;
        @Nullable
        private String ruleName;
        private float screenWidth;

        @Nullable
        public final Context getContext() {
            return this.context;
        }

        public final int getEdgeBottom() {
            return this.edgeBottom;
        }

        public final int getEdgeLeft() {
            return this.edgeLeft;
        }

        public final int getEdgeRight() {
            return this.edgeRight;
        }

        public final int getEdgeTop() {
            return this.edgeTop;
        }

        public final int getLineSpacing() {
            return this.lineSpacing;
        }

        @Nullable
        public final JSONObject getRawJson() {
            return this.rawJson;
        }

        @Nullable
        public final String getRuleName() {
            return this.ruleName;
        }

        public final float getScreenWidth() {
            return this.screenWidth;
        }

        public final void setContext(@Nullable Context context2) {
            this.context = context2;
        }

        public final void setEdgeBottom(int i) {
            this.edgeBottom = i;
        }

        public final void setEdgeLeft(int i) {
            this.edgeLeft = i;
        }

        public final void setEdgeRight(int i) {
            this.edgeRight = i;
        }

        public final void setEdgeTop(int i) {
            this.edgeTop = i;
        }

        public final void setLineSpacing(int i) {
            this.lineSpacing = i;
        }

        public final void setRawJson(@Nullable JSONObject jSONObject) {
            this.rawJson = jSONObject;
        }

        public final void setRuleName(@Nullable String str) {
            this.ruleName = str;
        }

        public final void setScreenWidth(float f) {
            this.screenWidth = f;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/api/data/RasterizeRule$Result;", "", "", "width", "Ljava/lang/Float;", "getWidth", "()Ljava/lang/Float;", "height", "getHeight", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;)V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Result {
        @Nullable
        private final Float height;
        @Nullable
        private final Float width;

        public Result(@Nullable Float f, @Nullable Float f2) {
            this.width = f;
            this.height = f2;
        }

        @Nullable
        public final Float getHeight() {
            return this.height;
        }

        @Nullable
        public final Float getWidth() {
            return this.width;
        }
    }
}
