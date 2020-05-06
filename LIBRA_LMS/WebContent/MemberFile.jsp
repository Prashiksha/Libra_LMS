<%
            
            response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate");//HTTP 1.1
            response.setHeader("Pragma" , "no-cache"); // HTTP 1.0
            response.setHeader("Expires", "0"); //Proxies
      
            if(session.getAttribute("username_member")==null)
            {
            	response.sendRedirect("FrontFile.jsp"); 
            }
           
      %>

<html>
    <head>
        <title>Welcome Member</title>
        <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="css/MemberPage.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body background="images/AdminPageBg.jpg">
        <header>
            <a href="#" class="logo" onclick="displayHome()">Libra</a>
            <div class="menu-toggle" id="menu-toggle" onclick="toggle()"></div>
            <nav class="nav" id="nav">
                <ul>
                    <li><a href="#" class="nav-active" id="nav-home" onclick="displayHome()">Home</a></li>
                    <li><a href="#" id="nav-issueBook" onclick="displayIssueBook()">Search/Issue Book</a></li>
                    <li><a href="MemberSearchDisplay.jsp" id="nav-returnBook" onclick="displayReturnBook()">Return Book</a></li>
                    <!-- <li><a href="#" id="nav-dues" onclick="displayDues()">Dues</a></li> -->
                    <li><a href="#" id="nav-profile" onclick="displayProfile()">Update Profile</a></li>
                   
                    <li><a href="" id="nav-wishlist" onclick="" title=""><i class="" aria-hidden="true"></i></a></li>
                    
                    <form action="MemberLogoutServlet" method="get">
                    <br>
                     	<button class="logout_button_member"type="submit">
                     		<i class="fa fa-sign-out" aria-hidden="true"></i>
                     		Logout
                     	</button>
                    		
                    </form>
                    
                </ul>
            </nav>
            <div class="clearfix"></div>
        </header>

        <div class="home" id="home">
            <div class="welcomemember">
                <h1>Welcome  ${username_member }</h1>
                <h2>Your Member ID is ${id}</h2>
            <h3>What would you like to do?</h3>
            </div>


			<!-- 
            <div class="top5Table">
                <label><u>Top 5 Trending Books</u></label>
                <table>
                    <tr>
                      <th>Ranking</th>
                      <th>Title</th>
                      <th>Author Name</th>
                      <th>Genre</th>
                    </tr>
                    <tr>
                      <td>#1</td>
                      <td>b</td>
                      <td>c</td>
                      <td>d</td>
                      <td><a href="#" onclick="issueBook()">Issue</a></td>
                      <td class="top5-wishlist"><i onclick="wishlistBook()" id="top5-wishlist" class="fa fa-heart-o" aria-hidden="true"></i></td>
                    </tr>
                    <tr>
                      <td>#2</td>
                      <td>b</td>
                      <td>c</td>
                      <td>d</td>
                      <td><a href="#" onclick="issueBook()">Issue</a></td>
                      <td class="top5-wishlist"><i onclick="wishlistBook(2)" id="top5-wishlist" class="fa fa-heart-o" aria-hidden="true"></i></td>
                    </tr>
                    <tr>
                        <td>#3</td>
                        <td>b</td>
                        <td>c</td>
                        <td>d</td>
                        <td><a href="#" onclick="issueBook()">Issue</a></td>
                        <td class="top5-wishlist"><i onclick="wishlistBook(2)" id="top5-wishlist" class="fa fa-heart-o" aria-hidden="true"></i></td>
                      </tr>
                      <tr>
                        <td>#4</td>
                        <td>b</td>
                        <td>c</td>
                        <td>d</td>
                        <td><a href="#" onclick="issueBook()">Issue</a></td>
                        <td class="top5-wishlist"><i onclick="wishlistBook(2)" id="top5-wishlist" class="fa fa-heart-o" aria-hidden="true"></i></td>
                      </tr>
                      <tr>
                        <td>#5</td>
                        <td>b</td>
                        <td>c</td>
                        <td>d</td>
                        <td><a href="#" onclick="issueBook()">Issue</a></td>
                        <td class="top5-wishlist"><i onclick="wishlistBook(2)" id="top5-wishlist" class="fa fa-heart-o" aria-hidden="true"></i></td>
                      </tr>
                </table>
            </div>
            -->
        </div>

        <div class="issueBook" id="issueBook">
            <div class="issueBook-searchBar">
            
                <form action="SearchBookMemberServlet" onsubmit="return validationSearchIssueBook()" id="formSearchBook" method="post">
            
            
                <label for="search">Search Books By :</label>
                <select id="issueBook-searchBook" name="issueBook-searchBook">
                    <option selected="selected" disabled="disabled" id="selected">Choose option..</option>
                    <option value="title">Title</option>
                    <option value="isbn">ISBN No</option>
                    <option value="author">Author</option>
                    <option value="genre">Genre</option>
                </select> 

                    <input type="text" placeholder="ISBN / Title / Author / Genre" id="" name="search_input_member">
                    <button class="button" type="submit">Search Book</button>
                    
                </form>
                
            </div>


			<!-- 
            <div class="issueBookTable">
                <table>
                    <tr>
                      <th>ISBN No</th>
                      <th>Title</th>
                      <th>Author Name</th>
                      <th>Genre</th>
                      <th>Available</th>
                    </tr>
                    <tr>
                      <td>a</td>
                      <td>b</td>
                      <td>c</td>
                      <td>d</td>
                      <td>e</td>
                      <td><a href="#" onclick="issueBook()">Issue</a></td>
                      <td class="issue-wishlist"><i onclick="wishlistBook(1)" id="issue-wishlist" class="fa fa-heart-o" aria-hidden="true"></i></td>
                    </tr>
                    <tr>
                      <td>a</td>
                      <td>b</td>
                      <td>c</td>
                      <td>d</td>
                      <td>e</td>
                      <td><a href="#" onclick="issueBook()">Issue</a></td>
                      <td class="issue-wishlist"><i onclick="wishlistBook(2)" id="issue-wishlist" class="fa fa-heart-o" aria-hidden="true"></i></td>
                    </tr>
                </table>
            </div>
            -->

        </div>

        <div class="returnBook" id="returnBook">
            <div class="returnBookTable">
            <!--  
                <table>
                    <tr>
                      <th>ISBN No</th>
                      <th>Title</th>
                      <th>Author Name</th>
                      <th>Genre</th>
                      <th>Issue Date</th>
                      <th>Return Date</th>
                      <th>Dues</th>
                    </tr>
                    <tr>
                      <td>a</td>
                      <td>b</td>
                      <td>c</td>
                      <td>d</td>
                      <td>e</td>
                      <td>f</td>
                      <td>g</td>
                      <td><a href="#" onclick="returnBook()">Return</a></td>
                    </tr>
                    <tr>
                        <td>a</td>
                        <td>b</td>
                        <td>c</td>
                        <td>d</td>
                        <td>e</td>
                        <td>f</td>
                        <td>g</td>
                        <td><a href="#" onclick="returnBook()">Return</a></td>
                      </tr>
                </table>
                -->
            </div>
        </div>

        <div class="profile" id="profile">
          <div class="content-profile">
          
            <form onsubmit="return validationProfile()" action="MemberProfileServlet" id="formProfile" method="post">
            
            <label class="info">UserID:</label>
              <input type="text" placeholder="UserID" class="username" id="username-profile" name="userid-profile" >
              <label class="label" id="lbluser-profile">UserID cannot be blank</label>
            <br>
              <label class="info">${username_member }</label>
              <input type="text" placeholder="Username" class="username" id="username-profile" name="username-profile" >
              <label class="label" id="lbluser-profile">Username cannot be blank</label>
              <br><label class="info">Password:</label>
              
              <a href="#" class="changepass" onclick="displayChangePass()">Change Password</a>
              <input type="password" placeholder="Password" class="password" id="password-profile" name="password-profile" >
              <label class="label" id="lblpassword-profile">Password cannot be blank</label>
              <br><label class="info">Mobile No:</label>
              <input placeholder="Mobile No" type="tel" id="mobile-profile" name="mobile-profile">
              <label class="label" id="lblmobile-profile">Mobile No cannot be blank</label>
              <br><label class="info">Email:</label>
              <input placeholder="Email" type="text" id="email-profile" name="email-profile">
              <label class="label" id="lblemail-profile" >Email cannot be blank</label>
              <br>
              <button class="button" type="submit">Save Changes</button>
          </form>
          </div>
        </div>

        <div class="popup" id="popup-changepass">
          <div class="popup-content" id="popup-content-changepass">
              <img src="images/close1.png" alt="close" id="" class="close" onclick="closeChangePass()">
              <br>
              
              <form onsubmit="return validationChangePass()" action="MemberChangePassServlet" id="formChangePass" method="post">
                	<label class="info">Member ID</label>
                  <input type="text" placeholder="Member ID" class="password" id="memberid-changepass" name="memberid-changepass">               
                  <label id="lblmemberid-changepass">Member ID cannot be blank</label>
                  <br>
                  <label class="info">Old Password:</label>
                  <input type="password" placeholder="Old Password" class="password" id="oldpassword-changepass" name="oldpassword-changepass">               
                  <label id="lbloldpass-changepass">Old Password cannot be blank</label>
                  <br>
                  <label class="info">New Password:</label>
                  <input type="password" placeholder="New Password" class="password" id="newpassword-changepass" name="newpassword-changepass">               
                  <label id="lblnewpass-changepass">New Password cannot be blank</label>
                  
                  <label class="info">Confirm Password:</label>
                  <input type="password" placeholder="Confirm Password" class="password" id="conpassword-changepass" name="conpassword-changepass">               
                  <label id="lblconpass-changepass">Confirm Password cannot be blank</label>
                  <br>
                  
                  <button class="button" type="submit">Change Password</button>
              </form>
          </div>
      </div>

        <div class="wishlist" id="wishlist">
          <div class="wishlistTable">
            <label><u>Your Wishlist</u></label>
            <table>
                <tr>
                  <th>S No</th>
                  <th>Title</th>
                  <th>Author Name</th>
                  <th>Genre</th>
                </tr>
                <tr>
                  <td>1</td>
                  <td>b</td>
                  <td>c</td>
                  <td>d</td>
                  <td><a href="#" onclick="issueBook()">Issue</a></td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>b</td>
                  <td>c</td>
                  <td>d</td>
                  <td><a href="#" onclick="issueBook()">Issue</a></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>b</td>
                    <td>c</td>
                    <td>d</td>
                    <td><a href="#" onclick="issueBook()">Issue</a></td>
                  </tr>
                  <tr>
                    <td>4</td>
                    <td>b</td>
                    <td>c</td>
                    <td>d</td>
                    <td><a href="#" onclick="issueBook()">Issue</a></td>
                  </tr>
                  <tr>
                    <td>5</td>
                    <td>b</td>
                    <td>c</td>
                    <td>d</td>
                    <td><a href="#" onclick="issueBook()">Issue</a></td>
                  </tr>
            </table>
        </div>
        </div>
    </body>
    <script src="js/MemberPage.js"></script>
</html>