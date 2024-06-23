package io.flutter.plugin.localization;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: Taobao */
public class LocalizationPlugin {
    @NonNull
    private final Context context;
    @NonNull
    private final LocalizationChannel localizationChannel;
    @VisibleForTesting
    final LocalizationChannel.LocalizationMessageHandler localizationMessageHandler;

    public LocalizationPlugin(@NonNull Context context2, @NonNull LocalizationChannel localizationChannel2) {
        AnonymousClass1 r0 = new LocalizationChannel.LocalizationMessageHandler() {
            /* class io.flutter.plugin.localization.LocalizationPlugin.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:10:0x006a  */
            /* JADX WARNING: Removed duplicated region for block: B:9:0x0061  */
            @Override // io.flutter.embedding.engine.systemchannels.LocalizationChannel.LocalizationMessageHandler
            public String getStringResource(@NonNull String str, @Nullable String str2) {
                Locale locale;
                Context context = LocalizationPlugin.this.context;
                if (str2 != null) {
                    Locale localeFromString = LocalizationPlugin.localeFromString(str2);
                    if (Build.VERSION.SDK_INT >= 17) {
                        Configuration configuration = new Configuration(LocalizationPlugin.this.context.getResources().getConfiguration());
                        configuration.setLocale(localeFromString);
                        context = LocalizationPlugin.this.context.createConfigurationContext(configuration);
                    } else {
                        Resources resources = LocalizationPlugin.this.context.getResources();
                        Configuration configuration2 = resources.getConfiguration();
                        locale = configuration2.locale;
                        configuration2.locale = localeFromString;
                        resources.updateConfiguration(configuration2, null);
                        int identifier = context.getResources().getIdentifier(str, "string", LocalizationPlugin.this.context.getPackageName());
                        String string = identifier == 0 ? context.getResources().getString(identifier) : null;
                        if (str2 != null && Build.VERSION.SDK_INT < 17) {
                            Resources resources2 = LocalizationPlugin.this.context.getResources();
                            Configuration configuration3 = resources2.getConfiguration();
                            configuration3.locale = locale;
                            resources2.updateConfiguration(configuration3, null);
                        }
                        return string;
                    }
                }
                locale = null;
                int identifier2 = context.getResources().getIdentifier(str, "string", LocalizationPlugin.this.context.getPackageName());
                if (identifier2 == 0) {
                }
                Resources resources22 = LocalizationPlugin.this.context.getResources();
                Configuration configuration32 = resources22.getConfiguration();
                configuration32.locale = locale;
                resources22.updateConfiguration(configuration32, null);
                return string;
            }
        };
        this.localizationMessageHandler = r0;
        this.context = context2;
        this.localizationChannel = localizationChannel2;
        localizationChannel2.setLocalizationMessageHandler(r0);
    }

    @VisibleForTesting
    public static Locale localeFromString(String str) {
        String str2;
        String[] split = str.replace('_', '-').split("-", -1);
        String str3 = split[0];
        String str4 = "";
        int i = 1;
        if (split.length <= 1 || split[1].length() != 4) {
            str2 = str4;
        } else {
            str2 = split[1];
            i = 2;
        }
        if (split.length > i && split[i].length() >= 2 && split[i].length() <= 3) {
            str4 = split[i];
        }
        return new Locale(str3, str4, str2);
    }

    public Locale resolveNativeLocale(List<Locale> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            ArrayList arrayList = new ArrayList();
            LocaleList locales = this.context.getResources().getConfiguration().getLocales();
            int size = locales.size();
            for (int i2 = 0; i2 < size; i2++) {
                Locale locale = locales.get(i2);
                String language = locale.getLanguage();
                if (!locale.getScript().isEmpty()) {
                    language = language + "-" + locale.getScript();
                }
                if (!locale.getCountry().isEmpty()) {
                    language = language + "-" + locale.getCountry();
                }
                arrayList.add(new Locale.LanguageRange(language));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage()));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage() + "-*"));
            }
            Locale lookup = Locale.lookup(arrayList, list);
            if (lookup != null) {
                return lookup;
            }
            return list.get(0);
        } else if (i >= 24) {
            LocaleList locales2 = this.context.getResources().getConfiguration().getLocales();
            for (int i3 = 0; i3 < locales2.size(); i3++) {
                Locale locale2 = locales2.get(i3);
                for (Locale locale3 : list) {
                    if (locale2.equals(locale3)) {
                        return locale3;
                    }
                }
                for (Locale locale4 : list) {
                    if (locale2.getLanguage().equals(locale4.toLanguageTag())) {
                        return locale4;
                    }
                }
                for (Locale locale5 : list) {
                    if (locale2.getLanguage().equals(locale5.getLanguage())) {
                        return locale5;
                    }
                }
            }
            return list.get(0);
        } else {
            Locale locale6 = this.context.getResources().getConfiguration().locale;
            if (locale6 != null) {
                for (Locale locale7 : list) {
                    if (locale6.equals(locale7)) {
                        return locale7;
                    }
                }
                for (Locale locale8 : list) {
                    if (locale6.getLanguage().equals(locale8.toString())) {
                        return locale8;
                    }
                }
            }
            return list.get(0);
        }
    }

    public void sendLocalesToFlutter(@NonNull Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = configuration.getLocales();
            int size = locales.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(locales.get(i));
            }
        } else {
            arrayList.add(configuration.locale);
        }
        this.localizationChannel.sendLocales(arrayList);
    }
}
