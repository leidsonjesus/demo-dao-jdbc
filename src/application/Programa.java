package application;

import java.util.Date;

import model.entidade.Department;
import model.entidade.Saller;

public class Programa {

	public static void main(String[] args) {
 
		Department dp = new Department(1, " Books");
		System.out.println(dp);

		Saller saller = new Saller(12, "Leidson", "leidson333@gmail.com", new Date(), 15000.00, dp);
		System.out.println(saller);
	}
	

}
