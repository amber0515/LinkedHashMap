package linkedHashMap;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BasicHashMap<K, V> implements MultiValueMap<K, V> {

    private Map<K, List<V>> mSource;

    public BasicHashMap(Map<K, List<V>> source){
        this.mSource = source;
    }

    public void add(K key, V value) {
        if (!containsKey(key)){
            mSource.put(key, new ArrayList<V>(1));
        }
        getValuesFromKey(key).add(value);
    }

    public void add(K key, List<V> values) {
        if (!containsKey(key)){
            mSource.put(key, values);
        }else {
            getValuesFromKey(key).addAll(values);
        }
    }

    public V getValueFromKey(K key, int index) {
        List<V> values = getValuesFromKey(key);
        if (values != null && values.size() > index){
            return values.get(index);
        }
        return null;
    }

    public List<V> getAllValues() {
        List<V> allValues = new ArrayList<V>();
        Set<K> keySet = getKeySet();
        for (K key : keySet){
            allValues.addAll(getValuesFromKey(key));
        }
        return allValues;
    }

    public Set<Map.Entry<K, List<V>>> entrySet() {
        return mSource.entrySet();
    }

    public void set(K key, V value) {
        remove(key);
        add(key, value);
    }

    public void set(K key, List<V> values) {
        mSource.put(key, values);
    }

    public V getFirstValue(K key) {
        return getValueFromKey(key, 0);
    }

    public List<V> getValuesFromKey(K key) {
        return mSource.get(key);
    }

    public Set<K> getKeySet() {
        return mSource.keySet();
    }

    public void remove(K key) {
        mSource.remove(key);
    }

    public void clear() {
        mSource.clear();
    }

    public int size() {
        return mSource.size();
    }

    public boolean isEmpty() {
        return mSource.isEmpty();
    }

    public boolean containsKey(K key) {
        return mSource.containsKey(key);
    }
}
