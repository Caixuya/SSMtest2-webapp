package com.thxy.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.thxy.dao.user.UserMapper;
import com.thxy.datasource.DataConnection;
import com.thxy.pojo.User;

public class MyBatisTest {
	
	public DataConnection dataConn=new DataConnection();
	
	@Test
	public void selectAllUser() throws IOException {
		
		SqlSession sqlSession=dataConn.getSqlSession();
		List<User> list=sqlSession.getMapper(UserMapper.class).selectAllUser();
		for(User user:list) {
			System.out.println(user.toString());
		}
		sqlSession.close();
	}
	
	@Test
//		查询一条记录，通过id查找姓名
	public void SelectById() throws IOException {
		
//		InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
//		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//		SqlSession sqlSession=sqlSessionFactory.openSession();
		
//		下面这句话代替上面的三句，因为这句话是引入com.thxy.datasource包下的
//		DataConnection.java中的getSqlSession方法，getSqlSession方法里写的就是这三句，因此
//		有这句话就不用重复写上面的三句，使不使用接口这句都是必要的
		SqlSession sqlSession=dataConn.getSqlSession();
		
//		执行语句
//		不使用接口：这里的selectOne("UserMapper.xml的namespace名.UserMapper.xml的id名",查询的值)
//		User user=sqlSession.selectOne("user.findUserById",5);  //当使用接口时，下面这句必须注释掉。

//		使用接口时应该注意：使用接口必须更改UserMapper.xml的namespace值，改成接口文件所在的位置
//		使用接口：引入接口类UserMapper。java，不使用接口时，这句必须注释掉
		User user = sqlSession.getMapper(UserMapper.class).findUserById(3);
		
		System.out.println("id:"+user.getId());
		System.out.println("姓名:"+user.getUserName());
		
		 //释放资源
		sqlSession.close();
	}
	
	@Test
	//增加一条记录
	public void testInsert() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
			
		User users=new User();
		users.setId(14);
		users.setUserName("老王");
		users.setGender(0);
		users.setUserPassword("1258");
		
//		      不使用接口： 下面这条输出添加的记录数目
//	  	  int insert=sqlSession.insert("user.add", users);
//	      System.out.println(insert);

//		       不使用接口的另一种方法，按需选择：下面这条输出添加的user集合
//		  sqlSession.insert("user.add", users);
//	      System.out.println(users);

//		使用接口：
		 sqlSession.getMapper(UserMapper.class).insertUser(users);
	
//		如果是增删改，必须提交事务，持久化到数据库：
		sqlSession.commit();
//		关闭连接：
		sqlSession.close();
		
		System.out.println("增加记录成功");
	}
	
	@Test
	//删除一条记录
	public void testDeleteUser() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		
//		不使用接口		
//		sqlSession.delete("user.delete","13");

//		使用接口
//		 int mapper = sqlSession.getMapper(UserMapper.class).delete(13);
		sqlSession.getMapper(UserMapper.class).deleteUser(14);
		
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println("删除记录成功");
	}
	
	@Test
	//修改一条记录
	public void testUpdate() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		
		//当UserMapper.java中updateUser的接口是int类型时，即public int updateUser(User user)，可创建一个User对象，控制台显示更新数目
	//	User user=new User();
	//	user.setId(5);
	//	user.setUserName("王老9");
		
//		不使用接口		
//		sqlSession.insert("user.update",user);
//		System.out.println(user);
		
//		使用接口
		sqlSession.getMapper(UserMapper.class).updateUser("李lllu",3);
		//void类型不返回任何值，没有返回值，所以无法调用返回值显示修改后的信息
		
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println("修改成功");
	}
	
}
