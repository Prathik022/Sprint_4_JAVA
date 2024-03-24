package GymManagement;
import java.math.BigInteger;
import java.util.*;
public class Person {
	
	    private String name;
	    private int age;
	    BigInteger phoneNumber;

	    public Person(String name, int age, BigInteger phoneNumber) {
	        this.name = name;
	        this.age = age;
	        this.phoneNumber = phoneNumber;
	    }

	    // Getters and setters for name and age
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }
	
}
