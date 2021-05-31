package com.example.springboot.message;

public class Message {
    head head;
    body body;

    public Message() {
        head = new head();
        body = new body();
    }

    public String toString() {
        StringBuilder string = new StringBuilder("original:").append(body.authen.authCredential.original);
        return string.append("--detach").append(body.authen.authCredential.detach).toString();
    }

    public String getOriginal() {
        return body.authen.authCredential.original;
    }

    public String getDetach() {
        return body.authen.authCredential.detach;
    }
}

class head {

    String version;
    String serviceType;

    public head() {
        version = "1.0";
        serviceType = "AuthenService";
    }
}

class body {
    clientInfo clientInfo;
    String appId;
    boolean accessControl;
    attributes attributes;
    authen authen;

    public body() {
        appId = "testApp";
        accessControl = true;
        clientInfo = new clientInfo();
        authen = new authen();
    }

}

class clientInfo {
    String clientIP;

    public clientInfo() {
        clientIP = "192.168.1.1";
    }
}

class authen {
    authCredential authCredential;

    public authen() {
        authCredential = new authCredential();

    }
}

class authCredential {
    String authMode;
    String detach;
    String original;

    public authCredential() {
        authMode = "cert";
        detach = "0x34jkljkdgf";
        original = "0xzqgdfglkgf";
    }
}

class attributes {
    String attributeType = "all";
}