package dao;

import beans.MemberInfoBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // sqlSessionTemplate 의 statement :
    // mapper 의 namespace 에 적힌 이름.sql 문 ID
    // ex : member.checkMemberIdExist - member 라는 이름을 갖는 mapper 내에서 id 가 checkMemberIdExist 인 sql 문을 지정.

    public String checkMemberIdExist(String user_id) {
        return sqlSessionTemplate.selectOne("member.checkMemberIdExist", user_id);
    }

    public void addMemberInfo(MemberInfoBean joinMemberBean) {
        sqlSessionTemplate.insert("member.addMemberInfo", joinMemberBean);
    }

    public MemberInfoBean getLoginMemberInfo(MemberInfoBean tempLoginMemberBean) {
        return sqlSessionTemplate.selectOne("member.getLoginMemberInfo", tempLoginMemberBean);
    }

    public MemberInfoBean getModifyMemberInfo(int user_idx) {
        return sqlSessionTemplate.selectOne("member.getModifyMemberInfo", user_idx);
    }
}
