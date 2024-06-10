package com.example.BES.client;

import com.example.BES.config.BESConnector;
import com.example.BES.soap.*;

//import jakarta.xml.bind.JAXBContext;
//import jakarta.xml.bind.JAXBException;
//import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
//import javax.xml.bind.Marshaller;
import java.io.StringWriter;

//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.JAXBException;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;

@Service
public class SoapClient {

    @Autowired
    private Jaxb2Marshaller marshaller;

    //@Autowired
    private WebServiceTemplate template;

    @Autowired
    private BESConnector besConnector;

    public String getPassword() throws JAXBException {

        String getPasswordUri = "https://bsestarmfdemo.bseindia.com/MFOrderEntry/MFOrder.svc/Secure";

        ObjectFactory objectFactory = new ObjectFactory();
        GetPassword passwordReq = objectFactory.createGetPassword();// GetPassword();
       // OrderData order = new OrderData();
        JAXBElement<String> userId = objectFactory.createString("abc");
        JAXBElement<String> password = objectFactory.createString("xyz");
        JAXBElement<String> passKey = objectFactory.createString("er34");

        passwordReq.setUserId(userId);
        passwordReq.setPassword(password);
        passwordReq.setPassKey(passKey);

       // GetPasswordResponse response = new GetPasswordResponse();
      //  response.setGetPasswordResult(passwordReq.getPassword());
       // response.getGetPasswordResult();

        // marshling and unmarshling

      //  JAXBContext jaxb = JAXBContext.newInstance(GetPassword.class);
       // Marshaller marshaller = jaxb.createMarshaller();
      //  marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      //  StringWriter writer = new StringWriter();
      //  marshaller.marshal(passwordReq, writer);

      //  System.out.println("xml file value: "+writer);

      //  template = new WebServiceTemplate((WebServiceMessageFactory) marshaller);
        // orderRequest.setData();
       // besConnector.setMarshaller((org.springframework.oxm.Marshaller) marshaller);
       // besConnector.callWebService(reqUri,passwordReq);

        System.out.println("getContextPath() value: "+marshaller.getContextPath());

        template = new WebServiceTemplate(marshaller);
       Object response = template.marshalSendAndReceive(getPasswordUri,passwordReq);
       System.out.println();
       return "";
    }
}

