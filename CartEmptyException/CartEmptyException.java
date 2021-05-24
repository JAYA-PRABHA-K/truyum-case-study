package CartEmptyException;

@SuppressWarnings("serial")
//this class throws the cartemptyException when the cart is empty
public class CartEmptyException extends Exception{
	public CartEmptyException(String message)
	{
		super(message);
	}
}
