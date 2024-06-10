package com.example.BES.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.Marshaller;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller jaxB = new Jaxb2Marshaller();
        jaxB.setContextPath("com.example.BES.soap");
       // jaxB.setPackagesToScan("com.example.BES.soap");
        //jaxB.setLazyInit(true);
        //jaxB.setSupportDtd(true);
        return jaxB;
    }

    @Bean
     public WebServiceTemplate template() {
        //return new WebServiceTemplate(marshaller());
        return new WebServiceTemplate(marshaller());
     }

    @Bean
    public BESConnector besConnector(Jaxb2Marshaller marshaller) {
        BESConnector client = new BESConnector();
        client.setDefaultUri("https://bsestarmfdemo.bseindia.com/MFOrderEntry/MFOrder.svc/Secure");
        //client.setMarshaller(marshaller);
        //client.setUnmarshaller(marshaller);
        return client;
    }

   // @Bean
    public BESConnector besConnectorJaxb(Marshaller marshaller) {
        BESConnector client = new BESConnector();
        client.setDefaultUri("https://bsestarmfdemo.bseindia.com/MFOrderEntry/MFOrder.svc/Secure");
        client.setMarshaller((org.springframework.oxm.Marshaller) marshaller);
        client.setUnmarshaller((org.springframework.oxm.Unmarshaller) marshaller);
        return client;
    }
}
