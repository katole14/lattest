package cap.org;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.flp.pms.service.IProductService;
import com.flp.pms.service.ProductServiceImpl;
import com.flp.pms.view.UserInteraction;

public class MyTest {
	ProductServiceImpl productPerviceImp=new ProductServiceImpl();
UserInteraction userinteraction;

@Before
public void testMyProdutBefore(){
	
	ProductServiceImpl productPerviceImp=new ProductServiceImpl();
	UserInteraction userInteraction=new UserInteraction();
	
}

@After
@Test
public void testMyProductAfter(){
	
	int i=productPerviceImp.generateProductId();
	System.out.println(i);
	String str=String.valueOf(i);
	int len=str.length();
	assertEquals(4, len);
	
}

}
