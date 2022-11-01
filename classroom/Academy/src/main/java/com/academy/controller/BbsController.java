package com.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.academy.domain.BbsVO;
import com.academy.service.BbsService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BbsController {

	private BbsService service;

	@GetMapping("/list") // 1.목록조회
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());

	}

	@PostMapping("/register") // 2.입력
	public String register(BbsVO board, RedirectAttributes rttr) {

		log.info("refister: " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBbsID());
		return "redirect:/board/list";
	}

//	@GetMapping("/get") // 3.검색
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bbsID") long bbsID, Model model) {
		log.info("/get");
		model.addAttribute("board", service.get(bbsID));
	}

	// 오타주의
	@PostMapping("/modify") // 4.수정
	public String modify(BbsVO board, RedirectAttributes rttr) {
		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:/board/list";
	}

//	@PostMapping("/remove") // 5.삭제
	@GetMapping("/remove") // 5.삭제
	@RequestMapping(value = "/remove", method = { RequestMethod.GET, RequestMethod.POST})
	public String remove(@RequestParam("bbsID") Long bbsID, RedirectAttributes rttr) {

		log.info("remove..." + bbsID);
		if (service.remove(bbsID)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

}
