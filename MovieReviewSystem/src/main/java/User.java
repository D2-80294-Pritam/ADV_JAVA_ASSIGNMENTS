import java.util.Date;
import java.util.Scanner;

public class User {
	private Integer id;
	private String firstName; 
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private Date birthdate;
	
	
	public User () {
		
	}
	
	public void editUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the new name of the user");
		String f1 = sc.next();
		System.out.println("Enter the new Last name of the user");
		String l1 = sc.next();
		System.out.println("Enter the new email of the user");
		String e1 = sc.next();
		System.out.println("Enter the new Mobile number of the user");
		String m1 = sc.next();
		System.out.print("New Birth Date (dd-MM-yyyy): ");
		String dateStr = sc.next();
		this.setFirstName(f1);
		this.setLastName(l1);
		this.setEmail(e1);
		this.setBirthdate(DateUtil.parse(dateStr));
		this.setMobile(m1);
	}
	
	public User(Integer id, String firstName, String lastName, String email, String password, String moibile,
			Date birthdate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobile = moibile;
		this.birthdate = birthdate;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", mobile=" + mobile + ", birthdate=" + birthdate + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String moibile) {
		this.mobile = moibile;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
	
}
