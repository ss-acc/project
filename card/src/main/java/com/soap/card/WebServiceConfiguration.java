package com.soap.card;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/CardService/*");
	}
	
	@Bean(name = "cards")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema cardSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CardServiceSoapHttp");
		wsdl11Definition.setLocationUri("/CardService");
		wsdl11Definition.setTargetNamespace("interfaces.soap.com");
		wsdl11Definition.setSchema(cardSchema);
		return wsdl11Definition;
	}
	
	
	
	@Bean
	public XsdSchema cardSchema() {
		return new SimpleXsdSchema(new ClassPathResource("card.xsd"));
	}
	
}

