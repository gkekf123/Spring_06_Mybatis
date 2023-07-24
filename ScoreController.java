package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;

@Controller
@RequestMapping("/service")
public class ScoreController {

	// 1st - 멤버변수로 선언해도 된다
	// 갯수가 많아지면 많아진만큼 객체생성 해야된다
//	ScoreService service = new ServiceScoreImpl();
	
//	System.out.println(vo.toString());
	
	// 1st
	// 자식생성 부모저장!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//	ScoreService service = new ServiceScoreImpl();
//	service.scoreRegist(vo);
	
	// 2st - 직접 빈등록 자동주입
//	@Autowired
//	ScoerService service;
	
	// 3st
	@Autowired
	@Qualifier("scoreService") // "이름"으로 연결 serviceScoreImpl
	ScoreService scoreService;
	
	
	// 화면 처리
	// 등록
	@RequestMapping("/scoreRegist")
	public String scoreregist() {
		return "service/scoreRegist";
	}
	
	// 목록
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		// 데이터를 모델에 담아 화면에 뿌린다
		
		ArrayList<ScoreVO>list = scoreService.getScores();	
		model.addAttribute("list", list);
		
		return "service/scoreList"; // 포워드
	}
	
	// 결과
	@RequestMapping("/scoreResult")
	public String scoreResult() {
		return "service/scoreResult";
	}
	
	// 등록 요청
	@RequestMapping(value = "/scoreForm", method=RequestMethod.POST)
	public String scoreForm(ScoreVO vo) {
		scoreService.scoreRegist(vo);
		return "redirect:/service/scoreResult"; // 등록 이후에 결과로
	}
	
	// 삭제 요청
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("num") int index) {
		
		scoreService.scoreDelete(index);
		
		return "redirect:/service/scoreList"; // 삭제 후 목록으로
	}
	
}
