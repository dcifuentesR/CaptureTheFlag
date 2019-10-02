var appModule = (function(){

    var  checkPassword= function(){
        var nick = $('#nick').val();
        apiClient.checkPassword(nick,_check);
    }

    var addAcount = function(){
        var correo = $('#nick').val();
        var nick = $('#nick').val();
        var password = $('#nick').val();        
    }

    var _check = function(cuenta){
        var password = $('#password').val();
        console.log(password + " cuenta"+ cuenta)
        if (cuenta.contrasena === password){
            console.log(password + " "+ cuenta[0]);
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