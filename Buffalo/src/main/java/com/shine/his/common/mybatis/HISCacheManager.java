package com.shine.his.common.mybatis;

import net.sf.ehcache.CacheManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by claude on 15-7-20.
 */
public class HISCacheManager {
    /**
     * The cache manager reference.
     */
    private static CacheManager CACHE_MANAGER = null;

    private HISCacheManager() {

    }

    public static synchronized CacheManager getCacheManager() {
        if (CACHE_MANAGER == null) {
            CACHE_MANAGER = createCacheManager();
        }
        return CACHE_MANAGER;
    }

    /**
     * Looks for "/ehcache.xml" classpath resource and builds the relative
     * {@code CacheManager}; if it's no found or it is impossible to load it,
     * returns the default manager.
     *
     * @return the application cache manager.
     */
    private static CacheManager createCacheManager() {
        CacheManager cacheManager;
        InputStream input = HISMybatisLRUCache.class.getResourceAsStream("/ehcache.xml");

        if (input != null) {
            try {
                cacheManager = CacheManager.create(input);
            } catch (Throwable t) {
                cacheManager = CacheManager.create();
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        } else {
            cacheManager = CacheManager.create();
        }

        return cacheManager;
    }
}
