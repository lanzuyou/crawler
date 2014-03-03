package com.ttpod.crawler.util

import java.nio.charset.Charset
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-3-3
 * Time: 下午3:27
 * To change this template use File | Settings | File Templates.
 */
class HtmlUtil {
    private static final def PATTERNFORCHARSET = Pattern.compile("charset\\s*=\\s*['\"]*([^\\s;'\"]*)");
    static String getCharset(String contentType) {
        Matcher matcher = PATTERNFORCHARSET.matcher(contentType);
        if (matcher.find()) {
            String charset = matcher.group(1);
            if (Charset.isSupported(charset)) {
                return charset;
            }
        }
        return null;
    }
}
