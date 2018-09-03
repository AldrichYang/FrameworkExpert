package netty.codedecode.marshalling;

import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

/**
 * Created by yh on 2018/6/15.
 */
public class MarshallingCodeCFactory {
    /**
     * 创建Jboss Marshalling解码器的MarshallingDecoder
     *
     * @return
     */
    public static MarshallingDecoder buildMarshallingDecoder() {
        // Marshalling工具类静态方法获取MarshallerFactory实例，参数serial表示创建的是Java序列化工厂对象
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(marshallerFactory, configuration);
        //Netty支持的marshalling解码器，支持半包和粘包的处理
        return new MarshallingDecoder(provider, 1024);
    }

    /**
     * 创建Jobss Marshalling编码器MarshallingEncoder
     *
     * @return
     */
    public static MarshallingEncoder buildMarshallingEncoder() {
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        MarshallerProvider provider = new DefaultMarshallerProvider(marshallerFactory, configuration);
        // 用于将实现序列化接口的POJO对象序列化为二进制数组
        return new MarshallingEncoder(provider);
    }
}

