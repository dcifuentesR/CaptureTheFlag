const apiUri="capturetheflag-arsw.herokuapp.com/";
apiClient= (function(){
    return {

        saveCuenta: function(cuenta){
            console.log(cuenta);
            $.ajax({
                url: "cuentas/",
                type: "post",
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