<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
	<tr> 
		<th>id</th>
		<th>名称</th>
		<th>详情</th>
	</tr>
	<c:forEach items="${pageInfo.list }" var="spec">
		<tr>
			<td>${spec.id }</td>
			<td>${spec.specName }</td>
			<td>
				<c:forEach items="${spec.specOptions }" var="option">
					${option.optionName}&nbsp;&nbsp;
					${option.orders }
				</c:forEach>
			</td>
		</tr>
	</c:forEach>
	
</table>