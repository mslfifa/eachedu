package com.eachedu.service;

import com.eachedu.dao.pojo.MasaUserV;

public interface MasaUserVService {
	MasaUserV findUser(String userid,String password);
}
