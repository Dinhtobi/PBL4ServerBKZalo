<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var= "APIurl" value = "/api-admin-groupchat"/>
<c:url var= "UserURL" value = "/admin-group"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa thông tin Nhóm</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang chủ</a>
					</li>
					<li class = "active" >Chỉnh sủa thông tin Nhóm</li>
					
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test = "${not empty message}">
							<div class = "alert alert-${alert}">
								${message}
							</div>
						</c:if>
						<form id="formSubmit">
						<div class="form-group">
							<label class ="col-sm-3 control-label no-padding-right">Tên nhóm</label>
							<div class="col-sm-9">
								<input type ="text" class ="form-control" id="tennhom" name ="tennhom" value = "${model.tennhom}">
							</div>
						</div>
						<br/>
						<br/>
						<div class="form-group">
							<label class ="col-sm-3 control-label no-padding-right">Trạng thái</label>
							<div class="col-sm-9">
							<c:if test="${model.trangthai == 1}">
								<input type ="radio"  id="hoatdong" name ="trangthai" value = "1" checked="checked">
								<label for="html">Đang hoạt động</label><br>
								<input type ="radio"  id="ngunghoatdong" name ="trangthai" value = "0">
								<label for="html">Ngừng hoạt động</label>
								</c:if>
							
							<c:if test="${model.trangthai == 0}">
								<input type ="radio"  id="hoatdong" name ="trangthai" value = "1">
								<label for="html">Đang hoạt động</label><br>
								<input type ="radio"  id="ngunghoatdong" name ="trangthai" value = "0" checked="checked">
								<label for="html">Ngừng hoạt động</label>
								</c:if>
								</div>
						</div>
						<br/>
						<br/>
						<div class="form-group">
							<div class="col-sm-12">
								<c:if test="${not empty model.id_nhomchat}">
								<input type ="button" class ="btn btn-white btn-warning btn-bold" id="btAddorUpdateUser" value = "Cập nhật nhóm">
								</c:if>
								</div>
						</div>
						<input type="hidden" value="${model.id_nhomchat}" id="id_nhomchat" name = "id_nhomchat"/>
						<input type="hidden" value="admin" id="type" name = "type"/>
						
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		$('#btAddorUpdateUser').click(function (e){
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData , function (i ,v) {
				data[""+v.name+""] =v.value; 
			});
			var id =$('#id_nhomchat').val();
				updateNew(data);
		});
		function updateNew(data){
			$.ajax({
				url: '${APIurl}',
				type:'PUT',
				contenType:'application/json',
				data:JSON.stringify(data),
				dataType:'json',
				success: function (result) {
					window.location.href = "${UserURL}?type=list&page=1&maxPageItem=5&sortName=id_nhomchat&sortBy=asc";
				},
				error: function (error) {
					console.log(error);
				},
			});
		}
	</script>
</body>
</html>