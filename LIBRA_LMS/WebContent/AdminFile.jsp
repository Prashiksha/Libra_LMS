
<%
            
            response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate");//HTTP 1.1
            response.setHeader("Pragma" , "no-cache"); // HTTP 1.0
            response.setHeader("Expires", "0"); //Proxies
      
            if(session.getAttribute("username_admin")==null)
            {
            	response.sendRedirect("FrontFile.jsp"); 
            }
           
      %>

<html>
    <head>
        <title>Welcome Admin</title>
        <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="css/AdminPage.css">
        <!-- <script src='https://kit.fontawesome.com/a076d05399.js'></script> -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>




    <body background="images/AdminPageBg.jpg">
    
    
        <header>
            <a href="#" class="logo" onclick="displayHome()">Libra</a>
            <div class="menu-toggle" id="menu-toggle" onclick="toggle()"></div>
            <nav class="nav" id="nav">
                <ul>
                    <li><a href="#" class="nav-active" id="nav-home" onclick="displayHome()">Home</a></li>
                    <li><a href="#" id="nav-addBook" onclick="displayAddBook()">Add Book</a></li>
                    <li><a href="#" id="nav-searchBook" onclick="displaySearchBook()">Search/Update Book</a></li>
                    <li><a href="#" id="nav-viewOrder" onclick="displayViewOrder()">View Order Details</a></li>
                    <li><a href="#" id="nav-changePass" onclick="displayChangePass()">Change Password</a></li>
                    
                    <form action="AdminLogoutServlet" method="get">
                     	<button class="logout_button"type="submit">
                     		<h6><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</h6>
                     	</button>
                    		
                    </form>
                    
                    <li></li>
                </ul>
            </nav>
            <div class="clearfix"></div>
        </header>

        <div class="home" id="home">
            <h1>Welcome Admin ${username_admin }</h1>
            <h3>What would you like to do?</h3>
        </div>

        <div class="addBook" id="addBook">
        
            <form onsubmit="return validationAddBook()" action="InsertBookServlet" id="formAddBook" method="post">
                <input type="text" placeholder="ISBN No" class="isbn" id="isbn-addBook" name="ISBN">
                <label id="lblisbn-addBook">ISBN No cannot be blank</label>
                <input type="text" placeholder="Title" class="title" id="title-addBook" name="book_title">
                <label id="lbltitle-addBook">Title cannot be blank</label>
                <input placeholder="Author Name" type="text" id="author-addBook" name="author">
                <label id="lblauthor-addBook">Author Name cannot be blank</label>
                <select id="language-addBook" name="language">
                    <option selected="selected" disabled="disabled" id="selected">Select Language</option>
                    <option value="english">English</option>
                    <option value="hindi">Hindi</option>
                    <option value="marathi">Marathi</option>
                    <option value="gujarati">Gujarati</option>
                </select>
                <label id="lbllanguage-addBook"></label>
                <select id="addGenre-addBook" name="genre">
                    <option selected="selected" disabled="disabled" id="selected">Select a Genre</option>
                    <option value="fiction">Fiction</option>
                    <option value="non-fiction">Non Fiction</option>
                    <option value="romantic">Romantic</option>
                </select> 
                <label id="lblgenre-addBook"></label>
                <input placeholder="Cost" type="number" id="cost-addBook" name="cost">
                <label id="lblcost-addBook" >Cost cannot be blank</label>
                <input placeholder="Quantity" type="number" id="quantity-addBook" name="quantity_initial">                   
                <label id="lblquantity-addBook" >Quantity cannot be blank</label>
                <br>
                <button class="button" type="submit">Add Book</button>
            </form>
            
        </div>

        <div class="searchBook" id="searchBook">
            <div class="searchBar">
            
             <form onsubmit="return validationSearchBook()" action="SearchBookServlet" id="formSearchBook" method="post">
            
                <label for="search">Search Books By :</label>
                <select id="searchBook" name="searchBook">
                	<option selected="selected" disabled="disabled" id="selected">Select a field</option>
                    <option value="title">Title</option>
                    <option value="isbn">ISBN No</option>
                    <option value="author">Author</option>
                    <option value="genre">Genre</option>
                </select> 
                
                    <input type="text" placeholder="ISBN / Title / Author / Genre" id="search_input" name="search_input">
                    <button class="button" type="submit" onclick="popupSearch()">Search</button>
                    
             </form>
                
            </div>

        </div>

        <div class="popup" id="popup-update">
            <div class="popup-content" id="popup-content-update">
                <img src="images/close1.png" alt="close" id="" class="close" onclick="closeUpdate()">
                <br>
                <form onsubmit="return validationUpdateBook()" action="#" id="formUpdateBook">
                    <label class="info">ISBN Number:</label>
                    <input type="text" placeholder="ISBN No" class="isbn" id="isbn-updateBook">
                    <label id="lblisbn-updateBook">ISBN No cannot be blank</label>
                    <br><label class="info">Title:</label>
                    <input type="text" placeholder="Title" class="title" id="title-updateBook">
                    <label id="lbltitle-updateBook">Title cannot be blank</label>
                    <br><label class="info">Author Name:</label>
                    <input placeholder="Author Name" type="text" id="author-updateBook">
                    <label id="lblauthor-updateBook">Author Name cannot be blank</label>
                    <br><label class="info">Cost:</label>
                    <input placeholder="Cost" type="number" id="cost-updateBook">
                    <label id="lblcost-updateBook" >Cost cannot be blank</label>
                    <br><label class="info">Quantity:</label>
                    <input placeholder="Quantity" type="number" id="quantity-updateBook">                   
                    <label id="lblquantity-updateBook" >Quantity cannot be blank</label>
                    <br>
                    <button class="button" type="submit">Update Book</button>
                    <!-- <a href="" class="button" onclick="">Delete Book</a> -->
                </form>
            </div>
        </div>

        <div class="viewOrder" id="viewOrder">
            <div class="viewOrderBar">
                <label for="viewOrder">Enter Member Id :</label>

                <form action="ViewOrderServlet" onsubmit="return validationViewOrder()" id="formviewOrderSearch" method="get">
                    <input type="text" placeholder="Member ID" id="" name="member-id">
                    <button class="button" type="submit">View Order</button>
                </form>
                
            </div>

        </div>

        

        <div class="popup" id="popup-changepass">
            <div class="popup-content" id="popup-content-changepass">
                <img src="images/close1.png" alt="close" id="" class="close" onclick="closeChangePass()">
                <br>
                
                <form onsubmit="return validationChangePass()" action="AdminChangePassServlet" id="formChangePass" method="post">
                    <label class="info">Username:</label>
                    <input type="text" placeholder="Username" class="username" id="username-changepass" name="username-changepass">
                    <label id="lbluser-changepass">Username cannot be blank</label>
                    <br><label class="info">Old Password:</label>
                    <input type="password" placeholder="Old Password" class="password" id="oldpassword-changepass" name="oldpassword-changepass">               
                    <label id="lbloldpass-changepass">Password cannot be blank</label>
                    <br><label class="info">New Password:</label>
                    <input type="password" placeholder="New Password" class="password" id="newpassword-changepass" name="newpassword-changepass">               
                    <label id="lblnewpass-changepass">Password cannot be blank</label>
                    <br><label class="info">Confirm Password:</label>
                    <input type="password" placeholder="Confirm Password" class="password" id="conpassword-changepass" name="conpassword-changepass">               
                    <label id="lblconpass-changepass">Confirm Password cannot be blank</label>
                    <br>
                    <button class="button" type="submit">Change Password</button>
                </form>
                
            </div>
        </div> 
    </body>

    <script src="js/AdminPage.js"></script>
</html>