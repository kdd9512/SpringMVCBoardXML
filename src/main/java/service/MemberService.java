package service;

import beans.MemberInfoBean;
import dao.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberService {

    @Autowired
    private MemberDAO memberDAO;

    // xml 프로젝트는 서버 가동시 자동으로 Bean 을 주입하려 하는데 이 Bean 은 sessionScope 라서
    // 그냥 주입하려하면 최초 서버 실행시 주입하려 하기 때문에 오류가 발생한다.
    // 이하의 "@Lazy" annotation 을 추가하여 서버가 가동된 이후에 Bean 주입을 하게 해야 한다.
    @Resource(name = "loginMemberBean")
    @Lazy
    private MemberInfoBean loginMemberBean;

    public boolean checkMemberIdExist(String user_id) {
        String user_name = memberDAO.checkMemberIdExist(user_id);

        // user_name 이 null 이라는건 겹치는 id 가 없다는 것이므로 해당 id를 등록에 사용할 수 있다.
        // 조건에 부합할 경우 true 를 반환한다.
        return user_name == null;
    }

    public void addMemberInfo(MemberInfoBean joinMemberBean) {
        memberDAO.addMemberInfo(joinMemberBean);
    }

    public void getLoginMemberInfo(MemberInfoBean tempLoginMemberBean) {
        MemberInfoBean tempLoginMemberBean2 = memberDAO.getLoginMemberInfo(tempLoginMemberBean);

        if (tempLoginMemberBean2 != null) {
            loginMemberBean.setUser_idx(tempLoginMemberBean2.getUser_idx());
            loginMemberBean.setUser_name(tempLoginMemberBean2.getUser_name());
            loginMemberBean.setMemberLogin(true);
        }
    }

    public void getModifyMemberInfo(MemberInfoBean modifyMemberBean) {
        MemberInfoBean tempModifyMemberBean = memberDAO.getModifyMemberInfo(loginMemberBean.getUser_idx());

        modifyMemberBean.setUser_id(tempModifyMemberBean.getUser_id());
        modifyMemberBean.setUser_name(tempModifyMemberBean.getUser_name());
        modifyMemberBean.setUser_idx(loginMemberBean.getUser_idx()); // idx 가지고 회원정보 찾는거니 이곳에 sql 로 가져온 idx 를 담는다.
    }

}
