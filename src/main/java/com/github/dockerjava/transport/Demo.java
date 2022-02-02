package com.github.dockerjava.transport;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Demo {
    public static void main(String[] args) throws IOException {
        ByteBuffer b = ByteBuffer.wrap("GET /\n".getBytes());
        LinuxDomainSocket s = new LinuxDomainSocket("/var/run/docker.sock");
        s.write(b);
        byte[] a = s.getInputStream().readAllBytes();
        System.out.println(new String(a));
    }
}
