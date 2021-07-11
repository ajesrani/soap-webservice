package com.soa.ws.rpc;

import codegen.HelloService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.ws.soap.MTOMFeature;

import codegen.Hello;

public class HelloTest {

	public static void main(String[] args) {
        HelloService service = new HelloService();
        Hello hello = service.getHelloPort(new MTOMFeature());
         
        String response = hello.sayHello("Chef");         
        System.out.println(response);
        
        // uploads a file
        try {
			String path = "C:/Users/ajesrani/Downloads/grid.log";
			File file = new File(path);
			FileInputStream fis = new FileInputStream(path);
			byte[] fileContent = new byte[(int) file.length()];
			fis.read(fileContent);
			hello.upload(file.getName(), fileContent);
			fis.close();
			
			System.out.println("File uploaded: " + path);

		} catch (Exception e) {
			e.printStackTrace();
		}
   
        // downloads a file
        try {
			String path = "C:/Users/ajesrani/Downloads/mytemp.txt";
			byte[] fileContent = hello.download("mytemp.txt");
			File file = new File(path);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(fileContent);
			fos.close();
			
			System.out.println("File downloaded: " + path);

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
