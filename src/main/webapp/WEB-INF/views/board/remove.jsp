<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    alert("삭제 완료.")
    location.href="/board/main?board_info_idx=${board_info_idx}";
</script>