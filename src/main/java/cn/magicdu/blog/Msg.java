package cn.magicdu.blog;

/**
 * common return message
 * @author  magicdu
 * @version 1.0.0
 */
public class Msg<K,V> {
    private K key;
    private V value;

    private Msg(){
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static  Msg getInstance(){
        return new Msg();
    }
}
