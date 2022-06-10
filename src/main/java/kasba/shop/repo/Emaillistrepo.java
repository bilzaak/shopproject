package kasba.shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kasba.shop.model.Emaillist;



public interface Emaillistrepo extends JpaRepository<Emaillist,Integer>{

	public boolean existsByEmail(String email);



}
