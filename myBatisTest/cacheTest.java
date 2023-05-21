package myBatisTest;

import org.apache.ibatis.session.SqlSession;

import myBatisTest.entity.Student;
import myBatisTest.mapper.TestMapper;

public class cacheTest {
    public static void main(String[] args) {
        try(SqlSession session = MyBatisUtil.getSession(true)){
            //FIRST level cache is only shared within its own session
            //SECOND level cache can be shared and used with all session

            //using session sometimes may cause error because if the database is changed
            //the SQLsession might still be returning the old cache without knowing anything its updated
            //to syhcronize the cache, we might need to use Redis

            //if we want to fix that manually, we have to close all the second level cache,
            //and set the SQL method to flushCache = "true"
            //that way the method will acess the database everytime without using cache
            TestMapper mapper = session.getMapper(TestMapper.class);
            // print out every student
            mapper.selectStudent().forEach(System.out::println);
            
            // return only 1 student whos sid is given
            Student s1 = mapper.getStudentBySid(102851);
            Student s2 = mapper.getStudentBySid(102851);
            // note that the s1 and s2 are the same object in memory because 
            // the object s1 is cached in case of using the same element again for SQL
            System.out.println(s1 == s2);

            // if we do insertion or add a student opereation from mapper
            // all the cache would be cleared beucase the database is not the same anymore


            // In this case, 2 object are not the same because different sessions
            // uses different cache
            Student s3;
            try(SqlSession session2 = MyBatisUtil.getSession(true)){
                TestMapper mapper2 = session2.getMapper(TestMapper.class);
                s3 = mapper2.getStudentBySid(102851);
            }
            Student s4 = mapper.getStudentBySid(102851);
            //if second cache is opened then it should be true
            //if not opened, it should be false
            System.out.println(s4 == s3);

            // if we want to use 2nd level cache, add <cache/> in TestMapper.xml
            // also remeber to add settings in mybatis-config

            // we can be more specific if we want to refresh cache after each sqlCall
            // now we can add flushCache="true" in the TestMapper.xml tags

            //if we don't want a SQL call use any cache to help, we can add
            // useCache = "false" in the TestMapper.xml tags
            
            //In below exmaple if session is not closed, their first level cache
            //will not be written into the second level cache which is shared
            // We opened second degree cache in mybatis-config.xml, it should return false
            try(SqlSession session3 = MyBatisUtil.getSession(true);
                SqlSession session4 = MyBatisUtil.getSession(true)){
                    TestMapper mapper3 = session3.getMapper(TestMapper.class);
                    TestMapper mapper4 = session4.getMapper(TestMapper.class);
                    Student s100 = mapper3.getStudentBySid(1);
                    Student s101 = mapper4.getStudentBySid(1);
                    // the first level cache from session3 is not yet written to second level yet
                    System.out.println(s100 == s101);

            }
            
            
        }
    }
    
}
