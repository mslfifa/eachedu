package com.eachedu.dao;

import com.eachedu.dao.pojo.MasaUserV;

public interface MasaUserVDao extends BaseDao {
	MasaUserV findUser(String userid,String password);
}
