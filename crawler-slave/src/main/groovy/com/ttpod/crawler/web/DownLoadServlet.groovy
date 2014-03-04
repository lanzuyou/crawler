package com.ttpod.crawler.web

import com.ttpod.crawler.model.Pipeline
import com.ttpod.crawler.model.Request
import com.ttpod.crawler.model.Task
import com.ttpod.crawler.process.FileProcessTask
import com.ttpod.crawler.process.HtmlProcessRequest
import com.ttpod.crawler.process.HtmlProcessTask
import com.ttpod.crawler.process.ProcessRequest

import javax.servlet.ServletConfig
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class DownLoadServlet extends HttpServlet {
    protected List<Pipeline> pipelines = new ArrayList<Pipeline>();

    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("taskId")
        String url = req.getParameter("url")
        Task task = Task.getTask(id)
        if (req.getParameter("html") != null) {
            new Thread(new HtmlProcessTask(new Request(url)))
        } else {
            new Thread(new FileProcessTask(new Request(url)))
        }
    }
}
