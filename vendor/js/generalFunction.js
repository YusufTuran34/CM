import $ from 'jquery'
export default {
    performPost : function(request,target,callback) {
        var settings = {
            "async": true,
            "url": target,
            "method": "POST",
            "headers": {
                "Content-Type": "application/json",
            },
            "processData": false,
            "data": JSON.stringify(request)
        }
        $.ajax(settings).done(function (response) {
            callback(response);
        }).fail(function(failresponse) {
            console.error("RESPONSE : "+failresponse.responseText)
        });
    },
    performGet : function(request,target,callback) {
        var settings = {
            "async": true,
            "url": target,
            "method": "GET",
            "headers": {
                "Content-Type": "application/json",
            },
            "processData": false,
            "data": null
        }
        $.ajax(settings).done(function (response) {
            callback(response);
        }).fail(function(failresponse) {
            console.error("RESPONSE : "+failresponse.responseText)
        });
    },
}