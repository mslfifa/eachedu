package com.eachedu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eachedu.dao.MasaUserVDao;
import com.eachedu.dao.pojo.MasaUserV;
import com.eachedu.service.MasaUserVService;
@Service("masaUserVService")
public class MasaUserVServiceImpl implements MasaUserVService {
	@Autowired
	private MasaUserVDao dao;
	@Override
	public MasaUserV findUser(String userid, String password) {
		// TODO Auto-generated method stub
		return dao.findUser(userid, password);
	}

}
