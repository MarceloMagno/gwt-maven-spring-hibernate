package br.com.shared;

public class Validator {

	  public static boolean isBlank(String value) {
		  return (value == null || "".equals(value.trim()));
	  }
	  
	  public static boolean isBlank(Integer value) {
		  return (value <= 0);
	  }
	  
	  public static boolean isBlank(Long value) {
		  return (value <= 0);
	  }
}
