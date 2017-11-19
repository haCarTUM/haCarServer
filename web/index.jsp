<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: matth
  Date: 18.11.2017
  Time: 07:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>HaCarTUM</title>
</head>
<body>
<jsp:include page="/WEB-INF/pages/template.jsp">
    <jsp:param value="Basic Column Chart" name="pageTitle"/>
    <jsp:param value="<div id='chartContainer'/>" name="content"/>
</jsp:include>

<%    Gson gsonObj = new Gson();
    Map<Object, Object> map;
    List<Map<Object, Object>> list = new ArrayList<>();

    map = new HashMap<>();
    map.put("x", 10);
    map.put("y", 71);
    list.add(map);
    map = new HashMap<>();
    map.put("x", 20);
    map.put("y", 55);
    list.add(map);
    map = new HashMap<>();
    map.put("x", 30);
    map.put("y", 50);
    list.add(map);
    map = new HashMap<>();
    map.put("x", 40);
    map.put("y", 65);
    list.add(map);
    map = new HashMap<>();
    map.put("x", 50);
    map.put("y", 95);
    list.add(map);
    map = new HashMap<>();
    map.put("x", 60);
    map.put("y", 68);
    list.add(map);
    map = new HashMap<>();
    map.put("x", 70);
    map.put("y", 28);
    list.add(map);
    map = new HashMap<>();
    map.put("x", 80);
    map.put("y", 34);
    list.add(map);
    map = new HashMap<>();
    map.put("x", 90);
    map.put("y", 14);
    list.add(map);
    String dataPoints = gsonObj.toJson(list);
%>

<script type="text/javascript">
	$(function () {
		var chart = new CanvasJS.Chart("chartContainer", {
			theme: "theme2",
			animationEnabled: true,
			title: {
				text: "Simple Column Chart in JSP"
			},
			subtitles: [
				{ text: "Try Resizing the Browser" }
			],
			data: [{
				type: "column", //change type to bar, line, area, pie, etc
				dataPoints: <% out.print(dataPoints); %>
			}]
		});
		chart.render();
	});


</script>
</body>
</html>
