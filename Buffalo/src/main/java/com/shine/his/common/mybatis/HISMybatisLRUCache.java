/*
 *    Copyright 2010 The MyBatis Team
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.shine.his.common.mybatis;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class HISMybatisLRUCache implements Cache {
    private final Ehcache delegate;
    /**
     * The {@code ReadWriteLock}.
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    /**
     * The cache id.
     */
    private final String id;
    private Map<Object, Object> keyMap;
    private Object eldestKey;

    /**
     * @param id
     */
    public HISMybatisLRUCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
        if (!HISCacheManager.getCacheManager().cacheExists(this.id)) {
            HISCacheManager.getCacheManager().addCache(this.id);
        }
        delegate = HISCacheManager.getCacheManager().getCache(this.id);
        setSize(256);
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        this.delegate.removeAll();
        keyMap.clear();
    }

    /**
     * {@inheritDoc}
     */
    public String getId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    public Object getObject(Object key) {
        try {
            Element cachedElement = delegate.get(key);
            if (cachedElement == null) {
                return null;
            }
            return cachedElement.getObjectValue();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    /**
     * {@inheritDoc}
     */
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    /**
     * {@inheritDoc}
     */
    public int getSize() {
        try {
            return delegate.getSize();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public void setSize(final int size) {
        keyMap = new LinkedHashMap<Object, Object>(size, .75F, true) {
            private static final long serialVersionUID = 4267176411845949873L;

            protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
                boolean tooBig = size() > size;
                if (tooBig) {
                    eldestKey = eldest.getKey();
                }
                return tooBig;
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    public void putObject(Object key, Object value) {
        try {
            delegate.put(new Element(key, value));
        } catch (Throwable t) {
            throw new CacheException(t);
        }
        cycleKeyList(key);
    }

    /**
     * {@inheritDoc}
     */
    public Object removeObject(Object key) {
        try {
            Object obj = this.getObject(key);
            delegate.remove(key);
            return obj;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Cache)) {
            return false;
        }

        Cache otherCache = (Cache) obj;
        return this.id.equals(otherCache.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "EHCache {"
                + this.id
                + "}";
    }


    private void cycleKeyList(Object key) {
        keyMap.put(key, key);
        if (eldestKey != null) {
            delegate.remove(eldestKey);
            eldestKey = null;
        }
    }


}
