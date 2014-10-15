package vv.tp3;


import java.util.ArrayList;
import java.util.List;

public class BiMap<K,V> extends SimpleMap<K,V> {

    List<K> k;
    List<V> v;

    public BiMap(){
        k = new ArrayList<K>();
        v = new ArrayList<V>();
    }

    @Override
    public V put(K key, V value){

        if(k.contains(key)){
            removeValue(key);
        }
        if (v.contains(value)){
            removeValue(k.get(v.indexOf(value)));
        }
        k.add(key);
        v.add(value);

        return value;
    }

    public K removeValue(Object key) {
        K before;
        if(k.contains(key)){
            before = k.get(k.indexOf(key));
            v.remove(k.indexOf(key));
            k.remove(key);
            return before;
        }
        return null;

    }

    public K getByValue(Object value) {
        if (v.contains(value))
            return k.get(v.indexOf(value));
        return null;
    }

    public boolean containsValue(Object value) {
        return v.contains(value);
    }

    public V get(Object key) {
        if (k.contains(key))
            return v.get(k.indexOf(key));
        return null;
    }
}
