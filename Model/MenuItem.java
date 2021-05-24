package Model;
import java.time.*;
public class MenuItem {
	private long id;
	private String name;
	private float price;
	private boolean active;
	private LocalDate dateoflaunch;
	private String category;
	private boolean freedelivery;
	
	//getter and setter methods for the private attribute
	public long getId() {						
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public LocalDate getDateoflaunch() {
		return dateoflaunch;
	}
	public void setDateoflaunch(LocalDate dateoflaunch) {
		this.dateoflaunch = dateoflaunch;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isFreedelivery() {
		return freedelivery;
	}
	public void setFreedelivery(boolean freedelivery) {
		this.freedelivery = freedelivery;
	}
	
	//five argument constructor to set the variables
	public MenuItem(long id, String name, float price, boolean active, LocalDate dateoflaunch, String category, boolean freedelivery)
	{
		
		this.id=id;
		this.name=name;
		this.price=price;
		this.active=active;
		this.dateoflaunch=dateoflaunch;
		this.category=category;
		this.freedelivery=freedelivery;
	}
	
	//toSrting method is to return the entire values in string
	public String toString()
	{
		String ac;
		String fe;
		if(active)
		{
			ac="yes";
		}
		else
		{
			ac="no";
		}
		if(freedelivery)
		{
			fe="yes";
		}
		else
		{
			fe="no";
		}
		return id+"\t"+name+""+price+"\t"+ac+"\t"+dateoflaunch+"\t"+category+"\t"+fe; 
	}
}
