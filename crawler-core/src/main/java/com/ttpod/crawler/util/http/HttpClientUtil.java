package com.ttpod.crawler.util.http;

import com.ttpod.crawler.model.Site;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-27
 * Time: 下午4:17
 * To change this template use File | Settings | File Templates.
 */
@ThreadSafe
public class HttpClientUtil {
    private final Map<String, CloseableHttpClient> httpClients = new HashMap<String, CloseableHttpClient>();
    private HttpClientManager manager = new HttpClientManager();

    private CloseableHttpClient getHttpClient(Site site) {
        if (site == null) {
            return manager.getClient(null);
        }
        String domain = site.getDomain();
        CloseableHttpClient httpClient = httpClients.get(domain);
        if (httpClient == null) {
            synchronized (this) {
                httpClient = httpClients.get(domain);
                if (httpClient == null) {
                    httpClient = manager.getClient(site);
                    httpClients.put(domain, httpClient);
                }
            }
        }
        return httpClient;
    }
}
