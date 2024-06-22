<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/layout.jsp" %>
<jsp:include page="../includes/header.jsp"/>

<div class="container mt-3">
    <h2>Сохранение клиента</h2>

    <div class="container mt-3">
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger" role="alert">
                <c:out value="${errorMessage}"/>
            </div>
        </c:if>

    </div>

    <form action="/clients/save" method="POST">
        <input type="hidden" name="clientId" value="${client.clientId != null ? client.clientId : ''}">
        <div class="form-group">
            <label for="fullName">ФИО</label>
            <input type="text" class="form-control" id="fullName" name="fullName" required value="${client.fullName}">
        </div>
        <div class="form-group">
            <label for="birthDate">Дата рождения</label>
            <input type="date" class="form-control" id="birthDate" name="birthDate" required value="${client.birthDate}">
        </div>

        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>
</div>

<jsp:include page="../includes/footer.jsp"/>