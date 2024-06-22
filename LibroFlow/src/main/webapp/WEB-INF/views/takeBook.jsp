<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/layout.jsp" %>
<jsp:include page="../includes/header.jsp"/>
<%@ page import="java.time.LocalDate" %>
<div class="container mt-3">
    <h2>Взять книгу на прочтение</h2>

    <div class="container mt-3">
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger" role="alert">
                <c:out value="${errorMessage}"/>
            </div>
        </c:if>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success" role="alert">
                <c:out value="${successMessage}"/>
            </div>
        </c:if>

    </div>


    <form action="/borrowedBooks/save" method="POST">
        <div class="form-group">
            <label for="clientFullName">Клиент</label>
            <input type="text" class="form-control" id="clientFullName" name="clientFullName" placeholder="Введите ФИО клиента">
        </div>

        <div class="form-group">
            <label for="bookTitle">Книга</label>
            <input type="text" class="form-control" id="bookTitle" name="bookTitle" placeholder="Введите название книги">
        </div>

        <div class="form-group">
            <label for="borrowDate">Дата взятия на прочтение</label>
            <input type="date" class="form-control" id="borrowDate" name="borrowDate" required value="<%= java.time.LocalDate.now().toString() %>">
        </div>

        <button type="submit" class="btn btn-primary">Сохранить</button>

    </form>
</div>
<jsp:include page="../includes/footer.jsp"/>