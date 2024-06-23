package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.editing.ListenableEditingState;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashMap;

/* compiled from: Taobao */
public class TextInputPlugin implements ListenableEditingState.EditingStateWatcher {
    private static final String TAG = "TextInputPlugin";
    @NonNull
    private final AutofillManager afm;
    @Nullable
    private TextInputChannel.Configuration configuration;
    private ImeSyncDeferringInsetsCallback imeSyncCallback;
    @NonNull
    private InputTarget inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
    @Nullable
    private Rect lastClientRect;
    @Nullable
    private InputConnection lastInputConnection;
    @Nullable
    private SparseArray<TextInputChannel.Configuration> mAutofillConfigurations;
    @Nullable
    private ListenableEditingState mEditable;
    @NonNull
    private final InputMethodManager mImm;
    private TextInputChannel.TextEditState mLastKnownFrameworkTextEditingState;
    private boolean mRestartInputPending;
    @NonNull
    private final View mView;
    @NonNull
    private PlatformViewsController platformViewsController;
    @NonNull
    private final TextInputChannel textInputChannel;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class InputTarget {
        int id;
        @NonNull
        Type type;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public enum Type {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            PLATFORM_VIEW
        }

        public InputTarget(@NonNull Type type2, int i) {
            this.type = type2;
            this.id = i;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface MinMax {
        void inspect(double d, double d2);
    }

    @SuppressLint({"NewApi"})
    public TextInputPlugin(View view, @NonNull TextInputChannel textInputChannel2, @NonNull PlatformViewsController platformViewsController2) {
        int i = 0;
        this.mView = view;
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.afm = (AutofillManager) view.getContext().getSystemService(AutofillManager.class);
        } else {
            this.afm = null;
        }
        if (i2 >= 30) {
            i = (view.getWindowSystemUiVisibility() & 2) == 0 ? 0 | WindowInsets.Type.navigationBars() : i;
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view, (view.getWindowSystemUiVisibility() & 4) == 0 ? i | WindowInsets.Type.statusBars() : i, WindowInsets.Type.ime());
            this.imeSyncCallback = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.textInputChannel = textInputChannel2;
        textInputChannel2.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() {
            /* class io.flutter.plugin.editing.TextInputPlugin.AnonymousClass1 */

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void clearClient() {
                TextInputPlugin.this.clearTextInputClient();
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void finishAutofillContext(boolean z) {
                if (Build.VERSION.SDK_INT >= 26 && TextInputPlugin.this.afm != null) {
                    if (z) {
                        TextInputPlugin.this.afm.commit();
                    } else {
                        TextInputPlugin.this.afm.cancel();
                    }
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void hide() {
                if (TextInputPlugin.this.inputTarget.type == InputTarget.Type.PLATFORM_VIEW) {
                    TextInputPlugin.this.notifyViewExited();
                    return;
                }
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.hideTextInput(textInputPlugin.mView);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void requestAutofill() {
                TextInputPlugin.this.notifyViewEntered();
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void sendAppPrivateCommand(String str, Bundle bundle) {
                TextInputPlugin.this.sendTextInputAppPrivateCommand(str, bundle);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setClient(int i, TextInputChannel.Configuration configuration) {
                TextInputPlugin.this.setTextInputClient(i, configuration);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditableSizeAndTransform(double d, double d2, double[] dArr) {
                TextInputPlugin.this.saveEditableSizeAndTransform(d, d2, dArr);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.setTextInputEditingState(textInputPlugin.mView, textEditState);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setPlatformViewClient(int i) {
                TextInputPlugin.this.setPlatformViewTextInputClient(i);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void show() {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.showTextInput(textInputPlugin.mView);
            }
        });
        textInputChannel2.requestExistingInputState();
        this.platformViewsController = platformViewsController2;
        platformViewsController2.attachTextInputPlugin(this);
    }

    private boolean canShowTextInput() {
        TextInputChannel.InputType inputType;
        TextInputChannel.Configuration configuration2 = this.configuration;
        if (configuration2 == null || (inputType = configuration2.inputType) == null || inputType.type != TextInputChannel.TextInputType.NONE) {
            return true;
        }
        return false;
    }

    private static boolean composingChanged(TextInputChannel.TextEditState textEditState, TextInputChannel.TextEditState textEditState2) {
        int i = textEditState.composingEnd - textEditState.composingStart;
        if (i != textEditState2.composingEnd - textEditState2.composingStart) {
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (textEditState.text.charAt(textEditState.composingStart + i2) != textEditState2.text.charAt(textEditState2.composingStart + i2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hideTextInput(View view) {
        notifyViewExited();
        this.mImm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    private static int inputTypeFromTextInputType(TextInputChannel.InputType inputType, boolean z, boolean z2, boolean z3, boolean z4, TextInputChannel.TextCapitalization textCapitalization) {
        TextInputChannel.TextInputType textInputType = inputType.type;
        if (textInputType == TextInputChannel.TextInputType.DATETIME) {
            return 4;
        }
        if (textInputType == TextInputChannel.TextInputType.NUMBER) {
            int i = 2;
            if (inputType.isSigned) {
                i = 4098;
            }
            return inputType.isDecimal ? i | 8192 : i;
        } else if (textInputType == TextInputChannel.TextInputType.PHONE) {
            return 3;
        } else {
            if (textInputType == TextInputChannel.TextInputType.NONE) {
                return 0;
            }
            int i2 = 1;
            if (textInputType == TextInputChannel.TextInputType.MULTILINE) {
                i2 = 131073;
            } else if (textInputType == TextInputChannel.TextInputType.EMAIL_ADDRESS) {
                i2 = 33;
            } else if (textInputType == TextInputChannel.TextInputType.URL) {
                i2 = 17;
            } else if (textInputType == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
                i2 = 145;
            } else if (textInputType == TextInputChannel.TextInputType.NAME) {
                i2 = 97;
            } else if (textInputType == TextInputChannel.TextInputType.POSTAL_ADDRESS) {
                i2 = 113;
            }
            if (z) {
                i2 = i2 | 524288 | 128;
            } else {
                if (z2) {
                    i2 |= 32768;
                }
                if (!z3) {
                    i2 |= 524288;
                }
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.CHARACTERS) {
                return i2 | 4096;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.WORDS) {
                return i2 | 8192;
            }
            return textCapitalization == TextInputChannel.TextCapitalization.SENTENCES ? i2 | 16384 : i2;
        }
    }

    private boolean needsAutofill() {
        return this.mAutofillConfigurations != null;
    }

    private void notifyValueChanged(String str) {
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && needsAutofill()) {
            this.afm.notifyValueChanged(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(str));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyViewEntered() {
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && needsAutofill()) {
            String str = this.configuration.autofill.uniqueIdentifier;
            int[] iArr = new int[2];
            this.mView.getLocationOnScreen(iArr);
            Rect rect = new Rect(this.lastClientRect);
            rect.offset(iArr[0], iArr[1]);
            this.afm.notifyViewEntered(this.mView, str.hashCode(), rect);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyViewExited() {
        TextInputChannel.Configuration configuration2;
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && (configuration2 = this.configuration) != null && configuration2.autofill != null && needsAutofill()) {
            this.afm.notifyViewExited(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void saveEditableSizeAndTransform(double d, double d2, final double[] dArr) {
        final double[] dArr2 = new double[4];
        final boolean z = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d3 = dArr[12] / dArr[15];
        dArr2[1] = d3;
        dArr2[0] = d3;
        double d4 = dArr[13] / dArr[15];
        dArr2[3] = d4;
        dArr2[2] = d4;
        AnonymousClass2 r10 = new MinMax() {
            /* class io.flutter.plugin.editing.TextInputPlugin.AnonymousClass2 */

            @Override // io.flutter.plugin.editing.TextInputPlugin.MinMax
            public void inspect(double d, double d2) {
                double d3 = 1.0d;
                if (!z) {
                    double[] dArr = dArr;
                    d3 = 1.0d / (((dArr[3] * d) + (dArr[7] * d2)) + dArr[15]);
                }
                double[] dArr2 = dArr;
                double d4 = ((dArr2[0] * d) + (dArr2[4] * d2) + dArr2[12]) * d3;
                double d5 = ((dArr2[1] * d) + (dArr2[5] * d2) + dArr2[13]) * d3;
                double[] dArr3 = dArr2;
                if (d4 < dArr3[0]) {
                    dArr3[0] = d4;
                } else if (d4 > dArr3[1]) {
                    dArr3[1] = d4;
                }
                if (d5 < dArr3[2]) {
                    dArr3[2] = d5;
                } else if (d5 > dArr3[3]) {
                    dArr3[3] = d5;
                }
            }
        };
        r10.inspect(d, 0.0d);
        r10.inspect(d, d2);
        r10.inspect(0.0d, d2);
        Float valueOf = Float.valueOf(this.mView.getContext().getResources().getDisplayMetrics().density);
        this.lastClientRect = new Rect((int) (dArr2[0] * ((double) valueOf.floatValue())), (int) (dArr2[2] * ((double) valueOf.floatValue())), (int) Math.ceil(dArr2[1] * ((double) valueOf.floatValue())), (int) Math.ceil(dArr2[3] * ((double) valueOf.floatValue())));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPlatformViewTextInputClient(int i) {
        this.inputTarget = new InputTarget(InputTarget.Type.PLATFORM_VIEW, i);
        this.lastInputConnection = null;
    }

    private void updateAutofillConfigurationIfNeeded(TextInputChannel.Configuration configuration2) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (configuration2 == null || configuration2.autofill == null) {
                this.mAutofillConfigurations = null;
                return;
            }
            TextInputChannel.Configuration[] configurationArr = configuration2.fields;
            SparseArray<TextInputChannel.Configuration> sparseArray = new SparseArray<>();
            this.mAutofillConfigurations = sparseArray;
            if (configurationArr == null) {
                sparseArray.put(configuration2.autofill.uniqueIdentifier.hashCode(), configuration2);
                return;
            }
            for (TextInputChannel.Configuration configuration3 : configurationArr) {
                TextInputChannel.Configuration.Autofill autofill = configuration3.autofill;
                if (autofill != null) {
                    this.mAutofillConfigurations.put(autofill.uniqueIdentifier.hashCode(), configuration3);
                    this.afm.notifyValueChanged(this.mView, autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(autofill.editState.text));
                }
            }
        }
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        TextInputChannel.Configuration.Autofill autofill;
        TextInputChannel.Configuration.Autofill autofill2;
        if (Build.VERSION.SDK_INT >= 26 && (autofill = this.configuration.autofill) != null) {
            HashMap<String, TextInputChannel.TextEditState> hashMap = new HashMap<>();
            for (int i = 0; i < sparseArray.size(); i++) {
                TextInputChannel.Configuration configuration2 = this.mAutofillConfigurations.get(sparseArray.keyAt(i));
                if (!(configuration2 == null || (autofill2 = configuration2.autofill) == null)) {
                    String charSequence = sparseArray.valueAt(i).getTextValue().toString();
                    TextInputChannel.TextEditState textEditState = new TextInputChannel.TextEditState(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                    if (autofill2.uniqueIdentifier.equals(autofill.uniqueIdentifier)) {
                        this.mEditable.setEditingState(textEditState);
                    } else {
                        hashMap.put(autofill2.uniqueIdentifier, textEditState);
                    }
                }
            }
            this.textInputChannel.updateEditingStateWithTag(this.inputTarget.id, hashMap);
        }
    }

    public void clearPlatformViewClient(int i) {
        InputTarget inputTarget2 = this.inputTarget;
        if (inputTarget2.type == InputTarget.Type.PLATFORM_VIEW && inputTarget2.id == i) {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            notifyViewExited();
            this.mImm.hideSoftInputFromWindow(this.mView.getApplicationWindowToken(), 0);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void clearTextInputClient() {
        this.mEditable.removeEditingStateListener(this);
        notifyViewExited();
        updateAutofillConfigurationIfNeeded(null);
        this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
        this.lastClientRect = null;
    }

    public InputConnection createInputConnection(View view, KeyboardManager keyboardManager, EditorInfo editorInfo) {
        int i;
        InputTarget.Type type = this.inputTarget.type;
        if (type == InputTarget.Type.NO_TARGET) {
            this.lastInputConnection = null;
            return null;
        } else if (type == InputTarget.Type.PLATFORM_VIEW) {
            return null;
        } else {
            TextInputChannel.Configuration configuration2 = this.configuration;
            int inputTypeFromTextInputType = inputTypeFromTextInputType(configuration2.inputType, configuration2.obscureText, configuration2.autocorrect, configuration2.enableSuggestions, configuration2.enableIMEPersonalizedLearning, configuration2.textCapitalization);
            editorInfo.inputType = inputTypeFromTextInputType;
            editorInfo.imeOptions = 33554432;
            if (Build.VERSION.SDK_INT >= 26 && !this.configuration.enableIMEPersonalizedLearning) {
                editorInfo.imeOptions = 33554432 | 16777216;
            }
            Integer num = this.configuration.inputAction;
            if (num == null) {
                i = (inputTypeFromTextInputType & 131072) != 0 ? 1 : 6;
            } else {
                i = num.intValue();
            }
            String str = this.configuration.actionLabel;
            if (str != null) {
                editorInfo.actionLabel = str;
                editorInfo.actionId = i;
            }
            editorInfo.imeOptions = i | editorInfo.imeOptions;
            InputConnectionAdaptor inputConnectionAdaptor = new InputConnectionAdaptor(view, this.inputTarget.id, this.textInputChannel, keyboardManager, this.mEditable, editorInfo);
            editorInfo.initialSelStart = this.mEditable.getSelectionStart();
            editorInfo.initialSelEnd = this.mEditable.getSelectionEnd();
            this.lastInputConnection = inputConnectionAdaptor;
            return inputConnectionAdaptor;
        }
    }

    @SuppressLint({"NewApi"})
    public void destroy() {
        this.platformViewsController.detachTextInputPlugin();
        this.textInputChannel.setTextInputMethodHandler(null);
        notifyViewExited();
        ListenableEditingState listenableEditingState = this.mEditable;
        if (listenableEditingState != null) {
            listenableEditingState.removeEditingStateListener(this);
        }
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.imeSyncCallback;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        if (r7 == r0.composingEnd) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // io.flutter.plugin.editing.ListenableEditingState.EditingStateWatcher
    public void didChangeEditingState(boolean z, boolean z2, boolean z3) {
        boolean z4;
        if (z) {
            notifyValueChanged(this.mEditable.toString());
        }
        int selectionStart = this.mEditable.getSelectionStart();
        int selectionEnd = this.mEditable.getSelectionEnd();
        int composingStart = this.mEditable.getComposingStart();
        int composingEnd = this.mEditable.getComposingEnd();
        if (this.mLastKnownFrameworkTextEditingState != null) {
            if (this.mEditable.toString().equals(this.mLastKnownFrameworkTextEditingState.text)) {
                TextInputChannel.TextEditState textEditState = this.mLastKnownFrameworkTextEditingState;
                if (selectionStart == textEditState.selectionStart) {
                    if (selectionEnd == textEditState.selectionEnd) {
                        if (composingStart == textEditState.composingStart) {
                        }
                    }
                }
            }
            z4 = false;
            if (z4) {
                Log.v(TAG, "send EditingState to flutter: " + this.mEditable.toString());
                this.textInputChannel.updateEditingState(this.inputTarget.id, this.mEditable.toString(), selectionStart, selectionEnd, composingStart, composingEnd);
                this.mLastKnownFrameworkTextEditingState = new TextInputChannel.TextEditState(this.mEditable.toString(), selectionStart, selectionEnd, composingStart, composingEnd);
                return;
            }
            return;
        }
        z4 = true;
        if (z4) {
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Editable getEditable() {
        return this.mEditable;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ImeSyncDeferringInsetsCallback getImeSyncCallback() {
        return this.imeSyncCallback;
    }

    @NonNull
    public InputMethodManager getInputMethodManager() {
        return this.mImm;
    }

    @Nullable
    public InputConnection getLastInputConnection() {
        return this.lastInputConnection;
    }

    public boolean handleKeyEvent(KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!getInputMethodManager().isAcceptingText() || (inputConnection = this.lastInputConnection) == null) {
            return false;
        }
        if (inputConnection instanceof InputConnectionAdaptor) {
            return ((InputConnectionAdaptor) inputConnection).handleKeyEvent(keyEvent);
        }
        return inputConnection.sendKeyEvent(keyEvent);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        Rect rect;
        if (Build.VERSION.SDK_INT >= 26 && needsAutofill()) {
            String str = this.configuration.autofill.uniqueIdentifier;
            AutofillId autofillId = viewStructure.getAutofillId();
            for (int i2 = 0; i2 < this.mAutofillConfigurations.size(); i2++) {
                int keyAt = this.mAutofillConfigurations.keyAt(i2);
                TextInputChannel.Configuration.Autofill autofill = this.mAutofillConfigurations.valueAt(i2).autofill;
                if (autofill != null) {
                    viewStructure.addChildCount(1);
                    ViewStructure newChild = viewStructure.newChild(i2);
                    newChild.setAutofillId(autofillId, keyAt);
                    newChild.setAutofillHints(autofill.hints);
                    newChild.setAutofillType(1);
                    newChild.setVisibility(0);
                    if (str.hashCode() != keyAt || (rect = this.lastClientRect) == null) {
                        newChild.setDimens(0, 0, 0, 0, 1, 1);
                        newChild.setAutofillValue(AutofillValue.forText(autofill.editState.text));
                    } else {
                        newChild.setDimens(rect.left, rect.top, 0, 0, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.lastClientRect));
                        newChild.setAutofillValue(AutofillValue.forText(this.mEditable));
                    }
                }
            }
        }
    }

    public void sendTextInputAppPrivateCommand(String str, Bundle bundle) {
        this.mImm.sendAppPrivateCommand(this.mView, str, bundle);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setTextInputClient(int i, TextInputChannel.Configuration configuration2) {
        notifyViewExited();
        this.configuration = configuration2;
        if (canShowTextInput()) {
            this.inputTarget = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, i);
        } else {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, i);
        }
        ListenableEditingState listenableEditingState = this.mEditable;
        if (listenableEditingState != null) {
            listenableEditingState.removeEditingStateListener(this);
        }
        TextInputChannel.Configuration.Autofill autofill = configuration2.autofill;
        this.mEditable = new ListenableEditingState(autofill != null ? autofill.editState : null, this.mView);
        updateAutofillConfigurationIfNeeded(configuration2);
        this.mRestartInputPending = true;
        this.lastClientRect = null;
        this.mEditable.addEditingStateListener(this);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setTextInputEditingState(View view, TextInputChannel.TextEditState textEditState) {
        TextInputChannel.TextEditState textEditState2;
        if (!this.mRestartInputPending && (textEditState2 = this.mLastKnownFrameworkTextEditingState) != null && textEditState2.hasComposing()) {
            boolean composingChanged = composingChanged(this.mLastKnownFrameworkTextEditingState, textEditState);
            this.mRestartInputPending = composingChanged;
            if (composingChanged) {
                Log.i(TAG, "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.mLastKnownFrameworkTextEditingState = textEditState;
        this.mEditable.setEditingState(textEditState);
        if (this.mRestartInputPending) {
            this.mImm.restartInput(view);
            this.mRestartInputPending = false;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void showTextInput(View view) {
        if (canShowTextInput()) {
            view.requestFocus();
            this.mImm.showSoftInput(view, 0);
            return;
        }
        hideTextInput(view);
    }
}
