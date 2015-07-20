package client;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.shine.his.store.pojo.StoreCheckMaster;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.*;

/**
 * Created by claude on 15-7-13.
 */
public class SimpleTest {
    public  void main1(String[] args) {
        // 使用默认配置文件创建CacheManager
        CacheManager manager = CacheManager.create();
        manager.addCache("ff");
// 通过manager可以生成指定名称的Cache对象
        Cache cache = cache = manager.getCache("ff");
// 使用manager移除指定名称的Cache对象
//        manager.removeCache("demoCache");
//        可以通过调用manager.removalAll() 来移除所有的Cache。通过调用manager的shutdown() 方法可以关闭CacheManager。
//        有了Cache对象之后就可以进行一些基本的Cache操作，例如：
//往cache中添加元素
        Element element = new Element("key", "value111");
        cache.put(element);
//从cache中取回元素
        Element element1 = cache.get("key");
        List list=null;
      System.out.println(  element1.getObjectValue());
//从Cache中移除一个元素
        cache.remove("key");
        manager.shutdown();
    }
    public static void main(String[] args) {
        HashMap map = new HashMap();

        for(int i = 0 ; i < 100 ; i ++){

            HashMap m1 = new HashMap();

            m1.put("pp900_88", i);

            m1.put("pp900_59", 30);

            m1.put("pp900_62", 6);

            m1.put("pp900_63", 4);

            m1.put("pp900_60", "y");

            m1.put("pp900_61", i);

            int hs = m1.hashCode();

            map.put(hs, map.get(hs)+","+i);
            //            System.out.println(i+"==="+m1.hashCode());
        }
        System.out.println(map.size());
        System.out.println(map);

        Page page=new Page();
    }

}
