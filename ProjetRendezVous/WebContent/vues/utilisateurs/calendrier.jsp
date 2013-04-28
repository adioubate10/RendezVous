<!-- Entete de la page -->
<%@page import="fr.rendezvous.javabeans.Professeur"%>
<%@page import="fr.rendezvous.modeles.ModeleCalendrierDAO"%>
<%@page import="fr.rendezvous.actions.CalendrierAction"%>
<%@page import="fr.rendezvous.actions.GRendezVous"%>
<%@ include file="../outils/entete.jspf" %>
<%@ page import="java.io.*"  %> 
<c:if test="${compte.class=='class fr.rendezvous.javabeans.Professeur'}">
<div><table><tr valign="top">

 <c:if test="${calendrier.class!='class fr.rendezvous.javabeans.Calendrier'}">
					<td style="padding-left:10px" class="lien">
						&nbsp;&nbsp;
							<a href="Ajoutercalendrier.action" title="Creer Calendrier">
						    <img src="images/application/ajouter.gif"/>
							</a>
								&nbsp;&nbsp;&nbsp;&nbsp;	
					   </td>
	</c:if>				   			
					   <td style="padding-left:10px" class="lien">
							<a href="Supprimercalendrier.action" title="Supprimer Calendrier">
						    <img src="images/application/supprimeradmin.png"/>
							</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
					   </td>
					  
					   <td style="padding-left:10px" class="lien">
							<s:form  action="Synchronisercalendrier"  theme="simple">

	               Mail :<select id="sexe" name="professeur.mail"><option value="<c:out value="${compte.mail}"/>"><c:out value="${compte.mail}"/></option>
	    
                          </select>
	                     <colspan="2" align="center"><s:submit type="image" src="images/application/enregistrer.gif"></s:submit>
                            </s:form>

							 &nbsp;&nbsp;&nbsp;&nbsp;
					   </td>
					   
					   <td style="padding-left:10px" class="lien">
							<a href="DeSynchronisercalendrier.action" title="DesynchroniserCalendrier">
						    <img src="images/application/charger.gif"/>
							</a>
					   </td>
					   <td style="padding-left:10px" class="lien">
							<a href="Listercalendrier.action" title="Lister Calendrier">
						    <img src="images/application/charger.gif"/>
							</a>
					   </td>
					   <td style="padding-left:10px" class="lien">
						&nbsp;&nbsp;
							<a href="Ajouterrdv.action" title="CreerRdv">
						    <img src="images/application/ajouter.bmp"/>
							</a>
								&nbsp;&nbsp;&nbsp;&nbsp;	
					   </td>
					   			
					   <td style="padding-left:10px" class="lien">
							<a href="Supprimerdv.action" title="SupprimerRdv">
						    <img src="images/application/supprimer.png"/>
							</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
					   </td>
					  
					   <td style="padding-left:10px" class="lien">
							<a href="Modifierdv.action" title="ModifierRdv">
						    <img src="images/application/more.gif"/>
							</a>
							 &nbsp;&nbsp;&nbsp;&nbsp;
					   </td>
					   <td style="padding-left:10px" class="lien">
							<a href="Listerrdv.action" title="ListerRdv">
						    <img src="images/application/monrdv.png"/>
							</a>
					   </td>
			</tr>
     </table>
   </div>
 
   
 <c:if test="${idgcalendrier!=null}">  

<iframe src="https://www.google.com/calendar/embed?src=<c:out value="${idgcalendrier}"/>%40gmail.com&ctz=Europe/Paris" style="border: 0" width="600" height="400" frameborder="0" scrolling="no"></iframe>
</c:if>
 <c:if test="${calendrier.class=='class fr.rendezvous.javabeans.Calendrier'}">
   
   
 
<iframe src="https://www.google.com/calendar/embed?src=<c:out value="${calendrier.id}"/>%40group.calendar.google.com&ctz=Europe/Paris" style="border: 0" width="600" height="400" frameborder="0" scrolling="no"></iframe>
</c:if>
<c:if test="${idgcalendrier==null}">
<div><blink>Vous avez pas encore synchroniser avec le  calendrier par defaut</blink></div>
</c:if>
</c:if>