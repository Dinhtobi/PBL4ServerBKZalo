<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var= "APIurl" value = "/api-admin-user"/>
<c:url var= "UserURL" value = "/admin-user"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa thông tin user</title>
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
					<li class = "active" >Chỉnh sủa thông tin user</li>
					
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
							<label class ="col-sm-3 control-label no-padding-right">Tên</label>
							<div class="col-sm-9">
								<input type ="text" class ="form-control" id="ten" name ="ten" value = "${model.ten}">
							</div>
						</div>
						<br/>
						<br/>
						<div class="form-group">
							<label class ="col-sm-3 control-label no-padding-right">Email</label>
							<div class="col-sm-9">
								<input type ="text" class ="form-control" id="email" name ="email" value = "${model.email}">
							</div>
						</div>
						<br/>
						<br/>
						<div class="form-group">
							<label class ="col-sm-3 control-label no-padding-right">Mật khẩu</label>
							<div class="col-sm-9">
								<input type ="text" class ="form-control" id="password" name ="password" value = "${model.password}">
							</div>
						</div>
						<br/>
						<br/>
						<div class="form-group">
							<div class="col-sm-12">
								<c:if test="${not empty model.id}">
								<input type ="button" class ="btn btn-white btn-warning btn-bold" id="btAddorUpdateUser" value = "Cập nhật user">
								</c:if>
								<%-- <c:if test="${empty model.id}">
								<input type ="button" class ="btn btn-white btn-warning btn-bold" id="btAddorUpdateUser" value = "Thêm mới user">
								</c:if> --%>
								</div>
						</div>
						<input type="hidden" value="${model.id}" id="id" name = "id"/>
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
			var id =$('#id').val();
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
					window.location.href = "${UserURL}?type=list&page=1&maxPageItem=5&sortName=id_users&sortBy=asc";
				},
				error: function (error) {
					console.log(error);
				},
			});
		}
	</script>
</body>
</html>