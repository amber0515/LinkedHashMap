package linkedHashMap;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MultiValueMap<K, V> {

    void add(K key, V value);

    void add(K key, List<V> values);

    void set(K key, V value);

    void set(K key, List<V> values);

    void remove(K key);

    void clear();

    V getValueFromKey(K key, int index);

    V getFirstValue(K key);

    /**
     * 通过key get对应的值链表
     * @param key key
     * @return list
     */
    List<V> getValuesFromKey(K key);

    /**
     * 拿到所有key的集合，因为肯定唯一，所以使用set存放
     * @return set
     */
    Set<K> getKeySet();

    /**
     * 拿到所有的value，因为有重复所以使用list存放
     * @return
     */
    List<V> getAllValues();

    /**
     * 同hashMap的单元存放。
     * @return set
     */
    Set<Map.Entry<K, List<V>>> entrySet();

    int size();

    boolean isEmpty();

    boolean containsKey(K key);


}
