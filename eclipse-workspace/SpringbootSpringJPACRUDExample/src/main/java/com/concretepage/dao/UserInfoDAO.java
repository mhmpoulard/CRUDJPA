package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.concretepage.entity.Article;
import com.concretepage.entity.UserInfo;

@Repository
@Transactional
public class UserInfoDAO implements IUserInfoDAO {

	@PersistenceContext	
	private EntityManager entityManager;
	@Override
	public UserInfo getActiveUser(String userName) {
		// TODO Auto-generated method stub
		UserInfo activeUserInfo = new UserInfo();
		short enabled = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=? and enabled=?")
				.setParameter(1, userName).setParameter(2, enabled).getResultList();
		if(!list.isEmpty()) {
			activeUserInfo = (UserInfo)list.get(0);
		}
		return activeUserInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllUserArticles() {
		// TODO Auto-generated method stub
		String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}

}
