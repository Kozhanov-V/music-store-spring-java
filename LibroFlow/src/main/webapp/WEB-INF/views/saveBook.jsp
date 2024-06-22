<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/layout.jsp" %>
<jsp:include page="../includes/header.jsp"/>

<div class="container mt-3">
  <h2>Сохранение книги</h2>

  <div class="container mt-3">
    <c:if test="${not empty errorMessage}">
      <div class="alert alert-danger" role="alert">
        <c:out value="${errorMessage}"/>
      </div>
    </c:if>

  </div>

  <form action="/books/save" method="POST">
    <input type="hidden" value="${book.bookId}" id="bookId" name="bookId">
    <div class="form-group">
      <label for="title">Название</label>
      <input type="text" class="form-control" id="title" name="title" required value="${book.title}">
    </div>
    <div class="form-group">
      <label for="author">Автор</label>
      <input type="text"
             class="form-control"
             id="author"
             name="author"
             required
             value="${book.author}">
    </div>
    <div class="form-group">
      <label for="isbn">ISBN</label>
      <input type="text" class="form-control" id="isbn" name="isbn" required
             pattern="\b(97[89])?\d{9}[\dX]\b"
             title="Введите действительный ISBN. Должен содержать 10 или 13 цифр, где последняя цифра может быть X. Для ISBN-13 начало должно быть 978 или 979."
             value="${book.isbn}">
      <small class="form-text text-muted">Введите действительный ISBN (13 цифр или 10 цифр, где последний символ может быть 'X').</small>
    </div>



    <button type="submit" class="btn btn-primary">Сохранить</button>
  </form>
</div>

<jsp:include page="../includes/footer.jsp"/>

