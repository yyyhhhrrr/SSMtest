<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>

</head>
<body>
<!--显示错误信息 -->
<c:if test="${allErrors!=null}">
	<c:forEach items="${allErrors}" var="error">
		 ${error.defaultMessage}
	</c:forEach>
</c:if>

<form id="itemForm" action="${ctx}/items/editItemsSubmit.action" method="post" enctype="multipart/form-data" >
<input type="hidden" name="id" value="${itemsCustom.id }"/>
修改商品信息：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td><input type="text" name="name" value="${itemsCustom.name }"/></td>
</tr>
<tr>
	<td>商品价格</td>
	<td><input type="text" name="price" value="${itemsCustom.price }"/></td>
</tr>
<tr>
	<td>商品生产日期</td>
	<td><input type="text" name="createtime" value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
</tr>
<tr>
	<td>商品图片</td>
	<td>
		<c:if test="${itemsCustom.pic !=null}">
			<img src="/picture/${itemsCustom.pic}" width=100 height=100/>
			<br/>
		</c:if>
		<input type="file"  name="items_pic"/>
	</td>
</tr>
<tr>
	<td>商品简介</td>
	<td>
	<textarea rows="3" cols="30" name="detail">${itemsCustom.detail }</textarea>
	</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>