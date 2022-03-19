package dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public String checkMemberIdExist(String user_id) {
        return sqlSessionTemplate.selectOne("member.checkMemberIdExist",user_id);
    }

}
