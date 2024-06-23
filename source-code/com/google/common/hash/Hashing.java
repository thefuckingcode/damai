package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.Immutable;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

@Beta
/* compiled from: Taobao */
public final class Hashing {
    static final int a = ((int) System.currentTimeMillis());

    @Immutable
    /* compiled from: Taobao */
    enum ChecksumType implements ImmutableSupplier<Checksum> {
        CRC_32("Hashing.crc32()") {
            @Override // com.google.common.base.Supplier
            public Checksum get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") {
            @Override // com.google.common.base.Supplier
            public Checksum get() {
                return new Adler32();
            }
        };
        
        public final HashFunction hashFunction;

        private ChecksumType(String str) {
            this.hashFunction = new ChecksumHashFunction(this, 32, str);
        }
    }

    public static HashFunction a() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }
}
