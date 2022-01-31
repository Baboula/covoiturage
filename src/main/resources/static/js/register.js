$('document').ready(function(){
	
	var password = document.getElementById("password");
	
	var confirmpassword = document.getElementById("confirmpassword");
	
	function validatePassword(){
		
		if(confirmpassword.value !== password.value){
			
			confirmpassword.setCustomValidity('Le password entré est différent');
		}else{
			
			confirmpassword.setCustomValidity('');
		}
		
	}
	
		password.onchange = validatePassword;
		confirmpassword.onkeyup = validatePassword;
});