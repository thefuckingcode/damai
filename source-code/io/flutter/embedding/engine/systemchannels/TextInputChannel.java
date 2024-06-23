package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.parser.JSONLexer;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class TextInputChannel {
    private static final String TAG = "TextInputChannel";
    @NonNull
    public final MethodChannel channel;
    private final MethodChannel.MethodCallHandler parsingMethodHandler;
    @Nullable
    private TextInputMethodHandler textInputMethodHandler;

    /* compiled from: Taobao */
    public static class Configuration {
        @Nullable
        public final String actionLabel;
        public final boolean autocorrect;
        @Nullable
        public final Autofill autofill;
        public final boolean enableIMEPersonalizedLearning;
        public final boolean enableSuggestions;
        @Nullable
        public final Configuration[] fields;
        @Nullable
        public final Integer inputAction;
        @NonNull
        public final InputType inputType;
        public final boolean obscureText;
        @NonNull
        public final TextCapitalization textCapitalization;

        /* compiled from: Taobao */
        public static class Autofill {
            public final TextEditState editState;
            public final String[] hints;
            public final String uniqueIdentifier;

            public Autofill(@NonNull String str, @NonNull String[] strArr, @NonNull TextEditState textEditState) {
                this.uniqueIdentifier = str;
                this.hints = strArr;
                this.editState = textEditState;
            }

            public static Autofill fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                int length = jSONArray.length();
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = translateAutofillHint(jSONArray.getString(i));
                }
                return new Autofill(string, strArr, TextEditState.fromJson(jSONObject2));
            }

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a4, code lost:
                if (r16.equals("familyName") == false) goto L_0x002d;
             */
            @NonNull
            private static String translateAutofillHint(@NonNull String str) {
                int i = Build.VERSION.SDK_INT;
                char c = JSONLexer.EOI;
                if (i < 26) {
                    return str;
                }
                str.hashCode();
                switch (str.hashCode()) {
                    case -2058889126:
                        if (str.equals("birthdayYear")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1917283616:
                        if (str.equals("oneTimeCode")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1844815832:
                        if (str.equals("creditCardExpirationMonth")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1825589953:
                        if (str.equals("telephoneNumberNational")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1821235109:
                        if (str.equals("newPassword")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1757573738:
                        if (str.equals("creditCardSecurityCode")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1682373820:
                        if (str.equals("creditCardExpirationDay")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1658955742:
                        if (str.equals("fullStreetAddress")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1567118045:
                        if (str.equals("telephoneNumberDevice")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1476752575:
                        if (str.equals("countryName")) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1413737489:
                        if (str.equals("middleInitial")) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1377792129:
                        if (str.equals("addressCity")) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1249512767:
                        if (str.equals("gender")) {
                            c = '\f';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1186060294:
                        if (str.equals("postalAddressExtendedPostalCode")) {
                            c = CharUtils.CR;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1151034798:
                        if (str.equals("creditCardNumber")) {
                            c = 14;
                            break;
                        }
                        c = 65535;
                        break;
                    case -835992323:
                        if (str.equals("namePrefix")) {
                            c = 15;
                            break;
                        }
                        c = 65535;
                        break;
                    case -818219584:
                        if (str.equals("middleName")) {
                            c = 16;
                            break;
                        }
                        c = 65535;
                        break;
                    case -747304516:
                        if (str.equals("nameSuffix")) {
                            c = 17;
                            break;
                        }
                        c = 65535;
                        break;
                    case -613980922:
                        if (str.equals("creditCardExpirationDate")) {
                            c = 18;
                            break;
                        }
                        c = 65535;
                        break;
                    case -613352043:
                        if (str.equals("creditCardExpirationYear")) {
                            c = 19;
                            break;
                        }
                        c = 65535;
                        break;
                    case -549230602:
                        if (str.equals("telephoneNumberCountryCode")) {
                            c = 20;
                            break;
                        }
                        c = 65535;
                        break;
                    case -265713450:
                        if (str.equals("username")) {
                            c = 21;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3373707:
                        if (str.equals("name")) {
                            c = 22;
                            break;
                        }
                        c = 65535;
                        break;
                    case 96619420:
                        if (str.equals("email")) {
                            c = 23;
                            break;
                        }
                        c = 65535;
                        break;
                    case 253202685:
                        if (str.equals("addressState")) {
                            c = 24;
                            break;
                        }
                        c = 65535;
                        break;
                    case 588174851:
                        if (str.equals("birthdayMonth")) {
                            c = 25;
                            break;
                        }
                        c = 65535;
                        break;
                    case 798554127:
                        break;
                    case 892233837:
                        if (str.equals("telephoneNumber")) {
                            c = 27;
                            break;
                        }
                        c = 65535;
                        break;
                    case 991032982:
                        if (str.equals("newUsername")) {
                            c = 28;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1069376125:
                        if (str.equals("birthday")) {
                            c = 29;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1216985755:
                        if (str.equals(Constants.Value.PASSWORD)) {
                            c = 30;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1469046696:
                        if (str.equals("givenName")) {
                            c = 31;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1662667945:
                        if (str.equals("postalAddress")) {
                            c = ' ';
                            break;
                        }
                        c = 65535;
                        break;
                    case 1921869058:
                        if (str.equals("postalAddressExtended")) {
                            c = '!';
                            break;
                        }
                        c = 65535;
                        break;
                    case 2011152728:
                        if (str.equals("postalCode")) {
                            c = jl1.QUOTE;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2011773919:
                        if (str.equals("birthdayDay")) {
                            c = '#';
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        return "birthDateYear";
                    case 1:
                        return "smsOTPCode";
                    case 2:
                        return "creditCardExpirationMonth";
                    case 3:
                        return "phoneNational";
                    case 4:
                        return "newPassword";
                    case 5:
                        return "creditCardSecurityCode";
                    case 6:
                        return "creditCardExpirationDay";
                    case 7:
                        return "streetAddress";
                    case '\b':
                        return "phoneNumberDevice";
                    case '\t':
                        return "addressCountry";
                    case '\n':
                        return "personMiddleInitial";
                    case 11:
                        return "addressLocality";
                    case '\f':
                        return "gender";
                    case '\r':
                        return "extendedPostalCode";
                    case 14:
                        return "creditCardNumber";
                    case 15:
                        return "personNamePrefix";
                    case 16:
                        return "personMiddleName";
                    case 17:
                        return "personNameSuffix";
                    case 18:
                        return "creditCardExpirationDate";
                    case 19:
                        return "creditCardExpirationYear";
                    case 20:
                        return "phoneCountryCode";
                    case 21:
                        return "username";
                    case 22:
                        return "personName";
                    case 23:
                        return "emailAddress";
                    case 24:
                        return "addressRegion";
                    case 25:
                        return "birthDateMonth";
                    case 26:
                        return "personFamilyName";
                    case 27:
                        return "phoneNumber";
                    case 28:
                        return "newUsername";
                    case 29:
                        return "birthDateFull";
                    case 30:
                        return Constants.Value.PASSWORD;
                    case 31:
                        return "personGivenName";
                    case ' ':
                        return "postalAddress";
                    case '!':
                        return "extendedAddress";
                    case '\"':
                        return "postalCode";
                    case '#':
                        return "birthDateDay";
                    default:
                        return str;
                }
            }
        }

        public Configuration(boolean z, boolean z2, boolean z3, boolean z4, @NonNull TextCapitalization textCapitalization2, @NonNull InputType inputType2, @Nullable Integer num, @Nullable String str, @Nullable Autofill autofill2, @Nullable Configuration[] configurationArr) {
            this.obscureText = z;
            this.autocorrect = z2;
            this.enableSuggestions = z3;
            this.enableIMEPersonalizedLearning = z4;
            this.textCapitalization = textCapitalization2;
            this.inputType = inputType2;
            this.inputAction = num;
            this.actionLabel = str;
            this.autofill = autofill2;
            this.fields = configurationArr;
        }

        public static Configuration fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            Configuration[] configurationArr;
            String string = jSONObject.getString("inputAction");
            if (string != null) {
                Autofill autofill2 = null;
                if (!jSONObject.isNull("fields")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("fields");
                    int length = jSONArray.length();
                    Configuration[] configurationArr2 = new Configuration[length];
                    for (int i = 0; i < length; i++) {
                        configurationArr2[i] = fromJson(jSONArray.getJSONObject(i));
                    }
                    configurationArr = configurationArr2;
                } else {
                    configurationArr = null;
                }
                Integer inputActionFromTextInputAction = inputActionFromTextInputAction(string);
                boolean optBoolean = jSONObject.optBoolean("obscureText");
                boolean optBoolean2 = jSONObject.optBoolean("autocorrect", true);
                boolean optBoolean3 = jSONObject.optBoolean("enableSuggestions");
                boolean optBoolean4 = jSONObject.optBoolean("enableIMEPersonalizedLearning");
                TextCapitalization fromValue = TextCapitalization.fromValue(jSONObject.getString("textCapitalization"));
                InputType fromJson = InputType.fromJson(jSONObject.getJSONObject(RemoteMessageConst.INPUT_TYPE));
                String string2 = jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel");
                if (!jSONObject.isNull("autofill")) {
                    autofill2 = Autofill.fromJson(jSONObject.getJSONObject("autofill"));
                }
                return new Configuration(optBoolean, optBoolean2, optBoolean3, optBoolean4, fromValue, fromJson, inputActionFromTextInputAction, string2, autofill2, configurationArr);
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0072, code lost:
            if (r12.equals("TextInputAction.done") == false) goto L_0x001b;
         */
        @NonNull
        private static Integer inputActionFromTextInputAction(@NonNull String str) {
            str.hashCode();
            char c = 1;
            switch (str.hashCode()) {
                case -810971940:
                    if (str.equals("TextInputAction.unspecified")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -737377923:
                    break;
                case -737089298:
                    if (str.equals("TextInputAction.next")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -737080013:
                    if (str.equals("TextInputAction.none")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -736940669:
                    if (str.equals("TextInputAction.send")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 469250275:
                    if (str.equals("TextInputAction.search")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1241689507:
                    if (str.equals("TextInputAction.go")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1539450297:
                    if (str.equals("TextInputAction.newline")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 2110497650:
                    if (str.equals("TextInputAction.previous")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return 0;
                case 1:
                    return 6;
                case 2:
                    return 5;
                case 3:
                    return 1;
                case 4:
                    return 4;
                case 5:
                    return 3;
                case 6:
                    return 2;
                case 7:
                    return 1;
                case '\b':
                    return 7;
                default:
                    return 0;
            }
        }
    }

    /* compiled from: Taobao */
    public static class InputType {
        public final boolean isDecimal;
        public final boolean isSigned;
        @NonNull
        public final TextInputType type;

        public InputType(@NonNull TextInputType textInputType, boolean z, boolean z2) {
            this.type = textInputType;
            this.isSigned = z;
            this.isDecimal = z2;
        }

        @NonNull
        public static InputType fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            return new InputType(TextInputType.fromValue(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    /* compiled from: Taobao */
    public enum TextCapitalization {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        
        @NonNull
        private final String encodedName;

        private TextCapitalization(@NonNull String str) {
            this.encodedName = str;
        }

        static TextCapitalization fromValue(@NonNull String str) throws NoSuchFieldException {
            TextCapitalization[] values = values();
            for (TextCapitalization textCapitalization : values) {
                if (textCapitalization.encodedName.equals(str)) {
                    return textCapitalization;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    /* compiled from: Taobao */
    public static class TextEditState {
        public final int composingEnd;
        public final int composingStart;
        public final int selectionEnd;
        public final int selectionStart;
        @NonNull
        public final String text;

        public TextEditState(@NonNull String str, int i, int i2, int i3, int i4) throws IndexOutOfBoundsException {
            if (!(i == -1 && i2 == -1) && (i < 0 || i2 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i) + AVFSCacheConstants.COMMA_SEP + String.valueOf(i2) + jl1.BRACKET_END_STR);
            } else if (!(i3 == -1 && i4 == -1) && (i3 < 0 || i3 > i4)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i3) + AVFSCacheConstants.COMMA_SEP + String.valueOf(i4) + jl1.BRACKET_END_STR);
            } else if (i4 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i3));
            } else if (i > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i));
            } else if (i2 <= str.length()) {
                this.text = str;
                this.selectionStart = i;
                this.selectionEnd = i2;
                this.composingStart = i3;
                this.composingEnd = i4;
            } else {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i2));
            }
        }

        public static TextEditState fromJson(@NonNull JSONObject jSONObject) throws JSONException {
            return new TextEditState(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean hasComposing() {
            int i = this.composingStart;
            return i >= 0 && this.composingEnd > i;
        }

        public boolean hasSelection() {
            return this.selectionStart >= 0;
        }
    }

    /* compiled from: Taobao */
    public interface TextInputMethodHandler {
        void clearClient();

        void finishAutofillContext(boolean z);

        void hide();

        void requestAutofill();

        void sendAppPrivateCommand(String str, Bundle bundle);

        void setClient(int i, @NonNull Configuration configuration);

        void setEditableSizeAndTransform(double d, double d2, double[] dArr);

        void setEditingState(@NonNull TextEditState textEditState);

        void setPlatformViewClient(int i);

        void show();
    }

    /* compiled from: Taobao */
    public enum TextInputType {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none");
        
        @NonNull
        private final String encodedName;

        private TextInputType(@NonNull String str) {
            this.encodedName = str;
        }

        static TextInputType fromValue(@NonNull String str) throws NoSuchFieldException {
            TextInputType[] values = values();
            for (TextInputType textInputType : values) {
                if (textInputType.encodedName.equals(str)) {
                    return textInputType;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public TextInputChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r0 = new MethodChannel.MethodCallHandler() {
            /* class io.flutter.embedding.engine.systemchannels.TextInputChannel.AnonymousClass1 */

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Bundle bundle;
                if (TextInputChannel.this.textInputMethodHandler != null) {
                    String str = methodCall.method;
                    Object obj = methodCall.arguments;
                    Log.v(TextInputChannel.TAG, "Received '" + str + "' message.");
                    str.hashCode();
                    char c = 65535;
                    switch (str.hashCode()) {
                        case -1779068172:
                            if (str.equals("TextInput.setPlatformViewClient")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1015421462:
                            if (str.equals("TextInput.setEditingState")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -37561188:
                            if (str.equals("TextInput.setClient")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 270476819:
                            if (str.equals("TextInput.hide")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 270803918:
                            if (str.equals("TextInput.show")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 649192816:
                            if (str.equals("TextInput.sendAppPrivateCommand")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 1204752139:
                            if (str.equals("TextInput.setEditableSizeAndTransform")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 1727570905:
                            if (str.equals("TextInput.finishAutofillContext")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 1904427655:
                            if (str.equals("TextInput.clearClient")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 2113369584:
                            if (str.equals("TextInput.requestAutofill")) {
                                c = '\t';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            try {
                                TextInputChannel.this.textInputMethodHandler.setPlatformViewClient(((JSONObject) obj).getInt("platformViewId"));
                                result.success(null);
                                return;
                            } catch (JSONException e) {
                                result.error("error", e.getMessage(), null);
                                return;
                            }
                        case 1:
                            try {
                                TextInputChannel.this.textInputMethodHandler.setEditingState(TextEditState.fromJson((JSONObject) obj));
                                result.success(null);
                                return;
                            } catch (JSONException e2) {
                                result.error("error", e2.getMessage(), null);
                                return;
                            }
                        case 2:
                            try {
                                JSONArray jSONArray = (JSONArray) obj;
                                TextInputChannel.this.textInputMethodHandler.setClient(jSONArray.getInt(0), Configuration.fromJson(jSONArray.getJSONObject(1)));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e3) {
                                result.error("error", e3.getMessage(), null);
                                return;
                            }
                        case 3:
                            TextInputChannel.this.textInputMethodHandler.hide();
                            result.success(null);
                            return;
                        case 4:
                            TextInputChannel.this.textInputMethodHandler.show();
                            result.success(null);
                            return;
                        case 5:
                            try {
                                JSONObject jSONObject = (JSONObject) obj;
                                String string = jSONObject.getString("action");
                                String string2 = jSONObject.getString("data");
                                if (string2 == null || string2.isEmpty()) {
                                    bundle = null;
                                } else {
                                    bundle = new Bundle();
                                    bundle.putString("data", string2);
                                }
                                TextInputChannel.this.textInputMethodHandler.sendAppPrivateCommand(string, bundle);
                                result.success(null);
                                return;
                            } catch (JSONException e4) {
                                result.error("error", e4.getMessage(), null);
                                return;
                            }
                        case 6:
                            try {
                                JSONObject jSONObject2 = (JSONObject) obj;
                                double d = jSONObject2.getDouble("width");
                                double d2 = jSONObject2.getDouble("height");
                                JSONArray jSONArray2 = jSONObject2.getJSONArray("transform");
                                double[] dArr = new double[16];
                                for (int i = 0; i < 16; i++) {
                                    dArr[i] = jSONArray2.getDouble(i);
                                }
                                TextInputChannel.this.textInputMethodHandler.setEditableSizeAndTransform(d, d2, dArr);
                                return;
                            } catch (JSONException e5) {
                                result.error("error", e5.getMessage(), null);
                                return;
                            }
                        case 7:
                            TextInputChannel.this.textInputMethodHandler.finishAutofillContext(((Boolean) obj).booleanValue());
                            result.success(null);
                            return;
                        case '\b':
                            TextInputChannel.this.textInputMethodHandler.clearClient();
                            result.success(null);
                            return;
                        case '\t':
                            TextInputChannel.this.textInputMethodHandler.requestAutofill();
                            result.success(null);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                }
            }
        };
        this.parsingMethodHandler = r0;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r0);
    }

    private static HashMap<Object, Object> createEditingStateJSON(String str, int i, int i2, int i3, int i4) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i));
        hashMap.put("selectionExtent", Integer.valueOf(i2));
        hashMap.put("composingBase", Integer.valueOf(i3));
        hashMap.put("composingExtent", Integer.valueOf(i4));
        return hashMap;
    }

    public void done(int i) {
        Log.v(TAG, "Sending 'done' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.done"));
    }

    public void go(int i) {
        Log.v(TAG, "Sending 'go' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.go"));
    }

    public void newline(int i) {
        Log.v(TAG, "Sending 'newline' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.newline"));
    }

    public void next(int i) {
        Log.v(TAG, "Sending 'next' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.next"));
    }

    public void performPrivateCommand(int i, String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    hashMap2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    hashMap2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            hashMap.put("data", hashMap2);
        }
        this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i), hashMap));
    }

    public void previous(int i) {
        Log.v(TAG, "Sending 'previous' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.previous"));
    }

    public void requestExistingInputState() {
        this.channel.invokeMethod("TextInputClient.requestExistingInputState", null);
    }

    public void search(int i) {
        Log.v(TAG, "Sending 'search' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.search"));
    }

    public void send(int i) {
        Log.v(TAG, "Sending 'send' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.send"));
    }

    public void setTextInputMethodHandler(@Nullable TextInputMethodHandler textInputMethodHandler2) {
        this.textInputMethodHandler = textInputMethodHandler2;
    }

    public void unspecifiedAction(int i) {
        Log.v(TAG, "Sending 'unspecified' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.unspecified"));
    }

    public void updateEditingState(int i, String str, int i2, int i3, int i4, int i5) {
        Log.v(TAG, "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i2 + "\nSelection end: " + i3 + "\nComposing start: " + i4 + "\nComposing end: " + i5);
        HashMap<Object, Object> createEditingStateJSON = createEditingStateJSON(str, i2, i3, i4, i5);
        this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i), createEditingStateJSON));
    }

    public void updateEditingStateWithTag(int i, HashMap<String, TextEditState> hashMap) {
        Log.v(TAG, "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, TextEditState> entry : hashMap.entrySet()) {
            TextEditState value = entry.getValue();
            hashMap2.put(entry.getKey(), createEditingStateJSON(value.text, value.selectionStart, value.selectionEnd, -1, -1));
        }
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i), hashMap2));
    }
}
