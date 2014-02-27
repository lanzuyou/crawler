package com.ttpod.crawler.model

import org.apache.http.HttpHost

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-27
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
class Site {
    private String domain;

    private String userAgent;

    private Map<String, String> cookies = new LinkedHashMap<String, String>();

    private String charset;

    /**
     * startUrls is the urls the crawler to start with.
     */
    private List<Request> startRequests = new ArrayList<Request>();

    private int sleepTime = 5000;

    private int retryTimes = 0;

    private int cycleRetryTimes = 0;

    private int timeOut = 5000;

    private static final Set<Integer> DEFAULT_STATUS_CODE_SET = new HashSet<Integer>();

    private Set<Integer> acceptStatCode = DEFAULT_STATUS_CODE_SET;

    private Map<String, String> headers = new HashMap<String, String>();

    private HttpHost httpProxy;

    private boolean useGzip = true;

    String getDomain() {
        return domain
    }

    void setDomain(String domain) {
        this.domain = domain
    }

    String getUserAgent() {
        return userAgent
    }

    void setUserAgent(String userAgent) {
        this.userAgent = userAgent
    }

    Map<String, String> getCookies() {
        return cookies
    }

    void setCookies(Map<String, String> cookies) {
        this.cookies = cookies
    }

    String getCharset() {
        return charset
    }

    void setCharset(String charset) {
        this.charset = charset
    }

    List<Request> getStartRequests() {
        return startRequests
    }

    void setStartRequests(List<Request> startRequests) {
        this.startRequests = startRequests
    }

    int getSleepTime() {
        return sleepTime
    }

    void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime
    }

    int getRetryTimes() {
        return retryTimes
    }

    void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes
    }

    int getCycleRetryTimes() {
        return cycleRetryTimes
    }

    void setCycleRetryTimes(int cycleRetryTimes) {
        this.cycleRetryTimes = cycleRetryTimes
    }

    int getTimeOut() {
        return timeOut
    }

    void setTimeOut(int timeOut) {
        this.timeOut = timeOut
    }

    Set<Integer> getAcceptStatCode() {
        return acceptStatCode
    }

    void setAcceptStatCode(Set<Integer> acceptStatCode) {
        this.acceptStatCode = acceptStatCode
    }

    Map<String, String> getHeaders() {
        return headers
    }

    void setHeaders(Map<String, String> headers) {
        this.headers = headers
    }

    HttpHost getHttpProxy() {
        return httpProxy
    }

    void setHttpProxy(HttpHost httpProxy) {
        this.httpProxy = httpProxy
    }

    boolean isUseGzip() {
        return useGzip
    }

    void setUseGzip(boolean useGzip) {
        this.useGzip = useGzip
    }
}
