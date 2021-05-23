package com.example.springboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ServiceException;
import com.example.pki.PkiHelper;

@RestController
public class HelloController {
    @RequestMapping(value = "/MessageService", produces = { MediaType.TEXT_XML_VALUE })
    public String hello() {
        InputStream x = this.getClass().getClassLoader().getResourceAsStream("response.xml");
        StringBuilder buffer = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(x, "UTF-8"));
            String l;
            while ((l = reader.readLine()) != null) {
                buffer.append(l);
            }
            int flag = 0x03;
            String signature = "";
            String data = "";
            try {
                // TODO JIBX object mapping
                PkiHelper.verifyP7Sign(Base64.decode(signature), flag, Base64.decode(data));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
