package com.ttpod.crawler.http;

import com.ttpod.crawler.model.Page;
import com.ttpod.crawler.model.Request;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-3-3
 * Time: 下午5:18
 * To change this template use File | Settings | File Templates.
 */
public class FileDownloader extends HttpClientDownloader {
    public static final int BUFFER_SIZE = 8192 * 16;

    protected Page handleResponse(Request request, String charset, HttpResponse httpResponse) throws IOException {
        String content = IOUtils.toString(httpResponse.getEntity().getContent(), charset);
        Page page = new Page();
        page.setRawText(content);
        page.setUrl(request.getUrl());
        page.setRequest(request);
        page.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        page.setFile(request.getFile());
        page.setSize(copy(httpResponse.getEntity().getContent(), new FileOutputStream(request.getFile())));
        return page;
    }

    public int copy(InputStream in, OutputStream out) throws IOException {
        try {
            byte[] buffer = new byte[BUFFER_SIZE];
            int byteCount = 0, bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                byteCount += bytesRead;
            }
            out.flush();
            return byteCount;
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
            }
            try {
                out.close();
            } catch (IOException ex) {
            }
        }
    }
}
