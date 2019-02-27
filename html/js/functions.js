var warenkorb = [];
var apple = {id:1, name:"iPhone 8"};
var samsung = {id:2, name:"Samsung Galaxy S9"};
var asus = {id:3, name:"Asus ROG Phone"};
var produkte = [apple, samsung, asus];

function zeigeWarenkorbInhalt() {
	var text;
	var warenkorbInhalt = document.getElementById('warenkorbInhalt');
	warenkorbInhalt.innerHTML = "";
	warenkorb.forEach(function(produkt) {
		text = "<p>" + produkt.name + ": " + document.getElementById(produkt.name).dataset.preis + " €</p>";
		warenkorbInhalt.innerHTML+=text;
	});
	var gesamt = berechneGesamt();
	document.getElementById('gesamt').innerHTML=gesamt;
	document.getElementById('steuer').innerHTML=berechneSteuer(gesamt);
}

function zumWarenkorbHinzufuegen(produktId) {
	warenkorb.push(produkte.find(x => x.id === produktId));
}

function entferneProdukteAusWarenkorb() {
	warenkorb = [];
	zeigeWarenkorbInhalt();
}

function berechneGesamt() {
	var gesamt = 0;
	warenkorb.forEach(function(produkt) {
		gesamt += Number(document.getElementById(produkt.name).dataset.preis);
	});
	return gesamt;
}

function berechneSteuer(preis) {
    return (preis / 100) * 19;
}

function suche() {
	const value = $("#produktSuche").val().toLowerCase();
	$(".card-header").filter(function () {
		$(this).parents(".col-md-6").toggle($(this).text().toLowerCase().indexOf(value) > -1);
	});
}