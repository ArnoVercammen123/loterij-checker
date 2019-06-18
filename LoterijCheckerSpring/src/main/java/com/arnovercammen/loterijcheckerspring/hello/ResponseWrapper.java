package com.arnovercammen.loterijcheckerspring.hello;

public class ResponseWrapper {

    private String response;
    public ResponseWrapper(String s) {
        response = s;
    }

    public String getResponse(){
        return response;
    }
}
