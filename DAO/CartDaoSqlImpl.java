package DAO;
import Model.MenuItem;
import Model.Cart;
import Util.DateUtil;
import java.util.*;

import CartEmptyException.CartEmptyException;

import java.sql.*;


public class CartDaoSqlImpl implements CartDao{
	public  List<MenuItem> getAllCartItems( long userId) throws CartEmptyException
	{
		// return the menuitem in the cart of the user
		try {
		Connection con=ConnectionHandeler.getConnection();
		double amount=0.00;
		ArrayList<MenuItem> arr=new ArrayList<>();
		Cart obj=new Cart();
		PreparedStatement stmt=con.prepareStatement("select c.userId, c.menuItemId, t.Name, t.Price, t.Active, t.Date_of_launch,t.Category,t.Free_delivery from cart c join truyum t  on t.Id=c.menuItemId where c.userId="+userId );
		ResultSet rs=stmt.executeQuery();
		if(rs.next())		//checks whether the first row is empty 
		{
			do
			{
				
				//long uid=rs.getLong(1); 
				long mid=rs.getLong(2);
				String name=rs.getString(3);
				float price=rs.getFloat(4);
				boolean active=rs.getString(5).equals("yes")?true:false;
				String date=rs.getString("Date_of_launch");
				String category=rs.getString("Category");
				boolean free=((rs.getString("Free_delivery")).equals("yes"));
				
				MenuItem mobj=new MenuItem(mid,name,price,active,DateUtil.convertToDate(date),category,free);
				arr.add(mobj);
			}while(rs.next());
		}
		else			//if the cart is empty it throws cartemptyexception
		{
			throw new CartEmptyException("The list is empty");
		}
		//calculating the total cost of the cart
		PreparedStatement st=con.prepareStatement("select sum(Price) from cart c join truyum t  on t.Id=c.menuItemId where c.userId="+userId );
		ResultSet re=st.executeQuery();
		re.next();
		amount=re.getDouble(1);
		obj.setTotal(amount);
		obj.setMenuitemlist(arr);
		
		return arr;
		}catch(ClassNotFoundException e) 
		{
			e.getMessage();
			return null;
		}catch(SQLException ex) {
			ex.getMessage();
			return null;
		}
		
	}
	public void addCartItem( long userId, long menuItemId)
	{
		//add the items to the cart of the user
		try {
		Connection con=ConnectionHandeler.getConnection();
		PreparedStatement stmt=con.prepareStatement("insert into cart (userId , menuItemId) values ("+userId+","+menuItemId+")" );
		stmt.executeUpdate();
		}catch(ClassNotFoundException e) 
		{
			e.getMessage();
		}catch(SQLException ex) {
			ex.getMessage();
		}
	}
	public void removeCartItem( long userId, long menuItemId) 
	{
		//remove the menuitem from the cart of the user
		try {
		Connection con=ConnectionHandeler.getConnection();
		PreparedStatement stmt=con.prepareStatement(" delete from cart where userId= "+userId+" and menuItemId="+menuItemId);
		stmt.executeUpdate();
		}
		catch(ClassNotFoundException e) 
		{
			e.getMessage();
		}catch(SQLException ex) {
			ex.getMessage();
		}
	}

}
