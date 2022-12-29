<%@ include file = "/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<c:url var= "APIurl" value = "/api-admin-user"/>
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
								<div class="table-responsive">
									<table class="table">
										<thead>
											<tr>
												
												<th>Tên thành viên</th>
												<th>Trạng thái</th>
												<th>Thời gian tham gia</th>
												<th>Thời gian rời khỏi</th>
											</tr>
										</thead>
										<tbody>
										 <c:forEach var = "item" items ="${model.kq}">
										<tr>
												
												<td>${item.tennguoidung}</td>
												<td>${item.trangthaihoatdong}</td>
												<td>${item.thoigianthamgia}</td>
												<td>${item.thoigianroikhoi}</td>
												
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
		            	 $('#sortName').val('id_nguoidung');
		            	  $('#sortBy').val('asc');
		            	  $('#type').val('list');
		               $('#formsubmit').submit(); 
		            	}
		            }
		        });
		    });
		</script>  
		  
</body>	
</html>