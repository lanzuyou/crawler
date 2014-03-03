package com.ttpod.crawler.http;

import com.ttpod.crawler.model.Page;
import com.ttpod.crawler.model.Request;
import com.ttpod.crawler.model.Task;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-3-3
 * Time: 上午11:50
 * To change this template use File | Settings | File Templates.
 */
public interface Downloader {
    public Page download(Request request, Task task);

    public void setThread(int threadNum);
}
