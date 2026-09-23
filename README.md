# Šypsena

„Šypsena“ – telefonui pritaikyta dantų valymo programėlė lietuvių kalba.

## Funkcijos

- 2 minučių valymo laikmatis;
- signalas kas 30 sekundžių, primenantis pakeisti valymo sritį;
- ryto ir vakaro valymų registravimas;
- pastarųjų 7 dienų istorija;
- mėnesio ataskaita ir įpročio statistika;
- PDF mėnesio ataskaita su statistika ir dienų lentele;
- CSV eksportas į „Excel“ arba „Google Sheets“;
- Android failų bendrinimas per „Capacitor Filesystem“ ir „Share“;
- JSON atsarginės kopijos sukūrimas ir atkūrimas;
- duomenų saugojimas įrenginio naršyklėje;
- diegimas telefone kaip PWA programėlės;
- veikimas be interneto;
- mobiliesiems pritaikytas juodos, baltos ir raudonos spalvų dizainas.

## Paleidimas

PWA funkcijoms reikalingas HTTPS adresas arba vietinis kūrimo serveris. Paprasčiausias vietinis paleidimas:

```bash
python3 -m http.server 8000
```

Tada naršyklėje atidarykite `http://localhost:8000`.

Paskelbus projektą su „GitHub Pages“, programėlę galima naudoti tiesiogiai telefone per jos interneto adresą.

## Įdiegimas telefone

Atidarykite programėlės HTTPS adresą „Chrome“ naršyklėje ir pasirinkite programėlės diegimo pasiūlymą. Įdiegta „Šypsena“ atsidaro atskirame lange ir pagrindinės funkcijos veikia be interneto.

## Duomenų saugojimas

Valymų istorija saugoma naršyklės `localStorage` atmintyje. Išvalius naršyklės duomenis įrašai gali dingti, todėl svarbius duomenis rekomenduojama periodiškai eksportuoti į JSON atsarginę kopiją.

## Privatumas

Ši versija nesiunčia valymų istorijos į serverį. Duomenys lieka tame įrenginyje ir naršyklėje, kurioje naudojama programėlė.

## Technologijos

- HTML5
- CSS3
- JavaScript
- Web App Manifest
- Service Worker
- Capacitor (Android)
- Canvas pagrindu generuojamos PDF ataskaitos

## Autorius

TyliaiTPk
