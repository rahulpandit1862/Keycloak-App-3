package com.myapp.keycloak.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/hello-1")
    @PreAuthorize("hasRole('client_user')")
    public String hello1() {
        return "Hello from - USER";
    }

    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('client_admin')")
    public String hello2() {
        return "Hello from - ADMIN";
    }

    @GetMapping("/hello-3")
    @PreAuthorize("hasRole('client_admin') or hasRole('client_user')")
    public String hello3() {
        return "Hello from - ADMIN & USER";
    }

}