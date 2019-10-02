var appModule = (function(){

    var  checkPassword= function(){
        var nick = $('#nick').val();
        apiClient.checkPassword(nick,_check);
    }

    var addAcount = function(){
        var correo = $('#email').val();
        var nick = $('#nick').val();
        var password = $('#password').val();   
        var cuenta = {"correo":correo,"contrasena":password,"nick":nick};
        apiClient.saveCuenta(JSON.stringify(cuenta));
    }

    var _check = function(cuenta){
        var password = $('#password').val();
        if (cuenta.contrasena === password){
            location.href = "/juego.html"
        }
        else {
            alert("Incorrect password");
        }
    }

    return {
        checkPassword: checkPassword,
        addAcount: addAcount
    }
})();