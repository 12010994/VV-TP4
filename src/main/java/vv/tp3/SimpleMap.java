package vv.tp3;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class SimpleMap<K,V> implements Map<K,V> {

    public List<K> k;
    public List<V> v;

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
        return k.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return k.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return v.contains(value);
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
            k.set(k.indexOf(key),key);
            before = v.get(k.indexOf(key));
            v.remove(k.indexOf(key));
            v.add(k.indexOf(key),value);
            return before;
        }
        k.add(key);
        v.add(value);
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
    public void putAll(Map<? extends K, ? extends V> m) {
        for(K key: m.keySet()){
            put(key, m.get(key));
        }
    }

    @Override
    public void clear() {
        k.clear();
        v.clear();
    }

    @Override
    public Set<K> keySet() {

        return new HashSet<K>(k);
    }

    @Override
    public Collection<V> values() {
        return new ArrayList<V>(v);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new NotImplementedException();
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
}