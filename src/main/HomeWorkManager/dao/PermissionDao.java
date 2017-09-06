package HomeWorkManager.dao;

import HomeWorkManager.enity.Permissions;

/**
 * Created by cjw on 2017/9/6.
 */
public interface PermissionDao {

    void createPermission(Permissions permissions);

    void deletePermission(Long permissionId);

}
