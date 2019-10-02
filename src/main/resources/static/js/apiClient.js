const apiUri="capturetheflag-arsw.herokuapp.com/";
apiClient= (function(){
    return {

        saveCuenta: function(cuenta){
            $.ajax({
                url: "cuentas/" + cuenta ,
                type: "POST",
                data: cuenta,
                contentType: "application/json"
            });
        },

        checkPassword: function(nick,callback){
            jQuery.ajax({
                url: "cuentas/" + nick ,
                success: function(result) {
                    console.log(result);
                  callback(result);
                },
                async: true
            });
        }
    };
})();