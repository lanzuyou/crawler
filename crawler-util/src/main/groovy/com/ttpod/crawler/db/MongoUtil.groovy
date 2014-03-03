package com.ttpod.crawler.db

import com.mongodb.*
import com.ttpod.crawler.util.PropertiesUtil

class MongoUtil {
    private static Mongo mongo
    private static PropertiesUtil prop
    private static def mongoMap = [:]

    static {
        String test = System.getProperty("test")
        if (test) {
            prop = PropertiesUtil.getProperties('mongotest.properties')
        } else {
            prop = PropertiesUtil.getProperties('mongo.properties')
        }

    }

    public static Mongo getMongo() {
        if (mongo == null) {
            mongo = getMongo(prop.getProperty('mongo.url'), prop.getProperty('mongo.port') as int)
        }

        return mongo

    }

    public static Mongo getMongo(String host, int port) {
        String address = new StringBuffer(host).append(":").append(port)
        if (mongoMap.get(address) == null) {
            MongoOptions mongoOptions = new MongoOptions();
            mongoOptions.maxWaitTime = (prop.getProperty('mongo.maxWaitTime') as int)
            mongoOptions.connectTimeout = (prop.getProperty('mongo.connectTimeout') as int)
            mongoOptions.socketTimeout = (prop.getProperty('mongo.socketTimeout') as int)
            mongoOptions.connectionsPerHost = (prop.getProperty('mongo.connectionsPerHost') as int)
            ServerAddress serverAddress = new ServerAddress(host, port)
            mongoMap = [address, new Mongo(serverAddress, mongoOptions)]
        }

        return mongoMap.get(address) as Mongo
    }

    public static DB getDB(String db) {
        return getMongo().getDB(db)
    }

    public static DBCollection getColl(MongoKey key) {
        return getMongo().getDB(key.getDbName()).getCollection(key.getCollName())
    }

    public static DBCollection getColl(String db, String coll) {
        return getMongo().getDB(db).getCollection(coll)
    }

    static main(a) {
        println getMongo()
        System.currentTimeMillis()
    }
}
