package com.soa.ws.document;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface ProductService {
	
	@WebMethod
	public Product searchById(int id) throws Exception;
	
	@WebMethod
	public Product[] getAllProducts();
	
	@WebMethod
	public void insertProduct(Product product);

}
