<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
 
<head>
<title>Assets List  <s:property value="username" /></title>

<link rel="stylesheet" type="text/css" href="/FinanceTrack/css/FinanceTrack.css" media="all">
</head>

<body>
	
	<s:form method="post" theme="simple">
	<script type="text/javascript">  
		function submitForm(id){
		   alert("submit form with ID: " + id);
		   document.getElementById("assetID_to_Edit").value = id;
		   alert("this is the value for assetID_to_Edit: " + document.getElementById("assetID_to_Edit").value);
		   window.location="editAsset.action";
		}
	</script>
	
	<div class="topActionButtons">
		<s:submit name="createAsset" value="Create Asset" align="center" action="createAsset"/>
		<s:submit name="searchAssets" value="Search Asset" align="center" action="searchAssets"/>
	</div>
	
	<div>
	
		<table>
			<tr>
				<td>
					
				</td>
				<td>
					Names
				</td>
				<td>
					Address
				</td>
				<td>
					Type
				</td>
				<td>
				</td>
			</tr>
			<s:iterator value="assetsList">
  			<tr id="assetID_<s:property value="assetID" />">
				<td>
				</td>
				<td>
					<s:property value="name"/>
				</td>
				<td>
					<s:property value="address"/>
				</td>
				<td>
					House
				</td>
				<td>
					<s:url id="editURL" action="editAsset">
						<s:param name="id" value="%{assetID}"></s:param>
					</s:url>
					<s:a href="%{editURL}">Edit</s:a>
				</td>
			</tr>
			</s:iterator>
			
		</table>
	</div>	
	<input type="hidden" name="assetIDSelected" id="assetID_to_Edit">
	</s:form>
</body>
</html>