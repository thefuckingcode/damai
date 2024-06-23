package kotlin.text;

import android.taobao.windvane.extra.uc.UCNetworkDelegate;
import java.util.regex.Matcher;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.s82;
import tb.ur2;

/* access modifiers changed from: package-private */
@DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {UCNetworkDelegate.CHANGE_WEBVIEW_URL, 284, 288}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
/* compiled from: Taobao */
public final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements Function2<s82<? super String>, Continuation<? super ur2>, Object> {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $limit;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Regex this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Regex$splitToSequence$1(Regex regex, CharSequence charSequence, int i, Continuation<? super Regex$splitToSequence$1> continuation) {
        super(2, continuation);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$limit = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Regex$splitToSequence$1 regex$splitToSequence$1 = new Regex$splitToSequence$1(this.this$0, this.$input, this.$limit, continuation);
        regex$splitToSequence$1.L$0 = obj;
        return regex$splitToSequence$1;
    }

    @Nullable
    public final Object invoke(@NotNull s82<? super String> s82, @Nullable Continuation<? super ur2> continuation) {
        return ((Regex$splitToSequence$1) create(s82, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i;
        Regex$splitToSequence$1 regex$splitToSequence$1;
        s82 s82;
        Matcher matcher;
        String obj2;
        Object obj3 = b.d();
        int i2 = this.label;
        int i3 = 0;
        if (i2 == 0) {
            k12.b(obj);
            s82 s822 = (s82) this.L$0;
            matcher = this.this$0.nativePattern.matcher(this.$input);
            if (this.$limit == 1 || !matcher.find()) {
                String obj4 = this.$input.toString();
                this.label = 1;
                if (s822.a(obj4, this) == obj3) {
                    return obj3;
                }
                return ur2.INSTANCE;
            }
            regex$splitToSequence$1 = this;
            s82 = s822;
            i = 0;
        } else if (i2 == 1) {
            k12.b(obj);
            return ur2.INSTANCE;
        } else if (i2 == 2) {
            int i4 = this.I$0;
            s82 = (s82) this.L$0;
            k12.b(obj);
            regex$splitToSequence$1 = this;
            i = i4;
            matcher = (Matcher) this.L$1;
            i3 = matcher.end();
            i++;
            if (i == regex$splitToSequence$1.$limit - 1 || !matcher.find()) {
                CharSequence charSequence = regex$splitToSequence$1.$input;
                obj2 = charSequence.subSequence(i3, charSequence.length()).toString();
                regex$splitToSequence$1.L$0 = null;
                regex$splitToSequence$1.L$1 = null;
                regex$splitToSequence$1.label = 3;
                if (s82.a(obj2, regex$splitToSequence$1) == obj3) {
                    return obj3;
                }
                return ur2.INSTANCE;
            }
        } else if (i2 == 3) {
            k12.b(obj);
            return ur2.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String obj5 = regex$splitToSequence$1.$input.subSequence(i3, matcher.start()).toString();
        regex$splitToSequence$1.L$0 = s82;
        regex$splitToSequence$1.L$1 = matcher;
        regex$splitToSequence$1.I$0 = i;
        regex$splitToSequence$1.label = 2;
        if (s82.a(obj5, regex$splitToSequence$1) == obj3) {
            return obj3;
        }
        i3 = matcher.end();
        i++;
        CharSequence charSequence2 = regex$splitToSequence$1.$input;
        obj2 = charSequence2.subSequence(i3, charSequence2.length()).toString();
        regex$splitToSequence$1.L$0 = null;
        regex$splitToSequence$1.L$1 = null;
        regex$splitToSequence$1.label = 3;
        if (s82.a(obj2, regex$splitToSequence$1) == obj3) {
        }
        return ur2.INSTANCE;
    }
}
