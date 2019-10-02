const apiUri="capturetheflag-arsw.herokuapp.com/";
apliClient= (function(){
    return {

        saveCuenta: function(cuenta){
            $.ajax({
                url: "cuentas/" + cuenta ,
                type: "POST",
                data: newBp,
                contentType: "application/json"
            });
        },

        checkPassword: function(nick,password, callback){
            jQuery.ajax({
                url: apiUrl + "cuentas/" + nick ,
                success: function(result) {
                  callback(result);
                },
                async: true
            });
        }
    }
})
