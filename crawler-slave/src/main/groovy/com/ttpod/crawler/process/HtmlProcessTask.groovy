package com.ttpod.crawler.process

import com.ttpod.crawler.http.Downloader
import com.ttpod.crawler.http.HtmlDownloader
import com.ttpod.crawler.model.Page
import com.ttpod.crawler.model.Pipeline
import com.ttpod.crawler.model.Request
import com.ttpod.crawler.model.Task

import java.util.concurrent.atomic.AtomicInteger

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-3-4
 * Time: 上午10:52
 * To change this template use File | Settings | File Templates.
 */
class HtmlProcessTask extends ProcessRequest implements Runnable {
    private static AtomicInteger sucessNum = new AtomicInteger(0);
    private static AtomicInteger failNum = new AtomicInteger(0);
    Request request
    List<Pipeline> pipelines = new ArrayList<Pipeline>();

    Downloader getDownloader() {
        return new HtmlDownloader()
    }

    HtmlProcessTask(Request request) {
        this.request = request
    }

    void run() {
        Page page = super.process(request)
        for (Pipeline pipeline : pipelines) {
            pipeline.process(page, this);
        }
    }
}
