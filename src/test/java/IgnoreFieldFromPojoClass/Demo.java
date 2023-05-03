package IgnoreFieldFromPojoClass;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Demo {

	@Test
	public void demo() throws JsonProcessingException
	{
		
		//Crate POJO Class object
		
		Employee e1=new Employee();
		e1.setName("Amin");
		e1.setAge(38);
		e1.setSalary(200000);
		e1.setFullName("Amin Shetty");
		e1.setEmail("amin@southindia.com");
		
		//Seriliztion of POJO--to--JOSN
		
		ObjectMapper object=new ObjectMapper();
		String emp=object.writerWithDefaultPrettyPrinter().writeValueAsString(e1);
		System.out.println(emp);
		
		//Now i dont want to print FullName so I would add @JSONIgnore annotation to field firstName
		//then it would print as follows
		
//		{
//			  "name" : "Amin",
//			  "age" : 38,
//			  "salary" : 200000,
//			  "email" : "amin@southindia.com"
//		}
		
		//what if i want both age and full name to be ignored 
		//will add @JsonIgnoreProperties(value= {"age","fullName"}) 
		//it will print
		
//		{
//			  "name" : "Amin",
//			  "salary" : 200000,
//			  "email" : "amin@southindia.com"
//			}
		

		
	}
}
