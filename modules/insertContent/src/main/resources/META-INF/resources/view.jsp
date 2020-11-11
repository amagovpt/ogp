<%@ include file="/init.jsp" %>
<%@page import = "com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@page import = "com.liferay.portal.kernel.util.WebKeys" %>

<portlet:defineObjects />

<!-- <portlet:resourceURL var="ajaxURL"> -->
<!-- </portlet:resourceURL> -->
<portlet:resourceURL var="processCommentURL" id="addComment"/>

<div class="modal-content">
	      <div class="main-content main-form" style="background-color: #fff;">
	      	<img alt="Fechar caixa de suggestões" class="close-modal" src="/o/opengov-theme/images/close.svg">
	   	        
	        <div class="modal-body">

	          <div class="tab-content col-xs-12 propose-measure-form">
	          	           	 	
	          	  <h2><@liferay.language key="propose-your-measure" /></h2>	          	
	          
		          <form name="myForm" id="propose-measure" data-toggle="validator" role="form">
		            <div class="col-sm-10 col-xs-11 col-sm-offset-1">
			            
			            <div class="row margin-bottom input-width" style="margin-top: 15px;">

			            	<div class="form-group">
				            	<label for="pm-titulo"><@liferay.language key="title" /></label>
				            	<input type="text" name="title" id="pm-titulo" placeholder="" required="required" data-error="<@liferay.language key="required-field" />">
			              		<div class="help-block with-errors"></div>
			              	</div>
			              	
			              	<div class="form-group">
				            	<label for="pm-objectivo"><@liferay.language key="goal" />?</label>
				            	<textarea maxlength="1500" required name="goal" id="pm-objectivo" required="required" data-error="<@liferay.language key="required-field" />"></textarea>
			              		<div class="help-block with-errors"></div>
			              		<small><@liferay.language key="characters" /><span class="chars2">1500</span></small>
			              	</div>
			              	
			              	
			              	<div class="form-group">
				              <label for="pm-problema"><@liferay.language key="what-is-the-problem-that-the-measure-describes" />?</label>
				              <textarea maxlength="1500" required id="pm-problema" required="required" data-error="<@liferay.language key="required-field" />"></textarea>
				              <div class="help-block with-errors"></div>
				              <small><@liferay.language key="characters" /><span class="chars2">1500</span></small>
			              	</div>
			              	
			              	
			              	<div class="form-group">
				              <label for="pm-solucao"><@liferay.language key="what-is-the-problem-that-the-measure-solves" />?</label>
				              <textarea maxlength="1500" required id="pm-solucao" required="required" data-error="<@liferay.language key="required-field" />"></textarea>
				              <div class="help-block with-errors"></div>
				              <small><@liferay.language key="characters" /><span class="chars2">1500</span></small>
			              	</div>			              
			             	
			            </div>
			            
			            <div class="row margin-bottom input-width">
			            	
			            	<div class="col-xs-6" style="padding-left:0">			            	
				            	<label for="pm-eixos"><@liferay.language key="axes" /></label>				
				            	<div class="dropdown"> 
				            		<#--<button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" type="button"><span class="caret"></span></button> -->
				            		<span class="caret"></span>
				            		<select name="eixos" id="pm-eixos" class="btn btn-primary dropdown-toggle"> 
				            			<option value="dados abertos"><@liferay.language key='open-data' /></option>
				            			<option value="transparência"><@liferay.language key='transparency' /></option>
				            			<option value="inclusão digital"><@liferay.language key='digital-inclusion' /></option>
				            			<option value="participação pública"><@liferay.language key='public-participation' /></option>
				            		</select>
				            		
				            		<div class="help-block with-errors"></div>
				            	</div>
			            	</div>
			            	
			            	<div class="col-xs-6" style="padding-right:0">
			            		<label for="pm-outras"><@liferay.language key="other-entities" /></label>
				            	<input type="text" name="outras" id="pm-outras" placeholder="" />
			            	</div>
						</div>
			            
			            <div class="row margin-bottom input-width disabled-group">
							<div class="col-xs-2">
				              <label for="pm-nome"><@liferay.language key="name" /></label>				              
			              	</div>
			              	
			              	<div class="col-xs-10">
			              		<input type="text" id="pm-nome" name="nome" disabled/>
			              	</div>
													
				              <#--<label for="pm-email"><@liferay.language key="email" /></label>
				              <input type="text" name="email" id="pm-email" placeholder="" required="required" data-error="<@liferay.language key="required-field" />">
				              <div class="help-block with-errors"></div>-->				             			              			             
			            </div>		

			            <div class="other-submit form-group" >			            	
			           		<button type="submit" class="btn btn-primary"><@liferay.language key="send" /></button>
			           		<input type="submit" style="display: none" name="submitProposalHidden"/>           
			            </div>
		            </div>
		          </form>
	          </div>
	        </div>
	      </div>
	
	    </div>
	
	  </div>
	</div>




<script type="text/javascript">

function proposeMeasureSubmit() {		
	var nome		= $('#pm-nome').val();
	var email		= $('#pm-email').val();
	var titulo		= $('#pm-titulo').val();		
	var msg			= $('#pm-mensagem').val();
	var eixos		= $('#pm-eixos').val();
	var objectivo	= $('#pm-objectivo').val();
	var problema	= $('#pm-problema').val();
	var solucao		= $('#pm-solucao').val();
	var outras		= $('#pm-outras').val();

	console.log("Nome="+nome);
	var data = {};	
	data["nome"]=nome;
	data["email"]=email;
	data["msg"]=msg;
	data["titulo"]=titulo;
	data["eixos"]=eixos;
	
	data["objectivo"]=objectivo;
	data["problema"]=problema;
	data["solucao"]=solucao;
	data["outras"]=outras;
	
	
// 	console.log(data["eixos"]);
	var dataJson = JSON.stringify(data);
// 	console.log("Data JSON="+dataJson);
	submitData(dataJson);
	return false;		
}

function submitData(dataJson){
	 
 	AUI().use('aui-base','aui-io-request','liferay-form','aui-alert', function(A){
//	AUI().use('aui-base','aui-io-request', function(A){
		
		var portletUrl = "InsertContent";
		A.io.request('<%=processCommentURL %>',{ 
// 		A.io.request('/addcomment?p_p_id='+portletUrl+'&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=addComment&p_p_cacheability=cacheLevelPage', {
			 dataType: 'json',
			 method: 'POST',
			 data: { data: dataJson },
			 on: {
				success: function() {
					
					console.log('/addcomment?p_p_id='+portletUrl+'&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=addComment&p_p_cacheability=cacheLevelPage')
				 	var data=this.get('responseData');
				 	var msg = data.message;
					var name = data.nome;	
					var error = data.error;
// 					alert(nome +" - "+ msg);
					
					$("#addCommentForm").hide();
					$("#pm-nome").val("");
					$("#pm-email").val("");
					$("#pm-mensagem").val("");
					$("#pm-titulo").val("");
					$("#pm-eixos").val("");
					$('#pm-objectivo').val("");
					$('#pm-problema').val("");
					$('#pm-solucao').val("");
					$('#pm-outras').val("");
					$('#pm-nome').val(Liferay.ThemeDisplay.getUserName());
					
					if(error === false){
						$("#myModalSuggestion").find(".alert-success").fadeIn();
					} else {
						$("#myModalSuggestion").find(".alert-danger").fadeIn();
					}
		 		},
		 	}
		 });
	});
}

</script>


