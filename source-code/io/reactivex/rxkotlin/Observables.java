package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u0003\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007 \b*\u0010\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u00050\u0005 \b**\u0012$\u0012\"\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007 \b*\u0010\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004H\u0007Jw\u0010\u0003\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000b0\rH\bJ°\u0001\u0010\u0003\u001an\u00120\u0012.\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f \b*\u0016\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u000e0\u000e \b*6\u00120\u0012.\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f \b*\u0016\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u000e0\u000e\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0004H\u0007J\u0001\u0010\u0003\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042 \b\u0004\u0010\f\u001a\u001a\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u000b0\u0011H\bJ«\u0001\u0010\u0003\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042&\b\u0004\u0010\f\u001a \u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u000b0\u0014H\bJÅ\u0001\u0010\u0003\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042,\b\u0004\u0010\f\u001a&\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u000b0\u0017H\bJß\u0001\u0010\u0003\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u0018\"\u0004\b\u0006\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u000422\b\u0004\u0010\f\u001a,\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u000b0\u001aH\bJù\u0001\u0010\u0003\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u0018\"\u0004\b\u0006\u0010\u001b\"\u0004\b\u0007\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u000428\b\u0004\u0010\f\u001a2\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u000b0\u001dH\bJ\u0002\u0010\u0003\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u0018\"\u0004\b\u0006\u0010\u001b\"\u0004\b\u0007\u0010\u001e\"\u0004\b\b\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00042>\b\u0004\u0010\f\u001a8\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u000b0 H\bJ­\u0002\u0010\u0003\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u0018\"\u0004\b\u0006\u0010\u001b\"\u0004\b\u0007\u0010\u001e\"\u0004\b\b\u0010!\"\u0004\b\t\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u00042D\b\u0004\u0010\f\u001a>\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\u000b0#H\bJ\u0001\u0010$\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007 \b*\u0010\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u00050\u0005 \b**\u0012$\u0012\"\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007 \b*\u0010\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004H\u0007Jw\u0010$\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000b0\rH\bJ°\u0001\u0010$\u001an\u00120\u0012.\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f \b*\u0016\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u000e0\u000e \b*6\u00120\u0012.\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f \b*\u0016\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u000e0\u000e\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0004H\u0007J\u0001\u0010$\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042 \b\u0004\u0010\f\u001a\u001a\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u000b0\u0011H\bJ«\u0001\u0010$\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042&\b\u0004\u0010\f\u001a \u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u000b0\u0014H\bJÅ\u0001\u0010$\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042,\b\u0004\u0010\f\u001a&\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u000b0\u0017H\bJß\u0001\u0010$\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u0018\"\u0004\b\u0006\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u000422\b\u0004\u0010\f\u001a,\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u000b0\u001aH\bJù\u0001\u0010$\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u0018\"\u0004\b\u0006\u0010\u001b\"\u0004\b\u0007\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u000428\b\u0004\u0010\f\u001a2\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u000b0\u001dH\bJ\u0002\u0010$\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u0018\"\u0004\b\u0006\u0010\u001b\"\u0004\b\u0007\u0010\u001e\"\u0004\b\b\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00042>\b\u0004\u0010\f\u001a8\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u000b0 H\bJ­\u0002\u0010$\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u0001H\u000bH\u000b\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u0018\"\u0004\b\u0006\u0010\u001b\"\u0004\b\u0007\u0010\u001e\"\u0004\b\b\u0010!\"\u0004\b\t\u0010\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u00042D\b\u0004\u0010\f\u001a>\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\u000b0#H\b¨\u0006%"}, d2 = {"Lio/reactivex/rxkotlin/Observables;", "", "()V", "combineLatest", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "T1", "T2", "kotlin.jvm.PlatformType", "source1", "source2", "R", "combineFunction", "Lkotlin/Function2;", "Lkotlin/Triple;", "T3", "source3", "Lkotlin/Function3;", "T4", "source4", "Lkotlin/Function4;", "T5", "source5", "Lkotlin/Function5;", "T6", "source6", "Lkotlin/Function6;", "T7", "source7", "Lkotlin/Function7;", "T8", "source8", "Lkotlin/Function8;", "T9", "source9", "Lkotlin/Function9;", "zip", "rxkotlin"}, k = 1, mv = {1, 1, 11})
/* compiled from: Observables.kt */
public final class Observables {
    public static final Observables INSTANCE = new Observables();

    private Observables() {
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        return Observable.combineLatest(observable, observable2, new Observables$combineLatest$1(function2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2> Observable<Pair<T1, T2>> combineLatest(Observable<T1> observable, Observable<T2> observable2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        return Observable.combineLatest(observable, observable2, Observables$combineLatest$2.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        return Observable.combineLatest(observable, observable2, observable3, new Observables$combineLatest$3(function3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3> Observable<Triple<T1, T2, T3>> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        return Observable.combineLatest(observable, observable2, observable3, Observables$combineLatest$4.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        return Observable.combineLatest(observable, observable2, observable3, observable4, new Observables$combineLatest$5(function4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        return Observable.combineLatest(observable, observable2, observable3, observable4, observable5, new Observables$combineLatest$6(function5));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        return Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, new Observables$combineLatest$7(function6));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(function7, "combineFunction");
        return Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, observable7, new Observables$combineLatest$8(function7));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(function8, "combineFunction");
        return Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, new Observables$combineLatest$9(function8));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(observable9, "source9");
        Intrinsics.checkParameterIsNotNull(function9, "combineFunction");
        return Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, new Observables$combineLatest$10(function9));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, R> Observable<R> zip(Observable<T1> observable, Observable<T2> observable2, Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        return Observable.zip(observable, observable2, new Observables$zip$1(function2));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2> Observable<Pair<T1, T2>> zip(Observable<T1> observable, Observable<T2> observable2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        return Observable.zip(observable, observable2, Observables$zip$2.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, R> Observable<R> zip(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        return Observable.zip(observable, observable2, observable3, new Observables$zip$3(function3));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3> Observable<Triple<T1, T2, T3>> zip(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        return Observable.zip(observable, observable2, observable3, Observables$zip$4.INSTANCE);
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Observable<R> zip(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        return Observable.zip(observable, observable2, observable3, observable4, new Observables$zip$5(function4));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, R> Observable<R> zip(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        return Observable.zip(observable, observable2, observable3, observable4, observable5, new Observables$zip$6(function5));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        return Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, new Observables$zip$7(function6));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(function7, "combineFunction");
        return Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, observable7, new Observables$zip$8(function7));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(function8, "combineFunction");
        return Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, new Observables$zip$9(function8));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(observable9, "source9");
        Intrinsics.checkParameterIsNotNull(function9, "combineFunction");
        return Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, new Observables$zip$10(function9));
    }
}
