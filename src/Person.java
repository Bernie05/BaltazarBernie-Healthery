public class Person
{
	private String fullName;
	private String address;
	private String birthday;
	private String gender;
	private String contactNo;

	public void setFullName(String fn) {
		fullName = fn;
	}

	public String getFullName() {
		return(fullName);
	}

	public void setAddress(String a) {
		address = a;
	}

	public String getAddress() {
		return(address);
	}

	public void setBirthday(String bd) {
		birthday = bd;
	}

	public String getBirthday() {
		return(birthday);
	}

	public void setGender(String g) {
		gender = g;
	}

	public String getGender() {
		return(gender);
	}

	public void setContactNo(String cn) {
		contactNo = cn;
	}

	public String getContactNo() {
		return(contactNo);
	}

	public String toString() {
		String str = "\nFull Name: " + fullName +  "\nAddress: " + address + "\nBirthday: " + birthday + "\nGender: " + gender + "\nPhone Number: " + contactNo + "\n";
		return(str);
	}
}
