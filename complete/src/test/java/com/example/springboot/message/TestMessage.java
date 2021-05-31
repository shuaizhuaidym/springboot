package com.example.springboot.message;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMessage {
	private final static Logger logger = LoggerFactory.getLogger(TestMessage.class);

	private IBindingFactory factory;
	private StringWriter writer;
	private StringReader reader;

	private final String CHAR_SET = "utf-8";

	String toXML(Message request) throws JiBXException, IOException {
		factory = BindingDirectory.getFactory(Message.class);
		writer=new StringWriter();
		IMarshallingContext mctx = factory.createMarshallingContext();
		mctx.setIndent(4);

		mctx.marshalDocument(request, CHAR_SET, null, writer);
		String xml = writer.toString();

		writer.close();
		return xml;
	}

	Message fromXML(String xml) throws JiBXException {
		reader = new StringReader(xml);

		IUnmarshallingContext uctx = factory.createUnmarshallingContext();
		Message req = (Message) uctx.unmarshalDocument(reader);

		return req;

	}

	public static void main(String[] args) throws JiBXException, IOException {
	    System.out.println(TestMessage.class.getClassLoader());
		TestMessage test = new TestMessage();
		Message req = new Message();
		String xml = test.toXML(req);
		logger.info(String.format("Serial result:%s\r\n", xml));

		Message request = test.fromXML(xml);
		logger.info("Deserial result:" + request.toString());
	}
}
