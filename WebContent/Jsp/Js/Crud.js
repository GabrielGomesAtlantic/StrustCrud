function guardar(){
	with(document.forms[0]){
	    let str = '';
		let arma1 = '';
		let arma2 = '';
		let arma3 = '';
		let arma4 = '';
		acao.value="GRAVAR";
		if(document.getElementById("armasMetralhadora").checked == true){
			arma1 = "Metralhadora ";
			
		}
		if(document.getElementById("armasShotgun").checked == true){
			arma2 = "/ Shotgun ";
		}
		if(document.getElementById("armasPistola").checked == true){
			arma3 = "/ Pistola ";
		}
		if(document.getElementById("armasAWP").checked == true){
			arma4 = "/ AWP"
		}
		armas.value = str.concat(arma1,arma2,arma3,arma4);
		submit();
	}
}

function limpar(){
	with(document.forms[0]){
		acao.value="LIMPAR";
		location.reload();
		submit();
	}
}

function deletar(objeto){
	with(document.forms[0]){
		acao.value="EXCLUIR";
		valor.value = objeto;
		submit();
	}
}

function preencheCampos(objeto){
	with(document.forms[0]){
		acao.value        = "EDITAR";
		for(i=0; objeto >= i; i++){
			if(i == objeto){
				valor.value       = objeto ;
				nickName.value    = document.getElementById("nickname"+objeto).textContent;
				level.value       = document.getElementById("level"+objeto).textContent;
				console.log(level.value)
				sexo.value        = document.getElementById("sexo"+objeto).textContent;
				datCria.value     = document.getElementById("datCria"+objeto).textContent;
				observacoes.value = document.getElementById("observacoes"+objeto).textContent;
				
				
				var arma = document.getElementById("armas"+objeto).textContent;
				
				
				console.log(document.getElementById("armas"+objeto).textContent);
				
				
				if(arma.includes('Metralhadora')){
					document.getElementById("armasMetralhadora").checked = true;
				}
				
				if(arma.includes('Shotgun')){
					document.getElementById("armasShotgun").checked = true;
				}
				
				if(arma.includes('Pistola')){
					document.getElementById("armasPistola").checked = true;
				} 
				
				if(arma.includes('AWP')){
					document.getElementById("armasAWP").checked = true;
				}
				
				arma = '';
				
				document.getElementById('editar').disabled = false;
				document.getElementById('gravar').disabled = true;
			}
		}
	}	
}

function reescrever(){
	with(document.forms[0]){
		let str = '';
		let arma1 = '';
		let arma2 = '';
		let arma3 = '';
		let arma4 = '';
		acao.value  = "EDITAR";
		if(document.getElementById("armasMetralhadora").checked == true){
			arma1 = "Metralhadora ";
			
		}
		if(document.getElementById("armasShotgun").checked == true){
			arma2 = "/ Shotgun ";
		}
		if(document.getElementById("armasPistola").checked == true){
			arma3 = "/ Pistola ";
		}
		if(document.getElementById("armasAWP").checked == true){
			arma4 = "/ AWP"
		}
		armas.value = str.concat(arma1,arma2,arma3,arma4);
		submit();
	}
}