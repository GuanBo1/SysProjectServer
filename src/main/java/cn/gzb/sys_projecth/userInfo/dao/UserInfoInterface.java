package cn.gzb.sys_projecth.userInfo.dao;
import cn.gzb.sys_projecth.userInfo.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface UserInfoInterface extends JpaRepository<UserInfo, Long> {
    @Override
    List<UserInfo> findAll();
    @Transactional
    @Modifying
    @Query(value = "select * from user_info where name=?1 and password=?2",nativeQuery = true)
    List<UserInfo> findByNameAndPassword(String userName,String password);
}
