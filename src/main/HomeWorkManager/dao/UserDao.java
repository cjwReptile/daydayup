package HomeWorkManager.dao;

import HomeWorkManager.dto.StudentDto;
import HomeWorkManager.dto.TeacherDto;
import HomeWorkManager.enity.UserEnity;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by cjw on 2017/9/5.
 */
@Repository
public interface UserDao {

    public UserEnity findUserByName(String userName);

    public UserEnity findUserByUserId(String userId);

    public void createUser(UserEnity userEnity);

    public void deleteUser(Long userId);

    public void updateUser(UserEnity userEnity);

    public void relateUserAndRole(Long userId,Long...roleIds);

    public void unrelateUserAndRole(Long userId,Long...roleIds);



    Set<String> findRoles(String userName);

    Set<String> findPermissions(String userName);

    StudentDto selectStudentInfoByUserId(String userId);

    TeacherDto selectTeacherInfoByUserId(String userId);






}
