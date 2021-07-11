package com.soa.ws.main;

import javax.xml.ws.Endpoint;

/* ========= SOAP based JAX-WS Web Services ==========
 *  
 * Configure Web Services Endpoints -
 * To allow the web services to be discoverable by clients, we need to declare endpoints in JAX-WS descriptor file. 
 * Create the sun-jaxws.xml file under WEB-INF directory
 * 
 * URL: http://localhost:8080/SOAPService/ws/hello
 * 
 * wsimport -
 * Generate code for the webservice client 
 * $ wsimport -keep -p src.test.java.codegen http://localhost:8080/SOAPWebService/ws/hello?wsdl
 * 
 * wsgen -
 * The wsgen tool is used to parse an existing web service implementation class and
 * 1. Generate JAX-WS portable artifacts (Java files) for web service deployment.
 * 2. Generate WSDL and xsd files, for testing or web service client development.
 * $ wsgen -verbose -keep -cp . com.bmc.ao.soa.Hello
 * $ wsgen -verbose -keep -cp . com.bmc.ao.soa.Hello -wsdl
 * 
 * MTOM (Message Transmission Optimization Mechanism) can be used to optimize binary data transfer via JAX-WS web services.
 * The SOAP message itself doesn’t contain the binary data. Instead, it has a reference to the part that contains the actual binary data.
 * The binary data is attached to the request as a MIME attachment 
 */

import com.soa.ws.rpc.Hello;

public class Main {

	public static void main(String[] args) {
		String bindingURI = "http://localhost:9090/SOAPWebService/ws/hello";
		Endpoint.publish(bindingURI, new Hello());
        System.out.println("Server started at: " + bindingURI);

	}

}
