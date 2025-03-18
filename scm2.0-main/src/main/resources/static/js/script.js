console.log("scrippt loadee");


let currentTheme = getTheme();

console.log(currentTheme);

changeTheme();


function  changeTheme(){
 
    document.querySelector('html').classList.add(currentTheme);

   const changeThemeButton = document.querySelector("#theme_change_button");

   changeThemeButton.addEventListener("click" , (event) => {
 
    console.log("button  cicked");
    
   })

}


function setTheme(theme){
    localStorage.setItem("theme" , theme);
}

function getTheme(){

    let theme = localStorage.getItem("theme");
   
    // if(theme) return
    // else  return "light";

    return  theme ? theme : "light";
}