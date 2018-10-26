package com.example.demo_jpa;

import com.example.demo_jpa.model.Role;
import com.example.demo_jpa.model.RoleRepository;
import com.example.demo_jpa.model.User;
import com.example.demo_jpa.model.UserRepository;
import com.example.demo_jpa.service.RoleService;
import com.example.demo_jpa.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Test
    public void loadContext() {

        // 创建10条记录
        int sizeBefore = userService.findAll().size();
        User user = userService.saveUser(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));
        int sizeAfter = userService.findAll().size();

        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, sizeAfter - sizeBefore);

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findByName("FFF").get(0).getAge().longValue());

        // 测试findUser, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findUser("FFF").get(0).getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).get(0).getName());

        // 测试删除姓名为AAA的User
        sizeBefore = userRepository.findAll().size();
        userRepository.delete(userRepository.findByName("AAA").get(0));
        sizeAfter = userRepository.findAll().size();

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(1, sizeBefore - sizeAfter);


        sizeBefore = roleService.findAll().size();
        roleRepository.save(new Role("创始人"));
        roleService.save(new Role("合伙人"));
        roleService.save(new Role("CEO"));
        roleService.save(new Role("普通员工"));
        sizeAfter = roleService.findAll().size();

        // TODO getOne spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
        // https://www.jianshu.com/p/f164e4b0aa18?utm_source=oschina-app
        //Role role = roleRepository.getOne(1L);
        //Assert.assertTrue(role.getName().equals("创始人"));
        Assert.assertTrue(sizeAfter - sizeBefore == 4);

//        userService.setUserRole();
    }

}
