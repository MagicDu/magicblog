package cn.magicdu.blog;

/**
 * common return message
 * @author  magicdu
 * @version 1.0.0
 */
public class Msg {
    private Object key;
    private Object value;

    private Msg(){}
    
    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    private static final Msg msg=new Msg();
    public static Msg getInstance(){
        return msg;
    }
}
