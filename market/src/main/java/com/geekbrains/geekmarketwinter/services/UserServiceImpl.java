package com.geekbrains.geekmarketwinter.services;

import contract.entities.Role;
import com.geekbrains.geekmarketwinter.entities.SystemUser;
import contract.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.geekbrains.geekmarketwinter.repositories.RoleRepository;
import com.geekbrains.geekmarketwinter.repositories.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private UserFeignService userFeignService;


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserFeignService(UserFeignService userFeignService) {
        this.userFeignService = userFeignService;
    }

    //     Рабочий вариант без фейн клиента.
//    @Override
//    @Transactional
//    public User findByUserName(String username) {
//        return userRepository.findOneByUserName(username);
//    }
    // DZ 9_4 (работает)
    @Override
    @Transactional
    public User findByUserName(String userName) {

        return userFeignService.findByUserName(userName);
    }


    //     Рабочий вариант без фейн клиента.
//    @Override
//    @Transactional
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
    // DZ 9_4 (работает)
    @Override
    @Transactional
    public List<User> getAllUsers() {

        return userFeignService.findAll();
    }


    @Override
    @Transactional
    public boolean save(SystemUser systemUser) {
        User user = new User();

        if (findByUserName(systemUser.getUserName()) != null) {
            return false;
        }

        user.setUserName(systemUser.getUserName());
        user.setPassword(passwordEncoder.encode(systemUser.getPassword()));
        user.setFirstName(systemUser.getFirstName());
        user.setLastName(systemUser.getLastName());
        user.setPhone(systemUser.getPhone());
        user.setEmail(systemUser.getEmail());

        user.setRoles(Arrays.asList(roleRepository.findOneByName("ROLE_EMPLOYEE")));
// dz 9_4
        userFeignService.saveUser(user);

        //    Старый вариант рабочий
//        userRepository.save(user);

        return true;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findOneByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
