package Test;

import com.fujia.pojo.Academy;
import com.fujia.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class AcademyTest {
    /**
     * @Description: 根据学院ID获取学院信息
     * @Param : null
     * @Return: void
     **/
    @Test
    public void findAcademyByIdTest() {
        SqlSession session = MyBatisUtils.getSession();
        Academy academy = session.selectOne("findAcademyById", 5);
        if(academy==null)
            System.out.println("没有此学院！");
        else
            System.out.println(academy);
        session.close();
    }

    /**
     * @Description: 根据学院名模糊查询学院信息列表 或 查询所有学院信息列表
     * @Param : null
     * @Return: void
     **/
    @Test
    public void findAcademyByNameTest() {
        SqlSession session = MyBatisUtils.getSession();
        List<Academy> academyList = session.selectList("findAcademyByName", "");
        for(Academy academy : academyList) {
            System.out.println(academy);
        }
    }

    @Test
    public void addAcademyTest(){
        SqlSession session = MyBatisUtils.getSession();
        Academy academy = new Academy("潇湘学院");
        int count = session.insert("addAcademy", academy);
        if(count > 0){
            System.out.println("插入数据成功！");
        }else{
            System.out.println("插入数据失败！");
        }
        session.commit();
        session.close();
    }

    @Test
    public void updateAcademyTest() {
        SqlSession session = MyBatisUtils.getSession();
        Academy academy = new Academy(3, "潇湘学院");
        int count = session.update("updateAcademy", academy);
        if(count > 0){
            System.out.println("修改数据成功！");
        }else{
            System.out.println("修改数据失败！");
        }
        session.commit();
        session.close();
    }

    @Test
    public void deleteAcademyTest() {
        SqlSession session = MyBatisUtils.getSession();
        int count = session.delete("deleteAcademy", 8);
        if(count > 0){
            System.out.println("删除数据成功！");
        }else{
            System.out.println("删除数据失败！");
        }
        session.commit();
        session.close();
    }
}