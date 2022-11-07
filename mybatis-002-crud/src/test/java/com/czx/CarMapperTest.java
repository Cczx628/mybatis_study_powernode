package com.czx;

import com.czx.pojo.Car;
import com.czx.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {

    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Car car = new Car(null, "9999", "比亚迪汉", 10.0, "2020-10-14", "新能源车");
        int count = sqlSession.insert("insertCar", car);
        System.out.println("插入了几条数据:" + count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        int i = sqlSession.delete("deleteById", 5);
        System.out.println("删除成功" + i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Car car = new Car(3L, "6231", "比亚迪宋", 15.0, "2021-10-14", "新能源车");
        int i = sqlSession.update("updateById", car);
        System.out.println("更新成功" + i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Object car = sqlSession.selectOne("selectById", 2);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        List<Object> cars = sqlSession.selectList("selectAll");
        cars.forEach(System.out::println);
        sqlSession.commit();
        sqlSession.close();
    }
}
