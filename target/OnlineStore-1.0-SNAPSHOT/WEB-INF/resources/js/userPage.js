/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 function changePassword() {
                console.log("start");
                var oldPassword = $("#oldPassword").val();
               
                console.log(oldPassword);

                $.ajax({
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8;',
                    url: 'changePassword',
                    type: 'PUT',
                    dataType: 'json',
                    contentType: 'application/json',
                            mimeType: 'application/json',
                   data : ({
			hui:'hui'
                  
		}),
                    success: function (data) {
                        console.log("in success");
                        var result = data;
                        $("#result_text").text(result);
                    }
                });
            }

