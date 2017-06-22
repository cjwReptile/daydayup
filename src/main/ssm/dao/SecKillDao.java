package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.model.SecKill;

import java.util.Date;
import java.util.List;

/**
 * Created by cjw on 2017/6/21.
 */
@Repository
public interface SecKillDao {
    /**
     *@Author  cjw
     *@Date 2017/6/21 10:36
     * 更新数据库记录
     */
    public int updataProduct(@Param("seckIllId") Long seckIllId,@Param("secKillTime") Date secKillTime);

    /**
     *@Author  cjw
     *@Date 2017/6/21 10:39
     * 获取秒杀商品，通过id
     */
     SecKill queryById(Long secKillId);

     /**
      *@Author  cjw
      *@Date 2017/6/21 10:41
      * 获取秒杀商品列表
      */
     List<SecKill> queryAll(@Param("offset") int offset,@Param("limit")int limit);
}
