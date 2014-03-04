package com.ttpod.crawler.process

import com.ttpod.crawler.http.Downloader
import com.ttpod.crawler.http.HtmlDownloader
import com.ttpod.crawler.model.Page
import com.ttpod.crawler.model.Pipeline
import com.ttpod.crawler.model.Request

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-3-4
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
class FileProcessTask extends ProcessRequest implements Runnable {
    Request request
    List<Pipeline> pipelines = new ArrayList<Pipeline>();

    Downloader getDownloader() {
        return new HtmlDownloader()
    }

    FileProcessTask(Request request) {
        this.request = request
    }

    void run() {
        Page page = super.process(request)
        for (Pipeline pipeline : pipelines) {
            pipeline.process(page, this);
        }
    }
}
