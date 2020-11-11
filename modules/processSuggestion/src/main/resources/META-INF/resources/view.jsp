<%@ include file="/init.jsp" %>
<portlet:defineObjects />

<portlet:resourceURL var="ajaxURL">
</portlet:resourceURL>

<portlet:renderURL var="exampleURL">
	<portlet:param name="mvcRenderCommandName" value="addComment" />
</portlet:renderURL>

<aui:form action="<%=exampleURL %>" id="<portlet:namespace/>fm" name="<portlet:namespace/>fm">
	<aui:button type="submit" name="submit" value="Submeter"/> 
</aui:form>

<hr/>

<aui:form id="<portlet:namespace/>fm" name="<portlet:namespace/>fm" >
	<aui:row>
	
		<div class="alert alert-dismissible alert-success" role="alert" style="display:none;" id="<portlet:namespace/>mensagemValidaMessage1">
		    <button aria-label="Close" class="close" data-dismiss="alert" type="button">
		        <svg aria-hidden="true" class="icon-monospaced lexicon-icon  lexicon-icon-times" >
		            <use xlink:href="/o/opengov-theme/images/close.svg" />
		        </svg>
		        <span class="sr-only">Close</span>
		    </button>
		    <strong class="lead">Enviado</strong> Contato enviado com Sucesso.
		</div>

		
		<aui:input disabled="false" label="Nome" name="Nome" id="nome" placeholder="Nome">
			<aui:validator name="required" />
			<aui:validator name="maxLength">40</aui:validator>
			<aui:validator name="minLength">2</aui:validator>
		</aui:input>
		<div style="display:none;" id="<portlet:namespace/>nomeValidaMessage">
             <p style="color:red;">*Campo Nome não pode ser vazio.</p>
      	</div> 
    
    
		<aui:input disabled="false" label="Email" name="Email" id="email"
 			placeholder="email@email.com"> 
 			<aui:validator name="required" /> 
 			<aui:validator name="email" /> 
 		</aui:input> 
 		<div style="display:none;" id="<portlet:namespace/>emailValidaMessage">
             <p style="color:red;">*Campo Email não pode ser vazio.</p>
      	</div> 
		<div class="form-group">
		    <label>Mensagem</label>
		    <span class="reference-mark text-warning">
        </span>
		    <textarea id="<portlet:namespace/>mensagem" class="form-control" placeholder="Mensagem"></textarea>
		</div>
 		<div style="display:none;" id="<portlet:namespace/>mensagemValidaMessage">
             <p style="color:red;">*Campo Mensagem não pode ser vazio.</p>
      	</div> 
      	
 	</aui:row> 
	<aui:button name="saveButton" type="button" value="Enviar" cssClass="submitLocal"/>
	<aui:button name="saveButton" type="submit" value="Enviar 2" cssClass="submitLocal"/> 
</aui:form>


<script type="text/javascript">

$(document).ready(function() {
	$(".submitLocal").click(function() {
		
		/*var nome=A.one("#<portlet:namespace />nome").get('value');
		var email=A.one("#<portlet:namespace />email").get('value');
		var mensagem=A.one("#<portlet:namespace />mensagem").get('value');*/
		
		var nome=$(this).parent("form").find("#<portlet:namespace/>nome").val();
		var email=$(this).parent("form").find("#<portlet:namespace/>email").val();
		var msg=$(this).parent("form").find("#<portlet:namespace/>mensagem").val();		
		
		var valida = true;
		
		if (nome == ""){
			$('#<portlet:namespace />nomeValidaMessage').show();
			valida = false;
		} else {
			$('#<portlet:namespace />nomeValidaMessage').hide();
		}
		if (email == ""){
			$('#<portlet:namespace />emailValidaMessage').show();
			valida = false;
		} else {
			$('#<portlet:namespace />emailValidaMessage').hide();
		}
		if (msg == ""){
			$('#<portlet:namespace />mensagemValidaMessage').show();
			valida = false;
		} else {
			$('#<portlet:namespace />mensagemValidaMessage').hide();
		}
		if(!valida){
			return;
		}
		
		var data = {};	
		data["nome"]=nome;
		data["email"]=email;
		data["msg"]=msg;
		var dataJson = JSON.stringify(data);
		console.log("Data JSON="+dataJson)
		submitData(dataJson);
		return false;		
	});
});


function submitData(dataJson){
	 
	AUI().use('aui-base','aui-io-request','liferay-form','aui-alert', function(A){
			
		A.io.request('<%=ajaxURL.toString()%>',{ 
			 dataType: 'json',
			 method: 'POST',
			 data: { <portlet:namespace />data: dataJson },
			 on: {
				success: function() {
					
				 	var data=this.get('responseData');
				 	var msg = data.message;
					var name = data.nome;	
					var error = data.error;
					alert(nome +" - "+ msg);
					
					if(error === false){
						A.one('#<portlet:namespace/>nome').set('value', ""); 
						A.one('#<portlet:namespace/>email').set('value', ""); 
						A.one('#<portlet:namespace/>mensagem').set('value', "");
					}
		 		},
		 	}
		 });
	});
}
</script>