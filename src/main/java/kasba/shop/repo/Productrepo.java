package kasba.shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kasba.shop.model.Product;
public interface Productrepo extends JpaRepository<Product,Integer>{

	boolean existsByCompanyIgnoreCaseAndCode(String comp,String code);

	List<Product> findByCompanyContainingIgnoreCase(String company);

	List<Product> findByCodeContainingIgnoreCase(String code);

	List<Product> findByNameContainingIgnoreCase(String name);

	boolean existsByCompany(String company);

	List<Product> findByCompanyAndNameContainingIgnoreCase(String company, String name);

	boolean existsByCompanyAndNameAndCode(String company, String name,String code);

	List<Product> findByCompanyAndCodeContainingIgnoreCase(String company, String code);
	
	@Query(value ="SELECT sum(unitprice) FROM Product P WHERE P.company=?1 AND P.pid=?2") // unit price is the column of product table
    public float total(String com , int pid);

	boolean existsByCompanyAndCode(String company, String code);

	boolean existsByCompanyAndName(String company, String name);

	boolean existsByCompanyAndNameIgnoreCase(String company, String name);
	
	
}
