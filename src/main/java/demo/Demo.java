package demo;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
//import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import com.github.dockerjava.zerodep.ZerodepDockerHttpClient;

import java.time.Duration;

public class Demo {
    public static void main(String[] args) {
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();

//        DockerClientFactory
        DockerClient client = DockerClientImpl.getInstance(
                config,
new ZerodepDockerHttpClient.Builder().dockerHost(config.getDockerHost()).sslConfig(config.getSSLConfig()).build()
                );

        System.out.println(client.listImagesCmd().exec());
//        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
//                .dockerHost(config.getDockerHost())
//                .sslConfig(config.getSSLConfig())
//                .maxConnections(100)
//                .connectionTimeout(Duration.ofSeconds(30))
//                .responseTimeout(Duration.ofSeconds(45))
//                .build();
//
//        DockerHttpClient.Request request = DockerHttpClient.Request.builder()
//                .method(DockerHttpClient.Request.Method.GET)
//                .path("/_ping")
//                .build();
//
//        try (DockerHttpClient.Response response = httpClient.execute(request)) {
//            assertThat(response.getStatusCode(), equalTo(200));
//            assertThat(IOUtils.toString(response.getBody()), equalTo("OK"));
//        }
    }
}
