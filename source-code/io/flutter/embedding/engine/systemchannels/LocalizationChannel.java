package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class LocalizationChannel {
    private static final String TAG = "LocalizationChannel";
    @NonNull
    public final MethodChannel channel;
    @NonNull
    @VisibleForTesting
    public final MethodChannel.MethodCallHandler handler;
    @Nullable
    private LocalizationMessageHandler localizationMessageHandler;

    /* compiled from: Taobao */
    public interface LocalizationMessageHandler {
        String getStringResource(@NonNull String str, String str2);
    }

    public LocalizationChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r0 = new MethodChannel.MethodCallHandler() {
            /* class io.flutter.embedding.engine.systemchannels.LocalizationChannel.AnonymousClass1 */

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                if (LocalizationChannel.this.localizationMessageHandler != null) {
                    String str = methodCall.method;
                    str.hashCode();
                    if (!str.equals("Localization.getStringResource")) {
                        result.notImplemented();
                        return;
                    }
                    JSONObject jSONObject = (JSONObject) methodCall.arguments();
                    try {
                        result.success(LocalizationChannel.this.localizationMessageHandler.getStringResource(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
                    } catch (JSONException e) {
                        result.error("error", e.getMessage(), null);
                    }
                }
            }
        };
        this.handler = r0;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/localization", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r0);
    }

    public void sendLocales(@NonNull List<Locale> list) {
        Log.v(TAG, "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            Log.v(TAG, "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + jl1.BRACKET_END_STR);
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(Build.VERSION.SDK_INT >= 21 ? locale.getScript() : "");
            arrayList.add(locale.getVariant());
        }
        this.channel.invokeMethod("setLocale", arrayList);
    }

    public void setLocalizationMessageHandler(@Nullable LocalizationMessageHandler localizationMessageHandler2) {
        this.localizationMessageHandler = localizationMessageHandler2;
    }
}
