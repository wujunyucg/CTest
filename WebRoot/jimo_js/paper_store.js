function showProblems(){
	alert("begin");
	var xmlHttp = null;  
    //´´½¨xmlHttp  
     if(window.ActiveXObject)  
     {  
      		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");  
     }  
     else if(window.XMLHttpRequest)  
     {  
      		xmlHttp=new XMLHttpRequest();  
     }  
    var url="servlet/PaperStoreServlet";  alert("url");
     xmlHttp.open("POST",url,true);  alert("open");
     xmlHttp.onreadystatechange= function(){
     	if(xmlHttp.readyState==4)  
	     {  
		      if(xmlHttp.status==200)  
		      {  alert("enter");
		       		 document.getElementById("h1").innerHTML = xmlHttp.responseText;
		       		 alert("responseText: "+xmlHttp.responseText);
		      }  
			}  
     } ; alert("out");
     xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");  
     xmlHttp.send("name=value");alert("over");  
}