const idi=document.getElementById("name");
const logo=document.getElementById("logo");
const mail=document.getElementById("email");

idi.addEventListener("click",event=>{
    event.target.style.backgroundColor="green";

});

idi.addEventListener("mouseover",event=>{
    event.target.style.backgroundColor="tomato";

})

idi.addEventListener("mouseout",event=>{
    event.target.style.backgroundColor="transparent";

})

mail.addEventListener("click",event=>{
    event.target.style.backgroundColor="green";

});

mail.addEventListener("mouseover",event=>{
    event.target.style.backgroundColor="tomato";

})

mail.addEventListener("mouseout",event=>{
    event.target.style.backgroundColor="transparent";

})


document.addEventListener('keydown',(event)=>{
    if(event.key==='Enter'){
        if(idi.value==='' && mail.value===''){
            alert("please enter username and mailid");
        }
    else if(idi.value===''){
        alert("please enter username");
    }
    else if(mail.value===''){
        alert("please enter mailid");
    }
    else{
        alert("thank for login");
    }
}

})


