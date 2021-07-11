package com.soa.ws.rpc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.soap.MTOM;

/*
 * The @MTOM annotation has two optional parameters:
 * enabled: specifies whether MTOM feature is enabled (true) or disabled (false).
 * threshold: specifies the size (in bytes) above which the binary data will be sent as attachment. 
 * This would be useful to enable MTOM only for data which is larger than a specified amount.
 */

@WebService
@SOAPBinding(style = Style.RPC)
@MTOM(enabled = true, threshold = 10240)
public class Hello {
 
    @WebMethod
    public String sayHello(String name) {
        return String.format("Hello %s", name);
    }
    
    @WebMethod
	public void upload(String fileName, byte[] fileContent) {
		
		try {
			String path = "C:/temp" + File.separator + fileName;
			File file = new File(path);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(fileContent);
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @WebMethod
	public byte[] download(String fileName) {
    	
		try {
			String path = "C:/temp" + File.separator + fileName;
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			byte[] fileContent = new byte[(int) file.length()];
			fis.read(fileContent);
			fis.close();
			
			return fileContent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
