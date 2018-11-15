package HomeWorkManager.service.serviceImpl;

import HomeWorkManager.dao.UserDao;
import HomeWorkManager.dto.BaseInfoDto;
import HomeWorkManager.dto.StudentDto;
import HomeWorkManager.dto.TeacherDto;
import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.UserService;
import HomeWorkManager.utils.PassWordUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.registry.infomodel.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by cjw on 2017/9/5.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public UserEnity findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }

    @Override
    public UserEnity findUserByUserId(String userId) {
        return userDao.findUserByUserId(userId);
    }

    @Override
    public void createUser(UserEnity userEnity) {
        PassWordUtil.encryptPassword(userEnity);
        userDao.createUser(userEnity);
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void updateUser(UserEnity userEnity) {
        userDao.updateUser(userEnity);
    }

    @Override
    public void relateUserAndRole(Long userId, Long... roleIds) {
        if(roleIds==null||roleIds.length==0)
            return;
        for (Long roleId:roleIds){
            userDao.relateUserAndRole(userId,roleId);
        }
    }

    @Override
    public void unrelateUserAndRole(Long userId, Long... roleIds) {
        if(roleIds==null||roleIds.length==0)
            return;
        for (Long roleId:roleIds){
            userDao.unrelateUserAndRole(userId,roleId);
        }
    }

    @Override
    public Set<String> findRoles(String userName) {
        return userDao.findRoles(userName);
    }

    @Override
    public Set<String> findPermissions(String userName) {
        return userDao.findPermissions(userName);
    }

    @Override
    public StudentDto selectStudentInfoByUserId(String userId) {
        StudentDto dto= userDao.selectStudentInfoByUserId(userId);
        return dto;
    }

    @Override
    public TeacherDto selectTeacherInfoByUserId(String userId) {
        return userDao.selectTeacherInfoByUserId(userId);
    }

    public Map<String,Object> produceParams(){

        return null;
    }

    @Override
    public BaseInfoDto getBaseInfo(UserEnity user){
        BaseInfoDto baseInfoDto = new BaseInfoDto();
        if(user.getType() == 1){
            TeacherDto dto = selectTeacherInfoByUserId(user.getUserId());
            BeanUtils.copyProperties(dto,baseInfoDto);
            baseInfoDto.setType(user.getType());
        }
        if(user.getType() == 2){
            StudentDto dto = selectStudentInfoByUserId(user.getUserId());
            BeanUtils.copyProperties(dto,baseInfoDto);
            baseInfoDto.setType(user.getType());
        }
        return baseInfoDto;
    }

}
