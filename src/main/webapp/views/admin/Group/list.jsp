<%@ include file = "/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<c:url var= "APIurl" value = "/api-admin-groupchat"/>
<c:url var= "GroupURL" value = "/admin-group"/>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Danh sách nhóm chat</title>
</head>

<body>
	
	<div class="main-content">
	<form action = "<c:url value ='/admin-user'/>" id = "formsubmit" method = "get">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>
					<li class="#">Trang chủ</li>
				</ul>
				
				<!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-12">							
							<button id = "btDelete" type = "button"
							class = "dt-button button-html5 btn btn-white btn-primary btn-bold"
							data-toggle ="tooltip" title= "Xoá nhóm" 
							>
							<span>
							<i class="fa fa-trash-o" aria-hidden="true"></i>
							</span>
							</button>
							
							
								<div class="table-responsive">
									<table class="table">
										<thead>
											<tr>
												<th><input type="checkbox" id="checkAll"></th>
												<th >Id Nhóm chat</th>
												<th>Tên Nhóm</th>
												<th>Tên người tạo</th>
												<th>Trạng thái</th>
												<th>Cập nhật</th>
												<th>Xem chi tiết</th>
											</tr>
										</thead>
										<tbody>
										 <c:forEach var = "item" items ="${model.kq}">
										<tr>
												<td><input type="checkbox" id="checkbox_${item.id_nhomchat}" value = "${item.id_nhomchat}"></td>
												<td>${item.id_nhomchat}</td>
												<td>${item.tennhom}</td>
												<td>${item.tennguoitao}</td>
												<td>${item.trangthaihoatdong}</td>
												<td>
												
												<c:url var = "editURL" value="/admin-group">
													<c:param name="type" value = "edit"></c:param>
													<c:param name="id_nhomchat" value = "${item.id_nhomchat}"></c:param>
												</c:url>
												<a class = "btn btn-sm btn-primary btn-edit" 
													data-toggle = "tooltip"
													title = "Cập nhật thông tin nhóm chat"
													href = '${editURL}'
												>
												<i class="fa fa-pencil" aria-hidden="true"></i>
												</a>
												
												</td>
												<td>
												
												<c:url var = "listURL" value="/admin-detailgroup">
													<c:param name="type" value = "list"></c:param>
													<c:param name="page" value = "1"></c:param>
													<c:param name="maxPageItem" value = "5"></c:param>
													<c:param name="sortName" value = "id_nguoidung"></c:param>
													<c:param name="sortBy" value = "asc"></c:param>
													<c:param name="id_nhomchat" value = "${item.id_nhomchat}"></c:param>
												</c:url>
												<a class = "btn btn-sm btn-primary btn-edit" 
													data-toggle = "tooltip"
													title = "Xem danh sách nhóm chat"
													href = '${listURL}'
												>
												<i class="fa fa-eye" aria-hidden="true"></i>
												</a>
												
												</td>
											</tr>
										</c:forEach> 
										</tbody>
									</table>
									 <ul class="pagination" id="pagination"></ul>
									<input type="hidden" value="" id="page" name = "page"/>
									<input type="hidden" value="" id="maxPageItem" name = "maxPageItem"/>
									<input type="hidden" value="" id="sortName" name = "sortName"/>
									<input type="hidden" value="" id="sortBy" name = "sortBy"/>
									<input type="hidden" value="" id="type" name = "type"/>
								 </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	</div>
	
	 <script type="text/javascript">
		 var totalPages = ${model.totalPage};
		var curentPage = ${model.page};
		var limit = 5;  
		    $(function () {
		        window.pagObj = $('#pagination').twbsPagination({
		            totalPages: totalPages,
		            visiblePages: 5,
		            startPage :curentPage,
		            onPageClick: function (event, page) {
		            	if(curentPage != page){
		            	$('#maxPageItem').val(limit)
		               $('#page').val(page);
		            	 $('#sortName').val('id_nhomchat');
		            	  $('#sortBy').val('asc');
		            	  $('#type').val('list');
		               $('#formsubmit').submit(); 
		            	}
		            }
		        });
		    });
		    
		    $("#btDelete").click( function () {
				var data ={};
				var ids = $('tbody input[type=checkbox]:checked').map(function () {
					return $(this).val();
				}).get();
				data['ids'] = ids;
				deleteUser(data);
			});
		    function deleteUser(data) {
				$.ajax({
					url: '${APIurl}',
					type:'DELETE',
					contenType:'application/json',
					data:JSON.stringify(data),
					success: function (result) {
						window.location.href = "${GroupURL}?type=list&page=1&maxPageItem=5&sortName=id_nhomchat&sortBy=asc";
					},
					error: function (error) {
						console.log(error);
					},
				});
			}
		</script>  
		  
</body>	
</html>