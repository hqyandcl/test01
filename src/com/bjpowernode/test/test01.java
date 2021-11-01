package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test01 {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream=null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
             SqlSession session= sqlSessionFactory.openSession();


        //增删改查，处理事务等操作都是通过session对象来完成
        //根据id查单条
        //select方法需要两个参数
        //参数1：根据命名空间，和id找到我们需要使用到sql语句。
//        参数2：是我们需要为sql语句所传递的参数
      /*  Student s=session.selectOne("test1.s1","A0001");
        System.out.println(s);
        session.close();*/

       /* List<Student>studentList=session.selectList("test1.s2");
        System.out.println(studentList);
        session.close();*/
        session.delete("test1.s4");
        session.commit();
        session.close();
    }
}
