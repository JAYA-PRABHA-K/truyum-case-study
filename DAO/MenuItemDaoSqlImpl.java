package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Model.MenuItem;
import Util.DateUtil;


public class MenuItemDaoSqlImpl implements MenuItemDao{
	public List<MenuItem> getMenuItemListAdmin() 
	{
		List<MenuItem> list=new ArrayList<>();
		
		try {
			//connection to the mysql
			Connection con=ConnectionHandeler.getConnection();
			//prepare statement to select all items from menu list
		PreparedStatement stmt=con.prepareStatement("select * from truyum");
		ResultSet rs=stmt.executeQuery();
		//returns the entire row of menu item in menu list to the admin
		while(rs.next())
		{
			
			long id=rs.getInt("Id");
			String name=rs.getString("Name");
			float price=rs.getFloat("Price");
			boolean active=(rs.getString("active")).equals("yes");
			String date=rs.getString("Date_of_launch");
			String category=rs.getString("Category");
			boolean free=(rs.getString("Free_delivery")).equals("yes");
			
			MenuItem obj=new MenuItem(id,name,price,active,DateUtil.convertToDate(date),category,free);
			list.add(obj);
		}
		
		
		}catch(ClassNotFoundException e) {
			e.getMessage();
			return null;
		}catch(SQLException e) {
			e.getMessage();
			return null;
			
		}
		return list;
	}
	public List<MenuItem> getMenuItemListCustomer()
	{
		//returns the active menu item in menu list to the customer
		try {
		Connection con=ConnectionHandeler.getConnection();
		List<MenuItem> list=new ArrayList<>();
		PreparedStatement stmt=con.prepareStatement("Select * from truyum where active='yes' ");
		
		ResultSet rs=stmt.executeQuery();
	
		while(rs.next())
		{
			long id=rs.getInt("Id");
			String name=rs.getString("Name");
			float price=rs.getFloat("Price");
			boolean active=(rs.getString("active")).equals("yes");
			String date=rs.getString("Date_of_launch");
			String category=rs.getString("Category");
			boolean free=((rs.getString("Free_delivery")).equals("yes"));
			MenuItem obj=new MenuItem(id,name,price,active,DateUtil.convertToDate(date),category,free);
			if  (obj.getDateoflaunch()==LocalDate.now() || obj.getDateoflaunch().isBefore(LocalDate.now()))
			list.add(obj);
		}
		return list;
		}catch(ClassNotFoundException e) {
			return null;
		}catch(SQLException e) {
			return null;
		}
	}
	public  MenuItem getMenuItem(long menuItemId)
	{
		//returns a specific menu item in menu list which is asked for.
		try {
		Connection con=ConnectionHandeler.getConnection();
		
		PreparedStatement stmt=con.prepareStatement("Select * from truyum where Id="+menuItemId);
		
		ResultSet rs=stmt.executeQuery();
		rs.next();
		long id=rs.getInt("Id");
		String name=rs.getString("Name");
		float price=rs.getFloat("Price");
		boolean active=(rs.getString("active")).equals("yes");
		String date=rs.getString("Date_of_launch");
		String category=rs.getString("Category");
		boolean free=((rs.getString("Free_delivery")).equals("yes"));
		MenuItem obj=new MenuItem(id,name,price,active,DateUtil.convertToDate(date),category,free);
		return obj;
		}
		catch(ClassNotFoundException e) {
			return null;
		}catch(SQLException e) {
			return null;
		}
	}

	public void modifyMenuItem(MenuItem menuItem) 
	{
		//a specific menu item in the list is updated
		try {
			Connection con=ConnectionHandeler.getConnection();
			long id=menuItem.getId();
			String name=menuItem.getName();
			float price=menuItem.getPrice();
			String active=(menuItem.isActive())?"yes":"no";
			int month=menuItem.getDateoflaunch().getMonthValue();
			int day=menuItem.getDateoflaunch().getDayOfMonth();
			int year=menuItem.getDateoflaunch().getYear();
			String date=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
			String category=menuItem.getCategory();
			String free=(menuItem.isFreedelivery())?"yes":"no";
			PreparedStatement stmt=con.prepareStatement("update truyum set Price="+price+", Name='"+name+"', Active='"+active+"', Category=' "+category+"', Free_delivery='"+free+"', Date_of_launch='"+date+"' where id="+id);
			stmt.executeUpdate();
		}catch(ClassNotFoundException e) {
			
		}catch(SQLException e) {
			
		}
	}
}
