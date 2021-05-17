package com.example.springboot.message;

public class Request {
	head head;
	body body;

	public Request() {
		head = new head();
		body = new body();
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
	String token;
	String qrcode;

	public authCredential() {
		authMode = "cert";
		token = "0x34jkljkdgf";
		qrcode = "0xzqgdfglkgf";
	}
}

class attributes {
	String attributeType = "all";
}