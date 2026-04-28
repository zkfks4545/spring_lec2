<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/product.css">
    <script src="/resources/js/product.js"></script>
</head>
<body>

<h1>- product reg -</h1>
    <div>
        <div>name <input type="text" id="name" name="p_name"></div>
        <div>price <input type="text" id="price" name="p_price"></div>
        <div>
            <button id="add">add</button>
        </div>
    </div>

<h1>- product update -</h1>
<form action="/product/update" method="post">
    <div>
        <div>
            <select name="p_no">
                <c:forEach items="${products}" var="p">
                    <option value="${p.p_no}">no. ${p.p_no}</option>
                </c:forEach>
            </select>
        </div>
        <div><input type="text" placeholder="name" name="p_name"></div>
        <div><input type="text" placeholder="price" name="p_price"></div>
        <div>
            <button>update</button>
        </div>
    </div>
</form>
<hr>
<h1>- product delete -</h1>
    <input type="text" name="pk">
    <button id="delBtn">delete</button>
<hr>

<hr>
<h1>- product list -</h1>
<div class="item">
    <div>no.</div>
    <div>name</div>
    <div>price</div>
</div>
<%--첨부하길 원하는 템플릿--%>
<div class="item temp">
    <div class="no"></div>
    <div class="name"></div>
    <div class="price"></div>
    <div class="delete">
        <button>del</button>
    </div>
</div>

<div id="product-list">

    <button id="openModal">Open Modal</button>


    <dialog id="myModal">
        <h2>Product Modal</h2>
        <div>
            <div class="modal-no"></div>
            <div class="modal-name"></div>
            <div class="modal-price"></div>
        </div>
        <button id="closeModal">Close</button>
    </dialog>

</div>

</body>
</html>