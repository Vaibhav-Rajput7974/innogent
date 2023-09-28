
import java.io.*;
import java.util.*;
class Student{
	int id;
	String name;
	int class__id;
	int marks;
	String gender;
	int age;
	Student(int id,String name,int class__id,int marks,String gender,int age){
		this.id=id;
		this.name=name;
		this.class__id=class__id;
		this.marks=marks;
		this.gender=gender;
		this.age=age;
	}
}
class Studentclass{
	int id;
	String classname;
	Studentclass(int id,String classname){
		this.id=id;
		this.classname=classname;
	}
}
class Address{
	int id;
	int pin_code;
	String city;
	int student_id;
	Address(int id,int pin_code,String city,int student_id){
		this.id=id;
		this.pin_code=pin_code;
		this.city=city;
		this.student_id=student_id;
	}
}

//Sorting Class 

class Sortbyname implements Comparator<Student> {
	public int compare(Student a,Student b){
		return a.name.compareTo(b.name);
	}
}

class Sortbymarks implements Comparator<Student> {
	public int compare(Student a,Student b){
		return a.marks-b.marks;
	}
}


public class csv {

	public static ArrayList<Student> uploadStudent(String filePath) {
        ArrayList<Student> data = new ArrayList<>();
		
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line=br.readLine();
            while ((line = br.readLine()) != null) {
                // Split the line by a comma (assuming it's a CSV file)
				line=line.replaceAll("\\s", "");
                String[] row = line.split(",");
				Student st=new Student(Integer.parseInt(row[0]),row[1],Integer.parseInt(row[2]),Integer.parseInt(row[3]),row[4],Integer.parseInt(row[5]));
                data.add(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
        return data;
    }
	public static ArrayList<Studentclass> uploadClass(String filePath) {
        ArrayList<Studentclass> data = new ArrayList<>();
		
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line=br.readLine();
            while ((line = br.readLine()) != null) {
				line=line.replaceAll("\\s", "");
                String[] row = line.split(",");
				Studentclass st=new Studentclass(Integer.parseInt(row[0]),row[1]);
                data.add(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
	public static ArrayList<Address> uploadAddress(String filePath) {
        ArrayList<Address> data = new ArrayList<>();
		
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line=br.readLine();
            while ((line = br.readLine()) != null) {
				line=line.replaceAll("\\s", "");
                String[] row = line.split(",");
				Address st=new Address(Integer.parseInt(row[0]),Integer.parseInt(row[1]),row[2],Integer.parseInt(row[3]));
                data.add(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
	
	//1 Find all students of pincode X(ex X = 482002). I can pass different filters like gender, age, class

	static ArrayList<Student> function1(List<Student> data1,List<Studentclass> data2,List<Address> data3,int pin){
		
		ArrayList<Student> out=new ArrayList<Student>();
		for(int i=0;i<data3.size();i++){
			if(data3.get(i).pin_code == pin){
				int idx=data3.get(i).student_id-1;
				out.add(data1.get(idx));
				System.out.println(data1.get(idx).name);
			}
		}
		return out;
	}
	
	// 2 Find all students of city ex X = Indore. I can pass different filters like gender, age, clas
	static ArrayList<Student> function2(List<Student> data1,List<Studentclass> data2,List<Address> data3,String ct){
		
		ArrayList<Student> out=new ArrayList<Student>();
		for(int i=0;i<data3.size();i++){
			if(data3.get(i).city.equals(ct)){
				int idx=data3.get(i).student_id-1;
				out.add(data1.get(idx));
				System.out.println(data1.get(idx).name);
			}
		}
		return out;
	}
	
	//4 Get the passed students. I can pass different filters like gender, age, class, city, pincode
	static ArrayList<Student> function4(List<Student> data1,List<Studentclass> data2,List<Address> data3){
		
		ArrayList<Student> out=new ArrayList<Student>();
		for(int i=0;i<data1.size();i++){
			if(data1.get(i).marks>50){
				out.add(data1.get(i));
				System.out.println(data1.get(i).name);
			}
		}
		return out;
	}
	
	//5 Get the failed students. I can pass different filters like gender, age, class, city, pincode
	static ArrayList<Student> function5(List<Student> data1,List<Studentclass> data2,List<Address> data3){
		
		ArrayList<Student> out=new ArrayList<Student>();
		for(int i=0;i<data1.size();i++){
			if(data1.get(i).marks<50){
				out.add(data1.get(i));
				System.out.println(data1.get(i).name);
			}
		}
		return out;
	}
	
	//6 Find all student of class X (ex X = A). I can pass different filters like gender, age, class, city, pincode
	static ArrayList<Student> function6(List<Student> data1,List<Studentclass> data2,List<Address> data3,String x){
		
		ArrayList<Student> out=new ArrayList<Student>();
		int cl_idx=-1;
		for(int i=0;i<data2.size();i++){
			if(data2.get(i).classname.equals(x)){
				cl_idx=data2.get(i).id;
			}
		}
		for(int i=0;i<data1.size();i++){
			if(data1.get(i).class__id == cl_idx){
				System.out.println(data1.get(i).name);
				out.add(data1.get(i));
			}
		}
		
		return out;
	}
	
	//8 It should fail if student record is having age > 20.
	static ArrayList<Student> function8(List<Student> data1,List<Studentclass> data2,List<Address> data3){
		
		ArrayList<Student> out=new ArrayList<Student>();
		for(int i=0;i<data1.size();i++){
			if(data1.get(i).age > 20){
				System.out.println("failed Student ="+data1.get(i).name);
				out.add(data1.get(i));
			}
		}
		
		return out;
	}
	
	//9 I should be able to delete student. After that it should delete the respective obj from Address & Student.
	
	static void function9(List<Student> data1,List<Studentclass> data2,List<Address> data3,int to_delete){
		
		for(int i=0;i<data1.size();i++){
			if(data1.get(i).id == to_delete){
				System.out.println(data1.get(i).id);
				data1.remove(i);
			}
		}
		for(int i=0;i<data3.size();i++){
			if(data3.get(i).student_id == to_delete){
				System.out.println(data3.get(i).id);
				data3.remove(i);
			}
		}
		
	}
	
	/*
	11 I should be able to read paginated students.
	like : read female students first 1-9
	like : read female students first 7-8 order by name
	like : read female students first 1-5 order by marks
	like : read female students first 9-50 order by mark
	*/
	
	static ArrayList<Student> function11(List<Student> data1,List<Studentclass> data2,List<Address> data3,int start,int end,String gen){
		ArrayList<Student> out=new ArrayList<Student>();
		for(int i=start;i<data1.size() && i<=end;i++){
			if(data1.get(i).gender.equals(gen)){
				//System.out.println(data1.get(i).name);
				out.add(data1.get(i));
			}
		}
		
		return out;
	}
	
	
	//			Filter Function 
	
	
	//			Gender Filter
	
	static ArrayList<Student> genderFilter(List<Student> data,String gen){
		ArrayList<Student> out=new ArrayList<Student>();
		for(int i=0;i<data.size();i++){
			if(data.get(i).gender.equals(gen)){
				//System.out.println(data.get(i).name);
				out.add(data.get(i));
			}
		}
		
		return out;
	}
	
	// 			Age Filter
	
	static ArrayList<Student> ageFilter(List<Student> data,int find_age){
		ArrayList<Student> out=new ArrayList<Student>();
		for(int i=0;i<data.size();i++){
			if(data.get(i).age == find_age){
				//System.out.println(data.get(i).name);
				out.add(data.get(i));
			}
		}
		
		return out;
	}
	
	//   		Class Filter
	
	
	static ArrayList<Student> classFilter(List<Studentclass> data2,List<Student> data,String find_class){
		int find_class_id=-1;
		for(int i=0;i<data2.size();i++){
			if(data2.get(i).classname.equals(find_class)){
				find_class_id=data2.get(i).id;
				break;
			}
		}
		ArrayList<Student> out=new ArrayList<Student>();
		for(int i=0;i<data.size();i++){
			if(data.get(i).class__id == find_class_id){
				System.out.println(data.get(i).name);
				out.add(data.get(i));
			}
		}
		return out;
	}
	
	// 			City Filter 
	
	
	static ArrayList<Student> cityFilter(List<Address> data3,List<Student> data,String find_city){
		ArrayList<Address> find_data=new ArrayList<Address>();
		
		for(int i=0;i<data3.size();i++){
			if(data3.get(i).city.equals(find_city)){
				find_data.add(data3.get(i));
			}
		}
		ArrayList<Student> out=new ArrayList<Student>();
		for(int i=0;i<data.size();i++){
			for(int j=0;j<find_data.size();j++){
				if(data.get(i).id == find_data.get(j).student_id){
					out.add(data.get(i));
					System.out.println(data.get(i).name);
				}
			}
		}
		return out;
	}
	
	// 			Pin_code Filter 
	
	
	static ArrayList<Student> pin_codeFilter(List<Address> data3,List<Student> data,int find_pin){
		ArrayList<Address> find_data=new ArrayList<Address>();
		
		for(int i=0;i<data3.size();i++){
			if(data3.get(i).pin_code == find_pin){
				find_data.add(data3.get(i));
			}
		}
		ArrayList<Student> out=new ArrayList<Student>();
		for(int i=0;i<data.size();i++){
			for(int j=0;j<find_data.size();j++){
				if(data.get(i).id == find_data.get(j).student_id){
					out.add(data.get(i));
					System.out.println(data.get(i).name);
				}
			}
		}
		return out;
	}
	
	
	//  		Order 
	
	//  		Order by name
	
	static ArrayList<Student> ordername(ArrayList<Student> data){
		
		Collections.sort(data,new Sortbyname());
		return data;
	}
	
	// Order by marks
	
	static ArrayList<Student> ordermarks(ArrayList<Student> data){
		
		Collections.sort(data,new Sortbymarks());
		return data;
	}
	
	
	static void printfun(ArrayList<Student> data){
		
		for(int i=0;i<data.size();i++){
			System.out.println("   Student id = "+data.get(i).id+"   Student name = "+data.get(i).name+"   class id = "+data.get(i).class__id+" Marks =  "+data.get(i).marks+" Gender =  "+data.get(i).gender+" Age =  "+data.get(i).age);
		}
	}
	
	public static void main(String arr[])throws Exception{
		
		
		ArrayList<Student> data1=uploadStudent("E:/innogent/student.csv");
		ArrayList<Studentclass> data2=uploadClass("E:/innogent/studentclass.csv");
		ArrayList<Address> data3=uploadAddress("E:/innogent/address.csv");
		
		ArrayList<Student> res=function1(data1,data2,data3,482002);
		
		res=classFilter(data2,res,"C");
		printfun(res);
		ArrayList<Student> res2=function2(data1,data2,data3,"indore");
	

		ArrayList<Student> res3=ordermarks(data1);
		res3=genderFilter(res3,"F");
		res3=cityFilter(data3,res3,"indore");
	
		ArrayList<Student> res4=function4(
data1,data2,data3);
		ArrayList<Student> res5=function5(data1,data2,data3);
		
		ArrayList<Student> res6=function6(data1,data2,data3,"A");
		ArrayList<Student> res8=function8(data1,data2,data3);
		//delete function;
		//function9(data1,data2,data3,1);
		ArrayList<Student> res11=function11(data1,data2,data3,1,9,"F");
		res11=ordermarks(res11);
		
		//printfun(res3);
	}	
}