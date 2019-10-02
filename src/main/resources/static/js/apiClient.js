const apiUri="capturetheflag-arsw.herokuapp.com/";
apiClient= (function(){
    return {

        saveCuenta: function(cuenta){
            $.ajax({
                url: "cuentas/" + cuenta ,
                type: "POST",
                data: newBp,
                contentType: "application/json"
            });
        },

        checkPassword: function(nick,callback){
            jQuery.ajax({
                url: "cuentas/" + nick ,
                success: function(result) {
                  callback(result);
                },
                async: true
            });
        }
    };
})();