function mascara(o, f) {
	v_obj = o;
	v_fun = f;
	setTimeout("execmascara()", 1);
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value);
}

function moeda(v) {
	v = v.replace(/\D/g, "");
	v = v.replace(/[0-9]{15}/, "inv?lido");
	v = v.replace(/(\d{1})(\d{15})$/, "$1.$2"); // coloca ponto antes dos ?ltimos 15 digitos
	v = v.replace(/(\d{1})(\d{11})$/, "$1.$2"); // coloca ponto antes dos ?ltimos 11 digitos
	v = v.replace(/(\d{1})(\d{8})$/, "$1.$2"); // coloca ponto antes dos ?ltimos 8 digitos
	v = v.replace(/(\d{1})(\d{5})$/, "$1.$2"); // coloca ponto antes dos ?ltimos 5 digitos
	v = v.replace(/(\d{1})(\d{1,2})$/, "$1,$2"); // coloca virgula antes dos ?ltimos 2 digitos
	return v;
}