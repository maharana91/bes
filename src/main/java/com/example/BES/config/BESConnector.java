package com.example.BES.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class BESConnector extends WebServiceGatewaySupport {

    public Object callWebService(String url, Object request) {
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }
}
