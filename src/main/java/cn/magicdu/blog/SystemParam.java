package cn.magicdu.blog;

/**
 * system common params
 * @author  magicdu
 * @version 1.0.0
 */
public enum SystemParam{
    // status
    OK,
    ERROR,
    SUCCESS,
    EXCEPTION,
    //type
    String,
    Date,
    Interger,
    Int,
    Float,
    Double,
    //role
    Admin,
    Reader,
    Writer,
    Visitor;
    public static final long EXPIRATION_TIME = 432_000_000;     // 5天(以毫秒ms计)
    public static final String SECRET = "magicTokenSecret";      // JWT密码
    public static final String TOKEN_PREFIX = "bickcess";         // Token前缀
    public static final String HEADER_STRING = "Authorization"; // 存放Token的Header Key

    private SystemParam(){}
}
