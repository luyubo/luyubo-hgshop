<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container">
	<div class="row">
		<div class="col-md-3">
			<label>名称</label>
			<label>${sku.title }</label>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<label>价格</label>
			<label>${sku.price }</label>
		</div>
	</div>
	
	<div class="row">
		以下是规格
	</div>
	<c:forEach items="${sku.specs}" var="spec">
		<div class="row">
			<div class="col-md-3">
				<label>${spec.specName}</label>
				<label>${spec.optionName}</label>
			</div>
		</div>
	</c:forEach>
</div>