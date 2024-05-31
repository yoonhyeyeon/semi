function displaySet(exe, no, refEpisodeNo, content, cmd){
	obj = document.frm;
	obj.no.value = no;
	obj.exe.value = exe;
	obj.refEpisodeNo.value = refEpisodeNo;
	while(content.indexOf("<br>") != -1){
		content = content.replace("<br>","\n");
	}
	obj.content.value = content;
	obj.cmd.value = cmd;
}