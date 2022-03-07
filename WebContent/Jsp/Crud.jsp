<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html>

<html>
<head>
	<!--<meta charset="ISO-8859-1">-->
	<title>CRUD</title>
	<link rel="stylesheet" type="text/css" href="Jsp/css/crud.css">
	<script type="text/javascript" src="Jsp/Js/crud.js"></script>
</head>
<body>
	<div class="Container">
		<form action="/Crud/Crud.do" method="POST">
			<input type="hidden" name="acao" value=""/>
			<input type="hidden" name="id" value=""/>
			CADASTRE SEU PERSONAGEM<br><br>
			<label>Nickname: </label>
			<input type="text" name="nickName" id="nickName" OnKeyPress="mascaraNome(event);" size="70" maxlength="60" placeholder=" Insira seu nick! "/><br><br>
			<label>Level: </label>
			<select name="level">
				<logic:iterate id="objeto" scope="request" name="listaLevel">
					  <option value="${objeto}">${objeto}</option>
				</logic:iterate>
			</select>
			<br><br>
			<label>Sexo: </label>
			<input type="radio" name="sexo" value="M"/>Masculino
			<input type="radio" name="sexo" value="F"/>Feminino
			<input type="radio" name="sexo" value="O"/>Outro
			<br><br>
			<label>Data de criação da conta: </label>
			<input type="text" id="data" class="" name="datCria" size="10" maxlength="10" OnKeyDown="mascaraData();" placeholder=" DD/MM/YYYY "/>
			<br><br>
			
			
			<label>Arma mais usada</label><br>
			<input type="hidden" name="armas" value=""/>
			<input type="Checkbox" id="armasMetralhadora" value="Metralhadora" />Metralhadora<br>
			<input type="Checkbox" id="armasShotgun" value="Shotgun"           />Shotgun<br>
			<input type="Checkbox" id="armasPistola" value="Pistola"           />Pistola<br>
			<input type="Checkbox" id="armasAWP" value="AWP"                   />AWP<br><br>
			
			
			<label>Observações: </label><br>
			<textarea name="observacoes" max-size="70" maxlength="280" placeholder=" Insira sua observacao! "></textarea><br><br>
			<input type="submit" id="gravar" value="Gravar"  onclick="guardar();">
			<input type="submit" value="Limpar"  onclick="limpar();">
			<input type="button" id="editar" value="Editar"  onclick="formatar();" disabled>
		</form><br><br> 
		<label>USUARIOS CADASTRADOS</label><br>
		<table>
			<thead>
                <tr>
                	<td class="tituloTabela">Excluir Cadastro</td>
                    <td class="tituloTabela">Nickname</td>
                    <td class="tituloTabela">Level</td>
                    <td class="tituloTabela">Sexo</td>
                    <td class="tituloTabela">Data de Criação da Conta</td>
                    <td class="tituloTabela">Arma Mais Usada</td>
                    <td class="tituloTabela">Observações</td>
                </tr>
            </thead>
            <tbody>
            	<logic:iterate id="objeto" scope="request" name="listaPersonagens">
            	<tr >
            		<td class="registrosTabela"><button id="excluir" name="excluir" value="Excluir" onclick="deletar(${objeto.id});">Excluir</button><button id="excluir" name="editar" value="Excluir" onclick="preencheCampos(${objeto.id});">Editar</button></td>
            		<td class="registrosTabela" id="nickname${objeto.id}" cursor="pointer">${objeto.nickName}</td>
                    <td class="registrosTabela" id="level${objeto.id}"    cursor="pointer">${objeto.level}</td>
					<td class="registrosTabela" id="sexo${objeto.id}"     cursor="pointer">${objeto.sexo}</td>
                    <td class="registrosTabela" id="datCria${objeto.id}"  cursor="pointer">${objeto.datCria}</td>
                    <td class="registrosTabela" id="armas${objeto.id}"    cursor="pointer">${objeto.armas}</td>
                    <td class="registrosTabela" id="observacoes${objeto.id}" cursor="pointer">${objeto.observacoes}</td>
            	</tr>
            	</logic:iterate>	
            </tbody>
		</table>
	</div>
</body>
</html>