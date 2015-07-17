package com.eachedu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.MasaUserVDao;
import com.eachedu.dao.pojo.MasaUserV;

@Repository("masaUserVDao")
public class MasaUserVDaoImpl extends BaseDaoImpl  implements MasaUserVDao {

	@Override
	public MasaUserV findUser(String userid, String password) {
		MasaUserV u = null;
		String hql = "from MasaUserV where userid=? and password=? ";
		List users = this.findByHql(hql, userid,password);
		u = (users==null || users.isEmpty())?null:(MasaUserV)users.get(0);
		return u;
	}

	

}
