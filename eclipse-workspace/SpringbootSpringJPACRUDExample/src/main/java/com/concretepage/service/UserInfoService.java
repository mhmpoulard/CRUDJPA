package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IUserInfoDAO;
import com.concretepage.entity.Article;

@Service
public class UserInfoService implements IUserInfoService {

	@Autowired
	private IUserInfoDAO userinfoDAO;
	@Override
	public List<Article> getAllUserArticles() {
		// TODO Auto-generated method stub
		return userinfoDAO.getAllUserArticles();
	}

}
