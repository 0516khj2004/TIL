package myspring.user.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.UserVOXML;

@RestController
//controller + responseBody

public class RestUserController {
	@Autowired
	UserService userService;
	
	//json����
	//����� ��� 
	@GetMapping("/users")
	public List<UserVO> userList(){
		return userService.getUserList();
	}
	
	//����� �� ��ȸ
	@GetMapping("/users/{id}")
	public UserVO userDetail(@PathVariable("id") String userid) { // @PathVariable String id {id}�� �����̸��� ���߸� variable�Ƚᵵ �ȴ�
		
		return userService.getUser(userid);
	}
	//����� ��� 
	@PostMapping("/users")
	public Boolean userInsert(@RequestBody UserVO user) {
		if(user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
	}
	
	//����� ���� 
	@PutMapping("/users")
	public Boolean userUpdate(@RequestBody UserVO user) {
		if(user != null) {
			userService.updateUser(user);
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
	}
	//����� ����
	@DeleteMapping("/users/{id}")
	public Boolean userDBoolean(@PathVariable String id) {
		if(id != null) {
			userService.deleteUser(id);
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
	}
	
	//xml����
	//����� ���
	@GetMapping("/usersxml")
	public UserVOXML userListXml() {
		List<UserVO> userList = userService.getUserList();
		return new UserVOXML("success", userList);	
	}
}
