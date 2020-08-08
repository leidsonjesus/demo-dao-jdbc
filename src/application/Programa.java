package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entidade.Saller;

public class Programa {

	public static void main(String[] args) {

		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Saller saller = sellerDao.findbyId(1);
		
		System.out.println(saller);
	}
	

}
