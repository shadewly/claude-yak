package com.shine.his.common.mybatis;

import org.apache.ibatis.cache.decorators.LoggingCache;

/**
 * Created by claude on 15-7-17.
 */
public class HisLoggingEhcache extends LoggingCache {
    public HisLoggingEhcache(final String id) {
        super(new HISMybatisLRUCache(id));
    }
}
