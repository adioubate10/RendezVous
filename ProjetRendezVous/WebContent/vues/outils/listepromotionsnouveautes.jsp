<%@ page import="java.util.List" %>  
<%@ page import="fr.rendezvous.javabeans.Etudiant" %>  
<%@ page import="fr.rendezvous.modeles.ModeleEtudiantDAO" %>   

<%
/*
// Initialisation du modèle 
ModeleArticleDAO modeleArticleDAO=new ModeleArticleDAO();
// On récupère les promotions et nouveautés 
List<Article> promotions=(List<Article>)modeleArticleDAO.listerArticleEnPromotion(4, 1, "nomarticle", "ASC");
List<Article> nouveautes=(List<Article>)modeleArticleDAO.listerNouveauArticlePaginer(4, 1, "nomarticle", "ASC");
// Mettre les attributs dans la requête pour les afficher
request.setAttribute("promotions",promotions);
request.setAttribute("nouveautes",nouveautes);
*/
%>

<div class="texte">&nbsp;<b>Nos promotions</b></div>
<br/>
<table class="tableauindex" cellspacing="10" style="background: url('<b:config attribut="urlApplication"/>images/application/degrade_tableau.gif') repeat-x;"> 
		<tr>	
			<s:iterator value="#request.promotions" var="article">	
				<td class="ligneimagearticle">
					<a href="<b:config attribut="urlApplication"/>consulter_Article.action?idArticle=<s:property value="#article.idArticle"/>">
						<img src="<b:config attribut="urlApplication"/>images/articles/<s:property value="#article.vignette"/>" height="150px"/>
					</a>
					<br/>
					<b:resumer longueur="3" texte="${article.nom}"/>
					<br/>
					<br/>
					<div class="prixarticle">
						Prix : <b:reduction prix="${article.prix}" pourcentage="${article.reduction}"/> &euro;
						<br/>
						au lieu de <b:prix montant="${article.prix}"/> &euro;
					</div>
				</td>
			</s:iterator>
		</tr>
</table>


<br/>
<div class="texte">&nbsp;<b>Nos nouveaut&eacute;s</b></div>
<br/>
<table class="tableauindex" cellspacing="10" style="background: url('<b:config attribut="urlApplication"/>images/application/degrade_tableau.gif') repeat-x;"> 
		<tr>	
			<s:iterator value="#request.nouveautes" var="article">			
				<td class="ligneimagearticle">
					<a href="<b:config attribut="urlApplication"/>consulter_Article.action?idArticle=<s:property value="#article.idArticle"/>">
						<img src="<b:config attribut="urlApplication"/>images/articles/<s:property value="#article.vignette"/>" height="150px"/>
					</a>
					<br/>
					<b:resumer longueur="3" texte="${article.nom}"/>
					<br/>
					<br/>
					<div class="prixarticle">
						Prix : <b:reduction prix="${article.prix}" pourcentage="${article.reduction}"/> &euro;
					</div>
				</td>
			</s:iterator>
		</tr>
</table>