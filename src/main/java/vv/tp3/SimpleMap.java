package vv.tp3;

import vv.tp3.factory.Doublet;

import java.util.*;

public class SimpleMap<K,V> implements Map<K,V> {

    List<K> k;
    List<V> v;

    public SimpleMap(){
        k = new ArrayList<K>();
        v = new ArrayList<V>();
    }




    @Override
    public int size() {
        return k.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        if (k.contains(key))
            return v.get(k.indexOf(key));
        return null;
    }

    @Override
    public V put(K key, V value){
        V before;
        if(k.contains(key)){
            k.add(k.indexOf(key),key);
            before = v.get(k.indexOf(key));
            v.add(k.indexOf(key),value);
            return before;
        }
        k.add(key);
        v.add(value);
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
