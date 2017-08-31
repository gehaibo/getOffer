package 算法分类.经典;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Jackson on 2017/8/20.
 */
public class 最近最少使用 {
    /**
     * Created by Jackson on 2017/8/20.
     */
    public static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private int cacheSize;

        //LinkedHashMap的一个构造函数，当参数accessOrder为true时，即会按照访问顺序排序，最近访问的放在最前，最早访问的放在后面
        public LRUCache(int cacheSize) {
            super(16, 0.75f, true);
            this.cacheSize = cacheSize;
        }

        //LinkedHashMap自带的判断是否删除最老的元素方法，默认返回false，即不删除老数据
        //我们要做的就是重写这个方法，当满足一定条件时删除老数据
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() >= cacheSize;
        }
    }
}
