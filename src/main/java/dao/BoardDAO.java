package dao;

import beans.ContentsInfoBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void addContentInfo(ContentsInfoBean writeContentBean) {
        sqlSessionTemplate.insert("board.addContentInfo", writeContentBean);
    }

}
