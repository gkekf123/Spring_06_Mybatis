package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.mapper.ScoreMapper;

@Service("scoreService") // 컴포넌트 스캔에 읽히면 자동으로 빈 등록
public class ScoreServiceImpl implements ScoreService{

//		mybatis의 ScoreMapper.java로 이동
	@Autowired
	private ScoreMapper scoreMapper;
	
	// 등록
	@Override
	public void scoreRegist(ScoreVO vo) {
		scoreMapper.scoreRegist(vo);
	}

	// 조회
	@Override
	public ArrayList<ScoreVO> getScores() {
		
		return scoreMapper.getScores();
	}

	// 삭제
	@Override
	public void scoreDelete(int index) {
		scoreMapper.scoreDelete(index);
	}

	
	
//	// DAO영역
//	@Autowired
//	@Qualifier("scoreDAO")
//	ScoreDAO scoreDAO;
//	
//	@Override
//	public void scoreRegist(ScoreVO vo) {
//
//		scoreDAO.scoreRegist(vo);
//		
//	}
//
//	@Override
//	public ArrayList<ScoreVO> getScores() {
//		return scoreDAO.getScores();
//	}
//
//	@Override
//	public void scoreDelete(int index) {
//		scoreDAO.scoreDelete(index);
//	}

}
