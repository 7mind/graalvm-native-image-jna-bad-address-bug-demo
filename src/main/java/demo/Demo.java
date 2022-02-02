package demo;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.netty.NettyDockerCmdExecFactory;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        DefaultDockerClientConfig configBuilder = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
        NettyDockerCmdExecFactory factory = new NettyDockerCmdExecFactory();

        DockerClient client = DockerClientImpl.getInstance(configBuilder).withDockerCmdExecFactory(factory);
//                new OkDockerHttpClient.Builder().dockerHost(configBuilder.getDockerHost()).sslConfig(configBuilder.getSSLConfig()).build()


        System.out.println(client.listImagesCmd().exec());
        factory.close();
    }
}
