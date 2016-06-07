package com.flp.pms.dao;

/*import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;

public class ProductDaoImplForMap implements IProductDao {
	
	//Central Repositary
	Map<Integer, Product> products=new HashMap<Integer, Product>();
	

	public List<Category> getAllCategory() {
		
		List<Category> categories=new ArrayList<Category>();
		categories.add(new Category(1, "Electronics", "Electronic Items"));
		categories.add(new Category(2, "Clothing", "All Cloth Varity"));
		categories.add(new Category(3, "Health&Care", "Health And Hospitality"));
		categories.add(new Category(4, "HouseHolds", "HouseHold Items"));
		categories.add(new Category(5, "Sports", "Games related Items"));
		
		return categories;
	}
	
	public List<SubCategory> getAllSubCategory() {
		
		List<SubCategory> subcategories=new ArrayList<SubCategory>();
		subcategories.add(new SubCategory(101, "Mobile",new Category(1, "Electronics", "Electronic Items")));
		subcategories.add(new SubCategory(102, "PowerBank",new Category(1, "Electronics", "Electronic Items")));
		subcategories.add(new SubCategory(103, "Data Storage",new Category(1, "Electronics", "Electronic Items")));
		
		
		subcategories.add(new SubCategory(201, "T-Shirt",new Category(2, "Clothing", "All Cloth Varity")));
		subcategories.add(new SubCategory(202, "Kurta",new Category(2, "Clothing", "All Cloth Varity")));
		subcategories.add(new SubCategory(203, "Saree",new Category(2, "Clothing", "All Cloth Varity")));
		subcategories.add(new SubCategory(204, "Kids Wear",new Category(2, "Clothing", "All Cloth Varity")));
		
		subcategories.add(new SubCategory(301,"Diabetic Shoes",new Category(3, "Health&Care", "Health And Hospitality")));
		subcategories.add(new SubCategory(302,"Diabetic Metre",new Category(3, "Health&Care", "Health And Hospitality")));
		subcategories.add(new SubCategory(303,"Blood Pressure Metre",new Category(3, "Health&Care", "Health And Hospitality")));
		
		
		subcategories.add(new SubCategory(401,"Dining Sets", new Category(4, "HouseHolds", "HouseHold Items")));
		subcategories.add(new SubCategory(402,"Cooker", new Category(4, "HouseHolds", "HouseHold Items")));
		subcategories.add(new SubCategory(403,"Knife", new Category(4, "HouseHolds", "HouseHold Items")));
		subcategories.add(new SubCategory(404,"Glasses", new Category(4, "HouseHolds", "HouseHold Items")));
		
		
		subcategories.add(new SubCategory(501, "Cricket Bat", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(502, "Cricket Ball", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(503, "Hockey bat", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(504, "Hockey Ball", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(505, "Volley Ball", new Category(5, "Sports", "Games related Items")));
		
		return subcategories;
	}

	public List<Supplier> getAllSuppliers() {
		
		List<Supplier> suppliers=new ArrayList<Supplier>();
		suppliers.add(new Supplier(111, "Tom", "Jerry", "North Avvenue", "Chennai", "Tamil Nadu", "600041", "6576575"));
		suppliers.add(new Supplier(222, "Jack", "Thomson", "South Avvenue", "Chennai", "Tamil Nadu", "600341", "78987978"));
		suppliers.add(new Supplier(333, "Kamal", "Emi", "West Avvenue", "Chennai", "Tamil Nadu", "600001", "787665765"));
		suppliers.add(new Supplier(444, "Annie", "Kenn", "EAST Avvenue", "Pune", "Maharastra", "600121", "5464565645"));
		suppliers.add(new Supplier(555, "Vimal", "Desai", "7th Avvenue", "Pune", "Maharastra", "600121", "87686787"));
		suppliers.add(new Supplier(666, "Bimal", "Singh", "12th Avvenue", "Pune", "Maharastra", "600121", "12456767"));
		return suppliers;
	}

	public List<Discount> getAllDiscounts() {
		List<Discount> discounts=new ArrayList<Discount>();
		discounts.add(new Discount(123, "Mega Offer", "Mega offer From Jan to Feb", 12.4, new Date(2009-1900, 4, 23)));
		discounts.add(new Discount(333, "Dewali Offer", "Dewali offer ", 12.4, new Date(2018-1900, 4, 23)));
		discounts.add(new Discount(678, "New Year Offer", "New Year offer ", .50, new Date(2020-1900, 4, 23)));
		discounts.add(new Discount(1234, "X'Mas Offer", "Xmas offer ", .55, new Date(2019-1900, 4, 23)));
		discounts.add(new Discount(340, "Pongal Offer", "Pongal offer ", 12.78, new Date(2017-1900, 4, 23)));
		
		
		return discounts;
	}

	public void addProduct(Product product) {
		products.put(product.getProductId(), product);
		
	}

	public Map<Integer, Product> getAllProducts() {
		
		return products;
	}
	
	

}
*/

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;
import com.flp.pms.util.DataBaseRequirements;

public class ProductDaoImplForMap implements IProductDao {

	// Central Repository
	Map<Integer, Product> products = new HashMap<Integer, Product>();

	// MySQL repository
	DataBaseRequirements daBaseRequirements = new DataBaseRequirements();

	PreparedStatement preparedStatement = null;
	PreparedStatement preparedStatement1 = null;

	public List<Category> getAllCategory() {

		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category(1, "Electronics", "Electronic Items"));
		categories.add(new Category(2, "Clothing", "All Cloth Varity"));
		categories.add(new Category(3, "Health&Care", "Health And Hospitality"));
		categories.add(new Category(4, "HouseHolds", "HouseHold Items"));
		categories.add(new Category(5, "Sports", "Games related Items"));

		return categories;
	}

	public List<SubCategory> getAllSubCategory() {

		List<SubCategory> subcategories = new ArrayList<SubCategory>();
		subcategories.add(new SubCategory(101, "Mobile", new Category(1, "Electronics", "Electronic Items")));
		subcategories.add(new SubCategory(102, "PowerBank", new Category(1, "Electronics", "Electronic Items")));
		subcategories.add(new SubCategory(103, "Data Storage", new Category(1, "Electronics", "Electronic Items")));

		subcategories.add(new SubCategory(201, "T-Shirt", new Category(2, "Clothing", "All Cloth Varity")));
		subcategories.add(new SubCategory(202, "Kurta", new Category(2, "Clothing", "All Cloth Varity")));
		subcategories.add(new SubCategory(203, "Saree", new Category(2, "Clothing", "All Cloth Varity")));
		subcategories.add(new SubCategory(204, "Kids Wear", new Category(2, "Clothing", "All Cloth Varity")));

		subcategories
				.add(new SubCategory(301, "Diabetic Shoes", new Category(3, "Health&Care", "Health And Hospitality")));
		subcategories
				.add(new SubCategory(302, "Diabetic Metre", new Category(3, "Health&Care", "Health And Hospitality")));
		subcategories.add(
				new SubCategory(303, "Blood Pressure Metre", new Category(3, "Health&Care", "Health And Hospitality")));

		subcategories.add(new SubCategory(401, "Dining Sets", new Category(4, "HouseHolds", "HouseHold Items")));
		subcategories.add(new SubCategory(402, "Cooker", new Category(4, "HouseHolds", "HouseHold Items")));
		subcategories.add(new SubCategory(403, "Knife", new Category(4, "HouseHolds", "HouseHold Items")));
		subcategories.add(new SubCategory(404, "Glasses", new Category(4, "HouseHolds", "HouseHold Items")));

		subcategories.add(new SubCategory(501, "Cricket Bat", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(502, "Cricket Ball", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(503, "Hockey bat", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(504, "Hockey Ball", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(505, "Volley Ball", new Category(5, "Sports", "Games related Items")));

		return subcategories;
	}

	public List<Supplier> getAllSuppliers() {

		List<Supplier> suppliers = new ArrayList<Supplier>();
		suppliers.add(new Supplier(111, "Tom", "Jerry", "North Avvenue", "Chennai", "Tamil Nadu", "600041", "6576575"));
		suppliers.add(
				new Supplier(222, "Jack", "Thomson", "South Avvenue", "Chennai", "Tamil Nadu", "600341", "78987978"));
		suppliers
				.add(new Supplier(333, "Kamal", "Emi", "West Avvenue", "Chennai", "Tamil Nadu", "600001", "787665765"));
		suppliers.add(new Supplier(444, "Annie", "Kenn", "EAST Avvenue", "Pune", "Maharastra", "600121", "5464565645"));
		suppliers.add(new Supplier(555, "Vimal", "Desai", "7th Avvenue", "Pune", "Maharastra", "600121", "87686787"));
		suppliers.add(new Supplier(666, "Bimal", "Singh", "12th Avvenue", "Pune", "Maharastra", "600121", "12456767"));
		return suppliers;
	}

	@SuppressWarnings("deprecation")
	public List<Discount> getAllDiscounts() {
		List<Discount> discounts = new ArrayList<Discount>();
		discounts
				.add(new Discount(123, "Mega Offer", "Mega offer From Jan to Feb", 12.4, new Date(2009 - 1900, 4, 23)));
		discounts.add(new Discount(333, "Dewali Offer", "Dewali offer ", 12.4, new Date(2018 - 1900, 4, 23)));
		discounts.add(new Discount(678, "New Year Offer", "New Year offer ", .50, new Date(2020 - 1900, 4, 23)));
		discounts.add(new Discount(1234, "X'Mas Offer", "Xmas offer ", .55, new Date(2019 - 1900, 4, 23)));
		discounts.add(new Discount(340, "Pongal Offer", "Pongal offer ", 12.78, new Date(2017 - 1900, 4, 23)));

		return discounts;
	}

	public void addProduct(Product product) {
		 products.put(product.getProductId(), product);
		 System.out.println(products);

		String sql1 = "insert into product values(?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "insert into productdiscounttable values(?,?)";
		preparedStatement = daBaseRequirements.getPreparedStatement(sql1);
		preparedStatement1 = daBaseRequirements.getPreparedStatement(sql2);
		try {

			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setDate(4, new Date(product.getManufacturing_date().getTime()));
			preparedStatement.setDate(5, new Date(product.getExpiry_date().getTime()));
			preparedStatement.setDouble(6, product.getMax_retail_price());
			preparedStatement.setInt(7, product.getCategory().getCategory_Id());
			preparedStatement.setInt(8, product.getSubCategory().getSub_category_Id());
			preparedStatement.setInt(9, product.getSupplier().getSupplierId());
			preparedStatement.setInt(10, product.getQuantity());
			preparedStatement.setFloat(11, product.getRatings());
			int rowInserted = preparedStatement.executeUpdate();
			List<Discount> temp = product.getDiscounts();
			int rowInserted1 = 0;
			for (int i = 0; i < temp.size(); i++) {
				preparedStatement1.setInt(1, product.getProductId());
				preparedStatement1.setInt(2, temp.get(i).getDiscountId());
				rowInserted1 = preparedStatement1.executeUpdate();
			}

			System.out.println(rowInserted + " product inserted " + rowInserted1 + " discount inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Map<Integer, Product> getAllProducts() {

		return products;
	}
}