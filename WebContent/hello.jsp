<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
   <div id="app">
   		<p>{{message}}</p>
   </div>
   <script type="text/javascript" src="${ctx}/vue/2.4.2/vue.min.js"></script>
<script>
new Vue({
	  el: '#app',
	  data: {
	    message: 'Hello1 Vue.js!'
	  }
	})
</script>
</body>
</html>