package com.ttpod.crawler.http;

import com.ttpod.crawler.model.Page;
import com.ttpod.crawler.model.Request;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-3-3
 * Time: 下午5:18
 * To change this template use File | Settings | File Templates.
 */
public class HtmlDownloader extends HttpClientDownloader {
    protected Page handleResponse(Request request, String charset, HttpResponse httpResponse) throws IOException {
        String content = IOUtils.toString(httpResponse.getEntity().getContent(), charset);
        Page page = new Page();
        page.setRawText(content);
        page.setUrl(request.getUrl());
        page.setRequest(request);
        page.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        return page;
    }
}
