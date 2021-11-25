package chapter5;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class ClassObject {
	
	public static void main(String[] args) throws Exception{
		Class<Integer> aClass = Integer.class;
		for(Type type : aClass.getGenericInterfaces()) {
			System.out.println(type.getTypeName());
			
		}
		
		for(Field field : aClass.getDeclaredFields()) {
			System.out.println(field.getName());
		}
	}

}
