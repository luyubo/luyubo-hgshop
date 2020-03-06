<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品规格列表</title>
</head>
<body>
<h3>商品规格列表</h3>

<div>
	<input id="queryName" value="${queryName}"/>
	
	<button type="button" class="btn btn-primary" onclick="query()">
   	查询 </button>
   	
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
	   添加</button>
	   
	<button type="button" class="btn btn-primary" onclick="delBatch()">
   	批量删除</button>
</div>
<!-- Modal 模态窗口-->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>&nbsp;
         <button type="button" onclick="addProp()"> 添加属性
         </button>
         
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        	
      </div>
      <div class="modal-body">
        	<form id="addspec">
        		 <div class="form-group">
    				<label for="specName">规格名称</label>
    				<input type="text" class="form-control" name="specName" id="specName" aria-describedby="specNamelHelp">
    				<small id="specNamelHelp" class="form-text text-muted">请输入规格名称</small>
  				</div>
  				<div class="form-group form-group-proper" >
    				<label for="inputAddress">属性值</label>
    				<input type="text" name="options[0].optionName" class="form-control" id="inputAddress" placeholder="1234 Main St">
    				<button onclick="$(this).parent().remove()">删除</button>
  				</div>
  				
    			
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="commitSpec()">提交</button>
      </div>
    </div>
  </div>
</div>


<table class="table">
  <tr>
  	<th colspan="100">id 
    	<input type="checkbox" id="allSel" onchange="selectedAll()" />  
			<button type="button" class="btn btn-info btn-sm" onclick="selAll(1)">全选</button>
			<button type="button" class="btn btn-info btn-sm" onclick="selAll(2)">全不选</button>
			<button type="button" class="btn btn-info btn-sm" onclick="selAll(3)">反选</button>
	</th>
  </tr>
  <tr>
    <th>id</th>
    <th>名称</th>
    <th>详情</th>
    <th>操作</th>
    
  </tr>
  <c:forEach items="${pageInfo.list }" var="spec">
	  <tr>
	    <td>
	    	<input type="checkbox" name="ids" value="${spec.id}" onchange="selectedOne()" />
	    	${spec.id }
	    </td>
	    <td>${spec.specName }</td>
	    <td>
	    	<c:forEach items="${spec.options }" var="opt">
	    	&nbsp;&nbsp;${opt.optionName }
	    	</c:forEach>
	    </td>
	    <td>
			<button type="button" class="btn btn-danger" onclick="delSec(${spec.id})">删除</button>
			<button type="button" class="btn btn-warning" onclick="openUpdateSpec(${spec.id})">修改</button>
		</td>
	  </tr>
  </c:forEach>
  <!-- pageInfo -->
	<tr>
		<td colspan="3">
			<jsp:include page="../common/page.jsp"></jsp:include>
		</td>
	</tr>
</table>

</body>

<script type="text/javascript">

/* 添加属性值 */
	var addindex=1;
	function addProp() {
		$("#addspec").append('<div class="form-group form-group-proper">'+
				'<label for="inputAddress">属性值</label>'+
				'<input type="text" name="options['+addindex+'].optionName" class="form-control" id="inputAddress" placeholder="1234 Main St">'+
				'<button onclick="$(this).parent().remove()">删除</button>'+
				'</div>')
				addindex++;
	}
	
/* 查询 */
	function query() {
		var url = "/spec/list?name="+$("#queryName").val();
		$("#main").load(url)
	}
	
/* 分页 */
	function goPage(pagenum) {
		var url ="/spec/list?name="+$("#queryName").val()+'&page='+pagenum;
		$("#main").load(url);
	}
	
/* 刷新 and 保持查询条件和页码 */
	function refresh() {
		var url ="/spec/list?name=${queryName}"+'&page=${pageInfo.pageNum}';
		$("#main").load(url);
	}

/* 添加窗口的复位 */
	function resetAddForm(){
		$(".form-group-proper").each(function(){
			$(this).remove();
		})
		addindex=1;
		$("#specName").val("")
	}
	
	// 给*添加*规格模态框增加*显示*成功后的事件  
	$('#staticBackdrop').on('shown.bs.modal', function (e) {
		  // do something...
		resetAddForm();
	})
	
	// 给*添加*规格模态框增加*关闭*以后的事件  
	$('#staticBackdrop').on('hidden.bs.modal', function (e) {
		  // do something...
		refresh();
	})
	
	// 给*修改*规格模态框增加关闭以后的事件  
	$('#staticBackdropUpdate').on('hidden.bs.modal', function (e) {
		  // do something...
		refresh();
	})

/* 提交 */	
	function commitSpec() {
		var formData = new FormData($("#addspec")[0]);
		$.ajax({url:"/spec/add",
			  //dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(data){
				  if(data=="success"){
						 alert("数据提交成功");
						 $('#staticBackdrop').modal('hide');
					 }else{
						 alert("数据保存失败");
					 }  
				 
			  }
			  })
	}
	
/* 删除*/
	function delSec(id) {
		if(confirm("您确认删除该条数据吗？")){
			$.post("/spec/delSpec",{id:id},function(){
				if(data="success"){
					alert("删除成功")
					refresh();
				}else {
					alert("删除失败")
				}
			});
		}else {
			return;
		}
	}

/* 三个选项按钮 */
	function selAll(flag){
	 	 if(flag==1){
			//全选
			$("[name=ids]").each(function(){
				$(this).prop("checked",true)
			})
		}
		
		if(flag==2){
			//全不选
			$("[name=ids]").each(function(){
				$(this).prop("checked",false)
			})
		}
		
		if(flag==3){
			//反选
			$("[name=ids]").each(function(){
				var ch = !$(this).prop("checked")
				$(this).prop("checked",ch)
			})
		} 
		// 判断是否所有的都被选中了
		var allSelected = $("[name=ids]").length==$("[name=ids]:checked").length;
		//设置全选的框
		$("#allSel").prop("checked",allSelected)
		 
	}
	
/*点击全选的checkbox*/
 function selectedAll(){
	var checked = $("#allSel").prop("checked")
	// 让每个checkbox 都等于 总的checkbox
	$("[name=ids]").each(function(){
			$(this).prop("checked",checked)
		})
} 
/* 批量删除 */
function delBatch(){
		if($("[name=ids]:checked").length<=0){
			alert("没有数据被选中，不能删除")
			return;
		}
		// 组织删除的数据
		var delIds  = new Array();
		$("[name=ids]:checked").each(function(){
			delIds.push($(this).val());
		})
		
		
		if(confirm("您确认删除这些数据么？")){
			$.post("/spec/delSpecBatch",{ids:delIds},function(data){
				if(data="success"){
					alert("删除成功")
					refresh();
				}else{
					alert("删除失败")
				}
				
			});
		}else{
			return;
		}
}
</script>
</html>