function Validation(valor) {
    var container = document.getElementById("group-" + valor.id);
    if(!isNaN(valor.value) && valor.value >= 0 && valor.value <= 99){ 
        container.className = "form-group has-success";
    } else {
        container.className = "form-group has-error";
    }

}

function Adicionar(){
    document.getElementById("menu").style.display = "none";
    document.getElementById("container").style.display = "none";

    var window = document.getElementById("add");
    window.style.display = "flex";
    window.style.position = "absolute";
    window.style.alignItems = "center";
    window.style.justifyContent = "center";
    window.style.top = "2%";
    window.style.left = "20%";
    window.style.backgroundColor = "rgb(248, 248, 248)";
    window.style.width = "60%";
    window.style.boxShadow = "0px 0px 16px 5px rgba(255, 255, 255, 0.6)";

    var register = document.getElementById("register");
    register.style.width = "90%";

    document.getElementById("playerName").focus();
    console.log("Propriedades definidas!");
}

function CloseForm() {
    // Encerrar o Form
    console.log("Form Encerrado!");
    document.getElementById("add").style.display = "none";
    document.getElementById("register").reset();

    document.getElementById("menu").style.display = "block";
    document.getElementById("container").style.display = "block";
}

function BolaoNull(){
    var navbar = document.getElementsByTagName("li");

    // length -1 para não desativar o logoff
    for(let i = 1; i < (navbar.length - 1); i++){
        var a = navbar[i].getElementsByTagName("a")[0];
        if(i == 5)
            a.className = "";
        else if(a !== undefined){
            if(navbar[i].id != "options")
                a.className = "btn disabled";
        }
    }

    document.getElementById("players").style.display = "none";
    document.getElementById("title").style.display = "none";
    document.getElementById("result").style.display = "none";
    var container = document.getElementById("container");
    container.innerHTML = "Nenhum bolão em andamento!";
    container.style.textAlign = "center";

    console.log("Não existe bolão em andamento!");
}