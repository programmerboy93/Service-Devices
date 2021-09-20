package pl.serwiszarogiem.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.serwiszarogiem.repository.RoleRepository;

@Component
@Primary
public class DaoRoleService implements RoleService{

    private final RoleRepository roleRepository;
    @Autowired
    public DaoRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
