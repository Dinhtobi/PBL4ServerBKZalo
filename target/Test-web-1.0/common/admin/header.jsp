<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<div id="navbar" class="navbar navbar-default">
	<script type="text/javascript">
		try {
			ace.settings.check('navbar', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="navbar-container" id="navbar-container">

		<div class="navbar-header pull-left">
			<a href="http://192.168.1.2:8080/Test-web/trang-chu" class="navbar-brand"> <small> <i
					class="fa fa-leaf"></i> Trang quản trị
			</small>
			</a>
		</div>
		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="light-blue"><a data-toggle="dropdown" href="#"
					class="dropdown-toggle"> Xin chào ${Admin.username} </a>
				<li class="light-blue"><a href="<c:url value =' /thoat'/>"> <i
					class="ace-icon fa fa-power-off"></i> Thoát </a></li>
				</li>
			</ul>
		</div>
	</div>