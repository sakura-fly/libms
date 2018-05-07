package com.libmss.util;

public class MD5 {
    private static final int SIXTEEN_WORDS_LENGTH = 512;
    private static final int DOUBLE_WORDS_LENGTH = 64;
    private static final int WORD_LENGTH = 32;
    private static final int BYTE_LENGTH = 16;
    private static final long MAX_UNSIGNED = 4294967296L;

    public static String md5(String inStr) {
        byte[] input = inStr.getBytes();
        long oriBitLen = input.length * 8;
        long newBitLen = (1 + (oriBitLen + 64) / 512) * 512;
        long numberOf0 = newBitLen - 64 - 1 - oriBitLen;

        //  Step 1 预处理步骤
        //  padding: 用0和1进行填充
        byte[] paddingBytes = new byte[(int)(newBitLen / 8)];
        int counter = 0;
        for (counter = 0; counter < input.length; ++counter) {
            paddingBytes[counter] = input[counter];
        }
        paddingBytes[counter++] = (byte) 0x80;
        for (int i = 0; i < (numberOf0 - 7) / 8; ++i) {
            paddingBytes[counter++] = 0;
        }

        //  Step 2
        //  通过小端规则（先放低位）补上bit长度
        long tmpInt = oriBitLen;
        for (int i1 = 0; i1 < 8; ++i1) {
            byte tmp = (byte) ((tmpInt >> (i1 * 8)) & 0xFF);
            paddingBytes[counter++] = tmp;
        }

        //  构造用word表示的等价分组
        long[] M = new long[paddingBytes.length / 4];
        for (int i = 0; i < paddingBytes.length / 4; ++i) {
            M[i] = MD5.bytesToLong(paddingBytes, i * 4);
        }

        //  Step 3 初始化buffer
        long wordA = 0x67452301L;
        long wordB = 0xefcdab89L;
        long wordC = 0x98badcfeL;
        long wordD = 0x10325476L;

        //  Step 4
        long[] T = new long[65];
        for (int i = 0; i < 65; ++i) {
            T[i] = (long) (Math.sin((double) i) * MD5.MAX_UNSIGNED);
            T[i] = Math.abs(T[i]) & 0xffffffffL;
        }
        //  将数据分为512bit即16字的小块进行处理
        for (int i = 0; i < M.length / 16; ++i) {
            //  用X暂存16字的数据
            long[] X = new long[16];
            for (int j = 0; j < 16; ++j) {
                X[j] = M[i * 16 + j];
            }
            //  暂存A, B, C, D
            Long AA = wordA;
            Long BB = wordB;
            Long CC = wordC;
            Long DD = wordD;

            int tmpCounter1 = 0;
            int tmpCounter2 = 1;
            //  Round 1
            for (int i1 = 0; i1 < 4; ++i1) {
                wordA = FOp(wordA, wordB, wordC, wordD, X[tmpCounter1++], 7, T[tmpCounter2++]);
                wordD = FOp(wordD, wordA, wordB, wordC, X[tmpCounter1++], 12, T[tmpCounter2++]);
                wordC = FOp(wordC, wordD, wordA, wordB, X[tmpCounter1++], 17, T[tmpCounter2++]);
                wordB = FOp(wordB, wordC, wordD, wordA, X[tmpCounter1++], 22, T[tmpCounter2++]);
            }

            //  Round 2
            tmpCounter1 = 1;
            for (int i1 = 0; i1 < 4; ++i1) {
                wordA = GOp(wordA, wordB, wordC, wordD, X[tmpCounter1], 5, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 5) % 16;
                wordD = GOp(wordD, wordA, wordB, wordC, X[tmpCounter1], 9, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 5) % 16;
                wordC = GOp(wordC, wordD, wordA, wordB, X[tmpCounter1], 14, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 5) % 16;
                wordB = GOp(wordB, wordC, wordD, wordA, X[tmpCounter1], 20, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 5) % 16;
            }

            //  Round 3
            tmpCounter1 = 5;
            for (int i1 = 0; i1 < 4; ++i1) {
                wordA = HOp(wordA, wordB, wordC, wordD, X[tmpCounter1], 4, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 3) % 16;
                wordD = HOp(wordD, wordA, wordB, wordC, X[tmpCounter1], 11, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 3) % 16;
                wordC = HOp(wordC, wordD, wordA, wordB, X[tmpCounter1], 16, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 3) % 16;
                wordB = HOp(wordB, wordC, wordD, wordA, X[tmpCounter1], 23, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 3) % 16;
            }

            //  Round 4
            tmpCounter1 = 0;
            for (int i1 = 0; i1 < 4; ++i1) {
                wordA = IOp(wordA, wordB, wordC, wordD, X[tmpCounter1], 6, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 7) % 16;
                wordD = IOp(wordD, wordA, wordB, wordC, X[tmpCounter1], 10, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 7) % 16;
                wordC = IOp(wordC, wordD, wordA, wordB, X[tmpCounter1], 15, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 7) % 16;
                wordB = IOp(wordB, wordC, wordD, wordA, X[tmpCounter1], 21, T[tmpCounter2++]);
                tmpCounter1 = (tmpCounter1 + 7) % 16;
            }

            wordA = 0xffffffffL & (wordA + AA);
            wordB = 0xffffffffL & (wordB + BB);
            wordC = 0xffffffffL & (wordC + CC);
            wordD = 0xffffffffL & (wordD + DD);
        }

        //  get result from wordA ~ wordD
        //  begin with the low-order byte of A,
        //  and end with the high-order byte of D
        String resultStr = "";
        long[] words = new long[]{wordA, wordB, wordC, wordD};
        for (int i = 0; i < 4; ++i) {
            words[i] = 0xffffffffL & words[i];
            resultStr += MD5.wordToHexString(words[i]);
        }

        return resultStr;
    }

    public static String wordToHexString(long word) {
        String resultStr = "";
        long tmpByte = 0xFF;
        for (int i = 0; i < 4; ++i) {
            String tmpStr = Long.toHexString(tmpByte & (word >> 8 * i));
            if (tmpStr.length() < 2) {
                tmpStr = "0" + tmpStr;
            }
            resultStr += tmpStr;
        }
        return resultStr;
    }

    public static String byteToHexString(byte b) {
        String result = Integer.toHexString(b & 0xFF);
        if (result.length() < 2) {
            result = "0" + result;
        }
        return result;
    }

    //  byte数组转化为int
    //  应用小端规则，靠前的byte转化为低位
    //  将index~index+3转化为一个int
    public static long bytesToLong(byte[] input, int index) {
        long result = 0;
        for (int i = 3; i >= 0; --i) {
            result = result << 8;
            //  消除符号位影响
            long tmp = 0xFF & input[index + i];
            result = result | tmp;
        }
        return result;
    }

    //  定义辅助函数
    private static long FFunc(long X, long Y, long Z) {
        return ((X & Y) | (~X & Z)) & 0xffffffffL;
    }

    private static long GFunc(long X, long Y, long Z) {
        return ((X & Z) | (Y & ~Z)) & 0xffffffffL;
    }

    private static long HFunc(long X, long Y, long Z) {
        return (X ^ Y ^ Z) & 0xffffffffL;
    }

    private static long IFunc(long X, long Y, long Z) {
        return (Y ^ (X | ~Z)) & 0xffffffffL;
    }

    //  Operation: a = b + ((a + F(b,c,d) + X[k] + T[i]) <<< s)
    //  @param a, b, c, d: A, B, C, D
    //  @param kk: X[k]
    //  @param s: s
    //  @param ii: T[i]
    //  @return new value of a
    //  注意这里用的是循环左移而不是简单的左移
    private static long FOp(long a, long b, long c, long d, long kk, long s, long ii) {
        long tmp0 = (a + FFunc(b, c, d) + kk + ii) & 0xffffffffL;
        long tmp1 = MD5.circularlyLeftShift(tmp0, s);
        long tmp = b + tmp1;
        return 0xFFFFFFFFL & tmp;
    }

    private static long GOp(long a, long b, long c, long d, long kk, long s, long ii) {
        long tmp0 = (a + GFunc(b, c, d) + kk + ii) & 0xffffffffL;
        long tmp1 = MD5.circularlyLeftShift(tmp0, s);
        long tmp = b + tmp1;
        return 0xFFFFFFFFL & tmp;
    }

    private static long HOp(long a, long b, long c, long d, long kk, long s, long ii) {
        long tmp0 = (a + HFunc(b, c, d) + kk + ii) & 0xffffffffL;
        long tmp1 = MD5.circularlyLeftShift(tmp0, s);
        long tmp = b + tmp1;
        return 0xFFFFFFFFL & tmp;
    }

    private static long IOp(long a, long b, long c, long d, long kk, long s, long ii) {
        long tmp0 = (a + IFunc(b, c, d) + kk + ii) & 0xffffffffL;
        long tmp1 = MD5.circularlyLeftShift(tmp0, s);
        long tmp = b + tmp1;
        return 0xFFFFFFFFL & tmp;
    }

    //  默认target为32位数
    private static long circularlyLeftShift(long target, long numberOfBits) {
        return (0xffffffffL & (target << numberOfBits)) | (target >>> (32 - numberOfBits));
    }
}