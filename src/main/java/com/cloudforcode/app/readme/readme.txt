<input class="file" type="file" id="fafafa" name="fileupload" />
		<input type="button" value="提交XHR" onclick="xhrSubmit();" />
		<script type="text/javascript">
			function xhrSubmit() {
				var file_obj = document.getElementById('fafafa').files[0];
				var fd = new FormData();
				fd.append('file', file_obj);
				xhr = new XMLHttpRequest();
				xhr.open('POST', 'http://www.cloudforcode.com:8085/api/v1/upload/image', true)
				xhr.send(fd);
				xhr.onreadystatechange = function() {
					//后端接受完毕
					if(xhr.readyState == 4) {
						var obj = JSON.parse(xhr.responseText);
						if(obj.code==200){
							console.log(obj.data);
						}
						console.log(obj);
					}
				};
			}
</script>