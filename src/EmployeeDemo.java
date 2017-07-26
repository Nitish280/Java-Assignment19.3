import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
//here we are creating the class EmployeeDemo
public class EmployeeDemo {
	//here we are creating the main method
	public static void main(String[] args) {
		//here we are creating the object the Employee class
        Employee employee1 = new Employee("Kailash Thakur", "Master Mentor", 5000);
        Employee employee2 = new Employee("Kumar Santosh", "Master Mentor", 20000);
        Employee employee3 = new Employee("Akhilesh Kumar", "Trainer", 5000);
        Employee employee4 = new Employee("Akhilesh Kumar", "Uanager", 8000);
        
        //here we are creating the object of treeset 
        TreeSet<Employee> treeSet = new TreeSet<Employee>(new EmployeeChainedComparator(
                new NameComparator(), new DesignationComparator()
                ));
        //here we are adding the elements in the treeSet
        treeSet.add(employee1);
        treeSet.add(employee2);
        treeSet.add(employee3);
        treeSet.add(employee4);
        //here we are initializing the treeSet
        for(Employee el : treeSet){
            System.out.println(el.toString());
        }
    }

}
//here we are creating the class SalaryComparator which implements Comparator
class SalaryComparator implements Comparator<Employee>{

    @Override
    //here we are creating the compare method which is of return type
    public int compare(Employee o1, Employee o2) {
    	//here we are applying condition for compare on the basis of salary
        if(o1.getSalary() > o2.getSalary()){
            return 1;
        }else{
            return -1;
        }
    }
    
}
//here we are creating the class NameComparator which implements Comparator
class NameComparator implements Comparator<Employee>{

    @Override
    //here we are creating the compare method which is of return type
    public int compare(Employee o1, Employee o2) {
    	//here we are applying condition for compare on the basis of name
        return o1.getName().compareTo(o2.getName());  
    }
    
}
//here we are creating the class DesignationComparator which implements Comparator
class DesignationComparator implements Comparator<Employee>{

    @Override
  //here we are creating the compare method which is of return type
    public int compare(Employee o1, Employee o2) {
    	//here we are applying condition for compare on the basis of Designation	
        return o1.getDesignation().compareTo(o2.getDesignation());  
    }
    
}
//here we are creating the class EmployeeChainedComparator which implements Comparator
class EmployeeChainedComparator implements Comparator<Employee> {
     
	private List<Comparator<Employee>> listComparators;
 
    @SafeVarargs
    //here we are creating the constructor
    public EmployeeChainedComparator(Comparator<Employee>... comparators) {
        this.listComparators =  Arrays.asList(comparators);
    }
 
    @Override
  //here we are creating the compare method which is of return type
    public int compare(Employee emp1, Employee emp2) {
        for (Comparator<Employee> comparator : listComparators) {
            int result = comparator.compare(emp1, emp2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}