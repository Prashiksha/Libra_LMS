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
    document.getElementById("addBook").style.display="none";
    document.getElementById("searchBook").style.display="none";
    document.getElementById("viewOrder").style.display="none";

    document.getElementById("nav-addBook").className="#";
    document.getElementById("nav-searchBook").className="#";
    document.getElementById("nav-viewOrder").className="#";
    document.getElementById("nav-changePass").className="#";
    
    document.getElementById("home").style.display="block";
    document.getElementById("nav-home").className="nav-active";
}

function displayAddBook(){
    document.getElementById("lblisbn-addBook").style.visibility="hidden";
    document.getElementById("lbltitle-addBook").style.visibility="hidden";
    document.getElementById("lblauthor-addBook").style.visibility="hidden";
    document.getElementById("lblcost-addBook").style.visibility="hidden";
    document.getElementById("lblquantity-addBook").style.visibility="hidden";

    document.getElementById("formAddBook").reset();

    document.getElementById("home").style.display="none";
    document.getElementById("searchBook").style.display="none";
    document.getElementById("viewOrder").style.display="none";

    document.getElementById("nav-home").className="#";
    document.getElementById("nav-searchBook").className="#";
    document.getElementById("nav-viewOrder").className="#";
    document.getElementById("nav-changePass").className="#";
    
    document.getElementById("addBook").style.display="block";
    document.getElementById("nav-addBook").className="nav-active";
}

function displaySearchBook(){
    document.getElementById("home").style.display="none";
    document.getElementById("addBook").style.display="none";
    document.getElementById("viewOrder").style.display="none";

    document.getElementById("formSearchBook").reset();

    document.getElementById("nav-home").className="#";
    document.getElementById("nav-addBook").className="#";
    document.getElementById("nav-viewOrder").className="#";
    document.getElementById("nav-changePass").className="#";

    document.getElementById("nav-searchBook").className="nav-active";
    document.getElementById("searchBook").style.display="block";
}

function displayUpdateBook(){
    document.getElementById("lblisbn-updateBook").style.visibility="hidden";
    document.getElementById("lbltitle-updateBook").style.visibility="hidden";
    document.getElementById("lblauthor-updateBook").style.visibility="hidden";
    document.getElementById("lblcost-updateBook").style.visibility="hidden";
    document.getElementById("lblquantity-updateBook").style.visibility="hidden";

    document.getElementById("formUpdateBook").reset();

    document.getElementById("popup-update").style.display="flex";
}

function closeUpdate(){
    document.getElementById("popup-update").style.display="none";
}

function displayViewOrder(){
    document.getElementById("home").style.display="none";
    document.getElementById("addBook").style.display="none";
    document.getElementById("searchBook").style.display="none";

    document.getElementById("formviewOrderSearch").reset();

    document.getElementById("nav-home").className="#";
    document.getElementById("nav-addBook").className="#";
    document.getElementById("nav-searchBook").className="#";
    document.getElementById("nav-changePass").className="#";

    document.getElementById("nav-viewOrder").className="nav-active";
    document.getElementById("viewOrder").style.display="block";
}

function displayChangePass(){
    document.getElementById("lbluser-changepass").style.visibility="hidden";
    document.getElementById("lbloldpass-changepass").style.visibility="hidden";
    document.getElementById("lblnewpass-changepass").style.visibility="hidden";
    document.getElementById("lblconpass-changepass").style.visibility="hidden";

    document.getElementById("formChangePass").reset();

    document.getElementById("popup-changepass").style.display="flex";
}

function closeChangePass(){
    document.getElementById("popup-changepass").style.display="none";
}

// function displayAddGenre(){
//     document.getElementById("home").style.display="none";
//     document.getElementById("addBook").style.display="none";
//     document.getElementById("searchBook").style.display="none";
//     document.getElementById("viewOrder").style.display="none";

//     document.getElementById("formAddGenre").reset();

//     document.getElementById("nav-home").className="#";
//     document.getElementById("nav-addBook").className="#";
//     document.getElementById("nav-searchBook").className="#";
//     document.getElementById("nav-viewOrder").className="#";

//     document.getElementById("nav-more").className="nav-active";
//     document.getElementById("addGenre").style.display="block";
// }

function validationAddBook(){
     var isbn=document.getElementById("isbn-addBook").value;
    var title=document.getElementById("title-addBook").value;
    var author=document.getElementById("author-addBook").value;
    var cost=document.getElementById("cost-addBook").value;
    var quantity=document.getElementById("quantity-addBook").value;

    document.getElementById("lblisbn-addBook").style.visibility="hidden";
    document.getElementById("lbltitle-addBook").style.visibility="hidden";
    document.getElementById("lblauthor-addBook").style.visibility="hidden";
    document.getElementById("lblcost-addBook").style.visibility="hidden";
    document.getElementById("lblquantity-addBook").style.visibility="hidden";

    var regxisbn=/^(97(8|9))?\d{9}(\d|X)$/;

    if(isbn.trim()==""){
        document.getElementById("lblisbn-addBook").style.visibility="visible";
        return false;
    }

    else if(!regxisbn.test(isbn)){
        document.getElementById("lblisbn-addBook").innerHTML="ISBN Number Invalid";
        document.getElementById("lblisbn-addBook").style.visibility="visible";
        return false;
    }

    if(title.trim()==""){
        document.getElementById("lbltitle-addBook").style.visibility="visible";
        return false;
    }

    if(author.trim()==""){
        document.getElementById("lblauthor-addBook").style.visibility="visible";
        return false;
    }

    if(cost.trim()==""){
        document.getElementById("lblcost-addBook").style.visibility="visible";
        return false;
    }

    if(quantity.trim()==""){
        document.getElementById("lblquantity-addBook").style.visibility="visible";
        return false;
    }
}

function validationUpdateBook(){
    var isbnUpdate=document.getElementById("isbn-updateBook").value;
    var titleUpdate=document.getElementById("title-updateBook").value;
    var authorUpdate=document.getElementById("author-updateBook").value;
    var costUpdate=document.getElementById("cost-updateBook").value;
    var quantityUpdate=document.getElementById("quantity-updateBook").value;

    document.getElementById("lblisbn-updateBook").style.visibility="hidden";
    document.getElementById("lbltitle-updateBook").style.visibility="hidden";
    document.getElementById("lblauthor-updateBook").style.visibility="hidden";
    document.getElementById("lblcost-updateBook").style.visibility="hidden";
    document.getElementById("lblquantity-updateBook").style.visibility="hidden";

    var regxisbn=/^(97(8|9))?\d{9}(\d|X)$/;

    if(isbnUpdate.trim()==""){
        document.getElementById("lblisbn-updateBook").style.visibility="visible";
        return false;
    }

    else if(!regxisbnUpdate.test(isbn)){
        document.getElementById("lblisbn-updateBook").innerHTML="ISBN Number Invalid";
        document.getElementById("lblisbn-updateBook").style.visibility="visible";
        return false;
    }

    if(titleUpdate.trim()==""){
        document.getElementById("lbltitle-updateBook").style.visibility="visible";
        return false;
    }

    if(authorUpdate.trim()==""){
        document.getElementById("lblauthor-updateBook").style.visibility="visible";
        return false;
    }

    if(costUpdate.trim()==""){
        document.getElementById("lblcost-updateBook").style.visibility="visible";
        return false;
    }

    if(quantityUpdate.trim()==""){
        document.getElementById("lblquantity-updateBook").style.visibility="visible";
        return false;
    }
}

function validationChangePass(){
    document.getElementById("lbluser-changepass").style.visibility="hidden";
    document.getElementById("lbloldpass-changepass").style.visibility="hidden";
    document.getElementById("lblnewpass-changepass").style.visibility="hidden";
    document.getElementById("lblconpass-changepass").style.visibility="hidden";

    var usernameChangePass=document.getElementById("username-changepass").value;
    var oldpasswordChangePass=document.getElementById("oldpassword-changepass").value;
    var newpasswordChangePass=document.getElementById("newpassword-changepass").value;
    var conpasswordChangePass=document.getElementById("conpassword-changepass").value;

    if(usernameChangePass.trim()==""){
        document.getElementById("lbluser-changepass").style.visibility="visible";
        return false;
    }

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

function displayDeleteBook(){
    document.getElementById("lblisbn-deleteBook").style.visibility="hidden";
    document.getElementById("lbltitle-deleteBook").style.visibility="hidden";
    document.getElementById("lblauthor-deleteBook").style.visibility="hidden";
    //document.getElementById("lblcost-deleteBook").style.visibility="hidden";
    //document.getElementById("lblquantity-deleteBook").style.visibility="hidden";

    document.getElementById("formDeleteBook").reset();

    document.getElementById("popup-delete").style.display="flex";
}

function closeDelete(){
    document.getElementById("popup-delete").style.display="none";
}

function validationDeleteBook(){
    var isbnDelete=document.getElementById("isbn-deleteBook").value;
    var titleDelete=document.getElementById("title-deleteBook").value;
    var authorDelete=document.getElementById("author-deleteBook").value;
    //var costUpdate=document.getElementById("cost-updateBook").value;
    //var quantityUpdate=document.getElementById("quantity-updateBook").value;

    document.getElementById("lblisbn-deleteBook").style.visibility="hidden";
    document.getElementById("lbltitle-deleteBook").style.visibility="hidden";
    document.getElementById("lblauthor-deleteBook").style.visibility="hidden";
    //document.getElementById("lblcost-updateBook").style.visibility="hidden";
    //document.getElementById("lblquantity-updateBook").style.visibility="hidden";

    var regxisbn=/^(97(8|9))?\d{9}(\d|X)$/;

    if(isbnDelete.trim()==""){
        document.getElementById("lblisbn-deleteBook").style.visibility="visible";
        return false;
    }

    else if(!regxisbnDelete.test(isbn)){
        document.getElementById("lblisbn-deleteBook").innerHTML="ISBN Number Invalid";
        document.getElementById("lblisbn-deleteBook").style.visibility="visible";
        return false;
    }

    if(titleDelete.trim()==""){
        document.getElementById("lbltitle-deleteBook").style.visibility="visible";
        return false;
    }

    if(authorDelete.trim()==""){
        document.getElementById("lblauthor-deleteBook").style.visibility="visible";
        return false;
    }

    /*if(costUpdate.trim()==""){
        document.getElementById("lblcost-updateBook").style.visibility="visible";
        return false;
    }

    if(quantityUpdate.trim()==""){
        document.getElementById("lblquantity-updateBook").style.visibility="visible";
        return false;
    }*/
}