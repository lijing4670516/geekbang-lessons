package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.sql.LocalTransactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.validation.Validator;

public class UserServiceImpl implements UserService {

//    @Resource(name = "bean/EntityManager")
//    private EntityManager entityManager;
//
//    @Resource(name = "bean/Validator")
//    private Validator validator;

    @Resource(name = "bean/UserRepository")
    private DatabaseUserRepository databaseUserRepository;

    @Override
    // 默认需要事务
//    @LocalTransactional
    public boolean register(User user) {
        return databaseUserRepository.save(user);
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    @LocalTransactional
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
