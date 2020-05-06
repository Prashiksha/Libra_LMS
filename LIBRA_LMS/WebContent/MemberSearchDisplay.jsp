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
                    <form action="MemberFile.jsp">
                     	<button class="logout_button"type="submit">
                     		Home
                     	</button>
                    </form>
                    
                    
                    <form action="IssueBookServlet" method="post">
                     	<button class="logout_button"type="submit">
                     		Issue Book
                     	</button>
                    </form>
                    
                    <form action="ViewIssuedBooksServlet" method="get">
                     	<button class="logout_button"type="submit">
                     		View Issued Books
                     	</button>
                    </form>
                    
                    <form action="ReturnBookServlet" method="post">
                     	<button class="logout_button"type="submit">
                     		Return Book
                     	</button>
                    </form>
                    
                    
                    
                    
                </ul>
            </nav>
            <div class="clearfix"></div>
        </header>

        <div class="home" id="home">
            <h1>Books You Searched for...</h1>
           <!-- <h2>Your Member ID is ${id}</h2> --> 
            <h3></h3>
        </div>


        
    </body>

    <script src="js/MemberPage.js"></script>
</html>