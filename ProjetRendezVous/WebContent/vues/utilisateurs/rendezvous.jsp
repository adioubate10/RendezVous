<!-- Entete de la page -->
<%@page import="fr.rendezvous.javabeans.Professeur"%>
<%@page import="fr.rendezvous.modeles.ModeleCalendrierDAO"%>
<%@page import="fr.rendezvous.actions.CalendrierAction"%>
<%@page import="fr.rendezvous.actions.GRendezVous"%>
<%@ include file="../outils/entete.jspf" %>
<%@ page import="java.io.*"  %> 
<c:if test="${compte.class=='class fr.rendezvous.javabeans.Etudiant'}">
<div><table><tr valign="top">

					   <td style="padding-left:10px" class="lien">
							<a href="Listercalendrier.action" title="Lister Calendrier">
						    <img src="images/application/charger.gif"/>
							</a>
					   </td>
					   <td style="padding-left:10px" class="lien">
						&nbsp;&nbsp;
							<a href="Ajouterdv.action" title="CreerRdv">
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
   </c:if>
  <c:if test="${cprofesseur.class=='class fr.rendezvous.javabeans.Professeur'}">
  <c:if test="${pcalendrier.class=='class fr.rendezvous.javabeans.Calendrier'}"> 
   
 
<iframe src="https://www.google.com/calendar/embed?src=<c:out value="${pcalendrier.id}"/>&ctz=Europe/Paris" style="border: 0" width="600" height="400" frameborder="0" scrolling="no"></iframe>
</c:if>
<c:if test="${calendrier.class!='class fr.rendezvous.javabeans.Calendrier'}">
<div><blink>Le professeur <c:out value="${cprofesseur.nom}"/> n'a pas encore creer de calendrier</blink></div>
</c:if>
</c:if>