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
        location.href = "/index.html"
    }

    var _check = function(cuenta){
        var password = $('#password').val();
        if (cuenta.contrasena === password){
            location.href = "/home.html"
            verificationModule.crear_cookie_sesion($('#nick').val())
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

var verificationModule =(function(){

    var crear_cookie_sesion =  function(usuario){
        document.cookie = "nickname=" +  encodeURIComponent(usuario);
    }

    var _readCookie = function (name) {
        var nameEQ = name + "="; 
        var ca = document.cookie.split(';');
      
        for(var i=0;i < ca.length;i++) {
      
          var c = ca[i];
          while (c.charAt(0)==' ') c = c.substring(1,c.length);
          if (c.indexOf(nameEQ) == 0) {
            return decodeURIComponent( c.substring(nameEQ.length,c.length) );
          }
      
        }
        return null;
      }


    var check_cookie = function(){
        /*console.log(document.cookie)
        var user = _readCookie("nickname");
        if (user == null ){
            alert("Permiso denegado, debe logearse primero.")
            location.href = "/index.html"
        }*/
        
    }

    var borrar_cookie = function(){
        document.cookie = 'nickname=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    }


    return {
        crear_cookie_sesion: crear_cookie_sesion,
        check_cookie: check_cookie,
        borrar_cookie:borrar_cookie
    }

})(); 

