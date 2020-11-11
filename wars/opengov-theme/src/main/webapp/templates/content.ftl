<section class="container-fluid-1280" id="content">
	
	<img class="floating_ilustration modal-open-button" src="/o/opengov-theme/images/icon-form-new.svg" alt="Abrir caixa de comentários" data-toggle="modal" data-target="#myModal">
	<h1 class="hide-accessible">${the_title}</h1>
	
	<#if selectable>
		<@liferay_util["include"] page=content_include />
	<#else>
		${portletDisplay.recycle()}
		
		${portletDisplay.setTitle(the_title)}
		
		<@liferay_theme["wrap-portlet"] page="portlet.ftl">
			<@liferay_util["include"] page=content_include />
		</@>
	</#if>
	
	<#-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <#-- Modal content-->
	    <div class="modal-content">
	      <div class="main-content main-form" style="background-color: #fff;">
  	
	      	<picture>
	      		<source class="close-modal" media="(min-width: 580px)" srcset="/o/opengov-theme/images/close.svg" style="display: none;">
	      		<img alt="Fechar caixa de propostas"  class="close-modal" src="/o/opengov-theme/images/close-white.svg">
	      	</picture>

	        <div class="modal-body">
	        	<div id="loader" class="my-modal-overlay" style="display: none;">
					<div class="loader"></div>
				</div>
	
	          <div class="main-nav-pills col-sm-4 col-xs-4">
			    <span><@liferay.language key="do-you-have-a-question-suggestion-or-comment" />?</span>
			    <h5 style="color: #fff"><@liferay.language key="contact-us-and-we-will-respond-as-soon-as-possible" />.</h5>
			  </div>
	          <div class="tab-content col-xs-8">
	          
	          		<div class="alert alert-success" role="alert">
					  	<@liferay.language key="comment-sucessully-submitted" />!
					</div>
					
					<div class="alert alert-danger" role="alert">
					  	<@liferay.language key="error-submitting-comment" />!
					</div>
	          
		          <form name="addComment" method="post" id="addCommentForm" data-toggle="validator" role="form">		          
		          
		            <div class="col-sm-10 col-xs-11 col-sm-offset-1" >
		            										
			            <div class="row margin-bottom input-width">
			            	<div class="form-group">
				            	<label for="nome" class="control-label"><@liferay.language key="name" /></label>
				            	<input type="text" maxlength="35" name="name" id="nome" class="form-control" required="required" data-error="<@liferay.language key="required-field" />">
				            	<div class="help-block with-errors"></div>
			            	</div>
			              
			              	<div class="form-group">
			             		<label for="email" class="control-label">E-mail</label>
			            		<input type="email" maxlength="35" name="email" id="email" class="form-control" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" data-error="<@liferay.language key="use-valid-email-address"/>">
			            		<div class="help-block with-errors"></div>
			            	</div>
			            </div>
		
			            <div class="row margin-bottom input-width form-group" style="margin-top: 15px;">
			            	<label for="msg" class="control-label"><@liferay.language key="message" /></label>
			            	<textarea class="form-control" required="required" maxlength="500" id="msg" data-error="<@liferay.language key="required-field" />"></textarea>			            	
			            	<small><@liferay.language key="characters" /><span id="chars">500</span></small>
			            	<div class="help-block with-errors"></div>
			            </div>		            			          
			            
			          	  <div class="captcha-pos" style="height: 70px; width: 100%">
			              	<div class="g-recaptcha"
					          data-sitekey="${captcha}"
					          data-callback="mySubmit"
					          data-size="invisible">
						   	</div>
						   	<div id="recaptcha-error" class="help-block with-errors" style="margin-top: 15px;"></div> 
					   	</div>
					   	
			            <div class="other-submit form-group" >			            				           		
			           		<button type="submit" class="btn btn-primary" ><@liferay.language key="send" /></button>
			           		<input type="submit" style="display: none" name="submitCommentlHidden"/>	            
			            </div>
			            
		            </div>		            
		            
		          </form>
	          
	          </div> <#-- Close tab content -->
	          
	        </div> <#-- close modal-body -->
	        
	      </div> <#-- close main-content main-form -->
	
	    </div> <#-- close modal-content -->
	
	  </div>
	</div>
	
	<#--  Close modal  -->
	
	<div id="myModalSuggestion" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <#-- Modal content-->
	    <div class="modal-content">
	      <div class="main-content main-form" style="background-color: #fff;">
	      	<img alt="Fechar caixa de suggestões" class="close-modal" src="/o/opengov-theme/images/close.svg">
	   	        
	        <div class="modal-body">
	          <div class="tab-suggestion col-xs-12 propose-measure-form" >
	          	           	 	
	          	  <h2><@liferay.language key="propose-your-measure" /></h2>	          	
	          <div class="tab-suggestion col-xs-91">
	          		
	          		<div class="alert alert-success" role="alert" >
					  	<@liferay.language key="measure-sucessully-submitted" />!
					</div>
					
					<div class="alert alert-danger" role="alert">
					  	<@liferay.language key="error-submitting-measure" />!
					</div>
	          
		          <form name="insertContent" id="propose-measure" data-toggle="validator" role="form" method="post">
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
				              	
				              	
				              	<div class="form-group" style="margin-bottom: -15px;">
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
					            		
					            		<div class="help-block with-errors">
					            		</div>
					            	</div>
				            	</div>
				            	
				            	<#--div class="col-xs-6" style="padding-right:0">
				            		<label for="pm-outras"><@liferay.language key="other-entities" /></label>
					            	<input type="text" name="outras" id="pm-outras" placeholder="" />
				            	</div-->
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
				           		<button type="submit" class="btn btn-primary" onclick="proposeMeasureSubmit()"><@liferay.language key="send" /></button>
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
	</div>
	
</section>	