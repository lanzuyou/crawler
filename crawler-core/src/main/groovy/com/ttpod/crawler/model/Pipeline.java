package com.ttpod.crawler.model;

public interface Pipeline {

    public void process(Page page, Task task);
}
