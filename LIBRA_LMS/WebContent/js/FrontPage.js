function popupAdmin(){
    document.getElementById("formAdminLogin").reset();

    document.getElementById("lbluserAdmin").style.visibility="hidden";
    document.getElementById("lblpassAdmin").style.visibility="hidden";
    document.getElementById("popup-admin").style.display="flex";
    //console.log("Chal raha hai 1");
}

function popupMember(){
    document.getElementById("formMemberLogin").reset();

    document.getElementById("lbluserMember").style.visibility="hidden";
    document.getElementById("lblpassMember").style.visibility="hidden";
    document.getElementById("popup-member").style.display="flex";
}

function popupRegister(){
    document.getElementById("formMemberRegister").reset();

    document.getElementById("popup-member").style.display="none";
    document.getElementById("popup-register").style.display="flex";
}

function validationAdmin(){

    var usernameAdmin=document.getElementById("username-admin").value;
    var passwordAdmin=document.getElementById("password-admin").value;

    document.getElementById("lbluserAdmin").style.visibility="hidden";
    document.getElementById("lblpassAdmin").style.visibility="hidden";
    
    if(usernameAdmin.trim()==""){
        document.getElementById("lbluserAdmin").style.visibility="visible";
        //alert("Invalid");
        return false;
    }
    
    else if(usernameAdmin.trim().length<=2 || usernameAdmin.trim().length>=20){
        document.getElementById("lbluserAdmin").innerHTML="Username should be between 2 to 20 characters";
        document.getElementById("lbluserAdmin").style.visibility="visible";
        return false;
    }
    
    if(passwordAdmin.trim()==""){
        document.getElementById("lblpassAdmin").style.visibility="visible";
        //alert("Invalid");
        return false;
    }
    
    else if(passwordAdmin.trim().length<=5 || passwordAdmin.trim().length>=20){
        document.getElementById("lblpassAdmin").innerHTML="Password should be between 5 to 20 characters";
        document.getElementById("lblpassAdmin").style.visibility="visible";
        return false;
    }
}

function validationMember(){

    var usernameMember=document.getElementById("username-member").value;
    var passwordMember=document.getElementById("password-member").value;

    document.getElementById("lbluserMember").style.visibility="hidden";
    document.getElementById("lblpassMember").style.visibility="hidden";
    
    if(usernameMember.trim()==""){
        document.getElementById("lbluserMember").style.visibility="visible";
        //alert("Invalid");
        return false;
    }
    
    else if(usernameMember.trim().length<=2 || usernameMember.trim().length>=20){
        document.getElementById("lbluserMember").innerHTML="Username should be between 2 to 20 characters";
        document.getElementById("lbluserMember").style.visibility="visible";
        return false;
    }
    
    if(passwordMember.trim()==""){
        document.getElementById("lblpassMember").style.visibility="visible";
        //alert("Invalid");
        return false;
    }
    
    else if(passwordMember.trim().length<=5 || passwordMember.trim().length>=20){
        document.getElementById("lblpassMember").innerHTML="Password should be between 5 to 20 characters";
        document.getElementById("lblpassMember").style.visibility="visible";
        return false;
    }
}

function validationRegister(){

    var usernameRegister=document.getElementById("username-register").value;
    var passwordRegister=document.getElementById("password-register").value;
    var conpasswordRegister=document.getElementById("conpassword-register").value;
	var mobilenoRegister=document.getElementById("mobileno-register").value;
    var emailRegister=document.getElementById("email-register").value;
    
    var regxmbl=/^[6-9]\d{9}$/;
	var regxemail=/^([a-zA-Z0-9\.-]+)@([a-zA-Z0-9-]+).([a-zA-Z]{2,8})(.[a-zA-Z]{2,8})$/;

    document.getElementById("lbluserRegister").style.visibility="hidden";
    document.getElementById("lblpassRegister").style.visibility="hidden";
    document.getElementById("lblconpassRegister").style.visibility="hidden";
    document.getElementById("lblmobileRegister").style.visibility="hidden";
    document.getElementById("lblemailRegister").style.visibility="hidden";
    
    if(usernameRegister.trim()==""){
        document.getElementById("lbluserRegister").style.visibility="visible";
        //alert("Invalid");
        return false;
    }
    
    else if(usernameRegister.trim().length<=2 || usernameRegister.trim().length>=20){
        document.getElementById("lbluserRegister").innerHTML="Username should be between 2 to 20 characters";
        document.getElementById("lbluserRegister").style.visibility="visible";
        return false;
    }
    
    if(passwordRegister.trim()==""){
        document.getElementById("lblpassRegister").style.visibility="visible";
        //alert("Invalid");
        return false;
    }
    
    else if(passwordRegister.trim().length<=5 || passwordRegister.trim().length>=20){
        document.getElementById("lblpassRegister").innerHTML="Password should be between 5 to 20 characters";
        document.getElementById("lblpassRegister").style.visibility="visible";
        return false;
    }

    if(conpasswordRegister.trim()==""){
        document.getElementById("lblconpassRegister").style.visibility="visible";
        //alert("Invalid");
        return false;
    }
    
    else if(passwordRegister.trim()!=conpasswordRegister.trim()){
        document.getElementById("lblconpassRegister").innerHTML="Password and Confirm Password do not match";
        document.getElementById("lblconpassRegister").style.visibility="visible";
        return false;
    }
    
    if(mobilenoRegister.trim()==""){
        document.getElementById("lblmobileRegister").style.visibility="visible";
        //alert("Invalid");
        return false;
    }

    else if(!regxmbl.test(mobilenoRegister)){
        document.getElementById("lblmobileRegister").innerHTML="Mobile Number Invalid";
        document.getElementById("lblmobileRegister").style.visibility="visible";
        return false;
    }
    
    if(emailRegister.trim()==""){
        document.getElementById("lblemailRegister").style.visibility="visible";
        //alert("Invalid");
        return false;
    }
    
    else if(!regxemail.test(emailRegister)){
        document.getElementById("lblemailRegister").innerHTML="Enter a Valid Email Address";
        document.getElementById("lblemailRegister").style.visibility="visible";
        return false;
    }
}
/*
function close(){
    console.log("Chal raha hai 2");
    alert("Heyehe");
    document.getElementById("popup-admin").style.display="none";
    console.log("Chal raha hai");
}
*/