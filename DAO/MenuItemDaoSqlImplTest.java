package DAO;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import Model.MenuItem;
import Util.DateUtil;

public class MenuItemDaoSqlImplTest {
	static MenuItemDao menuItemDao= new MenuItemDaoSqlImpl();
	static public  void main(String args[]) throws ParseException
	{

		System.out.println("sql Menu List Admin view");
		System.out.println("ID\tNAME\t\tPRICE\tACTIVE\tDATE OF LAUNCH\tCATEGORY\tFREE DELIVERY");
		testGetMenuItemListAdmin();
		System.out.println("\nsql Menu List Customer view");
		System.out.println("ID\tNAME\t\tPRICE\tACTIVE\tDATE OF LAUNCH\tCATEGORY\tFREE DELIVERY");
		testGetMenuItemListCustomer();
		System.out.println("\nsql Updated menu Item");
		System.out.println("ID\tNAME\t\tPRICE\tACTIVE\tDATE OF LAUNCH\tCATEGORY\tFREE DELIVERY");
		testModifyMenuItem();
		System.out.println("\nsql Get a menu based on ID");
		testGetMenuItem();
	}
	static public void testGetMenuItemListAdmin() throws ParseException
	{
		//List all the menu items
		List<MenuItem> list=menuItemDao.getMenuItemListAdmin();
		for(MenuItem obj:list)
		{
			
			System.out.println(obj.toString());
		}
	}
	static public void testGetMenuItemListCustomer() throws ParseException
	{
		//List the menu items that are	active and to date.
		List<MenuItem> list=menuItemDao.getMenuItemListCustomer();
		for(MenuItem obj:list)
		{
			
			System.out.println(obj.toString());
		}
	}
	static public void testModifyMenuItem() throws ParseException
	{
		//modify a menu item that already exist
		MenuItem menuItem=new MenuItem((long)5,"Chocolate Brownie ",35.00f,true,DateUtil.convertToDate("02/11/2022"),"Dessert",false);
		menuItemDao.modifyMenuItem(menuItem);
		MenuItem obj=menuItemDao.getMenuItem((long)5);
		
		System.out.println(obj.toString());
	}
	@SuppressWarnings("resource")
	static public void testGetMenuItem() throws ParseException
	{
		//list the menu item's details of the given id
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the ID to be searched");
		long n=sc.nextLong();
		System.out.println("ID\tNAME\t\tPRICE\tACTIVE\tDATE OF LAUNCH\tCATEGORY\tFREE DELIVERY");
		MenuItemDaoSqlImpl menuDao= new MenuItemDaoSqlImpl();
		MenuItem obj=menuDao.getMenuItem(n);
		System.out.println(obj.toString());
	}
}

