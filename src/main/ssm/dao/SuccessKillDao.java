package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.model.SuccessKill;

/**
 * Created by cjw on 2017/6/21.
 */
@Repository
public interface SuccessKillDao {
    /**
     *@Author  cjw
     *@Date 2017/6/21 10:45
     *@Description 秒杀成功记录入库
     */
    int insertSuccessKill(@Param("secKillId") Long secKillId,@Param("phone") Long phone);

    /**
     *@Author  cjw
     *@Date 2017/6/21 10:47
     *@Description 获取秒杀成功记录
     */
    SuccessKill querySuccessRecord(@Param("secKillId") Long secKillId,@Param("phone") Long phone);
}
