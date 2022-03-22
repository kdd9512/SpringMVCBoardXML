package controller;

import beans.MemberInfoBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class HomeController {
	// loginMemberBean 이 session 으로 들어오고 있는지 확인하기 위한 코드.

	// xml 프로젝트는 서버 가동시 자동으로 Bean 을 주입하려 하는데 이 Bean 은 sessionScope 이기 때문에
	// 그냥 주입하려하면 최초 서버 실행시 주입하려 하기 때문에 오류가 발생한다.
	// 이하의 "@Lazy" annotation 을 추가하여 서버가 가동된 이후에 Bean 주입을 하게 해야 한다.
//	@Resource(name = "loginMemberBean")
//	@Lazy
//	private MemberInfoBean loginMemberBean;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
//		System.out.println(loginMemberBean);
		return "redirect:/main";
	}
}

