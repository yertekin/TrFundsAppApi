package tr.fundsapp.TrFundsAppApi.data.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.fundsapp.TrFundsAppApi.data.dao.security.ERole;
import tr.fundsapp.TrFundsAppApi.data.dao.security.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
