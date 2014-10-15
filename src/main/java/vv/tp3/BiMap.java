package vv.tp3;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public boolean containsKey(Object key) {
        return k.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return v.contains(value);
    }

    public V get(Object key) {
        if (k.contains(key))
            return v.get(k.indexOf(key));
        return null;
    }

    @Override
    public V remove(Object key) {
        V before;
        if(k.contains(key)){
            before = get(key);
            v.remove(k.indexOf(key));
            k.remove(key);
            return before;
        }
        return null;
    }

    @Override
    public int size() {
        return k.size();
    }

    @Override
    public void clear() {
        k.clear();
        v.clear();
    }

    @Override
    public boolean isEmpty() {
        return k.isEmpty();
    }

    public boolean equals(Object o){
        if(o instanceof SimpleMap){
            SimpleMap map = (SimpleMap) o;
            if(v.equals(map.v) && k.equals(map.k)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode(){
        return k.hashCode()+v.hashCode();
    }

    @Override
    public Set<K> keySet() {

        return new HashSet<K>(k);
    }
}
