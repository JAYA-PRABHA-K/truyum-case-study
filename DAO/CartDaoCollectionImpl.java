package DAO;
import java.util.*;

import CartEmptyException.CartEmptyException;
import Model.Cart;
import Model.MenuItem;
public class CartDaoCollectionImpl implements CartDao {
	private  HashMap<Long, Cart> userCarts =new HashMap<>();
	public CartDaoCollectionImpl()
	{
		if(userCarts.isEmpty())
		{
			HashMap<Long, Cart> carts =new HashMap<>();
			userCarts=carts;
			
		}
	}
	public void addCartItem( long userId, long menuItemId)
	{
		//adds the menuitem to the cart of the user
			MenuItemDao  menuItemDao=new MenuItemDaoCollectionImpl();
			MenuItem obj=menuItemDao.getMenuItem(menuItemId);
			Set<Long> key=userCarts.keySet();
			int flag=0;
			for(Long k:key)
			{
				if(k==userId)
				{
					Cart cartobj=userCarts.get(k);
					List<MenuItem> list=cartobj.getMenuitemlist();
					list.add(obj);
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				Cart newcartobj=new Cart();
				List<MenuItem> nlist=newcartobj.getMenuitemlist();
				 
				nlist.add(obj);
				userCarts.put(userId, newcartobj);
			}
		
		
	}
	public List<MenuItem> getAllCartItems( long userId) throws CartEmptyException
	{
		// return all the menu items in the cart of the user
		Set<Long> key=userCarts.keySet();
		List<MenuItem> list=new ArrayList<>();
		Cart cartobj = null;
		for(Long k:key)
		{
			if(k==userId)
			{
				cartobj=userCarts.get(k);
				list=cartobj.getMenuitemlist();
				
			}
		}
		if(list.size()==0)
		{
			// if the cart is empty it throws cartemptyexception
			throw new CartEmptyException("The list is empty");
		}
		else
		{
			double amount=0.0;
			for(MenuItem obj:list)
			{
				amount+=obj.getPrice();
			}
			cartobj.setTotal(amount);
		}
		return list;
	}
	public void removeCartItem(long userId , long menuItemId)
	{
		//remove the menuitem from the cart of the user 
		Set<Long> key=userCarts.keySet();
		for(Long k:key)
		{
			if(k==userId)
			{
				Cart cartobj=userCarts.get(k);
				List<MenuItem> list=cartobj.getMenuitemlist();
				for(MenuItem obj:list)
				{
					if(obj.getId()==menuItemId)
					{
						(cartobj.getMenuitemlist()).remove(obj);
						break;
					}
				}
			}
		}
		
	}
}
