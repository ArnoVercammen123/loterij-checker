package com.arnovercammen.loterijcheckerspring.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello-world", method = RequestMethod.GET, produces = "application/json")
    public ResponseWrapper helloWorld(){
        return new ResponseWrapper("Hello World!");
    }
}
