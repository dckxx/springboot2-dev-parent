package com.dckxx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dckxx
 */
@RestController
public class HelloWorldController {

    @GetMapping("test")
    public String test() {
        return "Hello World!";
    }
}
