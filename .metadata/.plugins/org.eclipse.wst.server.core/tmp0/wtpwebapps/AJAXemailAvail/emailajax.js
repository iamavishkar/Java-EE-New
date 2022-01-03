function email_fun(email){
	var request = new XMLHttpRequest();
	var url = "checkemail.jsp?email="+email;
	if(email == "" || email==null){
		
		document.getElementById("status").innerHTML = "Enter data first";
		return;
		
	}else{
		request.onreadystatechange = function(){
			
			if(this.readyState ==4 && this.status==200){
				document.getElementById("status").innerHTML = this.responseText;
			}
		}
	}
	
	request.open("post",url,true);
	request.send();
}