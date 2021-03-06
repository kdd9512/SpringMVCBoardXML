package beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MemberInfoBean {

    // 테이블 구조와 동일한 Bean 을 정의한다.
    private int user_idx;

    // 유효성 검사.
    @Size(min = 2, max = 4)
    @Pattern(regexp = "[가-힣]*")
    private String user_name;

    @Size(min = 4, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_id;

    @Size(min = 4, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw;

    @Size(min = 4, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw2;

    private boolean memberIdExist; // join.jsp 의 유효성 검사를 위한 value

    private boolean memberLogin;


    public MemberInfoBean() {
        // 기본값을 false 로 설정.(검사 실행여부에 따라 T/F)
        this.memberIdExist = false;
        this.memberLogin = false;
    }

    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(int user_idx) {
        this.user_idx = user_idx;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_pw2() {
        return user_pw2;
    }

    public void setUser_pw2(String user_pw2) {
        this.user_pw2 = user_pw2;
    }

    public boolean isMemberIdExist() {
        return memberIdExist;
    }

    public void setMemberIdExist(boolean memberIdExist) {
        this.memberIdExist = memberIdExist;
    }

    public boolean isMemberLogin() {
        return memberLogin;
    }

    public void setMemberLogin(boolean memberLogin) {
        this.memberLogin = memberLogin;
    }
}
