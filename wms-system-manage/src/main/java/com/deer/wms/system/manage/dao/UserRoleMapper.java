package com.deer.wms.system.manage.dao;

import com.deer.wms.project.seed.core.mapper.Mapper;
import com.deer.wms.system.manage.model.UserRole;

public interface UserRoleMapper extends Mapper<UserRole> {

	void updateUserRole(UserRole userRole);
}