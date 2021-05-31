package com.example.springboot;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Map;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ServiceException;
import com.example.pki.PkiHelper;
import com.example.springboot.message.Message;

@RestController
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    private IBindingFactory factory = null;
    private StringWriter writer;
    private StringReader reader;

    private final String CHAR_SET = "utf-8";

    public HelloController() {
        try {
            factory = BindingDirectory.getFactory(Message.class);
        } catch (JiBXException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/MessageService", consumes = { MediaType.TEXT_XML_VALUE })
    public String message(@RequestBody String xml) {

        logger.debug("Request xml is:" + xml);
        try {
            Message request = fromXML(xml);

            logger.debug(String.format("Request object to string:%s", request.toString()));

            int flag = 0x03;

            String original = request.getOriginal();
            String signature = request.getDetach();
            try {
                Map<String, Object> result = PkiHelper.verifyP7Sign(signature.getBytes(), flag, original.getBytes());
                if ((long) result.get("errorCode") == 0L) {
                    byte[] bytes = (byte[]) result.get("cert");
                    CertificateFactory factory = CertificateFactory.getInstance("X.509");
                    java.security.cert.X509Certificate certificate = (X509Certificate) factory
                            .generateCertificate(new ByteArrayInputStream(bytes));
                    return certificate.getSubjectDN().getName();
                }else{
                    return result.get("errorCode").toString();
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "xml";
    }

    // JIBX序列化
    String toXML(Message request) throws JiBXException, IOException {
        writer = new StringWriter();
        IMarshallingContext mctx = factory.createMarshallingContext();
        mctx.setIndent(4);

        mctx.marshalDocument(request, CHAR_SET, null, writer);
        String xml = writer.toString();

        writer.close();
        return xml;
    }

    // JIBX反序列化
    Message fromXML(String xml) throws JiBXException {
        reader = new StringReader(xml);

        IUnmarshallingContext uctx = factory.createUnmarshallingContext();
        Message req = (Message) uctx.unmarshalDocument(reader);

        return req;

    }

}
