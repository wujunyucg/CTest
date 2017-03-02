function edit_child(){
	//var dialog = window.showModalDialog("jimo_jsp/edit.jsp",window,"dialogWidth:335px;status:no;dialogHeight:300px");
		var iWidth = 500;
		var iHeight = 300;
		var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
		var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
		var win = window.open("jimo_jsp/edit.jsp","±à¼­´°¿Ú", "width=" + iWidth + ", height=" + iHeight + ",top=" + iTop + ",left=" + iLeft + ",toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no,alwaysRaised=yes,depended=yes");
}