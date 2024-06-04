package com.example.erp.member;

import com.example.erp.board.FileUploadService;
import com.example.erp.dept.DeptDTO;
import com.example.erp.dept.DeptService;
import com.example.erp.dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import java.io.IOException;
import java.util.List;
//@SessionAttributes("user")에서 user라는 것은 세션에 저장하는 어트리뷰트의 이름.
//스프링MVC프레임워크 내부에스 컨트롤러에서 user라는 이름으로 공유된 Model객체에 저장된 어트리뷰트를 찾아서 
//"user"라는 이름의 어트리부트가 있으면 이를 세션에도 저장 해준다.
@Controller
@RequestMapping("/member")
@SessionAttributes("user")
public class MemberController {
	MemberService service;
	DeptService deptService;
	FileUploadService fileuploadService;

	
	@Autowired
	public MemberController(MemberService service, DeptService deptService, FileUploadService fileuploadService) {
		super();
		this.service = service;
		this.deptService = deptService;
		this.fileuploadService = fileuploadService;
	}

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("member/list");
		List<MemberDTO> memberlist = service.getMemberList();
		mav.addObject("memberlist",memberlist);
		return mav;
	}
	
	//로그인 - 기존방식
	@PostMapping("/login")
	public String login(MemberDTO loginUserInfo, HttpServletRequest request) {
		String view = "";
		System.out.println("*******"+loginUserInfo);
		MemberDTO user = service.login(loginUserInfo);
		if(user!=null) {
			//로그인 성공
			view = "redirect:/index.do";
			//세션에 로그인한 사용자의 데이터를 공유
			HttpSession session = request.getSession();//세션만들기 - 로그인 성공하면 세션을 만듬.
			session.setAttribute("user", user);
		}else {
			//로그인 실패
			view = "redirect:/emp/login.do";
		}
		return "redirect:/index.do";
	}
	
	//로그아웃 - 기존방식
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			//사용하던 세션을 메모리에서 제거
			session.invalidate();
		}
		return "redirect:/index.do";
	}
	
	//스프링에서 제공되는 기능을 이용해서 로그인 처리하기
	@PostMapping("/spring/login")
	public String springlogin(MemberDTO loginUserInfo, Model model) {
		System.out.println("스프링이 제공하는 @SessionAttributes를 이용해서 로그인");
		MemberDTO user = service.login(loginUserInfo);
		System.out.println("========로그인한 사용자 정보 : "+user);
		String view = "";
		if(user!=null) {
			//모델 객체에 user라는 이름으로 user객체 저장 -> 세션어트리뷰트가 user라는 이름으로 객체를 찾고있으면 얘를 반환함
			model.addAttribute("user",user);
			view = "emp/mypage"; //menu-tiles.xml에 등록한 이름의 뷰를 찾아서 뷰를 생성
		}else {
			view = "redirect:/emp/login.do";
		}
		return view;
	}
	//스프링에서 제공되는 기능을 이용해서 로그아웃
	//내부에서 세션의 상태를 확인할 수 있도록 - 스프링MVC내부에서 세션을 관리하기 위한 객체SessionStatus
	@GetMapping("/spring/logout")
	public String springlogout(SessionStatus status) {
		System.out.println("스프링이 제공하는 @SessionAttributes를 이용해서 로그아웃");
		status.setComplete();//세션에 있는 객체(로그인 정보)를 제거
		return "redirect:/index.do";
	}
	
	//@SessionAttributes를 사용해서 세션에 저장된 데이터를 관리하는 경우
	//@ModelAttribute("user")는 모델데이터를 메소드의 매개변수에 매핑할때 사용
	@GetMapping("/mypage")
	public String mypage(@ModelAttribute("user") MemberDTO user) {
		//로그인한 사용자의 mypage로 이동 - mypage는 menupath를 꺼내서 forward
		//로그인한 사용자의 정보는 세션에 저장되어있음
		System.out.println("로그인사용자=>"+user);
		return user.getMenupath();
	}
	
	@GetMapping("/insert")
	public String insert(Model model) {
		List<DeptDTO> deptlist = deptService.select();
		model.addAttribute("deptlist", deptlist);
		return "member/insert";
	}
	
	@PostMapping("/insert.do")
	public String insert(MemberDTO member, HttpSession session) throws IllegalStateException, IOException {
		//1. 파일 업로드
	    MultipartFile file = member.getUserImage();
//	    String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/static/images");
//	    System.out.println("memberinsert path : " + path);
	    System.out.println("memberinsert file : " + file);
	    System.out.println("member : " + member);
	  
	    String storeFileName = fileuploadService.uploadFile(file);
	    
	    member.setProfile_photo(storeFileName);
	    System.out.println("member : " + member);
	    //2. 디비에 저장
	    service.insert(member);
	    
	    return "redirect:/member/list";
	}
}
