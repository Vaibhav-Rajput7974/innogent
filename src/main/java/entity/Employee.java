package entity;

public class Employee {
	private boolean Admin;
	private int EmpId;
	private String FirstName;
	private String LastName;
	private String Password;
	private int Salary;
	private String Username;
	
	@Override
	public String toString() {
		return "Employee [Admin=" + Admin + ", EmpId=" + EmpId + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Password=" + Password + ", Salary=" + Salary + ", Username=" + Username + "]";
	}
	public Employee() {
		super();
	}
	public Employee(boolean admin, int empId, String firstName, String lastName, String password, int salary,
			String username) {
		super();
		Admin = admin;
		EmpId = empId;
		FirstName = firstName;
		LastName = lastName;
		Password = password;
		Salary = salary;
		Username = username;
	}
	public boolean isAdmin() {
		return Admin;
	}
	public void setAdmin(boolean admin) {
		Admin = admin;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	
}
