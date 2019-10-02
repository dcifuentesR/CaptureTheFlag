var appModule = (function(){

    var  checkPassword= function(){
        var nick = $('#id').val();
        apiClient.checkPassword(nick,_check);
    }

    var _check = function(cuenta){
        var password = $('#password').val();
        console.log(password + " "+ cuenta)
        if (cuenta.password === password){
            console.log(password + " "+ cuenta);
            //location.href = "/juego.html"
        }
        else {
            alert("Incorrect password");
        }
    }

    return {
        checkPassword: checkPassword
    }
})();