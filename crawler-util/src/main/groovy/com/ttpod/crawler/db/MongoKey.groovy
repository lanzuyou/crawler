package com.ttpod.crawler.db

public enum MongoKey {
    TASK_COLL("task", "schedule"),
    LOG_COLL("log", "task_log"),
    PAGE_COLL("task", "page_coll");

    private String dbName
    private String collName

    private MongoKey(String dbName, String collName) {
        this.dbName = dbName;
        this.collName = collName;
    }

    String getDbName() {
        return dbName
    }

    void setDbName(dbName) {
        this.dbName = dbName
    }

    String getCollName() {
        return collName
    }

    void setCollName(collName) {
        this.collName = collName
    }
}