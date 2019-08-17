import org.junit.Test;

import java.util.Base64;
import java.util.Objects;

/**
 * Created on 2019/4/30.
 */
public class Tests {
    @Test
    public void encodeAuth() throws Exception{
        byte[] encode = Base64.getEncoder().encode("root:root".getBytes("US-ASCII"));
        System.out.println(new String(encode));
    }
    @Test
    public void testNull(){
        System.out.println(null instanceof Object);
    }
}
