<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>View Task Item List</title>

    <link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>

</head>
<body>

	<div class="container">

	    

	    <form:form action="/editSaveTaskItem" method="post" modelAttribute="task">
			
		<h1 class="p-3" path="title" id="title"></h1>
		<br><br>
				
				  
			
	        <div class="row">
	        	<div class="form-group col-md-12">
	        		
						<h1>Title : ${task.title} </h1>
	        		
	        	</div>
	        </div>
			
			<hr class="mt-1 mb-10 w-10 border-3 border-dark"/>
			
			<div class="row">
		        	<div class="form-group col-md-12">
			      		<p>Status : ${task.status} </p>
				  	</div>
	      	</div>
				        
						
				<div class="row">
							<div class="form-group col-md-12">
								<p>Priority : ${task.priority} </p>
							</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
													<p>Date : ${task.date} </p>
												</div>
		   		</div>
									
						
						
			
			
			
			<div class="row">
				
				  <div class="form-group col-md-6">
				        		
					<h6>Description : </h6>
					<div class="row">
						<div class="form-group col-md-12">
						
				  			<form:textarea type="text" path="description" id="description" class="form-control input-sm " rows="6"  />
											
						</div>
					</div>
				        		
	        	</div>
				
				
					        	
	      </div>

	       
	        
	        
			
			
			
			

	        <div class="row p-2">
	        	<div class="col-md-2">
					<button type="button" class="btn btn-primary">
									      		    <a href="/viewTaskList">Back</a>
								           		</button>
	        	</div>
	        </div>

	    </form:form>

	</div>

	<script th:inline="javascript">
		
		
				
				
	            window.onload = function() {

	                var msg = "${message}";
	                console.log(msg);
	                if (msg == "Task view Failure") {
	    				Command: toastr["error"]("Something went wrong with the task you are fetching.")
	    			}

	    			toastr.options = {
	                      "closeButton": true,
	                      "debug": false,
	                      "newestOnTop": false,
	                      "progressBar": true,
	                      "positionClass": "toast-top-right",
	                      "preventDuplicates": false,
	                      "showDuration": "300",
	                      "hideDuration": "1000",
	                      "timeOut": "5000",
	                      "extendedTimeOut": "1000",
	                      "showEasing": "swing",
	                      "hideEasing": "linear",
	                      "showMethod": "fadeIn",
	                      "hideMethod": "fadeOut"
	                    }
	    	    }
	        </script>
</body>

</html>