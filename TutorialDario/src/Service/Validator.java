package Service;

import java.util.List;

import ProjectException.*;
import model.*;

public class Validator {
	
	private List<User> users;
	
	public Validator(){	}
	
	public Validator(List<User> users)
	{
		this.users = users;
	}
	
	public void ValidId(String idNumber) throws UserIDException
	{
		// check if length of id is valid
		if(idNumber.length() != 9)
			throw new UserIDException("Missing Or to many numbers in the ID number");
		
		// if not number only throw Exception
		if(!idNumber.matches("[0-9]{9,9}"))
			throw new UserIDException("Mast to be digit only");
			
			int sum = 0;		
			for(int index = 0 ; index < idNumber.length() ; index++)
			{
				if( index % 2 == 0)
					sum += idNumber.charAt(index) - '0';
				else
				{
					int temp = (idNumber.charAt(index) -'0') * 2;
					sum += temp / 10 + temp % 10; 
					
				}
			}
			
			if(sum == 0 || sum % 10 != 0 )
				throw new UserIDException("ID Number is not valid");
	}
	
	public void ValidNewUser(User user) throws UserException, EmailAddressException, TelNumberException
	{
		
		for(User checkUser : users)
		{
			if(checkUser.equals(user))
				throw new UserException("The User is exist");
			
			if(checkUser.getName().compareTo(user.getName()) == 0)
				throw new UserException("The Username is exist");
			
			if(checkUser.getEmail().compareTo(user.getEmail()) == 0)
				throw new EmailAddressException("The User Email is exist");
			
			if(checkUser.getTel().compareTo(user.getTel()) == 0)
				throw new TelNumberException("The User Phone is exist");
		}
	}
	
	public void ValidEmail(String email) throws EmailAddressException
	{
		String reg = "([a-zA-Z0-9]+([\\.+_-][a-zA-Z0-9]+)*)@(([a-zA-Z0-9]+((\\.|[-]{1,2})[a-zA-Z0-9]+)*)\\.[a-zA-Z]{2,6})";
		
		if(!email.matches(reg))
			throw new EmailAddressException("The currect Email format\n user@domain.com");
	}
	
	public void ValidPhoneNumber(String phone) throws TelNumberException
	{
		String reg = "^0(([57]\\d)|[23489])-?[2-9]\\d{6}$";
		
		if(!phone.matches(reg))
			throw new TelNumberException("The Phone number is not valid");
	}
	
	public void ValidPassword(String password) throws UserPasswordException
	{
		if(password.length() < 6 || password.length() > 20 )
			throw new UserPasswordException("Password have to be 6-20 characters");
		
		if(password.contains(" "))
			throw new UserPasswordException("Password cat not be with spaces!!");
	}
	
	public void ValidUserName(String name) throws UserNameException
	{
		String reg = "^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$";
		
		if(!name.matches(reg))
			throw new UserNameException("The user name must start with a letter\nand then you can put Numbers");
	}
}
