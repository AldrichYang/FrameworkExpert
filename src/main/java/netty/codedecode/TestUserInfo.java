package netty.codedecode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by yh on 2018/6/13.
 */
public class TestUserInfo {
    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.buildUserId(100).buildUserName("Welcome to Netty");
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream os = new ObjectOutputStream(bos)) {
            // 序列化
            os.writeObject(info);
            os.flush();
            byte[] b = bos.toByteArray();
            System.out.println("The jdk serializable length is : " + b.length);

            // 二进制编码
            System.out.println("The byte array serializable length is:  " + info.codeC().length);
        }


    }
}
