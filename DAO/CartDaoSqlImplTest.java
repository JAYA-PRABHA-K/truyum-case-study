package DAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import CartEmptyException.CartEmptyException;
import Model.MenuItem;

public class CartDaoSqlImplTest {
	static CartDao cartDao=new CartDaoSqlImpl();
	static public  void main(String[] args) throws ParseException, CartEmptyException, ClassNotFoundException, SQLException
	{
		System.out.println("sql Add to cart");
		System.out.println("ID\tNAME\t\tPRICE\tACTIVE\tDATE OF LAUNCH\tCATEGORY\tFREE DELIVERY");
		testAddCartItem();
		System.out.println("\nsql All Cart Items");
		System.out.println("ID\tNAME\t\tPRICE\tACTIVE\tDATE OF LAUNCH\tCATEGORY\tFREE DELIVERY");
		testGetAllCartItems();
		System.out.println("\nsql Remove from cart");
		System.out.println("ID\tNAME\t\tPRICE\tACTIVE\tDATE OF LAUNCH\tCATEGORY\tFREE DELIVERY");
		testRemoveCartItem();
	}
	static public void testAddCartItem() throws ParseException, CartEmptyException, ClassNotFoundException, SQLException
	{
		//add the menu item to the cart and prints the menuitems in the cart 
		cartDao.addCartItem(1,1);
		cartDao.addCartItem(1,2);
		List<MenuItem> list=cartDao.getAllCartItems(1);
		for(MenuItem obj:list)
		{
			System.out.println(obj.toString());
		}
	}
	static public void testGetAllCartItems() throws CartEmptyException, ClassNotFoundException, SQLException, ParseException
	{
		//prints all the menuitem in the cart of the user
		List<MenuItem> list=cartDao.getAllCartItems(1);
		for(MenuItem obj:list)
		{
			
			System.out.println(obj.toString());
		}
	}
	static public void testRemoveCartItem() throws CartEmptyException, ClassNotFoundException, SQLException, ParseException
	{
		//remove the menuitem from the cart of the user 
		cartDao.removeCartItem(1,1);
		//cartDao.removeCartItem(1,2);
		 List<MenuItem> list=cartDao.getAllCartItems(1);
		 if(list.size()==0)
		 {
			 throw new CartEmptyException("THe cart is empty");
		 }
		 else {
			 for(MenuItem obj:list)
				{
					
					System.out.println(obj.toString());
				}
		 }
	}
}
