import java.util.*;

class Employee
{
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;
	Employee(int id,String name,int age,String gender,String department,int yearOfJoining,double salary){
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.department=department;
		this.yearOfJoining=yearOfJoining;
		this.salary=salary;
	}
}
class Assigment2{
	static void function1(ArrayList<Employee> employeeList){
		int male=0;
		int female=0;
		for(int i=0;i<employeeList.size();i++){
			if(employeeList.get(i).gender.equals("Male"))male++;
			if(employeeList.get(i).gender.equals("Female"))female++;
		}
		System.out.println("Male  -> "+male+"\n"+"Female  -> "+female);
	}
	
	static void function2(ArrayList<Employee> employeeList){
		HashSet<String> st = new HashSet<String>();
		for(int i=0;i<employeeList.size();i++){
			st.add(employeeList.get(i).department);
		}
		
		for(String s:st){
			System.out.println(s);
		}
	}
	
	static void function3(ArrayList<Employee> employeeList){
		int male_total=0;
		int female_total=0;
		int count_male=0;
		int count_female=0;
		for(int i=0;i<employeeList.size();i++){
			if(employeeList.get(i).gender.equals("Male")){
				male_total+=employeeList.get(i).age;
				count_male++;
			}
			if(employeeList.get(i).gender.equals("Female")){
				female_total+=employeeList.get(i).age;
				count_female++;
			}
		}
		System.out.println("Male Average  -> "+(male_total/count_male)+"\n"+"Female Average  -> "+(female_total/count_female));
	}
	
	static void function4(ArrayList<Employee> employeeList){
		double highest=0;
		int ans=-1;
		for(int i=0;i<employeeList.size();i++){
			if(highest<employeeList.get(i).salary){
				highest=employeeList.get(i).salary;
				ans=i;
			}
		}
		System.out.println("id = "+employeeList.get(ans).id+"  name = "+employeeList.get(ans).name+"  age = "+employeeList.get(ans).age+"  gender = "+employeeList.get(ans).gender+"  department = "+employeeList.get(ans).department+"  yearOfJoining = "+employeeList.get(ans).yearOfJoining+"  salary = "+employeeList.get(ans).salary);	
	}
	
	static void function5(ArrayList<Employee> employeeList){
		for(int i=0;i<employeeList.size();i++){
			if(employeeList.get(i).yearOfJoining > 2015){
				System.out.println(employeeList.get(i).name);
			}
		}
	}
	
	static void function6(ArrayList<Employee> employeeList){
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		for(int i=0;i<employeeList.size();i++){
			String cur=employeeList.get(i).department;
			if(map.containsKey(cur)){
				int count=map.get(cur)+1;
				map.put(cur,count);
			}
			else{
				map.put(cur,0);
			}
		}
		map.forEach((k,v) -> System.out.println(k + ", -> " + v));
	}
	
	static void function7(ArrayList<Employee> employeeList){
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		HashMap<String,Double> map1=new HashMap<String,Double>();
		for(int i=0;i<employeeList.size();i++){
			String cur=employeeList.get(i).department;
			double cur2=employeeList.get(i).salary;
			
			if(map.containsKey(cur)){
				int count=map.get(cur)+1;
				double val=map.get(cur);
				map1.put(cur,val+cur2);
				map.put(cur,count);
			}
			else{
				map.put(cur,0);
				map1.put(cur,cur2);
				
			}
		}
		for(String key:map.keySet()){
			double avg=(map1.get(key)/map.get(key));
			System.out.println(key+"  ->  "+avg);
		}
	}
	
	static void function8(ArrayList<Employee> employeeList){
		double lowest=10000000;
		int ans=0;
		for(int i=0;i<employeeList.size();i++){
			if(lowest>employeeList.get(i).salary && employeeList.get(i).department.equals("Product Development")){
				lowest=employeeList.get(i).salary;
				ans=i;
			}
		}
		System.out.println("id = "+employeeList.get(ans).id+"  name = "+employeeList.get(ans).name+"  age = "+employeeList.get(ans).age+"  gender = "+employeeList.get(ans).gender+"  department = "+employeeList.get(ans).department+"  yearOfJoining = "+employeeList.get(ans).yearOfJoining+"  salary = "+employeeList.get(ans).salary);
		
	}
	
	static void function9(ArrayList<Employee> employeeList){
		int male=0;
		int female=0;
		for(int i=0;i<employeeList.size();i++){
			if(employeeList.get(i).department.equals("Sales And Marketing"))male++;
			if(employeeList.get(i).department.equals("Sales And Marketing"))female++;
		}
		System.out.println("Male  -> "+male+"\n"+"Female  -> "+female);
	}
	
	static void function11(ArrayList<Employee> employeeList){
		HashMap<String,ArrayList<String> > res=new HashMap<String,ArrayList<String> >(); 
		for(int i=0;i<employeeList.size();i++){
			String cur=employeeList.get(i).department;
			String nam=employeeList.get(i).name;
			//res.put(cur,add(nam));
		}
		
	}
	
	static void function12(ArrayList<Employee> employeeList){
		double total=0;
		int count=0;
		for(int i=0;i<employeeList.size();i++){
			total+=employeeList.get(i).salary;
			count++;
		}
		System.out.println("Total = "+total+"Average = "+(total/count));
	}	
	
	static void function13(ArrayList<Employee> employeeList){
		ArrayList<Employee> younger=new ArrayList<Employee>();
		ArrayList<Employee> older=new ArrayList<Employee>();
		for(int i=0;i<employeeList.size();i++){
			if(employeeList.get(i).age <=25){
				younger.add(employeeList.get(i));
			}
			else{
				older.add(employeeList.get(i));
			}
		}
		System.out.println("Younger");
		for(Employee s:younger){
			System.out.print(s.name+"  ");
		}
		System.out.println();
		System.out.println("Older");
		for(Employee s:older){
			System.out.print(s.name+"  ");
		}
		System.out.println();
	}
	static void function14(ArrayList<Employee> employeeList){
		int highest=0;
		int ans=-1;
		for(int i=0;i<employeeList.size();i++){
			if(highest<employeeList.get(i).age){
				highest=employeeList.get(i).age;
				ans=i;
			}
		}
		System.out.println("age = "+employeeList.get(ans).age+"  department = "+employeeList.get(ans).department);	
	}
	
	public static void main(String arr[]){
		ArrayList<Employee> employeeList = new ArrayList<Employee>();        
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		function1(employeeList);
		function2(employeeList);
		function3(employeeList);
		function4(employeeList);
		function5(employeeList);
		function6(employeeList);
		function7(employeeList);
		function8(employeeList);
		function9(employeeList);
		function11(employeeList);
		function12(employeeList);
		function13(employeeList);
		function14(employeeList);
	}
}
















