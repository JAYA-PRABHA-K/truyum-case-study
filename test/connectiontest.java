package test;
import DAO.ConnectionHandeler;
import DAO.MenuItemDaoCollectionImpl;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.*;

public class connectiontest {

	MenuItemDaoCollectionImpl obj1= new MenuItemDaoCollectionImpl();
	
	@Test
	public void testassert() {
		try {
			assertNotNull(ConnectionHandeler.getConnection());
			assertNull(ConnectionHandeler.getConnection());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testtrue() {
		
		assertTrue((obj1.getMenuItemListAdmin()).size()==5);
		assertFalse((obj1.getMenuItemListCustomer()).size()==3);
	}

}
