package vv.tp3;


import vv.tp3.factory.Factory;


public class LazyBiMap<K,V> extends BiMap<K,V> {

    public LazyBiMap(Factory<K, V> keyFactory, Factory<V, K> valueFactory) {
   }
    //TODO
    public V get(Object key){
        if (k.contains(key)) {
            return v.get(k.indexOf(key));
        }else{
            return put((K)key, (V)key);

        }
    }
}
