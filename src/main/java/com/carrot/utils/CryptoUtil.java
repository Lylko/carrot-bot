package com.carrot.utils;

import com.qaprosoft.carina.core.foundation.commons.SpecialKeywords;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import java.util.regex.Pattern;

public class CryptoUtil {
    private static CryptoTool cryptoTool = new CryptoTool(Configuration.get(Configuration.Parameter.CRYPTO_KEY_PATH));
    private static Pattern CRYPT_PATTERN = Pattern.compile(SpecialKeywords.CRYPT);

    public static String decrypt(String string) {
        return cryptoTool.decryptByPattern(string, CRYPT_PATTERN);
    }
    public static String encrypt(String string) {
        return cryptoTool.encrypt(string);
    }
}