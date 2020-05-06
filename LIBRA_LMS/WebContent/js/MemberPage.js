function toggle(){
    var menu=document.getElementById("menu-toggle");
    var nav=document.getElementById("nav");
    if(menu.className === "menu-toggle"){
        menu.className="menu-toggle-active";
        nav.className="nav-active";
    }
    else{
        menu.className="menu-toggle";
        nav.className="nav";
    }
}

function displayHome(){
    document.getElementById("issueBook").style.display="none";
    document.getElementById("returnBook").style.display="none";
    document.getElementById("profile").style.display="none";
    document.getElementById("wishlist").style.display="none";

    document.getElementById("nav-issueBook").className="#";
    document.getElementById("nav-returnBook").className="#";
    document.getElementById("nav-profile").className="#";
    // document.getElementById("nav-wishlist").className="#";
    document.getElementById("nav-wishlist").style.color="#262626";
    
    document.getElementById("home").style.display="block";
    document.getElementById("nav-home").className="nav-active";
}

function displayIssueBook(){
    document.getElementById("home").style.display="none";
    document.getElementById("returnBook").style.display="none";
    document.getElementById("profile").style.display="none";
    document.getElementById("wishlist").style.display="none";

    document.getElementById("nav-home").className="#";
    document.getElementById("nav-returnBook").className="#";
    document.getElementById("nav-profile").className="#";
    // document.getElementById("nav-wishlist").className="#";
    document.getElementById("nav-wishlist").style.color="#262626";
    
    document.getElementById("issueBook").style.display="block";
    document.getElementById("nav-issueBook").className="nav-active";
}

function displayReturnBook(){
    document.getElementById("home").style.display="none";
    document.getElementById("issueBook").style.display="none";
    document.getElementById("profile").style.display="none";
    document.getElementById("wishlist").style.display="none";

    document.getElementById("nav-home").className="#";
    document.getElementById("nav-issueBook").className="#";
    document.getElementById("nav-profile").className="#";
    // document.getElementById("nav-wishlist").className="#";
    document.getElementById("nav-wishlist").style.color="#262626";
    
    document.getElementById("returnBook").style.display="block";
    document.getElementById("nav-returnBook").className="nav-active";
}

function displayProfile(){
    document.getElementById("lblmobile-profile").style.visibility="hidden";
    document.getElementById("lblemail-profile").style.visibility="hidden";

    document.getElementById("home").style.display="none";
    document.getElementById("issueBook").style.display="none";
    document.getElementById("returnBook").style.display="none";
    document.getElementById("wishlist").style.display="none";

    document.getElementById("formProfile").reset();

    document.getElementById("nav-home").className="#";
    document.getElementById("nav-issueBook").className="#";
    document.getElementById("nav-returnBook").className="#";
    // document.getElementById("nav-wishlist").className="#";
    document.getElementById("nav-wishlist").style.color="#262626";
    
    document.getElementById("profile").style.display="block";
    document.getElementById("nav-profile").className="nav-active";
}

function displayWishlist(){
    document.getElementById("home").style.display="none";
    document.getElementById("issueBook").style.display="none";
    document.getElementById("returnBook").style.display="none";
    document.getElementById("profile").style.display="none";

    document.getElementById("nav-home").className="#";
    document.getElementById("nav-issueBook").className="#";
    document.getElementById("nav-returnBook").className="#";
    document.getElementById("nav-profile").className="#";
    
    document.getElementById("wishlist").style.display="block";
    document.getElementById("nav-wishlist").style.color="red";

}

function displayChangePass(){
    document.getElementById("lbloldpass-changepass").style.visibility="hidden";
    document.getElementById("lblnewpass-changepass").style.visibility="hidden";
    document.getElementById("lblconpass-changepass").style.visibility="hidden";

    document.getElementById("formChangePass").reset();

    document.getElementById("popup-changepass").style.display="flex";
}

function closeChangePass(){
    document.getElementById("popup-changepass").style.display="none";
}

function validationProfile(){
    document.getElementById("lblmobile-profile").style.visibility="hidden";
    document.getElementById("lblemail-profile").style.visibility="hidden";

    var regxmbl=/^[6-9]\d{9}$/;
	var regxemail=/^([a-zA-Z0-9\.-]+)@([a-zA-Z0-9-]+).([a-zA-Z]{2,8})(.[a-zA-Z]{2,8})$/;

    var mobileProfile=document.getElementById("mobile-profile").value;
    var emailProfile=document.getElementById("email-profile").value;

    if(mobileProfile.trim()==""){
        document.getElementById("lblmobile-profile").style.visibility="visible";
        return false;
    }

    else if(!regxmbl.test(mobileProfile)){
        document.getElementById("lblmobile-profile").innerHTML="Mobile Number Invalid";
        document.getElementById("lblmobile-profile").style.visibility="visible";
        return false;
    }

    if(emailProfile.trim()==""){
        document.getElementById("lblemail-profile").style.visibility="visible";
        return false;
    }

    else if(!regxemail.test(emailProfile)){
        document.getElementById("lblemail-profile").innerHTML="Email Address Invalid";
        document.getElementById("lblemail-profile").style.visibility="visible";
        return false;
    }
}

function validationChangePass(){
    document.getElementById("lbloldpass-changepass").style.visibility="hidden";
    document.getElementById("lblnewpass-changepass").style.visibility="hidden";
    document.getElementById("lblconpass-changepass").style.visibility="hidden";

    var oldpasswordChangePass=document.getElementById("oldpassword-changepass").value;
    var newpasswordChangePass=document.getElementById("newpassword-changepass").value;
    var conpasswordChangePass=document.getElementById("conpassword-changepass").value;

    if(oldpasswordChangePass.trim()==""){
        document.getElementById("lbloldpass-changepass").style.visibility="visible";
        return false;
    }

    if(newpasswordChangePass.trim()==""){
        document.getElementById("lblnewpass-changepass").style.visibility="visible";
        return false;
    }

    else if(oldpasswordChangePass.trim()==newpasswordChangePass.trim()){
        document.getElementById("lblnewpass-changepass").innerHTML="New Password cannot be same as Old Password";
        document.getElementById("lblnewpass-changepass").style.visibility="visible";
        return false;
    }

    else if(newpasswordChangePass.trim().length<=5 || newpasswordChangePass.trim().length>=20){
        document.getElementById("lblnewpass-changepass").innerHTML="Password should be between 5 to 20 characters";
        document.getElementById("lblnewpass-changepass").style.visibility="visible";
        return false;
    }

    if(conpasswordChangePass.trim()==""){
        document.getElementById("lblconpass-changepass").style.visibility="visible";
        return false;
    }

    else if(newpasswordChangePass.trim()!=conpasswordChangePass.trim()){
        document.getElementById("lblconpass-changepass").innerHTML="New Password and Confirm Password do not match";
        document.getElementById("lblconpass-changepass").style.visibility="visible";
        return false;
    }
}