package com.soa.ws.document;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface = "com.soa.ws.document.ProductService")
public class ProductServiceImpl implements ProductService {
	
	private static List<Product> productCatalog;
	
	public ProductServiceImpl() {
        initializeProductCatalog();
    }

	public Product searchById(int id) throws Exception {
		for (Product p : productCatalog) if (p.getId() == id) return p;
        throw new Exception("No product found with id " + id);
	}

	public Product[] getAllProducts() {
		Product[] products = new Product[productCatalog.size()];
        int i = 0;
        
        for (Product p : productCatalog) {
            products[i] = p;
            i++;
        }
        
        return products;
	}

	public void insertProduct(Product product) {
		productCatalog.add(product);	
	}
	
	
	private void initializeProductCatalog() {
		productCatalog = new ArrayList<Product>();
        productCatalog.add(new Product(123124, "Keyboard", 29.99D));
        productCatalog.add(new Product(223425, "Mouse", 9.95D));
        productCatalog.add(new Product(364533, "LCD Projector", 1199.19D));
		
	}

}
