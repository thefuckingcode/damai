package com.taobao.phenix.decode;

import android.graphics.Rect;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.entity.b;
import com.taobao.pexode.entity.c;
import com.taobao.pexode.mimetype.MimeType;
import com.taobao.phenix.bitmap.BitmapPool;
import com.taobao.phenix.decode.DecodeException;
import com.taobao.phenix.loader.network.IncompleteResponseException;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import com.taobao.rxm.request.RequestCancelListener;
import com.taobao.weex.common.Constants;
import java.io.FileInputStream;
import java.io.InputStream;
import tb.b40;
import tb.cs1;
import tb.ln0;
import tb.np1;
import tb.pb2;
import tb.pd0;
import tb.qd0;
import tb.tp1;
import tb.vr2;
import tb.ze2;

/* compiled from: Taobao */
public class a extends BaseChainProducer<b40, qd0, com.taobao.phenix.request.a> implements RequestCancelListener<com.taobao.phenix.request.a> {
    public a() {
        super(0, 1);
    }

    private void I(Consumer<b40, com.taobao.phenix.request.a> consumer, boolean z, qd0 qd0, DecodeException decodeException) {
        if (z) {
            decodeException.setLocalUri(consumer.getContext().G().n());
            Throwable th = decodeException;
            if (qd0 != null) {
                decodeException.dataFromDisk(qd0.k);
                th = decodeException;
                if (!qd0.k) {
                    th = decodeException;
                    if (!qd0.g) {
                        th = decodeException;
                        if (qd0.a()) {
                            vr2.x("Decoder", consumer.getContext(), "actual decode error=%s, convert to error=IncompleteContentError", decodeException);
                            th = new IncompleteResponseException();
                        }
                    }
                }
            }
            consumer.onFailure(th);
            return;
        }
        vr2.m("Decoder", consumer.getContext(), "intermediate result decode error=%s, request not failed yet", decodeException);
    }

    private qd0 J(qd0 qd0) {
        EncodedDataInspector h = tp1.o().h();
        if (h == null) {
            return qd0;
        }
        pd0 inspectEncodedData = h.inspectEncodedData(qd0.i, qd0);
        cs1.b(inspectEncodedData != null && inspectEncodedData.a(), "inspected data cannot be null or not available!");
        if (inspectEncodedData == qd0) {
            return qd0;
        }
        return qd0.d(inspectEncodedData, qd0.l).f(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02d2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02d4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02d6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02d6 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:128:0x02c2] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0161 A[Catch:{ OutOfMemoryError -> 0x02a0, UnsatisfiedLinkError -> 0x029c, all -> 0x0298 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x016a A[Catch:{ OutOfMemoryError -> 0x02a0, UnsatisfiedLinkError -> 0x029c, all -> 0x0298 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x018c A[Catch:{ OutOfMemoryError -> 0x02a0, UnsatisfiedLinkError -> 0x029c, all -> 0x0298 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01a9 A[Catch:{ OutOfMemoryError -> 0x02a0, UnsatisfiedLinkError -> 0x029c, all -> 0x0298 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01ab A[Catch:{ OutOfMemoryError -> 0x02a0, UnsatisfiedLinkError -> 0x029c, all -> 0x0298 }] */
    /* renamed from: H */
    public void consumeNewResult(Consumer<b40, com.taobao.phenix.request.a> consumer, boolean z, qd0 qd0) {
        qd0 qd02;
        Throwable th;
        boolean z2;
        Consumer<b40, com.taobao.phenix.request.a> consumer2;
        qd0 qd03;
        OutOfMemoryError outOfMemoryError;
        qd0 qd04;
        OutOfMemoryError e;
        boolean z3;
        UnsatisfiedLinkError unsatisfiedLinkError;
        UnsatisfiedLinkError e2;
        Throwable th2;
        OutOfMemoryError e3;
        UnsatisfiedLinkError e4;
        Throwable th3;
        RewindableStream rewindableStream;
        String str;
        BitmapPool a;
        b40 b40;
        boolean z4;
        RewindableStream rewindableStream2;
        com.taobao.phenix.request.a context = consumer.getContext();
        boolean z5 = true;
        if (qd0 != null) {
            try {
                if (qd0.a()) {
                    q(consumer, z);
                    vr2.n("Phenix", "Decode Started.", context);
                    qd0 J = J(qd0);
                    try {
                        if (J.k) {
                            try {
                                ln0.j(context.U());
                            } catch (OutOfMemoryError e5) {
                                consumer2 = consumer;
                                qd03 = J;
                                z2 = true;
                                outOfMemoryError = e5;
                            } catch (UnsatisfiedLinkError e6) {
                                consumer2 = consumer;
                                qd02 = J;
                                z3 = true;
                                unsatisfiedLinkError = e6;
                                try {
                                    vr2.n("Decoder", "Decode UnsatisfiedLinkError", context);
                                    I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNLINK_SO_ERROR, unsatisfiedLinkError));
                                    qd02.release();
                                } catch (Throwable th4) {
                                    th = th4;
                                    z5 = z3;
                                    if (z5 && qd02 != null) {
                                        qd02.release();
                                    }
                                    if (!(qd0 == null || qd0 == qd02)) {
                                        qd0.release();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                consumer2 = consumer;
                                qd02 = J;
                                th2 = th5;
                                try {
                                    vr2.m("Decoder", context, "unknown error, throwable=%s", th2);
                                    I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNKNOWN_ERROR, th2));
                                    qd02.release();
                                    return;
                                } catch (Throwable th6) {
                                    th = th6;
                                    qd02.release();
                                    qd0.release();
                                    throw th;
                                }
                            }
                        }
                        boolean j = Pexode.j();
                        PexodeOptions pexodeOptions = new PexodeOptions();
                        pexodeOptions.justDecodeBounds = true;
                        pexodeOptions.allowDegrade2System = true;
                        pexodeOptions.resourceValue = J.f;
                        pexodeOptions.forceStaticIfAnimation = context.X();
                        pexodeOptions.fromLocal = context.U().k() == ImageStatistics.FromType.FROM_LOCAL_FILE;
                        if (J.a == 1) {
                            rewindableStream = new com.taobao.pexode.entity.a(J.c, J.d, J.b);
                        } else {
                            InputStream inputStream = J.e;
                            if (inputStream instanceof FileInputStream) {
                                rewindableStream2 = new b((FileInputStream) inputStream, 1048576);
                            } else {
                                rewindableStream2 = new c(inputStream, 1048576);
                            }
                            rewindableStream = rewindableStream2;
                        }
                        Pexode.d(rewindableStream, pexodeOptions);
                        rewindableStream.rewind();
                        J.j(pexodeOptions.outMimeType);
                        if (z) {
                            context.U().v(J.g());
                        }
                        int m = Pexode.m(rewindableStream, pexodeOptions.outMimeType, j);
                        if (m != rewindableStream.getInputType()) {
                            if (m == 3) {
                                rewindableStream.back2StreamType();
                            }
                            if (m == 1) {
                                pd0 a2 = ze2.a(rewindableStream, tp1.o().c().build(), new int[]{J.b});
                                rewindableStream = new com.taobao.pexode.entity.a(a2.c, a2.d, a2.b);
                            }
                        }
                        MimeType mimeType = pexodeOptions.outMimeType;
                        if (mimeType == null || !mimeType.d()) {
                            int J2 = context.J();
                            int I = context.I();
                            if (pexodeOptions.resourceValue == null) {
                                try {
                                    if (pexodeOptions.isSizeAvailable() && !(J2 == 0 && I == 0)) {
                                        str = "Phenix";
                                        int a3 = pb2.a(pexodeOptions.outWidth, pexodeOptions.outHeight, pb2.c(J2, I, pexodeOptions.outWidth, pexodeOptions.outHeight), pb2.c(I, J2, pexodeOptions.outHeight, pexodeOptions.outWidth));
                                        pexodeOptions.sampleSize = a3;
                                        vr2.k("Decoder", context, "limit with maxSize, sampleSize=%d, maxSize=%dx%d, actualSize=%dx%d", Integer.valueOf(a3), Integer.valueOf(J2), Integer.valueOf(I), Integer.valueOf(pexodeOptions.outWidth), Integer.valueOf(pexodeOptions.outHeight));
                                        if (J.a != 1) {
                                            pexodeOptions.outPadding = new Rect();
                                        }
                                        if (j) {
                                            pexodeOptions.enableAshmem = true;
                                            pexodeOptions.allowDegrade2NoAshmem = true;
                                        }
                                        if (pexodeOptions.resourceValue == null && Pexode.l() && (a = tp1.o().a().build()) != null) {
                                            if (pexodeOptions.sampleSize > 1) {
                                                Pexode.d(rewindableStream, pexodeOptions);
                                                rewindableStream.rewind();
                                            }
                                            pexodeOptions.inBitmap = a.getFromPool(pexodeOptions.outWidth, pexodeOptions.outHeight, PexodeOptions.CONFIG);
                                            pexodeOptions.allowDegrade2NoInBitmap = true;
                                            context.U().s(pexodeOptions.inBitmap == null);
                                        }
                                    }
                                } catch (OutOfMemoryError e7) {
                                    e3 = e7;
                                    consumer2 = consumer;
                                    outOfMemoryError = e3;
                                    qd03 = J;
                                    z2 = true;
                                    vr2.n("Decoder", "Decode OutOfMemoryError", context);
                                    I(consumer2, z, qd03, new DecodeException(DecodeException.DecodedError.OOM_ERROR, outOfMemoryError));
                                    if (z2 && qd03 != null) {
                                        qd03.release();
                                    }
                                    if (qd0 == null || qd0 == qd03) {
                                        return;
                                    }
                                    qd0.release();
                                    return;
                                } catch (UnsatisfiedLinkError e8) {
                                    e4 = e8;
                                    consumer2 = consumer;
                                    unsatisfiedLinkError = e4;
                                    qd02 = J;
                                    z3 = true;
                                    vr2.n("Decoder", "Decode UnsatisfiedLinkError", context);
                                    I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNLINK_SO_ERROR, unsatisfiedLinkError));
                                    if (z3 && qd02 != null) {
                                        qd02.release();
                                    }
                                    if (qd0 == null || qd0 == qd02) {
                                        return;
                                    }
                                    qd0.release();
                                    return;
                                } catch (Throwable th7) {
                                    th3 = th7;
                                    consumer2 = consumer;
                                    th2 = th3;
                                    qd02 = J;
                                    z5 = true;
                                    vr2.m("Decoder", context, "unknown error, throwable=%s", th2);
                                    I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNKNOWN_ERROR, th2));
                                    if (z5 && qd02 != null) {
                                        qd02.release();
                                    }
                                    if (qd0 == null || qd0 == qd02) {
                                        return;
                                    }
                                    qd0.release();
                                    return;
                                }
                            }
                            str = "Phenix";
                            if (J.a != 1) {
                            }
                            if (j) {
                            }
                            if (pexodeOptions.sampleSize > 1) {
                            }
                            pexodeOptions.inBitmap = a.getFromPool(pexodeOptions.outWidth, pexodeOptions.outHeight, PexodeOptions.CONFIG);
                            pexodeOptions.allowDegrade2NoInBitmap = true;
                            context.U().s(pexodeOptions.inBitmap == null);
                        } else {
                            str = "Phenix";
                        }
                        pexodeOptions.justDecodeBounds = false;
                        if (context.i()) {
                            vr2.q("Decoder", context, "request is cancelled before image decoding", new Object[0]);
                            consumer.onCancellation();
                            J.release();
                            if (qd0 != J) {
                                qd0.release();
                                return;
                            }
                            return;
                        }
                        context.p0(pexodeOptions);
                        context.l(this);
                        np1 d = Pexode.d(rewindableStream, pexodeOptions);
                        context.s(this);
                        context.p0(null);
                        if (d != null) {
                            b40 = new b40(J, d.a, d.b, pexodeOptions.outPadding);
                            z4 = b40.e();
                        } else {
                            b40 = null;
                            z4 = false;
                        }
                        if (context.U() != null) {
                            context.U().C = pexodeOptions.outIcc;
                        }
                        consumer2 = consumer;
                        try {
                            p(consumer2, z4, z);
                            vr2.n(str, "Decode Finished.", context);
                            if (!z4) {
                                vr2.m("Decoder", context, "decoded image not available, cancelled=%b, mimeType=%s", Boolean.valueOf(context.i()), pexodeOptions.outMimeType);
                                I(consumer2, z, J, new DecodeException(DecodeException.DecodedError.UNAVAILABLE_OUTPUT_ERROR, "result image null, WxH=" + pexodeOptions.outWidth + Constants.Name.X + pexodeOptions.outHeight));
                                J.release();
                                if (qd0 != J) {
                                    qd0.release();
                                    return;
                                }
                                return;
                            }
                            try {
                                consumer2.onNewResult(b40, z);
                                vr2.k("Decoder", context, "decode complete, result=%s, WxH=%dx%d, mimeType=%s", b40, Integer.valueOf(pexodeOptions.outWidth), Integer.valueOf(pexodeOptions.outHeight), pexodeOptions.outMimeType);
                                if (qd0 == J) {
                                    return;
                                }
                            } catch (OutOfMemoryError e9) {
                                outOfMemoryError = e9;
                                qd03 = J;
                                z2 = false;
                                vr2.n("Decoder", "Decode OutOfMemoryError", context);
                                I(consumer2, z, qd03, new DecodeException(DecodeException.DecodedError.OOM_ERROR, outOfMemoryError));
                                qd03.release();
                            } catch (UnsatisfiedLinkError e10) {
                                unsatisfiedLinkError = e10;
                                qd02 = J;
                                z3 = false;
                                vr2.n("Decoder", "Decode UnsatisfiedLinkError", context);
                                I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNLINK_SO_ERROR, unsatisfiedLinkError));
                                qd02.release();
                            } catch (Throwable th8) {
                                th2 = th8;
                                qd02 = J;
                                z5 = false;
                                vr2.m("Decoder", context, "unknown error, throwable=%s", th2);
                                I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNKNOWN_ERROR, th2));
                                qd02.release();
                                return;
                            }
                            qd0.release();
                            return;
                        } catch (OutOfMemoryError e11) {
                            e3 = e11;
                            outOfMemoryError = e3;
                            qd03 = J;
                            z2 = true;
                            vr2.n("Decoder", "Decode OutOfMemoryError", context);
                            I(consumer2, z, qd03, new DecodeException(DecodeException.DecodedError.OOM_ERROR, outOfMemoryError));
                            qd03.release();
                        } catch (UnsatisfiedLinkError e12) {
                            e4 = e12;
                            unsatisfiedLinkError = e4;
                            qd02 = J;
                            z3 = true;
                            vr2.n("Decoder", "Decode UnsatisfiedLinkError", context);
                            I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNLINK_SO_ERROR, unsatisfiedLinkError));
                            qd02.release();
                        } catch (Throwable th9) {
                            th3 = th9;
                            th2 = th3;
                            qd02 = J;
                            z5 = true;
                            vr2.m("Decoder", context, "unknown error, throwable=%s", th2);
                            I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNKNOWN_ERROR, th2));
                            qd02.release();
                            return;
                        }
                    } catch (OutOfMemoryError e13) {
                        e3 = e13;
                        consumer2 = consumer;
                        outOfMemoryError = e3;
                        qd03 = J;
                        z2 = true;
                        vr2.n("Decoder", "Decode OutOfMemoryError", context);
                        I(consumer2, z, qd03, new DecodeException(DecodeException.DecodedError.OOM_ERROR, outOfMemoryError));
                        qd03.release();
                    } catch (UnsatisfiedLinkError e14) {
                        e4 = e14;
                        consumer2 = consumer;
                        unsatisfiedLinkError = e4;
                        qd02 = J;
                        z3 = true;
                        vr2.n("Decoder", "Decode UnsatisfiedLinkError", context);
                        I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNLINK_SO_ERROR, unsatisfiedLinkError));
                        qd02.release();
                    } catch (Throwable th10) {
                        th3 = th10;
                        consumer2 = consumer;
                        th2 = th3;
                        qd02 = J;
                        z5 = true;
                        vr2.m("Decoder", context, "unknown error, throwable=%s", th2);
                        I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNKNOWN_ERROR, th2));
                        qd02.release();
                        return;
                    }
                }
            } catch (OutOfMemoryError e15) {
                e = e15;
                consumer2 = consumer;
                qd04 = null;
                outOfMemoryError = e;
                qd03 = qd04;
                z2 = true;
                vr2.n("Decoder", "Decode OutOfMemoryError", context);
                I(consumer2, z, qd03, new DecodeException(DecodeException.DecodedError.OOM_ERROR, outOfMemoryError));
                qd03.release();
            } catch (UnsatisfiedLinkError e16) {
                e2 = e16;
                consumer2 = consumer;
                qd04 = null;
                unsatisfiedLinkError = e2;
                qd02 = qd04;
                z3 = true;
                vr2.n("Decoder", "Decode UnsatisfiedLinkError", context);
                I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNLINK_SO_ERROR, unsatisfiedLinkError));
                qd02.release();
            } catch (Throwable th11) {
                Throwable th12 = th11;
                consumer2 = consumer;
                qd04 = null;
                th2 = th12;
                qd02 = qd04;
                z5 = true;
                vr2.m("Decoder", context, "unknown error, throwable=%s", th2);
                I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNKNOWN_ERROR, th2));
                qd02.release();
                return;
            }
        }
        consumer2 = consumer;
        qd04 = null;
        try {
            I(consumer2, z, qd0, new DecodeException(DecodeException.DecodedError.UNAVAILABLE_INPUT_ERROR));
            if (qd0 != null) {
                qd0.release();
            }
        } catch (OutOfMemoryError e17) {
            e = e17;
            outOfMemoryError = e;
            qd03 = qd04;
            z2 = true;
            vr2.n("Decoder", "Decode OutOfMemoryError", context);
            I(consumer2, z, qd03, new DecodeException(DecodeException.DecodedError.OOM_ERROR, outOfMemoryError));
            qd03.release();
        } catch (UnsatisfiedLinkError e18) {
            e2 = e18;
            unsatisfiedLinkError = e2;
            qd02 = qd04;
            z3 = true;
            vr2.n("Decoder", "Decode UnsatisfiedLinkError", context);
            I(consumer2, z, qd02, new DecodeException(DecodeException.DecodedError.UNLINK_SO_ERROR, unsatisfiedLinkError));
            qd02.release();
        } catch (Throwable th13) {
        }
    }

    /* renamed from: K */
    public void onCancel(com.taobao.phenix.request.a aVar) {
        vr2.n("Phenix", "Decode Cancel.", aVar);
        PexodeOptions O = aVar.O();
        if (O != null) {
            aVar.p0(null);
            vr2.k("Decoder", aVar, "cancelled image decoding, result=%b", Boolean.valueOf(O.requestCancel()));
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.qg
    public boolean a(Consumer<b40, com.taobao.phenix.request.a> consumer) {
        return false;
    }
}
