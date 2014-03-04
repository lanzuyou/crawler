package com.ttpod.crawler.model

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-27
 * Time: 下午5:39
 * To change this template use File | Settings | File Templates.
 */
class Page {

    private Request request

    private String rawText

    private int statusCode

    private String url

    private String file

    private int size

    private boolean status

    boolean getStatus() {
        return status
    }

    void setStatus(boolean status) {
        this.status = status
    }

    String getUrl() {
        return url
    }

    void setUrl(String url) {
        this.url = url
    }

    Request getRequest() {
        return request
    }

    void setRequest(Request request) {
        this.request = request
    }

    Result getItems() {
        return items
    }

    void setItems(Result items) {
        this.items = items
    }

    Html getHtml() {
        return html
    }

    void setHtml(Html html) {
        this.html = html
    }

    String getRawText() {
        return rawText
    }

    void setRawText(String rawText) {
        this.rawText = rawText
    }

    int getStatusCode() {
        return statusCode
    }

    void setStatusCode(int statusCode) {
        this.statusCode = statusCode
    }

    List<Request> getTargetRequests() {
        return targetRequests
    }

    void setTargetRequests(List<Request> targetRequests) {
        this.targetRequests = targetRequests
    }

    String getFile() {
        return file
    }

    void setFile(String file) {
        this.file = file
    }

    int getSize() {
        return size
    }

    void setSize(int size) {
        this.size = size
    }
}
