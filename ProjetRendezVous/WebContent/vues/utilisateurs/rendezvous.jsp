<!-- Entete de la page -->
<%@page import="fr.rendezvous.actions.CalendrierAction"%>
<%@page import="fr.rendezvous.actions.Calendar"%>
<%@ include file="../outils/entete.jspf" %>
<%@ page import="java.io.*"  %> 
<div><table><tr valign="top">
					<td style="padding-left:10px" class="lien">
						&nbsp;&nbsp;
							<a href="CreerRdv.action" title="CreerRdv">
						    <img src="images/application/ajouter.gif"/>
							</a>
								&nbsp;&nbsp;&nbsp;&nbsp;	
					   </td>
					   			
					   <td style="padding-left:10px" class="lien">
							<a href="SupprimerRdv.action" title="SupprimerRdv">
						    <img src="images/application/supprimeradmin.png"/>
							</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
					   </td>
					  
					   <td style="padding-left:10px" class="lien">
							<a href="ModifierRdv.action" title="ModifierRdv">
						    <img src="images/application/modifier.gif"/>
							</a>
							 &nbsp;&nbsp;&nbsp;&nbsp;
					   </td>
					   
					   <td style="padding-left:10px" class="lien">
							<a href="ListerRdv.action" title="ListerRdv">
						    <img src="images/application/charger.gif"/>
							</a>
					   </td>
			</tr>
     </table>
   </div>
  
   <%String id=Calendar.getId(); %>
<iframe src="https://www.google.com/calendar/embed?src=<%=id  %>&ctz=Europe/Paris" style="border: 0" width="800" height="600" frameborder="0" scrolling="no"></iframe>