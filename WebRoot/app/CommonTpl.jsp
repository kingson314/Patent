<%@page language="java" contentType="text/html; charset=GBK"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv='cache-control' content='no-cache' />
		<meta http-equiv='expires' content='0' />
		<meta name="viewport"
			content=" initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>����ר�������嵥</title>
		<%@ include file="../../../sea/Session.jsp"%>
		<script>
			$(document).ready(function() {
				$("#btnQuery").click(function(){
				});
				$("#btnAdd").click(function(){
					var newRow=3;
					for(var i=0;i<newRow;i++){
						$("table tbody").append("<tr>"
				          +"<td width='30%'><input type='text' class='form-control' name='sqh' placeholder='�����������'></td>"
				          +"<td width='20%'></td>"
				          +"<td width='20%'></td>"
				          +"<td width='20%'></td>"
				          +"</tr>");
					}
					var h = document.documentElement.scrollHeight || document.body.scrollHeight;
					window.scrollTo(h,h);
				});
			});
		</script>
		<style>
			th{
				text-align:center;
				background-color:#5cb85c;
				color:#fff;
			}
			.title{
				text-align:center;
				font-weight:bold;
				font-size:24px;
			}
			#queryTable tr:nth-child(even) td {
				background-color:#d9edf7;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="title col-md-12">
					����ר�������嵥
				</div>
			</div>	
			<div class="row">
				<div class="col-md-12">
				<table id="queryTable" class="table table-bordered">
			      <thead>
			        <tr>
		        	  <th>����</th>
			          <th>�����</th>
			          <th>ר������</th>
			          <th>����״̬</th>
			          <th>˵��</th>
			        </tr>
			      </thead>
			      <tbody>
			        <%-- dyn html --%>
 			      </tbody>
			    </table>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4 footer_contactUs">
                    <h4>��ϵ��ʽ</h4>
                    <p>
                       	��ַ���㶫ʡ�麣�к��ٽ��ڲ�ҵ�������18��¥B��
                        <br> �������룺519031
                        <br/> �绰:400-806-3777
                        <br/> ���棺0756-8843326
                        <br/> �����ٹٷ�΢�źţ�qixianqinipr
                    </p>
                </div>
                <div class="col-xs-6 col-md-3">
				    <a style="height:145px;width:140px;" href="#" class="thumbnail">
				      <img  style="height:138px;width:140px;"src="<%=basePath%>app/images/code.jpg"" alt="...">
				    </a>
				  </div>
               </div>
		</div>
	</body>
</html>