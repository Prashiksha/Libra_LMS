<html>
    <head>
        <title>Book Display</title>
        <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="css/AdminPage.css">
        <!-- <script src='https://kit.fontawesome.com/a076d05399.js'></script> -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <body background="images/librarybg.jpg">
        <header>
            <a href="#" class="logo" onclick="displayHome()">Libra</a>
            <div class="menu-toggle" id="menu-toggle" onclick="toggle()"></div>
            <nav class="nav" id="nav">
                <ul>
                    <li><a href="AdminFile.jsp" class="nav-active" id="nav-home" >Home</a></li>
                    <li><a href="#" onclick="displayUpdateBook()">Update</a></li>
     				<!-- <li><a href="#" onclick="displayDeleteBook()">Delete</a></li> -->
     				
     				
     				<form action="AdminDeleteBook" method="post">
                     	<button class="logout_button"type="submit">
	                     	<h4>
	                     		<i class="fa fa-trash" aria-hidden="true">Delete</i>   
	                     	</h4>
							               	
						</button>
                    </form>
                    
                    
                    
                    
                    
                </ul>
            </nav>
            <div class="clearfix"></div>
        </header>

        <div class="home" id="home">
            <h1>Books You Searched for...</h1>
            <h3></h3>
        </div>

<div class="popup" id="popup-update">
            <div class="popup-content" id="popup-content-update">
                <img src="images/close1.png" alt="close" id="" class="close" onclick="closeUpdate()">
                <br>
                
                <form onsubmit="return validationUpdateBook()" action="UpdateBookServlet" id="formUpdateBook" method="post">
                    <label class="info">ISBN Number:</label>
                    <input type="text" placeholder="ISBN No" class="isbn" id="isbn-updateBook" name="isbn-updateBook">
                    <label id="lblisbn-updateBook">ISBN No cannot be blank</label>
                    <br><label class="info">Title:</label>
                    <input type="text" placeholder="Title" class="title" id="title-updateBook" name="title-updateBook">
                    <label id="lbltitle-updateBook">Title cannot be blank</label>
                    <br><label class="info">Author Name:</label>
                    <input placeholder="Author Name" type="text" id="author-updateBook" name="author-updateBook">
                    <label id="lblauthor-updateBook">Author Name cannot be blank</label>
                    <br><label class="info">Cost:</label>
                    <input placeholder="Cost" type="number" id="cost-updateBook" name="cost-updateBook">
                    <label id="lblcost-updateBook" >Cost cannot be blank</label>
                    <br><label class="info">Quantity:</label>
                    <input placeholder="Quantity" type="number" id="quantity-updateBook" name="quantity-updateBook">                   
                    <label id="lblquantity-updateBook" >Quantity cannot be blank</label>
                    <br>
                    
                    <button class="button" type="submit">Update Book</button>
                    <!-- <a href="" class="button" onclick="">Delete Book</a> -->
                </form>
            </div>
        </div>
        
        
        <!-- 
        
        <div class="popup" id="popup-delete">
            <div class="popup-content" id="popup-content-delete">
                <img src="images/close1.png" alt="close" id="" class="close" onclick="closeDelete()">
                <br>
                
                <form onsubmit="return validationDeleteBook()" action="" id="formDeleteBook" method="post">
                    <label class="info">ISBN Number:</label>
                    <input type="text" placeholder="ISBN No" class="isbn" id="isbn-deleteBook" name="isbn-deleteBook">
                    <label id="lblisbn-deleteBook">ISBN No cannot be blank</label>
                    <br><label class="info">Title:</label>
                    <input type="text" placeholder="Title" class="title" id="title-deleteBook" name="title-deleteBook">
                    <label id="lbltitle-deleteBook">Title cannot be blank</label>
                    <br><label class="info">Author Name:</label>
                    <input placeholder="Author Name" type="text" id="author-deleteBook" name="author-deleteBook">
                    <label id="lblauthor-deleteBook">Author Name cannot be blank</label>
                    <br><label class="info">Cost:</label>
                    
                    <br>
                    
                    <button class="button" type="submit">Delete Book</button>
                    
                </form>
            </div>
        </div>
        -->
        
        
        
    </body>

    <script src="js/AdminPage.js"></script>
</html>