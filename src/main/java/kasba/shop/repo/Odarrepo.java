package kasba.shop.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kasba.shop.model.Odar;
public interface Odarrepo extends JpaRepository<Odar,Integer>{

	List<Odar> findByShopidAndCompanyAndCodeAndNameOrderByUnitpriceAsc(int shopid, String company, String code,
			String name);

	@Query(value ="SELECT sum(unitprice) FROM Odar P WHERE P.company=?1 AND P.shopid=?2 AND P.name=?3 AND P.code=?4") // unit price is the column of product table
    public float total(String com , int shopid , String name , String code);	
	

     @Query("SELECT AVG(unitprice) FROM Odar P WHERE P.company=?1 AND P.shopid=?2 AND P.name=?3 AND P.code=?4")
     public float avrg(String com , int shopid , String name , String code);	
     
     

}
