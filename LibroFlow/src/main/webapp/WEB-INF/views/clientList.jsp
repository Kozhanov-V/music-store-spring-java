<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/layout.jsp" %>
<jsp:include page="../includes/header.jsp"/>
<div class="container mt-3 h-100">
    <div class="d-flex justify-content-between mb-2">
        <h2>Список клиентов</h2>



        <a class="btn btn-primary" href="/clients/add">Добавить клиента</a>
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
            <th>ФИО</th>
            <th>Дата рождения</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <!-- Пример строки таблицы. Данные должны быть заменены на динамические значения -->
        <c:forEach var="client" items="${clientList}">
        <tr >
            <td>${client.clientId}</td>
            <td>${client.fullName}</td>
            <td>${client.birthDate}</td>
            <td>
                <a class="btn btn-info btn-sm" href="/clients/edit/${client.clientId}">Редактировать</a>
            </td>
        </tr>
        </c:forEach>
        <!-- Конец примера строки таблицы -->
        </tbody>
    </table>
    <div class="row">
        <div class="col-12 d-flex justify-content-center">
            <ul class="pagination">
                <c:if test="${currentPage != 0}">
                    <li class="page-item">
                        <a class="page-link" href="/clients?page=${currentPage - 1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="${currentPage - 2 < 0 ? 0 : currentPage - 2}" end="${currentPage + 2 >= totalPages ? totalPages - 1 : currentPage + 2}" var="i">
                    <li class="page-item ${currentPage == i ? 'active' : ''}">
                        <a class="page-link" href="/clients?page=${i}">${i + 1}</a>
                    </li>
                </c:forEach>
                <c:if test="${currentPage + 1 < totalPages}">
                    <li class="page-item">
                        <a class="page-link" href="/clients?page=${currentPage + 1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>

</div>

<jsp:include page="../includes/footer.jsp"/>
