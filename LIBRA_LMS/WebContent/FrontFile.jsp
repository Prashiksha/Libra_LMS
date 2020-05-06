<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <title>Welcome to LIBRA</title>
        <link href="css/FrontPage.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <body background="images/librarybg (2).jpg">
        <!--
        <header id="home">
            <nav>
                <a href="#home"><img id="logo" src="images/logo.svg" alt="LOGO"></a>
                <div class="menu">
                    <ul>
                        <li>
                            <a href="#home">Home</a>
                            <a href="#about">About</a>
                            <a href="#contactus">Contact Us</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        -->
        <div class="container">
            <img src="images/logo.svg" alt="logo" id="logo">
            <h1>WELCOME TO LIBRA</h1>
            <button class="button" id="button" onclick="popupAdmin()">Admin Login</button>
            <button class="button" id="button" onclick="popupMember()">Member Login</button>
        </div>

        <div class="quote">
    
            <label id="quote">You can't cross the sea merely by standing and staring at the water</label>
            <br><br>
            <label id="writer">- Rabindranath Tagore</label>
        
        </div>

        <div class="popup" id="popup-admin">
            <div class="popup-content" id="popup-content-admin">
                <img src="images/close1.png" alt="closeMe" id="close-admin" class="close">
                <img src="images/avatar.svg" alt="user_picture" class="user_picture">
                
                <form onsubmit="return validationAdmin()" action="AdminLoginServlet" id="formAdminLogin" method="post">
                    <input type="text" placeholder="Username" class="username" id="username-admin" name="username-admin">
                    <label id="lbluserAdmin">Username cannot be blank</label>
                    <input type="password" placeholder="Password" class="password" id="password-admin" name="password-admin">               
                    <label id="lblpassAdmin">Password cannot be blank</label>
                    <br>
                    <button class="button" type="submit">Login</button>
                </form>
                
            </div>
        </div>

        <div class="popup" id="popup-member">
            <div class="popup-content" id="popup-content-member">
                <img src="images/close1.png" alt="close" id="close-member" class="close">
                <img src="images/avatar.svg" alt="user_picture" class="user_picture">
                
                <form onsubmit="return validationMember()" action="MemberLoginServlet" id="formMemberLogin" method="post">
                    <input type="text" placeholder="Username" class="username" id="username-member" name="username-member">
                    <label id="lbluserMember">Username cannot be blank</label>
                    <input type="password" placeholder="Password" class="password" id="password-member" name="password-member">
                    <label id="lblpassMember">Password cannot be blank</label>
                    <br>
                    <button class="button" type="submit">Login</button>
                    
                    <a href="#" class="button" onclick="popupRegister()" id="btnRegister">Register</a>
                </form>
                
            </div>
        </div>

        <div class="popup" id="popup-register">
            <div class="popup-content" id="popup-content-register">
                <img src="images/close1.png" alt="close" id="close-register" class="close">
                <!-- <img src="images/avatar.svg" alt="user_picture" class="user_picture"> -->
                
                <form onsubmit="return validationRegister()" action="MemberRegisterServlet" id="formMemberRegister" method="post">
                    <br>
                    <input type="text" placeholder="Username" class="username" id="username-register" name="username-register">
                    <label id="lbluserRegister">Username cannot be blank</label>
                    <input type="password" placeholder="Password" class="password" id="password-register" name="password-register">
                    <label id="lblpassRegister">Password cannot be blank</label>
                    <input placeholder="Confirm Password" type="password" id="conpassword-register" name="conpassword-register">
                    <label id="lblconpassRegister">Confirm Password cannot be blank</label>
                    <input placeholder="Mobile Number" type="text" id="mobileno-register" name="mobileno-register">
                    <label id="lblmobileRegister" >Mobile Number cannot be blank</label>
                    <input placeholder="Email Address" type="text" id="email-register" name="email-register">                   
                    <label id="lblemailRegister" >Email Address cannot be blank</label>
                    <br>
                    <button class="button" type="submit">Register</button>
                </form>
                
            </div>
        </div>
    </body>

    <script type="text/javascript">
        document.querySelector("#close-admin").addEventListener("click",function(){
            document.querySelector("#popup-admin").style.display="none";
        });

        document.querySelector("#close-member").addEventListener("click",function(){
            document.querySelector("#popup-member").style.display="none";
        });

        document.querySelector("#close-register").addEventListener("click",function(){
            document.querySelector("#popup-register").style.display="none";
        });
    </script>
    <script src="./js/FrontPage.js"></script>
    
    </html>