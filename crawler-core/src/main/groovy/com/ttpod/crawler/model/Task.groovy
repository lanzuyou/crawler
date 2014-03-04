package com.ttpod.crawler.model

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-3-3
 * Time: 上午11:01
 * To change this template use File | Settings | File Templates.
 */
class Task {
    private String name;
    private Site site;

    static Task getTask(String id, boolean flag) {
        return new Task()
    }

    Site getSite() {
        return site
    }

    void setSite(Site site) {
        this.site = site
    }
}
