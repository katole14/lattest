package com.flp.pms.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.pms.dao.IProductDao;
import com.flp.pms.dao.ProductDaoImplForMap;
import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;

public class ProductServiceImpl implements IProductService{
	
	private IProductDao iProductDao=new ProductDaoImplForMap();

	public List<Category> getAllCategory() {
		return iProductDao.getAllCategory();
	}

	public List<SubCategory> getAllSubCategory() {
		return iProductDao.getAllSubCategory();
	}

	public List<Discount> getAllDiscounts() {
		
		return iProductDao.getAllDiscounts();
	}

	public void addProduct(Product product) {
		Map<Integer, Product> maps=iProductDao.getAllProducts();
		boolean flag=false;
		Set<Integer> product_IDS=maps.keySet();
		int product_id_generated=generateProductId();
		
		//Generate unique Product Id
		if(!maps.isEmpty()){
			do{
				
				product_id_generated=generateProductId();
				for(Integer product_Id:product_IDS){
					if(product_Id==product_id_generated){
						flag=true;
						break;
					}
				}
			}while(flag);
			
			
		}
		product.setProductId(product_id_generated);
		
		iProductDao.addProduct(product);
	}

	
	public int generateProductId(){
		return (int)(Math.random()*10000);
	}

	public Map<Integer, Product> getAllProducts() {
		
		return iProductDao.getAllProducts();
	}

	public List<Supplier> getAllSuppliers() {
		
		return iProductDao.getAllSuppliers() ;
	}
	
	
}
