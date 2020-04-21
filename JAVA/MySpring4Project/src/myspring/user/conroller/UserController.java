package myspring.user.conroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//����� ��� ��ȸ 
	@RequestMapping("/userList.do")
	public ModelAndView userList() {
		List<UserVO> userList = userService.getUserList();
		return new ModelAndView("userList", "userList", userList); // = request.setAttribute("userList", users);
	
	}
	//����� �������� ��ȸ
	@RequestMapping("/userDetail.do")
	//@RequestParam => request.getParameter()
	//QueryString ? key1=value&key2=value2
	public String userDetail(@RequestParam String userid, Model model ) { // @RequestParam = request.getParameter("id")
		UserVO user = userService.getUser(userid);
		model.addAttribute("user", user);
		return "userDetail";
	}
	//����� ��� Form ��ȸ 
	@RequestMapping("/userInsertForm.do")
	public String insertUserForm(HttpSession session) {
		List<String> genderList = new ArrayList<String>();
		genderList.add("��");
		genderList.add("��");
		//session�� genderList���� 
		session.setAttribute("genderList", genderList);

		List<String> cityList = new ArrayList<String>();
		cityList.add("����");
		cityList.add("�λ�");
		cityList.add("�뱸");
		cityList.add("����");
		cityList.add("��õ");
		//session�� cityList����
		session.setAttribute("cityList", cityList);

		return "userInsert";
	}
	//����� ��� ó�� 
	@RequestMapping(value = "/userInsert.do", method = RequestMethod.POST)
	public String usertInsert(@ModelAttribute UserVO user) {
		System.out.println(">> UserVo" + user);
		userService.insertUser(user);
		
		//����� �����ȸ�� ó���ϴ� ��û���� ������  �ϰڴ�
		return "redirect:/userList.do";
	}
	
	//����� ����ó�� -> userDelete.do/gildog(userid) url / base���� append�ϴ� ���  @PathVariable
	@RequestMapping("/userDelete.do/{id}")
	public String userDelete(@PathVariable("id") String userid) {
		userService.deleteUser(userid);
		return "redirect:/userList.do";
	
	}

	//����� updateform
	   @RequestMapping("/updateUserForm.do")
	   public String updateUserForm(HttpSession session, @RequestParam String id) {
	      UserVO user = userService.getUser(id);

	      List<String> genderList = new ArrayList<String>();
	      genderList.add("��");
	      genderList.add("��");
	      //session��ü genderList ��ü�� ����
	      session.setAttribute("genderList", genderList);

	      List<String> cityList = new ArrayList<String>();
	      cityList.add("����");
	      cityList.add("���");
	      cityList.add("�λ�");
	      cityList.add("�뱸");
	      cityList.add("��õ");
	      //session��ü�� cityList ��ü�� ����
	      session.setAttribute("cityList", cityList);
	      session.setAttribute("user", user);
	      return "userUpdate";
	   }

	   //����� updateó��
	   @RequestMapping("/userUpdate.do")
	   public String userUpdate(@ModelAttribute UserVO user) {
	      userService.updateUser(user);
	      return "redirect:/userList.do";
	   }
}
