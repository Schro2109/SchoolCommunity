package com.dao;

import java.util.ArrayList;

import com.vo.HomePostsVO;

public class Test {
	
	public static void main(String[] args) {
		SchoolDAO dao = new SchoolDAO();
		ArrayList<HomePostsVO> list = dao.getHomePosts("NEWS");
		for(HomePostsVO vo : list) {
			System.out.println(vo.getpCode());
		}
	}
}
