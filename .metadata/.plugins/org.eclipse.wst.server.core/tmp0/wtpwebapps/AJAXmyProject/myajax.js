function myfun(){
	var request = new XMLHttpRequest();
	var num = document.getElementById("num").value;
	var url = "table.jsp?num="+num;
	
	request.onreadystatechange = function(){
		
		if(this.readyState==4 && this.status==200){
			document.getElementById("result").innerHTML = this.responseText;
		}
	};
	request.open("post",url,true);
	request.send();
}