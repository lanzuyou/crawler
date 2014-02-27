package com.ttpod.crawler.model

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-27
 * Time: 下午5:05
 * To change this template use File | Settings | File Templates.
 */
class Request {
    private String url;
    private Map<String, Object> context;
    private long priority;

    String getUrl() {
        return url
    }

    def setUrl(String url) {
        this.url = url
        return this
    }

    Map<String, Object> getContext() {
        return context
    }

    def setContext(Map<String, Object> context) {
        this.context = context
        return this
    }

    long getPriority() {
        return priority
    }

    def setPriority(long priority) {
        this.priority = priority
        return this
    }
}
