<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style>
    div.container { width: 800px; margin: 50px auto; }
    thead th { background-color: #eee; }
    table{ border-collapse: collapse; width: 100%; }
    td, th { padding: 4px; border: 1px solid lightgray; }
    td:nth-child(4) { text-align: center; }
    .btn { padding: 0.4em 1em; border: 1px solid gray;
       border-radius: 0.5em; background: linear-gradient(#fff, #ddd);
       text-decoration: none; color: black; display: inline-block; }
    a.btn { float: right; margin: -20px 0 5px 0; }
  </style>
</head>
<body>
<div class="container">

  <h1>강의목록</h1>

  <a href="create" class="btn">강의등록</a>
  <table class="table table-bordered table-condensed">
    <thead>
      <tr>
        <th>년도</th>
        <th>강의명</th>
        <th>구분</th>
        <th>분반</th>
        <th>학기</th>
        <th>시간</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="lecture" items="${ lectures }">
        <tr>
          <td>${ lecture.year }</td>
          <td><a href="edit?id=${ lecture.id }">${ lecture.courseName }</a></td>
          <td>${ lecture.gubun }</td>
          <td>${ lecture.bunban }</td>
          <td>${ lecture.semester }</td>
          <td>${ lecture.sigan }</td>

        </tr>
      </c:forEach>
    </tbody>
  </table>

</div>
</body>
</html>