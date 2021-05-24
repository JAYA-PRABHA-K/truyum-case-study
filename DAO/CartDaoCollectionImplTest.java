package DAO;
import CartEmptyException.CartEmptyException;
import java.text.ParseException;
import java.util.List;

import Model.MenuItem;

public class CartDaoCollectionImplTest {
	static CartDao  cartDao=new CartDaoCollectionImpl();
	static public void main( String args[]) throws ParseException, CartEmptyException
	{
		System.out.println("Add to cart");
		System.out.println("ID\tNAME\t\t\tPRICE\tACTIVE\tDATE OF LAUNCH\tCATEGORY\tFREE DELIVERY");
		testAddCartItem();
		System.out.println("\nAll Cart Items");
		System.out.println("ID\tNAME\t\t\tPRICE\tACTIVE\tDATE OF LAUNCH\tCATEGORY\tFREE DELIVERY");
		testGetAllCartItems();
		System.out.println("\nRemove from cart");
		System.out.println("ID\tNAME\t\t\tPRICE\tACTIVE\tDATE OF LAUNCH\tCATEGORY\tFREE DELIVERY");
		testRemoveCartItem();
	}
	static public void testAddCartItem() throws ParseException, CartEmptyException
	{
		//add the menuitem to the cart and prints the items added
		cartDao.addCartItem(1,1);
		cartDao.addCartItem(1,2);
		List<MenuItem> list=cartDao.getAllCartItems(1);
		for(MenuItem obj:list)
		{
			System.out.println(obj.toString());
		}
	}
	static public void testGetAllCartItems() throws CartEmptyException
	{
		//prints all the menuitem in the cart
		List<MenuItem> list=cartDao.getAllCartItems(1);
		for(MenuItem obj:list)
		{

			System.out.println(obj.toString());
			
		}
	}
	static public void testRemoveCartItem() throws CartEmptyException
	{
		//removes a menuitem from the cart. 
		cartDao.removeCartItem(1,1);
		 List<MenuItem> list=cartDao.getAllCartItems(1);
		 if(list.size()==0)
		 {
			 //throws cart empty exception if the cart is empty
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
