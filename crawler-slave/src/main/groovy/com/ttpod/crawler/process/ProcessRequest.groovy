package com.ttpod.crawler.process

import com.ttpod.crawler.http.Downloader
import com.ttpod.crawler.model.Page
import com.ttpod.crawler.model.Request
import com.ttpod.crawler.model.Task

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-3-3
 * Time: 下午7:05
 * To change this template use File | Settings | File Templates.
 */
abstract class ProcessRequest extends Task {
    Page page

    void process(Request request) {
        page = getDownloader().download(request, this)
        if (page == null || page.getRawText() == null) {
            // TODO
            // 尝试重试
            page.setStatus(false)
        }
        page.setStatus(true)
    }

    abstract Downloader getDownloader();
}
