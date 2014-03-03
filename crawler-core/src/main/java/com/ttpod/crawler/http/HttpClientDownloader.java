package com.ttpod.crawler.http;

import com.ttpod.crawler.model.Page;
import com.ttpod.crawler.model.Request;
import com.ttpod.crawler.model.Site;
import com.ttpod.crawler.model.Task;
import com.ttpod.crawler.util.HtmlUtil;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-3-3
 * Time: 下午1:45
 * To change this template use File | Settings | File Templates.
 */
public abstract class HttpClientDownloader implements Downloader {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private HttpClientManager clientManager = new HttpClientManager();

    @Override
    public Page download(Request request, Task task) {
        logger.info("downloading page " + request.getUrl());
        Site site = null;
        if (task != null) {
            site = task.getSite();
        } else {
            site = new Site();
        }
        Set<Integer> acceptStatCode = site.getAcceptStatCode();
        String charset = site.getCharset();

        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = clientManager.getHttpClient(site).execute(clientManager.bulidRequest(request, site));
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (acceptStatCode.contains(statusCode)) {
                //charset
                if (charset == null) {
                    String value = httpResponse.getEntity().getContentType().getValue();
                    charset = HtmlUtil.getCharset(value);
                }
                return handleResponse(request, charset, httpResponse);
            } else {
                logger.warn("code error " + statusCode + "\t" + request.getUrl());
                return null;
            }
        } catch (IOException e) {
            logger.warn("download page " + request.getUrl() + " error", e);
            if (site.getCycleRetryTimes() > 0) {
                return addToCycleRetry(request, site);
            }
            return null;
        } finally {
            try {
                if (httpResponse != null) {
                    //ensure the connection is released back to pool
                    EntityUtils.consume(httpResponse.getEntity());
                }
            } catch (IOException e) {
                logger.warn("close response fail", e);
            }
        }
    }

    protected abstract Page handleResponse(Request request, String charset, HttpResponse httpResponse) throws IOException;

    private Page addToCycleRetry(Request request, Site site) {
        Page page = new Page();
//        Object cycleTriedTimesObject = request.getExtra(Request.CYCLE_TRIED_TIMES);
//        if (cycleTriedTimesObject == null) {
//            page.addTargetRequest(request.setPriority(0).putExtra(Request.CYCLE_TRIED_TIMES, 1));
//        } else {
//            int cycleTriedTimes = (Integer) cycleTriedTimesObject;
//            cycleTriedTimes++;
//            if (cycleTriedTimes >= site.getCycleRetryTimes()) {
//                return null;
//            }
//            page.addTargetRequest(request.setPriority(0).putExtra(Request.CYCLE_TRIED_TIMES, 1));
//        }
        return page;
    }

    @Override
    public void setThread(int threadNum) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
