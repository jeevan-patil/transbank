package com.transbank.online;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class Test {
    public static void main(String a[]) {
	StandardPasswordEncoder ste = new StandardPasswordEncoder();
	System.out.println(ste.encode("patil"));
    }
}
