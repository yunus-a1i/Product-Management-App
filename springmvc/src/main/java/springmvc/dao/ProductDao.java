package springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import springmvc.model.Product;

@Component
public class ProductDao {

	@Autowired 
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	// get all pss
	
	public List<Product> getProducts(){
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//delete this single product
	@Transactional
	public void deleteProduct(int pid) {
	    Product product = this.hibernateTemplate.load(Product.class, pid);
	    if (product != null) {
	        this.hibernateTemplate.delete(product);  // Pass the actual Product object to delete
	    }
	}

	
	// get the single product
	
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class , pid);
	}
	
}
