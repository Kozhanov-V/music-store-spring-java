<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/layout.jsp" %>
<jsp:include page="../includes/header.jsp"/>
<div class="container mt-3">



    <div class="d-flex justify-content-between mb-2">
        <h2>Список книг</h2>




        <a class="btn btn-primary" href="/books/add">Добавить книгу</a>
    </div>
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
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th>id</th>
            <th>Название</th>
            <th>Автор</th>
            <th>ISBN</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${bookList}">
            <tr class="h-auto">
                <td>${book.bookId}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.isbn}</td>
                <td>
                    <a class="btn btn-info btn-sm" href="/books/edit/${book.bookId}">Редактировать</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="row">
        <div class="col-12 d-flex justify-content-center">
            <ul class="pagination">
                <c:if test="${currentPage != 0}">
                    <li class="page-item">
                        <a class="page-link" href="/books?page=${currentPage - 1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="${currentPage - 2 < 0 ? 0 : currentPage - 2}" end="${currentPage + 2 >= totalPages ? totalPages - 1 : currentPage + 2}" var="i">
                    <li class="page-item ${currentPage == i ? 'active' : ''}">
                        <a class="page-link" href="/books?page=${i}">${i + 1}</a>
                    </li>
                </c:forEach>
                <c:if test="${currentPage + 1 < totalPages}">
                    <li class="page-item">
                        <a class="page-link" href="/books?page=${currentPage + 1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
</div>
<jsp:include page="../includes/footer.jsp"/>
