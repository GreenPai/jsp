<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/jboard/js/daumPostcode.js"></script>
    
<%@ include file="./_header.jsp" %> <!-- 상대경로o 절대경로x -->
        <main id="user">
            <section class="register">
                <form action="/jboard/user/register.do" method="post">
                    <h2 class="tit">사이트 이용정보 입력</h2>
                    <table border="1">                        
                        <tr>
                            <td>아이디</td>
                            <td>
                                <input type="text" name="uid" placeholder="아이디 입력"/>
                                <button type="button"><img src="../images/chk_id.gif" alt="중복확인"/></button>
                                <span class="uidResult"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type="password" name="pass1" placeholder="비밀번호 입력"/></td>
                        </tr>
                        <tr>
                            <td>비밀번호 확인</td>
                            <td><input type="password" name="pass2" placeholder="비밀번호 입력 확인"/></td>
                        </tr>
                    </table>

                    <h2 class="tit">개인정보 입력</h2>
                    <table border="1">                        
                        <tr>
                            <td>이름</td>
                            <td>
                                <input type="text" name="name" placeholder="이름 입력"/>                        
                            </td>
                        </tr>
                        <tr>
                            <td>별명</td>
                            <td>
                                <p class="nickInfo">공백없는 한글, 영문, 숫자 입력</p>
                                <input type="text" name="nick" placeholder="별명 입력"/>
                                <button type="button"><img src="../images/chk_id.gif" alt="중복확인"/></button>
                                <span class="nickResult"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td>
                                <input type="email" name="email" placeholder="이메일 입력"/>
                                <button type="button"><img src="../images/chk_auth.gif" alt="인증번호 받기"/></button>
                                <div class="auth">
                                    <input type="text" name="auth" placeholder="인증번호 입력"/>
                                    <button type="button"><img src="../images/chk_confirm.gif" alt="확인"/></button>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>휴대폰</td>
                            <td><input type="text" name="hp" placeholder="휴대폰 입력"/></td>
                        </tr>
                        <tr>
                            <td>주소</td>
                            <td>
        
                                <input type="text" name="zip" id="zip" readonly="readonly" placeholder="우편번호"/>
                                <button type="button" onclick="daumPostcode()"><img src="../images/chk_post.gif" alt="우편번호찾기"/></button>
                                <input type="text" name="addr1" id="addr1" readonly="readonly"  placeholder="주소 검색"/>
                                <input type="text" name="addr2" id="addr2" placeholder="상세주소 입력"/>
                    
                            </td>
                        </tr>
                    </table>

                    <div>
                        <a href="/jboard/user/login.do" class="btn btnCancel">취소</a>
                        <input type="submit" value="회원가입" class="btn btnRegister"/>
                    </div>

                </form>

            </section>
        </main>
<%@ include file="./_footer.jsp" %>