package DAO;
import java.time.*;
import java.util.*;
import Util.DateUtil;

import Model.MenuItem;
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private List<MenuItem> menuItemList=new ArrayList<>();
	public MenuItemDaoCollectionImpl() 
	{
		//add the menu item to the menu list.
		if(menuItemList.size()==0)
		{
			MenuItem obj1=new MenuItem((long)1,"Sandwich		",99.00f,true,DateUtil.convertToDate("15/03/2017"),"Main Course",true);
			MenuItem obj2=new MenuItem((long)2,"Burger			",129.00f,true,DateUtil.convertToDate("23/12/2017"),"Main Course",false);
			MenuItem obj3=new MenuItem((long)3,"Pizza			",149.00f,true,DateUtil.convertToDate("21/08/2018"),"Main Course",false);
			MenuItem obj4=new MenuItem((long)4,"French Fries		",57.00f,false,DateUtil.convertToDate("02/07/2017"),"Starters",true);
			MenuItem obj5=new MenuItem((long)5,"Chocolate Brownie	",32.00f,true,DateUtil.convertToDate("02/11/2022"),"Dessert	",true);
			 menuItemList.add(obj1);
			 menuItemList.add(obj2);
			 menuItemList.add(obj3);
			 menuItemList.add(obj4);
			 menuItemList.add(obj5);
		}
	}
	public List<MenuItem> getMenuItemListAdmin()
	{
		//returns the entire row of menu item in menu list to the admin
		return menuItemList;
	}
	
	public List<MenuItem> getMenuItemListCustomer() 
	{
		//returns the active menu item in menu list to the customer
		List<MenuItem> list=new ArrayList<>();
		for(MenuItem obj:menuItemList)
		{
			
			if(obj.isActive() && (obj.getDateoflaunch()==LocalDate.now() || obj.getDateoflaunch().isBefore(LocalDate.now())))
			{
				list.add(obj);
			}
		}
		return list;
	}
		public void modifyMenuItem(MenuItem menuItem) 
	{
			//a specific menu item in the list is updated
			for(MenuItem obj:menuItemList)
			{
				
				if(obj.getId()==menuItem.getId())
				{
					
					menuItemList.remove(obj);
					menuItemList.add(menuItem);
				}
			}
		
	}
		public  MenuItem getMenuItem(long menuItemId)
	{
			//returns a specific menu item in menu list which is asked for.
		for(MenuItem obj:menuItemList)
		{
			if(obj.getId()==menuItemId)
			{
				return obj;
			}
		}
		return null;
	}
}
