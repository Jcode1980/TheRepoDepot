<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts2-jquery-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/FinanceTrack/css/FinanceTrack.css" media="all">
<s:head />
 <style>
      #AssetMainInfo{
      	padding-top: 20px;
      	height: 80px;
      }
      
       .labels{
      	float: left;
      	padding-right: 5px;
      	width: 50px;
      }
      
      .labelAndValue{
      	padding-bottom: 5px;
      	height: 20px;
      }
      
      
       #summaryDiv .labels{
      	float: left;
      	padding-right: 10px;
      	width: 200px;
      }
      
      .tableHead{
      	font-size: 11pt;
      }

	.innerActionsBar{
		height: 50px;	
	}
	
	.textValueClass{
		float:left;
		padding-right: 15px;
	}
		
  </style>

 <s:head />
 <sj:head compressed="false"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Assets</title>
</head>
<body>
<div class="wrapper">
<s:form method="post" theme="simple">
<h1>Asset Information </h1>
<div class="actionsArea">
<s:submit key="submit" value="Save" action="saveAssetEditAction" />
	<s:submit key="submit" value="Back" action="backActionEditAsset" />
	<s:submit key="submit" value="Cancel" action="cancelAssetEditAction" />
</div>
	
	
	<div id="AssetMainInfo">
		<s:hidden name="selectedAsset.assetID" />
		<div class="labelAndValue">
			<div class="labels">Name:</div><div><s:textfield size="30" label="Name" key="selectedAsset.name" cssClass="textValueClass"/>
			<div class="labels" style="padding-left: 10px;">Address:</div><div><s:textfield size="60" label="Address" key="selectedAsset.address" />
		</div>
		<div class="labelAndValue">
			<div class="labels">Asset Type:</div><div><s:select name="assetTypeIDString" list="assetTypeList" listKey="assetTypeID" listValue="name" headerKey="0" headerValue="Asset Type" label="Select a country" /></div>
			<div class="labels">Income Yield:</div><div><s:textfield size="30" label="Name" key="selectedAsset.incomeYield" cssClass="textValueClass"/></div>	
		</div>
		
	</div>	
	</div>
</div>
<div class="tabsArea">

  <sj:tabbedPane id="projectTab" selected="0"> 
         <sj:tab src="#summaryDiv">Summary</sj:tab>
         <sj:tab src="#InvoiceDiv">Income</sj:tab>
         <sj:tab src="#ExpenditureDiv">Expenditure</sj:tab> 
         <div id="summaryDiv"> 
         	<div>
         		<div class="labelAndValue">
					<div class="labels">Net Financial Income:</div><div>$10,000</div>
				</div>	
				<div class="labelAndValue">
					<div class="labels">Gross Financial Yield:</div><div>$20,000</div>
				</div>
				<div class="labelAndValue">
					<div class="labels">Gross Financial Expenditure:</div><div>$10,000</div>
				</div>	
         	</div>
         </div>
         <div id="InvoiceDiv">
         <div class="innerActionsBar">
         		<s:submit key="submit" value="+" action="saveAssetEditAction" />
         </div> 
	     <div>
	            <table>
	            	<tr class="tableHead">
						<td style="width:110px">Date Paid</td>
						<td style="width:120px">Type</td>
						<td style="width:200px">Company</td>
						<td style="width:300px">Description</td>
						<td style="width:110px">Amount</td>
	            	</tr>
	            	<tr>
	            		<td>1/8/2013</td>
	            		<td>Electricity Bill</td>
	            		<td>AGL</td>
	            		<td>Electricity Bill 1st Quarter</td>
	            		<td>130.00</td>
	            	</tr>
	            	<tr>
	            		<td>1/8/2013</td>
	            		<td>Electricity Bill</td>
	            		<td>AGL</td>
	            		<td>Electricity Bill 1st Quarter</td>
	            		<td>130.00</td>
	            	</tr>
	            	<tr>
	            		<td>5/10/2013</td>
	            		<td>Gas Bill</td>
	            		<td>SE Water</td>
	            		<td>Water Bill 1st Quarter</td>
	            		<td>180.00</td>
	            	</tr>
	            	<tr>
	            		<td>1/5/2013</td>
	            		<td>Rates </td>
	            		<td>Frankston City COuncil</td>
	            		<td>Rates 1st Quarter</td>
	            		<td>300.00</td>
	            	</tr>
	            	<tr>
	            		<td>1/12/2013</td>
	            		<td>Electricity Bill</td>
	            		<td>AGL</td>
	            		<td>Electricity Bill 2st Quarter</td>
	            		<td>130.00</td>
	            	</tr>
	            	
	            </table>
	         </div>     
         </div>  
         <div id="ExpenditureDiv"> 
         <div class="innerActionsBar">
         		<s:submit key="submit" value="+" action="saveAssetEditAction" />
         </div> 
              <table>
            	<tr class="tableHead">
					<td style="width:110px">Date Received</td>
					<td style="width:120px">Type</td>
					<td style="width:200px">Source</td>
					<td style="width:110px">Amount</td>
            	</tr>
            	<tr>
            		<td>1/7/2013</td>
            		<td>Rental</td>
            		<td>Tenant</td>
            		<td>1500.00</td>
            	</tr>
            	<tr>
            		<td>1/8/2013</td>
            		<td>Rental</td>
            		<td>Tenant</td>
            		<td>1100.00</td>
            	</tr>
            	<tr>
            		<td>1/9/2013</td>
            		<td>Rental</td>
            		<td>Tenant</td>
            		<td>1200.00</td>
            	</tr>
            	<tr>
            		<td>1/10/2013</td>
            		<td>Rental</td>
            		<td>Tenant</td>
            		<td>1300.00</td>
            	</tr>
            	<tr>
            		<td>1/12/2013</td>
            		<td>Rental</td>
            		<td>Tenant</td>
            		<td>1500.00</td>
            	</tr>
            	
            </table> 
         </div>  
      </sj:tabbedPane> <sj:a onClickTopics="selectOverview" href="#">Select Overview</sj:a> 
</div>	
</s:form>
</div>
</body>
</html>