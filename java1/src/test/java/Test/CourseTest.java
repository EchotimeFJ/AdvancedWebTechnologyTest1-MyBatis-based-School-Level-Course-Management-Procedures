package Test;

import com.fujia.pojo.Course;
import com.fujia.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CourseTest {

    /**
     * @Description: 根据课程名模糊查询课程信息列表 或 查询所有课程信息列表
     * @Param : null
     * @Return: void
     **/
    @Test
    public void findCourseByName() {
        SqlSession session = MyBatisUtils.getSession();
        List<Course> courseList = session.selectList("findCourseByName","");
        for(Course course : courseList) {
            System.out.println(course);
        }
    }

    @Test
    public void findCourseByCsAcademy() {
        SqlSession session = MyBatisUtils.getSession();
        List<Course> courseList = session.selectList("findCourseByName","");
        for(Course course : courseList) {
            if(course.getAcademyId()==1)
                System.out.println(course);
        }
    }


    /**
     * @Description: 根据课程ID获取课程信息
     * @Param : null
     * @Return: void
     **/
    @Test
    public void findCourseById() {
        SqlSession session = MyBatisUtils.getSession();
        Course course = session.selectOne("findCourseById", 2);
        System.out.println(course);
    }

    /**
     * @Description: 根据学院ID获取课程信息列表
     * @Param : null
     * @Return: void
     **/
    @Test
    public void findCourseByAcademyId() {
        SqlSession session = MyBatisUtils.getSession();
        List<Course> courseList = session.selectList("findCourseByAcademyId", 1);
        for(Course course : courseList) {
            System.out.println(course);
        }
    }
    /**
     * @Description: 添加课程信息
     * @Param : null
     * @Return: void
     **/
    @Test
    public void addCourse() {
        SqlSession session = MyBatisUtils.getSession();
        Course course = new Course(10,"大数据存储", 32, 1);
        int count = session.insert("addCourse", course);
        if(count > 0){
            System.out.println("插入课程成功！");
        }else{
            System.out.println("插入课程失败！");
        }
        session.commit();
        session.close();
    }

    /**
     * @Description: 更新课程信息
     * @Param : null
     * @Return: void
     **/
    @Test
    public void updateCourse() {
        SqlSession session = MyBatisUtils.getSession();
        Course course = new Course(4,"高级Web技术", 40, 1);
        int count = session.update("updateCourse", course);
        if(count > 0){
            System.out.println("修改数据成功！");
        }else{
            System.out.println("修改数据失败！");
        }
        session.commit();
        session.close();
    }

    /**
     * @Description: 删除课程信息
     * @Param : null
     * @Return: void
     **/
    @Test
    public void deleteCourse() {
        SqlSession session = MyBatisUtils.getSession();
        int count = session.delete("deleteCourse", 4);
        if(count > 0){
            System.out.println("删除课程成功！");
        }else{
            System.out.println("删除课程失败！");
        }
        session.commit();
        session.close();
    }
}
