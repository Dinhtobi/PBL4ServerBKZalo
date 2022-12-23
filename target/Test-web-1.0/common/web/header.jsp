<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
  <%@ include file = "/common/taglib.jsp" %>
 <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        
                        
                    </ul>
                    <form class="d-flex">
                    <c:if test = "${not empty Admin}">
                      <li class="nav-item"><a class="nav-link" href="#">Welcome, ${Admin.username}</a></li>
                     <li class="nav-item"><a class="nav-link" href='<c:url value = "#"/>'>Thoát</a></li>
                       </c:if> 
                      <c:if test ="${ empty Admin }">
                      <li class="nav-item"><a class="nav-link" href='<c:url value = "dang-nhap?action=login"/>'>Đăng nhập</a></li>
                       </c:if>   
                    </form>
              
                </div>
               
            </div>
        </nav>