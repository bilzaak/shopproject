package kasba.shop.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kasba.shop.helper.Masiksell;
import kasba.shop.model.Sell;
public interface Sellingrepo extends JpaRepository<Sell,Integer>{
 @Query("SELECT DISTINCT p.memokey  FROM Sell p WHERE p.customername like %:customername%")
    public List<Sell> distinctname(String customername);
	
    @Query("SELECT DISTINCT p.memokey  FROM Sell p WHERE p.customerphone like %:customerphone%")
    public List<Sell> distinctphone(String customerphone);

    public List<Sell> findByShopidAndCustomerphone(int shopid,String asik);
    public List<Sell> findByShopidAndSelldate(int shopid,Date d);
    public List<Sell> findByShopidAndCustomernameContainingIgnoreCase(int shopid, String asik);
public List<Sell> findByShopidAndSelldateBetween(int shopid, Date d, Date d2);
public List<Sell> findByShopidAndDueGreaterThanAndSelldateBetween(int shopid, float i, Date d, Date d2);
	public List<Sell> findByShopidAndSelldateAndDueGreaterThan(int shopid, Date d, float i);
public List<Sell> findByShopidAndDueGreaterThan(int shopid, float i);

public List<Sell> findByMemokey(String memokey);
	
}
