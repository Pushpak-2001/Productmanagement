<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="com.product.model.Manufacturer" %>
<%@page import="com.product.model.Dealer" %>

<%
Dealer dlr = null;
Manufacturer mnf = null;
if (session.getAttribute("loginuser") != null) 
{
	String clazz = session.getAttribute("loginuser").getClass().getSimpleName();
	if(clazz.equals("Dealer"))
	{
		dlr = (Dealer) session.getAttribute("loginuser");
	}
	else if(clazz.equals("Manufacturer"))
	{
		 mnf = (Manufacturer) session.getAttribute("loginuser");
	}

}
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	
<div class="container">
		<a class="navbar-brand" href="#">PRODUCT MANAGEMENT</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
			    <%if(dlr!=null){%>
				<li class="nav-item active"><a class="nav-link" href="dealerhome">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<% }%>
				<%if(mnf!=null){%>
				<li class="nav-item active"><a class="nav-link" href="manufacturerhome">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<% }%>
				
				<%if(mnf!=null){%>
				<li class="nav-item active"><a class="nav-link" href="addProductView">Add Product
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="uploadPage">Upload
						<span class="sr-only">(current)</span>
				</a></li>
				
				<% }%>
				
			</ul>
			
			<ul class="navbar-nav ml-auto">
			<%
			if(dlr == null && mnf==null)
			{ %>
				<li class="nav-item active"><a class="nav-link" href="loginPage">Login
						<span class="sr-only">(current)</span>
				</a></li>
				
			<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/">Register
						<span class="sr-only">(current)</span>
				</a></li>
			<% }
			else
			{ %>
			    
			    <li class="nav-item active"><a class="nav-link" href="#!">
			    <%if(dlr!=null)
			    {
			    	out.print(dlr.getUname());
			    }
			    
			    %>
			     <%if(mnf!=null)
			    {
			    	out.print(mnf.getUname());
			    }
			    
			    %>
						<span class="sr-only">(current)</span>
				</a></li>
			   
			   <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/">Logout
						<span class="sr-only">(current)</span>
				</a></li>
	
				
			<% }
			
			%>	
			
			</ul>
			
		</div>

</div>
	
</nav>