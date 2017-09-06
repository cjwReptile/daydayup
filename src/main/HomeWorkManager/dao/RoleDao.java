package HomeWorkManager.dao;

import HomeWorkManager.enity.RoleEnity;

/**
 * Created by cjw on 2017/9/6.
 */
public interface RoleDao {
    void createRole(RoleEnity roleEnity);

    void deleteRole(Long roleid);

    void relateRoleAndPermission(Long roleid,Long...permissionId);

    void unrelateRoleAndPermission(Long roleId,Long...permissionId);
}
