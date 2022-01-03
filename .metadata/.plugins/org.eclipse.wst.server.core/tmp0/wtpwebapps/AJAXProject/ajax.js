function test(){
	var req=new XMLHttpRequest();
	req.onreadystatechange=function(){
		
		if(this.readyState==4 && this.status==200){
			document.getElementById("m").innerHTML=this.responseText;
			document.getElementById("n").innerHTML=this.responseText;
		}
	};
	req.open("GET","home.jsp",true);
	req.send();
}

function myfun(a){
	var req=new XMLHttpRequest();
	if(a==null || a==''){
		document.getElementById("m").innerHTML="";
		return;
	}
	
	req.onreadystatechange=function(){
		
		if(this.readyState==4 && this.status==200){
			document.getElementById("m").innerHTML=this.responseText;
		}
	};
	req.open("GET","text.jsp?id="+a,true);
	req.send();

}