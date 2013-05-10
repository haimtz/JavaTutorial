package model;

public class User {
	
	// Members
	private String Name;
	private String IdNumber;
	private String Email;
	private String Tel;
	private String Password;
	
	
	
	// Getters and Setters
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getIdNumber() {
		return IdNumber;
	}
	public void setIdNumber(String idNumber) {
		IdNumber = idNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	// Equal override
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		User other = (User) obj;
		
		if (IdNumber == null && other.IdNumber != null ) 
			return false;
		
		else if (!IdNumber.equals(other.IdNumber))
			return false;
		
		if (Name == null && other.Name != null )
			return false;
	
		else if (!Name.equals(other.Name))
			return false;
		
		return true;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdNumber == null) ? 0 : IdNumber.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		return result;
	}

}
