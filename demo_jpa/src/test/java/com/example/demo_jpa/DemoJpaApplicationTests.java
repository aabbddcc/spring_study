package com.example.demo_jpa;

import com.example.demo_jpa.pojo.User;
import com.example.demo_jpa.pojo.UserRepository;
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

    @Test
    public void loadContext() {

        // 创建10条记录
        int sizeBefore = userRepository.findAll().size();
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));
        int sizeAfter =  userRepository.findAll().size();

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
        sizeAfter =  userRepository.findAll().size();

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(1, sizeBefore - sizeAfter);
    }

}
