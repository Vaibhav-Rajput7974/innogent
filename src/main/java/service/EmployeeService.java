package service;

import java.util.ArrayList;
import java.util.List;

import entity.Employee;

public class  EmployeeService {
	static public List<Employee> employeelist=new ArrayList<Employee>();
	public void setEmployeelist() {
		System.out.println("Employee");
		Employee c1=new Employee();
		c1.setAdmin(true);
		c1.setEmpId(1);
		c1.setFirstName("vaibhav");
		c1.setLastName("Rajput");
		c1.setSalary(100);
		c1.setPassword("123");
		c1.setUsername("vaibhav");
		employeelist.add(c1);
		
		Employee c2=new Employee();
		c2.setAdmin(false);
		c2.setEmpId(EmployeeService.genrateId());
		c2.setFirstName("vai");
		c2.setLastName("Raj");
		c2.setSalary(1000);
		c2.setPassword("111");
		c2.setUsername("vai");
		
		employeelist.add(c2);
		
		Employee c3=new Employee();
		c3.setAdmin(false);
		c3.setEmpId(EmployeeService.genrateId());
		c3.setFirstName("ram");
		c3.setLastName("Yadav");
		c3.setSalary(10320);
		c3.setPassword("321");
		c3.setUsername("rams");
		
		employeelist.add(c3);
		
		Employee c4=new Employee();
		c4.setAdmin(true);
		c4.setEmpId(EmployeeService.genrateId());
		c4.setFirstName("raju");
		c4.setLastName("rathore");
		c4.setSalary(10320);
		c4.setPassword("111");
		c4.setUsername("raju");
		
		employeelist.add(c4);
	}
	public static void addData(boolean admin,String fName,String sName,int salary,String uname,String pass) {
		Employee cur=new Employee();
		
		//cur=new Employee();
		cur.setAdmin(admin);
		cur.setEmpId(EmployeeService.genrateId());
		cur.setEmpId(genrateId());
		cur.setFirstName(fName);
		cur.setLastName(sName);
		cur.setSalary(salary);
		cur.setUsername(uname);
		cur.setPassword(pass);
		employeelist.add(cur);
	}
	public static int  genrateId() {
		int id=employeelist.get(employeelist.size()-1).getEmpId();
		return id+1;
	}
	
	public static boolean deleteData(int id) {
		Employee userEmployee=employeelist.stream().filter(e->e.getEmpId() == id).findFirst().orElse(null);
		boolean cheak=userEmployee.isAdmin();
		if(cheak)return true;
		employeelist.remove(userEmployee);	
		return false;
	}
	
	public  Employee update(int id) {
		//System.out.println(employeelist);
		Employee userEmployee=employeelist.stream().filter(e->e.getEmpId()== id).findFirst().orElse(null);
		if(userEmployee!=null){
			return userEmployee;
			
		}
		return null;
	}
	
	
	public Employee login(String name,String pass) {
		System.out.println(employeelist);
		Employee userEmployee=employeelist.stream().filter(e->e.getUsername().equals(name)&&e.getPassword().equals(pass)).findFirst().orElse(null);
		if(userEmployee!=null)
			return userEmployee;
		
		return null;
	}
	
	public List<Employee> getEmployeelist() {
		return employeelist;
	}
}
