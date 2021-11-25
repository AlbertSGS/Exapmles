package chapter5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Optional;

public class RandomThoughts {
	
	public static void main(String[] args) throws Exception {
		Optional<String> anOptional = Optional.of("Hi");
		Class<?> aClass = anOptional.getClass();
		
//		System.out.println(aClass.getName());
		
		for(Field aField : aClass.getDeclaredFields()) {
			System.out.println(aField.toString());
		}
		
		for(Method aMethod : aClass.getDeclaredMethods()) {
			System.out.println(aMethod.toString());
		}
		
		for(Constructor<?> constructor : aClass.getDeclaredConstructors()) {
			System.out.println(constructor.toString());
		}
				
		System.out.println(anOptional);
		
	}

}
